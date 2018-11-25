package entities;

import services.impl.StandardOPs;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
import java.io.Serializable;
import java.lang.reflect.Method;

public class Cashier implements Serializable {
	
	/* all primary attributes */
	private int Id;
	private String Name;
	
	/* all references */
	private Store WorkedStore; 
	
	/* all get and set functions */
	public int getId() {
		return Id;
	}	
	
	public void setId(int id) {
		this.Id = id;
	}
	public String getName() {
		return Name;
	}	
	
	public void setName(String name) {
		this.Name = name;
	}
	
	/* all functions for reference*/
	public Store getWorkedStore() {
		return WorkedStore;
	}	
	
	public void setWorkedStore(Store store) {
		this.WorkedStore = store;
	}			
	


}
