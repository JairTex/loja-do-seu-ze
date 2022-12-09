package br.com.seuze.store.system.communication;

import java.util.Scanner;

public class MenuPrincipal {
	public static void run () {
		Scanner sc = new Scanner(System.in);
		
		boolean exit = false;
		while (exit == false) {
			System.out.println(
					"---------- Menu ---------"
					+ "\n1 - Estoque"
					+ "\n2 - Vendas"
					+ "\n3 - Sair"
					);
			
			String choice = sc.nextLine();
			
			switch (choice) {
			case "1": {
				MenuStock.run();
				break;
			}
			case "2": {
				MenuSale.run();
				break;
			}
			case "3": {
				System.out.println("\nPrograma finalizado!");
				exit = true;
				break;
			}
			default:
				System.out.println("Opção inexistente!");
			}
		}
	}
}
