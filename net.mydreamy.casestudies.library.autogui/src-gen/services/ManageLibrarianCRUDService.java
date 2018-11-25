package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ManageLibrarianCRUDService {

	boolean createLibrarian(String librarianid, String name, String password) throws PreconditionException;
	Librarian queryLibrarian(String librarianid) throws PreconditionException;
	boolean modifyLibrarian(String librarianid, String name, String password) throws PreconditionException;
	boolean deleteLibrarian(String librarianid) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
