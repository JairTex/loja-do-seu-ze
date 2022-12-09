package br.com.seuze.store.system.data;

import java.util.LinkedHashMap;

public interface DataInterface {
	void save(Object object);
	void update(Object object);
	void delete(String id);
	Object getItem(String id);
	LinkedHashMap<String, Object> listAll();
}
