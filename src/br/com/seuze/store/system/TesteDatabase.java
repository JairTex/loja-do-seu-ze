package br.com.seuze.store.system;

import br.com.seuze.store.system.enumeration.ProductCategory;
import br.com.seuze.store.system.enumeration.ProductColor;
import br.com.seuze.store.system.enumeration.ProductDepartment;
import br.com.seuze.store.system.enumeration.ProductType;
import br.com.seuze.store.system.service.ProductService;

public class TesteDatabase {
	public static void run() {
		ProductService ps = new ProductService();
		System.out.println(ps.register("Camisa Preta Pitbull", ProductCategory.MEN, ProductDepartment.CLOTHING,
				ProductType.SHIRT, ProductColor.BLACK, "G", 1, 25.0));
		System.out.println(ps.register("Camisa Branca Milwall", ProductCategory.WOMEN, ProductDepartment.CLOTHING,
				ProductType.SHIRT, ProductColor.WHITE, "M", 10, 20.0));
		System.out.println(ps.register("Teniz Adidas Azul", ProductCategory.MEN, ProductDepartment.FOOTWEAR,
				ProductType.SHOES, ProductColor.BLUE, "42", 8, 30.0));
		System.out.println(ps.register("Calça Shein verde", ProductCategory.WOMEN, ProductDepartment.CLOTHING, ProductType.PANTS,
				ProductColor.GREEN, "40", 15, 65.0));
		System.out.println(ps.register("Camisa Preta Pitbull", ProductCategory.MEN, ProductDepartment.CLOTHING,
				ProductType.SHIRT, ProductColor.BLACK, "G", 60, 25.99));
		System.out.println(ps.register("Tenis Adidas Azul", ProductCategory.MEN, ProductDepartment.FOOTWEAR,
				ProductType.SHOES, ProductColor.BLUE, "42", 14, 310.0));
	}
}
