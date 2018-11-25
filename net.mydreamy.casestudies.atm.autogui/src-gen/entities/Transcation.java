package entities;

import services.impl.StandardOPs;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
import java.io.Serializable;
import java.lang.reflect.Method;

public class Transcation implements Serializable {
	
	/* all primary attributes */
	private int WithdrawedNum;
	private float BalanceAfterWithdraw;
	
	/* all references */
	private BankCard InvolvedCard; 
	
	/* all get and set functions */
	public int getWithdrawedNum() {
		return WithdrawedNum;
	}	
	
	public void setWithdrawedNum(int withdrawednum) {
		this.WithdrawedNum = withdrawednum;
	}
	public float getBalanceAfterWithdraw() {
		return BalanceAfterWithdraw;
	}	
	
	public void setBalanceAfterWithdraw(float balanceafterwithdraw) {
		this.BalanceAfterWithdraw = balanceafterwithdraw;
	}
	
	/* all functions for reference*/
	public BankCard getInvolvedCard() {
		return InvolvedCard;
	}	
	
	public void setInvolvedCard(BankCard bankcard) {
		this.InvolvedCard = bankcard;
	}			
	

	/* invarints checking*/
	public boolean Transcation_WithdrawedNumGreatAndEqualZero() {
		
		if (WithdrawedNum >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean Transcation_BalanceAfterWithdrawGreatAndEqualZero() {
		
		if (BalanceAfterWithdraw >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//check all invariants
	public boolean checkAllInvairant() {
		
		if (Transcation_WithdrawedNumGreatAndEqualZero() && Transcation_BalanceAfterWithdrawGreatAndEqualZero()) {
			return true;
		} else {
			return false;
		}
	}	
	
	//check invariant by inv name
	public boolean checkInvariant(String INVname) {
		
		try {
			Method m = this.getClass().getDeclaredMethod(INVname);
			return (boolean) m.invoke(this);
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	
	}	
	
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList("Transcation_WithdrawedNumGreatAndEqualZero","Transcation_BalanceAfterWithdrawGreatAndEqualZero"));

}
