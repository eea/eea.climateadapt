<style>
  #map-canvas {
    width: 400px;
    height: 200px;
  }
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
function submitForm() {
    $.ajax({type:'POST', url: '/portal/test', data:$('#form').serialize(), success: function(response) {
        $('#form').find('.result').html(response);
    }});
    return false;
	}
</script>
<script src="https://maps.googleapis.com/maps/api/js"></script>
<script>
	var map ;
  function initialize() {
    var mapCanvas = document.getElementById('map-canvas');
    var mapOptions = {
      center: new google.maps.LatLng(41, 2),
      zoom: 4,
      mapTypeId: google.maps.MapTypeId.HYBRID
    }
     map = new google.maps.Map(mapCanvas, mapOptions)
  }

    function addCity(name, lat,  long) {
        var mapCanvas = document.getElementById('map-canvas');
        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(lat,long),
            title: name
   		});
    marker.setMap(map);
    }
  google.maps.event.addDomListener(window, 'load', initialize);
</script>
<div>
    <div id="map-canvas" style="float:right">
</div>
<div name="choices">
	<H3>Climate Impacts</H3>
	<label for="Extreme Temperatures"><input type="checkbox" id="Water" onClick="addCity('Paris',42,3);"/>Extreme Temperatures</label>
	<label for="two"><input type="checkbox" id="Water Scarcity" onClick="addCity('Madrid',43,4);"/>Water Scarcity</label>
	<label for="Flooding"><input type="checkbox" id="Flooding" onClick="addCity('Rome',44,5);"/>Flooding</label>
</div>
<div name="form" onClick="submitForm()">
	<H3>Climate Impacts</H3>
	<label for="Extreme Temperatures"><input type="checkbox" id="Extreme Temperatures"/>Extreme Temperatures</label>
	<label for="two"><input type="checkbox" id="Water Scarcity" />Water Scarcity</label>
	<label for="Flooding"><input type="checkbox" id="Flooding"/>Flooding</label>
	<input type="text" id="result"/>
</div>