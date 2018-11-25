package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ManageSubjectCRUDService {

	boolean createSubject(String name) throws PreconditionException;
	Subject querySubject(String name) throws PreconditionException;
	boolean modifySubject(String name) throws PreconditionException;
	boolean deleteSubject(String name) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
