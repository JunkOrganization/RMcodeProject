package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ManageItemCRUDService {

	boolean createItem(int barcode, String name, float price, int stocknumber, float orderprice) throws PreconditionException;
	Item queryItem(int barcode) throws PreconditionException;
	boolean modifyItem(int barcode, String name, float price, int stocknumber, float orderprice) throws PreconditionException;
	boolean deleteItem(int barcode) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
