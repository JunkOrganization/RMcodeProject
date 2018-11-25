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
	public boolean createUser(String userid, String name, Sex sex, String password, String email, String faculty, int loanednumber, BorrowStatus borrowstatus, int suspensiondays, float overduefee) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		User user = null;
		for (User use : (List<User>)EntityManager.getAllInstancesOf("User"))
		{
			if (use.getUserID().equals(userid))
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
			use.setSex(sex);
			use.setPassword(password);
			use.setEmail(email);
			use.setFaculty(faculty);
			use.setLoanedNumber(loanednumber);
			use.setBorrowStatus(borrowstatus);
			use.setSuspensionDays(suspensiondays);
			use.setOverDueFee(overduefee);
			EntityManager.addObject("User", use);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [userid, name, password, email, faculty]
		//all relevant vars : use
		//all relevant entities : User
	} 
	 
	static {opINVRelatedEntity.put("createUser", Arrays.asList("User"));}
	
	@SuppressWarnings("unchecked")
	public User queryUser(String userid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		User user = null;
		for (User use : (List<User>)EntityManager.getAllInstancesOf("User"))
		{
			if (use.getUserID().equals(userid))
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
		//string parameters: [userid]
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean modifyUser(String userid, String name, Sex sex, String password, String email, String faculty, int loanednumber, BorrowStatus borrowstatus, int suspensiondays, float overduefee) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		User user = null;
		for (User use : (List<User>)EntityManager.getAllInstancesOf("User"))
		{
			if (use.getUserID().equals(userid))
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
			user.setSex(sex);
			user.setPassword(password);
			user.setEmail(email);
			user.setFaculty(faculty);
			user.setLoanedNumber(loanednumber);
			user.setBorrowStatus(borrowstatus);
			user.setSuspensionDays(suspensiondays);
			user.setOverDueFee(overduefee);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [userid, name, password, email, faculty]
		//all relevant vars : user
		//all relevant entities : User
	} 
	 
	static {opINVRelatedEntity.put("modifyUser", Arrays.asList("User"));}
	
	@SuppressWarnings("unchecked")
	public boolean deleteUser(String userid) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		User user = null;
		for (User use : (List<User>)EntityManager.getAllInstancesOf("User"))
		{
			if (use.getUserID().equals(userid))
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
		//string parameters: [userid]
		//all relevant vars : user
		//all relevant entities : User
	} 
	 
	static {opINVRelatedEntity.put("deleteUser", Arrays.asList("User"));}
	
	@SuppressWarnings("unchecked")
	public boolean createStudent(String userID, String name, Sex sex, String password, String email, String faculty, String major, Programme programme, StudentStatus registrationStatus) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		Student user = null;
		for (Student u : (List<Student>)EntityManager.getAllInstancesOf("Student"))
		{
			if (u.getUserID().equals(userID))
			{
				user = u;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			Student u = null;
			u = (Student) EntityManager.createObject("Student");
			u.setUserID(userID);
			u.setName(name);
			u.setEmail(email);
			u.setPassword(password);
			u.setSex(sex);
			u.setFaculty(faculty);
			u.setLoanedNumber(0);
			u.setBorrowStatus(BorrowStatus.NORMAL);
			u.setSuspensionDays(0);
			u.setOverDueFee(0);
			u.setMajor(major);
			u.setProgramme(programme);
			u.setRegistrationStatus(registrationStatus);
			EntityManager.addObject("User", u);
			EntityManager.addObject("Student", u);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [userID, name, password, email, faculty, major]
		//all relevant vars : u
		//all relevant entities : Student
	} 
	 
	static {opINVRelatedEntity.put("createStudent", Arrays.asList("Student"));}
	
	@SuppressWarnings("unchecked")
	public boolean createFaculty(String userID, String name, Sex sex, String password, String email, String faculty, FacultyPosition position, FacultyStatus status) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		Faculty user = null;
		for (Faculty u : (List<Faculty>)EntityManager.getAllInstancesOf("Faculty"))
		{
			if (u.getUserID().equals(userID))
			{
				user = u;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			Faculty u = null;
			u = (Faculty) EntityManager.createObject("Faculty");
			u.setUserID(userID);
			u.setName(name);
			u.setEmail(email);
			u.setPassword(password);
			u.setSex(sex);
			u.setFaculty(faculty);
			u.setLoanedNumber(0);
			u.setBorrowStatus(BorrowStatus.NORMAL);
			u.setSuspensionDays(0);
			u.setOverDueFee(0);
			u.setPosition(position);
			u.setStatus(status);
			EntityManager.addObject("User", u);
			EntityManager.addObject("Faculty", u);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [userID, name, password, email, faculty]
		//all relevant vars : u
		//all relevant entities : Faculty
	} 
	 
	static {opINVRelatedEntity.put("createFaculty", Arrays.asList("Faculty"));}
	
	@SuppressWarnings("unchecked")
	public boolean modifyStudent(String userID, String name, Sex sex, String password, String email, String faculty, String major, Programme programme, StudentStatus registrationStatus) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		Student user = null;
		for (Student u : (List<Student>)EntityManager.getAllInstancesOf("Student"))
		{
			if (u.getUserID().equals(userID))
			{
				user = u;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			user.setUserID(userID);
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setSex(sex);
			user.setFaculty(faculty);
			user.setLoanedNumber(0);
			user.setBorrowStatus(BorrowStatus.NORMAL);
			user.setSuspensionDays(0);
			user.setOverDueFee(0);
			user.setMajor(major);
			user.setProgramme(programme);
			user.setRegistrationStatus(registrationStatus);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [userID, name, password, email, faculty, major]
		//all relevant vars : user
		//all relevant entities : Student
	} 
	 
	static {opINVRelatedEntity.put("modifyStudent", Arrays.asList("Student"));}
	
	@SuppressWarnings("unchecked")
	public boolean modifyFaculty(String userID, String name, Sex sex, String password, String email, String faculty, String major, FacultyPosition position, FacultyStatus status) throws PreconditionException {
		/* Code generated for contract definition */
		//Get user
		Faculty user = null;
		for (Faculty u : (List<Faculty>)EntityManager.getAllInstancesOf("Faculty"))
		{
			if (u.getUserID().equals(userID))
			{
				user = u;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			user.setUserID(userID);
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setSex(sex);
			user.setFaculty(faculty);
			user.setLoanedNumber(0);
			user.setBorrowStatus(BorrowStatus.NORMAL);
			user.setSuspensionDays(0);
			user.setOverDueFee(0);
			user.setPosition(position);
			user.setStatus(status);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [userID, name, password, email, faculty, major]
		//all relevant vars : user
		//all relevant entities : Faculty
	} 
	 
	static {opINVRelatedEntity.put("modifyFaculty", Arrays.asList("Faculty"));}
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
