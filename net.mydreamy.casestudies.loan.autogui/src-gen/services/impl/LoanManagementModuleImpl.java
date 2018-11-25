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

public class LoanManagementModuleImpl implements LoanManagementModule{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public LoanManagementModuleImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean bookNewLoan(int requestid, int loanid, int accountid, LocalDate startdate, LocalDate enddate, int repaymentdays) throws PreconditionException {
		/* Code generated for contract definition */
		//Get loan
		Loan loan = null;
		for (Loan loa : (List<Loan>)EntityManager.getAllInstancesOf("Loan"))
		{
			if (loa.getLoanID() == loanid)
			{
				loan = loa;
				break;
			}
		}
		//Get r
		LoanRequest r = null;
		for (LoanRequest lr : (List<LoanRequest>)EntityManager.getAllInstancesOf("LoanRequest"))
		{
			if (lr.getRequestID() == requestid)
			{
				r = lr;
				break;
			}
		}
		//Get la
		LoanAccount la = null;
		for (LoanAccount lacc : (List<LoanAccount>)EntityManager.getAllInstancesOf("LoanAccount"))
		{
			if (lacc.getLoanAccountID() == accountid)
			{
				la = lacc;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(loan) == true && StandardOPs.oclIsundefined(r) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			Loan loa = null;
			LoanAccount lacc = null;
			loa = (Loan) EntityManager.createObject("Loan");
			loa.setLoanID(loanid);
			loa.setStartDate(startdate);
			loa.setEndDate(enddate);
			loa.setRePaymentDays(repaymentdays);
			loa.setStatus(LoanStatus.LSOPEN);
			loa.setRepaymentAmount(r.getLoanAmount());
			loa.setCurrentOverDueDate(startdate.plusDays(repaymentdays));
			if (StandardOPs.oclIsundefined(la) == true)
			{
				lacc = services.createLoanAccount(accountid);
				EntityManager.addObject("LoanAccount", lacc);
				la = lacc;
			}
			loa.setBelongedLoanAccount(la);
			services.transferFunds(accountid, r.getLoanAmount());
			la.setBalance(la.getBalance()+r.getLoanAmount());
			loa.setRemainAmountToPay(r.getLoanAmount());
			EntityManager.addObject("Loan", loa);
			r.setApprovalLoan(loa);
			loa.setReferedLoanRequest(r);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : r la lacc loa
		//all relevant entities : LoanRequest LoanAccount LoanAccount LoanAccount
	} 
	 
	static {opINVRelatedEntity.put("bookNewLoan", Arrays.asList("LoanRequest","LoanAccount","LoanAccount","LoanAccount"));}
	
	@SuppressWarnings("unchecked")
	public boolean generateStandardPaymentNotice() throws PreconditionException {
		/* Code generated for contract definition */
		//Get loans
		List<Loan> loans = new LinkedList<>();
		for (Loan loa : (List<Loan>)EntityManager.getAllInstancesOf("Loan"))
		{
			if (loa.getStatus() == LoanStatus.LSOPEN && LocalDate.now().plusDays(3).isAfter(loa.getCurrentOverDueDate()))
			{
				loans.add(loa);
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(loans) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			//no nested iterator --  iterator: forAll
			for (Loan l : loans)
			{
				services.sendEmail(l.getReferedLoanRequest().getEmail(), "OverDueSoon", "You account is OverDueSoon");
			}
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : l
		//all relevant entities : Loan
	} 
	 
	static {opINVRelatedEntity.put("generateStandardPaymentNotice", Arrays.asList("Loan"));}
	
	@SuppressWarnings("unchecked")
	public boolean generateLateNotice() throws PreconditionException {
		/* Code generated for contract definition */
		//Get loans
		List<Loan> loans = new LinkedList<>();
		for (Loan loa : (List<Loan>)EntityManager.getAllInstancesOf("Loan"))
		{
			if (loa.getStatus() == LoanStatus.LSOPEN && LocalDate.now().isAfter(loa.getCurrentOverDueDate()))
			{
				loans.add(loa);
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(loans) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			//no nested iterator --  iterator: forAll
			for (Loan l : loans)
			{
				services.sendEmail(l.getReferedLoanRequest().getEmail(), "OverDued", "You are overdued, please repayment ASAP");
			}
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : l
		//all relevant entities : Loan
	} 
	 
	static {opINVRelatedEntity.put("generateLateNotice", Arrays.asList("Loan"));}
	
	@SuppressWarnings("unchecked")
	public boolean loanPayment(int loanid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get loan
		Loan loan = null;
		for (Loan loa : (List<Loan>)EntityManager.getAllInstancesOf("Loan"))
		{
			if (loa.getLoanID() == loanid)
			{
				loan = loa;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(loan) == false && loan.getStatus() == LoanStatus.LSOPEN) 
		{ 
			/* Logic here */
			//return primitive type	
			loan.setRemainAmountToPay(loan.getRemainAmountToPay()-loan.getRepaymentAmount());
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : loan
		//all relevant entities : Loan
	} 
	 
	static {opINVRelatedEntity.put("loanPayment", Arrays.asList("Loan"));}
	
	@SuppressWarnings("unchecked")
	public boolean closeOutLoan(int loanid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get loan
		Loan loan = null;
		for (Loan loa : (List<Loan>)EntityManager.getAllInstancesOf("Loan"))
		{
			if (loa.getLoanID() == loanid)
			{
				loan = loa;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(loan) == false && loan.getStatus() == LoanStatus.LSOPEN) 
		{ 
			/* Logic here */
			//return primitive type	
			loan.setStatus(LoanStatus.CLOSED);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : loan
		//all relevant entities : Loan
	} 
	 
	static {opINVRelatedEntity.put("closeOutLoan", Arrays.asList("Loan"));}
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
