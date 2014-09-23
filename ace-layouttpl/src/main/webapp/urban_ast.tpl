<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script type="text/javascript">


		   	$(document).ready(function() {
				$("#ast-menu").accordion({
					autoHeight: false,
					navigation: true,
					navigationFilter: function(){
					    // assumes ast/ in url before /step
					    var doc_rel_href = document.location.href.substr( document.location.href.indexOf('ast/step')+4 );

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
      <li><a href="/tools/urban-ast" name="step-0" onclick="document.location.href='/tools/urban-ast'"><strong>0.</strong> The Urban Adaptation Support Tool - Getting started</a>
        <ul id="step-0">
          <li><a href="/tools/urban-ast/step-0-1" name="step-0-1" onclick="document.location.href='/tools/urban-ast/step-0-1'"><p>0.1 How to use the Urban Adaptation Support Tool?</p></a></li>
          <li><a href="/tools/urban-ast/step-0-2" name="step-0-2" onclick="document.location.href='/tools/urban-ast/step-0-2'"><p>0.2 How is the European climate changing and what are the consequences for urban areas?</p></a></li>
          <li><a href="/tools/urban-ast/step-0-3" name="step-0-3" onclick="document.location.href='/tools/urban-ast/step-0-3'"><p>0.3 What is adaptation to climate change and why does it matter in my city/town?</p></a></li>
          <li><a href="/tools/urban-ast/step-0-4" name="step-0-4" onclick="document.location.href='/tools/urban-ast/step-0-4'"><p>0.4 What are the key principles for adaptation?</p></a></li>
          <li><a href="/tools/urban-ast/step-0-5" name="step-0-5" onclick="document.location.href='/tools/urban-ast/step-0-5'"><p>0.5 Where can I find support for adaptation planning in the form of advice and capacity building?</p></a></li>
        </ul>
      </li>
      <li><a href="/tools/urban-ast/step-1" name="step-1" onclick="document.location.href='/tools/urban-ast/step-1'"><strong>1.</strong> Preparing the ground for adaptation</a>
        <ul id="step-1">
          <li><a href="/tools/urban-ast/step-1/step-1-1" name="step-1-1" onclick="document.location.href='/tools/urban-ast/step-1/step-1-1'"><p>1.1 How do I ensure high level political support for adaptation now and in the long run?</p></a></li>
          <li><a href="/tools/urban-ast/step-1/step-1-2" name="step-1-2" onclick="document.location.href='/tools/urban-ast/step-1/step-1-2'"><p>1.2 How do I set up the adaptation process within my municipality?</p></a></li>
          <li><a href="/tools/urban-ast/step-1/step-1-3" name="step-1-3" onclick="document.location.href='/tools/urban-ast/step-1/step-1-3'"><p>1.3 What human, technical and financial resources are required for adaptation planning and management?</p></a></li>
          <li><a href="/tools/urban-ast/step-1/step-1-4" name="step-1-4" onclick="document.location.href='/tools/urban-ast/step-1/step-1-4'"><p>1.4 What financial support is available for adaptation?</p></a></li>
          <li><a href="/tools/urban-ast/step-1/step-1-5" name="step-1-5" onclick="document.location.href='/tools/urban-ast/step-1/step-1-5'"><p>1.5 What initial information do I need to collect?</p></a></li>
          <li><a href="/tools/urban-ast/step-1/step-1-6" name="step-1-6" onclick="document.location.href='/tools/urban-ast/step-1/step-1-6'"><p>1.6 Who are the main (internal and external) players and stakeholders in adaptation processes and how do I involve them?</p></a></li>
          <li><a href="/tools/urban-ast/step-1/step-1-7" name="step-1-7" onclick="document.location.href='/tools/urban-ast/step-1/step-1-7'"><p>1.7 How do I communicate adaptation to climate change?</p></a>
            <ul id="step-1-7">
              <li><a href="/tools/urban-ast/step-1/self-check" name="step-1-7-1" onclick="document.location.href='/tools/urban-ast/step-1/self-check'"><p>SELF-CHECK</p></a></li>
            </ul>
          </li>
        </ul>
      </li>
      <li><a href="/tools/urban-ast/step-2" name="step-2" onclick="document.location.href='/tools/urban-ast/step-2'"><strong>2.</strong> Assessing risks and vulnerabilities to climate change</a>
        <ul id="step-2">
          <li><a href="/tools/urban-ast/step-2/step-2-1" name="step-2-1" onclick="document.location.href='/tools/urban-ast/step-2/step-2-1'"><p>2.1 What impacts has the past and current weather had/have on my city/town?</p></a></li>
          <li><a href="/tools/urban-ast/step-2/step-2-2" name="step-2-2" onclick="document.location.href='/tools/urban-ast/step-2/step-2-2'"><p>2.2 What methodology can I use for carrying out risk or vulnerability assessment?</p></a></li>
          <li><a href="/tools/urban-ast/step-2/step-2-3" name="step-2-3" onclick="document.location.href='/tools/urban-ast/step-2/step-2-3'"><p>2.3 Where can I find future climate and impact projections for my city/town and how to understand them?</p></a></li>
          <li><a href="/tools/urban-ast/step-2/step-2-4" name="step-2-4" onclick="document.location.href='/tools/urban-ast/step-2/step-2-4'"><p>2.4 How certain are future climate projections and how do I deal with the uncertainty?</p></a></li>
          <li><a href="/tools/urban-ast/step-2/step-2-5" name="step-2-5" onclick="document.location.href='/tools/urban-ast/step-2/step-2-5'"><p>2.5 Which sectors in my city/town are most likely to be impacted by climate change and how?</p></a></li>
          <li><a href="/tools/urban-ast/step-2/step-2-6" name="step-2-6" onclick="document.location.href='/tools/urban-ast/step-2/step-2-6'"><p>2.6 What is the role of the surrounding areas in adaptation and how do I take that into account?</p></a></li>
          <li><a href="/tools/urban-ast/step-2/step-2-7" name="step-2-7" onclick="document.location.href='/tools/urban-ast/step-2/step-2-7'"><p>2.7 Whom can I approach for further information, data and analysis assistance?</p></a></li>
          <li><a href="/tools/urban-ast/step-2/step-2-8" name="step-2-8" onclick="document.location.href='/tools/urban-ast/step-2/step-2-8'"><p>2.8 How do I identify the main adaptation concerns and set the strategic direction?</p></a></li>          
          <li><a href="/tools/urban-ast/step-2/step-2-9" name="step-2-9" onclick="document.location.href='/tools/urban-ast/step-2/step-2-9'"><p>2.9 How to set concrete Targets for adaptation?</p></a>
            <ul id="step-2-9">
              <li><a href="/tools/urban-ast/step-2/self-check" name="step-2-9-1" onclick="document.location.href='/tools/urban-ast/step-2/self-check'"><p>SELF-CHECK</p></a></li>
            </ul>
          </li>
        </ul>
      </li>
      <li><a href="/tools/urban-ast/step-3" name="step-3" onclick="document.location.href='/tools/urban-ast/step-3'"><strong>3.</strong> Identifying adaptation options</a>
        <ul id="step-3">
          <li><a href="/tools/urban-ast/step-3/step-3-1" name="step-3-1" onclick="document.location.href='/tools/urban-ast/step-3/step-3-1'"><p>3.1 What adaptation measures for urban cities exist and how to set up a catalogue of measures?</p></a></li>
          <li><a href="/tools/urban-ast/step-3/step-3-2" name="step-3-2" onclick="document.location.href='/tools/urban-ast/step-3/step-3-2'"><p>3.2 Where can I find examples of good adaptation practice of other cities and towns?</p></a></li>
          <li><a href="/tools/urban-ast/step-3/step-3-3" name="step-3-3" onclick="document.location.href='/tools/urban-ast/step-3/step-3-3'"><p>3.3 How do I identify the existing adaptation measures in my city/town?</p></a>
            <ul id="step-3-3">
              <li><a href="/tools/urban-ast/step-3/self-check" name="step-3-3-1" onclick="document.location.href='/tools/urban-ast/step-3/self-check'"><p>SELF-CHECK</p></a></li>
            </ul>
          </li>
        </ul>
      </li>
      <li><a href="/tools/urban-ast/step-4" name="step-4" onclick="document.location.href='/tools/urban-ast/step-4'"><strong>4.</strong> Assessing and selecting adaptation options</a>
        <ul id="step-4">
          <li><a href="/tools/urban-ast/step-4/step-4-1" name="step-4-1" onclick="document.location.href='/tools/urban-ast/step-4/step-4-1'"><p>4.1 What are the main aspects of adaptation measures that need to be assessed and described in detail?</p></a></li>
          <li><a href="/tools/urban-ast/step-4/step-4-2" name="step-4-2" onclick="document.location.href='/tools/urban-ast/step-4/step-4-2'"><p>4.2 What methodologies can I apply for the evaluation of adaptation measures and the identification of the most suitable ones?</p></a></li>
          <li><a href="/tools/urban-ast/step-4/step-4-3" name="step-4-3" onclick="document.location.href='/tools/urban-ast/step-4/step-4-3'"><p>4.3 How do I carry out cost-benefit analysis?</p></a></li>
          <li><a href="/tools/urban-ast/step-4/step-4-4" name="step-4-4" onclick="document.location.href='/tools/urban-ast/step-4/step-4-4'"><p>4.4 How to assess cross-cutting issues, trade-offs and synergies of adaptation options?</p></a></li>
          <li><a href="/tools/urban-ast/step-4/step-4-5" name="step-4-5" onclick="document.location.href='/tools/urban-ast/step-4/step-4-5'"><p>4.5 How to prioritise adaptation options and select the preferable ones?</p></a>
            <ul id="step-4-5">
              <li><a href="/tools/urban-ast/step-4/self-check" name="step-4-5-1" onclick="document.location.href='/tools/urban-ast/step-4/self-check'"><p>SELF-CHECK</p></a></li>
            </ul>
          </li>
        </ul>
      </li>
      <li><a href="/tools/urban-ast/step-5" name="step-5" onclick="document.location.href='/tools/urban-ast/step-5'"><strong>5.</strong> Implementation</a>
        <ul id="step-5">
          <li><a href="/tools/urban-ast/step-5/step-5-1" name="step-5-1" onclick="document.location.href='/tools/urban-ast/step-5/step-5-1'"><p>5.1 What are the main elements of a good adaptation strategy?</p></a></li>
          <li><a href="/tools/urban-ast/step-5/step-5-2" name="step-5-2" onclick="document.location.href='/tools/urban-ast/step-5/step-5-2'"><p>5.2 Where do I find good examples of existing adaptation strategies and action plans in urban areas?</p></a></li>
          <li><a href="/tools/urban-ast/step-5/step-5-3" name="step-5-3" onclick="document.location.href='/tools/urban-ast/step-5/step-5-3'"><p>5.3 How can I best apply mainstreaming adaptation into the existing urban policy framework and what instruments can I put in place?</p></a>
            <ul id="step-5-3">
              <li><a href="/tools/urban-ast/step-5/self-check" name="step-5-3-1" onclick="document.location.href='/tools/urban-ast/step-5/self-check'"><p>SELF-CHECK</p></a></li>
            </ul>
          </li>
        </ul>
      </li>
      <li><a href="/tools/urban-ast/step-6" name="step-6" onclick="document.location.href='/tools/urban-ast/step-6'"><strong>6.</strong> Monitoring and evaluation</a>
        <ul id="step-6">
            <li><a href="/tools/urban-ast/step-6/step-6-1" name="step-6-1" onclick="document.location.href='/tools/urban-ast/step-6/step-6-1'"><p>6.1 What approaches for monitoring and evaluation can I apply?</p></a></li>
            <li><a href="/tools/urban-ast/step-6/step-6-2" name="step-6-2" onclick="document.location.href='/tools/urban-ast/step-6/step-6-2'"><p>6.2 How do I develop indicators for adaptation?</p></a></li>        
            <li><a href="/tools/urban-ast/step-6/step-6-3" name="step-6-3" onclick="document.location.href='/tools/urban-ast/step-6/step-6-3'"><p>6.3 Where can I find examples of adaptation indicators?</p></a>
                <ul id="step-6-3">
                    <li><a href="/tools/urban-ast/step-6/self-check" name="step-6-3-1" onclick="document.location.href='/tools/urban-ast/step-6/self-check'"><p>SELF-CHECK</p></a></li>
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