package br.com.seuze.store.system.data;

import java.util.LinkedHashMap;

import br.com.seuze.store.system.model.Product;

public class ProductData implements DataInterface{
	private LinkedHashMap<String, Object> stock = new LinkedHashMap<>(); 
	public void save(Object object) {
		Product product = (Product) object;
		stock.put(product.getSku(), product);
	}
	public void update(Object object) {
		Product product = (Product) object;
		stock.replace(product.getSku(), product);
	}
	public void delete(String id) {
		stock.remove(id);
	}
	public Object getItem(String id) {
		Product product = (Product) stock.get(id);
		return product;
	}
	public LinkedHashMap<String, Object> listAll() {
		return stock;
	}
}
