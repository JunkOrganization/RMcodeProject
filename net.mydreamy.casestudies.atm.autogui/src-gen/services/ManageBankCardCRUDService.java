package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ManageBankCardCRUDService {

	boolean createBankCard(int cardid, CardStatus cardstatus, CardCatalog catalog, int password, float balance) throws PreconditionException;
	BankCard queryBankCard(int cardid) throws PreconditionException;
	boolean modifyBankCard(int cardid, CardStatus cardstatus, CardCatalog catalog, int password, float balance) throws PreconditionException;
	boolean deleteBankCard(int cardid) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
