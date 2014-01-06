<%--
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
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@include file="/html/init.jsp" %>

<liferay-ui:success key="project-added" message="project-added-successfully" />
<liferay-ui:success key="project-updated" message="project-updated-successfully" />
<liferay-ui:success key="project-deleted" message="project-deleted-successfully" />
<liferay-ui:error key="none-selected" message="none-selected" />
<liferay-ui:error key="project-delete-tech-error" message="project-delete-tech-error" />

<%
    String redirectUrl = PortalUtil.getCurrentURL(renderRequest);
    String orderByCol = ParamUtil.getString(request, Constants.ORDERBYCOL);
    String orderByType = ParamUtil.getString(request, Constants.ORDERBYTYPE);

    // Process order-by-column.
    if (Validator.isNotNull(orderByCol)) {
        renderRequest.getPortletSession().setAttribute(Constants.ORDERBYCOL, orderByCol );
    } else {
        orderByCol = (String) renderRequest.getPortletSession().getAttribute(Constants.ORDERBYCOL);
    }

    // Process order-by-type.
    if (Validator.isNotNull(orderByType)) {
        renderRequest.getPortletSession().setAttribute(Constants.ORDERBYTYPE, orderByType );
    } else {
        orderByType = (String) renderRequest.getPortletSession().getAttribute(Constants.ORDERBYTYPE);
    }

    // Further processing of order-by-column and order-by-type.
    if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
        renderRequest.getPortletSession().setAttribute(Constants.ORDERBYCOL, orderByCol );
        renderRequest.getPortletSession().setAttribute(Constants.ORDERBYTYPE, orderByType );
    } else {
        orderByCol = prefs.getValue(Constants.ORDERBYCOL, "acronym");
        orderByType = prefs.getValue(Constants.ORDERBYTYPE, "asc");
        renderRequest.getPortletSession().setAttribute(Constants.ORDERBYCOL, orderByCol );
        renderRequest.getPortletSession().setAttribute(Constants.ORDERBYTYPE, orderByType );
    }

    // Yet further processing of order-by-column and order-by-type.
    orderByCol = (String) renderRequest.getPortletSession().getAttribute(Constants.ORDERBYCOL);
    orderByType = (String) renderRequest.getPortletSession().getAttribute(Constants.ORDERBYTYPE);

    // Set the order-by comparator.
    OrderByComparator orderByComparator = ProjectUtil.getProjectOrderByComparator(orderByCol, orderByType);
%>

<%-- Prepare action URL for the projectsForm. "projectsFormSubmitted" is the name of the event to be handled. --%>
<portlet:actionURL name="projectsFormSubmitted" var="projectsFormActionUrl"/>

<%-- Start projectsForm. --%>
<aui:form name="projectsForm" action="<%=projectsFormActionUrl%>" method="post">

<%-- Main action buttons for operations with projects. --%>
<aui:button-row>

    <%-- Prepare URL for the link to the page where a new project can be added. --%>
    <portlet:renderURL var="addProjectURL">
        <portlet:param name="jspPage" value="/html/project/edit_project.jsp" />
        <portlet:param name="redirect" value="<%=redirectUrl%>" />
    </portlet:renderURL>

    <%-- Display the button that links to the page where a new project can be added. --%>
    <!--<aui:button value="Add" onClick="<%= //addProjectURL.toString() %>"/>-->

    <%--
    Submits projectsForm. In order to get submit value at server side, had to override the
    button's onClick which sets the value to a hidden input.
    --%>
   <aui:button type="submit" value="Delete" onClick="this.form.elements['submitAction'].value='delete';return confirm('Are you sure you want to delete the selected projects? Click OK to continue, otherwise choose Cancel.');"/>
    <input name="submitAction" type="hidden"/>

</aui:button-row>

<%-- Measures search results container. --%>
<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "75")) %>' emptyResultsMessage="project-empty-results-message" orderByCol="<%= orderByCol %>" orderByType="<%= orderByType %>">

    <liferay-ui:search-container-results
        results="<%= ProjectLocalServiceUtil.getProjectsByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd(), orderByComparator) %>"
        total="<%= ProjectLocalServiceUtil.getProjectsCountByGroupId(scopeGroupId) %>"
    />

    <liferay-ui:search-container-row
        className="nl.wur.alterra.cgi.ace.model.Project"
        keyProperty="projectId"
        modelVar="project" escapedModel="true"
    >

	    <%--
	    escapedModel="true"  is needed in order to escape the acronym
	    which is accessed by < %= project.getAcronym() % >

	    better alternative: als access the acronym by property="acronym"
	    properties always get escaped
	    --%>

	    <%
	    String projectViewLink = "<a href='/projects1?ace_project_id=" + project.getProjectId() + "'>" +  project.getAcronym() + "</a>" ;
	    String projectSectorsStr = project.getSectors().replace(";","; ");
	    String projectElementsStr = project.getElement().replace(";","; ");
	    String projectStatusDispValue = (project.getControlstatus()<ACEIndexUtil.Status_APPROVED ? (project.getControlstatus()==ACEIndexUtil.Status_SUBMITTED ? "Submitted" : "Draft") : "Approved");

	    if (project.getReplacesId() !=  project.getProjectId()){ %>
            <liferay-ui:search-container-column-jsp align="right" path="/html/project/project_selector.jsp"/><%
        }
	    else{ %>
            <liferay-ui:search-container-column-text>&nbsp;</liferay-ui:search-container-column-text><%
        }
	    %>

        <liferay-ui:search-container-column-text name="projectId" orderable="true" orderableProperty="projectId" >
            <%=project.getProjectId()%>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="acronym" orderable="true" orderableProperty="acronym" >
            <%=projectViewLink%>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="title" property="title"/>

        <liferay-ui:search-container-column-text name="status" orderable="true" orderableProperty="controlstatus" >
            <%=projectStatusDispValue%>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="source" orderable="true" orderableProperty="source" >
            <%=project.getSource()%>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="sectors" value="<%=projectSectorsStr%>"/>

        <liferay-ui:search-container-column-text name="elements" value="<%= projectElementsStr %>"/>

    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />

</liferay-ui:search-container>

<%-- End projectsForm. --%>
</aui:form>