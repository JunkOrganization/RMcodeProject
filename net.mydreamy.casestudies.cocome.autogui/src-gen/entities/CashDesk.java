package entities;

import services.impl.StandardOPs;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
import java.io.Serializable;
import java.lang.reflect.Method;

public class CashDesk implements Serializable {
	
	/* all primary attributes */
	private int Id;
	
	/* all references */
	private List<Sale> ContainedSales = new LinkedList<Sale>(); 
	private Store BelongedStore; 
	
	/* all get and set functions */
	public int getId() {
		return Id;
	}	
	
	public void setId(int id) {
		this.Id = id;
	}
	
	/* all functions for reference*/
	public List<Sale> getContainedSales() {
		return ContainedSales;
	}	
	
	public void addContainedSales(Sale sale) {
		this.ContainedSales.add(sale);
	}
	
	public void deleteContainedSales(Sale sale) {
		this.ContainedSales.remove(sale);
	}
	public Store getBelongedStore() {
		return BelongedStore;
	}	
	
	public void setBelongedStore(Store store) {
		this.BelongedStore = store;
	}			
	


}
