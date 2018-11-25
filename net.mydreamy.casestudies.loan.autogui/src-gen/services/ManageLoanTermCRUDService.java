package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ManageLoanTermCRUDService {

	boolean createLoanTerm(int itemid, String content) throws PreconditionException;
	LoanTerm queryLoanTerm(int itemid) throws PreconditionException;
	boolean modifyLoanTerm(int itemid, String content) throws PreconditionException;
	boolean deleteLoanTerm(int itemid) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
