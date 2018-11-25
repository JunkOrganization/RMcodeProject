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

public class ManageCashDeskCRUDServiceImpl implements ManageCashDeskCRUDService{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public ManageCashDeskCRUDServiceImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean createCashDesk(int id, String name, boolean isopened) throws PreconditionException {
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
			cas.setName(name);
			cas.setIsOpened(isopened);
			EntityManager.addObject("CashDesk", cas);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name]
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
	public boolean modifyCashDesk(int id, String name, boolean isopened) throws PreconditionException {
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
			cashdesk.setName(name);
			cashdesk.setIsOpened(isopened);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name]
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
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
