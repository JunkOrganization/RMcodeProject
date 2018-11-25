package entities;

import services.impl.StandardOPs;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
import java.io.Serializable;
import java.lang.reflect.Method;

public class ProductCatalog implements Serializable {
	
	/* all primary attributes */
	private int Id;
	private String Name;
	
	/* all references */
	private List<Item> ContainedItems = new LinkedList<Item>(); 
	
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
	public List<Item> getContainedItems() {
		return ContainedItems;
	}	
	
	public void addContainedItems(Item item) {
		this.ContainedItems.add(item);
	}
	
	public void deleteContainedItems(Item item) {
		this.ContainedItems.remove(item);
	}
	


}
