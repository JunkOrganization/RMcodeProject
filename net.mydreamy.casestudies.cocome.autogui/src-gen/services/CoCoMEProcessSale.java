package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface CoCoMEProcessSale {

	boolean makeNewSale() throws PreconditionException;
	boolean enterItem(int barcode, int quantity) throws PreconditionException;
	boolean endSale() throws PreconditionException;
	boolean makeCashPayment(float amount) throws PreconditionException;
	boolean makeCardPayment(String cardAccountNumber, LocalDate expiryDate, float fee) throws PreconditionException;
	
	/* all get and set functions for temp property*/
	SalesLineItem getCurrentSaleLine();
	void setCurrentSaleLine(SalesLineItem currentsaleline);
	Sale getCurrentSale();
	void setCurrentSale(Sale currentsale);
	CashDesk getCurrentCashDesk();
	void setCurrentCashDesk(CashDesk currentcashdesk);
	Store getCurrentStore();
	void setCurrentStore(Store currentstore);
	PaymentMethod getCurrentPaymentMethod();
	void setCurrentPaymentMethod(PaymentMethod currentpaymentmethod);
			
	/* invariant checking function */
}
