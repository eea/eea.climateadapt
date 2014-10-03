<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script type="text/javascript">


		   	$(document).ready(function() {
		   		var pageUrl = document.location.href;
				$("#ast-menu").accordion({
					autoHeight: false,
					navigation: true,
					navigationFilter: function(){
					    // assumes ast/ in url before /step
					    var doc_rel_href = pageUrl.substr( document.location.href.indexOf('ast/step')+4 );

					    var this_rel_href = $(this).attr('href');
					    this_rel_href = this_rel_href.substr( this_rel_href.indexOf('ast/step')+4 );

					    if(doc_rel_href.indexOf('?') > 0) {
					    	doc_rel_href = doc_rel_href.substr(0, doc_rel_href.indexOf('?') );
					    }

					    if( (doc_rel_href.indexOf(this_rel_href) != -1) ) {
							$(this).addClass("active");
							return true;
						}
						else {return false;}
					}
				});

				$("a.ui-state-active").parent().css('background-color', '#6D7A2B');
				
				// Get a table with the links of the menu in #ast-menu
				var tab=new Array();
				$('#ast-menu li a').each(function(){ 
					tab.push($(this).attr('href'));
				});
				
				// Check which entry match the current url and return 
				// the previous one and the next one 
				var tablel = tab.length; i = 0; pos = -1; previous = ""; next = "";
				
				while ( i < tablel && pos < 0) { 
					pos = pageUrl.search(tab[i]);
					if ( pos > 0) {
						// If we are on the first page, return the last one as previous link
						if ( i == 0) {
							previous = tab[tablel-1];
							next = tab[1];
						} else if (i == tablel-1) {
							previous = tab [tablel-2];
							next = tab[0];
						} else {
							previous = tab[i-1];
							next = tab [i+1];
						}
					} 
					i++;
				}
				
				// Put previous and next into the href values of respective links
				$('#previous-link a').attr("href",previous);
				$('#next-link a').attr("href",next);
			});
    </script>

<div class="ast" id="main-content" role="main">
#if ($browserSniffer.isIe($request) && $browserSniffer.getMajorVersion($request) < 8)
<table class="portlet-layout">
  <tr>
    <td class="aui-w33 portlet-column portlet-column-first" id="column-1">
      $processor.processColumn("column-1", "portlet-column-content portlet-column-content-first")
    </td>

    <td class="aui-w66 portlet-column portlet-column-last" id="column-2">
      $processor.processColumn("column-2", "portlet-column-content portlet-column-content-last")
      <table>
        <tr>
          <td class="aui-w33 portlet-column portlet-column" id="column-3">
            $processor.processColumn("column-3", "portlet-column-content portlet-column-content-first")
          </td>
          <td class="aui-w33 portlet-column portlet-column" id="column-4">
            $processor.processColumn("column-4", "portlet-column-content portlet-column-content-last")
          </td>
        </tr>
          <tr>
			  <td class="aui-w66 portlet-column portlet-column-last" id="column-5" colspan="2">
			    $processor.processColumn("column-5", "portlet-column-content portlet-column-content-last")
			  </td>
		</tr>
      </table>
    </td>
  </tr>
