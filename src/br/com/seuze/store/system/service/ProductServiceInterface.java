package br.com.seuze.store.system.service;

import java.util.LinkedHashMap;

import br.com.seuze.store.system.data.ProductData;
import br.com.seuze.store.system.enumeration.ProductCategory;
import br.com.seuze.store.system.enumeration.ProductColor;
import br.com.seuze.store.system.enumeration.ProductDepartment;
import br.com.seuze.store.system.enumeration.ProductType;

public interface ProductServiceInterface {
	public String register(String description, ProductCategory category, ProductDepartment department,
			ProductType type, ProductColor color, String size, int amount, Double value);
	public String generateSku(ProductCategory category, ProductDepartment department, ProductType type, ProductColor color);
	public boolean isValid(Object object);
	public boolean removeFromStock(String sku, int amount);
	public boolean addToStock(String sku, int amount);
	public boolean addProductToBag(String sku, String bagId, int amount) throws CloneNotSupportedException;
	public Object searchBySku (String sku);
	public LinkedHashMap<String, Object> searchByCategory (ProductCategory category);
	public LinkedHashMap<String, Object> searchByDepartment (ProductDepartment department);
	public LinkedHashMap<String, Object> searchByType (ProductType type);
	public LinkedHashMap<String, Object> searchByColor (ProductColor color);
	public LinkedHashMap<String, Object> searchBySize (String size);
	public ProductData listStock();
}
