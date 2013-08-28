<%@include file="/html/init.jsp" %>

<portlet:defineObjects />
<c:choose>
	 <c:when test="${showall ne 'full'}">
	   <div class="news-events">
			  <ul>
				<c:forEach var="journal" items="${newsList}" varStatus="status">
				      <li><fmt:formatDate pattern="dd MMM yyyy"  value="${journal.displayDate}"/>&nbsp;<a href="${urlList[status.count - 1]}">${journal.title}</a></li>
				</c:forEach>
			</ul>
	
		
		    <p style="text-align: right">
				<span style="font-size: 11px"><a class="double-arrow" href="/news-archive?show=full">News archive</a></span>
			</p>
			
	  </div>
	</c:when>
	
	<c:otherwise>
	    <div class="bluebuttondiv">
           <a href="#" class="bluebutton">Sign up for newsletter</a>
        </div>
       
	   	<h3 class="case-studies-events-list-header">All News</h3>
		<ul class="case-studies-events-list">
		
	    <c:forEach var="journal" items="${newsList}" varStatus="status">
	        <li>
				<h5><a href="${urlList[status.count]}">${journal.title}</a></h5>
				<small><fmt:formatDate pattern="dd MMM yyyy"  value="${journal.displayDate}"/></small>
				<p>${journal.description}</p>
			</li>
	    </c:forEach>
	   </ul>
	</c:otherwise>
</c:choose>
