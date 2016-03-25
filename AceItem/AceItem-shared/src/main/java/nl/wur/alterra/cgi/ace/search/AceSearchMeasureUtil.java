package nl.wur.alterra.cgi.ace.search;

import java.util.List;

import com.google.gson.Gson;

public class AceSearchMeasureUtil {
	
	 /**
     * This method was created for issue https://taskman.eionet.europa.eu/issues/27313
     * @param originalMeasureId
     * @return
     */
    public static long filterAdaptationOptionIds(long originalMeasureId) {
    	long filteredMeasureId;
    	if (originalMeasureId == 2622) {
    		filteredMeasureId = 606;
    	} else if (originalMeasureId == 2626) {
    		filteredMeasureId = 607;
    	} else if (originalMeasureId == 620 || originalMeasureId == 641 || originalMeasureId == 708 ||
    			originalMeasureId == 2615 || originalMeasureId == 2621) {
    		filteredMeasureId = 611;
    	} else if (originalMeasureId == 640 || originalMeasureId == 2628) {
    		filteredMeasureId = 616;
    	} else if (originalMeasureId == 2603 || originalMeasureId == 2627) {
    		filteredMeasureId = 628;
    	} else if (originalMeasureId == 624 || originalMeasureId == 2601 || originalMeasureId == 2602 ||
    			originalMeasureId == 2604 || originalMeasureId == 2606 || originalMeasureId == 2607 ||
    			originalMeasureId == 2616 || originalMeasureId == 2623) {
    		filteredMeasureId = 629;
    	} else if (originalMeasureId == 633 || originalMeasureId == 679 || originalMeasureId == 2610) {
    		filteredMeasureId = 649;
    	} else if (originalMeasureId == 2613 || originalMeasureId == 2614) {
    		filteredMeasureId = 655;
    	} else if (originalMeasureId == 671 || originalMeasureId == 674 || originalMeasureId == 678) {
    		filteredMeasureId = 656;
    	} else if (originalMeasureId == 663 || originalMeasureId == 2618) {
    		filteredMeasureId = 664;
    	} else if (originalMeasureId == 2617){
    		filteredMeasureId = 679;
    	} else if (originalMeasureId == 2625 || originalMeasureId == 2627) {
    		filteredMeasureId = 682;
    	} else if (originalMeasureId == 2620 || originalMeasureId == 2625) {
    		filteredMeasureId = 687;
    	} else if (originalMeasureId == 2608 || originalMeasureId == 2624) {
    		filteredMeasureId = 1101;
    	} else if (originalMeasureId == 675) {
    		filteredMeasureId = 1102;
    	} else if (originalMeasureId == 2605 || originalMeasureId == 2619) {
    		filteredMeasureId = 4702;
    	} else {
    		return originalMeasureId;
    	}
    	
    	
    	return filteredMeasureId;	
    }

    public static String getJSONResults(List<AceItemSearchResult> results) {
    	Gson gson = new Gson();    	
    	return gson.toJson(results);
    }
	
}
