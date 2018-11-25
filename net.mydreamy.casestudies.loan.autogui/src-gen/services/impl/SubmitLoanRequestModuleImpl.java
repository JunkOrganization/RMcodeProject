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

public class SubmitLoanRequestModuleImpl implements SubmitLoanRequestModule{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public SubmitLoanRequestModuleImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean enterLoanInformation(int requestid, String name, float loanamount, String loanpurpose, float income, int phonenumber, String postaladdress, int zipcode, String email, String workreferences, String creditreferences, int checkingaccountnumber, int securitynumber) throws PreconditionException {
		/* Code generated for contract definition */
		//Get loanrequest
		LoanRequest loanrequest = null;
		for (LoanRequest loa : (List<LoanRequest>)EntityManager.getAllInstancesOf("LoanRequest"))
		{
			if (loa.getRequestID() == requestid)
			{
				loanrequest = loa;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(loanrequest) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			LoanRequest loa = null;
			loa = (LoanRequest) EntityManager.createObject("LoanRequest");
			loa.setRequestID(requestid);
			loa.setName(name);
			loa.setLoanAmount(loanamount);
			loa.setLoanPurpose(loanpurpose);
			loa.setIncome(income);
			loa.setPhoneNumber(phonenumber);
			loa.setPostalAddress(postaladdress);
			loa.setZipCode(zipcode);
			loa.setEmail(email);
			loa.setWorkReferences(workreferences);
			loa.setCreditReferences(creditreferences);
			loa.setCheckingAccountNumber(checkingaccountnumber);
			loa.setSecurityNumber(securitynumber);
			EntityManager.addObject("LoanRequest", loa);
			this.setCurrentLoanRequest(loa);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name, loanpurpose, postaladdress, email, workreferences, creditreferences]
		//all relevant vars : this loa
		//all relevant entities :  LoanRequest
	} 
	 
	static {opINVRelatedEntity.put("enterLoanInformation", Arrays.asList("","LoanRequest"));}
	
	@SuppressWarnings("unchecked")
	public boolean creditRequest() throws PreconditionException {
		/* check precondition */
		if (StandardOPs.oclIsundefined(this.getCurrentLoanRequest()) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			CreditHistory his = null;
			his = (CreditHistory) EntityManager.createObject("CreditHistory");
			his = services.getCreditHistory(this.getCurrentLoanRequest().getSecurityNumber(), CurrentLoanRequest.getName());
			this.getCurrentLoanRequest().setRequestedCreditHistory(his);
			EntityManager.addObject("CreditHistory", his);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : his this
		//all relevant entities : CreditHistory 
	} 
	 
	static {opINVRelatedEntity.put("creditRequest", Arrays.asList("CreditHistory",""));}
	
	@SuppressWarnings("unchecked")
	public boolean accountStatusRequest() throws PreconditionException {
		/* check precondition */
		if (StandardOPs.oclIsundefined(this.getCurrentLoanRequest()) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			CheckingAccount ca = null;
			ca = (CheckingAccount) EntityManager.createObject("CheckingAccount");
			ca = services.getCheckingAccountStatus(this.getCurrentLoanRequest().getCheckingAccountNumber());
			this.getCurrentLoanRequest().setRequestedCAHistory(ca);
			EntityManager.addObject("CheckingAccount", ca);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : this ca
		//all relevant entities :  CheckingAccount
	} 
	 
	static {opINVRelatedEntity.put("accountStatusRequest", Arrays.asList("","CheckingAccount"));}
	
	@SuppressWarnings("unchecked")
	public int calculateScore() throws PreconditionException {
		/* check precondition */
		if (StandardOPs.oclIsundefined(this.getCurrentLoanRequest()) == false && StandardOPs.oclIsundefined(CurrentLoanRequest.getRequestedCAHistory()) == false && StandardOPs.oclIsundefined(CurrentLoanRequest.getRequestedCreditHistory()) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			this.getCurrentLoanRequest().setCreditScore(100);
			this.getCurrentLoanRequest().setStatus(LoanRequestStatus.SUBMITTED);
			return this.getCurrentLoanRequest().getCreditScore();
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : this
		//all relevant entities : 
	} 
	 
	static {opINVRelatedEntity.put("calculateScore", Arrays.asList(""));}
	
	/* temp property for controller */
	private LoanRequest CurrentLoanRequest;
			
	/* all get and set functions for temp property*/
	public LoanRequest getCurrentLoanRequest() {
		return CurrentLoanRequest;
	}	
	
	public void setCurrentLoanRequest(LoanRequest currentloanrequest) {
		this.CurrentLoanRequest = currentloanrequest;
	}
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
