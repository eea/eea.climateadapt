package nl.wur.alterra.quickanddirtyows.wcs;

import java.io.ByteArrayOutputStream;

public class Coverage {

	private String identifier;

	private String outputFormat;
	
	private Extent extent;
	
	private Extent lonLatExtent;
	
	private double xResolution;
	
	private double yResolution;
	
	private double xOrigin;
	
	private double yOrigin;
	
	private ByteArrayOutputStream outputStream;
	
	public Coverage(String identifier, String outputFormat, Extent extent,
			Extent lonLatExtent, double xResolution, double yResolution,
			double xOrigin, double yOrigin, ByteArrayOutputStream outputStream) {
		super();
		this.identifier = identifier;
		this.outputFormat = outputFormat;
		this.extent = extent;
		this.lonLatExtent = lonLatExtent;
		this.xResolution = xResolution;
		this.yResolution = yResolution;
		this.xOrigin = xOrigin;
		this.yOrigin = yOrigin;
		this.outputStream = outputStream;
	}

	protected String getOutputFormat() {
		return outputFormat;
	}

	protected void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}

	protected String getIdentifier() {
		return identifier;
	}

	protected void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	protected Extent getExtent() {
		return extent;
	}

	protected void setExtent(Extent extent) {
		this.extent = extent;
	}

	protected Extent getLonLatExtent() {
		return lonLatExtent;
	}

	protected void setLonLatExtent(Extent lonLatExtent) {
		this.lonLatExtent = lonLatExtent;
	}

	protected double getxResolution() {
		return xResolution;
	}

	protected void setxResolution(double xResolution) {
		this.xResolution = xResolution;
	}

	protected double getyResolution() {
		return yResolution;
	}

	protected void setyResolution(double yResolution) {
		this.yResolution = yResolution;
	}

	protected double getxOrigin() {
		return xOrigin;
	}

	protected void setxOrigin(double xOrigin) {
		this.xOrigin = xOrigin;
	}

	protected double getyOrigin() {
		return yOrigin;
	}

	protected void setyOrigin(double yOrigin) {
		this.yOrigin = yOrigin;
	}

	protected ByteArrayOutputStream getOutputStream() {
		return outputStream;
	}

	protected void setOutputStream(ByteArrayOutputStream outputStream) {
		this.outputStream = outputStream;
	}
}
