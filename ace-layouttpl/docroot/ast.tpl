<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
	<script type="text/javascript">

		
		   	$(document).ready(function() {
				$("#ast-menu").accordion({ 
					autoHeight: false,
					navigation: true,
					navigationFilter: function(){
					    // assumes tool/ in url before /step
					    var doc_rel_href = document.location.href.substr( document.location.href.indexOf('tool/step')+4 );
					    
					    var this_rel_href = $(this).attr('href');
					    this_rel_href = this_rel_href.substr( this_rel_href.indexOf('tool/step')+4 );
					    
					    if(doc_rel_href.indexOf('?') > 0) {
					    	doc_rel_href = doc_rel_href.substr(0, doc_rel_href.indexOf('?') );
					    }
					    
					    if( (doc_rel_href.IndexOf(this_rel_href) != -1 ) ) {
							$(this).addClass("active");
							return true;
						}
						else {return false;}
					}
				});
				
				$("a.ui-state-active").parent().css('background-color', '#6D7A2B');
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
	            </table>
			</td>
			
		</tr>
    </table>
#else
    <div class="portlet-layout">
        
        <div class="aui-w33 portlet-column portlet-column-first" id="column-1">
            $processor.processColumn("column-1", "portlet-column-content")
            <ul id="ast-menu">
                <li><a href="/adaptation-support-tool" name="step-0" onclick="document.location.href='/adaptation-support-tool'">The Adaptation Support Tool - Getting started</a>
		            <ul id="step-0">
		            	<li><a href="/adaptation-support-tool/european-climate" name="step-0-1" onclick="document.location.href='/adaptation-support-tool/european-climate'"><p>How is the European climate changing?</p></a></li>
		            	<li><a href="/adaptation-support-tool/why-adapt" name="step-0-2" onclick="document.location.href='/adaptation-support-tool/why-adapt'"><p>Why adapt to climate change?</p></a></li>
		            	<li><a href="/adaptation-support-tool/key-principles" name="step-0-3" onclick="document.location.href='/adaptation-support-tool/key-principles'"><p>Key principles for adaptation</p></a></li>
		            	<li><a href="/adaptation-support-tool/how-to-use" name="step-0-4" onclick="document.location.href='/adaptation-support-tool/how-to-use'"><p>How to use the Adaptation Support Tool?</p></a></li>
		            </ul>
		        </li>
	            <li><a href="/adaptation-support-tool/step-1" name="step-1" onclick="document.location.href='/adaptation-support-tool/step-1'"><strong>1.</strong> Preparing the ground for adaptation</a>
		            <ul id="step-1">
		            	<li><a href="/adaptation-support-tool/step-1/high-level-support" name="step-1-1" onclick="document.location.href='/adaptation-support-tool/step-1/high-level-support'"><p>Obtain high-level support</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-1/set-up-process" name="step-1-2" onclick="document.location.href='/adaptation-support-tool/step-1/set-up-process'"><p>Set up the process</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-1/ressources" name="step-1-3" onclick="document.location.href='/adaptation-support-tool/step-1/ressources'"><p>Estimate human and financial resources and identify funding opportunities</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-1/collect-information" name="step-1-4" onclick="document.location.href='/adaptation-support-tool/step-1/collect-information'"><p>Collect information</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-1/communicate-raise-awareness" name="step-1-5" onclick="document.location.href='/adaptation-support-tool/step-1/communicate-raise-awareness'"><p>Communicate and raise awareness</p></a>
		            		<ul id="step-1-5">
		            			<li><a href="/adaptation-support-tool/step-1/self-check" name="step-1-5-1" onclick="document.location.href='/adaptation-support-tool/step-1/self-check'"><p>SELF-CHECK</p></a></li>
		            		</ul>
		            	</li>
		            </ul>
		        </li>
	            <li><a href="/adaptation-support-tool/step-2" name="step-2" onclick="document.location.href='/adaptation-support-tool/step-2'"><strong>2.</strong> Assessing risks and vulnerabilities to climate change</a>
		            <ul id="step-2">
		            	<li><a href="/adaptation-support-tool/step-2/past-weather-events" name="step-2-1" onclick="document.location.href='/adaptation-support-tool/step-2/past-weather-events'"><p>Analyse how past weather events have affected your area</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-2/risk-vulnerability-assessment" name="step-2-2" onclick="document.location.href='/adaptation-support-tool/step-2/risk-vulnerability-assessment'"><p>Undertake a climate change risks and vulnerability assessment</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-2/trans-boundary-issues" name="step-2-3" onclick="document.location.href='/adaptation-support-tool/step-2/trans-boundary-issues'"><p>Take trans-boundary issues into account</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-2/knowlegde-uncertainty" name="step-2-4" onclick="document.location.href='/adaptation-support-tool/step-2/knowlegde-uncertainty'"><p>Develop an approach for addressing knowledge gaps and for dealing with uncertainties</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-2/strategic-direction" name="step-2-5" onclick="document.location.href='/adaptation-support-tool/step-2/strategic-direction'"><p>Select your area’s main concerns and set your strategic direction</p></a>
		            		<ul id="step-2-5">
		            			<li><a href="/adaptation-support-tool/step-2/self-check" name="step-2-5-1" onclick="document.location.href='/adaptation-support-tool/step-2/self-check'"><p>SELF-CHECK</p></a></li>
		            		</ul>	    
		            	</li>
		            </ul>
		        </li>
		        <li><a href="/adaptation-support-tool/step-3" name="step-3" onclick="document.location.href='/adaptation-support-tool/step-3'"><strong>3.</strong> Identifying adaptation options</a>
		            <ul id="step-3">
		            	<li><a href="/adaptation-support-tool/step-3/collect-options" name="step-3-1" onclick="document.location.href='/adaptation-support-tool/step-3/collect-options'"><p>Collect appropriate adaptation options given your country´s main concerns</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-3/explore-good-practices" name="step-3-2" onclick="document.location.href='/adaptation-support-tool/step-3/explore-good-practices'"><p>Explore good practices and existing measures</p></a></li>
            			<li><a href="/adaptation-support-tool/step-3/describe-options" name="step-3-3" onclick="document.location.href='/adaptation-support-tool/step-3/describe-options'"><p>Describe adaptation options in detail</p></a>
            				<ul id="step-3-3">
            					<li><a href="/adaptation-support-tool/step-3/self-check" name="step-3-3-1" onclick="document.location.href='/adaptation-support-tool/step-3/self-check'"><p>SELF-CHECK</p></a></li>
            				</ul>
            			</li>		            	
		            </ul>
		        </li>
		        <li><a href="/adaptation-support-tool/step-4" name="step-4" onclick="document.location.href='/adaptation-support-tool/step-4'"><strong>4.</strong> Assessing adaptation options</a>
		            <ul id="step-4">
		            	<li><a href="/adaptation-support-tool/step-4/assess-time-cost-benefits" name="step-4-1" onclick="document.location.href='/adaptation-support-tool/step-4/assess-time-cost-benefits'"><p>Assess possible options in terms of time, cost, benefits and efforts</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-4/cross-cutting-issues" name="step-4-2" onclick="document.location.href='/adaptation-support-tool/step-4/cross-cutting-issues'"><p>Assess cross-cutting issues, trade-offs and synergies of adaptation options</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-4/prioritise-and-select" name="step-4-3" onclick="document.location.href='/adaptation-support-tool/step-4/prioritise-and-select'"><p>Prioritise adaptation options and select preferred ones</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-4/strategy-and-approval" name="step-4-4" onclick="document.location.href='/adaptation-support-tool/step-4/strategy-and-approval'"><p>Prepare a strategy document and get political approval</p></a>
		            		<ul id="step-4-4">
		            			<li><a href="/adaptation-support-tool/step-4/self-check" name="step-4-4-1" onclick="document.location.href='/adaptation-support-tool/step-4/self-check'"><p>SELF-CHECK</p></a></li>
		            		</ul>
		            	</li>
		            </ul>
		        </li>
		        <li><a href="/adaptation-support-tool/step-5" name="step-5" onclick="document.location.href='/adaptation-support-tool/step-5'"><strong>5.</strong> Implementation</a>
		        	<ul id="step-5">
		            	<li><a href="/adaptation-support-tool/step-5/mainstreaming" name="step-5-1" onclick="document.location.href='/adaptation-support-tool/step-5/mainstreaming'"><p>Mainstreaming: Identify and make use of entry points for adaptation</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-5/seek-agreements" name="step-5-2" onclick="document.location.href='/adaptation-support-tool/step-5/seek-agreements'"><p>Seek agreements with stakeholders responsible for implementation</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-5/action-plan" name="step-5-3" onclick="document.location.href='/adaptation-support-tool/step-5/action-plan'"><p>Develop an action plan</p></a>
		            		<ul id="step-5-3">
		            			<li><a href="/adaptation-support-tool/step-5/self-check" name="step-5-3-1" onclick="document.location.href='/adaptation-support-tool/step-5/self-check'"><p>SELF-CHECK</p></a></li>
		            		</ul>
		            	</li>
		            </ul>
		        </li>
		        <li><a href="/adaptation-support-tool/step-6" name="step-6" onclick="document.location.href='/adaptation-support-tool/step-6'"><strong>6.</strong> Monitoring and evaluation</a>
		        	<ul id="step-6">
		            	<li><a href="/adaptation-support-tool/step-6/develop-provisions" name="step-6-1" onclick="document.location.href='/adaptation-support-tool/step-6/develop-provisions'"><p>Develop appropriate M&E provisions for your policy´s objectives and adaptation options</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-6/identify-indicators" name="step-6-2" onclick="document.location.href='/adaptation-support-tool/step-6/identify-indicators'"><p>Identify indicators </p></a></li>
		            		<ul id="step-6-2">
		            			<li><a href="/adaptation-support-tool/step-6/self-check" name="step-6-2-1" onclick="document.location.href='/adaptation-support-tool/step-6/self-check'"><p>SELF-CHECK</p></a></li>
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
        </div>
        
    </div>
#end
</div>
