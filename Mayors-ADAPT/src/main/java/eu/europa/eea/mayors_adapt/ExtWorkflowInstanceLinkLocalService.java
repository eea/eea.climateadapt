package eu.europa.eea.mayors_adapt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowThreadLocal;
import com.liferay.portal.model.User;
import com.liferay.portal.model.WorkflowDefinitionLink;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.service.WorkflowInstanceLinkLocalService;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceWrapper;
import com.liferay.portal.service.persistence.WorkflowDefinitionLinkUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinition;
import com.liferay.portal.workflow.kaleo.model.KaleoInstance;
import com.liferay.portal.workflow.kaleo.model.KaleoNotification;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignmentInstance;
import com.liferay.portal.workflow.kaleo.service.KaleoDefinitionLocalServiceClp;
import com.liferay.portal.workflow.kaleo.service.KaleoDefinitionLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoDefinitionLocalServiceWrapper;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoNodeLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoNotificationLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoDefinitionPersistence;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoDefinitionUtil;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskAssignmentInstanceUtil;
import com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskUtil;

public class ExtWorkflowInstanceLinkLocalService extends
		WorkflowInstanceLinkLocalServiceWrapper {
	public ExtWorkflowInstanceLinkLocalService(
			WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService) {
		super(workflowInstanceLinkLocalService);
	}

	@Override
	public void startWorkflowInstance(long companyId, long groupId,
			long userId, String className, long classPK,
			Map<String, Serializable> workflowContext) throws PortalException,
			SystemException {
		ServiceContext serviceContext = (ServiceContext) workflowContext
				.get("serviceContext");
		if (!WorkflowThreadLocal.isEnabled()) {
			return;
		}
		if (userId == 0) {
			userId = UserLocalServiceUtil.getDefaultUserId(companyId);
		}

		WorkflowHandler workflowHandler = WorkflowHandlerRegistryUtil
				.getWorkflowHandler(className);

		WorkflowDefinitionLink workflowDefinitionLink = null;

		String workflowDefinitionName = null;
		int workflowDefinitionVersion = 0;

		String structureName = serviceContext.getAttribute("structureName")
				.toString();

		if (structureName.equalsIgnoreCase("City Profile")) {
			String contactEmail = null;
			String contactNameSurname = null;
			String cityName = null;
			String serverURL = null;
			Map<String, Serializable> serviceContextMap = serviceContext
					.getAttributes();
			for (String key : workflowContext.keySet())
				_log.info("WorkflowContext: " + key + "->"
						+ workflowContext.get(key));
			for (String key : serviceContextMap.keySet()) {
				workflowContext.put(key, serviceContextMap.get(key));
				if (key.startsWith("contactEmail"))
					contactEmail = ((String) serviceContextMap.get(key));
				if (key.startsWith("contactNameSurname"))
					contactNameSurname = ((String) serviceContextMap.get(key));
				if (key.startsWith("title"))
					cityName = ((String) serviceContextMap.get(key));
				if (key.startsWith("redirect"))
					serverURL = ((String) serviceContextMap.get(key)).split("\\/group")[0];
				_log.info("ServiceContext: " + key + "->"
						+ serviceContextMap.get(key));
			}
			workflowDefinitionName = structureName + " Approval";
			KaleoDefinition kaleoDefinition = KaleoDefinitionLocalServiceUtil
					.getLatestKaleoDefinition(workflowDefinitionName,
							serviceContext);
			workflowDefinitionName = kaleoDefinition.getName();
			workflowDefinitionVersion = kaleoDefinition.getVersion();
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
					"no-reply@climate-adapt.eea.europa.eu");
				workflowContext.put(
					WorkflowConstants.CONTEXT_NOTIFICATION_SENDER_NAME,
					"Mayors-ADAPT Site Administrator");

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

		_log.info("Workflow instance started: "
				+ workflowInstance);

		addWorkflowInstanceLink(userId, companyId, groupId, className, classPK,
				workflowInstance.getWorkflowInstanceId());
	}

	private static Log _log = LogFactoryUtil
			.getLog(ExtWorkflowInstanceLinkLocalService.class);
}