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

public class SearchBookImpl implements SearchBook{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public SearchBookImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public List<Book> searchBookByBarCode(String barcode) throws PreconditionException {
		/* check precondition */
		if (barcode instanceof String) 
		{ 
			/* Logic here */
	 		List<Book> tempsbook = new LinkedList<>();
	 		//has nested iterator	
	 		for (Book book : ((List<Book>)EntityManager.getAllInstancesOf("Book")))
	 		{
	 			//nested for here:
	 			for (BookCopy c : book.getCopys()) //generated in pre generator
	 			{			
	 				if (c.getBarcode().equals(barcode))
	 				{
	 					tempsbook.add(book);
	 				}
	 			}
	 		}
	 		return tempsbook;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [barcode]
	} 
	 
	
	@SuppressWarnings("unchecked")
	public List<Book> searchBookByTitle(String title) throws PreconditionException {
		/* check precondition */
		if (!title.equals("")) 
		{ 
			/* Logic here */
	 		List<Book> tempsbook = new LinkedList<>();
	 		//no nested iterator --  iterator: select
	 		for (Book book : ((List<Book>)EntityManager.getAllInstancesOf("Book")))
	 		{
	 			if (book.getTitle().equals(title))
	 			{
	 				tempsbook.add(book);
	 			} 
	 		}
	 		return tempsbook;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [title]
	} 
	 
	
	@SuppressWarnings("unchecked")
	public List<Book> searchBookByAuthor(String authorname) throws PreconditionException {
		/* check precondition */
		if (!authorname.equals("")) 
		{ 
			/* Logic here */
	 		List<Book> tempsbook = new LinkedList<>();
	 		//no nested iterator --  iterator: select
	 		for (Book book : ((List<Book>)EntityManager.getAllInstancesOf("Book")))
	 		{
	 			if (book.getAuthor().equals(authorname))
	 			{
	 				tempsbook.add(book);
	 			} 
	 		}
	 		return tempsbook;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [authorname]
	} 
	 
	
	@SuppressWarnings("unchecked")
	public List<Book> searchBookByISBN(String ISBNnumber) throws PreconditionException {
		/* check precondition */
		if (ISBNnumber instanceof String) 
		{ 
			/* Logic here */
	 		List<Book> tempsbook = new LinkedList<>();
	 		//no nested iterator --  iterator: select
	 		for (Book book : ((List<Book>)EntityManager.getAllInstancesOf("Book")))
	 		{
	 			if (book.getISBn().equals(ISBNnumber))
	 			{
	 				tempsbook.add(book);
	 			} 
	 		}
	 		return tempsbook;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [ISBNnumber]
	} 
	 
	
	@SuppressWarnings("unchecked")
	public List<Book> searchBookBySubject(String subject) throws PreconditionException {
		/* check precondition */
		if (subject instanceof String) 
		{ 
			/* Logic here */
	 		List<Book> tempsbook = new LinkedList<>();
	 		//has nested iterator	
	 		for (Book book : ((List<Book>)EntityManager.getAllInstancesOf("Book")))
	 		{
	 			//nested for here:
	 			for (Subject s : book.getSubject()) //generated in pre generator
	 			{			
	 				if (s.getName().equals(subject))
	 				{
	 					tempsbook.add(book);
	 				}
	 			}
	 		}
	 		return tempsbook;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [subject]
	} 
	 
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
