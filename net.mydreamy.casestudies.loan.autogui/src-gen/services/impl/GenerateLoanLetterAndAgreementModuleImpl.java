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

public class GenerateLoanLetterAndAgreementModuleImpl implements GenerateLoanLetterAndAgreementModule{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public GenerateLoanLetterAndAgreementModuleImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public List<LoanRequest> listApprovalRequest() throws PreconditionException {
		/* Code generated for contract definition */
		//Get rs
		List<LoanRequest> rs = new LinkedList<>();
		for (LoanRequest r : (List<LoanRequest>)EntityManager.getAllInstancesOf("LoanRequest"))
		{
			if (r.getStatus() == LoanRequestStatus.APPROVED)
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
	 
	static {opINVRelatedEntity.put("listApprovalRequest", Arrays.asList(""));}
	
	@SuppressWarnings("unchecked")
	public boolean genereateApprovalLetter(int id) throws PreconditionException {
		/* Code generated for contract definition */
		//Get r
		LoanRequest r = null;
		for (LoanRequest lr : (List<LoanRequest>)EntityManager.getAllInstancesOf("LoanRequest"))
		{
			if (lr.getRequestID() == id)
			{
				r = lr;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(r) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			ApprovalLetter l = null;
			l = (ApprovalLetter) EntityManager.createObject("ApprovalLetter");
			l.setContent("ApprovalLetterContent");
			r.setAttachedApprovalLetter(l);
			this.setCurrentLoanRequest(r);
			EntityManager.addObject("ApprovalLetter", l);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : r this l
		//all relevant entities : LoanRequest  ApprovalLetter
	} 
	 
	static {opINVRelatedEntity.put("genereateApprovalLetter", Arrays.asList("LoanRequest","","ApprovalLetter"));}
	
	@SuppressWarnings("unchecked")
	public boolean emailToAppliant() throws PreconditionException {
		/* check precondition */
		if (StandardOPs.oclIsundefined(this.getCurrentLoanRequest()) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			services.sendEmail(CurrentLoanRequest.getEmail(), CurrentLoanRequest.getName(), "Your Loan Request was approved");
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean generateLoanAgreement() throws PreconditionException {
		/* check precondition */
		if (StandardOPs.oclIsundefined(this.getCurrentLoanRequest()) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			LoanAgreement la = null;
			la = (LoanAgreement) EntityManager.createObject("LoanAgreement");
			la.setContent("Loan Agreement");
			this.getCurrentLoanRequest().setAttachedLoanAgreement(la);
			EntityManager.addObject("LoanAgreement", la);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : la this
		//all relevant entities : LoanAgreement 
	} 
	 
	static {opINVRelatedEntity.put("generateLoanAgreement", Arrays.asList("LoanAgreement",""));}
	
	@SuppressWarnings("unchecked")
	public boolean printLoanAgreement(int number) throws PreconditionException {
		/* check precondition */
		if (StandardOPs.oclIsundefined(this.getCurrentLoanRequest()) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			services.print(CurrentLoanRequest.getAttachedLoanAgreement().getContent(), number);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	/* temp property for controller */
	private ApprovalLetter CurrentApprovalLetter;
	private LoanAgreement CurrentLoanAgreement;
	private LoanRequest CurrentLoanRequest;
	private List<LoanRequest> CurrentLoanRequests;
			
	/* all get and set functions for temp property*/
	public ApprovalLetter getCurrentApprovalLetter() {
		return CurrentApprovalLetter;
	}	
	
	public void setCurrentApprovalLetter(ApprovalLetter currentapprovalletter) {
		this.CurrentApprovalLetter = currentapprovalletter;
	}
	public LoanAgreement getCurrentLoanAgreement() {
		return CurrentLoanAgreement;
	}	
	
	public void setCurrentLoanAgreement(LoanAgreement currentloanagreement) {
		this.CurrentLoanAgreement = currentloanagreement;
	}
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
