package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface SearchBook {

	List<Book> searchBookByBarCode(String barcode) throws PreconditionException;
	List<Book> searchBookByTitle(String title) throws PreconditionException;
	List<Book> searchBookByAuthor(String authorname) throws PreconditionException;
	List<Book> searchBookByISBN(String ISBNnumber) throws PreconditionException;
	List<Book> searchBookBySubject(String subject) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
