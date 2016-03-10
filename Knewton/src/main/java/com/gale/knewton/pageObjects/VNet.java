package com.gale.knewton.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.YamlReader;



public class VNet extends BaseWebComponent{

	WebDriver driver;
	String pagename = "VNet";
	
	public VNet() {
		initializePageFactory(this);
	}

	@FindBy(name="userName")
	WebElement  inp_userName ;
	
	@FindBy(name="password")
	WebElement  inp_password ;

	@FindBy(name="Login")
	WebElement  btn_signIn ;
	
	@FindBy(name="_VN_ServicePortal")
	WebElement  topFrame ;
	
	@FindBy(xpath="//a[contains(.,'Search')]")
	WebElement  lnkSearch ;
	
	@FindBy(name="callId")
	WebElement  inp_callID ;
	
	@FindBy(id="8873")
	WebElement  btnSearch ;
	
	@FindBy(name="ActivitySelect0")
	WebElement  selGoTo ;
	
	@FindBy(xpath="//*[@class='TableBorderAndBg']/tbody/tr[4]/td/table/tbody/tr[2]/td[4]")
	WebElement  tdCallAction ;
	
	@FindBy(xpath="//*[@class='TableBorderAndBg']/tbody/tr[4]/td/table/tbody/tr[2]/td[11]")
	WebElement  txtStatus ;
	
	@FindBy(xpath="(//span[@id='78751']/u)[2]")
	WebElement  linkReportID ;
	
	@FindBy(name="coordinatorReviewedCheckbox")
	WebElement  ckBoxCR ;
	
	@FindBy(id="77830")
	WebElement  lnkSubmitRprtEve ;
	
	@FindBy(id="78750")
	WebElement  linkNotes ;
		
	@FindBy(xpath="(//span[@id='78751']/u)[1]")
	WebElement  lnkclrDLR ;
	
	@FindBy(xpath="//tr[9]/td/table/tbody/tr[27]/td[3]")
	WebElement  crkIDCLRDLR ;
	
	@FindBy(xpath="(//a[@class='StatusBar'])[4]")
	WebElement  back ;
	
	@FindBy(id="70")
	WebElement  home ;
	
	@FindBy(xpath="(//span[@id='78751']/u)[1]")
	WebElement  faults ;
	
	@FindBy(xpath="(//a[@class='WinletTabFontBack'])[2]")
	WebElement  addFaultTab ;
	
	@FindBy(name="faultId")
	WebElement  ddfltID ;
	
	@FindBy(id="77830")
	WebElement  btnaddFault ;
	
	@FindBy(xpath="(//span[@id='78751']/u)[2]")
	WebElement  linkReportEvent ;
	
	@FindBy(name="checkBoxsrvcCenComp")
	WebElement  checkBoxsrvcCenComp ;
	
	@FindBy(name="completeReasonDropdown")
	WebElement  ddCompleteReason ;
	
	@FindBy(name="note")
	WebElement  inpReportRemarks ;
	
	@FindBy(xpath="//tr[5]/td")
	WebElement  txtSCenter ;
	
	@FindBy(id="77830")
	WebElement  lnkSubComp ;
	
	@FindBy(id="120")
	WebElement  logout ;
	
						   			
			
	
	
	public void loginVNet(String loginID, String password) {
		switchToFrame(topFrame);
		inp_userName.sendKeys(loginID);
		inp_password.clear();
		inp_password.sendKeys(password);
		btn_signIn.click();
		hardWait(5);
		logMessage("Step: click btn_signIn\n");
		

	}
	
	public String searchCallGetStatus(String VNetId) {
		switchToDefaultContent();
		switchToFrame(topFrame);
		isElementEnabled(lnkSearch, true);
		lnkSearch.click();
		
		hardWait(5);
		switchToiFrame(0);
		inp_callID.sendKeys(VNetId) ;
		clickByJavascript(btnSearch);
		//element("btnSearch").submit();
		//element("btnSearch").click();
		
		hardWait(5);
		String status=txtStatus.getText();
		logMessage("Step: Status"+status);
		//hover(element("txtStatus"));
		return status;
		
	}
	
		
	
	public void logoutVNet() {
		switchToDefaultContent();
		switchToFrame(topFrame);
		isElementEnabled(logout,true);
		logout.click();
		logMessage("Step: VNet is logged out\n");
	}
	

	public void closeVnetTicket(String VNetId) {
		/*
		holdExecution(2000);
		switchToDefaultContent();
		switchToFrame(element("topFrame"));
		element("home").click();
		searchCallGetStatus(VNetId);
		holdExecution(2000);
		selectDropDownValue(element("selGoTo"), 4);
		holdExecution(5000);
		switchToDefaultContent();
		switchToFrame(element("topFrame"));
		switchToiFrame(0);
		holdExecution(2000);
		
		element("ckBoxCR").sendKeys(" ");
		holdExecution(2000);
		//clickable(element("lnkSubmitRprtEve"));
		//element("lnkSubmitRprtEve").click();
		clickByJavascript("lnkSubmitRprtEve");
		holdExecution(2000);
		//element("lnkSubmitRprtEve").submit();
		element("linkNotes").click();
		holdExecution(2000);
		clickByJavascript("lnkclrDLR");
		//element("lnkclrDLR").click();
		//clickByJavascript("lnkclrDLR");
		holdExecution(2000);
		String circuit=element("crkIDCLRDLR").getText();
		logMessage("Circuit ID in VNET"+ circuit +"\n");
		switchToDefaultContent();
		switchToFrame(element("topFrame"));
		element("home").click();
		searchCallGetStatus(VNetId);
		holdExecution(2000);
		selectDropDownValue(element("selGoTo"), 2);
		holdExecution(2000);
		selectProvidedTextFromDropDown(element("ddfltID"), "88_NO_TROUBLE_FOUND");
		holdExecution(5000);
		switchToDefaultContent();
		switchToFrame(element("topFrame"));
		switchToiFrame(0);
		isElementEnabled("btnaddFault", true);
		element("btnaddFault").submit();
		holdExecution(2000);
		clickByJavascript("linkReportEvent");
		holdExecution(2000);
		
		element("checkBoxsrvcCenComp").sendKeys(" ");
		selectProvidedTextFromDropDown(element("ddCompleteReason"), "Customer Advised OK to Close");
		element("inpReportRemarks").sendKeys("Automation testing completed");
		holdExecution(2000);
		//element("lnkSubComp").submit();
		clickByJavascript("lnkSubComp");
		holdExecution(20000);
		String status= element("txtSCenter").getText();
		logMessage("Statas of woerk in VNET"+ status +"\n");
			*/
	}
	
	
}
