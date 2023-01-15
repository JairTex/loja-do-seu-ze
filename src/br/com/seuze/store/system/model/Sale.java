package br.com.seuze.store.system.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.seuze.store.system.strategy.PaymentStrategy;

public class Sale {
	private static Integer counterSaleId = 0;
	private String saleId;
	
	private List<Product> bag;
	private Double totalValue;
	private String document;
	private Calendar date;
	private PaymentStrategy payment;
	private boolean completed;
	
	public Sale(List<Product> bag, Double totalValue, String document) {
		counterSaleId++;
		this.saleId = counterSaleId.toString();
		this.bag = bag;
		this.totalValue = totalValue;
		this.document = document;
		this.completed = false;
	}
	
	@Override
	public String toString() {
		return ""
				+ "ID: " + this.getSaleId()
				+ "\nDate: " + this.getDateFormatted()
				+"\nBag: " + this.getBag()
				+ "\nCompleted: " + this.isCompleted()
				+ "\nClient Document: " + this.getDocument()
				+ "\n" + payment.toString()
				+ "\nTotal Value: " + this.getTotalValue();
	}
	
	public String getSaleId() {
		return saleId;
	}
	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}
	public List<Product> getBag() {
		return bag;
	}
	public void setBag(List<Product> bag) {
		this.bag = bag;
	}
	public Double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	public String getDocument() {
		if (this.document == null) {
			return "Indefinido";
		}
		return this.document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public Calendar getDate() {
		return date;
	}
	public String getDateFormatted() {	
		if (this.getDate() == null) {
			return "Indefinido";
		}
		
		SimpleDateFormat formatted = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		return formatted.format(this.getDate().getTime());
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public static Integer getCounterSaleId() {
		return counterSaleId;
	}
	public static void setCounterSaleId(Integer counterSaleId) {
		Sale.counterSaleId = counterSaleId;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public PaymentStrategy getPayment() {
		return payment;
	}
	public void setPayment(PaymentStrategy payment) {
		this.payment = payment;
	}
}
