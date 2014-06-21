package nl.wur.alterra.cgi.util;

import java.util.Comparator;

import com.liferay.portlet.journal.model.JournalArticle;

public class JournalComparator implements Comparator {

    int sortFlag = 0;

    public JournalComparator(int sortFlag)
    {
       this.sortFlag = sortFlag;
    }

    public int compare(Object o1, Object o2)
    {
        JournalArticle article1 = (JournalArticle) o1;
        JournalArticle article2 = (JournalArticle) o2;

        int result = article1.getDisplayDate().compareTo(article2.getDisplayDate());

        if (result != 0)
        {
            if (sortFlag == 1)
            {
                result = -result;
            }
        }

        return result;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
