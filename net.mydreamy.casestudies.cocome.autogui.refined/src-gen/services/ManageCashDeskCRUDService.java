package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ManageCashDeskCRUDService {

	boolean createCashDesk(int id, String name, boolean isopened) throws PreconditionException;
	CashDesk queryCashDesk(int id) throws PreconditionException;
	boolean modifyCashDesk(int id, String name, boolean isopened) throws PreconditionException;
	boolean deleteCashDesk(int id) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
