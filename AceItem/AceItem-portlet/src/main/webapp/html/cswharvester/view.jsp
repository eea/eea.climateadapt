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

<%@include file="/html/init.jsp" %>

<liferay-ui:success key="harvester-added" message="harvester-added-successfully" />
<liferay-ui:success key="harvester-updated" message="harvester-updated-successfully" />
<liferay-ui:success key="harvester-deleted" message="harvester-deleted-successfully" />
<liferay-ui:error key="cannot-execute-nongeo-harvester" message="cannot-execute-nongeo-harvester"/>
<liferay-ui:error key="none-selected" message="none-selected" />

<%
    String redirectUrl = PortalUtil.getCurrentURL(renderRequest);
%>

<%-- Prepare action URL for the harvestersForm. "harvestersFormSubmitted" is the name of the event to be handled. --%>
<portlet:actionURL name="harvestersFormSubmitted" var="harvestersFormActionUrl"/>

<%-- Start harvestersForm. --%>
<aui:form name="harvestersForm" action="<%=harvestersFormActionUrl%>" method="post">

<%-- Action buttons for operations with harvesters. --%>
<aui:button-row>

    <%-- Prepare URL for the link to the page where a new harvester can be added. --%>
    <portlet:renderURL var="addCSWHarvesterURL">
        <portlet:param name="jspPage" value="/html/cswharvester/edit_cswharvester.jsp" />
        <portlet:param name="redirect" value="<%= redirectUrl %>" />
    </portlet:renderURL>

    <%-- Display the button that links to the page where a new harvester can be added. --%>
    <aui:button value="Add" onClick="<%= addCSWHarvesterURL.toString() %>"/>

    <%--
    Submit buttons for harvestersForm. In order to get submit value at server side, had to override the
    button's onClick which sets the value to a hidden input.
    --%>
    <aui:button type="submit" value="Delete" onClick="this.form.elements['submitAction'].value='delete';return confirm('Are you sure you want to delete the selected harvesters? Click OK to continue, otherwise choose Cancel.');"/>
    <aui:button type="submit" value="Execute" onClick="this.form.elements['submitAction'].value='execute';return confirm('Are you sure you want to execute the selected harvesters? Click OK to continue, otherwise choose Cancel.');"/>
    <input name="submitAction" type="hidden"/>

</aui:button-row>

<%-- Harvesters search results container. --%>
<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "10")) %>' emptyResultsMessage="cswHarvester-empty-results-message">
    <liferay-ui:search-container-results
        results="<%= CSWHarvesterLocalServiceUtil.getCSWHarvestersByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
        total="<%= CSWHarvesterLocalServiceUtil.getCSWHarvestersCountByGroupId(scopeGroupId) %>"
    />

    <liferay-ui:search-container-row
        className="nl.wur.alterra.cgi.ace.model.CSWHarvester"
        keyProperty="cswharvesterid"
        modelVar="cswHarvester" escapedModel="true"
    >

        <%--
        escapedModel="true"  is needed in order to escape the acronym
        which is accessed by < %= aceitem.getAcronym() % >

        better alternative: als access the acronym by property="acronym"
        properties always get escaped
        --%>

        <%
        String availableInGeoNetwork = (cswHarvester.getSavedToGeoNetwork() ? "Yes" : "No");
        String status = cswHarvester.getStatus();
        String urlDisplayValue = cswHarvester.getUrl();
        if (urlDisplayValue.length() > 70){
            urlDisplayValue = urlDisplayValue.substring(0,70) + "...";
        }
        String checkBoxName = CSWHarvesterPortlet.SUBMITTED_CSW_HARVESTER_ID_PREFIX + cswHarvester.getCswharvesterid();
        %>

        <portlet:renderURL var="cswHarvesterEditUrl">
            <portlet:param name="jspPage" value="/html/cswharvester/edit_cswharvester.jsp" />
            <portlet:param name="cswharvesterid" value="<%=String.valueOf(cswHarvester.getCswharvesterid())%>"/>
            <portlet:param name="redirect" value="<%=redirectUrl%>"/>
        </portlet:renderURL>

        <liferay-ui:search-container-column-text>
            <liferay-ui:input-checkbox param="<%=checkBoxName%>"/>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="name" orderable="true" orderableProperty="name">
            <aui:a href="<%=cswHarvesterEditUrl.toString()%>"><%=cswHarvester.getName()%></aui:a>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="url">
            <span title="<%=cswHarvester.getUrl()%>"><%=urlDisplayValue%></span>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="Available in GeoNetwork" value="<%=availableInGeoNetwork%>" align="center"/>

        <liferay-ui:search-container-column-text name="Harvest method" align="center">
            <% if(cswHarvester.getEvery() == 0) { %>
                <img id="harvester-manual" src="<%=renderRequest.getContextPath()%>/images/icons/harvester-manual.png" alt="Manual harvester execution" title="Manual harvester execution"/>
            <% } else { %>
                <img id="harvester-scheduled" src="<%=renderRequest.getContextPath()%>/images/icons/harvester-scheduled.png" alt="Automatic harvester execution" title="Automatic harvester execution"/>
            <% } %>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="Status" align="center">
            <% if(status.equals("NEVER_RUN") || status.equals("GEONETWORK_GET_SUCCESS")) { %>
                <img id="harvester-status" src="<%=renderRequest.getContextPath()%>/images/icons/harvester-never-run.png" alt="Waiting for first run" title="Waiting for first run"/>
            <% } else if(status.equals("RUNNING")) { %>
                <img id="harvester-status" src="<%=renderRequest.getContextPath()%>/images/icons/harvester-running.png" alt="Running" title="Running"/>
            <% } else if(status.equals("SUCCESS")) { %>
                <img id="harvester-status" src="<%=renderRequest.getContextPath()%>/images/icons/harvester-run-success.png" alt="Succesfully run" title="Succesfully run"/>
            <% } else { %>
                <img id="harvester-status" src="<%=renderRequest.getContextPath()%>/images/icons/harvester-run-failure.png" alt="Error: status is <%=status%>" title="Error: status is <%=status%>"/>
            <% } %>
        </liferay-ui:search-container-column-text>

    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />

</liferay-ui:search-container>

<%-- End harvestersForm. --%>
</aui:form>