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

public class ManageStoreCRUDServiceImpl implements ManageStoreCRUDService{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public ManageStoreCRUDServiceImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean createStore(int id, String name, String address, boolean isopened) throws PreconditionException {
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
			sto.setIsOpened(isopened);
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
	public boolean modifyStore(int id, String name, String address, boolean isopened) throws PreconditionException {
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
			store.setIsOpened(isopened);
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
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
