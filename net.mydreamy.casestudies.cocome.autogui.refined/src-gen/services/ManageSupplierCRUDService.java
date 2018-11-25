package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ManageSupplierCRUDService {

	boolean createSupplier(int id, String name) throws PreconditionException;
	Supplier querySupplier(int id) throws PreconditionException;
	boolean modifySupplier(int id, String name) throws PreconditionException;
	boolean deleteSupplier(int id) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
