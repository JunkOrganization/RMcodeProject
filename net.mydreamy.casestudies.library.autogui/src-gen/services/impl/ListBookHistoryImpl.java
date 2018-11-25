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

public class ListBookHistoryImpl implements ListBookHistory{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public ListBookHistoryImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public List<Loan> listBorrowHistory(String uid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		User user = null;
		for (User u : (List<User>)EntityManager.getAllInstancesOf("User"))
		{
			if (u.getUserID().equals(uid))
			{
				user = u;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == false) 
		{ 
			/* Logic here */
	 		return user.getLoanedBook();
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [uid]
	} 
	 
	
	@SuppressWarnings("unchecked")
	public List<Loan> listHodingBook(String uid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		User user = null;
		for (User u : (List<User>)EntityManager.getAllInstancesOf("User"))
		{
			if (u.getUserID().equals(uid))
			{
				user = u;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == false) 
		{ 
			/* Logic here */
	 		List<Loan> tempsl = new LinkedList<>();
	 		//no nested iterator --  iterator: select
	 		for (Loan l : user.getLoanedBook())
	 		{
	 			if (l.getIsReturned() == false)
	 			{
	 				tempsl.add(l);
	 			} 
	 		}
	 		return tempsl;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [uid]
	} 
	 
	
	@SuppressWarnings("unchecked")
	public List<BookCopy> listOverDueBook(String uid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		User user = null;
		for (User u : (List<User>)EntityManager.getAllInstancesOf("User"))
		{
			if (u.getUserID().equals(uid))
			{
				user = u;
				break;
			}
		}
		//Get loans
		List<Loan> loans = new LinkedList<>();
		for (Loan l : user.getLoanedBook())
		{
			if (l.getIsReturned() == false && l.getOverDueFee() > 0)
			{
				loans.add(l);
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == false && StandardOPs.oclIsundefined(loans) == false) 
		{ 
			/* Logic here */
	 		List temps = new LinkedList<>();
	 		//no nested iterator --  iterator: collect
	 		for (Loan l : loans)
	 		{
	 			temps.add(l.getLoanedCopy());
	 		}
	 		return temps;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [uid]
	} 
	 
	
	@SuppressWarnings("unchecked")
	public List<BookCopy> listReservationBook(String uid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		User user = null;
		for (User u : (List<User>)EntityManager.getAllInstancesOf("User"))
		{
			if (u.getUserID().equals(uid))
			{
				user = u;
				break;
			}
		}
		//Get res
		List<Reserve> res = new LinkedList<>();
		res = user.getReservedBook();
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == false && StandardOPs.oclIsundefined(res) == false) 
		{ 
			/* Logic here */
	 		List temps = new LinkedList<>();
	 		//no nested iterator --  iterator: collect
	 		for (Reserve r : res)
	 		{
	 			temps.add(r.getReservedCopy());
	 		}
	 		return temps;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [uid]
	} 
	 
	
	@SuppressWarnings("unchecked")
	public List<RecommendBook> listRecommendBook(String uid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		User user = null;
		for (User u : (List<User>)EntityManager.getAllInstancesOf("User"))
		{
			if (u.getUserID().equals(uid))
			{
				user = u;
				break;
			}
		}
		//Get rBooks
		List<RecommendBook> rBooks = new LinkedList<>();
		rBooks = user.getRecommendedBook();
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == false && StandardOPs.oclIsundefined(rBooks) == false) 
		{ 
			/* Logic here */
	 		return rBooks;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [uid]
	} 
	 
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
