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

import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.Normalizer;

import java.util.Arrays;


/**
 * Document Library File Name Normalizer Implementation.
 * 
 * @author Tim Telcik <tim.telcik@permance.com.au>
 * 
 * @see https://issues.liferay.com/browse/LPS-37869
 *
 * @see DLFileNameNormalizer
 * see DLStoreImpl#validate(String, boolean)
 */
public class DLFileNameNormalizerImpl implements DLFileNameNormalizer {

	public String normalize(String fileName) {
		return normalize(fileName, null);
	}

	public String normalize(String fileName, char[] replaceChars) {
		if (Validator.isNull(fileName)) {
			return fileName;
		}

		fileName = GetterUtil.getString(fileName);
		fileName = fileName.toLowerCase();
		fileName = Normalizer.normalizeToAscii(fileName);

		StringBuilder sb = null;

		int index = 0;

		for (int i = 0; i < fileName.length(); i++) {
			char c = fileName.charAt(i);

			if ((Arrays.binarySearch(_REPLACE_CHARS, c) >= 0) ||
				((replaceChars != null) &&
				 ArrayUtil.contains(replaceChars, c))) {

				if (sb == null) {
					sb = new StringBuilder();
				}

				if (i > index) {
					sb.append(fileName.substring(index, i));
				}

				sb.append(CharPool.DASH);
				// sb.append(CharPool.UNDERLINE);

				index = i + 1;
			}
		}

		if (sb != null) {
			if (index < fileName.length()) {
				sb.append(fileName.substring(index));
			}

			fileName = sb.toString();
		}

		while (fileName.indexOf(StringPool.DOUBLE_DASH) >= 0) {
			fileName = StringUtil.replace(
				fileName, StringPool.DOUBLE_DASH, StringPool.DASH);
		}

		return fileName;
	}

	private static final char[] _REPLACE_CHARS;

	static {

		// see DLStoreImpl#isValidName(String)
		char[] replaceChars = new char[] { '\\', '/', ':', '*', '?', '\'', '<',
				'>', '|', '[', ']' };
		
		Arrays.sort(replaceChars);

		_REPLACE_CHARS = replaceChars;
	}

}
