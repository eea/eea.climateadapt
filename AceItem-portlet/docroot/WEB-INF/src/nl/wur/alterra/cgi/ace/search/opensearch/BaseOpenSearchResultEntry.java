package nl.wur.alterra.cgi.ace.search.opensearch;

import java.util.Date;

/**
 * Single search result entry in BaseOpenSearchResult.
 *
 * @author heikki doeleman
 */
public class BaseOpenSearchResultEntry {

    private Date modifedDate = new Date();
    private long resultGroupId;
    private String title;
    private String url;
    private String content;
    private String[] tags;
    private double ratings;
    private String entryClassName;
    private long entryClassPK;
    private double score = 1.0;

    public Date getModifedDate() {
        return modifedDate;
    }

    public void setModifedDate(Date modifedDate) {
        this.modifedDate = modifedDate;
    }

    public long getResultGroupId() {
        return resultGroupId;
    }

    public void setResultGroupId(long resultGroupId) {
        this.resultGroupId = resultGroupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public String getEntryClassName() {
        return entryClassName;
    }

    public void setEntryClassName(String entryClassName) {
        this.entryClassName = entryClassName;
    }

    public long getEntryClassPK() {
        return entryClassPK;
    }

    public void setEntryClassPK(long entryClassPK) {
        this.entryClassPK = entryClassPK;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
