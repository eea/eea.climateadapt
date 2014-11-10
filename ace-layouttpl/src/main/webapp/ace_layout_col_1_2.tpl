<script type="text/javascript">

   	$(document).ready(function() {
   		var pageUrl = document.location.href;
		
		// Find the page url in the list of <a> tags in tha menu and add class 'active' 
		$('.menu-urban li a').each(function(){
		    if (pageUrl.search($(this).attr('href')) > 0) {
		          $(this).addClass("active");
		          $(this).closest(".menu-urban-sub").css({"opacity": "1", "height": "80px"});
		          $(this).closest(".menu-urban li").css({"opacity": "1"});
		    }
		});
	});
</script>


<div class="ace_layout_col_1_2" id="main-content" role="main">
	<div class="portlet-layout">
		<div class="portlet-column portlet-column-only" id="column-1">
			$processor.processColumn("column-1", "portlet-column-content portlet-column-content-first")
		</div>
	</div>
	<div class="portlet-layout">	
		<div class="aui-w20 portlet-column portlet-column-first" id="column-2">
			$processor.processColumn("column-2", "portlet-column-content portlet-column-content-first")
			  <ul class="menu-urban">
		        <li>
		            <a href="/tools/urban-adaptation/climatic-threats/heat-waves" id="heat_waves" class="menu-link">Heat waves</a>
		            <ul class="menu-urban-sub">
		                <li><a href="/tools/urban-adaptation/climatic-threats/heat-waves/exposure">Exposure</a></li>
		                <li><a href="/tools/urban-adaptation/climatic-threats/heat-waves/sensitivity">Sensitivity</a></li>
		                <li><a href="/tools/urban-adaptation/climatic-threats/heat-waves/response-capacity">Response capacity</a></li>
		            </ul>
		        </li>
		        <li>
		            <a href="/tools/urban-adaptation/climatic-threats/droughts" id="drought" class="menu-link">Water scarity and droughts</a>
		            <ul class="menu-urban-sub">
		                <li><a href="/tools/urban-adaptation/climatic-threats/droughts/exposure">Exposure</a></li>
		                <li><a href="/tools/urban-adaptation/climatic-threats/droughts/sensitivity">Sensitivity</a></li>
		                <li><a href="/tools/urban-adaptation/climatic-threats/droughts/response-capacity">Response capacity</a></li>
		            </ul>
		        </li>
		        <li>
		            <a href="/tools/urban-adaptation/climatic-threats/flooding" id="flooding" class="menu-link">Flooding</a>
		            <ul class="menu-urban-sub">
		                <li><a href="/tools/urban-adaptation/climatic-threats/flooding/exposure">Exposure</a></li>
		                <li><a href="/tools/urban-adaptation/climatic-threats/flooding/sensitivity">Sensitivity</a></li>
		                <li><a href="/tools/urban-adaptation/climatic-threats/flooding/response-capacity">Response capacity</a></li>
		            </ul>
		        </li>
		        <li>
		            <a href="/tools/urban-adaptation/climatic-threats/forest-fires" id="forest_fires" class="menu-link">Forest fires</a>
		            <ul class="menu-urban-sub">
		                <li><a href="/tools/urban-adaptation/climatic-threats/forest-fires/exposure">Exposure</a></li>
		                <li><a href="/tools/urban-adaptation/climatic-threats/forest-fires/sensitivity">Sensitivity</a></li>
		                <li><a href="/tools/urban-adaptation/climatic-threats/forest-fires/response-capacity">Response capacity</a></li>
		            </ul>
		        </li>
		    </ul>			
		</div>
        <div class="aui-w80 portlet-column" id="column-3">
			$processor.processColumn("column-3", "portlet-column-content")
		</div>
	</div>
</div>
