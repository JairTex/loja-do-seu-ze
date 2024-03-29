package br.com.seuze.store.system.communication;

import java.util.Scanner;

import br.com.seuze.store.system.model.Product;
import br.com.seuze.store.system.model.Sale;
import br.com.seuze.store.system.service.ProductService;
import br.com.seuze.store.system.service.SaleService;
import br.com.seuze.store.system.strategy.CashPayment;
import br.com.seuze.store.system.strategy.CreditCardPayment;
import br.com.seuze.store.system.strategy.DebitCardPayment;
import br.com.seuze.store.system.strategy.PixPayment;

public class Sell {
	public static void run() {
		Scanner sc = new Scanner(System.in);
		ProductService ps = new ProductService();
		SaleService ss = new SaleService();
		Sale sale = ss.registerSale();
	
		boolean endSale = false;
		while(endSale ==false) {
			System.out.println("1 - Adicionar um produto:"
					+ "\n2 - Finalizar venda"
					+ "\n3 - Ver sacola");
			String choose = sc.nextLine();
			
			switch(choose) {
				case "1":{
					System.out.println("Digite o SKU do produto: ");
					String sku = sc.nextLine();
					try {
						Product product = (Product) ps.searchBySku(sku);
						System.out.println("Quantidade do produto: ");
						Integer amount = Integer.parseInt(sc.nextLine());
						ps.addProductToBag(product.getSku(), sale.getSaleId(), amount);
						System.out.println("Produto adicionado à sacola.");
					}catch (Exception e) {
						System.out.println("Houve um erro ao consultar o produto!");
					}
					break;}
				case "2":{
					System.out.println("Ordem de compra processada."
							+ "\nClique ENTER.");
					sc.nextLine();
					ss.orderSale(sale.getSaleId());
					
					System.out.println("Lista de produtos:");
					for(Product product : sale.getBag()) {
						System.out.println(product.getSku() + " - Qtd: " + product.getAmount() 
						+ " - Valor Unid: " + product.getValue());
					}
					System.out.println("TOTAL: " + ss.calculateTotalValue(sale.getSaleId()));
					
					System.out.println("Confirmar venda? \n1 - Sim | 2 - Não");
					String continueOption = sc.nextLine();
					
					switch(continueOption) { 
						case "1":
							System.out.println("Adicionar CPF? \n1 - Sim | Qualquer tecla - Não");
							String documentOption = sc.nextLine();
							switch(documentOption) {
							case "1":{
									System.out.println("Digite o seu CPF: Exemplo (XXX.XXX.XXX-XX)");
									String document = sc.nextLine();
									try{
										ss.registerDocument(sale.getSaleId(), document);
									}catch (Exception e) {
										System.out.println("Erro ao incluir CPF!");
									}
								}
							}
							boolean paymentChoose = false;
							while(paymentChoose ==false) {
								System.out.println("Selecione uma forma de pagamento:"
										+ "\n1 - Dinheiro"
										+ "\n2 - Cartão de Crédito"
										+ "\n3 - Cartão de Débito"
										+ "\n4 - Pix");
								String choosePaymentForm = sc.nextLine();
								
								switch (choosePaymentForm) {
									case "1": {
										ss.sell(sale.getSaleId(), new CashPayment(ss.calculateTotalValue(sale.getSaleId())));
										paymentChoose = true;
										endSale=true;
										System.out.println("Receba o pagamento!");
										System.out.println("Clique ENTER.");
										sc.nextLine();
										
										System.out.println("Compra finalizada com sucesso!");
										break;
									} 
									case "2": {
										System.out.println("Digite o número do cartão (Ex.: XXXX XXXX XXXX XXXX)");
										String cardNumber = sc.nextLine();
										System.out.println("Digite o digito de segunrança (Ex.: XXX):");
										String cardSecurity = sc.nextLine();
										System.out.println("Digite a data de validade (XX/XX):");
										String expirationDate = sc.nextLine();
										ss.sell(sale.getSaleId(), new CreditCardPayment(cardSecurity, cardNumber, expirationDate));
										paymentChoose = true;
										endSale=true;
										System.out.println("Compra finalizada com sucesso!");
										break;
									}
									case "3": {
										System.out.println("Digite o número do cartão (Ex.: XXXX XXXX XXXX XXXX)");
										String cardNumber = sc.nextLine();
										System.out.println("Digite o digito de segunrança (Ex.: XXX):");
										String cardSecurity = sc.nextLine();
										System.out.println("Digite a data de validade (XX/XX):");
										String expirationDate = sc.nextLine();
										ss.sell(sale.getSaleId(), new DebitCardPayment(cardSecurity, cardNumber, expirationDate));
										paymentChoose = true;
										endSale=true;
										System.out.println("Compra finalizada com sucesso!");
										break;
									}
									case "4": {
										System.out.println("Digite alguma chave Pix sua:");
										String pixKey = sc.nextLine();
										ss.sell(sale.getSaleId(), new PixPayment(pixKey, ss.calculateTotalValue(sale.getSaleId())));
										paymentChoose = true;
										endSale=true;
										System.out.println("Leia o QR Code!");
										System.out.println("Clique ENTER.");
										sc.nextLine();
										System.out.println("Compra finalizada com sucesso!");
										break;
									}
									default:
										System.out.println("Opção inexistente!");
										break;
								}
							}
							break;
							default:
								System.out.println("Opção inexistente!");
								break;
						}
					break;
				}
				case "3":{
					System.out.println("Lista de produtos:");
					for(Product product_ : sale.getBag()) {
						System.out.println(product_.getSku() + " - Qtd: " + product_.getAmount() 
						+ " - Valor Unid: " + product_.getValue());
					}
					System.out.println("TOTAL: " + ss.calculateTotalValue(sale.getSaleId()));
					break;}
				default:{
					System.out.println("Opção inválida");
					break;}
			}	
		}
	}		
}