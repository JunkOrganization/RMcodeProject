package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface SubmitLoanRequestModule {

	boolean enterLoanInformation(int requestid, String name, float loanamount, String loanpurpose, float income, int phonenumber, String postaladdress, int zipcode, String email, String workreferences, String creditreferences, int checkingaccountnumber, int securitynumber) throws PreconditionException;
	boolean creditRequest() throws PreconditionException;
	boolean accountStatusRequest() throws PreconditionException;
	int calculateScore() throws PreconditionException;
	
	/* all get and set functions for temp property*/
	LoanRequest getCurrentLoanRequest();
	void setCurrentLoanRequest(LoanRequest currentloanrequest);
			
	/* invariant checking function */
}
