package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ManageCashierCRUDService {

	boolean createCashier(int id, String name) throws PreconditionException;
	Cashier queryCashier(int id) throws PreconditionException;
	boolean modifyCashier(int id, String name) throws PreconditionException;
	boolean deleteCashier(int id) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
