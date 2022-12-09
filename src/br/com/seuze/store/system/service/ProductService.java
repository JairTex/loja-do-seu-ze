package br.com.seuze.store.system.service;

import java.util.LinkedHashMap;

import br.com.seuze.store.system.data.ProductData;
import br.com.seuze.store.system.data.SaleData;
import br.com.seuze.store.system.enumeration.ProductCategory;
import br.com.seuze.store.system.enumeration.ProductColor;
import br.com.seuze.store.system.enumeration.ProductDepartment;
import br.com.seuze.store.system.enumeration.ProductType;
import br.com.seuze.store.system.model.Product;
import br.com.seuze.store.system.model.Sale;

public class ProductService implements ProductServiceInterface{
	private static ProductData productData = new ProductData();
	private static SaleService saleService = new SaleService();
	private static SaleData saleData = saleService.listSales();
	
	public String register(String description, ProductCategory category, ProductDepartment department,
			ProductType type, ProductColor color, String size, int amount, Double value) {
		
		LinkedHashMap<String, Object> stock = productData.listAll();
		Product product = new Product(generateSku(category, department, type, color), description, category, department, 
				type, color, size, amount, value);
		
		if(isValid(product)) {
			if(stock.containsKey(product.getSku())){
				Product productRegistered = (Product) stock.get(product.getSku());
				
				productRegistered.setDescription(product.getDescription());
				productRegistered.setAmount(productRegistered.getAmount() + product.getAmount());
				productRegistered.setValue(value);
				
				productData.update(productRegistered);
				
				return productRegistered.getSku();
			} else {
				productData.save(product);
				return product.getSku();
			}
		}
		return "The product " + product.getSku() + " is invalid!";
	}
	
	public String generateSku(ProductCategory category, ProductDepartment department, ProductType type, ProductColor color) {
		String Sku = category.getValue() + department.getValue() + type.getValue() + color.getValue();
		return Sku;
	}
	
	public boolean isValid(Object object) {
		Product product = (Product) object;
		if(product.getAmount() >= 0 && product.getValue() >= 0.0 
				&& !product.getSku().isBlank() && !product.getSku().isEmpty()
				&& !product.getSize().isBlank() && !product.getSize().isEmpty()){
			
			return true;
		}
		return false;
	}
	
	public boolean removeFromStock(String sku, int amount) {
		LinkedHashMap<String, Object> stock = productData.listAll();
		if(stock.containsKey(sku.toUpperCase())) {
			Product product = (Product) stock.get(sku);
			product.setAmount(product.getAmount() - amount);
			
			productData.update(product);
			return true;
		}		
		return false;
	}
	
	public boolean addToStock(String sku, int amount) {
		LinkedHashMap<String, Object> stock = productData.listAll();
		if(stock.containsKey(sku.toUpperCase())) {
			Product product = (Product) stock.get(sku);
			product.setAmount(product.getAmount() + amount);
			
			productData.update(product);
			return true;
		}		
		return false;
	}
	
	public boolean addProductToBag(String sku, String bagId, int amount) throws CloneNotSupportedException {
		LinkedHashMap<String, Object> salesList = saleData.listAll();
		LinkedHashMap<String, Object> stock = productData.listAll();
		if(salesList.containsKey(bagId) && stock.containsKey(sku)) {
			Product productBag = (Product) stock.get(sku);
			Product productBagClone = (Product) productBag.clone();
			productBagClone.setAmount(amount);
			
			Sale sale = (Sale) salesList.get(bagId);
			sale.getBag().add(productBagClone);
			saleData.update(sale);
			
			return true;
		}
		return false;
	}
	
	public Object searchBySku(String sku) {
		LinkedHashMap<String, Object> stock = productData.listAll();
		
		for(String key : stock.keySet()) {
			if (key.equalsIgnoreCase(sku)) {
				Product product = (Product) stock.get(key);
				return product;
			}
		}
		return null;
	}
	
	public LinkedHashMap<String, Object> searchByCategory(ProductCategory category) {
		LinkedHashMap<String, Object> stock = productData.listAll();
		LinkedHashMap<String, Object> stockCategory = new LinkedHashMap<>();
		
		for(String key : stock.keySet()) {
			Product product = (Product) stock.get(key);
			if (product.getCategory() == category) {
				stockCategory.put(product.getSku(), product);
			}
		}
		return stockCategory;
	}
	
	public LinkedHashMap<String, Object> searchByDepartment(ProductDepartment department) {
		LinkedHashMap<String, Object> stock = productData.listAll();
		LinkedHashMap<String, Object> stockDepartment = new LinkedHashMap<>();
		
		for(String key : stock.keySet()) {
			Product product = (Product) stock.get(key);
			if (product.getDepartment() == department) {
				stockDepartment.put(product.getSku(), product);
			}
		}
		return stockDepartment;
	}
	
	public LinkedHashMap<String, Object> searchByType(ProductType type) {
		LinkedHashMap<String, Object> stock = productData.listAll();
		LinkedHashMap<String, Object> stockType = new LinkedHashMap<>();
		
		for(String key : stock.keySet()) {
			Product product = (Product) stock.get(key);
			if (product.getType() == type) {
				stockType.put(product.getSku(), product);
			}
		}
		return stockType;
	}
	
	public LinkedHashMap<String, Object> searchByColor(ProductColor color) {
		LinkedHashMap<String, Object> stock = productData.listAll();
		LinkedHashMap<String, Object> stockColor = new LinkedHashMap<>();
		
		for(String key : stock.keySet()) {
			Product product = (Product) stock.get(key);
			if (product.getColor() == color) {
				stockColor.put(product.getSku(), product);
			}
		}
		return stockColor;
	}
	
	public LinkedHashMap<String, Object> searchBySize(String size) {
		LinkedHashMap<String, Object> stock = productData.listAll();
		LinkedHashMap<String, Object> stockSize = new LinkedHashMap<>();
		
		for(String key : stock.keySet()) {
			Product product = (Product) stock.get(key);
			if (product.getSize() == size) {
				stockSize.put(product.getSku(), product);
			}
		}
		return stockSize;
	}
	public LinkedHashMap<String, Object> listAllProducts() {
		LinkedHashMap<String, Object> stock = productData.listAll();
		
		return stock;
	}
	public ProductData listStock() {
		return productData;
	}
}
