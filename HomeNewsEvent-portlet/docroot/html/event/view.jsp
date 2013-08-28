<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

<c:choose>
	 <c:when test="${showall ne 'full'}">
	   <div class="news-events">
			  <ul>
				<c:forEach var="journal" items="${eventList}" varStatus="status">
				      <li>${dayList[status.count - 1]}&nbsp;${monthList[status.count - 1]}&nbsp;${yearList[status.count - 1]},&nbsp;<a href="${urlList[status.count - 1]}">${journal.title}</a>,&nbsp;${locationList[status.count - 1]}</li>
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
							<div class="case-studies-events-list-date-month">${monthList[status.count - 1]}</div>
							<div class="case-studies-events-list-date-day">${dayList[status.count - 1]}</div>
							<div class="case-studies-events-list-date-year">${yearList[status.count - 1]}</div>
						</div>
				   </div>
		        
		           <div class="case-studies-events-list-column-right">
						<h5><a href="${urlList[status.count - 1]}">${journal.title}</a></h5>
						<small>${locationList[status.count - 1]}</small>
						<p>${journal.description}</p>
				  </div>
				  <div class="case-studies-three-column-layout-clearing"></div>
				</li>
		    </c:forEach>
	   </ul>
	</c:otherwise>
</c:choose>
