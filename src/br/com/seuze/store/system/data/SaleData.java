package br.com.seuze.store.system.data;

import java.util.LinkedHashMap;

import br.com.seuze.store.system.model.Sale;

public class SaleData implements DataInterface{
	private LinkedHashMap<String, Object> salesHistory = new LinkedHashMap<>(); 
	
	public void save(Object object) {
		Sale sale = (Sale) object;
		salesHistory.put(sale.getSaleId(), sale);
	}
	public void update(Object object) {
		Sale sale = (Sale) object;
		salesHistory.replace(sale.getSaleId(), sale);
		
	}
	public void delete(String id) {
		salesHistory.remove(id);
	}
	public Object getItem(String id) {
		Sale sale = (Sale) salesHistory.get(id);
		return sale;
	}
	public LinkedHashMap<String, Object> listAll() {
		return this.salesHistory;
	}
}
