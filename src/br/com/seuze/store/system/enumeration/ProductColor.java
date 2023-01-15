package br.com.seuze.store.system.enumeration;

import java.util.LinkedHashMap;
import java.util.Map;

public enum ProductColor {
	BLUE("BLU", "Blue"), GREEN("GRE", "Green"), YELLOW("YEL", "Yellow"), 
	RED("RED", "Red"), GRAY("GRA", "Gray"),	BLACK("BLA", "Black"), 
	WHITE("WHI", "White"), OTHER("OTH", "Other");
	
    private final String value;
    private final String description;
    
    private static final Map<String, ProductColor> listOfColors = new LinkedHashMap<>();
	 
    static {
    	for(ProductColor productColor : ProductColor.values()) { 
    		listOfColors.put(productColor.getValue(), productColor);
    		}
    }
    
	private ProductColor(String value, String description) {
		this.value = value;
		this.description = description;
	}
	
	public String getValue() {
		return value;
	}
	public String getDescription() {
		return description;
	}
	public static Map<String, ProductColor> getListofcolors() {
		return listOfColors;
	}
}
