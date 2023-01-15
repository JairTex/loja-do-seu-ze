package br.com.seuze.store.system.communication;

import java.util.LinkedHashMap;

import br.com.seuze.store.system.model.Product;
import br.com.seuze.store.system.service.ProductService;

public class PrintAllStock {
	public static void run() {
		ProductService ps = new ProductService();
		LinkedHashMap<String, Object> stock = ps.listAllProducts(); 
		System.out.println("------------ ESTOQUE -------------");
		for(String key : stock.keySet()) {
			Product product = (Product) stock.get(key);
			System.out.println(product.toString());
			System.out.println("-----------------------");
		};
	}
}
