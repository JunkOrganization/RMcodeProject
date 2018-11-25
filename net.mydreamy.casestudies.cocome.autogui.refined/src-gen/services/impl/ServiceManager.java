package services.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import services.*;
	
public class ServiceManager {
	
	private static Map<String, List> AllServiceInstance = new HashMap<String, List>();
	
	private static List<CoCoMEProcessSale> CoCoMEProcessSaleInstances = new LinkedList<CoCoMEProcessSale>();
	private static List<ThirdPartServices> ThirdPartServicesInstances = new LinkedList<ThirdPartServices>();
	private static List<ManageStoreCRUDService> ManageStoreCRUDServiceInstances = new LinkedList<ManageStoreCRUDService>();
	private static List<ManageProductCatalogCRUDService> ManageProductCatalogCRUDServiceInstances = new LinkedList<ManageProductCatalogCRUDService>();
	private static List<ManageCashDeskCRUDService> ManageCashDeskCRUDServiceInstances = new LinkedList<ManageCashDeskCRUDService>();
	private static List<ManageCashierCRUDService> ManageCashierCRUDServiceInstances = new LinkedList<ManageCashierCRUDService>();
	private static List<ManageItemCRUDService> ManageItemCRUDServiceInstances = new LinkedList<ManageItemCRUDService>();
	private static List<ManageSupplierCRUDService> ManageSupplierCRUDServiceInstances = new LinkedList<ManageSupplierCRUDService>();
	private static List<CoCoMEOrderProducts> CoCoMEOrderProductsInstances = new LinkedList<CoCoMEOrderProducts>();
	private static List<CoCoMESystem> CoCoMESystemInstances = new LinkedList<CoCoMESystem>();
	
	static {
		AllServiceInstance.put("CoCoMEProcessSale", CoCoMEProcessSaleInstances);
		AllServiceInstance.put("ThirdPartServices", ThirdPartServicesInstances);
		AllServiceInstance.put("ManageStoreCRUDService", ManageStoreCRUDServiceInstances);
		AllServiceInstance.put("ManageProductCatalogCRUDService", ManageProductCatalogCRUDServiceInstances);
		AllServiceInstance.put("ManageCashDeskCRUDService", ManageCashDeskCRUDServiceInstances);
		AllServiceInstance.put("ManageCashierCRUDService", ManageCashierCRUDServiceInstances);
		AllServiceInstance.put("ManageItemCRUDService", ManageItemCRUDServiceInstances);
		AllServiceInstance.put("ManageSupplierCRUDService", ManageSupplierCRUDServiceInstances);
		AllServiceInstance.put("CoCoMEOrderProducts", CoCoMEOrderProductsInstances);
		AllServiceInstance.put("CoCoMESystem", CoCoMESystemInstances);
	} 
	
	public static List getAllInstancesOf(String ClassName) {
			 return AllServiceInstance.get(ClassName);
	}	
	
	public static CoCoMEProcessSale createCoCoMEProcessSale() {
		CoCoMEProcessSale s = new CoCoMEProcessSaleImpl();
		CoCoMEProcessSaleInstances.add(s);
		return s;
	}
	public static ThirdPartServices createThirdPartServices() {
		ThirdPartServices s = new ThirdPartServicesImpl();
		ThirdPartServicesInstances.add(s);
		return s;
	}
	public static ManageStoreCRUDService createManageStoreCRUDService() {
		ManageStoreCRUDService s = new ManageStoreCRUDServiceImpl();
		ManageStoreCRUDServiceInstances.add(s);
		return s;
	}
	public static ManageProductCatalogCRUDService createManageProductCatalogCRUDService() {
		ManageProductCatalogCRUDService s = new ManageProductCatalogCRUDServiceImpl();
		ManageProductCatalogCRUDServiceInstances.add(s);
		return s;
	}
	public static ManageCashDeskCRUDService createManageCashDeskCRUDService() {
		ManageCashDeskCRUDService s = new ManageCashDeskCRUDServiceImpl();
		ManageCashDeskCRUDServiceInstances.add(s);
		return s;
	}
	public static ManageCashierCRUDService createManageCashierCRUDService() {
		ManageCashierCRUDService s = new ManageCashierCRUDServiceImpl();
		ManageCashierCRUDServiceInstances.add(s);
		return s;
	}
	public static ManageItemCRUDService createManageItemCRUDService() {
		ManageItemCRUDService s = new ManageItemCRUDServiceImpl();
		ManageItemCRUDServiceInstances.add(s);
		return s;
	}
	public static ManageSupplierCRUDService createManageSupplierCRUDService() {
		ManageSupplierCRUDService s = new ManageSupplierCRUDServiceImpl();
		ManageSupplierCRUDServiceInstances.add(s);
		return s;
	}
	public static CoCoMEOrderProducts createCoCoMEOrderProducts() {
		CoCoMEOrderProducts s = new CoCoMEOrderProductsImpl();
		CoCoMEOrderProductsInstances.add(s);
		return s;
	}
	public static CoCoMESystem createCoCoMESystem() {
		CoCoMESystem s = new CoCoMESystemImpl();
		CoCoMESystemInstances.add(s);
		return s;
	}
}	
