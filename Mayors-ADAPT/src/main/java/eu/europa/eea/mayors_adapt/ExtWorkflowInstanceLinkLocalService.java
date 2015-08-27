package eu.europa.eea.mayors_adapt;

import java.io.Serializable;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowThreadLocal;
import com.liferay.portal.model.WorkflowDefinitionLink;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WorkflowInstanceLinkLocalService;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceWrapper;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinition;
import com.liferay.portal.workflow.kaleo.service.KaleoDefinitionLocalServiceUtil;

public class ExtWorkflowInstanceLinkLocalService extends
		WorkflowInstanceLinkLocalServiceWrapper {
	public ExtWorkflowInstanceLinkLocalService(
			WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService) {
		super(workflowInstanceLinkLocalService);
	}

	static WorkflowDefinitionLink workflowDefinitionLink = null;
	static String workflowDefinitionName = null;
	static int workflowDefinitionVersion = 0;
	static ServiceContext serviceContext = null;
	static String structureName = null;
	static Map<String, Serializable> workflowContext;
	static long userId;

	@Override
	public void startWorkflowInstance(long companyId, long groupId,
			long userId, String className, long classPK,
			Map<String, Serializable> workflowContext) throws PortalException,
			SystemException {
		ExtWorkflowInstanceLinkLocalService.workflowContext = workflowContext;
		ExtWorkflowInstanceLinkLocalService.userId = userId;

		if (!WorkflowThreadLocal.isEnabled()) {
			return;
		}
		if (userId == 0) {
			userId = UserLocalServiceUtil.getDefaultUserId(companyId);
		}

		WorkflowHandler workflowHandler = WorkflowHandlerRegistryUtil
				.getWorkflowHandler(className);

		serviceContext = (ServiceContext) workflowContext.get("serviceContext");
		structureName = serviceContext.getAttribute("structureName").toString();

		if (structureName.equalsIgnoreCase("City Profile")) {
			processCityProfile();
		} else {
			workflowDefinitionLink = workflowHandler.getWorkflowDefinitionLink(
					companyId, groupId, classPK);
			workflowDefinitionName = workflowDefinitionLink
					.getWorkflowDefinitionName();
			workflowDefinitionVersion = workflowDefinitionLink
					.getWorkflowDefinitionVersion();

		}
		_log.info("Workflow definition selected -> Name: "
				+ workflowDefinitionName + ", Version:"
				+ workflowDefinitionVersion);

		workflowContext.put(WorkflowConstants.CONTEXT_COMPANY_ID,
				String.valueOf(companyId));
		workflowContext.put(WorkflowConstants.CONTEXT_GROUP_ID,
				String.valueOf(groupId));
		workflowContext.put(WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME,
				className);
		workflowContext.put(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK,
				String.valueOf(classPK));
		workflowContext.put(WorkflowConstants.CONTEXT_ENTRY_TYPE,
				workflowHandler.getType(LocaleUtil.getDefault()));

		WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil
				.startWorkflowInstance(companyId, groupId, userId,
						workflowDefinitionName, workflowDefinitionVersion,
						null, workflowContext);

		_log.info("Workflow instance started: " + workflowInstance);

		addWorkflowInstanceLink(userId, companyId, groupId, className, classPK,
				workflowInstance.getWorkflowInstanceId());
	}

	private void processCityProfile() {
		String contactEmail = null;
		String contactNameSurname = null;
		String cityName = null;
		String serverURL = null;
		_log.info("Submitting a City Profile for publication: ");
		Map<String, Serializable> serviceContextMap = serviceContext
				.getAttributes();
		for (String key : serviceContextMap.keySet()) {
			workflowContext.put(key, serviceContextMap.get(key));
			if (key.contains("email_of_contact_person"))
				contactEmail = ((String) serviceContextMap.get(key));
			if (key.contains("name_surname_of_contact_person"))
				contactNameSurname = ((String) serviceContextMap.get(key));
			if (key.startsWith("title"))
				cityName = ((String) serviceContextMap.get(key));
			if (key.startsWith("redirect"))
				serverURL = ((String) serviceContextMap.get(key))
						.split("\\/group")[0];
			_log.info("ServiceContext: " + key + "->"
					+ serviceContextMap.get(key));
		}
		serverURL = "http://"+serviceContext.getRequest().getServerName();
		if (contactNameSurname == null || contactNameSurname.length()==0)
			contactNameSurname = "City Profile Contact";
		workflowDefinitionName = structureName + " Approval";
		KaleoDefinition kaleoDefinition = null;
		_log.info("Looking for workflow definition: " + workflowDefinitionName);
		try {
			kaleoDefinition = KaleoDefinitionLocalServiceUtil
					.getLatestKaleoDefinition(workflowDefinitionName,
							serviceContext);
			workflowDefinitionName = kaleoDefinition.getName();
			workflowDefinitionVersion = kaleoDefinition.getVersion();
			_log.info("Using workflow definition: "
					+ kaleoDefinition.getName()+" version "+kaleoDefinition.getVersion());
			workflowContext.put("CITY_PROFILE_CITY_NAME", cityName);
			workflowContext.put("CITY_PROFILE_CITY_NAME_LOWERCASE",
					cityName.toLowerCase());
			workflowContext.put("CITY_PROFILE_CONTACT_NAME_SURNAME",
					contactNameSurname);
			workflowContext.put("CITY_PROFILE_CONTACT_EMAIL_ADDRESS",
					contactEmail);
			workflowContext.put("CITY_PROFILE_OWNER", userId);
			workflowContext.put("CITY_PROFILE_SERVER_URL", serverURL);
			workflowContext.put(
					WorkflowConstants.CONTEXT_NOTIFICATION_SENDER_ADDRESS,
					"helpdesk@mayors-adapt.eu");
			workflowContext.put(
					WorkflowConstants.CONTEXT_NOTIFICATION_SENDER_NAME,
					"Mayors-ADAPT Site Administrator");
			for (String key : workflowContext.keySet())
				_log.info("WorkflowContext: " + key + "->"
						+ workflowContext.get(key));
		} catch (Exception e) {
			_log.error("Workflow not found: " + workflowDefinitionName);
		}
	}

	private static Log _log = LogFactoryUtil
			.getLog(ExtWorkflowInstanceLinkLocalService.class);
}