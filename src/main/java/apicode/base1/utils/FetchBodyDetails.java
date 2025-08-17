package apicode.base1.utils;

import org.json.JSONObject;

public class FetchBodyDetails {
	
	 // Add Product body
    public static String addProduct(String name) {
        return "{ \"name\": \"" + name + "\" }";
    }
    
    public static String updatename(String newName) {
    	JSONObject body = new JSONObject();
        body.put("newName", newName);  // must be "newName"
        return body.toString();

    }

}
