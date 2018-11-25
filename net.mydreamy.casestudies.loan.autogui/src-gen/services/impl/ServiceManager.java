package services.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import services.*;
	
public class ServiceManager {
	
	private static Map<String, List> AllServiceInstance = new HashMap<String, List>();
	
	private static List<SubmitLoanRequestModule> SubmitLoanRequestModuleInstances = new LinkedList<SubmitLoanRequestModule>();
	private static List<ThirdPartServices> ThirdPartServicesInstances = new LinkedList<ThirdPartServices>();
	private static List<EnterValidatedCreditReferencesModule> EnterValidatedCreditReferencesModuleInstances = new LinkedList<EnterValidatedCreditReferencesModule>();
	private static List<EvaluateLoanRequestModule> EvaluateLoanRequestModuleInstances = new LinkedList<EvaluateLoanRequestModule>();
	private static List<GenerateLoanLetterAndAgreementModule> GenerateLoanLetterAndAgreementModuleInstances = new LinkedList<GenerateLoanLetterAndAgreementModule>();
	private static List<LoanManagementModule> LoanManagementModuleInstances = new LinkedList<LoanManagementModule>();
	private static List<ManageLoanTermCRUDService> ManageLoanTermCRUDServiceInstances = new LinkedList<ManageLoanTermCRUDService>();
	
	static {
		AllServiceInstance.put("SubmitLoanRequestModule", SubmitLoanRequestModuleInstances);
		AllServiceInstance.put("ThirdPartServices", ThirdPartServicesInstances);
		AllServiceInstance.put("EnterValidatedCreditReferencesModule", EnterValidatedCreditReferencesModuleInstances);
		AllServiceInstance.put("EvaluateLoanRequestModule", EvaluateLoanRequestModuleInstances);
		AllServiceInstance.put("GenerateLoanLetterAndAgreementModule", GenerateLoanLetterAndAgreementModuleInstances);
		AllServiceInstance.put("LoanManagementModule", LoanManagementModuleInstances);
		AllServiceInstance.put("ManageLoanTermCRUDService", ManageLoanTermCRUDServiceInstances);
	} 
	
	public static List getAllInstancesOf(String ClassName) {
			 return AllServiceInstance.get(ClassName);
	}	
	
	public static SubmitLoanRequestModule createSubmitLoanRequestModule() {
		SubmitLoanRequestModule s = new SubmitLoanRequestModuleImpl();
		SubmitLoanRequestModuleInstances.add(s);
		return s;
	}
	public static ThirdPartServices createThirdPartServices() {
		ThirdPartServices s = new ThirdPartServicesImpl();
		ThirdPartServicesInstances.add(s);
		return s;
	}
	public static EnterValidatedCreditReferencesModule createEnterValidatedCreditReferencesModule() {
		EnterValidatedCreditReferencesModule s = new EnterValidatedCreditReferencesModuleImpl();
		EnterValidatedCreditReferencesModuleInstances.add(s);
		return s;
	}
	public static EvaluateLoanRequestModule createEvaluateLoanRequestModule() {
		EvaluateLoanRequestModule s = new EvaluateLoanRequestModuleImpl();
		EvaluateLoanRequestModuleInstances.add(s);
		return s;
	}
	public static GenerateLoanLetterAndAgreementModule createGenerateLoanLetterAndAgreementModule() {
		GenerateLoanLetterAndAgreementModule s = new GenerateLoanLetterAndAgreementModuleImpl();
		GenerateLoanLetterAndAgreementModuleInstances.add(s);
		return s;
	}
	public static LoanManagementModule createLoanManagementModule() {
		LoanManagementModule s = new LoanManagementModuleImpl();
		LoanManagementModuleInstances.add(s);
		return s;
	}
	public static ManageLoanTermCRUDService createManageLoanTermCRUDService() {
		ManageLoanTermCRUDService s = new ManageLoanTermCRUDServiceImpl();
		ManageLoanTermCRUDServiceInstances.add(s);
		return s;
	}
}	
