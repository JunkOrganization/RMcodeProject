package services.impl;

import services.*;
import entities.*;
import java.util.List;
import java.util.LinkedList;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ManageItemCRUDServiceImpl implements ManageItemCRUDService{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public ManageItemCRUDServiceImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean createItem(int barcode, String name, float price, int stocknumber, float orderprice) throws PreconditionException {
		/* Code generated for contract definition */
		//Get item
		Item item = null;
		for (Item ite : (List<Item>)EntityManager.getAllInstancesOf("Item"))
		{
			if (ite.getBarcode() == barcode)
			{
				item = ite;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(item) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			Item ite = null;
			ite = (Item) EntityManager.createObject("Item");
			ite.setBarcode(barcode);
			ite.setName(name);
			ite.setPrice(price);
			ite.setStockNumber(stocknumber);
			ite.setOrderPrice(orderprice);
			EntityManager.addObject("Item", ite);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name]
		//all relevant vars : ite
		//all relevant entities : Item
	} 
	 
	static {opINVRelatedEntity.put("createItem", Arrays.asList("Item"));}
	
	@SuppressWarnings("unchecked")
	public Item queryItem(int barcode) throws PreconditionException {
		/* Code generated for contract definition */
		//Get item
		Item item = null;
		for (Item ite : (List<Item>)EntityManager.getAllInstancesOf("Item"))
		{
			if (ite.getBarcode() == barcode)
			{
				item = ite;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(item) == false) 
		{ 
			/* Logic here */
	 		return item;
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean modifyItem(int barcode, String name, float price, int stocknumber, float orderprice) throws PreconditionException {
		/* Code generated for contract definition */
		//Get item
		Item item = null;
		for (Item ite : (List<Item>)EntityManager.getAllInstancesOf("Item"))
		{
			if (ite.getBarcode() == barcode)
			{
				item = ite;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(item) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			item.setBarcode(barcode);
			item.setName(name);
			item.setPrice(price);
			item.setStockNumber(stocknumber);
			item.setOrderPrice(orderprice);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name]
		//all relevant vars : item
		//all relevant entities : Item
	} 
	 
	static {opINVRelatedEntity.put("modifyItem", Arrays.asList("Item"));}
	
	@SuppressWarnings("unchecked")
	public boolean deleteItem(int barcode) throws PreconditionException {
		/* Code generated for contract definition */
		//Get item
		Item item = null;
		for (Item ite : (List<Item>)EntityManager.getAllInstancesOf("Item"))
		{
			if (ite.getBarcode() == barcode)
			{
				item = ite;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(item) == false && StandardOPs.includes(((List<Item>)EntityManager.getAllInstancesOf("Item")), item)) 
		{ 
			/* Logic here */
			//return primitive type	
			EntityManager.deleteObject("Item", item);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : item
		//all relevant entities : Item
	} 
	 
	static {opINVRelatedEntity.put("deleteItem", Arrays.asList("Item"));}
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
