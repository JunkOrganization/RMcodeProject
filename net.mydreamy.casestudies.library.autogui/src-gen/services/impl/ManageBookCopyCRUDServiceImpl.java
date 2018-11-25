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

public class ManageBookCopyCRUDServiceImpl implements ManageBookCopyCRUDService{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public ManageBookCopyCRUDServiceImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean addBookCopy(String callNo, String barcode, String location) throws PreconditionException {
		/* Code generated for contract definition */
		//Get book
		Book book = null;
		for (Book b : (List<Book>)EntityManager.getAllInstancesOf("Book"))
		{
			if (b.getCallNo().equals(callNo))
			{
				book = b;
				break;
			}
		}
		//Get bc
		BookCopy bc = null;
		for (BookCopy c : book.getCopys())
		{
			if (c.getBarcode().equals(barcode))
			{
				bc = c;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(book) == false && StandardOPs.oclIsundefined(bc) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			BookCopy copy = null;
			copy = (BookCopy) EntityManager.createObject("BookCopy");
			copy.setBarcode(barcode);
			copy.setStatus(CopyStatus.AVAILABLE);
			copy.setLocation(location);
			copy.setIsReserved(false);
			book.addCopys(copy);
			copy.setBookBelongs(book);
			book.setCopyNum(book.getCopyNum()+1);
			EntityManager.addObject("BookCopy", copy);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [callNo, barcode, location]
		//all relevant vars : book copy
		//all relevant entities : Book BookCopy
	} 
	 
	static {opINVRelatedEntity.put("addBookCopy", Arrays.asList("Book","BookCopy"));}
	
	@SuppressWarnings("unchecked")
	public BookCopy queryBookCopy(String barcode) throws PreconditionException {
		/* Code generated for contract definition */
		//Get bookcopy
		BookCopy bookcopy = null;
		for (BookCopy boo : (List<BookCopy>)EntityManager.getAllInstancesOf("BookCopy"))
		{
			if (boo.getBarcode().equals(barcode))
			{
				bookcopy = boo;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(bookcopy) == false) 
		{ 
			/* Logic here */
	 		return bookcopy;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [barcode]
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean modifyBookCopy(String barcode, CopyStatus status, String location, boolean isreserved) throws PreconditionException {
		/* Code generated for contract definition */
		//Get bookcopy
		BookCopy bookcopy = null;
		for (BookCopy boo : (List<BookCopy>)EntityManager.getAllInstancesOf("BookCopy"))
		{
			if (boo.getBarcode().equals(barcode))
			{
				bookcopy = boo;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(bookcopy) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			bookcopy.setBarcode(barcode);
			bookcopy.setStatus(status);
			bookcopy.setLocation(location);
			bookcopy.setIsReserved(isreserved);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [barcode, location]
		//all relevant vars : bookcopy
		//all relevant entities : BookCopy
	} 
	 
	static {opINVRelatedEntity.put("modifyBookCopy", Arrays.asList("BookCopy"));}
	
	@SuppressWarnings("unchecked")
	public boolean deleteBookCopy(String barcode) throws PreconditionException {
		/* Code generated for contract definition */
		//Get bookcopy
		BookCopy bookcopy = null;
		for (BookCopy boo : (List<BookCopy>)EntityManager.getAllInstancesOf("BookCopy"))
		{
			if (boo.getBarcode().equals(barcode))
			{
				bookcopy = boo;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(bookcopy) == false && StandardOPs.includes(((List<BookCopy>)EntityManager.getAllInstancesOf("BookCopy")), bookcopy)) 
		{ 
			/* Logic here */
			//return primitive type	
			EntityManager.deleteObject("BookCopy", bookcopy);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [barcode]
		//all relevant vars : bookcopy
		//all relevant entities : BookCopy
	} 
	 
	static {opINVRelatedEntity.put("deleteBookCopy", Arrays.asList("BookCopy"));}
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
