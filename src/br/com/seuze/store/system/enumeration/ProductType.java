package br.com.seuze.store.system.enumeration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public enum ProductType {
	SHIRT("SHI", "Shirt"), SHORTS("SCH", "Shorts"), PANTS("PAN", "Pants"),
	SHOES("SHO", "Shoes"), HAT("HAT", "Hat"), SWIMMING_CAP("SCA", "Swimming Cap");
	
    private final String value;
    private final String description;
	
    private static final Map<String, ProductType> listOfTypes = new LinkedHashMap<>();
	 
    static {
    	for(ProductType productType : ProductType.values()) { 
    		listOfTypes.put(productType.getValue(), productType);
    		}
    }
    
    private ProductType(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public String getValue() {
		return value;
	}
	public String getDescription() {
		return description;
	}
	public static Map<String, ProductType> getListoftypes() {
		return listOfTypes;
	}
}
