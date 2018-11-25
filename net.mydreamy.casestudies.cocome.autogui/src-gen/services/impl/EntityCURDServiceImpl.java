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

public class EntityCURDServiceImpl implements EntityCURDService{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public EntityCURDServiceImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean createStore(int id, String name, String address) throws PreconditionException {
		/* Code generated for contract definition */
		//Get store
		Store store = null;
		for (Store sto : (List<Store>)EntityManager.getAllInstancesOf("Store"))
		{
			if (sto.getId() == id)
			{
				store = sto;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(store) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			Store sto = null;
			sto = (Store) EntityManager.createObject("Store");
			sto.setId(id);
			sto.setName(name);
			sto.setAddress(address);
			EntityManager.addObject("Store", sto);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name, address]
		//all relevant vars : sto
		//all relevant entities : Store
	} 
	 
	static {opINVRelatedEntity.put("createStore", Arrays.asList("Store"));}
	
	@SuppressWarnings("unchecked")
	public Store queryStore(int id) throws PreconditionException {
		/* Code generated for contract definition */
		//Get store
		Store store = null;
		for (Store sto : (List<Store>)EntityManager.getAllInstancesOf("Store"))
		{
			if (sto.getId() == id)
			{
				store = sto;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(store) == false) 
		{ 
			/* Logic here */
	 		return store;
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean modifyStore(int id, String name, String address) throws PreconditionException {
		/* Code generated for contract definition */
		//Get store
		Store store = null;
		for (Store sto : (List<Store>)EntityManager.getAllInstancesOf("Store"))
		{
			if (sto.getId() == id)
			{
				store = sto;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(store) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			store.setId(id);
			store.setName(name);
			store.setAddress(address);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name, address]
		//all relevant vars : store
		//all relevant entities : Store
	} 
	 
	static {opINVRelatedEntity.put("modifyStore", Arrays.asList("Store"));}
	
	@SuppressWarnings("unchecked")
	public boolean deleteStore(int id) throws PreconditionException {
		/* Code generated for contract definition */
		//Get store
		Store store = null;
		for (Store sto : (List<Store>)EntityManager.getAllInstancesOf("Store"))
		{
			if (sto.getId() == id)
			{
				store = sto;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(store) == false && StandardOPs.includes(((List<Store>)EntityManager.getAllInstancesOf("Store")), store)) 
		{ 
			/* Logic here */
			//return primitive type	
			EntityManager.deleteObject("Store", store);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : store
		//all relevant entities : Store
	} 
	 
	static {opINVRelatedEntity.put("deleteStore", Arrays.asList("Store"));}
	
	@SuppressWarnings("unchecked")
	public boolean createProductCatalog(int id, String name) throws PreconditionException {
		/* Code generated for contract definition */
		//Get productcatalog
		ProductCatalog productcatalog = null;
		for (ProductCatalog pro : (List<ProductCatalog>)EntityManager.getAllInstancesOf("ProductCatalog"))
		{
			if (pro.getId() == id)
			{
				productcatalog = pro;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(productcatalog) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			ProductCatalog pro = null;
			pro = (ProductCatalog) EntityManager.createObject("ProductCatalog");
			pro.setId(id);
			pro.setName(name);
			EntityManager.addObject("ProductCatalog", pro);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name]
		//all relevant vars : pro
		//all relevant entities : ProductCatalog
	} 
	 
	static {opINVRelatedEntity.put("createProductCatalog", Arrays.asList("ProductCatalog"));}
	
	@SuppressWarnings("unchecked")
	public ProductCatalog queryProductCatalog(int id) throws PreconditionException {
		/* Code generated for contract definition */
		//Get productcatalog
		ProductCatalog productcatalog = null;
		for (ProductCatalog pro : (List<ProductCatalog>)EntityManager.getAllInstancesOf("ProductCatalog"))
		{
			if (pro.getId() == id)
			{
				productcatalog = pro;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(productcatalog) == false) 
		{ 
			/* Logic here */
	 		return productcatalog;
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean modifyProductCatalog(int id, String name) throws PreconditionException {
		/* Code generated for contract definition */
		//Get productcatalog
		ProductCatalog productcatalog = null;
		for (ProductCatalog pro : (List<ProductCatalog>)EntityManager.getAllInstancesOf("ProductCatalog"))
		{
			if (pro.getId() == id)
			{
				productcatalog = pro;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(productcatalog) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			productcatalog.setId(id);
			productcatalog.setName(name);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name]
		//all relevant vars : productcatalog
		//all relevant entities : ProductCatalog
	} 
	 
	static {opINVRelatedEntity.put("modifyProductCatalog", Arrays.asList("ProductCatalog"));}
	
	@SuppressWarnings("unchecked")
	public boolean deleteProductCatalog(int id) throws PreconditionException {
		/* Code generated for contract definition */
		//Get productcatalog
		ProductCatalog productcatalog = null;
		for (ProductCatalog pro : (List<ProductCatalog>)EntityManager.getAllInstancesOf("ProductCatalog"))
		{
			if (pro.getId() == id)
			{
				productcatalog = pro;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(productcatalog) == false && StandardOPs.includes(((List<ProductCatalog>)EntityManager.getAllInstancesOf("ProductCatalog")), productcatalog)) 
		{ 
			/* Logic here */
			//return primitive type	
			EntityManager.deleteObject("ProductCatalog", productcatalog);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : productcatalog
		//all relevant entities : ProductCatalog
	} 
	 
	static {opINVRelatedEntity.put("deleteProductCatalog", Arrays.asList("ProductCatalog"));}
	
	@SuppressWarnings("unchecked")
	public boolean createCashDesk(int id) throws PreconditionException {
		/* Code generated for contract definition */
		//Get cashdesk
		CashDesk cashdesk = null;
		for (CashDesk cas : (List<CashDesk>)EntityManager.getAllInstancesOf("CashDesk"))
		{
			if (cas.getId() == id)
			{
				cashdesk = cas;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(cashdesk) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			CashDesk cas = null;
			cas = (CashDesk) EntityManager.createObject("CashDesk");
			cas.setId(id);
			EntityManager.addObject("CashDesk", cas);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : cas
		//all relevant entities : CashDesk
	} 
	 
	static {opINVRelatedEntity.put("createCashDesk", Arrays.asList("CashDesk"));}
	
	@SuppressWarnings("unchecked")
	public CashDesk queryCashDesk(int id) throws PreconditionException {
		/* Code generated for contract definition */
		//Get cashdesk
		CashDesk cashdesk = null;
		for (CashDesk cas : (List<CashDesk>)EntityManager.getAllInstancesOf("CashDesk"))
		{
			if (cas.getId() == id)
			{
				cashdesk = cas;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(cashdesk) == false) 
		{ 
			/* Logic here */
	 		return cashdesk;
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean modifyCashDesk(int id) throws PreconditionException {
		/* Code generated for contract definition */
		//Get cashdesk
		CashDesk cashdesk = null;
		for (CashDesk cas : (List<CashDesk>)EntityManager.getAllInstancesOf("CashDesk"))
		{
			if (cas.getId() == id)
			{
				cashdesk = cas;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(cashdesk) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			cashdesk.setId(id);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : cashdesk
		//all relevant entities : CashDesk
	} 
	 
	static {opINVRelatedEntity.put("modifyCashDesk", Arrays.asList("CashDesk"));}
	
	@SuppressWarnings("unchecked")
	public boolean deleteCashDesk(int id) throws PreconditionException {
		/* Code generated for contract definition */
		//Get cashdesk
		CashDesk cashdesk = null;
		for (CashDesk cas : (List<CashDesk>)EntityManager.getAllInstancesOf("CashDesk"))
		{
			if (cas.getId() == id)
			{
				cashdesk = cas;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(cashdesk) == false && StandardOPs.includes(((List<CashDesk>)EntityManager.getAllInstancesOf("CashDesk")), cashdesk)) 
		{ 
			/* Logic here */
			//return primitive type	
			EntityManager.deleteObject("CashDesk", cashdesk);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : cashdesk
		//all relevant entities : CashDesk
	} 
	 
	static {opINVRelatedEntity.put("deleteCashDesk", Arrays.asList("CashDesk"));}
	
	@SuppressWarnings("unchecked")
	public boolean createCashier(int id, String name) throws PreconditionException {
		/* Code generated for contract definition */
		//Get cashier
		Cashier cashier = null;
		for (Cashier cas : (List<Cashier>)EntityManager.getAllInstancesOf("Cashier"))
		{
			if (cas.getId() == id)
			{
				cashier = cas;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(cashier) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			Cashier cas = null;
			cas = (Cashier) EntityManager.createObject("Cashier");
			cas.setId(id);
			cas.setName(name);
			EntityManager.addObject("Cashier", cas);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name]
		//all relevant vars : cas
		//all relevant entities : Cashier
	} 
	 
	static {opINVRelatedEntity.put("createCashier", Arrays.asList("Cashier"));}
	
	@SuppressWarnings("unchecked")
	public Cashier queryCashier(int id) throws PreconditionException {
		/* Code generated for contract definition */
		//Get cashier
		Cashier cashier = null;
		for (Cashier cas : (List<Cashier>)EntityManager.getAllInstancesOf("Cashier"))
		{
			if (cas.getId() == id)
			{
				cashier = cas;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(cashier) == false) 
		{ 
			/* Logic here */
	 		return cashier;
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean modifyCashier(int id, String name) throws PreconditionException {
		/* Code generated for contract definition */
		//Get cashier
		Cashier cashier = null;
		for (Cashier cas : (List<Cashier>)EntityManager.getAllInstancesOf("Cashier"))
		{
			if (cas.getId() == id)
			{
				cashier = cas;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(cashier) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			cashier.setId(id);
			cashier.setName(name);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name]
		//all relevant vars : cashier
		//all relevant entities : Cashier
	} 
	 
	static {opINVRelatedEntity.put("modifyCashier", Arrays.asList("Cashier"));}
	
	@SuppressWarnings("unchecked")
	public boolean deleteCashier(int id) throws PreconditionException {
		/* Code generated for contract definition */
		//Get cashier
		Cashier cashier = null;
		for (Cashier cas : (List<Cashier>)EntityManager.getAllInstancesOf("Cashier"))
		{
			if (cas.getId() == id)
			{
				cashier = cas;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(cashier) == false && StandardOPs.includes(((List<Cashier>)EntityManager.getAllInstancesOf("Cashier")), cashier)) 
		{ 
			/* Logic here */
			//return primitive type	
			EntityManager.deleteObject("Cashier", cashier);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : cashier
		//all relevant entities : Cashier
	} 
	 
	static {opINVRelatedEntity.put("deleteCashier", Arrays.asList("Cashier"));}
	
	@SuppressWarnings("unchecked")
	public boolean createItem(int barcode, String description, float price) throws PreconditionException {
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
			ite.setDescription(description);
			ite.setPrice(price);
			EntityManager.addObject("Item", ite);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [description]
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
	public boolean modifyItem(int barcode, String description, float price) throws PreconditionException {
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
			item.setDescription(description);
			item.setPrice(price);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [description]
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
