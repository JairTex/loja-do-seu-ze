package br.com.seuze.store.system.communication;

import java.util.Scanner;

public class MenuSale {
	static void run () {
		Scanner sc = new Scanner(System.in);
		
		boolean exit = false;
		while (exit == false) {
			System.out.println(
					"---------- Venda ---------"
					+ "\n1 - Realizar Venda;"
					+ "\n2 - Histórico de Vendas"
					+ "\n3 - Sair"
					);
			
			String choice = sc.nextLine();
			
			switch (choice) {
			case "1": {
				Sell.run();
				break;
			}
			case "2": {
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
