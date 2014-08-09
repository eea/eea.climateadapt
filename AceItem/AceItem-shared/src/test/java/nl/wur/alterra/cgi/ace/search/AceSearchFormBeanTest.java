package nl.wur.alterra.cgi.ace.search;

import org.junit.Assert;
import org.junit.Test;

public class AceSearchFormBeanTest {

    @Test
    public void simpleInit() {
        AceSearchFormBean bean = new AceSearchFormBean();

        bean.setFreetextMode("2");
        FreetextMode ftm = bean.getFreeTextMode(); // Yes, it is spelled differently from setFreetextMode
        Assert.assertEquals(FreetextMode.ALL, ftm);
    }
}