</table>
#else
<div class="portlet-layout">

	<div class="aui-w33 portlet-column portlet-column-first" id="column-1">
	    $processor.processColumn("column-1", "portlet-column-content")
	    <ul id="ast-menu">
	      <li><a href="/tools/urban-ast/step-0-0" name="step-0-0" onclick="document.location.href='/tools/urban-ast/step-0-0'"><strong>0.</strong> The Urban Adaptation Support Tool - Getting started</a>
	        <ul id="step-0">
	          <li><a href="/tools/urban-ast/step-0-1" name="step-0-1" onclick="document.location.href='/tools/urban-ast/step-0-1'"><p>0.1 How to use the Urban Adaptation Support Tool?</p></a></li>
	          <li><a href="/tools/urban-ast/step-0-2" name="step-0-2" onclick="document.location.href='/tools/urban-ast/step-0-2'"><p>0.2 How is the European climate changing and what are the consequences for urban areas?</p></a></li>
	          <li><a href="/tools/urban-ast/step-0-3" name="step-0-3" onclick="document.location.href='/tools/urban-ast/step-0-3'"><p>0.3 What is adaptation to climate change and why does it matter in my city/town?</p></a></li>
	          <li><a href="/tools/urban-ast/step-0-4" name="step-0-4" onclick="document.location.href='/tools/urban-ast/step-0-4'"><p>0.4 What are the key principles for adaptation?</p></a></li>
	          <li><a href="/tools/urban-ast/step-0-5" name="step-0-5" onclick="document.location.href='/tools/urban-ast/step-0-5'"><p>0.5 Where can I find support for adaptation planning in the form of advice and capacity building?</p></a></li>
	        </ul>
	      </li>
	      <li><a href="/tools/urban-ast/step-1-0" name="step-1-0" onclick="document.location.href='/tools/urban-ast/step-1-0'"><strong>1.</strong> Preparing the ground for adaptation</a>
	        <ul id="step-1">
	          <li><a href="/tools/urban-ast/step-1-1" name="step-1-1" onclick="document.location.href='/tools/urban-ast/step-1-1'"><p>1.1 How do I ensure high level political support for adaptation now and in the long run?</p></a></li>
	          <li><a href="/tools/urban-ast/step-1-2" name="step-1-2" onclick="document.location.href='/tools/urban-ast/step-1-2'"><p>1.2 How do I set up the adaptation process within my municipality?</p></a></li>
	          <li><a href="/tools/urban-ast/step-1-3" name="step-1-3" onclick="document.location.href='/tools/urban-ast/step-1-3'"><p>1.3 What human, technical and financial resources are required for adaptation planning and management?</p></a></li>
	          <li><a href="/tools/urban-ast/step-1-4" name="step-1-4" onclick="document.location.href='/tools/urban-ast/step-1-4'"><p>1.4 What financial support is available for adaptation?</p></a></li>
	          <li><a href="/tools/urban-ast/step-1-5" name="step-1-5" onclick="document.location.href='/tools/urban-ast/step-1-5'"><p>1.5 What initial information do I need to collect?</p></a></li>
	          <li><a href="/tools/urban-ast/step-1-6" name="step-1-6" onclick="document.location.href='/tools/urban-ast/step-1-6'"><p>1.6 Who are the main (internal and external) players and stakeholders in adaptation processes and how do I involve them?</p></a></li>
	          <li><a href="/tools/urban-ast/step-1-7" name="step-1-7" onclick="document.location.href='/tools/urban-ast/step-1-7'"><p>1.7 How do I communicate adaptation to climate change?</p></a>
	            <ul id="step-1-7">
	              <li><a href="/tools/urban-ast/step-1-check" name="step-1-7-1" onclick="document.location.href='/tools/urban-ast/step-1-check'"><p>Self-check</p></a></li>
	            </ul>
	          </li>
	        </ul>
	      </li>
	      <li><a href="/tools/urban-ast/step-2-0" name="step-2-0" onclick="document.location.href='/tools/urban-ast/step-2-0'"><strong>2.</strong> Assessing risks and vulnerabilities to climate change</a>
	        <ul id="step-2">
	          <li><a href="/tools/urban-ast/step-2-1" name="step-2-1" onclick="document.location.href='/tools/urban-ast/step-2-1'"><p>2.1 What impacts has the past and current weather had/have on my city/town?</p></a></li>
	          <li><a href="/tools/urban-ast/step-2-2" name="step-2-2" onclick="document.location.href='/tools/urban-ast/step-2-2'"><p>2.2 What methodology can I use for carrying out risk or vulnerability assessment?</p></a></li>
	          <li><a href="/tools/urban-ast/step-2-3" name="step-2-3" onclick="document.location.href='/tools/urban-ast/step-2-3'"><p>2.3 Where can I find future climate and impact projections for my city/town and how to understand them?</p></a></li>
	          <li><a href="/tools/urban-ast/step-2-4" name="step-2-4" onclick="document.location.href='/tools/urban-ast/step-2-4'"><p>2.4 How certain are future climate projections and how do I deal with the uncertainty?</p></a></li>
	          <li><a href="/tools/urban-ast/step-2-5" name="step-2-5" onclick="document.location.href='/tools/urban-ast/step-2-5'"><p>2.5 Which sectors in my city/town are most likely to be impacted by climate change and how?</p></a></li>
	          <li><a href="/tools/urban-ast/step-2-6" name="step-2-6" onclick="document.location.href='/tools/urban-ast/step-2-6'"><p>2.6 What is the role of the surrounding areas in adaptation and how do I take that into account?</p></a></li>
	          <li><a href="/tools/urban-ast/step-2-7" name="step-2-7" onclick="document.location.href='/tools/urban-ast/step-2-7'"><p>2.7 Whom can I approach for further information, data and analysis assistance?</p></a></li>
	          <li><a href="/tools/urban-ast/step-2-8" name="step-2-8" onclick="document.location.href='/tools/urban-ast/step-2-8'"><p>2.8 How do I identify the main adaptation concerns and set the strategic direction?</p></a></li>          
	          <li><a href="/tools/urban-ast/step-2-9" name="step-2-9" onclick="document.location.href='/tools/urban-ast/step-2-9'"><p>2.9 How to set concrete Targets for adaptation?</p></a>
	            <ul id="step-2-9">
	              <li><a href="/tools/urban-ast/step-2-check" name="step-2-9-1" onclick="document.location.href='/tools/urban-ast/step-2-check'"><p>Self-check</p></a></li>
	            </ul>
	          </li>
	        </ul>
	      </li>
	      <li><a href="/tools/urban-ast/step-3-0" name="step-3-0" onclick="document.location.href='/tools/urban-ast/step-3-0'"><strong>3.</strong> Identifying adaptation options</a>
	        <ul id="step-3">
	          <li><a href="/tools/urban-ast/step-3-1" name="step-3-1" onclick="document.location.href='/tools/urban-ast/step-3-1'"><p>3.1 What adaptation measures for urban cities exist and how to set up a catalogue of measures?</p></a></li>
	          <li><a href="/tools/urban-ast/step-3-2" name="step-3-2" onclick="document.location.href='/tools/urban-ast/step-3-2'"><p>3.2 Where can I find examples of good adaptation practice of other cities and towns?</p></a></li>
	          <li><a href="/tools/urban-ast/step-3-3" name="step-3-3" onclick="document.location.href='/tools/urban-ast/step-3-3'"><p>3.3 How do I identify the existing adaptation measures in my city/town?</p></a>
	            <ul id="step-3-3">
	              <li><a href="/tools/urban-ast/step-3-check" name="step-3-3-1" onclick="document.location.href='/tools/urban-ast/step-3-check'"><p>Self-check</p></a></li>
	            </ul>
	          </li>
	        </ul>
	      </li>
	      <li><a href="/tools/urban-ast/step-4-0" name="step-4-0" onclick="document.location.href='/tools/urban-ast/step-4-0'"><strong>4.</strong> Assessing and selecting adaptation options</a>
	        <ul id="step-4">
	          <li><a href="/tools/urban-ast/step-4-1" name="step-4-1" onclick="document.location.href='/tools/urban-ast/step-4-1'"><p>4.1 What are the main aspects of adaptation measures that need to be assessed and described in detail?</p></a></li>
	          <li><a href="/tools/urban-ast/step-4-2" name="step-4-2" onclick="document.location.href='/tools/urban-ast/step-4-2'"><p>4.2 How do I carry out cost-benefit analysis?</p></a></li>
	          <li><a href="/tools/urban-ast/step-4-3" name="step-4-3" onclick="document.location.href='/tools/urban-ast/step-4-3'"><p>4.3 How to assess cross-cutting issues, trade-offs and synergies of adaptation options?</p></a></li>
	          <li><a href="/tools/urban-ast/step-4-4" name="step-4-4" onclick="document.location.href='/tools/urban-ast/step-4-4'"><p>4.4 How to prioritise adaptation options and select the preferable ones?</p></a>
	            <ul id="step-4-4">
	              <li><a href="/tools/urban-ast/step-4-check" name="step-4-4-1" onclick="document.location.href='/tools/urban-ast/step-4-check'"><p>Self-check</p></a></li>
	            </ul>
	          </li>
	        </ul>
	      </li>
	      <li><a href="/tools/urban-ast/step-5-0" name="step-5-0" onclick="document.location.href='/tools/urban-ast/step-5-0'"><strong>5.</strong> Implementation</a>
	        <ul id="step-5">
	          <li><a href="/tools/urban-ast/step-5-1" name="step-5-1" onclick="document.location.href='/tools/urban-ast/step-5-1'"><p>5.1 What are the main elements of a good adaptation strategy?</p></a></li>
	          <li><a href="/tools/urban-ast/step-5-2" name="step-5-2" onclick="document.location.href='/tools/urban-ast/step-5-2'"><p>5.2 Where do I find good examples of existing adaptation strategies and action plans in urban areas?</p></a></li>
	          <li><a href="/tools/urban-ast/step-5-3" name="step-5-3" onclick="document.location.href='/tools/urban-ast/step-5-3'"><p>5.3 How can I best apply mainstreaming adaptation into the existing urban policy framework and what instruments can I put in place?</p></a>
	            <ul id="step-5-3">
	              <li><a href="/tools/urban-ast/step-5-check" name="step-5-3-1" onclick="document.location.href='/tools/urban-ast/step-5-check'"><p>Self-check</p></a></li>
	            </ul>
	          </li>
	        </ul>
	      </li>
	      <li><a href="/tools/urban-ast/step-6-0" name="step-6-0" onclick="document.location.href='/tools/urban-ast/step-6-0'"><strong>6.</strong> Monitoring and evaluation</a>
	        <ul id="step-6">
	            <li><a href="/tools/urban-ast/step-6-1" name="step-6-1" onclick="document.location.href='/tools/urban-ast/step-6-1'"><p>6.1 What approaches for monitoring and evaluation can I apply?</p></a></li>
	            <li><a href="/tools/urban-ast/step-6-2" name="step-6-2" onclick="document.location.href='/tools/urban-ast/step-6-2'"><p>6.2 How do I develop indicators for adaptation?</p></a></li>        
	            <li><a href="/tools/urban-ast/step-6-3" name="step-6-3" onclick="document.location.href='/tools/urban-ast/step-6-3'"><p>6.3 Where can I find examples of adaptation indicators?</p></a>
	                <ul id="step-6-3">
	                    <li><a href="/tools/urban-ast/step-6-check" name="step-6-3-1" onclick="document.location.href='/tools/urban-ast/step-6-check'"><p>Self-check</p></a></li>
	                </ul>
	            </li>
	        </ul>
	  </li>
	</ul>
	</div>
	
	<div class="aui-w66 portlet-column portlet-column-last" id="column-right">
		<div id="aui-w66 top-column">
		  <div class="aui-w100 portlet-column portlet-column-first" id="column-2">
		    $processor.processColumn("column-2", "portlet-column-content portlet-column-content-last")
		  </div>
		</div>
		<div id="bottom-column">
		  <div class="aui-w33 portlet-column portlet-column" id="column-3">
		    $processor.processColumn("column-3", "portlet-column-content portlet-column-content-first")
		  </div>
		  <div class="aui-w33 portlet-column portlet-column" id="column-4">
		    $processor.processColumn("column-4", "portlet-column-content portlet-column-content-last")
		  </div>
		</div>
		<div id="aui-w66 foot-column">
			<div class="aui-w100 portlet-column portlet-column-first" id="column-5">
			   $processor.processColumn("column-5", "portlet-column-content portlet-column-content-last")
			   <hr />
			   <div id="bottom-menu">
				   	<div id="previous-link"><a href="">« Previous question</a></div>
				    <div id="contact-link" class="bluebuttondiv">
				    	<a href="http://climate-adapt.eea.europa.eu/tools/urban-ast/contact" class="bluebutton">Contact us with your questions,<br/>comments and suggestions</a></div>
				    <div id="next-link"><a href="">Next question »</a></div>
			   </div>
			   <div class="clear-both"></div>
			 </div>  
	    </div>
	</div>

</div>


        #end
        </div>