package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface LoanManagementModule {

	boolean bookNewLoan(int requestid, int loanid, int accountid, LocalDate startdate, LocalDate enddate, int repaymentdays) throws PreconditionException;
	boolean generateStandardPaymentNotice() throws PreconditionException;
	boolean generateLateNotice() throws PreconditionException;
	boolean loanPayment(int loanid) throws PreconditionException;
	boolean closeOutLoan(int loanid) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
