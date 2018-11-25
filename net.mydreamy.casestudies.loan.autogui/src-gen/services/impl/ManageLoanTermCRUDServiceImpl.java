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

public class ManageLoanTermCRUDServiceImpl implements ManageLoanTermCRUDService{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public ManageLoanTermCRUDServiceImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean createLoanTerm(int itemid, String content) throws PreconditionException {
		/* Code generated for contract definition */
		//Get loanterm
		LoanTerm loanterm = null;
		for (LoanTerm loa : (List<LoanTerm>)EntityManager.getAllInstancesOf("LoanTerm"))
		{
			if (loa.getItemID() == itemid)
			{
				loanterm = loa;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(loanterm) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			LoanTerm loa = null;
			loa = (LoanTerm) EntityManager.createObject("LoanTerm");
			loa.setItemID(itemid);
			loa.setContent(content);
			EntityManager.addObject("LoanTerm", loa);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [content]
		//all relevant vars : loa
		//all relevant entities : LoanTerm
	} 
	 
	static {opINVRelatedEntity.put("createLoanTerm", Arrays.asList("LoanTerm"));}
	
	@SuppressWarnings("unchecked")
	public LoanTerm queryLoanTerm(int itemid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get loanterm
		LoanTerm loanterm = null;
		for (LoanTerm loa : (List<LoanTerm>)EntityManager.getAllInstancesOf("LoanTerm"))
		{
			if (loa.getItemID() == itemid)
			{
				loanterm = loa;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(loanterm) == false) 
		{ 
			/* Logic here */
	 		return loanterm;
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean modifyLoanTerm(int itemid, String content) throws PreconditionException {
		/* Code generated for contract definition */
		//Get loanterm
		LoanTerm loanterm = null;
		for (LoanTerm loa : (List<LoanTerm>)EntityManager.getAllInstancesOf("LoanTerm"))
		{
			if (loa.getItemID() == itemid)
			{
				loanterm = loa;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(loanterm) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			loanterm.setItemID(itemid);
			loanterm.setContent(content);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [content]
		//all relevant vars : loanterm
		//all relevant entities : LoanTerm
	} 
	 
	static {opINVRelatedEntity.put("modifyLoanTerm", Arrays.asList("LoanTerm"));}
	
	@SuppressWarnings("unchecked")
	public boolean deleteLoanTerm(int itemid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get loanterm
		LoanTerm loanterm = null;
		for (LoanTerm loa : (List<LoanTerm>)EntityManager.getAllInstancesOf("LoanTerm"))
		{
			if (loa.getItemID() == itemid)
			{
				loanterm = loa;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(loanterm) == false && StandardOPs.includes(((List<LoanTerm>)EntityManager.getAllInstancesOf("LoanTerm")), loanterm)) 
		{ 
			/* Logic here */
			//return primitive type	
			EntityManager.deleteObject("LoanTerm", loanterm);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : loanterm
		//all relevant entities : LoanTerm
	} 
	 
	static {opINVRelatedEntity.put("deleteLoanTerm", Arrays.asList("LoanTerm"));}
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
