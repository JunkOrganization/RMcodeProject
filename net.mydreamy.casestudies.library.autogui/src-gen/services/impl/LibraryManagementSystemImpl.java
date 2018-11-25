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

public class LibraryManagementSystemImpl implements LibraryManagementSystem{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public LibraryManagementSystemImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean recommendBook(String uid, String callNo, String title, String edition, String author, String publisher, String description, String isbn) throws PreconditionException {
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
		//Get rb
		RecommendBook rb = null;
		for (RecommendBook r : (List<RecommendBook>)EntityManager.getAllInstancesOf("RecommendBook"))
		{
			if (r.getCallNo().equals(callNo))
			{
				rb = r;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == false && StandardOPs.oclIsundefined(rb) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			RecommendBook r = null;
			r = (RecommendBook) EntityManager.createObject("RecommendBook");
			r.setCallNo(callNo);
			r.setTitle(title);
			r.setEdition(edition);
			r.setAuthor(author);
			r.setPublisher(publisher);
			r.setDescription(description);
			r.setISBn(isbn);
			r.setRecommendDate(LocalDate.now());
			r.setRecommendUser(user);
			user.addRecommendedBook(r);
			EntityManager.addObject("RecommendBook", r);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [uid, callNo, title, edition, author, publisher, description, isbn]
		//all relevant vars : r
		//all relevant entities : RecommendBook
	} 
	 
	static {opINVRelatedEntity.put("recommendBook", Arrays.asList("RecommendBook"));}
	
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
	
	@SuppressWarnings("unchecked")
	public boolean makeReservation(String uid, String barcode) throws PreconditionException {
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
		//Get copy
		BookCopy copy = null;
		for (BookCopy bc : (List<BookCopy>)EntityManager.getAllInstancesOf("BookCopy"))
		{
			if (bc.getBarcode().equals(barcode))
			{
				copy = bc;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == false && StandardOPs.oclIsundefined(copy) == false && copy.getStatus() == CopyStatus.LOANED && copy.getIsReserved() == false) 
		{ 
			/* Logic here */
			//return primitive type	
			Reserve res = null;
			res = (Reserve) EntityManager.createObject("Reserve");
			copy.setIsReserved(true);
			res.setIsReserveClosed(false);
			res.setReserveDate(LocalDate.now());
			res.setReservedUser(user);
			res.setReservedCopy(copy);
			user.addReservedBook(res);
			copy.addReservationRecord(res);
			EntityManager.addObject("Reserve", res);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [uid, barcode]
		//all relevant vars : res copy
		//all relevant entities : Reserve BookCopy
	} 
	 
	static {opINVRelatedEntity.put("makeReservation", Arrays.asList("Reserve","BookCopy"));}
	
	@SuppressWarnings("unchecked")
	public boolean cannelReservation(String uid, String barcode) throws PreconditionException {
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
		//Get copy
		BookCopy copy = null;
		for (BookCopy bc : (List<BookCopy>)EntityManager.getAllInstancesOf("BookCopy"))
		{
			if (bc.getBarcode().equals(barcode))
			{
				copy = bc;
				break;
			}
		}
		//Get res
		Reserve res = null;
		for (Reserve r : (List<Reserve>)EntityManager.getAllInstancesOf("Reserve"))
		{
			if (r.getReservedCopy() == copy && r.getReservedUser() == user)
			{
				res = r;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == false && StandardOPs.oclIsundefined(copy) == false && copy.getStatus() == CopyStatus.LOANED && copy.getIsReserved() == true && StandardOPs.oclIsundefined(res) == false && res.getIsReserveClosed() == false) 
		{ 
			/* Logic here */
			//return primitive type	
			copy.setIsReserved(false);
			res.setIsReserveClosed(true);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [uid, barcode]
		//all relevant vars : res copy
		//all relevant entities : Reserve BookCopy
	} 
	 
	static {opINVRelatedEntity.put("cannelReservation", Arrays.asList("Reserve","BookCopy"));}
	
	@SuppressWarnings("unchecked")
	public boolean borrowBook(String uid, String barcode) throws PreconditionException {
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
		//Get stu
		Student stu = null;
		for (Student s : (List<Student>)EntityManager.getAllInstancesOf("Student"))
		{
			if (s.getUserID().equals(uid))
			{
				stu = s;
				break;
			}
		}
		//Get fac
		Faculty fac = null;
		for (Faculty f : (List<Faculty>)EntityManager.getAllInstancesOf("Faculty"))
		{
			if (f.getUserID().equals(uid))
			{
				fac = f;
				break;
			}
		}
		//Get copy
		BookCopy copy = null;
		for (BookCopy bc : (List<BookCopy>)EntityManager.getAllInstancesOf("BookCopy"))
		{
			if (bc.getBarcode().equals(barcode))
			{
				copy = bc;
				break;
			}
		}
		//Get res
		Reserve res = null;
		for (Reserve r : (List<Reserve>)EntityManager.getAllInstancesOf("Reserve"))
		{
			if (r.getReservedCopy() == copy && r.getReservedUser() == user && r.getIsReserveClosed() == false)
			{
				res = r;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == false && StandardOPs.oclIsundefined(copy) == false && user.getBorrowStatus() == BorrowStatus.NORMAL && user.getSuspensionDays() == 0 && (user instanceof Student ? (stu.getProgramme() == Programme.BACHELOR ? stu.getLoanedNumber() < 20 : (stu.getProgramme() == Programme.MASTER ? stu.getLoanedNumber() < 40 : stu.getLoanedNumber() < 60)) : fac.getLoanedNumber() < 60) && (copy.getStatus() == CopyStatus.AVAILABLE || (copy.getStatus() == CopyStatus.ONHOLDSHELF && copy.getIsReserved() == true && StandardOPs.oclIsundefined(res) == false && res.getIsReserveClosed() == false))) 
		{ 
			/* Logic here */
			//return primitive type	
			Loan loan = null;
			loan = (Loan) EntityManager.createObject("Loan");
			loan.setLoanedUser(user);
			loan.setLoanedCopy(copy);
			loan.setIsReturned(false);
			loan.setLoanDate(LocalDate.now());
			user.setLoanedNumber(user.getLoanedNumber()+1);
			user.addLoanedBook(loan);
			copy.addLoanedRecord(loan);
			if (user instanceof Student)
			{
				loan.setDueDate(LocalDate.now().plusDays(30));
			}
			else
			{
			 	loan.setDueDate(LocalDate.now().plusDays(60));
			}
			if (copy.getStatus() == CopyStatus.ONHOLDSHELF)
			{
				copy.setIsReserved(false);
				res.setIsReserveClosed(true);
			}
			copy.setStatus(CopyStatus.LOANED);
			loan.setOverDue3Days(false);
			loan.setOverDue10Days(false);
			loan.setOverDue17Days(false);
			loan.setOverDue31Days(false);
			EntityManager.addObject("Loan", loan);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [uid, barcode]
		//all relevant vars : res loan copy user
		//all relevant entities : Reserve Loan BookCopy User
	} 
	 
	static {opINVRelatedEntity.put("borrowBook", Arrays.asList("Reserve","Loan","BookCopy","User"));}
	
	@SuppressWarnings("unchecked")
	public boolean renewBook(String uid, String barcode) throws PreconditionException {
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
		//Get stu
		Student stu = null;
		for (Student s : (List<Student>)EntityManager.getAllInstancesOf("Student"))
		{
			if (s.getUserID().equals(uid))
			{
				stu = s;
				break;
			}
		}
		//Get fac
		Faculty fac = null;
		for (Faculty f : (List<Faculty>)EntityManager.getAllInstancesOf("Faculty"))
		{
			if (f.getUserID().equals(uid))
			{
				fac = f;
				break;
			}
		}
		//Get copy
		BookCopy copy = null;
		for (BookCopy bc : (List<BookCopy>)EntityManager.getAllInstancesOf("BookCopy"))
		{
			if (bc.getBarcode().equals(barcode) && bc.getStatus() == CopyStatus.LOANED)
			{
				copy = bc;
				break;
			}
		}
		//Get loan
		Loan loan = null;
		for (Loan l : (List<Loan>)EntityManager.getAllInstancesOf("Loan"))
		{
			if (l.getLoanedUser() == user && l.getLoanedCopy() == copy)
			{
				loan = l;
				break;
			}
		}
		/* check precondition */
		if (user.getBorrowStatus() == BorrowStatus.NORMAL && StandardOPs.oclIsundefined(user) == false && StandardOPs.oclIsundefined(copy) == false && StandardOPs.oclIsundefined(loan) == false && copy.getIsReserved() == false && loan.getDueDate().isAfter(LocalDate.now()) && (user instanceof Student ? loan.getRenewedTimes() < 3 : loan.getRenewedTimes() < 6) && loan.getOverDueFee() == 0) 
		{ 
			/* Logic here */
			//return primitive type	
			loan.setRenewedTimes(loan.getRenewedTimes()+1);
			loan.setRenewDate(LocalDate.now());
			if (user instanceof Student)
			{
				if (stu.getProgramme() == Programme.BACHELOR)
				{
					loan.setDueDate(loan.getDueDate().plusDays(20));
				}
				else
				{
				 	if (stu.getProgramme() == Programme.MASTER)
				 	{
				 		loan.setDueDate(loan.getDueDate().plusDays(40));
				 	}
				 	else
				 	{
				 	 	loan.setDueDate(loan.getDueDate().plusDays(60));
				 	}
				}
			}
			else
			{
			 	loan.setDueDate(loan.getDueDate().plusDays(60));
			}
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [uid, barcode]
		//all relevant vars : loan
		//all relevant entities : Loan
	} 
	 
	static {opINVRelatedEntity.put("renewBook", Arrays.asList("Loan"));}
	
	@SuppressWarnings("unchecked")
	public boolean returnBook(String barcode) throws PreconditionException {
		/* Code generated for contract definition */
		//Get copy
		BookCopy copy = null;
		for (BookCopy bc : (List<BookCopy>)EntityManager.getAllInstancesOf("BookCopy"))
		{
			if (bc.getBarcode().equals(barcode) && bc.getStatus() == CopyStatus.LOANED)
			{
				copy = bc;
				break;
			}
		}
		//Get loan
		Loan loan = null;
		for (Loan l : (List<Loan>)EntityManager.getAllInstancesOf("Loan"))
		{
			if (l.getLoanedCopy() == copy && l.getIsReturned() == false)
			{
				loan = l;
				break;
			}
		}
		//Get loans
		List<Loan> loans = new LinkedList<>();
		for (Loan l : (List<Loan>)EntityManager.getAllInstancesOf("Loan"))
		{
			if (l.getLoanedUser() == loan.getLoanedUser() && l.getIsReturned() == false && l.getDueDate().isAfter(LocalDate.now()))
			{
				loans.add(l);
			}
		}
		//Get res
		Reserve res = null;
		for (Reserve r : copy.getReservationRecord())
		{
			if (r.getReservedCopy() == copy)
			{
				res = r;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(copy) == false && StandardOPs.oclIsundefined(loan) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			loan.getLoanedUser().setLoanedNumber(loan.getLoanedUser().getLoanedNumber()-1);
			loan.setIsReturned(true);
			loan.setReturnDate(LocalDate.now());
			if (copy.getIsReserved() == true)
			{
				copy.setStatus(CopyStatus.ONHOLDSHELF);
				services.sendNotificationEmail(res.getReservedUser().getEmail());
			}
			else
			{
			 	copy.setStatus(CopyStatus.AVAILABLE);
			}
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [barcode]
		//all relevant vars : loan copy
		//all relevant entities : Loan BookCopy
	} 
	 
	static {opINVRelatedEntity.put("returnBook", Arrays.asList("Loan","BookCopy"));}
	
	@SuppressWarnings("unchecked")
	public boolean payOverDueFee(String uid, float fee) throws PreconditionException {
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
		for (Loan l : (List<Loan>)EntityManager.getAllInstancesOf("Loan"))
		{
			if (l.getLoanedUser() == user && l.getDueDate().isBefore(LocalDate.now()) && l.getIsReturned() == true && l.getOverDueFee() > 0)
			{
				loans.add(l);
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(user) == false && StandardOPs.notEmpty(loans) && fee >= user.getOverDueFee()) 
		{ 
			/* Logic here */
			//return primitive type	
			user.setOverDueFee(0);
			//no nested iterator --  iterator: forAll
			for (Loan l : loans)
			{
				l.setOverDueFee(0);
			}
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [uid]
		//all relevant vars : l user
		//all relevant entities : Loan User
	} 
	 
	static {opINVRelatedEntity.put("payOverDueFee", Arrays.asList("Loan","User"));}
	
	@SuppressWarnings("unchecked")
	public void checkOverDueandComputeOverDueFee() throws PreconditionException {
		/* Code generated for contract definition */
		//Get loans
		List<Loan> loans = new LinkedList<>();
		for (Loan loan : (List<Loan>)EntityManager.getAllInstancesOf("Loan"))
		{
			if (loan.getIsReturned() == false && loan.getDueDate().isBefore(LocalDate.now()))
			{
				loans.add(loan);
			}
		}
		/* check precondition */
		if (true) 
		{ 
			/* Logic here */
	        //no return type
			//no nested iterator --  iterator: forAll
			for (Loan loan : loans)
			{
				loan.setIsReturned(false);
				if (LocalDate.now().minusDays(3).isAfter(loan.getDueDate()) && loan.getOverDue3Days() == false)
				{
					loan.getLoanedUser().setBorrowStatus(BorrowStatus.SUSPEND);
					services.sendNotificationEmail(loan.getLoanedUser().getEmail());
					loan.setOverDue3Days(true);
				}
				if (LocalDate.now().minusDays(10).isAfter(loan.getDueDate()) && loan.getOverDue10Days() == false)
				{
					loan.getLoanedUser().setSuspensionDays(loan.getLoanedUser().getSuspensionDays()+14);
					services.sendNotificationEmail(loan.getLoanedUser().getEmail());
					loan.setOverDue10Days(true);
				}
				if (LocalDate.now().minusDays(17).isAfter(loan.getDueDate()) && loan.getOverDue17Days() == false)
				{
					loan.getLoanedUser().setSuspensionDays(loan.getLoanedUser().getSuspensionDays()+30);
					services.sendNotificationEmail(loan.getLoanedUser().getEmail());
					loan.setOverDue17Days(true);
				}
				if (LocalDate.now().minusDays(31).isAfter(loan.getDueDate()) && loan.getOverDue31Days() == false)
				{
					loan.setOverDueFee(60);
					services.sendNotificationEmail(loan.getLoanedUser().getEmail());
					loan.setOverDue31Days(true);
					loan.getLoanedUser().setOverDueFee(loan.getLoanedUser().getOverDueFee()+loan.getOverDueFee());
				}
			}
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : loan
		//all relevant entities : Loan
	} 
	 
	static {opINVRelatedEntity.put("checkOverDueandComputeOverDueFee", Arrays.asList("Loan"));}
	
	@SuppressWarnings("unchecked")
	public void dueSoonNotification() throws PreconditionException {
		/* check precondition */
		if (true) 
		{ 
			/* Logic here */
	        //no return type
			List<User> users = null;
			//no nested iterator --  iterator: forAll
			for (User u : users)
			{
				services.sendNotificationEmail(u.getEmail());
			}
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : u
		//all relevant entities : User
	} 
	 
	static {opINVRelatedEntity.put("dueSoonNotification", Arrays.asList("User"));}
	
	@SuppressWarnings("unchecked")
	public void countDownSuspensionDay() throws PreconditionException {
		/* check precondition */
		if (true) 
		{ 
			/* Logic here */
	        //no return type
			List<User> users = null;
			//no nested iterator --  iterator: forAll
			for (User u : users)
			{
				u.setSuspensionDays(u.getSuspensionDays()-1);
				if (u.getBorrowStatus() == BorrowStatus.SUSPEND && u.getOverDueFee() == 0 && u.getSuspensionDays() == 0)
				{
					u.setBorrowStatus(BorrowStatus.NORMAL);
				}
			}
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : u
		//all relevant entities : User
	} 
	 
	static {opINVRelatedEntity.put("countDownSuspensionDay", Arrays.asList("User"));}
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
