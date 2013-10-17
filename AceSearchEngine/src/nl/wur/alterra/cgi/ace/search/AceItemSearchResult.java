package nl.wur.alterra.cgi.ace.search;

import java.util.Date;

import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexUtil;

/**
 * AceItem wrapper class to export only relevant AceItem attributes to
 * searchResults and add search result specific properties.
 *
 * @heikki doeleman / Hugo de Groot
 */
public class AceItemSearchResult {

    /** */
    private long aceItemId;
    private String name;
    private String storedAt;
    private String storagetype;
    private float relevance;
    private long rating;
    private String shortdescription;
    private short controlstatus;
    private String deeplink;
    private String spatialLayer;
    private String feature;
    private boolean isNew= false;
    

    public boolean isIsNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		//System.out.println("inside setNew name is " + this.name);
		//System.out.println("isNew is " + isNew);
		this.isNew = isNew;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		//System.out.println(" setting feature " + feature);
		this.feature = feature;
	}

	/**
     *
     * @param aceitem
     */
    public AceItemSearchResult(AceItem aceitem) {

        setAceItemId(aceitem.getAceItemId());

        setName(aceitem.getName().replaceAll("'", "\'"));

        setStoredAt(aceitem.getStoredAt().replaceAll("'", "\'"));

        setStoragetype(aceitem.getStoragetype().replaceAll("'", "\'"));

        setRating(aceitem.getRating());

        setShortdescription(aceitem.getDescription().replaceAll("'", "\'"));

        setControlstatus(aceitem.getControlstatus());

        setDeeplink(aceitem.getDeeplink().replaceAll("'", "\'"));
        
        //System.out.println("feature is " + aceitem.getFeature());
        setFeature(aceitem.getFeature());
        //System.out.println("name is " + getName());
        setNew(isNew(aceitem.getApprovaldate(), aceitem.getCreationdate()));
        
    }
    
    
    
    
    public boolean isNew(Date approvalDate, Date createdDate)
    {
    	Date processDate = null;
    	if (approvalDate == null)
    	{
    		processDate = createdDate;
    	}
    	else
    	{
    		processDate = approvalDate;
    	}
    	
    	//System.out.println("approval date is " + approvalDate);
    	//System.out.println("creation date is " + approvalDate);
    	//System.out.println("process date is " + processDate);
    	Date today = new Date();
    	long t1 = today.getTime();
    	long t2 = processDate.getTime();
    	
    	//System.out.println("creation date is " + creationDate);
    	long day = 1000 * 60 * 60 * 24; // milliseconds in a day
    	
    	long days = (t1 - t2) / day;
    	
    	//System.out.println("days is " + days);
    	if (days <= 90)
    	{
    		//System.out.println("returning true");
    		return true;
    	}
    	else
    	{
    		//System.out.println("returning false");
    		return false;
    	}
    }

    /**
     * @return
     */
    public Long getAceItemId() {
        return aceItemId;
    }

    /**
     * @param aceItemId
     */
    public void setAceItemId(Long aceItemId) {
        this.aceItemId = aceItemId;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name.replaceAll("\"", "\"\"");
    }

    /**
     * @return
     */
    public String getStoragetype() {
        return storagetype;
    }

    /**
     * @param storagetype
     */
    public void setStoragetype(String storagetype) {
        this.storagetype = storagetype.replaceAll("\"", "\"\"");
    }

    /**
     * @return
     */
    public String getStoredAt() {
        return storedAt;
    }

    /**
     * @param storedAt
     */
    public void setStoredAt(String storedAt) {
        this.storedAt = storedAt.replaceAll("\"", "\"\"");
    }

    /**
     * @return
     */
    public float getRelevance() {
        return relevance;
    }

    /**
     * @param relevance
     */
    public void setRelevance(float relevance) {
        String help = "" + relevance;
        if (!help.startsWith("NaN")) {

            this.relevance = relevance;
        } else {

            this.relevance = 0.0f;
        }
    }

    /**
     * @return
     */
    public Long getRating() {
        return rating;
    }

    /**
     * @param rating
     */
    public void setRating(Long rating) {
        this.rating = rating;
    }

    /**
     * @return
     */
    public String getShortdescription() {
        return shortdescription;
    }

    /**
     * @param shortdescription
     */
    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription.replaceAll("\\<.*?\\>", " ");

        int desclength = ACEIndexUtil.retrieveTotalDescriptionLength()
                - this.name.length();

        if (desclength < 4) {

            desclength = 24;
        }

        if (this.shortdescription.length() > desclength) {

            this.shortdescription = this.shortdescription.substring(0,
                    desclength - 4).replaceAll("\"", "\"\"")
                    + " ...";
        }

    }

    /**
     * @return
     */
    public Short getControlstatus() {
        return controlstatus;
    }

    /**
     * @param controlstatus
     */
    public void setControlstatus(Short controlstatus) {
        this.controlstatus = controlstatus;
    }

    /**
     * @return
     */
    public String getDeeplink() {
        return deeplink;
    }

    /**
     * @param deeplink
     */
    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink.replaceAll("\"", "\"\"");
    }

    /**
     * @return
     */
    public String getSpatialLayer() {
        return spatialLayer;
    }

    /**
     * @param spatialLayer
     */
    public void setSpatialLayer(String spatialLayer) {
        this.spatialLayer = spatialLayer;
    }
}
