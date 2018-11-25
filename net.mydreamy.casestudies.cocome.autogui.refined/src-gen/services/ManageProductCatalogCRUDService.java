package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ManageProductCatalogCRUDService {

	boolean createProductCatalog(int id, String name) throws PreconditionException;
	ProductCatalog queryProductCatalog(int id) throws PreconditionException;
	boolean modifyProductCatalog(int id, String name) throws PreconditionException;
	boolean deleteProductCatalog(int id) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
