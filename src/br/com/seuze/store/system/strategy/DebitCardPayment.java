package br.com.seuze.store.system.strategy;

public class DebitCardPayment extends CardPayment  {
	public DebitCardPayment(String cardSecurity, String cardNumber, String expirationDate) {
		super(cardSecurity, cardNumber, expirationDate);
	}

	@Override
	public String toString() {
		return "Debit Card";
	}
	@Override
	public String description() {
		return "Payment: Debit Card";
	}
}