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
					    
					    if( (doc_rel_href == this_rel_href) ) {
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
                <li><a href="/adaptation-support-tool/step-0" name="step-0" onclick="document.location.href='/adaptation-support-tool/'">The Adaptation Support Tool - Getting started</a>
		            <ul id="step-0">
		            	<li><a href="/adaptation-support-tool/step-0-1" name="step-0-1" onclick="document.location.href='/adaptation-support-tool/step-0-1'"><p>How is the European climate changing?</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-0-2" name="step-0-2" onclick="document.location.href='/adaptation-support-tool/step-0-2'"><p>Why adapt to climate change?</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-0-3" name="step-0-3" onclick="document.location.href='/adaptation-support-tool/step-0-3'"><p>Key principles for adaptation</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-0-4" name="step-0-4" onclick="document.location.href='/adaptation-support-tool/step-0-4'"><p>How to use the Adaptation Support Tool?</p></a></li>
		            </ul>
		        </li>
	            <li><a href="/adaptation-support-tool/step-1" name="step-1" onclick="document.location.href='/adaptation-support-tool/step-1'"><strong>1.</strong> Preparing the ground for adaptation</a>
		            <ul id="step-1">
		            	<li><a href="/adaptation-support-tool/step-1-1" name="step-1-1" onclick="document.location.href='/adaptation-support-tool/step-1-1'"><p>Obtain high-level support</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-1-2" name="step-1-2" onclick="document.location.href='/adaptation-support-tool/step-1-2'"><p>Set up the process</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-1-3" name="step-1-3" onclick="document.location.href='/adaptation-support-tool/step-1-3'"><p>Estimate human and financial resources and identify funding opportunities</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-1-4" name="step-1-4" onclick="document.location.href='/adaptation-support-tool/step-1-4'"><p>Collect information</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-1-5" name="step-1-5" onclick="document.location.href='/adaptation-support-tool/step-1-5'"><p>Communicate and raise awareness</p></a>
		            		<ul id="step-1-5">
		            			<li><a href="/adaptation-support-tool/step-1-5-1" name="step-1-5-1" onclick="document.location.href='/adaptation-support-tool/step-1-5-1'"><p>SELF-CHECK</p></a></li>
		            		</ul>
		            	</li>
		            </ul>
		        </li>
	            <li><a href="/adaptation-support-tool/step-2" name="step-2" onclick="document.location.href='/adaptation-support-tool/step-2'"><strong>2.</strong> Assessing risks and vulnerabilities to climate change</a>
		            <ul id="step-2">
		            	<li><a href="/adaptation-support-tool/step-2-1" name="step-2-1" onclick="document.location.href='/adaptation-support-tool/step-2-1'"><p>Analyse how past weather events have affected your area</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-2-2" name="step-2-2" onclick="document.location.href='/adaptation-support-tool/step-2-2'"><p>Undertake a climate change risks and vulnerability assessment</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-2-3" name="step-2-3" onclick="document.location.href='/adaptation-support-tool/step-2-3'"><p>Take trans-boundary issues into account</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-2-4" name="step-2-4" onclick="document.location.href='/adaptation-support-tool/step-2-4'"><p>Develop an approach for addressing knowledge gaps and for dealing with uncertainties</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-2-5" name="step-2-5" onclick="document.location.href='/adaptation-support-tool/step-2-5'"><p>Select your area’s main concerns and set your strategic direction</p></a>
		            		<ul id="step-2-5">
		            			<li><a href="/adaptation-support-tool/step-2-5-1" name="step-2-5-1" onclick="document.location.href='/adaptation-support-tool/step-2-5-1'"><p>SELF-CHECK</p></a></li>
		            		</ul>	    
		            	</li>
		            </ul>
		        </li>
		        <li><a href="/adaptation-support-tool/step-3" name="step-3" onclick="document.location.href='/adaptation-support-tool/step-3'"><strong>3.</strong> Identifying adaptation options</a>
		            <ul id="step-3">
		            	<li><a href="/adaptation-support-tool/step-3-1" name="step-3-1" onclick="document.location.href='/adaptation-support-tool/step-3-1'"><p>Collect appropriate adaptation options given your country´s main concerns</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-3-2" name="step-3-2" onclick="document.location.href='/adaptation-support-tool/step-3-2'"><p>Explore good practices and existing measures</p></a></li>
            			<li><a href="/adaptation-support-tool/step-3-3" name="step-3-3" onclick="document.location.href='/adaptation-support-tool/step-3-3'"><p>Describe adaptation options in detail</p></a>
            				<ul id="step-3-3">
            					<li><a href="/adaptation-support-tool/step-3-3-1" name="step-3-3-1" onclick="document.location.href='/adaptation-support-tool/step-3-3-1'"><p>SELF-CHECK</p></a></li>
            				</ul>
            			</li>		            	
		            </ul>
		        </li>
		        <li><a href="/adaptation-support-tool/step-4" name="step-4" onclick="document.location.href='/adaptation-support-tool/step-4'"><strong>4.</strong> Assessing adaptation options</a>
		            <ul id="step-4">
		            	<li><a href="/adaptation-support-tool/step-4-1" name="step-4-1" onclick="document.location.href='/adaptation-support-tool/step-4-1'"><p>Assess possible options in terms of time, cost, benefits and efforts</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-4-2" name="step-4-2" onclick="document.location.href='/adaptation-support-tool/step-4-2'"><p>Assess cross-cutting issues, trade-offs and synergies of adaptation options</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-4-3" name="step-4-3" onclick="document.location.href='/adaptation-support-tool/step-4-3'"><p>Prioritise adaptation options and select preferred ones</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-4-4" name="step-4-4" onclick="document.location.href='/adaptation-support-tool/step-4-4'"><p>Prepare a strategy document and get political approval</p></a>
		            		<ul id="step-4-4">
		            			<li><a href="/adaptation-support-tool/step-4-4-1" name="step-4-4-1" onclick="document.location.href='/adaptation-support-tool/step-4-4-1'"><p>SELF-CHECK</p></a></li>
		            		</ul>
		            	</li>
		            </ul>
		        </li>
		        <li><a href="/adaptation-support-tool/step-5" name="step-5" onclick="document.location.href='/adaptation-support-tool/step-5'"><strong>5.</strong> Implementation</a>
		        	<ul id="step-5">
		            	<li><a href="/adaptation-support-tool/step-5-1" name="step-5-1" onclick="document.location.href='/adaptation-support-tool/step-5-1'"><p>Mainstreaming: Identify and make use of entry points for adaptation</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-5-2" name="step-5-2" onclick="document.location.href='/adaptation-support-tool/step-5-2'"><p>Seek agreements with stakeholders responsible for implementation</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-5-3" name="step-5-3" onclick="document.location.href='/adaptation-support-tool/step-5-3'"><p>Develop an action plan</p></a>
		            		<ul id="step-5-3">
		            			<li><a href="/adaptation-support-tool/step-5-3-1" name="step-5-3-1" onclick="document.location.href='/adaptation-support-tool/step-5-3-1'"><p>SELF-CHECK</p></a></li>
		            		</ul>
		            	</li>
		            </ul>
		        </li>
		        <li><a href="/adaptation-support-tool/step-6" name="step-6" onclick="document.location.href='/adaptation-support-tool/step-6'"><strong>6.</strong> Monitoring and evaluation</a>
		        	<ul id="step-6">
		            	<li><a href="/adaptation-support-tool/step-6-1" name="step-6-1" onclick="document.location.href='/adaptation-support-tool/step-6-1'"><p>Develop appropriate M&E provisions for your policy´s objectives and adaptation options</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-6-2" name="step-6-2" onclick="document.location.href='/adaptation-support-tool/step-6-2'"><p>Identify indicators </p></a></li>
		            		<ul id="step-6-2">
		            			<li><a href="/adaptation-support-tool/step-6-2-1" name="step-6-2-1" onclick="document.location.href='/adaptation-support-tool/step-6-2-1'"><p>SELF-CHECK</p></a></li>
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
