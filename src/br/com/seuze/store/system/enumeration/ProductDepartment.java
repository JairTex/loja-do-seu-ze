package br.com.seuze.store.system.enumeration;

import java.util.LinkedHashMap;
import java.util.Map;

public enum ProductDepartment {
	CLOTHING("CL", "Clothing"), UNDERWEAR("UW", "Underwear "), 
	FOOTWEAR("FW", "Footwear"), ACCESSORIES("AC", "Accessories");
	
    private final String value;
    private final String description;
    
    private static final Map<String, ProductDepartment> listOfDepartments = new LinkedHashMap<>();
	 
    static {
    	for(ProductDepartment productDepartment : ProductDepartment.values()) { 
    		listOfDepartments.put(productDepartment.getValue(), productDepartment);
    		}
    }
    
    private ProductDepartment(String value, String description){
		this.value = value;
		this.description = description;
	}

	public String getValue() {
		return value;
	}
	public String getDescription() {
		return description;
	}
	public static Map<String, ProductDepartment> getListofdepartments() {
		return listOfDepartments;
	}
}
