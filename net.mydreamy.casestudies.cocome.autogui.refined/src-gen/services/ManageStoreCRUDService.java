package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ManageStoreCRUDService {

	boolean createStore(int id, String name, String address, boolean isopened) throws PreconditionException;
	Store queryStore(int id) throws PreconditionException;
	boolean modifyStore(int id, String name, String address, boolean isopened) throws PreconditionException;
	boolean deleteStore(int id) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
