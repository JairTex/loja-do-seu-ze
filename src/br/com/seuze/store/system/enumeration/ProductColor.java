package br.com.seuze.store.system.enumeration;

import java.util.LinkedHashMap;
import java.util.Map;

public enum ProductColor {
	BLUE("BLU", "Blue"), LIGHT_BLUE("LBL", "Light blue"), DARK_BLUE("DBL", "Dark blue"),
	GREEN("GRE", "Green"), YELLOW("YEL", "Yellow"), ORANGE("ORA", "Orange"), PINK("PIN", "Pink"),
	RED("RED", "Red"), PURPLE("PUR", "Purple"), BROWN("BRO", "Brown"), GRAY("GR", "Gray"),
	BLACK("BLA", "Black"), WHITE("WHI", "White"), OTHER("OTH", "Other");
	
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
