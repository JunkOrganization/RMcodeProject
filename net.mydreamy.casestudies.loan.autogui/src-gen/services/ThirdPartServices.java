package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ThirdPartServices {

	boolean sendEmail(String emailaddress, String title, String content) throws PreconditionException;
	boolean print(String content, int numbers) throws PreconditionException;
	LoanAccount createLoanAccount(int id) throws PreconditionException;
	boolean transferFunds(int id, float amount) throws PreconditionException;
	CreditHistory getCreditHistory(int securityid, String name) throws PreconditionException;
	CheckingAccount getCheckingAccountStatus(int cid) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
