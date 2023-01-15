package br.com.seuze.store.system.communication;

import java.util.LinkedHashMap;
import java.util.Scanner;

import br.com.seuze.store.system.enumeration.ProductCategory;
import br.com.seuze.store.system.enumeration.ProductColor;
import br.com.seuze.store.system.enumeration.ProductDepartment;
import br.com.seuze.store.system.enumeration.ProductType;
import br.com.seuze.store.system.model.Product;
import br.com.seuze.store.system.service.ProductService;

public class RegisterProduct {
	static void run () {
		Scanner sc= new Scanner(System.in);
		String description;
		ProductCategory category = null;
		ProductDepartment department = null;
		ProductType type = null;
		ProductColor color = null;
		String size;
		int amount;
		Double value;
		
		///////////Category
		System.out.println("A qual Categoria o produto pertence?");
		LinkedHashMap<String, ProductCategory> categoryList = 
				(LinkedHashMap<String, ProductCategory>) ProductCategory.getListofcategorys();
		
		while(category==null) {
			for(String categoryValue : categoryList.keySet()) {
				System.out.println(categoryValue + " - " + categoryList.get(categoryValue).getDescription());
			}
			System.out.println("Digite o valor da categoria. Ex: \"W\" para \"wolmen's\"");
			String categoryChosenValue = sc.nextLine();
			
			if(categoryChosenValue.equalsIgnoreCase("W")) {
				category = ProductCategory.WOMEN;
			} else if (categoryChosenValue.equalsIgnoreCase("M")) {
				category = ProductCategory.MEN;
			} else if (categoryChosenValue.equalsIgnoreCase("C")){
				category = ProductCategory.CHILDREN;
			}else {
				category = null;
			}
		}
		
		///////////Department
		
		/*
	CLOTHING("CL", "Clothing"), UNDERWEAR("UW", "Underwear "), 
	FOOTWEAR("FW", "Footwear"), ACCESSORIES("AC", "Accessories");*/
	
		System.out.println("A qual Departamento o produto pertence?");
		LinkedHashMap<String, ProductDepartment> departmentList = 
				(LinkedHashMap<String, ProductDepartment>) ProductDepartment.getListofdepartments();
		
		while(department==null){
			for(String departmentValue : departmentList.keySet()) {
				System.out.println(departmentValue + " - " + departmentList.get(departmentValue).getDescription());
			}
			System.out.println("Digite o valor do departamento. Ex: \"CL\" para \"Clothing\"");
			String departmentChosenValue = sc.nextLine().toUpperCase();
			
			if(departmentChosenValue.equalsIgnoreCase("CL")) {
				department = ProductDepartment.CLOTHING;			
			} else if(departmentChosenValue.equalsIgnoreCase("UW")) {
				department = ProductDepartment.UNDERWEAR;
			} else if(departmentChosenValue.equalsIgnoreCase("FW")) {
				department = ProductDepartment.FOOTWEAR;
			} else if(departmentChosenValue.equalsIgnoreCase("AC")) {
				department = ProductDepartment.ACCESSORIES;
			} else {
				department = null;
			}
		}
		
		////////////Type
		/*
	SHIRT("SHI", "Shirt"), SHORTS("SHT", "Shorts"), PANTS("PAN", "Pants"),
	SHOES("SHO", "Shoes"), HAT("HAT", "Hat"), SWIMMING_CAP("SCA", "Swimming Cap");*/
		
		System.out.println("Qual o Tipo do produto?");
		LinkedHashMap<String, ProductType> typeList = 
				(LinkedHashMap<String, ProductType>) ProductType.getListoftypes();
		
		while(type==null) {
			for(String typeValue : typeList.keySet()) {
				System.out.println(typeValue + " - " + typeList.get(typeValue).getDescription());
			}
			System.out.println("Digite o valor do tipo. Ex: \"SHI\" para \"Shirt\"");
			String typeChosenValue = sc.nextLine();
			
			if(typeChosenValue.equalsIgnoreCase("SHI")) {
				type = ProductType.SHIRT;			
			} else if(typeChosenValue.equalsIgnoreCase("SCT")) {
				type = ProductType.SHORTS;
			} else if(typeChosenValue.equalsIgnoreCase("PAN")) {
				type = ProductType.PANTS;
			} else if(typeChosenValue.equalsIgnoreCase("SHO")) {
				type = ProductType.SHOES;
			} else if(typeChosenValue.equalsIgnoreCase("HAT")) {
				type = ProductType.HAT;
			} else if(typeChosenValue.equalsIgnoreCase("SCA")) {
				type = ProductType.SWIMMING_CAP;
			} else {
				type = null;
			}
		}
		
		///////////Color
		/*
	BLUE("BLU", "Blue"), GREEN("GRE", "Green"), YELLOW("YEL", "Yellow"), 
	RED("RED", "Red"), GRAY("GRA", "Gray"),	BLACK("BLA", "Black"), 
	WHITE("WHI", "White"), OTHER("OTH", "Other");
		 * */
		System.out.println("Qual a Cor do produto?");
		LinkedHashMap<String, ProductColor> colorList = 
				(LinkedHashMap<String, ProductColor>) ProductColor.getListofcolors();
		
		while(color==null) {
			for(String colorValue : colorList.keySet()) {
				System.out.println(colorValue + " - " + colorList.get(colorValue).getDescription());
			}
			System.out.println("Digite o valor do cor. Ex: \"BLA\" para \"Black\"");
			String colorChosenValue = sc.nextLine();
			
			if(colorChosenValue.equalsIgnoreCase("BLU")) {
				color = ProductColor.BLUE;
			} else if(colorChosenValue.equalsIgnoreCase("GRE")) {
				color = ProductColor.GREEN;
			} else if(colorChosenValue.equalsIgnoreCase("YEL")) {
				color = ProductColor.YELLOW;
			} else if(colorChosenValue.equalsIgnoreCase("Red")) {
				color = ProductColor.RED;
			} else if(colorChosenValue.equalsIgnoreCase("GRA")) {
				color = ProductColor.GRAY;
			}else if(colorChosenValue.equalsIgnoreCase("BLA")) {
				color = ProductColor.BLACK;
			}else if(colorChosenValue.equalsIgnoreCase("WHI")) {
				color = ProductColor.WHITE;
			}else if(colorChosenValue.equalsIgnoreCase("OTH")) {
				color = ProductColor.OTHER;
			} else {
				color = null;
			}
		}
		
		System.out.println("Descrição do produto (Marca, Fabricante, etc.)");
		description = sc.nextLine();
		System.out.println("Tamanho (Ex.: G, P, M, 40, 42):");
		size = sc.nextLine();
		System.out.println("Quantidade (Apenas números):");
		amount = Integer.parseInt(sc.nextLine());
		System.out.println("Valor do produto (Ex. 32.20):");
		value = Double.parseDouble(sc.nextLine());
		
		ProductService ps = new ProductService();
		ps.register(description, category, department, type, color, size, amount, value);
	}
}
