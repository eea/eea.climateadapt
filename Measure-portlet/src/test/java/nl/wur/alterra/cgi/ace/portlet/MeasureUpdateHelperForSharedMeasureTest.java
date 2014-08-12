package nl.wur.alterra.cgi.ace.portlet;

import org.junit.Assert;
import org.junit.Test;

public class MeasureUpdateHelperForSharedMeasureTest {

    /**
     * There is an intention in escapeName to cut the string at 75 characters for the database,
     * but due to a coding error the full string is returned.
     */
    @Test
    public void simpleInit() {
        String str = "X !$1234567890'(){[]}:,<=>\"#&?;*~ abcdefghijklmnopqrstuvwxyz Ηλέκτρα€/\\X";
        String res = MeasureUpdateHelperForSharedMeasure.escapeName(str);
        //System.out.println(res);
        Assert.assertEquals("X !$1234567890-()---------------- abcdefghijklmnopqrstuvwxyz Ηλέκτρα€--X", res);
    }
}
