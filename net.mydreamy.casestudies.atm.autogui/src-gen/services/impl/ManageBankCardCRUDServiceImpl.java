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

public class ManageBankCardCRUDServiceImpl implements ManageBankCardCRUDService{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public ManageBankCardCRUDServiceImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean createBankCard(int cardid, CardStatus cardstatus, CardCatalog catalog, int password, float balance) throws PreconditionException {
		/* Code generated for contract definition */
		//Get bankcard
		BankCard bankcard = null;
		for (BankCard ban : (List<BankCard>)EntityManager.getAllInstancesOf("BankCard"))
		{
			if (ban.getCardID() == cardid)
			{
				bankcard = ban;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(bankcard) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			BankCard ban = null;
			ban = (BankCard) EntityManager.createObject("BankCard");
			ban.setCardID(cardid);
			ban.setCardStatus(cardstatus);
			ban.setCatalog(catalog);
			ban.setPassword(password);
			ban.setBalance(balance);
			EntityManager.addObject("BankCard", ban);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : ban
		//all relevant entities : BankCard
	} 
	 
	static {opINVRelatedEntity.put("createBankCard", Arrays.asList("BankCard"));}
	
	@SuppressWarnings("unchecked")
	public BankCard queryBankCard(int cardid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get bankcard
		BankCard bankcard = null;
		for (BankCard ban : (List<BankCard>)EntityManager.getAllInstancesOf("BankCard"))
		{
			if (ban.getCardID() == cardid)
			{
				bankcard = ban;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(bankcard) == false) 
		{ 
			/* Logic here */
	 		return bankcard;
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean modifyBankCard(int cardid, CardStatus cardstatus, CardCatalog catalog, int password, float balance) throws PreconditionException {
		/* Code generated for contract definition */
		//Get bankcard
		BankCard bankcard = null;
		for (BankCard ban : (List<BankCard>)EntityManager.getAllInstancesOf("BankCard"))
		{
			if (ban.getCardID() == cardid)
			{
				bankcard = ban;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(bankcard) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			bankcard.setCardID(cardid);
			bankcard.setCardStatus(cardstatus);
			bankcard.setCatalog(catalog);
			bankcard.setPassword(password);
			bankcard.setBalance(balance);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : bankcard
		//all relevant entities : BankCard
	} 
	 
	static {opINVRelatedEntity.put("modifyBankCard", Arrays.asList("BankCard"));}
	
	@SuppressWarnings("unchecked")
	public boolean deleteBankCard(int cardid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get bankcard
		BankCard bankcard = null;
		for (BankCard ban : (List<BankCard>)EntityManager.getAllInstancesOf("BankCard"))
		{
			if (ban.getCardID() == cardid)
			{
				bankcard = ban;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(bankcard) == false && StandardOPs.includes(((List<BankCard>)EntityManager.getAllInstancesOf("BankCard")), bankcard)) 
		{ 
			/* Logic here */
			//return primitive type	
			EntityManager.deleteObject("BankCard", bankcard);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : bankcard
		//all relevant entities : BankCard
	} 
	 
	static {opINVRelatedEntity.put("deleteBankCard", Arrays.asList("BankCard"));}
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
