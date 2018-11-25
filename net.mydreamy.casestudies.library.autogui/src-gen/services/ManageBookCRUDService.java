package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ManageBookCRUDService {

	boolean createBook(String callno, String title, String edition, String author, String publisher, String description, String isbn, int copynum) throws PreconditionException;
	Book queryBook(String callno) throws PreconditionException;
	boolean modifyBook(String callno, String title, String edition, String author, String publisher, String description, String isbn, int copynum) throws PreconditionException;
	boolean deleteBook(String callno) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
