package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ListBookHistory {

	List<Loan> listBorrowHistory(String uid) throws PreconditionException;
	List<Loan> listHodingBook(String uid) throws PreconditionException;
	List<BookCopy> listOverDueBook(String uid) throws PreconditionException;
	List<BookCopy> listReservationBook(String uid) throws PreconditionException;
	List<RecommendBook> listRecommendBook(String uid) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
