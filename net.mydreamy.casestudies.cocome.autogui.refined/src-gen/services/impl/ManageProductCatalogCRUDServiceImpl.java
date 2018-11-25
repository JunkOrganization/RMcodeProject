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

public class ManageProductCatalogCRUDServiceImpl implements ManageProductCatalogCRUDService{
	
	
	public static Map<String, List<String>> opINVRelatedEntity = new HashMap<String, List<String>>();
	
	
	ThirdPartServices services;
			
	public ManageProductCatalogCRUDServiceImpl() {
		services = new ThirdPartServicesImpl();
	}
	
	/* Generate buiness logic according to functional requirement */
	@SuppressWarnings("unchecked")
	public boolean createProductCatalog(int id, String name) throws PreconditionException {
		/* Code generated for contract definition */
		//Get productcatalog
		ProductCatalog productcatalog = null;
		for (ProductCatalog pro : (List<ProductCatalog>)EntityManager.getAllInstancesOf("ProductCatalog"))
		{
			if (pro.getId() == id)
			{
				productcatalog = pro;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(productcatalog) == true) 
		{ 
			/* Logic here */
			//return primitive type	
			ProductCatalog pro = null;
			pro = (ProductCatalog) EntityManager.createObject("ProductCatalog");
			pro.setId(id);
			pro.setName(name);
			EntityManager.addObject("ProductCatalog", pro);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name]
		//all relevant vars : pro
		//all relevant entities : ProductCatalog
	} 
	 
	static {opINVRelatedEntity.put("createProductCatalog", Arrays.asList("ProductCatalog"));}
	
	@SuppressWarnings("unchecked")
	public ProductCatalog queryProductCatalog(int id) throws PreconditionException {
		/* Code generated for contract definition */
		//Get productcatalog
		ProductCatalog productcatalog = null;
		for (ProductCatalog pro : (List<ProductCatalog>)EntityManager.getAllInstancesOf("ProductCatalog"))
		{
			if (pro.getId() == id)
			{
				productcatalog = pro;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(productcatalog) == false) 
		{ 
			/* Logic here */
	 		return productcatalog;
		}
		else
		{
			throw new PreconditionException();				
		}
	} 
	 
	
	@SuppressWarnings("unchecked")
	public boolean modifyProductCatalog(int id, String name) throws PreconditionException {
		/* Code generated for contract definition */
		//Get productcatalog
		ProductCatalog productcatalog = null;
		for (ProductCatalog pro : (List<ProductCatalog>)EntityManager.getAllInstancesOf("ProductCatalog"))
		{
			if (pro.getId() == id)
			{
				productcatalog = pro;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(productcatalog) == false) 
		{ 
			/* Logic here */
			//return primitive type	
			productcatalog.setId(id);
			productcatalog.setName(name);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//string parameters: [name]
		//all relevant vars : productcatalog
		//all relevant entities : ProductCatalog
	} 
	 
	static {opINVRelatedEntity.put("modifyProductCatalog", Arrays.asList("ProductCatalog"));}
	
	@SuppressWarnings("unchecked")
	public boolean deleteProductCatalog(int id) throws PreconditionException {
		/* Code generated for contract definition */
		//Get productcatalog
		ProductCatalog productcatalog = null;
		for (ProductCatalog pro : (List<ProductCatalog>)EntityManager.getAllInstancesOf("ProductCatalog"))
		{
			if (pro.getId() == id)
			{
				productcatalog = pro;
				break;
			}
		}
		/* check precondition */
		if (StandardOPs.oclIsundefined(productcatalog) == false && StandardOPs.includes(((List<ProductCatalog>)EntityManager.getAllInstancesOf("ProductCatalog")), productcatalog)) 
		{ 
			/* Logic here */
			//return primitive type	
			EntityManager.deleteObject("ProductCatalog", productcatalog);
			return true;
		}
		else
		{
			throw new PreconditionException();				
		}
		//all relevant vars : productcatalog
		//all relevant entities : ProductCatalog
	} 
	 
	static {opINVRelatedEntity.put("deleteProductCatalog", Arrays.asList("ProductCatalog"));}
	
	/* temp property for controller */
			
	/* all get and set functions for temp property*/
	
	/* invarints checking*/
	public final static ArrayList<String> allInvariantCheckingFunction = new ArrayList<String>(Arrays.asList());
			
}
