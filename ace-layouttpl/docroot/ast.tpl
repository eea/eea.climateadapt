<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
	<script type="text/javascript">
			String.prototype.endsWith = function(suffix) {
    			return this.match(suffix+"$") == suffix;
			};
		
          	$(document).ready(function() {
				$("#ast-menu").accordion({ 
					autoHeight: false,
					navigation: true,
					navigationFilter: function(){
						if( document.location.href.endsWith($(this).attr('href')) ) {
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
			                $processor.processColumn("column-4", "portlet-column-content portlet-column-content")
			            </td>
			        </tr>
	            </table>
			</td>
			
		</tr>
    </table>
#else
    <div class="portlet-layout">
        
        <div class="aui-w33 portlet-column portlet-column-first" id="column-1">
            $processor.processColumn("column-1", "portlet-column-content portlet-column-content-first")
            <ul id="ast-menu">
	            <li><a href="/adaptation-support-tool/step-1" name="step-1" onclick="document.location.href='/adaptation-support-tool/step-1'"><strong>1.</strong> Getting started</a>
		            <ul id="step-1">
		            	<li><a href="/adaptation-support-tool/step-1-1" name="step-1-1" onclick="document.location.href='/adaptation-support-tool/step-1-1'">1.1. <p>How to use the adaptation support tool?</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-1-2" name="step-1-2" onclick="document.location.href='/adaptation-support-tool/step-1-2'">1.2. <p>Why adapt to climate change?</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-1-3" name="step-1-3" onclick="document.location.href='/adaptation-support-tool/step-1-3'">1.3. <p>How to plan for adaptation?</p></a></li>
		            </ul>
		        </li>
	            <li><a href="/adaptation-support-tool/step-2" name="step-2" onclick="document.location.href='/adaptation-support-tool/step-2'"><strong>2.</strong> Assessing risks and vulnerability to climate change</a>
		            <ul id="step-2">
		            	<li><a href="/adaptation-support-tool/step-2-1" name="step-2-1" onclick="document.location.href='/adaptation-support-tool/step-2-1'">2.1. <p>How is the European climate changing?</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-2-2" name="step-2-2" onclick="document.location.href='/adaptation-support-tool/step-2-2'">2.2. <p>Risks and vulnerabilities in European sectors and regions</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-2-3" name="step-2-3" onclick="document.location.href='/adaptation-support-tool/step-2-3'">2.3. <p>Are there also opportunities?</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-2-4" name="step-2-4" onclick="document.location.href='/adaptation-support-tool/step-2-4'">2.4. <p>How to assess adaptive capacity?</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-2-5" name="step-2-5" onclick="document.location.href='/adaptation-support-tool/step-2-5'">2.5. <p>How to deal with uncertainties?</p></a></li>
		            </ul>
		        </li>
		        <li><a href="/adaptation-support-tool/step-3" name="step-3" onclick="document.location.href='/adaptation-support-tool/step-3'"><strong>3.</strong> Identifying adaptation options</a>
		            <ul id="step-3">
		            	<li><a href="/adaptation-support-tool/step-3-1" name="step-3-1" onclick="document.location.href='/adaptation-support-tool/step-3-1'">3.1. <p>What adaptation options are available?</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-3-2" name="step-3-2" onclick="document.location.href='/adaptation-support-tool/step-3-2'">3.2. <p>What case studies are available?</p></a></li>
		            </ul>
		        </li>
		        <li><a href="/adaptation-support-tool/step-4" name="step-4" onclick="document.location.href='/adaptation-support-tool/step-4'"><strong>4.</strong> Assessing adaptation options</a>
		            <ul id="step-4">
		            	<li><a href="/adaptation-support-tool/step-4-1" name="step-4-1" onclick="document.location.href='/adaptation-support-tool/step-4-1'">4.1. <p>How to decide which options to include in an adaptation strategy?</p></a></li>
		            	<li><a href="/adaptation-support-tool/step-4-2" name="step-4-2" onclick="document.location.href='/adaptation-support-tool/step-4-2'">4.2. <p>What are costs and benefits of adaptation?</p></a></li>
		            </ul>
		        </li>
		        <li class="no-substep"><a href="/adaptation-support-tool/step-5" name="step-5" onclick="document.location.href='/adaptation-support-tool/step-5'"><strong>5.</strong> Implementation</a></li>
		        <li class="no-substep"><a href="/adaptation-support-tool/step-6" name="step-6" onclick="document.location.href='/adaptation-support-tool/step-6'"><strong>6.</strong> Monitoring & Evaluation</a></li>
            </ul>
        </div>
        
        <div class="aui-w66 portlet-column portlet-column-last" id="column-right">
            <div id="aui-w66 top-column">
	            <div class="aui-w100 portlet-column portlet-column-first" id="column-2">
	                $processor.processColumn("column-2", "portlet-column-content portlet-column-content-first")
	            </div>
            </div>
            <div id="bottom-column">
	            <div class="aui-w33 portlet-column portlet-column" id="column-3">
	                $processor.processColumn("column-3", "portlet-column-content portlet-column-content-first")
	            </div>
	            <div class="aui-w33 portlet-column portlet-column" id="column-4">
	                $processor.processColumn("column-4", "portlet-column-content portlet-column-content")
	            </div>
            </div>
        </div>
        
    </div>
#end
</div>
