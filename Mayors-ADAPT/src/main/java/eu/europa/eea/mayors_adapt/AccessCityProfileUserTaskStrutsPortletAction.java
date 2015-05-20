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
import com.liferay.portal.security.auth.Authenticator;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.usersadmin.action.GetUsersCountAction;

public class AccessCityProfileUserTaskStrutsPortletAction extends
		BaseStrutsAction {
	private static Log _log = LogFactoryUtil
			.getLog(AccessCityProfileUserTaskStrutsPortletAction.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Enumeration paras = request.getParameterNames();
		while (paras.hasMoreElements()) {
			// String attrName = (String) attrs.nextElement();
			// String attrValue = (String) request.getAttribute(attrName);
			_log.info("Param: " + paras.nextElement());
		}
		Enumeration attrs = request.getAttributeNames();
		while (attrs.hasMoreElements()) {
			// String attrName = (String) attrs.nextElement();
			// String attrValue = (String) request.getAttribute(attrName);
			_log.info("Attr: " + attrs.nextElement());
		}
		Enumeration sAttrs = request.getSession().getAttributeNames();
		while (sAttrs.hasMoreElements()) {
			String sAttrName = (String) sAttrs.nextElement();
			_log.info("SAttr: " + sAttrName +" value: "+request.getSession().getAttribute(sAttrName));
		}

		Enumeration<String> enu1 = request.getHeaderNames();
		while (enu1.hasMoreElements()) {
			String name = enu1.nextElement();
			Enumeration<String> enu2 = request.getHeaders(name);
			while (enu2.hasMoreElements()) {
				String value = enu2.nextElement();
				_log.info("Header: " + name + " value:" + value);
			}
		}

		request.getSession().invalidate();

		paras = request.getParameterNames();
		while (paras.hasMoreElements()) {
			// String attrName = (String) attrs.nextElement();
			// String attrValue = (String) request.getAttribute(attrName);
			_log.info("Param: " + paras.nextElement());
		}
		attrs = request.getAttributeNames();
		while (attrs.hasMoreElements()) {
			// String attrName = (String) attrs.nextElement();
			// String attrValue = (String) request.getAttribute(attrName);
			_log.info("Attr: " + attrs.nextElement());
		}
		request.getSession().invalidate();
		while (enu1.hasMoreElements()) {
			String name = enu1.nextElement();
			Enumeration<String> enu2 = request.getHeaders(name);
			while (enu2.hasMoreElements()) {
				String value = enu2.nextElement();
				_log.info("Header: " + name + " value:" + value);
			}
		}
		 sAttrs = request.getSession().getAttributeNames();
		while (sAttrs.hasMoreElements()) {
			String sAttrName = (String) sAttrs.nextElement();
			_log.info("SAttr: " + sAttrName +" value: "+request.getSession().getAttribute(sAttrName));
		}
		

		String entryClassPK = ParamUtil.get(request, "entryClassPK", "0");
		String entryClassName = ParamUtil.get(request, "entryClassName",
				"com.liferay.portlet.journal.model.JournalArticle");
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
		HashMap<String, Object> map = new HashMap<String, Object>();
		// int authResult = UserLocalServiceUtil.authenticateByScreenName(
		// companyId, "cityprofilecontact", "cityprofilecontact", null,
		// request.getParameterMap(),
		// map);
 
		Map<String, String[]> headerMap = new HashMap<String, String[]>();

		 enu1 = request.getHeaderNames();

		while (enu1.hasMoreElements()) {
			String name = enu1.nextElement();

			Enumeration<String> enu2 = request.getHeaders(name);

			List<String> headers = new ArrayList<String>();

			while (enu2.hasMoreElements()) {
				String value = enu2.nextElement();

				headers.add(value);
			}

			headerMap.put(name, headers.toArray(new String[headers.size()]));
		}

//		String login = "vazqugus";
		String login = "cityprofilecontact";
//		int authResult = UserLocalServiceUtil.authenticateByScreenName(
//				companyId, login,
//				password, headerMap,
//				request.getParameterMap(), map);

//		LoginUtil.login(request, response, login, password, false, null);

//		_log.info("Auth2:" + authResult);
//		_log.info(authResult == Authenticator.SUCCESS);
		_log.info(request.getParameterMap());
		_log.info(headerMap);
		_log.info(map);
		for (String key : map.keySet()) {
			_log.info("key:" + key + " value:" + map.get(key));
		}
		_log.info(request.getSession().toString());
		// UserLocalServiceUtil.getUserById(Long.parseLong("1222")).getS;
		User user = UserLocalServiceUtil.getUserByScreenName(companyId, login);
		
		HttpSession session = request.getSession();
//		login = ""+map.get("userId");
		session.setAttribute("j_username", String.valueOf(user.getUserId()));
		session.setAttribute("j_password", user.getPassword());
		session.setAttribute("j_remoteuser", String.valueOf(user.getUserId()));

		String articleId = JournalArticleLocalServiceUtil.getArticle(
				Long.parseLong(entryClassPK)).getArticleId();
		WorkflowInstanceLink workflowInstanceLink = WorkflowInstanceLinkLocalServiceUtil
				.getWorkflowInstanceLink(companyId, groupId, entryClassName,
						Long.parseLong(entryClassPK));
		WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil
				.getWorkflowInstance(companyId,
						workflowInstanceLink.getWorkflowInstanceId());
		_log.info("Gathering tasks for workflowInstanceLink: "
				+ workflowInstanceLink.getWorkflowInstanceId() + " user:"
				+ userId + " companyId:" + companyId);
		List<WorkflowTask> tasks = WorkflowTaskManagerUtil
				.getWorkflowTasksByWorkflowInstance(companyId, userId,
						workflowInstanceLink.getWorkflowInstanceId(), false, 0,
						1, null);
		long workflowTaskId = 0;

		for (WorkflowTask task : tasks) {
			_log.info("Task id: " + task.getWorkflowTaskId() + " "
					+ task.getName());
			workflowTaskId = task.getWorkflowTaskId();
		}

		LiferayPortletURL factoryFormURL = PortletURLFactoryUtil.create(
				request, "15", 10137L, PortletRequest.RENDER_PHASE);
		factoryFormURL.setWindowState(LiferayWindowState.POP_UP);
		factoryFormURL.setPortletMode(PortletMode.VIEW);
		factoryFormURL.setDoAsGroupId(18L);
		// factoryFormURL.setEncrypt(true);
		factoryFormURL.setParameter("articleId", articleId);
		// factoryFormURL.addParameterIncludedInPath("articleId");
		factoryFormURL.setParameter("workflowInstanceId",
				String.valueOf(workflowInstanceLink.getWorkflowInstanceId()));
		factoryFormURL.setParameter("version", version);
		factoryFormURL.setParameter("struts_action", "/journal/edit_article");
		// factoryFormURL.setParameter("redirect",
		// HttpUtil.encodeURL("http://google.com"));

		String formURL = HttpUtil
				.decodeURL("http%3A%2F%2Flocal-climate-adapt.eea.europa.eu%2Fgroup%2Fcontrol_panel%2Fmanage"
						+ "%3Fp_p_auth%3DLQg4QvMr"
						+ "%26p_p_id%3D15"
						+ "%26p_p_lifecycle%3D0"
						+ "%26p_p_state%3Dpop_up"
						+ "%26p_p_mode%3Dview%"
						+ "26doAsGroupId%3D18"
						+ "%26refererPlid%3D10137"
						+ "%26_15_struts_action%3D%252Fjournal%252Fedit_article"
						+ "%26_15_groupId%3D18"
						+ "%26_15_articleId%3D"
						+ articleId
						+ "%26_15_version%3D1.0%26_15_redirect%3Dhttp%253A%252F%252Flocal-climate-adapt.eea.europa.eu%252Fgroup%252Fcontrol_panel%252Fmanage%253Fp_p_id%253D151%2526p_p_lifecycle%253D0%2526p_p_state%253Dpop_up%2526p_p_mode%253Dview%2526refererPlid%253D14150%2526_151_struts_action%253D%25252Fworkflow_definitions%25252Fadd_asset_redirect%2526%26_15_originalRedirect%3Dhttp%253A%252F%252Flocal-climate-adapt.eea.europa.eu%252Fgroup%252Fcontrol_panel%252Fmanage%253Fp_p_id%253D151%2526p_p_lifecycle%253D0%2526p_p_state%253Dpop_up%2526p_p_mode%253Dview%2526refererPlid%253D14150%2526_151_struts_action%253D%25252Fworkflow_definitions%25252Fadd_asset_redirect%2526_151_redirect%253Dhttp%25253A%25252F%25252Flocal-climate-adapt.eea.europa.eu%25252Fgroup%25252Fcontrol_panel%25252Fmanage%25253Fp_p_id%25253D151%252526p_p_lifecycle%25253D0%252526p_p_state%25253Dmaximized%252526p_p_mode%25253Dview%252526refererPlid%25253D14150%252526_151_assetEntryVersionId%25253D11269538%252526_151_showEditURL%25253Dtrue%252526_151_workflowAssetPreview%25253Dtrue%252526_151_redirect%25253Dhttp%2525253A%2525252F%2525252Flocal-climate-adapt.eea.europa.eu%2525252Fgroup%2525252Fcontrol_panel%2525252Fmanage%2525253Fp_p_id%2525253D151%25252526p_p_lifecycle%2525253D0%25252526p_p_state%2525253Dmaximized%25252526p_p_mode%2525253Dview%25252526refererPlid%2525253D14150"
						+ "%25252526_151_workflowInstanceId%2525253D"
						+ workflowInstance.getWorkflowInstanceId()
						+ "%25252526_151_redirect%2525253Dhttp%252525253A%252525252F%252525252Flocal-climate-adapt.eea.europa.eu%252525252Fgroup%252525252Fcontrol_panel%252525252Fmanage%252525253Fp_p_id%252525253D151%2525252526p_p_lifecycle%252525253D0%2525252526p_p_state%252525253Dmaximized%2525252526p_p_mode%252525253Dview%2525252526refererPlid%252525253D14150%2525252526_151_tabs1%252525253Dsubmissions%25252526_151_struts_action%2525253D%252525252Fworkflow_definitions%252525252Fedit_workflow_instance%252526_151_struts_action%25253D%2525252Fworkflow_definitions%2525252Fview_content%252526_151_type%25253Dcontent%252526_151_assetEntryId%25253D11269542%26_15_referringPortletResource%3D151");

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
		// factoryTaskURL.setParameter("tabs1", "submissions");
		// factoryTaskURL.setParameter("redirect",
		// "http%3A%2F%2Flocal-climate-adapt.eea.europa.eu%2Fgroup%2Fcontrol_panel%2Fmanage%3F"
		// + "p_p_id%3D151"
		// + "%26p_p_lifecycle%3D0"
		// + "%26p_p_state%3Dmaximized"
		// + "%26p_p_mode%3Dview"
		// + "%26refererPlid%3D14150"
		// + "%26_151_tabs1%3Dsubmissions");

		//
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
		// +
		// "&_151_struts_action=%2Fworkflow_definitions%2Fedit_workflow_instance"));

		String taskURL = "http://local-climate-adapt.eea.europa.eu/group/control_panel/manage"
				+ "?p_p_id=151"
				+ "&p_p_lifecycle=0"
				+ "&p_p_state=pop_up"
				+ "&p_p_mode=view"
				+ "&refererPlid=14150"
				+ "&_151_workflowInstanceId="
				+ workflowInstanceLink.getWorkflowInstanceId()
				+ "&_151_redirect=http%3A%2F%2Flocal-climate-adapt.eea.europa.eu%2Fgroup%2Fcontrol_panel%2Fmanage%3F"
				+ "p_p_id%3D151"
				+ "%26p_p_lifecycle%3D0"
				+ "%26p_p_state%3Dmaximized"
				+ "%26p_p_mode%3Dview"
				+ "%26refererPlid%3D14150"
				+ "%26_151_tabs1%3Dsubmissions"
				+ "&_151_struts_action=%2Fworkflow_definitions%2Fedit_workflow_instance";

		_log.info("recordId: " + entryClassPK);
		_log.info("articleId: " + articleId);
		_log.info("taskId: " + workflowTaskId);
		_log.info("factoryFormURL: " + factoryFormURL);
		_log.info("formURL: " + formURL);
		_log.info("factoryTaskURL: " + factoryTaskURL);
		_log.info("taskURL: " + taskURL);
		_log.info("factoryFinishURL: " + factoryFinishURL);
		_log.info("finishURL: " + finishURL);
		// _log.info("articleId: "+JournalArticleLocalServiceUtil.getLatestArticle(Long.parseLong(entryClassPK)).getArticleId());

		//
		// request.getParameterMap().put(approveTaskURL, approveTaskURL);
		// request.getSession().invalidate();

		List<String> actions = Arrays.asList(new String[] { "editForm",
				"finishTask", "editTask" });
		switch (actions.indexOf(action)) {
		case 0:
			response.sendRedirect(factoryFormURL.toString());
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
		case 2:
			response.sendRedirect(factoryTaskURL.toString());
			break;
		}
		return null;
	}
}