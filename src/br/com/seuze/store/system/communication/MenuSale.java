package br.com.seuze.store.system.communication;

import java.util.Scanner;

import br.com.seuze.store.system.model.Sale;
import br.com.seuze.store.system.service.SaleService;

public class MenuSale {
	static void run () {
		Scanner sc = new Scanner(System.in);
		SaleService ss = new SaleService();
		
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
				if(ss.finishedSales().isEmpty()) {
					System.out.println("Nenhuma venda computada!");
					System.out.println("Clique ENTER.");
					sc.nextLine();
				} else {
					System.out.println("------------ HISTORICO -------------");
					for(String key : ss.finishedSales().keySet()) {
						Sale sale = (Sale) ss.finishedSales().get(key);
						System.out.println(sale.toString());
						System.out.println("----------------------------------");
					}
				}
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
