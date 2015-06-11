package eu.europa.eea.mayors_adapt.service.impl;

import java.util.List;
import java.util.TreeMap;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;

import eu.europa.eea.mayors_adapt.service.base.DataServiceBaseImpl;

/**
 * The implementation of the data remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
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

	public TreeMap<String, String> getDataTypes() {
		TreeMap<String, String> dataTypes = new TreeMap<String, String>();
		dataTypes.put("DOCUMENT", "Publications and reports");
		dataTypes.put("INFORMATIONSOURCE", "Information portals");
		dataTypes.put("MAPGRAPHDATASET", "Maps, graphs and datasets");
		dataTypes.put("INDICATOR", "Indicators");
		dataTypes.put("GUIDANCE", "Guidance");
		dataTypes.put("TOOL", "Tools");
		dataTypes.put("RESEARCHPROJECT", "Research and knowledge projects");
		dataTypes.put("ORGANISATION", "Organisations");
		dataTypes.put("MEASURE", "Adaptation options");
		dataTypes.put("ACTION", "Case studies");
		return dataTypes;
	}

	public TreeMap<String, String> getAdaptationSectors() {
		TreeMap<String, String> adaptationSectors = new TreeMap<String, String>();
		adaptationSectors.put("AGRICULTURE", "Agriculture and Forest");
		adaptationSectors.put("BIODIVERSITY", "Biodiversity");
		adaptationSectors.put("COASTAL", "Coastal areas");
		adaptationSectors.put("DISASTERRISKREDUCTION",
				"Disaster Risk Reduction");
		adaptationSectors.put("FINANCIAL", "Financial");
		adaptationSectors.put("HEALTH", "Health");
		adaptationSectors.put("INFRASTRUCTURE", "Infrastructure");
		adaptationSectors.put("MARINE", "Marine and Fisheries");
		adaptationSectors.put("WATERMANAGEMENT", "Water management");
		adaptationSectors.put("URBAN", "Urban");
		return adaptationSectors;
	}

	public TreeMap<String, String> getClimateImpacts() {
		TreeMap<String, String> climateImpacts = new TreeMap<String, String>();
		climateImpacts.put("EXTREMETEMP", "Temperatures");
		climateImpacts.put("WATERSCARCE", "Water Scarcity");
		climateImpacts.put("FLOODING", "Flooding");
		climateImpacts.put("SEALEVELRISE", "Sea Level Rise");
		climateImpacts.put("DROUGHT", "Droughts");
		climateImpacts.put("STORM", "Storms");
		climateImpacts.put("ICEANDSNOW", "Ice and Snow");
		return climateImpacts;
	}

	public TreeMap<String, String> getAdaptationElements() {
		TreeMap<String, String> adaptationElements = new TreeMap<String, String>();
		adaptationElements.put("OBSERVATIONS", "Observations and Scenarios");
		adaptationElements.put("VULNERABILITY", "Vulnerability Assessment");
		adaptationElements.put("ACTION", "Adaptation Actions");
		adaptationElements.put("PLANSTRATEGY",
				"Adaptation Plans and Strategies");
		adaptationElements.put("EU_POLICY", "Sector Policies");
		adaptationElements.put("MEASUREACTION",
				"Adaptation Measures and Actions");
		return adaptationElements;
	}

	public TreeMap<String, String> getCountries() {
		TreeMap<String, String> countries = new TreeMap<String, String>();
		countries.put("AL", "Albania");
		countries.put("AT", "Austria");
		countries.put("BE", "Belgium");
		countries.put("BG", "Bulgaria");
		countries.put("HR", "Croatia");
		countries.put("CY", "Cyprus");
		countries.put("CZ", "Czech Republic");
		countries.put("DE", "Germany");
		countries.put("DK", "Denmark");
		countries.put("EE", "Estonia");
		countries.put("FI", "Finland");
		countries.put("GB", "United Kingdom");
		countries.put("FR", "France");
		countries.put("GR", "Greece");
		countries.put("HU", "Hungary");
		countries.put("IE", "Ireland");
		countries.put("IT", "Italy");
		countries.put("LV", "Latvia");
		countries.put("LT", "Lithuania");
		countries.put("LU", "Luxembourg");
		countries.put("MT", "Malta");
		countries.put("NL", "Netherlands");
		countries.put("PL", "Poland");
		countries.put("PT", "Portugal");
		countries.put("RO", "Romania");
		countries.put("SK", "Slovakia");
		countries.put("SI", "Slovenia");
		countries.put("ES", "Spain");
		countries.put("SE", "Sweden");
		countries.put("CH", "Switzerland");
		countries.put("IS", "Iceland");
		countries.put("LI", "Liechtenstein");
		countries.put("NO", "Norway");
		countries.put("TR", "Turkey");
		countries.put("HR", "Croatia");
		countries.put("RS", "Serbia");
		countries.put("BA", "Bosnia and Herzegovina");
		countries.put("ME", "Montenegro");
		countries.put("AL", "Albania");
		countries.put("XK",
				"Kosovo under UN Security Counil Resolution 1244/99");
		countries.put("MK", "Former Yugoslav Republic of Macedonia");
		return countries;
	}

	public DDMStructure getStructure() throws SystemException {
		TreeMap<String, String> climateImpacts = new TreeMap<String, String>();
		List<DDMStructure> r = DDMStructureLocalServiceUtil.getDDMStructures(0,
				DDMStructureLocalServiceUtil.getDDMStructuresCount());
		DDMStructure ret = null;
		for (DDMStructure struct : r) {
			if (struct.getName().equals("City Profile")
					&& struct.getDescription().equals(
							"Structure for a City Profile"))
				ret = struct;
		}
		r = DDMStructureLocalServiceUtil.getStructures(18L, "City Profile",
				"Structure for a City Profile");
		return ret;
	}

}
