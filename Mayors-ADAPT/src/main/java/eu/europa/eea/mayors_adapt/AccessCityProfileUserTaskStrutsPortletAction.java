package eu.europa.eea.mayors_adapt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.model.WorkflowInstanceLink;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class AccessCityProfileUserTaskStrutsPortletAction extends
		BaseStrutsAction {
	private static Log _log = LogFactoryUtil
			.getLog(AccessCityProfileUserTaskStrutsPortletAction.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.getSession().invalidate();

		List<String> actions = Arrays.asList(new String[] { "editForm",
				"finishTask" });
		String token = ParamUtil.get(request, "token", "0");
		long groupId = ParamUtil.getLong(request, "groupId", 18L);
		long companyId = ParamUtil.getLong(request, "companyId", 1L);
		long userId = ParamUtil.getLong(request, "userId", UserLocalServiceUtil
				.getUserByScreenName(companyId, "cityprofilecontact")
				.getUserId());
		long refererPlid = ParamUtil.getLong(request, "referrerPlid", 14150L);
		String version = ParamUtil.get(request, "version", "1.0");
		if (version.equals("0.0"))
			version = "1.0";
		String action = ParamUtil.get(request, "action", "editTask");

		String login = "cityprofilecontact";
		User user = UserLocalServiceUtil.getUserByScreenName(companyId, login);
		HttpSession session = request.getSession();
		session.setAttribute("j_username", String.valueOf(user.getUserId()));
		session.setAttribute("j_password", user.getPassword());
		session.setAttribute("j_remoteuser", String.valueOf(user.getUserId()));

		JournalArticle article = JournalArticleLocalServiceUtil
				.getJournalArticleByUuidAndGroupId(token, groupId);

		String articleId = article.getArticleId();
		WorkflowInstanceLink workflowInstanceLink = WorkflowInstanceLinkLocalServiceUtil
				.getWorkflowInstanceLink(article.getCompanyId(),
						article.getGroupId(), JournalArticle.class.getName(),
						article.getId());
		WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil
				.getWorkflowInstance(article.getCompanyId(),
						workflowInstanceLink.getWorkflowInstanceId());
		_log.info("Gathering tasks for workflowInstance: "
				+ workflowInstanceLink.getWorkflowInstanceId() + " user:"
				+ userId + " companyId:" + companyId);
		List<WorkflowTask> tasks = WorkflowTaskManagerUtil
				.getWorkflowTasksByWorkflowInstance(companyId, userId,
						workflowInstanceLink.getWorkflowInstanceId(), false, 0,
						1, null);
		long workflowTaskId = 0;

		for (WorkflowTask task : tasks) {
			_log.info("Task Found id: " + task.getWorkflowTaskId() + " "
					+ task.getName());
			workflowTaskId = task.getWorkflowTaskId();
		}


		LiferayPortletURL factoryFormURL = PortletURLFactoryUtil.create(
				request, "Mayors-ADAPT-portlet", 10137L,
				PortletRequest.RENDER_PHASE);
		factoryFormURL.setWindowState(LiferayWindowState.POP_UP);
		factoryFormURL.setPortletMode(PortletMode.VIEW);
		factoryFormURL.setDoAsGroupId(groupId);
		// factoryFormURL.setEncrypt(true);
		// factoryFormURL.setParameter("articleId", articleId);
		factoryFormURL.setParameter("token", token);
		// factoryFormURL.addParameterIncludedInPath("articleId");
		factoryFormURL.setParameter("workflowInstanceId",
				String.valueOf(workflowInstanceLink.getWorkflowInstanceId()));

		String pageurl = "/city-profile-form?token=" + article.getUuid();

		LiferayPortletURL factoryFinishURL = PortletURLFactoryUtil.create(
				request, "151", 14150L, PortletRequest.ACTION_PHASE);
		factoryFinishURL.setWindowState(LiferayWindowState.POP_UP);
		factoryFinishURL.setPortletMode(PortletMode.VIEW);
		factoryFinishURL.setParameter("articleId", articleId);
		factoryFinishURL.setParameter("workflowInstanceId",
				String.valueOf(workflowInstanceLink.getWorkflowInstanceId()));
		factoryFinishURL.setParameter("workflowTaskId",
				String.valueOf(workflowTaskId));
		factoryFinishURL.setParameter("cmd", "save");
		factoryFinishURL.setParameter("assigneeUserId", String.valueOf(2));
		factoryFinishURL.setParameter("transitionName", "Finish");
		factoryFinishURL.setParameter("struts_action",
				"/workflow_definitions/edit_workflow_instance_task");
		factoryFinishURL.setParameter("redirect",
				HttpUtil.encodeURL("http://google.com"));

		String finishURL = "http://local-climate-adapt.eea.europa.eu/group/control_panel/manage"
				// + "?p_auth=eVXkiYB3"
				+ "&p_p_id=151"
				+ "&p_p_lifecycle=1"
				+ "&p_p_state=pop_up"
				+ "&p_p_mode=view"
				+ "&refererPlid=14150"
				+ "&_151_cmd=save"
				+ "&_151_assigneeUserId=2"
				+ "&_151_workflowTaskId="
				+ workflowTaskId
				+ "&_151_redirect=http%3A%2F%2Flocal-climate-adapt.eea.europa.eu%2Fgroup%2Fcontrol_panel%2Fmanage%3Fp_p_id%3D151%26p_p_lifecycle%3D0%26p_p_state%3Dmaximized%26p_p_mode%3Dview%26refererPlid%3D14150"
				+ "%26_151_workflowInstanceId%3D"
				+ workflowInstance.getWorkflowInstanceId()
				+ "%26_151_redirect%3Dhttp%253A%252F%252Flocal-climate-adapt.eea.europa.eu%252Fgroup%252Fcontrol_panel%252Fmanage%253Fp_p_id%253D151%2526p_p_lifecycle%253D0%2526p_p_state%253Dmaximized%2526p_p_mode%253Dview%2526refererPlid%253D14150%2526_151_tabs1%253Dsubmissions%26_151_struts_action%3D%252Fworkflow_definitions%252Fedit_workflow_instance"
				+ "&_151_struts_action=%2Fworkflow_definitions%2Fedit_workflow_instance_task"
				+ "&_151_transitionName=finish";

		LiferayPortletURL factoryTaskURL = PortletURLFactoryUtil.create(
				request, PortletKeys.CONTROL_PANEL_MENU, 14150L,
				PortletRequest.RENDER_PHASE);
		factoryTaskURL.setWindowState(LiferayWindowState.MAXIMIZED);
		factoryTaskURL.setPortletMode(PortletMode.VIEW);
		factoryTaskURL.setParameter("workflowInstanceId",
				String.valueOf(workflowInstanceLink.getWorkflowInstanceId()));
		factoryTaskURL.setParameter("struts_action",
				"/workflow_definitions/edit_workflow_instance");
		factoryTaskURL
				.setParameter(
						"redirect",
						HttpUtil.encodeURL(
								"http://local-climate-adapt.eea.europa.eu/group/control_panel/manage?p_p_id=151"
										+ "&p_p_lifecycle=0"
										+ "&p_p_state=maximized"
										+ "&p_p_mode=view"
										+ "&refererPlid=14150"
										+ "&_151_tabs1=submissions", false));


		_log.info("workflowTaskId: " + workflowTaskId);
		_log.info("articleId: " + articleId);
		_log.info("taskId: " + workflowTaskId);
		_log.info("factoryFormURL: " + factoryFormURL);
		_log.info("factoryTaskURL: " + factoryTaskURL);
		_log.info("factoryFinishURL: " + factoryFinishURL);
		_log.info("finishURL: " + finishURL);

		switch (actions.indexOf(action)) {
		case 0:
			response.sendRedirect(pageurl.toString());
			break;
		case 1:
			_log.info("Finishing Task for : groupId:"
					+ workflowInstanceLink.getGroupId() + " user:"
					+ workflowInstanceLink.getUserId() + " task:"
					+ workflowTaskId);
			WorkflowTaskManagerUtil.completeWorkflowTask(
					workflowInstanceLink.getGroupId(),
					workflowInstanceLink.getUserId(), workflowTaskId, "Finish",
					null, workflowInstance.getWorkflowContext());
			response.sendRedirect("/mayors-adapt/thanks");
			break;
//		case 2:
//			response.sendRedirect(factoryTaskURL.toString());
//			break;
		}
		return null;
	}
}