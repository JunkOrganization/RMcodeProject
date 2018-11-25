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

public class EvaluateLoanRequestModuleImpl implements EvaluateLoanRequestModule{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public EvaluateLoanRequestModuleImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public List<LoanRequest> listTenLoanRequest() throws PreconditionException {
		/* Code generated for contract definition */
		//Get rs
		List<LoanRequest> rs = new LinkedList<>();
		for (LoanRequest r : (List<LoanRequest>)EntityManager.getAllInstancesOf("LoanRequest"))
		{
			if (r.getStatus() == LoanRequestStatus.REFERENCESVALIDATED)
			{
				rs.add(r);
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(rs) == false) 
		{ 
			/* Logic here */
	 		this.setCurrentLoanRequests(rs);
	 		return rs;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : this
		//all relevant entities : 
	} 
	 
	static {opINVRelatedEntity.put("listTenLoanRequest", Arrays.asList(""));}
	
	@SuppressWarnings("unchecked")
	public LoanRequest chooseOneForReview(int requestid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get rs
		LoanRequest rs = null;
		for (LoanRequest r : this.getCurrentLoanRequests())
		{
			if (r.getRequestID() == requestid)
			{
				rs = r;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(rs) == false) 
		{ 
			/* Logic here */
	 		this.setCurrentLoanRequest(rs);
	 		return rs;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : this
		//all relevant entities : 
	} 
	 
	static {opINVRelatedEntity.put("chooseOneForReview", Arrays.asList(""));}
	
	@SuppressWarnings("unchecked")
	public CreditHistory checkCreditHistory() throws PreconditionException {
		/* check precondition */
		if (StandardOPs.oclIsundefined(this.getCurrentLoanRequest()) == false && StandardOPs.oclIsundefined(CurrentLoanRequest.getRequestedCreditHistory()) == false) 
		{ 
			/* Logic here */
	 		return CurrentLoanRequest.getRequestedCreditHistory();
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public CheckingAccount reviewCheckingAccount() throws PreconditionException {
		/* check precondition */
		if (StandardOPs.oclIsundefined(this.getCurrentLoanRequest()) == false && StandardOPs.oclIsundefined(CurrentLoanRequest.getRequestedCAHistory()) == false) 
		{ 
			/* Logic here */
	 		return CurrentLoanRequest.getRequestedCAHistory();
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public List<LoanTerm> listAvaiableLoanTerm() throws PreconditionException {
		/* check precondition */
		if (true) 
		{ 
			/* Logic here */
	 		return ((List<LoanTerm>)EntityManager.getAllInstancesOf("LoanTerm"));
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean addLoanTerm(int termid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get loanterm
		LoanTerm loanterm = null;
		for (LoanTerm loa : (List<LoanTerm>)EntityManager.getAllInstancesOf("LoanTerm"))
		{
			if (loa.getItemID() == termid)
			{
				loanterm = loa;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(this.getCurrentLoanRequest()) == false && StandardOPs.oclIsundefined(loanterm) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			CurrentLoanRequest.addAttachedLoanTerms(loanterm);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : loanterm
		//all relevant entities : LoanTerm
	} 
	 
	static {opINVRelatedEntity.put("addLoanTerm", Arrays.asList("LoanTerm"));}
	
	@SuppressWarnings("unchecked")
	public boolean approveLoanRequest() throws PreconditionException {
		/* check precondition */
		if (StandardOPs.oclIsundefined(this.getCurrentLoanRequest()) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			this.getCurrentLoanRequest().setStatus(LoanRequestStatus.APPROVED);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : this
		//all relevant entities : 
	} 
	 
	static {opINVRelatedEntity.put("approveLoanRequest", Arrays.asList(""));}
	
	/* temp property for controller */
	private LoanRequest CurrentLoanRequest;
	private List<LoanRequest> CurrentLoanRequests;
			
	/* all get and set functions for temp property*/
	public LoanRequest getCurrentLoanRequest() {
		return CurrentLoanRequest;
	}	
	
	public void setCurrentLoanRequest(LoanRequest currentloanrequest) {
		this.CurrentLoanRequest = currentloanrequest;
	}
	public List<LoanRequest> getCurrentLoanRequests() {
		return CurrentLoanRequests;
	}	
	
	public void setCurrentLoanRequests(List<LoanRequest> currentloanrequests) {
		this.CurrentLoanRequests = currentloanrequests;
	}
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
