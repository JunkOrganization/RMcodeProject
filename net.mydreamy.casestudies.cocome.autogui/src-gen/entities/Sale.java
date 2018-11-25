package entities;

import services.impl.StandardOPs;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
import java.io.Serializable;
import java.lang.reflect.Method;

public class Sale implements Serializable {
	
	/* all primary attributes */
	private LocalDate Time;
	private boolean IsComplete;
	private float Amount;
	private boolean IsReadytoPay;
	
	/* all references */
	private Store Belongedstore; 
	private CashDesk BelongedCashDesk; 
	private List<SalesLineItem> ContainedSalesLine = new LinkedList<SalesLineItem>(); 
	private Payment AssoicatedPayment; 
	
	/* all get and set functions */
	public LocalDate getTime() {
		return Time;
	}	
	
	public void setTime(LocalDate time) {
		this.Time = time;
	}
	public boolean getIsComplete() {
		return IsComplete;
	}	
	
	public void setIsComplete(boolean iscomplete) {
		this.IsComplete = iscomplete;
	}
	public float getAmount() {
		return Amount;
	}	
	
	public void setAmount(float amount) {
		this.Amount = amount;
	}
	public boolean getIsReadytoPay() {
		return IsReadytoPay;
	}	
	
	public void setIsReadytoPay(boolean isreadytopay) {
		this.IsReadytoPay = isreadytopay;
	}
	
	/* all functions for reference*/
	public Store getBelongedstore() {
		return Belongedstore;
	}	
	
	public void setBelongedstore(Store store) {
		this.Belongedstore = store;
	}			
	public CashDesk getBelongedCashDesk() {
		return BelongedCashDesk;
	}	
	
	public void setBelongedCashDesk(CashDesk cashdesk) {
		this.BelongedCashDesk = cashdesk;
	}			
	public List<SalesLineItem> getContainedSalesLine() {
		return ContainedSalesLine;
	}	
	
	public void addContainedSalesLine(SalesLineItem saleslineitem) {
		this.ContainedSalesLine.add(saleslineitem);
	}
	
	public void deleteContainedSalesLine(SalesLineItem saleslineitem) {
		this.ContainedSalesLine.remove(saleslineitem);
	}
	public Payment getAssoicatedPayment() {
		return AssoicatedPayment;
	}	
	
	public void setAssoicatedPayment(Payment payment) {
		this.AssoicatedPayment = payment;
	}			
	


}
