<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

<c:choose>
	 <c:when test="${showall ne 'full'}">
	   <div class="news-events">
			  <ul>
				<c:forEach var="journal" items="${eventList}" varStatus="status">
				      <li>${journal.date}&nbsp;${journal.month}&nbsp;${journal.year},&nbsp;<a href="${journal.url}">${journal.article.title}</a>,&nbsp;${journal.location}</li>
				</c:forEach>
			</ul>
	
		
		    <p style="text-align: right">
				<span style="font-size: 11px"><a class="double-arrow" href="/more-events?show=full">More Events</a></span>
			</p>
			
	  </div>
	</c:when>
	
	<c:otherwise>
	  <h3 class="case-studies-events-list-header">All Events</h3>
		<ul class="case-studies-events-list">
		    <c:forEach var="journal" items="${eventList}" varStatus="status">
		        <li>
		           <div class="case-studies-events-list-column-left">
			            <div class="case-studies-events-list-date">
							<div class="case-studies-events-list-date-month">${journal.month}</div>
							<div class="case-studies-events-list-date-day">${journal.date}</div>
							<div class="case-studies-events-list-date-year">${journal.year}</div>
						</div>
				   </div>
		        
		           <div class="case-studies-events-list-column-right">
						<h5><a href="${journal.url}">${journal.article.title}</a></h5>
						<small>${journal.location}</small>
						<p>${journal.article.description}</p>
				  </div>
				  <div class="case-studies-three-column-layout-clearing"></div>
				</li>
		    </c:forEach>
	   </ul>
	</c:otherwise>
</c:choose>
