package nl.wur.alterra.cgi.ace.mapviewer.mapstate;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MapStateList extends ArrayList<MapState> {

	private static final long serialVersionUID = -3382450652048951246L;
	
	public MapState getMapState(String aMapViewerAppId, String aMapViewerWmcDirectory) throws Exception {
		MapState result = findMapState(aMapViewerAppId);
		
		if (result == null) {
			result = getInitialMapState(aMapViewerAppId, aMapViewerWmcDirectory);
			
			add(result);
		}
		
		return result;
	}

	public MapState findMapState(String aMapViewerAppId) throws Exception {
		MapState result = null;
		
		for (int i = 0; i < size(); i ++) {
			MapState mapstate = get(i);
			
			if (mapstate.getMapVieweAppId().equalsIgnoreCase(aMapViewerAppId)) {
				result = mapstate;
				
				break;
			}
		}
		
		return result;
	}

	private MapState getInitialMapState(String aMapViewerAppId, String aMapViewerWmcDirectory) throws Exception {
		MapState result = null;
		
		String filename = aMapViewerWmcDirectory.concat("/" + aMapViewerAppId + ".xml");
		
		File file = new File(filename);
		
		if (file.exists()) {
			FileInputStream fileinputstream = new FileInputStream(filename);
			
			DataInputStream datainputstream = new DataInputStream(fileinputstream);
			
			String mapstate = "";
			
			try {
				BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(datainputstream));
				
				try {
					String line;
					
					while ((line = bufferedreader.readLine()) != null)   {
						mapstate += line;
					}
				} finally {
					bufferedreader.close();
				}
			} finally {
				datainputstream.close();
				
				fileinputstream.close();
			}
			
			result = new MapState(aMapViewerAppId, mapstate);
		} else {
			throw new Exception("File not found: " + filename);
		}
		
		return result;
	}

}
