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
 * The model interface for the CSWHarvester service. Represents a row in the &quot;Ace_CSWHarvester&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. All methods that expect a c s w harvester model instance should use the {@link CSWHarvester} interface instead.
 * </p>
 *
 * @author groot052
 * @see CSWHarvesterModel
 * @see nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterImpl
 * @see nl.wur.alterra.cgi.ace.model.impl.CSWHarvesterModelImpl
 * @generated
 */
public interface CSWHarvester extends CSWHarvesterModel {
	/**
	* heikki doeleman: Liferay won't let me override toString(), because if I do that it generates 2 declarations of toString()
	* in CSWHarvesterCpl, which does not compile. Thanks Liferay !
	*
	* @return shorter string than toString()
	*/
	public java.lang.String toShortString();
}