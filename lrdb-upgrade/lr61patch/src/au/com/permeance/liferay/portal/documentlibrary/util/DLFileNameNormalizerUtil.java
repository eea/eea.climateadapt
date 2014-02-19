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

package au.com.permeance.liferay.portal.documentlibrary.util;

import com.liferay.portal.kernel.security.pacl.permission.PortalRuntimePermission;


/**
 * Document Library File Name Normalizer Utility.
 * 
 * @author Tim Telcik <tim.telcik@permance.com.au>
 * 
 * @see https://issues.liferay.com/browse/LPS-35280
 * @see https://issues.liferay.com/browse/LPS-37869
 */
public class DLFileNameNormalizerUtil {

	public static DLFileNameNormalizer getFileNameNormalizer() {
		PortalRuntimePermission.checkGetBeanProperty(
			DLFileNameNormalizerUtil.class);

		return _dlFileNameNormalizer;
	}

	public static String normalize( String fileName ) {
		return getFileNameNormalizer().normalize( fileName );
	}

	public static String normalize( String fileName, char[] replaceChars ) {
		return getFileNameNormalizer().normalize( fileName, replaceChars );
	}

	public void setFileNameNormalizer( DLFileNameNormalizer fileNameNormalizer ) {

		PortalRuntimePermission.checkSetBeanProperty(getClass());

		_dlFileNameNormalizer = fileNameNormalizer;
	}

	private static DLFileNameNormalizer _dlFileNameNormalizer;

}
