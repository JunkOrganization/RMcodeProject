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

public class ManageUserCRUDServiceImpl implements ManageUserCRUDService{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public ManageUserCRUDServiceImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean createUser(int userid, String name, String address) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		User user = null;
		for (User use : (List<User>)EntityManager.getAllInstancesOf("User"))
		{
			if (use.getUserID() == userid)
			{
				user = use;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			User use = null;
			use = (User) EntityManager.createObject("User");
			use.setUserID(userid);
			use.setName(name);
			use.setAddress(address);
			EntityManager.addObject("User", use);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name, address]
		//all relevant vars : use
		//all relevant entities : User
	} 
	 
	static {opINVRelatedEntity.put("createUser", Arrays.asList("User"));}
	
	@SuppressWarnings("unchecked")
	public User queryUser(int userid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		User user = null;
		for (User use : (List<User>)EntityManager.getAllInstancesOf("User"))
		{
			if (use.getUserID() == userid)
			{
				user = use;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == false) 
		{ 
			/* Logic here */
	 		return user;
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean modifyUser(int userid, String name, String address) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		User user = null;
		for (User use : (List<User>)EntityManager.getAllInstancesOf("User"))
		{
			if (use.getUserID() == userid)
			{
				user = use;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			user.setUserID(userid);
			user.setName(name);
			user.setAddress(address);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name, address]
		//all relevant vars : user
		//all relevant entities : User
	} 
	 
	static {opINVRelatedEntity.put("modifyUser", Arrays.asList("User"));}
	
	@SuppressWarnings("unchecked")
	public boolean deleteUser(int userid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		User user = null;
		for (User use : (List<User>)EntityManager.getAllInstancesOf("User"))
		{
			if (use.getUserID() == userid)
			{
				user = use;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == false && StandardOPs.includes(((List<User>)EntityManager.getAllInstancesOf("User")), user)) 
		{ 
			/* Logic here */
			//return primitive type	
			EntityManager.deleteObject("User", user);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : user
		//all relevant entities : User
	} 
	 
	static {opINVRelatedEntity.put("deleteUser", Arrays.asList("User"));}
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
