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

<liferay-ui:success key="aceitem-added" message="aceitem-added-successfully" />
<liferay-ui:success key="aceitem-updated" message="aceitem-updated-successfully" />
<liferay-ui:success key="aceitem-deleted" message="aceitem-deleted-successfully" />
<liferay-ui:error key="none-selected" message="none-selected" />
<liferay-ui:error key="aceitem-delete-tech-error" message="aceitem-delete-tech-error" />

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
    OrderByComparator orderByComparator = AceItemUtil.getAceItemOrderByComparator(orderByCol, orderByType);
%>

<%-- Prepare action URL for the aceItemsForm. "aceItemsFormSubmitted" is the name of the event to be handled. --%>
<portlet:actionURL name="aceItemsFormSubmitted" var="aceItemsFormActionUrl"/>

<%-- Start aceItemsForm. --%>
<aui:form name="aceItemsForm" action="<%=aceItemsFormActionUrl%>" method="post">

<%-- Main action buttons for operations with ace items. --%>
<aui:button-row>

    <%-- Prepare URL for the link to the page where a new ace item can be added. --%>
    <%-- 
        The addAceItemURL no longer used in this page as the structure of the ace items have been modified and hence the url
        So all the add links would point to the common share-your-info page --%>
	<%-- 
	   <portlet:renderURL var="addAceItemURL">
	        <portlet:param name="jspPage" value="/html/aceitem/edit_aceitem.jsp" />
	        <portlet:param name="redirect" value="<%= redirectUrl %>" />
	    </portlet:renderURL>
    --%>
    
    <%-- Display the button that links to the page where a new ace item can be added. --%>
    <aui:button value="Add" onClick="/share-your-info"/>

    <%-- Submits aceItemsForm. In order to get submit value at server side, had to override the --%>
    <%-- button's onClick which sets the value to a hidden input. --%>
    <aui:button type="submit" value="Delete" onClick="this.form.elements['submitAction'].value='delete';return confirm('Are you sure you want to delete the selected items? Click OK to continue, otherwise choose Cancel.');"/>
    <input name="submitAction" type="hidden"/>

</aui:button-row>

<%-- Ace items search results container. --%>
<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "75")) %>' emptyResultsMessage="aceitem-empty-results-message"  orderByCol="<%=orderByCol%>" orderByType="<%=orderByType%>" >

    <liferay-ui:search-container-results
        results="<%= AceItemLocalServiceUtil.getAceItemsByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd(), orderByComparator) %>"
        total="<%= AceItemLocalServiceUtil.getAceItemsCountByGroupId(scopeGroupId) %>"
    />

    <liferay-ui:search-container-row
        className="nl.wur.alterra.cgi.ace.model.AceItem"
        keyProperty="aceItemId"
        modelVar="aceitem" escapedModel="true">

        <%
        String aceItemViewLink = aceitem.getName() ;
        String aceItemSectorsStr = aceitem.getSectors_().replace(";","; ");
        String aceItemStatusDispValue = (aceitem.getControlstatus() < ACEIndexUtil.Status_APPROVED ? (aceitem.getControlstatus()==ACEIndexUtil.Status_SUBMITTED ? "Submitted" : "Draft") : "Approved");

        // Only these types get viewed by viewaceitem portlet; Ace Serviced Entities have their own portlets
        String storageType = aceitem.getStoragetype();
        
        //DEPRECATED
        //boolean isRelevantStorageType = storageType.equalsIgnoreCase("URL") || storageType.equalsIgnoreCase("MAPLAYER")
          //                   || storageType.equalsIgnoreCase("PLAINMETADATA") || storageType.equalsIgnoreCase("SETOFMAPS");
        boolean isRelevantStorageType = storageType.equalsIgnoreCase("NONE");
        
        if (isRelevantStorageType) {
            aceItemViewLink = "<a href='/viewaceitem?aceitem_id=" + aceitem.getAceItemId() + "'>" +  aceitem.getName() + "</a>" ;
        }

        // Only editable if relevant and not gets replaced.
        boolean isDeleteOrEditAllowed = isRelevantStorageType && aceitem.getReplacesId()!= aceitem.getAceItemId();
        if (isDeleteOrEditAllowed){ %>
             <liferay-ui:search-container-column-jsp align="right" path="/html/aceitem/aceitem_selector.jsp"/><%
           }
        else{ %>
            <liferay-ui:search-container-column-text>&nbsp;</liferay-ui:search-container-column-text><%
        }
        %>

        <liferay-ui:search-container-column-text name="aceItemId" orderable="true" orderableProperty="aceItemId">
            <%=aceitem.getAceItemId()%>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="name" orderable="true" orderableProperty="name">
            <%=aceItemViewLink%>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="status" orderable="true" orderableProperty="controlstatus">
            <%= aceItemStatusDispValue %>
        </liferay-ui:search-container-column-text>

      
        <liferay-ui:search-container-column-text name="source" orderable="true" orderableProperty="source">
            <%=aceitem.getSource().replaceAll("&lt;p&gt;", "").replaceAll("&lt;/p&gt;", "") %>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="sectors_" value="<%=aceItemSectorsStr%>"/>

        <liferay-ui:search-container-column-text name="datatype" orderable="true" orderableProperty="datatype">
            <%= aceitem.getDatatype() %>
        </liferay-ui:search-container-column-text>

    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator/>
<%-- End search results container. --%>
</liferay-ui:search-container>

<%-- Additional actions displayed below the search results. --%>
<aui:button-row>
    <portlet:actionURL name="synchronizeIndex" var="rebuildIndexURL"/>
    <a href="<%=rebuildIndexURL%>">Rebuild index</a>

</aui:button-row>

<%-- End aceItemsForm. --%>
</aui:form>
