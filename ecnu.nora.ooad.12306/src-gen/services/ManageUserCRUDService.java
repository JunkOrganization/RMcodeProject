package services;

import entities.*;
import java.util.List;
import java.time.LocalDate;


public interface ManageUserCRUDService {

	boolean createUser(int userid, String name, String address) throws PreconditionException;
	User queryUser(int userid) throws PreconditionException;
	boolean modifyUser(int userid, String name, String address) throws PreconditionException;
	boolean deleteUser(int userid) throws PreconditionException;
	
	/* all get and set functions for temp property*/
			
	/* invariant checking function */
}
