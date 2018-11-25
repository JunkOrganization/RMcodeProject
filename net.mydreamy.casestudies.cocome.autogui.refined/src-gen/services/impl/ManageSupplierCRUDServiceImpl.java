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

public class ManageSupplierCRUDServiceImpl implements ManageSupplierCRUDService{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public ManageSupplierCRUDServiceImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean createSupplier(int id, String name) throws PreconditionException {
		/* Code generated for contract definition */
		//Get supplier
		Supplier supplier = null;
		for (Supplier sup : (List<Supplier>)EntityManager.getAllInstancesOf("Supplier"))
		{
			if (sup.getId() == id)
			{
				supplier = sup;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(supplier) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			Supplier sup = null;
			sup = (Supplier) EntityManager.createObject("Supplier");
			sup.setId(id);
			sup.setName(name);
			EntityManager.addObject("Supplier", sup);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name]
		//all relevant vars : sup
		//all relevant entities : Supplier
	} 
	 
	static {opINVRelatedEntity.put("createSupplier", Arrays.asList("Supplier"));}
	
	@SuppressWarnings("unchecked")
	public Supplier querySupplier(int id) throws PreconditionException {
		/* Code generated for contract definition */
		//Get supplier
		Supplier supplier = null;
		for (Supplier sup : (List<Supplier>)EntityManager.getAllInstancesOf("Supplier"))
		{
			if (sup.getId() == id)
			{
				supplier = sup;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(supplier) == false) 
		{ 
			/* Logic here */
	 		return supplier;
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean modifySupplier(int id, String name) throws PreconditionException {
		/* Code generated for contract definition */
		//Get supplier
		Supplier supplier = null;
		for (Supplier sup : (List<Supplier>)EntityManager.getAllInstancesOf("Supplier"))
		{
			if (sup.getId() == id)
			{
				supplier = sup;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(supplier) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			supplier.setId(id);
			supplier.setName(name);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name]
		//all relevant vars : supplier
		//all relevant entities : Supplier
	} 
	 
	static {opINVRelatedEntity.put("modifySupplier", Arrays.asList("Supplier"));}
	
	@SuppressWarnings("unchecked")
	public boolean deleteSupplier(int id) throws PreconditionException {
		/* Code generated for contract definition */
		//Get supplier
		Supplier supplier = null;
		for (Supplier sup : (List<Supplier>)EntityManager.getAllInstancesOf("Supplier"))
		{
			if (sup.getId() == id)
			{
				supplier = sup;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(supplier) == false && StandardOPs.includes(((List<Supplier>)EntityManager.getAllInstancesOf("Supplier")), supplier)) 
		{ 
			/* Logic here */
			//return primitive type	
			EntityManager.deleteObject("Supplier", supplier);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : supplier
		//all relevant entities : Supplier
	} 
	 
	static {opINVRelatedEntity.put("deleteSupplier", Arrays.asList("Supplier"));}
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
