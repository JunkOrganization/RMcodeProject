package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface EntityCURDService {

	boolean createStore(int id, String name, String address) throws PreconditionException;
	Store queryStore(int id) throws PreconditionException;
	boolean modifyStore(int id, String name, String address) throws PreconditionException;
	boolean deleteStore(int id) throws PreconditionException;
	boolean createProductCatalog(int id, String name) throws PreconditionException;
	ProductCatalog queryProductCatalog(int id) throws PreconditionException;
	boolean modifyProductCatalog(int id, String name) throws PreconditionException;
	boolean deleteProductCatalog(int id) throws PreconditionException;
	boolean createCashDesk(int id) throws PreconditionException;
	CashDesk queryCashDesk(int id) throws PreconditionException;
	boolean modifyCashDesk(int id) throws PreconditionException;
	boolean deleteCashDesk(int id) throws PreconditionException;
	boolean createCashier(int id, String name) throws PreconditionException;
	Cashier queryCashier(int id) throws PreconditionException;
	boolean modifyCashier(int id, String name) throws PreconditionException;
	boolean deleteCashier(int id) throws PreconditionException;
	boolean createItem(int barcode, String description, float price) throws PreconditionException;
	Item queryItem(int barcode) throws PreconditionException;
	boolean modifyItem(int barcode, String description, float price) throws PreconditionException;
	boolean deleteItem(int barcode) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
