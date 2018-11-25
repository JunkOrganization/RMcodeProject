package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ATMSystem {

	boolean deposit(float quantity) throws PreconditionException;
	boolean inputPassword(int password) throws PreconditionException;
	boolean inputCard(int cardid) throws PreconditionException;
	boolean ejectCard() throws PreconditionException;
	boolean withDraw(int quantity) throws PreconditionException;
	float printReceipt() throws PreconditionException;
	float checkBalance() throws PreconditionException;
	
	/* all get and set functions for temp property*/
	boolean getPasswordValidated();
	void setPasswordValidated(boolean passwordvalidated);
	float getWithdrawedNumber();
	void setWithdrawedNumber(float withdrawednumber);
	BankCard getInputCard();
	void setInputCard(BankCard inputcard);
	boolean getCardIDValidated();
	void setCardIDValidated(boolean cardidvalidated);
	boolean getIsDeposit();
	void setIsDeposit(boolean isdeposit);
	boolean getIsWithdraw();
	void setIsWithdraw(boolean iswithdraw);
	float getDepositedNumber();
	void setDepositedNumber(float depositednumber);
			
	/* invariant checking function */
}
