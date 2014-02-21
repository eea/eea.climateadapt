package nl.wur.alterra.cgi.ace.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the CSWHarvester service. Represents a row in the &quot;Ace_CSWHarvester&quot; database table, with each column mapped to a property of this class.
 *
 * @author groot052
 * @see CSWHarvesterModel
 * @see nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterImpl
 * @see nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterModelImpl
 * @generated
 */
public interface CSWHarvester extends CSWHarvesterModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * heikki doeleman: Liferay won't let me override toString(), because if I do that it generates 2 declarations of toString()
    * in CSWHarvesterCpl, which does not compile. Thanks Liferay !
    *
    * @return shorter string than toString()
    */
    public java.lang.String toShortString();
}
