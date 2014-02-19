/**
* Copyright (C) 2013 Permeance Technologies
*
* This program is free software: you can redistribute it and/or modify it under the terms of the
* GNU General Public License as published by the Free Software Foundation, either version 3 of the
* License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* General Public License for more details.
*
* You should have received a copy of the GNU General Public License along with this program. If
* not, see <http://www.gnu.org/licenses/>.
*/

package au.com.permeance.liferay.portal.util;

import au.com.permeance.liferay.portal.kernel.util.PropsKeysExt;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;


/**
 * Property Values Extension.
 * 
 * @author Tim Telcik <tim.telcik@permeance.com.au>
 */
public class PropsValuesExt {
	
	public static boolean LAYOUT_IMPORT_DL_FILE_NAME_NORMALIZATION_ENABLED = GetterUtil.getBoolean(PropsUtil.get(PropsKeysExt.LAYOUT_IMPORT_DL_FILE_NAME_NORMALIZATION_ENABLED),true);
	
	public static boolean VERIFY_DL_FILE_NAME_NORMALIZATION_ENABLED = GetterUtil.getBoolean(PropsUtil.get(PropsKeysExt.VERIFY_DL_FILE_NAME_NORMALIZATION_ENABLED),true);
	
	public static int VERIFY_DL_FILE_NAME_NORMALIZATION_MAX_LIST_PAGE_SIZE = GetterUtil.getInteger(PropsUtil.get(PropsKeysExt.VERIFY_DL_FILE_NAME_NORMALIZATION_MAX_LIST_PAGE_SIZE), 50);

}
