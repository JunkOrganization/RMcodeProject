package services.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import services.*;
	
public class ServiceManager {
	
	private static Map<String, List> AllServiceInstance = new HashMap<String, List>();
	
	private static List<ATMSystem> ATMSystemInstances = new LinkedList<ATMSystem>();
	private static List<ManageBankCardCRUDService> ManageBankCardCRUDServiceInstances = new LinkedList<ManageBankCardCRUDService>();
	private static List<ManageUserCRUDService> ManageUserCRUDServiceInstances = new LinkedList<ManageUserCRUDService>();
	private static List<ThirdPartServices> ThirdPartServicesInstances = new LinkedList<ThirdPartServices>();
	
	static {
		AllServiceInstance.put("ATMSystem", ATMSystemInstances);
		AllServiceInstance.put("ManageBankCardCRUDService", ManageBankCardCRUDServiceInstances);
		AllServiceInstance.put("ManageUserCRUDService", ManageUserCRUDServiceInstances);
		AllServiceInstance.put("ThirdPartServices", ThirdPartServicesInstances);
	} 
	
	public static List getAllInstancesOf(String ClassName) {
			 return AllServiceInstance.get(ClassName);
	}	
	
	public static ATMSystem createATMSystem() {
		ATMSystem s = new ATMSystemImpl();
		ATMSystemInstances.add(s);
		return s;
	}
	public static ManageBankCardCRUDService createManageBankCardCRUDService() {
		ManageBankCardCRUDService s = new ManageBankCardCRUDServiceImpl();
		ManageBankCardCRUDServiceInstances.add(s);
		return s;
	}
	public static ManageUserCRUDService createManageUserCRUDService() {
		ManageUserCRUDService s = new ManageUserCRUDServiceImpl();
		ManageUserCRUDServiceInstances.add(s);
		return s;
	}
	public static ThirdPartServices createThirdPartServices() {
		ThirdPartServices s = new ThirdPartServicesImpl();
		ThirdPartServicesInstances.add(s);
		return s;
	}
}	
