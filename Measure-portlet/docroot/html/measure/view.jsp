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

<%@include file="/html/init.jsp"%>

<liferay-ui:success key="measure-added" message="measure-added-successfully" />
<liferay-ui:success key="measure-updated" message="measure-updated-successfully" />
<liferay-ui:success key="measure-deleted" message="measure-deleted-successfully" />
<liferay-ui:error key="none-selected" message="none-selected" />
<liferay-ui:error key="measure-delete-tech-error" message="measure-delete-tech-error" />

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
        orderByCol = prefs.getValue(Constants.ORDERBYCOL, "name");
        orderByType = prefs.getValue(Constants.ORDERBYTYPE, "asc");
        renderRequest.getPortletSession().setAttribute(Constants.ORDERBYCOL, orderByCol );
        renderRequest.getPortletSession().setAttribute(Constants.ORDERBYTYPE, orderByType );
    }

    // Yet further processing of order-by-column and order-by-type.
    orderByCol = (String) renderRequest.getPortletSession().getAttribute(Constants.ORDERBYCOL);
    orderByType = (String) renderRequest.getPortletSession().getAttribute(Constants.ORDERBYTYPE);

    // Set the order-by comparator.
    OrderByComparator orderByComparator = MeasureUtil.getMeasureOrderByComparator(orderByCol, orderByType);
%>

<%-- Prepare action URL for the measuresForm. "measuresFormSubmitted" is the name of the event to be handled. --%>
<portlet:actionURL name="measuresFormSubmitted" var="measuresFormActionUrl"/>

<%-- Start measuresForm. --%>
<aui:form name="measuresForm" action="<%=measuresFormActionUrl%>" method="post">

<%-- Main action buttons for operations with ace items. --%>
<aui:button-row>
    <%-- Display the button that links to the page where a new ace item can be added. --%>
    <aui:button value="Add" onClick="/share-your-info"/>
    
   <%--
    Submits measuresForm. In order to get submit value at server side, had to override the
    button's onClick which sets the value to a hidden input.
    --%>
    <aui:button type="submit" value="Delete" onClick="this.form.elements['submitAction'].value='delete';return confirm('Are you sure you want to delete the selected measures? Click OK to continue, otherwise choose Cancel.');"/>
    <input name="submitAction" type="hidden"/>  

</aui:button-row>

<%-- Measures search results container. --%>
<liferay-ui:search-container delta='<%=GetterUtil.getInteger(prefs.getValue("rowsPerPage", "75"))%>' emptyResultsMessage="measure-empty-results-message" orderByCol="<%=orderByCol%>" orderByType="<%=orderByType%>">

    <liferay-ui:search-container-results
        results="<%=MeasureLocalServiceUtil.getMeasuresByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd(), orderByComparator)%>"
        total="<%=MeasureLocalServiceUtil.getMeasuresCountByGroupId(scopeGroupId)%>"
    />

    <liferay-ui:search-container-row
        className="nl.wur.alterra.cgi.ace.model.Measure"
        keyProperty="measureId"
        modelVar="measure" escapedModel="true"
    >

        <%--
        escapedModel="true"  is needed in order to escape the acronym
        which is accessed by < %= measure.getAcronym() % >

        better alternative: als access the acronym by property="acronym"
        properties always get escaped
        --%>

        <%
        String measureViewLink = "<a href='/viewmeasure?ace_measure_id=" + measure.getMeasureId() + "'>" +  measure.getName() + "</a>" ;
        String measureSectorsStr = measure.getSectors_().replace(";","; ");
        String measureImpactsStr = measure.getClimateimpacts_().replace(";","; ");
        String measureStatusDispValue = (measure.getControlstatus()<ACEIndexUtil.Status_APPROVED ? (measure.getControlstatus()==ACEIndexUtil.Status_SUBMITTED ? "Submitted" : "Draft") : "Approved");

        String measureType = "Adaptation option";
        if( measure.getMao_type().equalsIgnoreCase("A")) {
            measureType = "Case study";
        }

        // Only editable if no candidate item exists for this measure.
        if (measure.getReplacesId() !=  measure.getMeasureId()){ %>
             <liferay-ui:search-container-column-jsp align="right" path="/html/measure/measure_selector.jsp"/><%
           }
        else{ %>
            <liferay-ui:search-container-column-text>&nbsp;</liferay-ui:search-container-column-text><%
        }
        %>

        <liferay-ui:search-container-column-text name="measureId" orderable="true" orderableProperty="measureId">
            <%=measure.getMeasureId()%>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="name" orderable="true" orderableProperty="name">
            <%=measureViewLink%>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="status" orderable="true" orderableProperty="controlstatus">
          <%=measureStatusDispValue%>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="source" orderable="true" orderableProperty="source">
            <%=measure.getSource().replaceAll("&lt;p&gt;", "").replaceAll("&lt;/p&gt;", "")%>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="sectors" value="<%=measureSectorsStr%>"/>

        <liferay-ui:search-container-column-text name="impacts" value="<%=measureImpactsStr%>"/>

        <liferay-ui:search-container-column-text name="lon" value='<%="" + measure.getLon()%>'/>

        <liferay-ui:search-container-column-text name="type" orderable="true" orderableProperty="type" value="<%=measureType%>"/>

    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />

</liferay-ui:search-container>

<%-- End measuresForm. --%>
</aui:form>