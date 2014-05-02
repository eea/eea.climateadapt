package nl.wur.alterra.cgi.ace.portlet;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.configuration.Filter;
import com.liferay.portal.util.InitUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Properties;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 *
 *
 * @author Andres Säde
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ConfigurationFactoryUtil.class})
public class AceItemPortletTest {

    private AceItemPortlet portlet = new AceItemPortlet();

    @Mock
    private ActionRequest request;
    @Mock
    private ActionResponse response;

    @Before
    public void init() {
        System.setProperty("catalina.base", ".");
        System.setProperty("external-properties", "portal-test.properties");
        MockitoAnnotations.initMocks( this );
        //InitUtil.initWithSpring();
    }

    @Test
    public void testAddAceItem() {

//        PowerMockito.mockStatic( ConfigurationFactoryUtil.class );
//        when( ConfigurationFactoryUtil.getConfiguration( any( ClassLoader.class ), anyString() ) ).thenReturn( new Configuration() {
//
//            @Override
//            public void addProperties( Properties properties ) {
//
//            }
//
//            @Override
//            public void clearCache() {
//
//            }
//
//            @Override
//            public boolean contains( String s ) {
//                return false;
//            }
//
//            @Override
//            public String get( String s ) {
//                return null;
//            }
//
//            @Override
//            public String get( String s, Filter filter ) {
//                return null;
//            }
//
//            @Override
//            public String[] getArray( String s ) {
//                return new String[0];
//            }
//
//            @Override
//            public String[] getArray( String s, Filter filter ) {
//                return new String[0];
//            }
//
//            @Override
//            public Properties getProperties() {
//                return null;
//            }
//
//            @Override
//            public Properties getProperties( String s, boolean b ) {
//                return null;
//            }
//
//            @Override
//            public void removeProperties( Properties properties ) {
//
//            }
//
//            @Override
//            public void set( String s, String s2 ) {
//
//            }
//        } );

        //portlet.addAceItem( request, response );

    }
}
