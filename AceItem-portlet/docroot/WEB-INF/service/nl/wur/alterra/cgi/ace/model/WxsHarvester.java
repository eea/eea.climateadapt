package nl.wur.alterra.cgi.ace.model;

/**
 * The model interface for the WxsHarvester service. Represents a row in the &quot;Ace_WxsHarvester&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. All methods that expect a wxs harvester model instance should use the {@link WxsHarvester} interface instead.
 * </p>
 *
 * @author groot052
 * @see WxsHarvesterModel
 * @see nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterImpl
 * @see nl.wur.alterra.cgi.ace.model.impl.WxsHarvesterModelImpl
 * @generated
 */
public interface WxsHarvester extends WxsHarvesterModel {
    /**
    * heikki doeleman: Liferay won't let me override toString(), because if I do that it generates 2 declarations of toString()
    * in WxsHarvesterCpl, which does not compile. Thanks Liferay !
    *
    * @return shorter string than toString()
    */
    public java.lang.String toShortString();
}
