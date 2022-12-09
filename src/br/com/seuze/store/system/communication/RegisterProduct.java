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
		
		///////////Department
		System.out.println("A qual Departamento o produto pertence?");
		LinkedHashMap<String, ProductDepartment> departmentList = 
				(LinkedHashMap<String, ProductDepartment>) ProductDepartment.getListofdepartments();
		
		for(String departmentValue : departmentList.keySet()) {
			System.out.println(departmentValue + " - " + departmentList.get(departmentValue).getDescription());
		}
		System.out.println("Digite o valor do departamento. Ex: \"CL\" para \"Clothing\"");
		String departmentChosenValue = sc.nextLine();
		
		if(departmentChosenValue.equalsIgnoreCase("")) {
			
		} else if(departmentChosenValue.equalsIgnoreCase("")) {
			
		} else if(departmentChosenValue.equalsIgnoreCase("")) {
			
		}
		
		////////////Type
		System.out.println("Qual o Tipo do produto?");
		LinkedHashMap<String, ProductType> typeList = 
				(LinkedHashMap<String, ProductType>) ProductType.getListoftypes();
		
		for(String typeValue : typeList.keySet()) {
			System.out.println(typeValue + " - " + typeList.get(typeValue).getDescription());
		}
		System.out.println("Digite o valor do tipo. Ex: \"SHI\" para \"Shirt\"");
		String typeChosenValue = sc.nextLine();
		
		for(String typeValue : typeList.keySet()) {
				if(typeValue.equalsIgnoreCase(typeChosenValue)) {
					type = typeList.get(typeValue);
				}
		}
		
		///////////Color
		System.out.println("Qual a Cor do produto?");
		LinkedHashMap<String, ProductColor> colorList = 
				(LinkedHashMap<String, ProductColor>) ProductColor.getListofcolors();
		
		for(String colorValue : colorList.keySet()) {
			System.out.println(colorValue + " - " + colorList.get(colorValue).getDescription());
		}
		System.out.println("Digite o valor do cor. Ex: \"BLA\" para \"Black\"");
		String colorChosenValue = sc.nextLine();
		
		for(String colorValue : colorList.keySet()) {
				if(colorValue.equalsIgnoreCase(colorChosenValue)) {
					color = colorList.get(colorValue);
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
		ps.register(description, ProductCategory.MEN, ProductDepartment.CLOTHING, ProductType.HAT, ProductColor.BLUE, size, amount, value);
	}
}
