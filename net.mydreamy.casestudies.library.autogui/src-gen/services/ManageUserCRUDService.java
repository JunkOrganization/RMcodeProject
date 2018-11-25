package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ManageUserCRUDService {

	boolean createUser(String userid, String name, Sex sex, String password, String email, String faculty, int loanednumber, BorrowStatus borrowstatus, int suspensiondays, float overduefee) throws PreconditionException;
	User queryUser(String userid) throws PreconditionException;
	boolean modifyUser(String userid, String name, Sex sex, String password, String email, String faculty, int loanednumber, BorrowStatus borrowstatus, int suspensiondays, float overduefee) throws PreconditionException;
	boolean deleteUser(String userid) throws PreconditionException;
	boolean createStudent(String userID, String name, Sex sex, String password, String email, String faculty, String major, Programme programme, StudentStatus registrationStatus) throws PreconditionException;
	boolean createFaculty(String userID, String name, Sex sex, String password, String email, String faculty, FacultyPosition position, FacultyStatus status) throws PreconditionException;
	boolean modifyStudent(String userID, String name, Sex sex, String password, String email, String faculty, String major, Programme programme, StudentStatus registrationStatus) throws PreconditionException;
	boolean modifyFaculty(String userID, String name, Sex sex, String password, String email, String faculty, String major, FacultyPosition position, FacultyStatus status) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
