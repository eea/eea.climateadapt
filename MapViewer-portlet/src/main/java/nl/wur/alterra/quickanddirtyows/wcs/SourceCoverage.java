package nl.wur.alterra.quickanddirtyows.wcs;

import java.io.File;


public class SourceCoverage {

	private String identifier;

	private String outputFormat;
	
	private Extent extent;
	
	private Extent lonLatExtent;
	
	private double xResolution;
	
	private double yResolution;
	
	private double xOrigin;
	
	private double yOrigin;
	
	private File file;
	
	public SourceCoverage(String identifier, String outputFormat,
			Extent extent, Extent lonLatExtent, double xResolution,
			double yResolution, double xOrigin, double yOrigin,
			File aFile) {
		super();
		this.identifier = identifier;
		this.outputFormat = outputFormat;
		this.extent = extent;
		this.lonLatExtent = lonLatExtent;
		this.xResolution = xResolution;
		this.yResolution = yResolution;
		this.xOrigin = xOrigin;
		this.yOrigin = yOrigin;
		this.file = aFile;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getOutputFormat() {
		return outputFormat;
	}

	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}

	public Extent getExtent() {
		return extent;
	}

	public void setExtent(Extent extent) {
		this.extent = extent;
	}

	public Extent getLonLatExtent() {
		return lonLatExtent;
	}

	public void setLonLatExtent(Extent lonLatExtent) {
		this.lonLatExtent = lonLatExtent;
	}

	public double getxResolution() {
		return xResolution;
	}

	public void setxResolution(double xResolution) {
		this.xResolution = xResolution;
	}

	public double getyResolution() {
		return yResolution;
	}

	public void setyResolution(double yResolution) {
		this.yResolution = yResolution;
	}

	public double getxOrigin() {
		return xOrigin;
	}

	public void setxOrigin(double xOrigin) {
		this.xOrigin = xOrigin;
	}

	public double getyOrigin() {
		return yOrigin;
	}

	public void setyOrigin(double yOrigin) {
		this.yOrigin = yOrigin;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
