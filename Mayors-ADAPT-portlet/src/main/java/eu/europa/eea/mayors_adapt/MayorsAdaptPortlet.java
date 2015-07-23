package eu.europa.eea.mayors_adapt;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.model.WorkflowInstanceLink;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class MayorsAdaptPortlet extends LiferayPortlet {

	String uuid = null;

	public void init() {
		viewTemplate = getInitParameter("view-template");
	}

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		_log.info("View of managing page for token: " + uuid);
		include(viewTemplate, renderRequest, renderResponse);

	}

	protected void include(String path, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	

	public void finishTask(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		if (ParamUtil.getString(actionRequest, "token") != null)
			uuid = ParamUtil.getString(actionRequest, "token");
		long groupId = ParamUtil.getLong(actionRequest, "groupId");
		long companyId = ParamUtil.getLong(actionRequest, "companyId");
		String pageurl = "";
		_log.info("Finishing Task for item: " + uuid);
		try {
			long userId = UserLocalServiceUtil.getUserByScreenName(companyId,
					"cityprofilecontact").getUserId();
			JournalArticle article = JournalArticleLocalServiceUtil
					.getJournalArticleByUuidAndGroupId(uuid, groupId);

			pageurl = "/c/portal/accessCityProfileUserTask?token="
					+ article.getUuid();

			WorkflowInstanceLink workflowInstanceLink = WorkflowInstanceLinkLocalServiceUtil
					.getWorkflowInstanceLink(article.getCompanyId(),
							article.getGroupId(),
							JournalArticle.class.getName(), article.getId());

			WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil
					.getWorkflowInstance(article.getCompanyId(),
							workflowInstanceLink.getWorkflowInstanceId());

			_log.info("Gathering tasks for workflowInstance: "
					+ workflowInstanceLink.getWorkflowInstanceId() + " user:"
					+ userId + " companyId:"
					+ workflowInstanceLink.getCompanyId());

			List<WorkflowTask> tasks = WorkflowTaskManagerUtil
					.getWorkflowTasksByWorkflowInstance(
							workflowInstanceLink.getCompanyId(), userId,
							workflowInstanceLink.getWorkflowInstanceId(),
							false, 0, 1, null);
			long workflowTaskId = 0;

			_log.info("Tasks found: " + tasks.size());

			for (WorkflowTask task : tasks) {
				_log.info("Task Found id: " + task.getWorkflowTaskId() + " "
						+ task.getName());
				workflowTaskId = task.getWorkflowTaskId();
			}
			if (workflowTaskId == 0)
				_log.error("No task found for user to finish");

			WorkflowTaskManagerUtil.completeWorkflowTask(
					workflowInstanceLink.getGroupId(),
					workflowInstanceLink.getUserId(), workflowTaskId, "Finish",
					null, workflowInstance.getWorkflowContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		actionResponse.sendRedirect(pageurl.toString());

	}

	protected String viewTemplate;

	private static Log _log = LogFactoryUtil.getLog(MayorsAdaptPortlet.class);

}
