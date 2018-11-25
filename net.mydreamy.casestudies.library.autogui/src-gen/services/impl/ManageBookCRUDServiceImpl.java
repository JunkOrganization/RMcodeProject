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

public class ManageBookCRUDServiceImpl implements ManageBookCRUDService{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public ManageBookCRUDServiceImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean createBook(String callno, String title, String edition, String author, String publisher, String description, String isbn, int copynum) throws PreconditionException {
		/* Code generated for contract definition */
		//Get book
		Book book = null;
		for (Book boo : (List<Book>)EntityManager.getAllInstancesOf("Book"))
		{
			if (boo.getCallNo().equals(callno))
			{
				book = boo;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(book) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			Book boo = null;
			boo = (Book) EntityManager.createObject("Book");
			boo.setCallNo(callno);
			boo.setTitle(title);
			boo.setEdition(edition);
			boo.setAuthor(author);
			boo.setPublisher(publisher);
			boo.setDescription(description);
			boo.setISBn(isbn);
			boo.setCopyNum(copynum);
			EntityManager.addObject("Book", boo);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [callno, title, edition, author, publisher, description, isbn]
		//all relevant vars : boo
		//all relevant entities : Book
	} 
	 
	static {opINVRelatedEntity.put("createBook", Arrays.asList("Book"));}
	
	@SuppressWarnings("unchecked")
	public Book queryBook(String callno) throws PreconditionException {
		/* Code generated for contract definition */
		//Get book
		Book book = null;
		for (Book boo : (List<Book>)EntityManager.getAllInstancesOf("Book"))
		{
			if (boo.getCallNo().equals(callno))
			{
				book = boo;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(book) == false) 
		{ 
			/* Logic here */
	 		return book;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [callno]
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean modifyBook(String callno, String title, String edition, String author, String publisher, String description, String isbn, int copynum) throws PreconditionException {
		/* Code generated for contract definition */
		//Get book
		Book book = null;
		for (Book boo : (List<Book>)EntityManager.getAllInstancesOf("Book"))
		{
			if (boo.getCallNo().equals(callno))
			{
				book = boo;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(book) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			book.setCallNo(callno);
			book.setTitle(title);
			book.setEdition(edition);
			book.setAuthor(author);
			book.setPublisher(publisher);
			book.setDescription(description);
			book.setISBn(isbn);
			book.setCopyNum(copynum);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [callno, title, edition, author, publisher, description, isbn]
		//all relevant vars : book
		//all relevant entities : Book
	} 
	 
	static {opINVRelatedEntity.put("modifyBook", Arrays.asList("Book"));}
	
	@SuppressWarnings("unchecked")
	public boolean deleteBook(String callno) throws PreconditionException {
		/* Code generated for contract definition */
		//Get book
		Book book = null;
		for (Book boo : (List<Book>)EntityManager.getAllInstancesOf("Book"))
		{
			if (boo.getCallNo().equals(callno))
			{
				book = boo;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(book) == false && StandardOPs.includes(((List<Book>)EntityManager.getAllInstancesOf("Book")), book)) 
		{ 
			/* Logic here */
			//return primitive type	
			EntityManager.deleteObject("Book", book);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [callno]
		//all relevant vars : book
		//all relevant entities : Book
	} 
	 
	static {opINVRelatedEntity.put("deleteBook", Arrays.asList("Book"));}
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
