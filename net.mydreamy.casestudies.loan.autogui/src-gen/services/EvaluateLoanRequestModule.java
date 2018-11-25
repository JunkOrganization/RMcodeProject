package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface EvaluateLoanRequestModule {

	List<LoanRequest> listTenLoanRequest() throws PreconditionException;
	LoanRequest chooseOneForReview(int requestid) throws PreconditionException;
	CreditHistory checkCreditHistory() throws PreconditionException;
	CheckingAccount reviewCheckingAccount() throws PreconditionException;
	List<LoanTerm> listAvaiableLoanTerm() throws PreconditionException;
	boolean addLoanTerm(int termid) throws PreconditionException;
	boolean approveLoanRequest() throws PreconditionException;
	
	/* all get and set functions for temp property*/
	LoanRequest getCurrentLoanRequest();
	void setCurrentLoanRequest(LoanRequest currentloanrequest);
	List<LoanRequest> getCurrentLoanRequests();
	void setCurrentLoanRequests(List<LoanRequest> currentloanrequests);
			
	/* invariant checking function */
}
