package nl.wur.alterra.cgi.ace.mapviewer.mapstate;

public class MapState {

	private String mapVieweAppId;
	
	private String mapState;

	public MapState(String mapVieweAppId, String mapState) {
		super();
		this.mapVieweAppId = mapVieweAppId;
		this.mapState = mapState;
	}

	public String getMapVieweAppId() {
		return mapVieweAppId;
	}

	public void setMapVieweAppId(String mapVieweAppId) {
		this.mapVieweAppId = mapVieweAppId;
	}

	public String getMapState() {
		return mapState;
	}

	public void setMapState(String mapState) {
		this.mapState = mapState;
	}
}
