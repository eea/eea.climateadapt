package nl.wur.alterra.cgi.ace.mapviewer.csw;

import java.util.ArrayList;

import nl.wur.alterra.cgi.ace.mapviewer.csw.digitaltransferoption.DigitalTransferOption;

public class CSWRecord {

	ArrayList<DigitalTransferOption> digitalTransferOptions;

	public CSWRecord() {
		super();
		
		digitalTransferOptions = new ArrayList<DigitalTransferOption>();
	}

	public ArrayList<DigitalTransferOption> getDigitalTransferOptions() {
		return digitalTransferOptions;
	}

	public void setDigitalTransferOptions(
			ArrayList<DigitalTransferOption> digitalTransferOptions) {
		this.digitalTransferOptions = digitalTransferOptions;
	}
}
