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

import com.liferay.portlet.documentlibrary.util.DLUtil;


/**
 * Document Library Utility Extension.
 * 
 * @author Tim Telcik <tim.telcik@permeance.com.au>
 * 
 * @see DLUtil
 * @see https://issues.liferay.com/browse/LPS-35280
 * @see https://issues.liferay.com/browse/LPS-37869
 */
public class DLUtilExt {
	
	/**
	 * Returns true for a valid file name.
	 * 
	 * @see com.liferay.portlet.documentlibrary.store.DLStoreImpl#validate
	 * @see com.liferay.portlet.documentlibrary.store.DLStoreImpl#isValidName
	 */
	public static boolean isValidFileName(String name) {
		if ((name == null) ||
			name.contains("\\") ||
			name.contains("\\\\") ||
			name.contains("//") ||
			name.contains(":") ||
			name.contains("*") ||
			name.contains("?") ||
			name.contains("\"") ||
			name.contains("<") ||
			name.contains(">") ||
			name.contains("|") ||
			name.contains("[") ||
			name.contains("]") ||
			name.contains("../") ||
			name.contains("/..")) {

			return false;
		}

		return true;
	}
	
	/**
	 * Normalizes the given file name.
	 */
	public static String normalizeFileName( String fileName ) {
		String newFileName = fileName;
		if (fileName != null) {
			newFileName = DLFileNameNormalizerUtil.normalize( fileName );
		}
		return newFileName;
	}
	
}
