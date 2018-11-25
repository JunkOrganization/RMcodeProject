package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface CoCoMESystem {

	boolean changePrice(int barcode, float newPrice) throws PreconditionException;
	boolean receiveOrderedProduct(int orderID) throws PreconditionException;
	List<Supplier> listSuppliers() throws PreconditionException;
	List<Item> showStockReports() throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
