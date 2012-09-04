package nl.wur.alterra.cgi.ace.search;

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
