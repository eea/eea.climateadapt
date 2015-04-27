package eu.europa.eea.mayors_adapt;

import java.util.List;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
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
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class AccessCityProfileUserTaskStrutsPortletAction extends
		BaseStrutsAction {
	private static Log _log = LogFactoryUtil
			.getLog(AccessCityProfileUserTaskStrutsPortletAction.class);
 
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String entryClassPK = ParamUtil.get(request, "entryClassPK", "0");
		String entryClassName = ParamUtil.get(request, "entryClassName",
				"com.liferay.portlet.journal.model.JournalArticle");
		long groupId = ParamUtil.getLong(request, "groupId", 18L);
		long companyId = ParamUtil.getLong(request, "companyId", 1L);
		long refererPlid = ParamUtil.getLong(request, "referrerPlid", 14150L);
		String action = ParamUtil.get(request, "action", "editTask");
		User user = UserLocalServiceUtil.getUserByScreenName(companyId,
				"cityprofilecontact");
		_log.info("User: " + user.getScreenName());
		String articleId = JournalArticleLocalServiceUtil.getArticle(
				Long.parseLong(entryClassPK)).getArticleId();
		WorkflowInstanceLink workflowInstanceLink = WorkflowInstanceLinkLocalServiceUtil
				.getWorkflowInstanceLink(companyId, groupId, entryClassName,
						Long.parseLong(entryClassPK));
		WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil
				.getWorkflowInstance(companyId,
						workflowInstanceLink.getWorkflowInstanceId());
		_log.info("Gathering task for workflowInstanceLink: "
				+ workflowInstanceLink.getWorkflowInstanceId() + " user:"
				+ user.getUserId() + " companyId:" + companyId);
		List<WorkflowTask> tasks = WorkflowTaskManagerUtil
				.getWorkflowTasksByWorkflowInstance(companyId,
						user.getUserId(),
						workflowInstanceLink.getWorkflowInstanceId(), false, 0,
						1, null);
		long workflowTaskId = 0;

		for (WorkflowTask task : tasks) {
			_log.info("Task id: " + task.getWorkflowTaskId() + " "
					+ task.getName());
			workflowTaskId = task.getWorkflowTaskId();
		}

		String pid = "151";

		LiferayPortletURL taskURL = PortletURLFactoryUtil.create(request, pid,
				refererPlid, "0");
		taskURL.setWindowState(WindowState.NORMAL);
		taskURL.setPortletMode(PortletMode.VIEW);
		taskURL.setParameter("workflowInstanceId",
				String.valueOf(workflowInstanceLink.getWorkflowInstanceId()));
		taskURL.setParameter("redirect",
				HttpUtil.encodeURL("http://google.com"));

		String taskURL2 = "http://local-climate-adapt.eea.europa.eu/group/control_panel/manage"
				+ "?p_p_id=151"
				+ "&p_p_lifecycle=0"
				+ "&p_p_state=pop_up"
				+ "&p_p_mode=view"
				+ "&refererPlid=14150"
				+ "&_151_workflowInstanceId="
				+ workflowInstanceLink.getWorkflowInstanceId()
				+ "&_151_redirect=http%3A%2F%2Flocal-climate-adapt.eea.europa.eu%2Fgroup%2Fcontrol_panel%2Fmanage%3Fp_p_id%3D151%26p_p_lifecycle%3D0%26p_p_state%3Dmaximized%26p_p_mode%3Dview%26refererPlid%3D14150%26_151_tabs1%3Dsubmissions&_151_struts_action=%2Fworkflow_definitions%2Fedit_workflow_instance";

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
		finishURL = "http://google.com";
		String formURL = HttpUtil
				.decodeURL("http%3A%2F%2Flocal-climate-adapt.eea.europa.eu%2Fgroup%2Fcontrol_panel%2Fmanage%3Fp_p_auth%3DLQg4QvMr%26p_p_id%3D15%26p_p_lifecycle%3D0%26p_p_state%3Dpop_up%26p_p_mode%3Dview%26doAsGroupId%3D18%26refererPlid%3D10137%26_15_struts_action%3D%252Fjournal%252Fedit_article%26_15_groupId%3D18"
						+ "%26_15_articleId%3D"
						+ articleId
						+ "%26_15_version%3D1.0%26_15_redirect%3Dhttp%253A%252F%252Flocal-climate-adapt.eea.europa.eu%252Fgroup%252Fcontrol_panel%252Fmanage%253Fp_p_id%253D151%2526p_p_lifecycle%253D0%2526p_p_state%253Dpop_up%2526p_p_mode%253Dview%2526refererPlid%253D14150%2526_151_struts_action%253D%25252Fworkflow_definitions%25252Fadd_asset_redirect%2526%26_15_originalRedirect%3Dhttp%253A%252F%252Flocal-climate-adapt.eea.europa.eu%252Fgroup%252Fcontrol_panel%252Fmanage%253Fp_p_id%253D151%2526p_p_lifecycle%253D0%2526p_p_state%253Dpop_up%2526p_p_mode%253Dview%2526refererPlid%253D14150%2526_151_struts_action%253D%25252Fworkflow_definitions%25252Fadd_asset_redirect%2526_151_redirect%253Dhttp%25253A%25252F%25252Flocal-climate-adapt.eea.europa.eu%25252Fgroup%25252Fcontrol_panel%25252Fmanage%25253Fp_p_id%25253D151%252526p_p_lifecycle%25253D0%252526p_p_state%25253Dmaximized%252526p_p_mode%25253Dview%252526refererPlid%25253D14150%252526_151_assetEntryVersionId%25253D11269538%252526_151_showEditURL%25253Dtrue%252526_151_workflowAssetPreview%25253Dtrue%252526_151_redirect%25253Dhttp%2525253A%2525252F%2525252Flocal-climate-adapt.eea.europa.eu%2525252Fgroup%2525252Fcontrol_panel%2525252Fmanage%2525253Fp_p_id%2525253D151%25252526p_p_lifecycle%2525253D0%25252526p_p_state%2525253Dmaximized%25252526p_p_mode%2525253Dview%25252526refererPlid%2525253D14150"
						+ "%25252526_151_workflowInstanceId%2525253D"
						+ workflowInstance.getWorkflowInstanceId()
						+ "%25252526_151_redirect%2525253Dhttp%252525253A%252525252F%252525252Flocal-climate-adapt.eea.europa.eu%252525252Fgroup%252525252Fcontrol_panel%252525252Fmanage%252525253Fp_p_id%252525253D151%2525252526p_p_lifecycle%252525253D0%2525252526p_p_state%252525253Dmaximized%2525252526p_p_mode%252525253Dview%2525252526refererPlid%252525253D14150%2525252526_151_tabs1%252525253Dsubmissions%25252526_151_struts_action%2525253D%252525252Fworkflow_definitions%252525252Fedit_workflow_instance%252526_151_struts_action%25253D%2525252Fworkflow_definitions%2525252Fview_content%252526_151_type%25253Dcontent%252526_151_assetEntryId%25253D11269542%26_15_referringPortletResource%3D151");

		_log.info("recordId: " + entryClassPK);
		_log.info("articleId: " + articleId);
		_log.info("taskId: " + workflowTaskId);
		_log.info("URLFactory: " + taskURL);
		_log.info("URLFija: " + taskURL2);
		// _log.info("articleId: "+JournalArticleLocalServiceUtil.getLatestArticle(Long.parseLong(entryClassPK)).getArticleId());

		String borrar = "http://local-climate-adapt.eea.europa.eu/group/control_panel/manage?p_auth=6Jck9tQV&p_p_id=151&p_p_lifecycle=1&p_p_state=pop_up&p_p_mode=view&refererPlid=14150&_151_cmd=save&_151_assigneeUserId=11266956&_151_workflowTaskId=11270024&_151_redirect=http%3A%2F%2Flocal-climate-adapt.eea.europa.eu%2Fgroup%2Fcontrol_panel%2Fmanage%3Fp_p_id%3D151%26p_p_lifecycle%3D0%26p_p_state%3Dpop_up%26p_p_mode%3Dview%26refererPlid%3D14150%26_151_workflowInstanceId%3D11270018%26_151_redirect%3Dhttp%253A%252F%252Flocal-climate-adapt.eea.europa.eu%252Fgroup%252Fcontrol_panel%252Fmanage%253Fp_p_id%253D151%2526p_p_lifecycle%253D0%2526p_p_state%253Dmaximized%2526p_p_mode%253Dview%2526refererPlid%253D14150%2526_151_tabs1%253Dsubmissions%26_151_struts_action%3D%252Fworkflow_definitions%252Fedit_workflow_instance&_151_struts_action=%2Fworkflow_definitions%2Fedit_workflow_instance_task&_151_transitionName=Finish";

		//
		// request.getParameterMap().put(approveTaskURL, approveTaskURL);
		if (action.equals("editTask"))
			response.sendRedirect(taskURL2.toString());
		if (action.equals("finishTask")) {
			WorkflowTaskManagerUtil.completeWorkflowTask(
					workflowInstanceLink.getGroupId(),
					workflowInstanceLink.getUserId(), workflowTaskId, "Finish",
					null, workflowInstance.getWorkflowContext());
			response.sendRedirect(finishURL);
		}
		if (action.equals("editForm"))
			response.sendRedirect(formURL);
		return null;
	}
}