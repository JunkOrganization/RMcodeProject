package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface EnterValidatedCreditReferencesModule {

	List<LoanRequest> listSubmitedLoanRequest() throws PreconditionException;
	LoanRequest chooseLoanRequest(int requestid) throws PreconditionException;
	boolean markRequestValid() throws PreconditionException;
	
	/* all get and set functions for temp property*/
	LoanRequest getCurrentLoanRequest();
	void setCurrentLoanRequest(LoanRequest currentloanrequest);
	List<LoanRequest> getCurrentLoanRequests();
	void setCurrentLoanRequests(List<LoanRequest> currentloanrequests);
			
	/* invariant checking function */
}
