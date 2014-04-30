package nl.wur.alterra.quickanddirtyows.csw.digitaltransferoption;

public class DigitalTransferOption {

	private String url;
	
	private String layerName;
	
	private String layerTitle;
	
	private String protocol;

	public DigitalTransferOption(String url, String layerName, String layerTitle, String protocol) {
		super();
		
		this.url = url;
		
		this.layerName = layerName;
		
		this.layerTitle = layerTitle;
		
		this.protocol = protocol;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLayerName() {
		return layerName;
	}

	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}

	public String getLayerTitle() {
		return layerTitle;
	}

	public void setLayertitle(String layerTitle) {
		this.layerTitle = layerTitle;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
}
