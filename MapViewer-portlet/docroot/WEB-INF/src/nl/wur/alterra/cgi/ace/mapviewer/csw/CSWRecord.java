package nl.wur.alterra.cgi.ace.mapviewer.csw;

import nl.wur.alterra.cgi.ace.mapviewer.csw.digitaltransferoption.DigitalTransferOptions;

public class CSWRecord {

	private String title;

	DigitalTransferOptions digitalTransferOptions;

	public CSWRecord() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public DigitalTransferOptions getDigitalTransferOptions() {
		return digitalTransferOptions;
	}

	public void setDigitalTransferOptions(
			DigitalTransferOptions digitalTransferOptions) {
		this.digitalTransferOptions = digitalTransferOptions;
	}
}
