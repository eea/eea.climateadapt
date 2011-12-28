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

package nl.wur.alterra.cgi.ace.model.impl;

import nl.wur.alterra.cgi.ace.model.WxsHarvester;

/**
 * The model implementation for the WxsHarvester service. Represents a row in the &quot;Ace_WxsHarvester&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link nl.wur.alterra.cgi.ace.model.WxsHarvester} interface.
 * </p>
 *
 * <p>
 * Never reference this class directly. All methods that expect a wxs harvester model instance should use the {@link WxsHarvester} interface instead.
 * </p>
 */
public class WxsHarvesterImpl extends WxsHarvesterModelImpl
	implements WxsHarvester {
	public WxsHarvesterImpl() {
	}

    /**
     * heikki doeleman: Liferay won't let me override toString(), because if I do that it generates 2 declarations of toString()
     * in WxsHarvesterCpl, which does not compile. Thanks Liferay !
     *
     * @return shorter string than toString()
     */
    @Override
    public String toShortString() {
        return this.getWxsharvesterid() + " " + this.getName();
    }

}