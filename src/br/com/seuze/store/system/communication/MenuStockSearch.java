package br.com.seuze.store.system.communication;

import java.util.LinkedHashMap;
import java.util.Scanner;

import br.com.seuze.store.system.enumeration.ProductCategory;
import br.com.seuze.store.system.enumeration.ProductColor;
import br.com.seuze.store.system.enumeration.ProductDepartment;
import br.com.seuze.store.system.enumeration.ProductType;
import br.com.seuze.store.system.model.Product;
import br.com.seuze.store.system.service.ProductService;

public class MenuStockSearch {
	
	static void run () {
		Scanner sc = new Scanner(System.in);
		ProductService ps = new ProductService();
		
		boolean exit = false;
		while (exit == false) {
			System.out.println(
					"---------- Buscar Por... ---------"
					+ "\n1 - SKU"
					+ "\n2 - Categoria"
					+ "\n3 - Departamento"
					+ "\n4 - Tipo"
					+ "\n5 - Cor"
					+ "\n6 - Sair"
					);
			
			String choice = sc.nextLine();
			
			switch (choice) {
			case "1": {
				System.out.println("Digite o SKU do produto: ");
				String sku = sc.nextLine();
				Product product = (Product) ps.searchBySku(sku);
				System.out.println(product.toString());
				break;
			}
			case "2": {
				ProductCategory category = null;
				LinkedHashMap<String, ProductCategory> categoryList = 
						(LinkedHashMap<String, ProductCategory>) ProductCategory.getListofcategorys();
				
				for(String categoryValue : categoryList.keySet()) {
					System.out.println(categoryValue + " - " + categoryList.get(categoryValue).getDescription());
				}
				System.out.println("Digite o valor da categoria. Ex: \"W\" para \"wolmen's\"");
				String categoryChosenValue = sc.nextLine();
				for(String categoryValue : categoryList.keySet()) {
					if(categoryValue.equalsIgnoreCase(categoryChosenValue)) {
						category = categoryList.get(categoryValue);
					}
				}
				LinkedHashMap<String, Object> products = ps.searchByCategory(category);
				System.out.println("------------ ESTOQUE -------------");
				for(String key : products.keySet()) {
					Product product = (Product) products.get(key);
					System.out.println(product.toString());
					System.out.println("-----------------------");
				};
				break;
			}
			case "3": {
				ProductDepartment department = null;
				System.out.println("A qual Departamento o produto pertence?");
				LinkedHashMap<String, ProductDepartment> departmentList = 
						(LinkedHashMap<String, ProductDepartment>) ProductDepartment.getListofdepartments();
				
				for(String departmentValue : departmentList.keySet()) {
					System.out.println(departmentValue + " - " + departmentList.get(departmentValue).getDescription());
				}
				System.out.println("Digite o valor do departamento. Ex: \"CL\" para \"Clothing\"");
				String departmentChosenValue = sc.nextLine();
				
				for(String departmentValue : departmentList.keySet()) {
						if(departmentValue.equalsIgnoreCase(departmentChosenValue)) {
							department = departmentList.get(departmentValue);
						}
				}
				LinkedHashMap<String, Object> products = ps.searchByDepartment(department);
				System.out.println("------------ ESTOQUE -------------");
				for(String key : products.keySet()) {
					Product product = (Product) products.get(key);
					System.out.println(product.toString());
					System.out.println("-----------------------");
				};
				break;
			}
			case "4": {
				ProductType type = null;
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
				LinkedHashMap<String, Object> products = ps.searchByType(type);
				System.out.println("------------ ESTOQUE -------------");
				for(String key : products.keySet()) {
					Product product = (Product) products.get(key);
					System.out.println(product.toString());
					System.out.println("-----------------------");
				};
				break;
			}
			case "5": {
				ProductColor color = null;
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
				LinkedHashMap<String, Object> products = ps.searchByColor(color);
				System.out.println("------------ ESTOQUE -------------");
				for(String key : products.keySet()) {
					Product product = (Product) products.get(key);
					System.out.println(product.toString());
					System.out.println("-----------------------");
				};
				break;
			}
			case "6": {
				exit = true;
				break;
			}
			default:
				System.out.println("Opção inexistente!");
			}
		}
	}
}
