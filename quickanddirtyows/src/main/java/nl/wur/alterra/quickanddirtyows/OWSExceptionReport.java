package nl.wur.alterra.quickanddirtyows;

/**
 * @author vanme002
 * @version 1.0
 * @created 25-Nov-2010 12:37:06
 */
public class OWSExceptionReport {

	public String exceptioncode;
	public String exceptiontext;
	public String locator;
	
	public OWSExceptionReport(){
		super();
	}
	
	public OWSExceptionReport(String exceptioncode, String exceptiontext,
			String locator) {
		super();
		this.exceptioncode = exceptioncode;
		this.exceptiontext = exceptiontext;
		this.locator = locator;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}