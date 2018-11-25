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

public class ManageCashierCRUDServiceImpl implements ManageCashierCRUDService{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public ManageCashierCRUDServiceImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
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
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
