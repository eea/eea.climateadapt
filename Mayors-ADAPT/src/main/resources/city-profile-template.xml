<script>
	AUI({ filter: 'raw' }).use('aui-carousel', function(A) {
	new
	A.Carousel({
	intervalTime:5,
	contentBox: '#myCarousel',
	activeIndex:0,
	width:400,
	height:200
	}).render();

	});
</script>

<div id="page">

	<#if Image.getSiblings()?has_content>
	<div id="myCarousel">
		<#list Image.getSiblings() as cur_images>

		<#if cur_images_index==0>
		<a href="google.com">
			<div class="carousel-item"
				style="background: url(${cur_images.getData()})width:400px; height:200px;"
				class="carousel-item carousel-item-active" ;>
			</div>
		</a>
		</#if>
		<a href="google.com">
			<div class="carousel-item"
				style="background: url(${cur_images.getData()});width:400px; height:200px;"
				class="carousel-item" "></div>
		</a>
		</#list>

	</div>
	</#if>


	Climate Impacts
	<#if Climate_Impact?has_content>
	<#list
	Climate_Impact.getOptions() as impact>
	<ul>
		<li>${impact}</li>
	</ul>
	</#list>
	</#if>

</div>
