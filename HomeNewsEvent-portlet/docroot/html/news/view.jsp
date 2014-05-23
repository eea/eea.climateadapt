<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

<c:choose>
	 <c:when test="${showall ne 'full'}">
	<p>
       <a href="/news-archive?show=full"><img alt="" src="/image/image_gallery?uuid=f2dd890d-c486-4915-acc6-1bee459b0b0e&groupId=18&t=1315229176561" style="width: 214px; height: 59px" /></a>
    </p>
	   
	   <div class="news-events">
			  <ul>
				<c:forEach var="journal" items="${newsList}" varStatus="status">
				      <li><fmt:formatDate pattern="dd MMM yyyy"  value="${journal.displayDate}"/>&nbsp;<a href="${urlList[status.count - 1]}" target="_blank">${titleList[status.count - 1]}</a></li>
				</c:forEach>
			</ul>
	
		
		    <p style="text-align: right">
				<span style="font-size: 11px"><a class="double-arrow" href="/news-archive?show=full">News archive</a></span>
			</p>
			
	  </div>
	</c:when>
	
	<c:otherwise>
	   	<h3 class="case-studies-events-list-header">All News</h3>
		<ul class="case-studies-events-list">
		
	    <c:forEach var="journal" items="${newsList}" varStatus="status">
	        <li>
				<h5><a href="${urlList[status.count - 1]}" target="_blank">${titleList[status.count - 1]}</a></h5>
				<small><fmt:formatDate pattern="dd MMM yyyy"  value="${journal.displayDate}"/></small>
				<p>${journal.description}</p>
			</li>
	    </c:forEach>
	   </ul>
	</c:otherwise>
</c:choose>
