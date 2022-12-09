package br.com.seuze.store.system.service;

import java.util.LinkedHashMap;

import br.com.seuze.store.system.data.SaleData;
import br.com.seuze.store.system.enumeration.TypeOfPayment;
import br.com.seuze.store.system.model.Sale;
import br.com.seuze.store.system.strategy.PaymentStrategy;

public interface SaleServiceInterface {
	public Sale registerSale();
	public Sale searchSaleById(String id);
	public Sale  orderSale(String id);
	public void sell(String id, PaymentStrategy payment);
	public boolean registerDocument(String id, String document);
	public boolean documentIsValid(String document);
	public boolean documentFormatAccepted(String document);
	public boolean documentDigitsAccepted(String document);
	public Double calculateTotalValue(String id);
	public void cleanBag(String id);
	public SaleData listSales(); 
}
