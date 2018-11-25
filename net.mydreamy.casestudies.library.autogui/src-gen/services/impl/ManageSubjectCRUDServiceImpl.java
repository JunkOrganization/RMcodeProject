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

public class ManageSubjectCRUDServiceImpl implements ManageSubjectCRUDService{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public ManageSubjectCRUDServiceImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean createSubject(String name) throws PreconditionException {
		/* Code generated for contract definition */
		//Get subject
		Subject subject = null;
		for (Subject sub : (List<Subject>)EntityManager.getAllInstancesOf("Subject"))
		{
			if (sub.getName().equals(name))
			{
				subject = sub;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(subject) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			Subject sub = null;
			sub = (Subject) EntityManager.createObject("Subject");
			sub.setName(name);
			EntityManager.addObject("Subject", sub);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name]
		//all relevant vars : sub
		//all relevant entities : Subject
	} 
	 
	static {opINVRelatedEntity.put("createSubject", Arrays.asList("Subject"));}
	
	@SuppressWarnings("unchecked")
	public Subject querySubject(String name) throws PreconditionException {
		/* Code generated for contract definition */
		//Get subject
		Subject subject = null;
		for (Subject sub : (List<Subject>)EntityManager.getAllInstancesOf("Subject"))
		{
			if (sub.getName().equals(name))
			{
				subject = sub;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(subject) == false) 
		{ 
			/* Logic here */
	 		return subject;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name]
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean modifySubject(String name) throws PreconditionException {
		/* Code generated for contract definition */
		//Get subject
		Subject subject = null;
		for (Subject sub : (List<Subject>)EntityManager.getAllInstancesOf("Subject"))
		{
			if (sub.getName().equals(name))
			{
				subject = sub;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(subject) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			subject.setName(name);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name]
		//all relevant vars : subject
		//all relevant entities : Subject
	} 
	 
	static {opINVRelatedEntity.put("modifySubject", Arrays.asList("Subject"));}
	
	@SuppressWarnings("unchecked")
	public boolean deleteSubject(String name) throws PreconditionException {
		/* Code generated for contract definition */
		//Get subject
		Subject subject = null;
		for (Subject sub : (List<Subject>)EntityManager.getAllInstancesOf("Subject"))
		{
			if (sub.getName().equals(name))
			{
				subject = sub;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(subject) == false && StandardOPs.includes(((List<Subject>)EntityManager.getAllInstancesOf("Subject")), subject)) 
		{ 
			/* Logic here */
			//return primitive type	
			EntityManager.deleteObject("Subject", subject);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name]
		//all relevant vars : subject
		//all relevant entities : Subject
	} 
	 
	static {opINVRelatedEntity.put("deleteSubject", Arrays.asList("Subject"));}
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
