package nl.wur.alterra.cgi.ace.portlet;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import nl.wur.alterra.cgi.ace.model.AceItem;
import nl.wur.alterra.cgi.ace.search.lucene.ACEIndexSynchronizer;
import nl.wur.alterra.cgi.ace.service.AceItemLocalServiceUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 *
 *
 * @author Andres Säde
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        ConfigurationFactoryUtil.class,
        PortalUtil.class,
        SessionErrors.class,
        AceItemValidator.class,
        AceItemLocalServiceUtil.class})
public class AceItemPortletTest {

    @InjectMocks
    private AceItemPortlet portlet = new AceItemPortlet();

    @Mock
    private ActionRequest request;

    @Mock
    private ActionResponse response;

    @Mock
    private Company company;

    @Mock
    private ThemeDisplay theme;

    @Mock
    private Configuration configuration;

    @Mock
    private AceItem aceItem;

    @Mock
    private ACEIndexSynchronizer ACEIndexSynchronizer;


    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks( this );

        PowerMockito.mockStatic( ConfigurationFactoryUtil.class );
        PowerMockito.mockStatic( PortalUtil.class );
        PowerMockito.mockStatic( SessionErrors.class );
        PowerMockito.mockStatic( AceItemLocalServiceUtil.class );

        when( theme.getCompany() ).thenReturn( company );
        when( request.getAttribute( WebKeys.THEME_DISPLAY ) ).thenReturn( theme );
        when( ConfigurationFactoryUtil.getConfiguration( any( ClassLoader.class ), anyString() ) ).thenReturn( configuration );
        when( AceItemLocalServiceUtil.getAceItem( anyLong() ) ).thenReturn( aceItem );
    }


    @Test
    public void testAddAceItem_NameNotPresent() throws Exception {

        portlet.addAceItem( request, response );

        // user should stay on same page
        verify( response, atLeastOnce() ).setRenderParameter( "jspPage", "/html/aceitem/edit_aceitem.jsp" );

        // verify that error message is set
        PowerMockito.verifyStatic( atLeastOnce() );
        SessionErrors.add( eq( request ), eq( "aceitemname-required" ) );

    }


    @Test
    public void testAddAceItem_NamePresents() throws Exception {

        // return name parameter from "request"
        when( request.getParameter( "name" ) ).thenReturn( "Ace item fake name" );

        portlet.addAceItem( request, response );

        // verify that there is no more error message about missing name attribute
        PowerMockito.verifyStatic( never() );
        SessionErrors.add( eq( request ), eq( "aceitemname-required" ) );

    }


    @Test
    public void testAddAceItem_success() throws Exception {

        final Map<String, String> requestParams = new HashMap<String, String>();
        requestParams.put( "aceItemId", "0" );
        requestParams.put( "checkcreationdate", "checkcreationdate" );
        requestParams.put( "wxsharvesterId", "wxsharvesterId" );
        requestParams.put( "name", "name" );
        requestParams.put( "description", "description" );
        requestParams.put( "specialtagging", "specialtagging" );
        requestParams.put( "chk_importance", "chk_importance" );
        requestParams.put( "chk_controlstatus", "1" );
        requestParams.put( "feature", "feature" );

        when( request.getParameter( anyString() ) ).thenAnswer( new Answer<String>() {
            @Override
            public String answer( InvocationOnMock invocationOnMock ) throws Throwable {
                Object[] args = invocationOnMock.getArguments();
                return requestParams.get( args[0] );
            }
        } );

        PowerMockito.mockStatic( AceItemValidator.class );

        // skip validation to check successful request
        when( AceItemValidator.validateAceItem( any( AceItem.class ), anyList() ) ).thenReturn( true );

        portlet.addAceItem( request, response );

        // verify that LiferayPortlet.sendRedirect called = successful request
        verify( request, atLeastOnce() ).getParameter( "redirect" );

        // verify that SessionErrors.add() not called
        PowerMockito.verifyStatic( never() );
        SessionErrors.add( eq( request ), anyString() );

    }
}
