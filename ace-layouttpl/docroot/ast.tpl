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
						$(this).addClass("active;");
						return document.location.href.endsWith($(this).attr('href'));
					}
				});
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
	            <li><a href="/adaptation-support-tool/step-1" name="step-1" onclick="document.location.href='/adaptation-support-tool/step-1'">1. Getting started</a>
		            <ul id="step-1">
		            	<li><a href="/adaptation-support-tool/step-1-1" name="step-1-1" onclick="document.location.href='/adaptation-support-tool/step-1-1'">1.1. How to use the adaptation support tool?</a></li>
		            	<li><a href="/adaptation-support-tool/step-1-2" name="step-1-2" onclick="document.location.href='/adaptation-support-tool/step-1-2'">1.2. Why adapt to climate change?</a></li>
		            	<li><a href="/adaptation-support-tool/step-1-3" name="step-1-3" onclick="document.location.href='/adaptation-support-tool/step-1-3'">1.3. How to plan for adaptation?</a></li>
		            </ul>
		        </li>
	            <li><a href="/adaptation-support-tool/step-2" name="step-2" onclick="document.location.href='/adaptation-support-tool/step-2'">2. Assessing risks and vulnerability to climate change</a>
		            <ul id="step-2">
		            	<li><a href="/adaptation-support-tool/step-2-1" name="step-2-1" onclick="document.location.href='/adaptation-support-tool/step-2-1'">2.1. How is the European climate changing?</a></li>
		            	<li><a href="/adaptation-support-tool/step-2-2" name="step-2-2" onclick="document.location.href='/adaptation-support-tool/step-2-2'">2.2. Risks and vulnerabilities in European sectors and regions</a></li>
		            	<li><a href="/adaptation-support-tool/step-2-3" name="step-2-3" onclick="document.location.href='/adaptation-support-tool/step-2-3'">2.3. Are there also opportunities?</a></li>
		            	<li><a href="/adaptation-support-tool/step-2-4" name="step-2-4" onclick="document.location.href='/adaptation-support-tool/step-2-4'">2.4. How to assess adaptive capacity?</a></li>
		            	<li><a href="/adaptation-support-tool/step-2-5" name="step-2-5" onclick="document.location.href='/adaptation-support-tool/step-2-5'">2.5. How to deal with uncertainties?</a></li>
		            </ul>
		        </li>
		        <li><a href="/adaptation-support-tool/step-3" name="step-3" onclick="document.location.href='/adaptation-support-tool/step-3'">3. Identifying adaptation options</a>
		            <ul id="step-3">
		            	<li><a href="/adaptation-support-tool/step-3-1" name="step-3-1" onclick="document.location.href='/adaptation-support-tool/step-3-1'">3.1. What adaptation options are available?</a></li>
		            	<li><a href="/adaptation-support-tool/step-3-2" name="step-3-2" onclick="document.location.href='/adaptation-support-tool/step-3-2'">3.2. What case studies are available?</a></li>
		            </ul>
		        </li>
		        <li><a href="/adaptation-support-tool/step-4" name="step-4" onclick="document.location.href='/adaptation-support-tool/step-4'">4. Assessing adaptation options</a>
		            <ul id="step-4">
		            	<li><a href="/adaptation-support-tool/step-4-1" name="step-4-1" onclick="document.location.href='/adaptation-support-tool/step-4-1'">4.1. How to decide which options to include in an adaptation strategy?</a></li>
		            	<li><a href="/adaptation-support-tool/step-4-2" name="step-4-2" onclick="document.location.href='/adaptation-support-tool/step-4-2'">4.2. What are costs and benefits of adaptation?</a></li>
		            </ul>
		        </li>
		        <li><a href="/adaptation-support-tool/step-5" name="step-5" onclick="document.location.href='/adaptation-support-tool/step-5'">5. Implementation</a></li>
		        <li><a href="/adaptation-support-tool/step-6" name="step-6" onclick="document.location.href='/adaptation-support-tool/step-6'">6. Monitoring & Evaluation</a></li>
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
