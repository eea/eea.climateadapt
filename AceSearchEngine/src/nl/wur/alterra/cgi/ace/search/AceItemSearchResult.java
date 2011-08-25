package nl.wur.alterra.cgi.ace.search;

import nl.wur.alterra.cgi.ace.model.AceItem;

/**
 * Class to decorate AceItem with search result specific properties.
 *
 * @heikki doeleman
 */
public class AceItemSearchResult {

    private AceItem aceItem;
    private float relevance;
    private String shortdescription;

    public AceItemSearchResult(AceItem aceItem) {
        this.aceItem = aceItem;
    }
    
    public AceItem getAceItem() {
        return aceItem;
    }

    public void setAceItem(AceItem aceItem) {
        this.aceItem = aceItem;
    }

    public float getRelevance() {
        return relevance;
    }

    public void setRelevance(float relevance) {
        this.relevance = relevance;
    }

    public String getShortdescription() {
        return shortdescription;
    }

    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription.replaceAll("\\<.*?\\>", " ");
        
        if( this.shortdescription.length() > 400) {
        	
        	this.shortdescription = this.shortdescription.substring(0,396) + " ..." ; 
        }
        
    }
}
