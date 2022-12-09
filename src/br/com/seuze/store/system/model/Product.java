package br.com.seuze.store.system.model;

import br.com.seuze.store.system.enumeration.ProductCategory;
import br.com.seuze.store.system.enumeration.ProductColor;
import br.com.seuze.store.system.enumeration.ProductDepartment;
import br.com.seuze.store.system.enumeration.ProductType;

public class Product implements Cloneable{
	private String sku;
	private String description;
	private ProductCategory category;
	private ProductDepartment department;
	private ProductType type;
	private ProductColor color;
	private String size;
	private int amount;
	private Double value;
	public Product(String sku, String description, ProductCategory category, ProductDepartment department,
			ProductType type, ProductColor color, String size, int amount, Double value) {
		this.sku = sku;
		this.description = description;
		this.category = category;
		this.department = department;
		this.type = type;
		this.color = color;
		this.size = size;
		this.amount = amount;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return
				"-------- Product --------"
				+ "\nSKU : " + this.getSku()
				+ "\nDescription: " + this.getDescription()
				+ "\nClassification: " + this.getCategory().getDescription() + " " 
										+ this.getDepartment().getDescription() + " " 
										+ this.getType().getDescription()
				+ "\nColor: " + this.getColor().getDescription()
				+ "\nSize: " + this.getSize()
				+ "\nAmount: " + this.getAmount()
				+ "\nValue: " + this.getValue();
	}
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	public ProductDepartment getDepartment() {
		return department;
	}
	public void setDepartment(ProductDepartment department) {
		this.department = department;
	}
	public ProductType getType() {
		return type;
	}
	public void setType(ProductType type) {
		this.type = type;
	}
	public ProductColor getColor() {
		return color;
	}
	public void setColor(ProductColor color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
	public Object clone() throws CloneNotSupportedException {
		Product productCloned = (Product) super.clone();
		return productCloned;
	} 
}
