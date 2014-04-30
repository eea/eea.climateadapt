package nl.wur.alterra.quickanddirtyows;


/**
 * @author vanme002
 * @version 1.0
 * @created 25-Nov-2010 12:36:57
 */
public class OWSException extends Exception {

	private static final long serialVersionUID = 4990495499965324844L;

	public OWSExceptionReport owsExceptionReport;
	
	public OWSException(){
		super();
	}

	public OWSException(OWSExceptionReport owsExceptionReport) {
		super();
		this.owsExceptionReport = owsExceptionReport;
	}

	@Override
	public String getMessage() {
		return this.owsExceptionReport.exceptioncode + " - " + this.owsExceptionReport.exceptiontext;
	}
}