package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ThirdPartServices {

	boolean thirdPartyCardPaymentService(String cardAccountNumber, LocalDate expiryDate, float fee) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
