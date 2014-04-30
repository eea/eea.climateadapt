package nl.wur.alterra.quickanddirtyows.urlparser;

import java.util.ArrayList;

public class OnlineResourceParser {

	private ArrayList<Parameter> parameters;
	
	private String url;
	
	public OnlineResourceParser(String aUrl) {
		super();
		
		parameters = new ArrayList<Parameter>();
		
		String[] urlquerystring = aUrl.split("\\?");
		
		if (urlquerystring.length > 1) {
			this.url = urlquerystring[0];
			
			String querystring = urlquerystring[1];
					
			String[] namevalues = querystring.split("&");
			
			for (int i = 0; i < namevalues.length; i ++) {
				String[] namevalue = namevalues[i].split("=");
				
				if (namevalue.length == 2) {
					Parameter parameter = new Parameter(namevalue[0], namevalue[1]);
					
					parameters.add(parameter);
				}
			}
			
		}
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public Parameter findParameterByName(String aName) {
		Parameter result = null;
		
		for (int i = 0; i < parameters.size(); i ++) {
			Parameter parameter = parameters.get(i);
			
			if (parameter.getName().equalsIgnoreCase(aName)) {
				result = parameter;
				
				break;
			}
		}
		
		return result;
	}
}
