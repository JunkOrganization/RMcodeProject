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

public class EnterValidatedCreditReferencesModuleImpl implements EnterValidatedCreditReferencesModule{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public EnterValidatedCreditReferencesModuleImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public List<LoanRequest> listSubmitedLoanRequest() throws PreconditionException {
		/* Code generated for contract definition */
		//Get rs
		List<LoanRequest> rs = new LinkedList<>();
		for (LoanRequest r : (List<LoanRequest>)EntityManager.getAllInstancesOf("LoanRequest"))
		{
			if (r.getStatus() == LoanRequestStatus.SUBMITTED)
			{
				rs.add(r);
			}
		}
		/* check precondition */
		if (StandardOPs.size(rs) > 0) 
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
	 
	static {opINVRelatedEntity.put("listSubmitedLoanRequest", Arrays.asList(""));}
	
	@SuppressWarnings("unchecked")
	public LoanRequest chooseLoanRequest(int requestid) throws PreconditionException {
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
	 
	static {opINVRelatedEntity.put("chooseLoanRequest", Arrays.asList(""));}
	
	@SuppressWarnings("unchecked")
	public boolean markRequestValid() throws PreconditionException {
		/* check precondition */
		if (StandardOPs.oclIsundefined(this.getCurrentLoanRequest()) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			this.getCurrentLoanRequest().setStatus(LoanRequestStatus.REFERENCESVALIDATED);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : this
		//all relevant entities : 
	} 
	 
	static {opINVRelatedEntity.put("markRequestValid", Arrays.asList(""));}
	
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
