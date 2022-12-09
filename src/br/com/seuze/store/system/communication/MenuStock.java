package br.com.seuze.store.system.communication;

import java.util.Scanner;

public class MenuStock {
	static void run () {
		Scanner sc = new Scanner(System.in);
		
		boolean exit = false;
		while (exit == false) {
			System.out.println(
					"---------- Estoque ---------"
					+ "\n1 - Cadastrar Produto"
					+ "\n2 - Verificar Estoque"
					+ "\n3 - Buscar produto"
					+ "\n4 - Sair"
					);
			
			String choice = sc.nextLine();
			
			switch (choice) {
			case "1": {
				try {
					RegisterProduct.run();
				}catch (Exception e) {
					System.out.println("Houve um erro ao realizar registro." + e);
				}
				break;
			}
			case "2": {
				try {
					PrintAllStock.run();
				}catch (Exception e) {
					System.out.println("Houve um erro ao realizar operação.");
				}
				break;
			}
			case "3": {
				try {
					MenuStockSearch.run();
				}catch (Exception e) {
					System.out.println("Houve um erro ao realizar busca.");
				}
				break;
			}
			case "4": {
				exit = true;
				break;
			}
			default:
				System.out.println("Opção inexistente!");
			}
		}
	}
}
