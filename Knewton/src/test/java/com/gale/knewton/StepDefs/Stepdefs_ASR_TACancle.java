package com.gale.knewton.StepDefs;
import java.util.Hashtable;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.Remedy;
import com.gale.knewton.pageObjects.VFO;
import com.gale.knewton.pageObjects.VNet;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import com.gale.knewton.util.*;


public class Stepdefs_ASR_TACancle extends BaseWebComponent {
	
	
	static Map<String,Object> testyaml;
	String troubleTicket;
	String agentID;
	String getVnetID;
	String VFO_URL;
	String Remedy_URL;
	String serviceID;
	
	@Given("^I created ticket in VFO with URL (.*?)$")
	public void VFOCreateTicket(String VFO_URL)   {
		System.out.println("*****I created ticket in VFO URL "+VFO_URL);
		this.VFO_URL=VFO_URL;
		DriverFactory.navigateBrowser(VFO_URL);
		VFO VFOpage = new VFO();
		VFOpage.loginVFO();
		/*
		testyaml= YamlReader.getYamlValues("ASR_CancleCheckout");
		String template= (String) testyaml.get("template");
		String serviceID=(String) testyaml.get("serviceID");
		String ids[]=VFOpage.createTroubleTicket(template, serviceID);
		troubleTicket=ids[0];
		agentID=ids[1];
		Stepdefs_baseTest.tearDown();
		*/
	}
	
	
	@Given("^Created service order in Remedy with URL (.*?)$")
	public void created_service_order_in_Remedy(String Remedy_URL) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//Reinitite to run in different browser
		/*
		logMessage("****** Opening Remedy ******\n");
		Stepdefs_baseTest.setUp("firefox");
		Stepdefs_baseTest.navigateBrowser(Remedy_URL);
		this.Remedy_URL=Remedy_URL;
		testyaml= YamlReader.getYamlValues("ASR_CancleCheckout");
		String uNameRemedy= (String) testyaml.get("uNameRemedy");
		String passRemedy=(String) testyaml.get("passRemedy");
		Remedy remedyPage= new Remedy();
		remedyPage.loginRemedy(uNameRemedy,passRemedy);
		hardWait(5);
		serviceID=remedyPage.getServiceID(1);
		String serviceIDYML=(String) testyaml.get("serviceID");
		int timer = 0; 
		while (!serviceID.equals(serviceIDYML) || timer>30 ) {
			serviceID=remedyPage.getServiceID(1);
			timer=timer+1;	
		}
		remedyPage.dblclickServiceID();
		remedyPage.createWorkOrder("Major","Next AM Dispatch","AIR_DRYER");
		remedyPage.closeMutipleWindow();
		getVnetID=remedyPage.getVnetID();
		timer = 0; 
		while (getVnetID.isEmpty() || timer>30 ) {
			getVnetID=remedyPage.getVnetID();
			timer=timer+1;	
		}
		boolean flag=true;
		if (getVnetID.isEmpty()) {
			flag=false;
		}
		remedyPage.logoutRemedy();
		Stepdefs_baseTest.tearDown();
		*/
		
		logMessage("****Created service order in Remedy "+Remedy_URL);
}

	@When("^I Cancle ticket in VFO$")
	public void i_Cancle_ticket_in_VFO() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("*****I Cancle ticket in VFO");
	   /*
	    Stepdefs_baseTest.setUp("firefox");
	    Stepdefs_baseTest.navigateBrowser(VFO_URL);
	    VFO VFOpage = new VFO();
		VFOpage.loginVFO();
 		VFOpage.cancleTicket();
  		VFOpage.logout();
  		Stepdefs_baseTest.tearDown();
  		
  		//Check in Remedy, WO should not be there any more
  		logMessage("****** Opening Remedy ******\n");
		Stepdefs_baseTest.setUp("firefox");
		Stepdefs_baseTest.navigateBrowser(Remedy_URL);
		testyaml= YamlReader.getYamlValues("ASR_CancleCheckout");
		String uNameRemedy= (String) testyaml.get("uNameRemedy");
		String passRemedy=(String) testyaml.get("passRemedy");
		Remedy remedyPage= new Remedy();
		remedyPage.loginRemedy(uNameRemedy,passRemedy);
		  		 		
  		String serviceIDAfterCancle=remedyPage.getServiceID(1);
  		String getVnetIDAfterCancle=remedyPage.getVnetID();
  		
  		if ((!serviceIDAfterCancle.equalsIgnoreCase(serviceID)) && (!getVnetIDAfterCancle.equalsIgnoreCase(getVnetID))) {
  			
  			Assert.assertEquals("True","True"); 
  			//Reporter.log("WO cancled in VNET\n", true);
  		}
  		else{
  			Assert.assertEquals("True","False"); 
  			//Reporter.log("WO did not get cancled in VNet\n", true);
  		}
  		remedyPage.logoutRemedy();
  		Stepdefs_baseTest.tearDown();
	  		*/	
	}

	@Then("^I should be able to see the status  in VNET with URL (.*?)$")
	public void i_should_be_able_to_see_the_status_in_VNET(String VNET_URL) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("*****I should be able to see the status  in VNET "+VNET_URL);
		
		/*
		Stepdefs_baseTest.setUp("IE");
		Stepdefs_baseTest.navigateBrowser(VNET_URL);
		testyaml= YamlReader.getYamlValues("ASR_CancleCheckout");
		String uNameVNet= (String) testyaml.get("uNameVNet");
		Object passVNet1=testyaml.get("passVNet");
		String passVNet=String.valueOf(passVNet1);
		VNet VNetPage=new VNet();
		VNetPage.loginVNet(uNameVNet,passVNet);
		hardWait(5);
		String VNetStatus=VNetPage.searchCallGetStatus(getVnetID);
		
		logMessage("VNet Status is " +VNetStatus);
		//CANCELLED 
	
		Assert.assertEquals("CANCELLED",VNetStatus); 
		VNetPage.takeActualScreenShot("VNET");
		VNetPage.logoutVNet();
		Stepdefs_baseTest.tearDown();
	*/
		
	}
	
	
	

}
