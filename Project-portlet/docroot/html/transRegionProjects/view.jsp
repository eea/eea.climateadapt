<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="org.apache.commons.lang.math.NumberUtils"%>
<%@page import="nl.wur.alterra.cgi.ace.search.AceItemSearchResult"%>
<%@page import="nl.wur.alterra.cgi.ace.portlet.TransRegionProjectsPortlet"%>
<%@page import="nl.wur.alterra.cgi.ace.search.ACESearchEngine"%>
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
int pageSize = 3;

List<Project> regionProjects = (List<Project>) request.getAttribute(TransRegionProjectsPortlet.REGION_PROJECTS);
int projectsTotal = regionProjects==null ? 0 : regionProjects.size();
int prjPages = Double.valueOf(Math.ceil((double)projectsTotal / (double)pageSize)).intValue();
int prjPage = NumberUtils.toInt(request.getParameter("prjPage"), 1);
prjPage = Math.min(Math.max(prjPage, 1), prjPages);

List<AceItemSearchResult> regionOrganisations = (List<AceItemSearchResult>) request.getAttribute(TransRegionProjectsPortlet.REGION_ORGANISATIONS);
int organisationsTotal = regionOrganisations==null ? 0 : regionOrganisations.size();
int orgPages = Double.valueOf(Math.ceil((double)organisationsTotal / (double)pageSize)).intValue();
int orgPage = NumberUtils.toInt(request.getParameter("orgPage"), 1);
orgPage = Math.min(Math.max(orgPage, 1), orgPages);

//Get the wished page of projects.
if (prjPages > 1){
    int fromIndex = (prjPage-1) * pageSize;
    int toIndex = Math.min(fromIndex + pageSize, projectsTotal);
    regionProjects = regionProjects.subList(fromIndex, toIndex);
}

//Get the wished page of organisations.
if (orgPages > 1){
    int fromIndex = (orgPage-1) * pageSize;
    int toIndex = Math.min(fromIndex + pageSize, organisationsTotal);
    regionOrganisations = regionOrganisations.subList(fromIndex, toIndex);
}

boolean canAddNew = renderRequest.isUserInRole("Portal Content Reviewer") ||
renderRequest.isUserInRole("administrator") || renderRequest.isUserInRole("power-user") || renderRequest.isUserInRole("Writer");
%>

<portlet:renderURL var="prevProjectsLink">
 <portlet:param name="prjPage" value="<%=String.valueOf(prjPage - 1)%>"/>
 <portlet:param name="orgPage" value="<%=String.valueOf(orgPage)%>"/>
</portlet:renderURL>
<portlet:renderURL var="nextProjectsLink">
 <portlet:param name="prjPage" value="<%=String.valueOf(prjPage + 1)%>"/>
    <portlet:param name="orgPage" value="<%=String.valueOf(orgPage)%>"/>
</portlet:renderURL>
<portlet:renderURL var="prevOrganisationsLink">
    <portlet:param name="orgPage" value="<%=String.valueOf(orgPage - 1)%>"/>
    <portlet:param name="prjPage" value="<%=String.valueOf(prjPage)%>"/>
</portlet:renderURL>
<portlet:renderURL var="nextOrganisationsLink">
    <portlet:param name="orgPage" value="<%=String.valueOf(orgPage + 1)%>"/>
    <portlet:param name="prjPage" value="<%=String.valueOf(prjPage)%>"/>
</portlet:renderURL>

<div style="width:250px">

    <div>
        <span class="section_title">&#9658; Projects (<%=projectsTotal%>)</span>
        <%
        if (regionProjects!=null && !regionProjects.isEmpty()){ %>
            <ul>
                <%
                for (Project regionProject : regionProjects){ %>
                    <li style="font-size:0.9em">
                        <span class="bolder">
                            <a href="/projects1?ace_project_id=<%=regionProject.getProjectId()%>"><strong><%=regionProject.getTitle()%></strong></a>
                        </span> - <%=ProjectUtil.truncateWithDots(regionProject.getAbstracts(), 100)%>
                    </li><%
                }
                %>
            </ul>
            <%
            if (prjPages > 1){
                String prevHref = prjPage > 1 ? prevProjectsLink : "javascript:;";
                String prevStyle = prjPage > 1 ? "" : "style=\"text-decoration:none;\"";

                String nextHref = prjPage < prjPages ? nextProjectsLink : "javascript:;";
                String nextStyle = prjPage < prjPages ? "" : "style=\"text-decoration:none;\"";
                %>
                <div style="text-align:right">
                    <a href="<%=prevHref%>" class="prevnext" <%=prevStyle%>>prev</a>&nbsp;|&nbsp;<a href="<%=nextHref%>" class="prevnext" <%=nextStyle%>>next</a>
                </div><%
            }
        }
        %>
    </div>
    <div>
        <span class="section_title">&#9658; Organisations (<%=organisationsTotal%>)</span>
        <%
        if (regionOrganisations!=null && !regionOrganisations.isEmpty()){ %>
            <ul>
                <%
                for (AceItemSearchResult regionOrganisation : regionOrganisations){ %>
                    <li style="font-size:0.9em">
                        <span class="bolder">
                            <a href="/viewaceitem?aceitem_id=<%=regionOrganisation.getAceItemId()%>"><strong><%=regionOrganisation.getName()%></strong></a>
                        </span> - <%=ProjectUtil.truncateWithDots(regionOrganisation.getShortdescription(), 100)%>
                    </li><%
                }
                %>
            </ul>
            <%
            if (orgPages > 1){
                String prevHref = orgPage > 1 ? prevOrganisationsLink : "javascript:;";
                String prevStyle = orgPage > 1 ? "" : "style=\"text-decoration:none;\"";

                String nextHref = orgPage < orgPages ? nextOrganisationsLink : "javascript:;";
                String nextStyle = orgPage < orgPages ? "" : "style=\"text-decoration:none;\"";
                %>
                <div style="text-align:right">
                    <a href="<%=prevHref%>" class="prevnext" <%=prevStyle%>>prev</a>&nbsp;|&nbsp;<a href="<%=nextHref%>" class="prevnext" <%=nextStyle%>>next</a>
                </div><%
            }
        }
        %>
    </div>

</div>
<div style="clear: both"> </div>
