/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

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
