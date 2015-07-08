package eu.europa.eea.mayors_adapt.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import java.util.TreeSet;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.TermQueryFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

import eu.europa.eea.mayors_adapt.service.base.DataServiceBaseImpl;

/**
 * The implementation of the data remote service.
 *
 * <p>
 * All custom service methods should be add in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link eu.europa.eea.mayors_adapt.service.DataService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eu.europa.eea.mayors_adapt.service.base.DataServiceBaseImpl
 * @see eu.europa.eea.mayors_adapt.service.DataServiceUtil
 */
@AccessControlled(guestAccessEnabled = true)
public class DataServiceImpl extends DataServiceBaseImpl {

	public TreeSet<String> getDataTypes() {
		TreeSet<String> dataTypes = new TreeSet<String>();
		dataTypes.add("Publications and reports");
		dataTypes.add("Information portals");
		dataTypes.add("Maps, graphs and datasets");
		dataTypes.add("Indicators");
		dataTypes.add("Guidance");
		dataTypes.add("Tools");
		dataTypes.add("Research and knowledge projects");
		dataTypes.add("Organisations");
		dataTypes.add("Adaptation options");
		dataTypes.add("Case studies");
		return dataTypes;
	}

	public TreeSet<String> getAdaptationSectors() {
		TreeSet<String> adaptationSectors = new TreeSet<String>();
		adaptationSectors.add("Agriculture and Forest");
		adaptationSectors.add("Biodiversity");
		adaptationSectors.add("Coastal areas");
		adaptationSectors.add("Disaster Risk Reduction");
		adaptationSectors.add("Financial");
		adaptationSectors.add("Health");
		adaptationSectors.add("Infrastructure");
		adaptationSectors.add("Marine and Fisheries");
		adaptationSectors.add("Water management");
		adaptationSectors.add("Urban");
		return adaptationSectors;
	}

	public TreeSet<String> getClimateImpacts() {
		TreeSet<String> climateImpacts = new TreeSet<String>();
		climateImpacts.add("Temperatures");
		climateImpacts.add("Water Scarcity");
		climateImpacts.add("Flooding");
		climateImpacts.add("Sea Level Rise");
		climateImpacts.add("Droughts");
		climateImpacts.add("Storms");
		climateImpacts.add("Ice and Snow");
		return climateImpacts;
	}

	public TreeSet<String> getAdaptationElements() {
		TreeSet<String> adaptationElements = new TreeSet<String>();
		adaptationElements.add("Observations and Scenarios");
		adaptationElements.add("Vulnerability Assessment");
		adaptationElements.add("Adaptation Actions");
		adaptationElements.add("Adaptation Plans and Strategies");
		adaptationElements.add("Sector Policies");
		adaptationElements.add("Adaptation Measures and Actions");
		return adaptationElements;
	}

	public TreeSet<String> getCountries() {
		TreeSet<String> countries = new TreeSet<String>();
		countries.add("Albania");
		countries.add("Austria");
		countries.add("Belgium");
		countries.add("Bulgaria");
		countries.add("Croatia");
		countries.add("Cyprus");
		countries.add("Czech Republic");
		countries.add("Germany");
		countries.add("Denmark");
		countries.add("Estonia");
		countries.add("Finland");
		countries.add("United Kingdom");
		countries.add("France");
		countries.add("Greece");
		countries.add("Hungary");
		countries.add("Ireland");
		countries.add("Italy");
		countries.add("Latvia");
		countries.add("Lithuania");
		countries.add("Luxembourg");
		countries.add("Malta");
		countries.add("Netherlands");
		countries.add("Poland");
		countries.add("Portugal");
		countries.add("Romania");
		countries.add("Slovakia");
		countries.add("Slovenia");
		countries.add("Spain");
		countries.add("Sweden");
		countries.add("Switzerland");
		countries.add("Iceland");
		countries.add("Liechtenstein");
		countries.add("Norway");
		countries.add("Turkey");
		countries.add("Croatia");
		countries.add("Serbia");
		countries.add("Bosnia and Herzegovina");
		countries.add("Montenegro");
		countries.add("Albania");
		countries.add("Kosovo under UN Security Counil Resolution 1244/99");
		countries.add("Former Yugoslav Republic of Macedonia");
		return countries;
	}

	public DDMStructure getStructure() throws SystemException {
		return cityProfileStructure;
	}

	Log _log = LogFactoryUtil.getLog("DataServiceImpl.class");
	String structureName = "City Profile";
	DDMStructure cityProfileStructure = getStructure(structureName);
	long cityProfileStructureId = cityProfileStructure.getStructureId();
	Locale locale = new Locale("en", "GB");

