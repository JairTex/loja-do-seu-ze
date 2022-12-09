package br.com.seuze.store.system.strategy;

  public class CashPayment implements PaymentStrategy { 
	  private Double amount;
  
	  public CashPayment(Double amount) { 
		  this.amount = amount; 
		  }
  
	  @Override
	  public String description() {
		  return "Payment: Cash";
	  }
  
	  public Double getAmount() { 
		  return amount; } 
	  public void setAmount(Double amount) { 
		  this.amount = amount; } 
  }
 