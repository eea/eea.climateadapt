package nl.wur.alterra.cgi.ace.search.opensearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Search result for BaseOpenSearchImpl.
 *
 * @author heikki doeleman
 */
public class BaseOpenSearchResult {
    private List<BaseOpenSearchResultEntry> entries = new ArrayList<BaseOpenSearchResultEntry>();
    private int total;

    public List<BaseOpenSearchResultEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<BaseOpenSearchResultEntry> entries) {
        this.entries = entries;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int size() {
        return getEntries().size();
    }

    public boolean isEmpty() {
        return getEntries().isEmpty();
    }

    public boolean add(BaseOpenSearchResultEntry baseOpenSearchResultEntry) {
        return getEntries().add(baseOpenSearchResultEntry);
    }

    public boolean remove(Object o) {
        return getEntries().remove(o);
    }

    public void clear() {
        getEntries().clear();
    }
}