	public TreeMap<String, String> getCitiesByCriteria(List<String> countries,
			List<String> sectors, List<String> impacts, List<String> stages) {

		TreeMap<String, String> ret = new TreeMap<String, String>();

		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(1);
		searchContext.setEntryClassNames(new String[] { JournalArticle.class
				.getName() });

		BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		try {
			if (countries != null && countries.size() > 0) {
				BooleanQuery countryQuery = BooleanQueryFactoryUtil
						.create(searchContext);
				for (String country : countries) {
					countryQuery.add(TermQueryFactoryUtil.create(searchContext,
							getField("a_m_country"), country),
							BooleanClauseOccur.SHOULD);
				}
				booleanQuery.add(countryQuery, BooleanClauseOccur.MUST);
			}

			if (sectors != null && sectors.size() > 0) {
				BooleanQuery sectorQuery = BooleanQueryFactoryUtil
						.create(searchContext);
				for (String sector : sectors) {
					sectorQuery.add(TermQueryFactoryUtil.create(searchContext,
							getField("b_m_sector"), sector),
							BooleanClauseOccur.SHOULD);
				}
				booleanQuery.add(sectorQuery, BooleanClauseOccur.MUST);
			}

			if (impacts != null && impacts.size() > 0) {
				BooleanQuery impactQuery = BooleanQueryFactoryUtil
						.create(searchContext);
				for (String impact : impacts) {
					impactQuery.add(TermQueryFactoryUtil.create(searchContext,
							getField("b_m_climate_impacts"), impact),
							BooleanClauseOccur.MUST);
				}
				booleanQuery.add(impactQuery, BooleanClauseOccur.MUST);
			}

			if (stages != null && stages.size() > 0) {
				BooleanQuery stageQuery = BooleanQueryFactoryUtil
						.create(searchContext);
				for (String stage : stages) {
					stageQuery.add(TermQueryFactoryUtil.create(searchContext,
							getField("c_m_stage_of_the_implementation_cycle"),
							stage), BooleanClauseOccur.SHOULD);
				}
				booleanQuery.add(stageQuery, BooleanClauseOccur.MUST);
			}

			booleanQuery.add(TermQueryFactoryUtil.create(searchContext,
					Field.STATUS, WorkflowConstants.STATUS_APPROVED),
					BooleanClauseOccur.MUST);

			booleanQuery.add(TermQueryFactoryUtil.create(searchContext,
					Field.CLASS_TYPE_ID, cityProfileStructureId),
					BooleanClauseOccur.MUST);

		} catch (ParseException e) {
			_log.error("Could not parse query " + booleanQuery.toString());
			e.printStackTrace();
		}
		try {
			_log.info("Executing Query: " + booleanQuery.toString());

			Hits hits = SearchEngineUtil.search(searchContext, booleanQuery);
			for (Document doc : hits.getDocs()) {
				// List<String> impactList = Arrays.asList(doc
				// .getValues(getField("b_m_climate_impacts")));
				//
				// _log.info("impactList: " + impactList);
				// _log.info("impact2List: " +impact2List);
				// _log.info("impact: "+impacts);
				// _log.info(impact2List.containsAll(impacts));
				// if (impactList.containsAll(impacts))
				long articleId = Long.parseLong(doc.get(Field.UID).split("_PORTLET_")[1]);
				String articleUrlTitle = "";
				try {
					JournalArticle article = JournalArticleLocalServiceUtil
							.getArticle(articleId);
					articleUrlTitle = article.getUrlTitle();
				} catch (com.liferay.portlet.journal.NoSuchArticleException e) {
					_log.error("City profile not found for indexed articleId: "+articleId);
				}
				ret.put(doc.get(locale, Field.TITLE),
						"/-/" + articleUrlTitle );
				_log.info(Arrays.asList(doc
						.getValues(getField("b_m_climate_impacts"))));
				_log.info(doc.toString());
			}

			_log.info("Query executed: " + booleanQuery.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

	private DDMStructure getStructure(String structureName) {
		String structureDescription = "Structure for a City Profile";
		DDMStructure cityProfileStructure = null;
		List<DDMStructure> structures;
		try {
			structures = DDMStructureLocalServiceUtil.getStructures();
			for (DDMStructure structure : structures) {
				if (structure.getName(LocaleUtil.getDefault())
						.equalsIgnoreCase(structureName))
					cityProfileStructure = structure;
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		if (cityProfileStructure == null)
			_log.error("Could not found structure with name: " + structureName);
		return cityProfileStructure;
	}

	private String getField(String field) {
		return "ddm/" + cityProfileStructureId + "/" + field + "_" + locale;
	}

}
