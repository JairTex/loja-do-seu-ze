package br.com.seuze.store.system;

import br.com.seuze.store.system.enumeration.ProductCategory;
import br.com.seuze.store.system.enumeration.ProductColor;
import br.com.seuze.store.system.enumeration.ProductDepartment;
import br.com.seuze.store.system.enumeration.ProductType;
import br.com.seuze.store.system.model.Product;
import br.com.seuze.store.system.model.Sale;
import br.com.seuze.store.system.service.ProductService;
import br.com.seuze.store.system.service.SaleService;
import br.com.seuze.store.system.strategy.CashPayment;

public class Teste {
	private static ProductService ps = new ProductService();
	private static SaleService ss = new SaleService();

	public static void main(String[] args) throws CloneNotSupportedException {
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
		Sale sale1 = ss.registerSale();
		ps.addProductToBag("MCLSHIBLA", "1", 5);
		ps.addProductToBag("WCLSHIWHI", "1", 10);
		ps.addProductToBag("MFWSHOBLU", "1", 25);
		ss.calculateTotalValue("1");
		
		sale1 = ss.searchSaleById("1");
		System.out.println(sale1.getTotalValue());
		
		
		  System.out.println("Estoque : "  + ps.searchBySku("MCLSHIBLA").toString());
		  System.out.println("Estoque : "  + ps.searchBySku("WCLSHIWHI").toString());
		  System.out.println("Estoque : "  + ps.searchBySku("MFWSHOBLU").toString());
		  ss.calculateTotalValue("1");
		 
		
		ss.orderSale("1");
		
		ss.calculateTotalValue("1");
		sale1 = ss.searchSaleById("1");
		System.out.println(sale1.getTotalValue());
		
		sale1 = ss.searchSaleById("1");
		for(Product p : sale1.getBag()) {
			System.out.println(p.getAmount());
			System.out.println(p.getValue());
			System.out.println(p.getAmount() * p.getValue());
			System.out.println(" - - - ");
		}
		System.out.println(sale1.getTotalValue());
		
		System.out.println(ps.searchBySku("MCLSHIBLA").toString());
		System.out.println(ps.searchBySku("WCLSHIWHI").toString());
		System.out.println(ps.searchBySku("MFWSHOBLU").toString());
		
		ss.registerDocument("1", "045.852.212-04");
		ss.sell("1", new CashPayment(202.0));
		System.out.println(ss.searchSaleById("1"));
		

	}
}
