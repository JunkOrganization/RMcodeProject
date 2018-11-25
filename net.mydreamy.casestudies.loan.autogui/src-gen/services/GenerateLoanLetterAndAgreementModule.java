package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface GenerateLoanLetterAndAgreementModule {

	List<LoanRequest> listApprovalRequest() throws PreconditionException;
	boolean genereateApprovalLetter(int id) throws PreconditionException;
	boolean emailToAppliant() throws PreconditionException;
	boolean generateLoanAgreement() throws PreconditionException;
	boolean printLoanAgreement(int number) throws PreconditionException;
	
	/* all get and set functions for temp property*/
	ApprovalLetter getCurrentApprovalLetter();
	void setCurrentApprovalLetter(ApprovalLetter currentapprovalletter);
	LoanAgreement getCurrentLoanAgreement();
	void setCurrentLoanAgreement(LoanAgreement currentloanagreement);
	LoanRequest getCurrentLoanRequest();
	void setCurrentLoanRequest(LoanRequest currentloanrequest);
	List<LoanRequest> getCurrentLoanRequests();
	void setCurrentLoanRequests(List<LoanRequest> currentloanrequests);
			
	/* invariant checking function */
}
