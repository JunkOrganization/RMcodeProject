package services.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import services.*;
	
public class ServiceManager {
	
	private static Map<String, List> AllServiceInstance = new HashMap<String, List>();
	
	private static List<CoCoMEProcessSale> CoCoMEProcessSaleInstances = new LinkedList<CoCoMEProcessSale>();
	private static List<ThridPartServices> ThridPartServicesInstances = new LinkedList<ThridPartServices>();
	private static List<EntityCURDService> EntityCURDServiceInstances = new LinkedList<EntityCURDService>();
	
	static {
		AllServiceInstance.put("CoCoMEProcessSale", CoCoMEProcessSaleInstances);
		AllServiceInstance.put("ThridPartServices", ThridPartServicesInstances);
		AllServiceInstance.put("EntityCURDService", EntityCURDServiceInstances);
	} 
	
	public static List getAllInstancesOf(String ClassName) {
			 return AllServiceInstance.get(ClassName);
	}	
	
	public static CoCoMEProcessSale createCoCoMEProcessSale() {
		CoCoMEProcessSale s = new CoCoMEProcessSaleImpl();
		CoCoMEProcessSaleInstances.add(s);
		return s;
	}
	public static ThridPartServices createThridPartServices() {
		ThridPartServices s = new ThridPartServicesImpl();
		ThridPartServicesInstances.add(s);
		return s;
	}
	public static EntityCURDService createEntityCURDService() {
		EntityCURDService s = new EntityCURDServiceImpl();
		EntityCURDServiceInstances.add(s);
		return s;
	}
}	
