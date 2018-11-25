package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface LibraryManagementSystem {

	boolean recommendBook(String uid, String callNo, String title, String edition, String author, String publisher, String description, String isbn) throws PreconditionException;
	BookCopy queryBookCopy(String barcode) throws PreconditionException;
	boolean addBookCopy(String callNo, String barcode, String location) throws PreconditionException;
	boolean deleteBookCopy(String barcode) throws PreconditionException;
	boolean makeReservation(String uid, String barcode) throws PreconditionException;
	boolean cannelReservation(String uid, String barcode) throws PreconditionException;
	boolean borrowBook(String uid, String barcode) throws PreconditionException;
	boolean renewBook(String uid, String barcode) throws PreconditionException;
	boolean returnBook(String barcode) throws PreconditionException;
	boolean payOverDueFee(String uid, float fee) throws PreconditionException;
	void checkOverDueandComputeOverDueFee() throws PreconditionException;
	void dueSoonNotification() throws PreconditionException;
	void countDownSuspensionDay() throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
