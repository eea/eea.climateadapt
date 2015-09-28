<style>
		html,body{
			padding:0;
			margin:0;
			height:100%;
		}
		#pagina{
			position:relative;
			width:100%;
			overflow-y: auto;
		}
		#contenedor{
			width:70%;
			height:100%;
			background-color:#FFFFFF;
			position:absolute;
		}
		.contenedorPadding{
			padding:10px;
		}
		#summary{
			width:30%;
			height:100%;
			background-color:#d2de92;
			float:right;
		}
		#logos{
			width:100%;
			height:144px;
			position: relative;
		}
		#logoMayors{
			position:absolute;
			top:0px;
			left:0px;
		}
		#logoStatus{
			position:absolute;
			top:0px;
			right:0px;		
			left:300px;
		}
		.textoContenido{
			text-align: justify;
		}
        #map-canvas {
            width: 260px;
            height: 200px;
          }		
	</style>	
<script src="https://maps.googleapis.com/maps/api/js"></script>
<script>
  function initialize() {
    var mapCanvas = document.getElementById('map-canvas');
    var mapOptions = {
      center: new google.maps.LatLng(${a_m_city_latitude.getData()},${a_m_city_longitude.getData()}),
      zoom: 8,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    var map = new google.maps.Map(mapCanvas, mapOptions)
  }
  google.maps.event.addDomListener(window, 'load', initialize);
</script>

<div id="pagina">
	<div id="contenedor">
		<div class="contenedorPadding">
			<div id="logos">
				<div id="logoMayors">
					<img src="http://mayors-adapt.eu/wp-content/themes/mayoradapt/images/logo.png" />
				</div>
				<div id="logoStatus">
					<img src="/documents/18/11263941/stage_${c_m_stage_of_the_implementation_cycle.getData()}.png" style="max-width: 100%;"/>
				</div>				
			</div>
			<div>
				<h1>${.vars['reserved-article-title'].data} - ${a_m_country.getData()}</h1>
				<p class="textoContenido">
				${b_city_background.getData()}
				</p>
				  <div class="sector-main-article">
					  <div id="read-more-link" style="position:inherit;width:inherit">
						<a style="text-decoration:none;">Climate change impacts and adaptation responses</a>
					  </div>  
				  </div>				
				<p class="textoContenido">
                    ${b_climate_impacts_additional_information.getData()}
                </p>
				  <div class="sector-main-article">
					  <div id="read-more-link" style="position:inherit;width:inherit">
						<a style="text-decoration:none;">Planned adaptation actions</a>
					  </div>  
				  </div>				
				<p class="textoContenido">
					${e_m_planed_adaptation_actions.getData()}
				</p>
				  <div class="sector-main-article">
					  <div id="read-more-link" style="position:inherit;width:inherit">
						<a style="text-decoration:none;">Good practice / spotlight item</a>
					  </div>  
				  </div>				
				<p class="textoContenido">
				<b>${f_m_action_event_title.getData()}</b><br/>
				${f_m_action_event_long_description.getData()}<br/>
				<div>
	                <img alt="" src="${f_picture.getData()}" style="max-width: 100%;" />
    		        <#if f_picture_caption??>
			            <#if f_picture_caption.getData() != "null">
			                <p class="textoContenido">
    		                    ${f_picture_caption.getData()}
    		                </p>
    		            </#if>
			        </#if>
				</div>
				</p>
			</div>
		</div>
	</div>
	<div id="summary">
		<div class="contenedorPadding">
			<div id="map-canvas" style="float:top"></div>

			<b>Climate Change Impacts</b><br/>
            <#if b_m_climate_impacts??>
                ${b_m_climate_impacts.getData()}
                <#list b_m_climate_impacts.getOptions() as climate_impact>
                    <ul>
                        <li>${climate_impact}</li>
                    </ul>
	            </#list>
            </#if><br/>
			<b>Key vulnerable sectors</b><br/>
            <#if b_m_sector??>
                ${b_m_sector.getData()}
                <#list b_m_sector.getOptions() as sector>
                    <ul>
                        <li>${sector}</li>
                    </ul>
	            </#list>
            </#if><br/>			
			<b>Name & surname of mayor</b><br/>
	    	${b_m_name_surname_of_mayor.getData()}<br/><br/>
			<b>Population</b><br/>
			<#if a_population_size??>
			    <#if a_population_size.getData() != "null">
				    ${a_population_size.getData()} inhabitants
				</#if>
			</#if><br/><br/>
			<b>Contact person</b><br/>
			${b_m_r_name_surname_of_contact_person.getData()}<br/>
			${b_m_role_of_contact_person.getData()}<br/><br/>
			<b>Official e-mail</b><br/>
			${b_m_official_email.getData()}<br/>
			<a href="${b_m_website_of_the_local_authority.getData()}"/>Website</a><br/><br/>
			<b>Date of oficial joining to Mayors Adapt</b><br/>
			<#assign b_signature_date_DateObj = dateUtil.newDate(getterUtil.getLong(b_signature_date.getData()))>
			${dateUtil.getDate(b_signature_date_DateObj, "dd MMM yyyy", locale)}<br/><br/>
			<b>Covenant of mayors signatory (yes/no)</b><br/>
			<#if getterUtil.getBoolean(b_m_covenant_of_mayors_signatory.getData())>
			    Yes
			</#if>
			<#if !getterUtil.getBoolean(b_m_covenant_of_mayors_signatory.getData())>
			    No
			</#if>			
			<br/><br/>
			<b>Last Update:</b><br/>
			${.vars['reserved-article-modified-date'].data}
			<br/><br/>
		</div>
	</div>
</div>