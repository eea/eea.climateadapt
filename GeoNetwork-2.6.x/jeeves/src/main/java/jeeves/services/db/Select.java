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

package jeeves.services.db;

import java.util.*;

import org.jdom.*;

import jeeves.constants.*;
import jeeves.interfaces.*;
import jeeves.resources.dbms.*;
import jeeves.server.*;
import jeeves.server.context.*;

//=============================================================================

/** Performs a generic query
  */

public class Select implements Service
{
	private String dbName;
	private String query;
	private Vector inFields;
	private Vector outFields;

	//--------------------------------------------------------------------------
	//---
	//--- Init
	//---
	//--------------------------------------------------------------------------

	public void init(String appPath, ServiceConfig params) throws Exception
	{
		dbName = params.getMandatoryValue(Jeeves.Config.DB);
		query  = params.getMandatoryValue(Jeeves.Config.QUERY);
		Iterator i = params.getChildren(Jeeves.Config.IN_FIELDS, Jeeves.Config.FIELD);

		inFields = new Vector();
		if (i != null)
			while (i.hasNext())
				inFields.add(i.next());

		i = params.getChildren(Jeeves.Config.OUT_FIELDS, Jeeves.Config.FIELD);
		outFields = new Vector();
		if (i != null)
			while (i.hasNext())
				outFields.add(i.next());
	}

	//--------------------------------------------------------------------------
	//---
	//--- Service
	//---
	//--------------------------------------------------------------------------

	public Element exec(Element params, ServiceContext context) throws Exception
	{
		Dbms    dbms   = (Dbms) context.getResourceManager().open(dbName);
		Vector  vArgs  = DBUtils.scanInFields(params, inFields, null, dbms);
		Hashtable formats = DBUtils.scanOutFields(outFields);
		return dbms.selectFull(query, formats, vArgs.toArray());
	}
}

//=============================================================================

