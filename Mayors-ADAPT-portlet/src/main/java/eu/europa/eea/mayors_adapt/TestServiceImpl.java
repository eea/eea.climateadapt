package eu.europa.eea.mayors_adapt;

import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

/**
 * The implementation of the combos remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link eu.europa.eea.mayors_adapt.service.CombosService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eu.europa.eea.mayors_adapt.service.base.CombosServiceBaseImpl
 * @see eu.europa.eea.mayors_adapt.service.CombosServiceUtil
 */
@JSONWebService
public class TestServiceImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * eu.europa.eea.mayors_adapt.service.CombosServiceUtil} to access the
	 * combos remote service.
	 */
	public int getValue()
			throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return 1;
	}
}
