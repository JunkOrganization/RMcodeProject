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

public class CoCoMESystemImpl implements CoCoMESystem{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public CoCoMESystemImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean changePrice(int barcode, float newPrice) throws PreconditionException {
		/* Code generated for contract definition */
		//Get item
		Item item = null;
		for (Item i : (List<Item>)EntityManager.getAllInstancesOf("Item"))
		{
			if (i.getBarcode() == barcode)
			{
				item = i;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(item) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			item.setPrice(newPrice);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : item
		//all relevant entities : Item
	} 
	 
	static {opINVRelatedEntity.put("changePrice", Arrays.asList("Item"));}
	
	@SuppressWarnings("unchecked")
	public boolean receiveOrderedProduct(int orderID) throws PreconditionException {
		/* Code generated for contract definition */
		//Get op
		OrderProduct op = null;
		for (OrderProduct i : (List<OrderProduct>)EntityManager.getAllInstancesOf("OrderProduct"))
		{
			if (i.getId() == orderID)
			{
				op = i;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(op) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			op.setOrderStatus(OrderStatus.RECEIVED);
			//no nested iterator --  iterator: forAll
			for (OrderEntry oe : op.getContainedEntries())
			{
				oe.getItem().setStockNumber(oe.getItem().getStockNumber()+oe.getQuantity());
			}
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : op oe
		//all relevant entities : OrderProduct OrderEntry
	} 
	 
	static {opINVRelatedEntity.put("receiveOrderedProduct", Arrays.asList("OrderProduct","OrderEntry"));}
	
	@SuppressWarnings("unchecked")
	public List<Supplier> listSuppliers() throws PreconditionException {
		/* check precondition */
		if (true) 
		{ 
			/* Logic here */
	 		return ((List<Supplier>)EntityManager.getAllInstancesOf("Supplier"));
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public List<Item> showStockReports() throws PreconditionException {
		/* check precondition */
		if (true) 
		{ 
			/* Logic here */
	 		return ((List<Item>)EntityManager.getAllInstancesOf("Item"));
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
