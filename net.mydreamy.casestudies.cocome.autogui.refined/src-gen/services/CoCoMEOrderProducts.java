package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface CoCoMEOrderProducts {

	boolean makeNewOrder(int orderid) throws PreconditionException;
	List<Item> listAllOutOfStoreProducts() throws PreconditionException;
	boolean orderItem(int barcode, int quantity) throws PreconditionException;
	boolean chooseSupplier(int supplierID) throws PreconditionException;
	boolean placeOrder() throws PreconditionException;
	
	/* all get and set functions for temp property*/
	OrderProduct getCurrentOrderProduct();
	void setCurrentOrderProduct(OrderProduct currentorderproduct);
			
	/* invariant checking function */
}
