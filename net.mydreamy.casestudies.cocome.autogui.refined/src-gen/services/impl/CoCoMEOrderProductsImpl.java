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

public class CoCoMEOrderProductsImpl implements CoCoMEOrderProducts{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public CoCoMEOrderProductsImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean makeNewOrder(int orderid) throws PreconditionException {
		/* check precondition */
		if (true) 
		{ 
			/* Logic here */
			//return primitive type	
			OrderProduct op = null;
			op = (OrderProduct) EntityManager.createObject("OrderProduct");
			op.setOrderStatus(OrderStatus.NEW);
			op.setId(orderid);
			op.setTime(LocalDate.now());
			EntityManager.addObject("OrderProduct", op);
			this.setCurrentOrderProduct(op);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : op this
		//all relevant entities : OrderProduct 
	} 
	 
	static {opINVRelatedEntity.put("makeNewOrder", Arrays.asList("OrderProduct",""));}
	
	@SuppressWarnings("unchecked")
	public List<Item> listAllOutOfStoreProducts() throws PreconditionException {
		/* check precondition */
		if (true) 
		{ 
			/* Logic here */
	 		List<Item> tempsitem = new LinkedList<>();
	 		//no nested iterator --  iterator: select
	 		for (Item item : ((List<Item>)EntityManager.getAllInstancesOf("Item")))
	 		{
	 			if (item.getStockNumber() == 0)
	 			{
	 				tempsitem.add(item);
	 			} 
	 		}
	 		return tempsitem;
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean orderItem(int barcode, int quantity) throws PreconditionException {
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
			OrderEntry order = null;
			order = (OrderEntry) EntityManager.createObject("OrderEntry");
			order.setQuantity(quantity);
			order.setSubAmount(item.getOrderPrice()*quantity);
			order.setItem(item);
			EntityManager.addObject("OrderEntry", order);
			currentOrderProduct.addContainedEntries(order);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : order
		//all relevant entities : OrderEntry
	} 
	 
	static {opINVRelatedEntity.put("orderItem", Arrays.asList("OrderEntry"));}
	
	@SuppressWarnings("unchecked")
	public boolean chooseSupplier(int supplierID) throws PreconditionException {
		/* Code generated for contract definition */
		//Get sup
		Supplier sup = null;
		for (Supplier s : (List<Supplier>)EntityManager.getAllInstancesOf("Supplier"))
		{
			if (s.getId() == supplierID)
			{
				sup = s;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(sup) == false && StandardOPs.oclIsundefined(currentOrderProduct) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			currentOrderProduct.setSupplier(sup);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : currentOrderProduct
		//all relevant entities : 
	} 
	 
	static {opINVRelatedEntity.put("chooseSupplier", Arrays.asList(""));}
	
	@SuppressWarnings("unchecked")
	public boolean placeOrder() throws PreconditionException {
		/* check precondition */
		if (StandardOPs.oclIsundefined(currentOrderProduct) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			currentOrderProduct.setOrderStatus(OrderStatus.REQUESTED);
			//no nested iterator --  iterator: forAll
			for (OrderEntry o : currentOrderProduct.getContainedEntries())
			{
				currentOrderProduct.setAmount(currentOrderProduct.getAmount()+o.getSubAmount());
			}
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : currentOrderProduct o
		//all relevant entities :  OrderEntry
	} 
	 
	static {opINVRelatedEntity.put("placeOrder", Arrays.asList("","OrderEntry"));}
	
	/* temp property for controller */
	private OrderProduct currentOrderProduct;
			
	/* all get and set functions for temp property*/
	public OrderProduct getCurrentOrderProduct() {
		return currentOrderProduct;
	}	
	
	public void setCurrentOrderProduct(OrderProduct currentorderproduct) {
		this.currentOrderProduct = currentorderproduct;
	}
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
