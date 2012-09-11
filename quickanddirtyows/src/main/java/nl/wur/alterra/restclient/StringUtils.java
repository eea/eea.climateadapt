package nl.wur.alterra.restclient;

public class StringUtils {

	public static String fix(String aString) {
        String result = aString.replaceAll("\\p{Punct}", "_");

		return result;
	}
	
	public static String checkAndAppend(String aCheckString, String aAppendString) {
		if (aCheckString.endsWith(aAppendString)) {
			return aCheckString;
		} else {
			return aCheckString + aAppendString;
		}
	}
	
	public static String Before(String aSearchString, String aFindString) {
		int pos = aSearchString.indexOf(aFindString);

		return aSearchString.substring(0, pos);
	}
	
	public static String After(String aSearchString, String aFindString) {
		int pos = aSearchString.indexOf(aFindString);
		
		return aSearchString.substring(pos + 1, aSearchString.length());
	}
}
