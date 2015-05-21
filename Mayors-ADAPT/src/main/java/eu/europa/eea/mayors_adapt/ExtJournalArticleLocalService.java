package eu.europa.eea.mayors_adapt;

import java.io.File;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceWrapper;
import com.liferay.portlet.journal.service.JournalArticleLocalService;

public class ExtJournalArticleLocalService extends JournalArticleLocalServiceWrapper {
	/* (non-Java-doc)
	 * @see com.liferay.portlet.journal.service.JournalArticleLocalServiceWrapper#JournalArticleLocalServiceWrapper(JournalArticleLocalService journalArticleLocalService)
	 */
	public ExtJournalArticleLocalService(JournalArticleLocalService journalArticleLocalService) {
		super(journalArticleLocalService);
	}
	
	@Override
	public JournalArticle updateArticle(long userId, long groupId,
			long folderId, String articleId, double version,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			String content, String type, String ddmStructureKey,
			String ddmTemplateKey, String layoutUuid, int displayDateMonth,
			int displayDateDay, int displayDateYear, int displayDateHour,
			int displayDateMinute, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear,
			int expirationDateHour, int expirationDateMinute,
			boolean neverExpire, int reviewDateMonth, int reviewDateDay,
			int reviewDateYear, int reviewDateHour, int reviewDateMinute,
			boolean neverReview, boolean indexable, boolean smallImage,
			String smallImageURL, File smallImageFile,
			Map<String, byte[]> images, String articleURL,
			ServiceContext serviceContext) throws PortalException,
			SystemException {
		System.out.println("Por aqui 2");
		// TODO Auto-generated method stub
		return super.updateArticle(userId, groupId, folderId, articleId, version,
				titleMap, descriptionMap, content, type, ddmStructureKey,
				ddmTemplateKey, layoutUuid, displayDateMonth, displayDateDay,
				displayDateYear, displayDateHour, displayDateMinute,
				expirationDateMonth, expirationDateDay, expirationDateYear,
				expirationDateHour, expirationDateMinute, neverExpire, reviewDateMonth,
				reviewDateDay, reviewDateYear, reviewDateHour, reviewDateMinute,
				neverReview, indexable, smallImage, smallImageURL, smallImageFile,
				images, articleURL, serviceContext);
	}
	
	

}