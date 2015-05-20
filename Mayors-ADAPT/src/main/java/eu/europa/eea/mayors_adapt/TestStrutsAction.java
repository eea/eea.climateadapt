package eu.europa.eea.mayors_adapt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.util.JournalConverterUtil;

public class TestStrutsAction extends BaseStrutsAction {
	private static Log _log = LogFactoryUtil
			.getLog(TestStrutsAction.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
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

		DDMStructure structure = DDMStructureLocalServiceUtil
				.getStructure(11254912L);
		// _log.info("Name:" + structure.getName());
		// _log.info("Key:" + structure.getPrimaryKey());
		// _log.info("Desc:" + structure.getDescription());
		// _log.info("Type:" + structure.getFieldsMap());
		// _log.info("Type:" + structure.getType());
		//
		// _log.info("------msg");

		List<JournalArticle> articles = JournalArticleLocalServiceUtil
				.getStructureArticles(18L, "11254911");
		for (JournalArticle article : articles) {
			if (article.getStatus() != 8) {
				_log.info("Title:" + article.getTitle());
				_log.info("Content:" + article.getModelClassName());
				_log.info("Key:" + article.getPrimaryKey());
				_log.info("Desc:" + article.getDescription());
				_log.info("Type:" + article.getStatus());
				_log.info("Type:" + article.getType());
			}
		}
		// dynami
		 List<JournalArticle> queryArticles =
		 JournalArticleLocalServiceUtil.getStructureArticles(18L, "11254911");
		 for (JournalArticle article : queryArticles){
		 _log.info("Content:"+article.getModelAttributes());
		 _log.info("Key:"+article.getPrimaryKey());
		 _log.info("Desc:"+article.getDescription());
		 _log.info("Type:"+article.getType());
			Fields fields = JournalConverterUtil.getDDMFields(structure, article.getContent());
			for (Field field: fields){
				_log.info("Field:"+field.getName()+" Value:"+field.getValue());
			}
		 }

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
				.forClass(JournalArticle.class);
		dynamicQuery.add(PropertyFactoryUtil.forName("structureId")
				.eq(11254911));
		dynamicQuery.add(PropertyFactoryUtil.forName("content").like(

		// <dynamic-element name="contactEmail" index="0" type="text"
		// index-type="keyword">
		// _ <dynamic-content
		// language-id="en_GB"><![CDATA[representative@spain.es]]></dynamic-content>
		// </dynamic-element>

				"%<dynamic-content><![CDATA[technology]]></dynamic-content>%"));

		return null;
	}
}