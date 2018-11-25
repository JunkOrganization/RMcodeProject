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

public class ManageLibrarianCRUDServiceImpl implements ManageLibrarianCRUDService{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public ManageLibrarianCRUDServiceImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean createLibrarian(String librarianid, String name, String password) throws PreconditionException {
		/* Code generated for contract definition */
		//Get librarian
		Librarian librarian = null;
		for (Librarian lib : (List<Librarian>)EntityManager.getAllInstancesOf("Librarian"))
		{
			if (lib.getLibrarianID().equals(librarianid))
			{
				librarian = lib;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(librarian) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			Librarian lib = null;
			lib = (Librarian) EntityManager.createObject("Librarian");
			lib.setLibrarianID(librarianid);
			lib.setName(name);
			lib.setPassword(password);
			EntityManager.addObject("Librarian", lib);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [librarianid, name, password]
		//all relevant vars : lib
		//all relevant entities : Librarian
	} 
	 
	static {opINVRelatedEntity.put("createLibrarian", Arrays.asList("Librarian"));}
	
	@SuppressWarnings("unchecked")
	public Librarian queryLibrarian(String librarianid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get librarian
		Librarian librarian = null;
		for (Librarian lib : (List<Librarian>)EntityManager.getAllInstancesOf("Librarian"))
		{
			if (lib.getLibrarianID().equals(librarianid))
			{
				librarian = lib;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(librarian) == false) 
		{ 
			/* Logic here */
	 		return librarian;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [librarianid]
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean modifyLibrarian(String librarianid, String name, String password) throws PreconditionException {
		/* Code generated for contract definition */
		//Get librarian
		Librarian librarian = null;
		for (Librarian lib : (List<Librarian>)EntityManager.getAllInstancesOf("Librarian"))
		{
			if (lib.getLibrarianID().equals(librarianid))
			{
				librarian = lib;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(librarian) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			librarian.setLibrarianID(librarianid);
			librarian.setName(name);
			librarian.setPassword(password);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [librarianid, name, password]
		//all relevant vars : librarian
		//all relevant entities : Librarian
	} 
	 
	static {opINVRelatedEntity.put("modifyLibrarian", Arrays.asList("Librarian"));}
	
	@SuppressWarnings("unchecked")
	public boolean deleteLibrarian(String librarianid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get librarian
		Librarian librarian = null;
		for (Librarian lib : (List<Librarian>)EntityManager.getAllInstancesOf("Librarian"))
		{
			if (lib.getLibrarianID().equals(librarianid))
			{
				librarian = lib;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(librarian) == false && StandardOPs.includes(((List<Librarian>)EntityManager.getAllInstancesOf("Librarian")), librarian)) 
		{ 
			/* Logic here */
			//return primitive type	
			EntityManager.deleteObject("Librarian", librarian);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [librarianid]
		//all relevant vars : librarian
		//all relevant entities : Librarian
	} 
	 
	static {opINVRelatedEntity.put("deleteLibrarian", Arrays.asList("Librarian"));}
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
