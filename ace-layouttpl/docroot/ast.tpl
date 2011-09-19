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
	            <li><a href="/adaptation-support-tool/step-1" name="step-1">AST step 1</a>
		            <ul id="step-1">
		            	<li><a href="/adaptation-support-tool/step-1-1" name="step-1-1">AST step 1-1</a></li>
		            	<li><a href="/adaptation-support-tool/step-1-2" name="step-1-2">AST step 1-2</a></li>
		            </ul>
		        </li>
	            <li><a href="/adaptation-support-tool/step-2" name="step-2">AST step 2</a>
		            <ul id="step-2">
		            	<li><a href="/adaptation-support-tool/step-2-1" name="step-2-1">AST step 2-1</a></li>
		            	<li><a href="/adaptation-support-tool/step-2-2" name="step-2-2">AST step 2-2</a></li>
		            	<li><a href="/adaptation-support-tool/step-2-3" name="step-2-3">AST step 2-3</a></li>
		            	<li><a href="/adaptation-support-tool/step-2-4" name="step-2-4">AST step 2-4</a></li>
		            	<li><a href="/adaptation-support-tool/step-2-5" name="step-2-5">AST step 2-5</a></li>
		            </ul>
		        </li>
		        <li><a href="/adaptation-support-tool/step-3" name="step-3">AST step 3</a>
		            <ul id="step-3">
		            	<li><a href="/adaptation-support-tool/step-3-1" name="step-3-1">AST step 3-1</a></li>
		            	<li><a href="/adaptation-support-tool/step-3-2" name="step-3-2">AST step 3-2</a></li>
		            </ul>
		        </li>
		        <li><a href="/adaptation-support-tool/step-4" name="step-4">AST step 4</a>
		            <ul id="step-4">
		            	<li><a href="/adaptation-support-tool/step-4-1" name="step-4-1">AST step 4-1</a></li>
		            	<li><a href="/adaptation-support-tool/step-4-2" name="step-4-2">AST step 4-2</a></li>
		            </ul>
		        </li>
		        <li><a href="/adaptation-support-tool/step-5" name="step-5">AST step 5</a></li>
		        <li><a href="/adaptation-support-tool/step-6" name="step-6">AST step 6</a></li>
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
