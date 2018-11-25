package services.impl;

import services.*;
import entities.*;
import java.util.List;
import java.util.LinkedList;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ATMSystemImpl implements ATMSystem{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public ATMSystemImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean deposit(float quantity) throws PreconditionException {
		/* check precondition */
		if (this.getPasswordValidated() == true && this.getCardIDValidated() == true && StandardOPs.oclIsundefined(this.getInputCard()) == false && quantity >= 0) 
		{ 
			/* Logic here */
			//return primitive type	
			this.getInputCard().setBalance(this.getInputCard().getBalance()+quantity);
			this.setIsDeposit(true);
			this.setDepositedNumber(quantity);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : this
		//all relevant entities : 
	} 
	 
	static {opINVRelatedEntity.put("deposit", Arrays.asList(""));}
	
	@SuppressWarnings("unchecked")
	public boolean inputPassword(int password) throws PreconditionException {
		/* check precondition */
		if (this.getCardIDValidated() == true && StandardOPs.oclIsundefined(this.getInputCard()) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			if (this.getInputCard().getPassword() == password)
			{
				this.setPasswordValidated(true);
				return true;
			}
			else
			{
			 	this.setPasswordValidated(false);
			 	return false;
			}
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : this
		//all relevant entities : 
	} 
	 
	static {opINVRelatedEntity.put("inputPassword", Arrays.asList(""));}
	
	@SuppressWarnings("unchecked")
	public boolean inputCard(int cardid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get bc
		BankCard bc = null;
		for (BankCard c : (List<BankCard>)EntityManager.getAllInstancesOf("BankCard"))
		{
			if (c.getCardID() == cardid)
			{
				bc = c;
				break;
			}
		}
		/* check precondition */
		if (true) 
		{ 
			/* Logic here */
			//return primitive type	
			if ((StandardOPs.oclIsundefined(bc) == false))
			{
				this.setCardIDValidated(true);
				this.setInputCard(bc);
				return true;
			}
			else
			{
			 	this.setCardIDValidated(false);
			 	return false;
			}
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : this
		//all relevant entities : 
	} 
	 
	static {opINVRelatedEntity.put("inputCard", Arrays.asList(""));}
	
	@SuppressWarnings("unchecked")
	public boolean ejectCard() throws PreconditionException {
		/* check precondition */
		if (this.getPasswordValidated() == true && this.getCardIDValidated() == true && StandardOPs.oclIsundefined(this.getInputCard()) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			this.setInputCard(null);
			this.setPasswordValidated(false);
			this.setCardIDValidated(false);
			this.setIsWithdraw(false);
			this.setIsDeposit(false);
			this.setWithdrawedNumber(0);
			this.setDepositedNumber(0);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : this
		//all relevant entities : 
	} 
	 
	static {opINVRelatedEntity.put("ejectCard", Arrays.asList(""));}
	
	@SuppressWarnings("unchecked")
	public boolean withDraw(int quantity) throws PreconditionException {
		/* check precondition */
		if (this.getPasswordValidated() == true && this.getCardIDValidated() == true && StandardOPs.oclIsundefined(this.getInputCard()) == false && this.getInputCard().getBalance() >= quantity) 
		{ 
			/* Logic here */
			//return primitive type	
			this.getInputCard().setBalance(this.getInputCard().getBalance()-quantity);
			this.setWithdrawedNumber(quantity);
			this.setIsWithdraw(true);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : this
		//all relevant entities : 
	} 
	 
	static {opINVRelatedEntity.put("withDraw", Arrays.asList(""));}
	
	@SuppressWarnings("unchecked")
	public float printReceipt() throws PreconditionException {
		/* check precondition */
		if (this.getCardIDValidated() == true && this.getPasswordValidated() == true && StandardOPs.oclIsundefined(this.getInputCard()) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			if (this.getIsWithdraw() == true)
			{
				return this.getWithdrawedNumber();
			}
			else
			{
			 	if (this.getIsDeposit() == true)
			 	{
			 		return this.getDepositedNumber();
			 	}
			 	else
			 	{
			 	 	return 0;
			 	}
			}
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public float checkBalance() throws PreconditionException {
		/* check precondition */
		if (this.getPasswordValidated() == true && this.getCardIDValidated() == true && StandardOPs.oclIsundefined(this.getInputCard()) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			return this.getInputCard().getBalance();
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	/* temp property for controller */
	private boolean PasswordValidated;
	private float WithdrawedNumber;
	private float TransferNumber;
	private BankCard InputCard;
	private boolean CardIDValidated;
	private boolean IsDeposit;
	private boolean IsWithdraw;
	private float DepositedNumber;
			
	/* all get and set functions for temp property*/
	public boolean getPasswordValidated() {
		return PasswordValidated;
	}	
	
	public void setPasswordValidated(boolean passwordvalidated) {
		this.PasswordValidated = passwordvalidated;
	}
	public float getWithdrawedNumber() {
		return WithdrawedNumber;
	}	
	
	public void setWithdrawedNumber(float withdrawednumber) {
		this.WithdrawedNumber = withdrawednumber;
	}
	public float getTransferNumber() {
		return TransferNumber;
	}	
	
	public void setTransferNumber(float transfernumber) {
		this.TransferNumber = transfernumber;
	}
	public BankCard getInputCard() {
		return InputCard;
	}	
	
	public void setInputCard(BankCard inputcard) {
		this.InputCard = inputcard;
	}
	public boolean getCardIDValidated() {
		return CardIDValidated;
	}	
	
	public void setCardIDValidated(boolean cardidvalidated) {
		this.CardIDValidated = cardidvalidated;
	}
	public boolean getIsDeposit() {
		return IsDeposit;
	}	
	
	public void setIsDeposit(boolean isdeposit) {
		this.IsDeposit = isdeposit;
	}
	public boolean getIsWithdraw() {
		return IsWithdraw;
	}	
	
	public void setIsWithdraw(boolean iswithdraw) {
		this.IsWithdraw = iswithdraw;
	}
	public float getDepositedNumber() {
		return DepositedNumber;
	}	
	
	public void setDepositedNumber(float depositednumber) {
		this.DepositedNumber = depositednumber;
	}
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
