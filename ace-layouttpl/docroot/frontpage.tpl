<div class="frontpage-layout" id="main-content" role="main">
#if ($browserSniffer.isIe($request) && $browserSniffer.getMajorVersion($request) < 8)
	<table class="portlet-layout" id="fp-top-row">
		<tr>
			<td class="aui-w25 portlet-column portlet-column-first" id="column-1">
				$processor.processColumn("column-1", "portlet-column-content portlet-column-content-first")
			</td>
			<td class="aui-w50 portlet-column" id="column-2">
				$processor.processColumn("column-2", "portlet-column-content")
			</td>
			<td class="aui-w25 portlet-column portlet-column-last" id="column-3">
				$processor.processColumn("column-3", "portlet-column-content portlet-column-content-last")
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td class="aui-w25 portlet-column portlet-column-first" id="column-4">
				$processor.processColumn("column-4", "portlet-column-content portlet-column-content-first")
			</td>
			<td class="aui-w25 portlet-column" id="column-5">
				$processor.processColumn("column-5", "portlet-column-content")
			</td>
			<td class="aui-w25 portlet-column portlet-column-last" id="column-6">
				$processor.processColumn("column-6", "portlet-column-content")
			</td>
			<td class="aui-w25 portlet-column portlet-column-last" id="column-7">
				$processor.processColumn("column-7", "portlet-column-content portlet-column-content-last")
			</td>
		</tr>
	</table>
#else
	<div id="fp-top-row-custom" class="portlet-layout">
		<div class="aui-w75 portlet-column portlet-column-first" id="column-1">
			$processor.processColumn("column-1", "portlet-column-content portlet-column-content-first")
		</div>
		<div class="aui-w25 portlet-column" id="column-2">
			$processor.processColumn("column-2", "portlet-column-content")
		</div>
	</div>

	<div id="portlet-layout" class="portlet-layout">
		<div class="aui-w50 portlet-column portlet-column-first" id="column-3">
			$processor.processColumn("column-3", "portlet-column-content portlet-column-content-first")
		</div>
		<div class="aui-w50 portlet-column" id="column-4">
			$processor.processColumn("column-4", "portlet-column-content")
		</div>
	</div>
	<div class="portlet-layout">
		<div class="aui-w25 portlet-column portlet-column-first" id="column-5">
			$processor.processColumn("column-5", "portlet-column-content portlet-column-content-first")
		</div>
		<div class="aui-w25 portlet-column" id="column-6">
			$processor.processColumn("column-6", "portlet-column-content")
		</div>
		<div class="aui-w25 portlet-column portlet-column-last" id="column-7">
			$processor.processColumn("column-7", "portlet-column-content")
		</div>
		<div class="aui-w25 portlet-column portlet-column-last" id="column-8">
			$processor.processColumn("column-8", "portlet-column-content portlet-column-content-last")
		</div>
	</div>
#end
</div>
