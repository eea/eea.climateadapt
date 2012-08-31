<%
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
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@include file="/html/init.jsp" %>

<%
String currentUrl = PortalUtil.getCurrentURL(renderRequest);
java.util.List<Project> regionProjects = new java.util.ArrayList<Project>();

List<Project> projects = ProjectLocalServiceUtil.getProjectsByGroupId(scopeGroupId);
for (Project project : projects){
    if (ProjectUtil.projectMatchesTransRegionUrl(project, currentUrl)){
        regionProjects.add(project);
    }

}

boolean canAddProject = renderRequest.isUserInRole("Portal Content Reviewer") ||
renderRequest.isUserInRole("administrator") || renderRequest.isUserInRole("power-user") || renderRequest.isUserInRole("Writer");

%>
<div class="detailright">

    <H6>Projects related to this region:</H6>

    <%
    if (!regionProjects.isEmpty()){ %>
        <ul>
            <%
            for (Project regionProject : regionProjects){ %>
                <li>
                    <span class="bolder">
                        <a href="/projects1?ace_project_id=<%=regionProject.getProjectId()%>"><strong><%=regionProject.getTitle()%></strong></a>
                    </span> - <%=ProjectUtil.truncateWithDots(regionProject.getAbstracts(), 180)%>
                </li><%
            }
            %>
        </ul><%
    }
    %>

    <%
    if (canAddProject){ %>
	    <a href="/en/web/guest/projects?p_p_id=projectportlet_WAR_Projectportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_projectportlet_WAR_Projectportlet_jspPage=%2Fhtml%2Fproject%2Fedit_project.jsp&_projectportlet_WAR_Projectportlet_redirect=<%=currentUrl.replace("/","%2F")%>">
	        Add new project ...
	    </a><%
	    }
    %>

</div>
<div style="clear: both"> </div>
