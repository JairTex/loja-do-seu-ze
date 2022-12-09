package br.com.seuze.store.system.strategy;

public class CreditCardPayment extends CardPayment {

	public CreditCardPayment(String cardSecurity, String cardNumber, String expirationDate) {
		super(cardSecurity, cardNumber, expirationDate);
	}
	@Override
	public String description() {
		return "Payment: Credit Card";
	}
}
