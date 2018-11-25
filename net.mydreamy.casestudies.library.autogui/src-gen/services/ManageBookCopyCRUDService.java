package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ManageBookCopyCRUDService {

	boolean addBookCopy(String callNo, String barcode, String location) throws PreconditionException;
	BookCopy queryBookCopy(String barcode) throws PreconditionException;
	boolean modifyBookCopy(String barcode, CopyStatus status, String location, boolean isreserved) throws PreconditionException;
	boolean deleteBookCopy(String barcode) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
