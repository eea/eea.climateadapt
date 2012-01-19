package nl.wur.alterra.cgi.ace.search;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexUtil;

/**
 * AceItem wrapper class to export only relevant AceItem attributes to searchResults and add  search result specific properties.
 *
 * @heikki doeleman / Hugo de Groot
 */
public class AceItemSearchResult {

    private long aceItemId;
    private String name;
    private String storedAt;
    private String storagetype;
    private float relevance;
    private long rating;
    private String shortdescription;
    private short controlstatus;
    private String deeplink;

    public AceItemSearchResult(AceItem aceitem) {
    	 
    	setAceItemId( aceitem.getAceItemId() ) ;
    	 
    	setName( aceitem.getName().replaceAll("'","\'") ) ;
    	 
    	setStoredAt( aceitem.getStoredAt().replaceAll("'","\'") ) ;
    	 
    	setStoragetype( aceitem.getStoragetype().replaceAll("'","\'") ) ;
    	 
    	setRating( aceitem.getRating() ) ;
    	 
    	setShortdescription( aceitem.getDescription().replaceAll("'","\'") ) ;
    	 
    	setControlstatus( aceitem.getControlstatus() ) ;
    	 
    	setDeeplink( aceitem.getDeeplink().replaceAll("'","\'") ) ;
    }
    
	public Long getAceItemId() {
		return aceItemId;
	}

	public void setAceItemId(Long aceItemId)
	{
        this.aceItemId = aceItemId;
    }

	public String getName() {
		return name;
	}

	public void setName(String name)
	{
        this.name = name.replaceAll("\"", "\"\"");
    }

	public String getStoragetype() {
		return storagetype;
	}

	public void setStoragetype(String storagetype)
	{
        this.storagetype = storagetype.replaceAll("\"", "\"\"");
    }

	public String getStoredAt() {
		return storedAt;
	}

	public void setStoredAt(String storedAt)
	{
        this.storedAt = storedAt.replaceAll("\"", "\"\"");
    }

    public float getRelevance() {
        return relevance;
    }

    public void setRelevance(float relevance) {
        String help = "" + relevance;
        if( ! help.startsWith("NaN")) {
        	
        	this.relevance = relevance ;
        }  
        else {
        	
        	this.relevance = 0.0f;
        }
    }

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating)
	{
        this.rating = rating;
    }
    
    public String getShortdescription() {
        return shortdescription;
    }

    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription.replaceAll("\\<.*?\\>", " ");
        this.shortdescription = shortdescription.replaceAll("\"", "\"\"");
        
        int desclength = ACEIndexUtil.retrieveTotalDescriptionLength() - this.name.length();
        
        if (desclength < 4) {
        	
        	desclength = 24;
        }
        
        if( this.shortdescription.length() > desclength) {
        	
        	this.shortdescription = this.shortdescription.substring(0, desclength-4) + " ..." ; 
        }
        
    }

	public Short getControlstatus() {
		return controlstatus;
	}

	public void setControlstatus(Short controlstatus)
	{
        this.controlstatus = controlstatus;
    }

	public String getDeeplink() {
		return deeplink;
	}

	public void setDeeplink(String deeplink)
	{
        this.deeplink = deeplink.replaceAll("\"", "\"\"");
    }
}
