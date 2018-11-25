package services.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import services.*;
	
public class ServiceManager {
	
	private static Map<String, List> AllServiceInstance = new HashMap<String, List>();
	
	private static List<LibraryManagementSystem> LibraryManagementSystemInstances = new LinkedList<LibraryManagementSystem>();
	private static List<ThirdPartServices> ThirdPartServicesInstances = new LinkedList<ThirdPartServices>();
	private static List<ListBookHistory> ListBookHistoryInstances = new LinkedList<ListBookHistory>();
	private static List<SearchBook> SearchBookInstances = new LinkedList<SearchBook>();
	private static List<ManageUserCRUDService> ManageUserCRUDServiceInstances = new LinkedList<ManageUserCRUDService>();
	private static List<ManageBookCRUDService> ManageBookCRUDServiceInstances = new LinkedList<ManageBookCRUDService>();
	private static List<ManageSubjectCRUDService> ManageSubjectCRUDServiceInstances = new LinkedList<ManageSubjectCRUDService>();
	private static List<ManageBookCopyCRUDService> ManageBookCopyCRUDServiceInstances = new LinkedList<ManageBookCopyCRUDService>();
	private static List<ManageLibrarianCRUDService> ManageLibrarianCRUDServiceInstances = new LinkedList<ManageLibrarianCRUDService>();
	
	static {
		AllServiceInstance.put("LibraryManagementSystem", LibraryManagementSystemInstances);
		AllServiceInstance.put("ThirdPartServices", ThirdPartServicesInstances);
		AllServiceInstance.put("ListBookHistory", ListBookHistoryInstances);
		AllServiceInstance.put("SearchBook", SearchBookInstances);
		AllServiceInstance.put("ManageUserCRUDService", ManageUserCRUDServiceInstances);
		AllServiceInstance.put("ManageBookCRUDService", ManageBookCRUDServiceInstances);
		AllServiceInstance.put("ManageSubjectCRUDService", ManageSubjectCRUDServiceInstances);
		AllServiceInstance.put("ManageBookCopyCRUDService", ManageBookCopyCRUDServiceInstances);
		AllServiceInstance.put("ManageLibrarianCRUDService", ManageLibrarianCRUDServiceInstances);
	} 
	
	public static List getAllInstancesOf(String ClassName) {
			 return AllServiceInstance.get(ClassName);
	}	
	
	public static LibraryManagementSystem createLibraryManagementSystem() {
		LibraryManagementSystem s = new LibraryManagementSystemImpl();
		LibraryManagementSystemInstances.add(s);
		return s;
	}
	public static ThirdPartServices createThirdPartServices() {
		ThirdPartServices s = new ThirdPartServicesImpl();
		ThirdPartServicesInstances.add(s);
		return s;
	}
	public static ListBookHistory createListBookHistory() {
		ListBookHistory s = new ListBookHistoryImpl();
		ListBookHistoryInstances.add(s);
		return s;
	}
	public static SearchBook createSearchBook() {
		SearchBook s = new SearchBookImpl();
		SearchBookInstances.add(s);
		return s;
	}
	public static ManageUserCRUDService createManageUserCRUDService() {
		ManageUserCRUDService s = new ManageUserCRUDServiceImpl();
		ManageUserCRUDServiceInstances.add(s);
		return s;
	}
	public static ManageBookCRUDService createManageBookCRUDService() {
		ManageBookCRUDService s = new ManageBookCRUDServiceImpl();
		ManageBookCRUDServiceInstances.add(s);
		return s;
	}
	public static ManageSubjectCRUDService createManageSubjectCRUDService() {
		ManageSubjectCRUDService s = new ManageSubjectCRUDServiceImpl();
		ManageSubjectCRUDServiceInstances.add(s);
		return s;
	}
	public static ManageBookCopyCRUDService createManageBookCopyCRUDService() {
		ManageBookCopyCRUDService s = new ManageBookCopyCRUDServiceImpl();
		ManageBookCopyCRUDServiceInstances.add(s);
		return s;
	}
	public static ManageLibrarianCRUDService createManageLibrarianCRUDService() {
		ManageLibrarianCRUDService s = new ManageLibrarianCRUDServiceImpl();
		ManageLibrarianCRUDServiceInstances.add(s);
		return s;
	}
}	
