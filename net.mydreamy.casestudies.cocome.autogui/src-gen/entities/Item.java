package entities;

import services.impl.StandardOPs;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
import java.io.Serializable;
import java.lang.reflect.Method;

public class Item implements Serializable {
	
	/* all primary attributes */
	private int Barcode;
	private String Description;
	private float Price;
	private int StockNumber;
	
	/* all references */
	private ProductCatalog BelongedCatalog; 
	
	/* all get and set functions */
	public int getBarcode() {
		return Barcode;
	}	
	
	public void setBarcode(int barcode) {
		this.Barcode = barcode;
	}
	public String getDescription() {
		return Description;
	}	
	
	public void setDescription(String description) {
		this.Description = description;
	}
	public float getPrice() {
		return Price;
	}	
	
	public void setPrice(float price) {
		this.Price = price;
	}
	public int getStockNumber() {
		return StockNumber;
	}	
	
	public void setStockNumber(int stocknumber) {
		this.StockNumber = stocknumber;
	}
	
	/* all functions for reference*/
	public ProductCatalog getBelongedCatalog() {
		return BelongedCatalog;
	}	
	
	public void setBelongedCatalog(ProductCatalog productcatalog) {
		this.BelongedCatalog = productcatalog;
	}			
	


}
