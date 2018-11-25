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

public class CoCoMEProcessSaleImpl implements CoCoMEProcessSale{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public CoCoMEProcessSaleImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean makeNewSale() throws PreconditionException {
		/* check precondition */
		if (StandardOPs.oclIsundefined(currentCashDesk) == false && currentCashDesk.getIsOpened() == true && (StandardOPs.oclIsundefined(currentSale) == true || (StandardOPs.oclIsundefined(currentSale) == false && currentSale.getIsComplete() == true))) 
		{ 
			/* Logic here */
			//return primitive type	
			Sale s = null;
			s = (Sale) EntityManager.createObject("Sale");
			s.setBelongedCashDesk(currentCashDesk);
			currentCashDesk.addContainedSales(s);
			s.setIsComplete(false);
			s.setIsReadytoPay(false);
			EntityManager.addObject("Sale", s);
			this.setCurrentSale(s);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : s this
		//all relevant entities : Sale 
	} 
	 
	static {opINVRelatedEntity.put("makeNewSale", Arrays.asList("Sale",""));}
	
	@SuppressWarnings("unchecked")
	public boolean enterItem(int barcode, int quantity) throws PreconditionException {
		/* Code generated for contract definition */
		//Get item
		Item item = null;
		for (Item i : (List<Item>)EntityManager.getAllInstancesOf("Item"))
		{
			if (i.getBarcode() == barcode)
			{
				item = i;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(currentSale) == false && currentSale.getIsComplete() == false && StandardOPs.oclIsundefined(item) == false && item.getStockNumber() > 0) 
		{ 
			/* Logic here */
			//return primitive type	
			SalesLineItem sli = null;
			sli = (SalesLineItem) EntityManager.createObject("SalesLineItem");
			this.setCurrentSaleLine(sli);
			sli.setBelongedSale(currentSale);
			currentSale.addContainedSalesLine(sli);
			sli.setQuantity(quantity);
			sli.setBelongedItem(item);
			item.setStockNumber(item.getStockNumber()-quantity);
			sli.setSubamount(item.getPrice()*quantity);
			EntityManager.addObject("SalesLineItem", sli);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : sli item this
		//all relevant entities : SalesLineItem Item 
	} 
	 
	static {opINVRelatedEntity.put("enterItem", Arrays.asList("SalesLineItem","Item",""));}
	
	@SuppressWarnings("unchecked")
	public float endSale() throws PreconditionException {
		/* check precondition */
		if (StandardOPs.oclIsundefined(currentSale) == false && currentSale.getIsComplete() == false && currentSale.getIsReadytoPay() == false) 
		{ 
			/* Logic here */
			//return primitive type	
			//no nested iterator --  iterator: forAll
			for (SalesLineItem sl : currentSale.getContainedSalesLine())
			{
				currentSale.setAmount(currentSale.getAmount()+sl.getSubamount());
			}
			currentSale.setIsReadytoPay(true);
			return currentSale.getAmount();
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : currentSale sl
		//all relevant entities :  SalesLineItem
	} 
	 
	static {opINVRelatedEntity.put("endSale", Arrays.asList("","SalesLineItem"));}
	
	@SuppressWarnings("unchecked")
	public boolean makeCashPayment(float amount) throws PreconditionException {
		/* check precondition */
		if (StandardOPs.oclIsundefined(currentSale) == false && currentSale.getIsComplete() == false && currentSale.getIsReadytoPay() == true && amount >= currentSale.getAmount()) 
		{ 
			/* Logic here */
			//return primitive type	
			CashPayment cp = null;
			cp = (CashPayment) EntityManager.createObject("CashPayment");
			cp.setAmountTendered(amount);
			cp.setBelongedSale(currentSale);
			currentSale.setAssoicatedPayment(cp);
			currentSale.setBelongedstore(currentStore);
			currentStore.addSales(currentSale);
			currentSale.setIsComplete(true);
			currentSale.setTime(LocalDate.now());
			cp.setBalance(amount-currentSale.getAmount());
			EntityManager.addObject("CashPayment", cp);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : currentSale cp
		//all relevant entities :  CashPayment
	} 
	 
	static {opINVRelatedEntity.put("makeCashPayment", Arrays.asList("","CashPayment"));}
	
	@SuppressWarnings("unchecked")
	public boolean makeCardPayment(String cardAccountNumber, LocalDate expiryDate, float fee) throws PreconditionException {
		/* check precondition */
		if (StandardOPs.oclIsundefined(currentSale) == false && currentSale.getIsComplete() == false && currentSale.getIsReadytoPay() == true && services.thirdPartyCardPaymentService(cardAccountNumber, expiryDate, fee)) 
		{ 
			/* Logic here */
			//return primitive type	
			CardPayment cdp = null;
			cdp = (CardPayment) EntityManager.createObject("CardPayment");
			cdp.setAmountTendered(fee);
			cdp.setBelongedSale(currentSale);
			currentSale.setAssoicatedPayment(cdp);
			cdp.setCardAccountNumber(cardAccountNumber);
			cdp.setExpiryDate(expiryDate);
			EntityManager.addObject("CardPayment", cdp);
			currentSale.setBelongedstore(currentStore);
			currentStore.addSales(currentSale);
			currentSale.setIsComplete(true);
			currentSale.setTime(LocalDate.now());
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [cardAccountNumber]
		//all relevant vars : currentSale cdp
		//all relevant entities :  CardPayment
	} 
	 
	static {opINVRelatedEntity.put("makeCardPayment", Arrays.asList("","CardPayment"));}
	
	@SuppressWarnings("unchecked")
	public boolean openCashDesk(int cashDeskID) throws PreconditionException {
		/* Code generated for contract definition */
		//Get cd
		CashDesk cd = null;
		for (CashDesk s : (List<CashDesk>)EntityManager.getAllInstancesOf("CashDesk"))
		{
			if (s.getId() == cashDeskID)
			{
				cd = s;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(cd) == false && cd.getIsOpened() == false && StandardOPs.oclIsundefined(currentStore) == false && currentStore.getIsOpened() == true) 
		{ 
			/* Logic here */
			//return primitive type	
			this.setCurrentCashDesk(cd);
			cd.setIsOpened(true);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : cd this
		//all relevant entities : CashDesk 
	} 
	 
	static {opINVRelatedEntity.put("openCashDesk", Arrays.asList("CashDesk",""));}
	
	@SuppressWarnings("unchecked")
	public boolean closeCashDesk(int cashDeskID) throws PreconditionException {
		/* Code generated for contract definition */
		//Get cd
		CashDesk cd = null;
		for (CashDesk s : (List<CashDesk>)EntityManager.getAllInstancesOf("CashDesk"))
		{
			if (s.getId() == cashDeskID)
			{
				cd = s;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(cd) == false && cd.getIsOpened() == true && StandardOPs.oclIsundefined(currentStore) == false && currentStore.getIsOpened() == true) 
		{ 
			/* Logic here */
			//return primitive type	
			this.setCurrentCashDesk(cd);
			cd.setIsOpened(false);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : cd this
		//all relevant entities : CashDesk 
	} 
	 
	static {opINVRelatedEntity.put("closeCashDesk", Arrays.asList("CashDesk",""));}
	
	@SuppressWarnings("unchecked")
	public boolean openStore(int storeID) throws PreconditionException {
		/* Code generated for contract definition */
		//Get sto
		Store sto = null;
		for (Store s : (List<Store>)EntityManager.getAllInstancesOf("Store"))
		{
			if (s.getId() == storeID)
			{
				sto = s;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(sto) == false && sto.getIsOpened() == false) 
		{ 
			/* Logic here */
			//return primitive type	
			this.setCurrentStore(sto);
			sto.setIsOpened(true);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : this sto
		//all relevant entities :  Store
	} 
	 
	static {opINVRelatedEntity.put("openStore", Arrays.asList("","Store"));}
	
	@SuppressWarnings("unchecked")
	public boolean closeStore(int storeID) throws PreconditionException {
		/* Code generated for contract definition */
		//Get sto
		Store sto = null;
		for (Store s : (List<Store>)EntityManager.getAllInstancesOf("Store"))
		{
			if (s.getId() == storeID)
			{
				sto = s;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(sto) == false && sto.getIsOpened() == true) 
		{ 
			/* Logic here */
			//return primitive type	
			sto.setIsOpened(false);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : sto
		//all relevant entities : Store
	} 
	 
	static {opINVRelatedEntity.put("closeStore", Arrays.asList("Store"));}
	
	/* temp property for controller */
	private SalesLineItem currentSaleLine;
	private Sale currentSale;
	private CashDesk currentCashDesk;
	private Store currentStore;
	private PaymentMethod currentPaymentMethod;
			
	/* all get and set functions for temp property*/
	public SalesLineItem getCurrentSaleLine() {
		return currentSaleLine;
	}	
	
	public void setCurrentSaleLine(SalesLineItem currentsaleline) {
		this.currentSaleLine = currentsaleline;
	}
	public Sale getCurrentSale() {
		return currentSale;
	}	
	
	public void setCurrentSale(Sale currentsale) {
		this.currentSale = currentsale;
	}
	public CashDesk getCurrentCashDesk() {
		return currentCashDesk;
	}	
	
	public void setCurrentCashDesk(CashDesk currentcashdesk) {
		this.currentCashDesk = currentcashdesk;
	}
	public Store getCurrentStore() {
		return currentStore;
	}	
	
	public void setCurrentStore(Store currentstore) {
		this.currentStore = currentstore;
	}
	public PaymentMethod getCurrentPaymentMethod() {
		return currentPaymentMethod;
	}	
	
	public void setCurrentPaymentMethod(PaymentMethod currentpaymentmethod) {
		this.currentPaymentMethod = currentpaymentmethod;
	}
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
