package br.com.seuze.store.system.enumeration;

import java.util.LinkedHashMap;
import java.util.Map;

public enum ProductCategory {
	WOMEN("W", "Women's"), MEN("M", "Men's"), CHILDREN("C", "Children’s");
	
	private final String value;
    private final String description;
	
    private static final Map<String, ProductCategory> listOfCategorys = new LinkedHashMap<>();
	 
    static {
    	for(ProductCategory productCategory : ProductCategory.values()) { 
    		listOfCategorys.put(productCategory.getValue(), productCategory);
    		}
    }
    
    private ProductCategory(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public String getValue() {
		return value;
	}
	public String getDescription() {
		return description;
	}
	public static Map<String, ProductCategory> getListofcategorys() {
		return listOfCategorys;
	}
}
