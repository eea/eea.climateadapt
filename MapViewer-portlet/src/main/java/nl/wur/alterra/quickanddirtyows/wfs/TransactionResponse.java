package nl.wur.alterra.quickanddirtyows.wfs;

public class TransactionResponse {
	
	// <?xml version="1.0" encoding="UTF-8"?>
	// <wfs:WFS_TransactionResponse version="1.0.0" xmlns:wfs="http://www.opengis.net/wfs" xmlns:ogc="http://www.opengis.net/ogc" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.opengis.net/wfs http://localhost:8080/geoserver/schemas/wfs/1.0.0/WFS-transaction.xsd">
	// <wfs:InsertResult>
	// <ogc:FeatureId fid="none"/>
	// </wfs:InsertResult> 
	// <wfs:TransactionResult> 
	// <wfs:Status> 
	// <wfs:FAILED/> 
	// </wfs:Status> 
	// <wfs:Message>Error performing insert: Error inserting features</wfs:Message> 
	// </wfs:TransactionResult>
	// </wfs:WFS_TransactionResponse>
	public String status;
	
	public String message;
	
	public int inserted;
	
	public int updated;
	
	public int deleted;

	public TransactionResponse(String status, String message, int inserted,
			int updated, int deleted) {
		super();
		this.status = status;
		this.message = message;
		this.inserted = inserted;
		this.updated = updated;
		this.deleted = deleted;
	}
}
