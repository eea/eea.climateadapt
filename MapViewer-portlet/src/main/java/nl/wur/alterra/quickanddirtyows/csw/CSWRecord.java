package nl.wur.alterra.quickanddirtyows.csw;

import nl.wur.alterra.quickanddirtyows.csw.digitaltransferoption.DigitalTransferOptions;
import nl.wur.alterra.quickanddirtyows.csw.keyword.Keywords;

public class CSWRecord {
	
	private String fileIdentifier;

	private String title;
	
	private String abstractText;
	
	private Keywords keywords;

	private DigitalTransferOptions digitalTransferOptions;
	
	private String attribution;

	public CSWRecord() {
		super();
	}

	public String getFileIdentifier() {
		return fileIdentifier;
	}

	public void setFileIdentifier(String fileIdentifier) {
		this.fileIdentifier = fileIdentifier;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Keywords getKeywords() {
		return keywords;
	}

	public void setKeywords(Keywords keywords) {
		this.keywords = keywords;
	}

	public DigitalTransferOptions getDigitalTransferOptions() {
		return digitalTransferOptions;
	}

	public void setDigitalTransferOptions(DigitalTransferOptions digitalTransferOptions) {
		this.digitalTransferOptions = digitalTransferOptions;
	}

	public String getAbstractText() {
		return abstractText;
	}

	public void setAbstractText(String abstractText) {
		this.abstractText = abstractText;
	}

	public String getAttribution() {
		return attribution;
	}

	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}
}
