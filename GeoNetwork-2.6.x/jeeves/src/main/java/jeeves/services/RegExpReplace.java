//=============================================================================
//===	Copyright (C) 2001-2005 Food and Agriculture Organization of the
//===	United Nations (FAO-UN), United Nations World Food Programme (WFP)
//===	and United Nations Environment Programme (UNEP)
//===
//===	This library is free software; you can redistribute it and/or
//===	modify it under the terms of the GNU Lesser General Public
//===	License as published by the Free Software Foundation; either
//===	version 2.1 of the License, or (at your option) any later version.
//===
//===	This library is distributed in the hope that it will be useful,
//===	but WITHOUT ANY WARRANTY; without even the implied warranty of
//===	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//===	Lesser General Public License for more details.
//===
//===	You should have received a copy of the GNU Lesser General Public
//===	License along with this library; if not, write to the Free Software
//===	Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
//===
//===	Contact: Jeroen Ticheler - FAO - Viale delle Terme di Caracalla 2,
//===	Rome - Italy. email: GeoNetwork@fao.org
//==============================================================================

package jeeves.services;

import java.util.*;
import java.util.regex.*;

import org.jdom.*;

import jeeves.interfaces.*;
import jeeves.server.*;
import jeeves.server.context.*;
import jeeves.constants.*;
import jeeves.utils.*;

//=============================================================================

/** This service reads a configuration xml file containint containing
    pattern-replacement pairs and applies all the pairs to each text
    element of the output.
    The configuration is read from xml/regexp.xml and is formatted:
    <regexp>
       <expr pattern="..." replacement="..."/>
    </regexp>
  */

public class RegExpReplace implements Service
{
	private Vector patterns, replacements;

	//--------------------------------------------------------------------------
	//---
	//--- Init
	//---
	//--------------------------------------------------------------------------

	public void init(String appPath, ServiceConfig params) throws Exception
	{
		String  file   = params.getMandatoryValue(Jeeves.Config.FILE);
		Element config = Xml.loadFile(appPath + file);

		patterns     = new Vector();
		replacements = new Vector();

		// read all pattern-replacement pairs
		for (Iterator iter = config.getChildren().iterator(); iter.hasNext(); )
		{
			Element expr        = (Element) iter.next();
			String  pattern     = expr.getAttributeValue(Jeeves.Attr.PATTERN);
			String  replacement = expr.getAttributeValue(Jeeves.Attr.REPLACEMENT);

			patterns.add(Pattern.compile(pattern));
			replacements.add(getRealText(replacement));
		}
	}

	//--------------------------------------------------------------------------
	//---
	//--- Service
	//---
	//--------------------------------------------------------------------------

	public Element exec(Element params, ServiceContext context) throws Exception
	{
		replaceInElement(params);

		return params;
	}

	//--------------------------------------------------------------------------
	//--- replace some entities

	private String getRealText(String text)
	{
		String noLt  = replace(text, "&lt;", "<");
		String noGt  = replace(noLt, "&gt;", ">");
		String noAmp = replace(noGt, "&amp;", "&");

		return noAmp;
	}

	//--------------------------------------------------------------------------

	private String replace(String text, String delim, String replacement)
	{
		StringBuffer    result = new StringBuffer();
		StringTokenizer st     = new StringTokenizer(text, delim, true);

		while (st.hasMoreTokens())
		{
			String token = st.nextToken();

			if (token.equals(delim)) result.append(replacement);
				else                  result.append(token);
		}

		return result.toString();
	}

	//--------------------------------------------------------------------------
	//--- apply all pattern-replacement pairs

	private void replaceInElement(Element e)
	{
		if (e.getChildren().size() != 0)
			for (Iterator iter = e.getChildren().iterator(); iter.hasNext(); )
				replaceInElement((Element)iter.next());
		else
		{
			String text = e.getText();

			for (int i = 0; i < patterns.size(); i++)
			{
				Pattern pattern     = (Pattern)patterns.get(i);
				String  replacement = (String) replacements.get(i);
				Matcher matcher     = pattern.matcher(text);

				text = matcher.replaceAll(replacement);
			}
			e.setText(text);
		}
	}
}

//=============================================================================

