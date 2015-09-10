package eu.europa.eea.mayors_adapt;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.model.WorkflowInstanceLink;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class AccessCityProfileUserTaskStrutsPortletAction extends
		BaseStrutsAction {
	private static Log _log = LogFactoryUtil
			.getLog(AccessCityProfileUserTaskStrutsPortletAction.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		long companyId = PortalUtil.getDefaultCompanyId();
		long groupId = GroupLocalServiceUtil.getGroup(companyId, "Guest").getGroupId();

		String login = "cityprofilecontact";

		User user = UserLocalServiceUtil.getUserByScreenName(companyId,
				login);

		String token = ParamUtil.get(request, "token", "0");

//		_log.info("Task before");
//		showTask(token, user,  groupId);


		HttpSession session = request.getSession();
		session.setAttribute("j_username", String.valueOf(user.getUserId()));
		session.setAttribute("j_password", user.getPassword());
		session.setAttribute("j_remoteuser", String.valueOf(user.getUserId()));

		_log.info("Task after");
		showTask(token, user, groupId);

		String pageurl = "/city-profile-form?token=" + token;
//		RequestDispatcher d=request.getRequestDispatcher(pageurl);
//		d.forward(request, response);
		response.sendRedirect(pageurl.toString());
		return null;
	}

	private void showTask(String token, User user, long groupId) throws Exception {
		JournalArticle article = JournalArticleLocalServiceUtil
				.getJournalArticleByUuidAndGroupId(token, groupId);

		WorkflowInstanceLink workflowInstanceLink = WorkflowInstanceLinkLocalServiceUtil
				.getWorkflowInstanceLink(article.getCompanyId(),
						article.getGroupId(), JournalArticle.class.getName(),
						article.getId());

		WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil
				.getWorkflowInstance(article.getCompanyId(),
						workflowInstanceLink.getWorkflowInstanceId());

		_log.info("Gathering tasks for workflowInstance: "
				+ workflowInstanceLink.getWorkflowInstanceId() + " user:"
				+ user.getUserId() + " companyId:" + workflowInstanceLink.getCompanyId());

		List<WorkflowTask> tasks = WorkflowTaskManagerUtil
				.getWorkflowTasksByWorkflowInstance(
						workflowInstanceLink.getCompanyId(), groupId,
						workflowInstanceLink.getWorkflowInstanceId(), false, 0,
						1, null);
		long workflowTaskId = 0;

		_log.info("Tasks found: " + tasks.size());

		for (WorkflowTask task : tasks) {
			_log.info("Task Found id: " + task.getWorkflowTaskId() + " "
					+ task.getName());
			workflowTaskId = task.getWorkflowTaskId();
		}
	}
}