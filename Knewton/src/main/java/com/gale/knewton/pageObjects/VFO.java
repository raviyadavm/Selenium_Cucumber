package com.gale.knewton.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.YamlReader;

public class VFO extends BaseWebComponent {
	
	
	String loginID;
	String password;
	String serviceType;
	
	public VFO(){
		initializePageFactory(this);
	}
	
	@FindBy(id="loginName")
	WebElement  inp_userName ;
	
	@FindBy(id="password")
	WebElement  inp_password ;
		
	@FindBy(name="serviceRequestType")
	WebElement  sel_serviceType ;
	
	@FindBy(css="a > img")
	WebElement  btn_signIn ;
		
	@FindBy(name="mainFrame")
	WebElement  mainFrame ;
		
	@FindBy(xpath="//img[@src='images/menutabs_ticket.gif']")
	WebElement  menuOrder ;
	
	@FindBy(id="menuItemText48")
	WebElement  lnkCreateOrder ;

	@FindBy(id="menuItemText50")
	WebElement  lnkCancle ;
	
	@FindBy(name="selectTR")
	WebElement  radioSelect ;
	
	@FindBy(id="additionalTroubleInfo")
	WebElement  addInfo ;
		
	@FindBy(id="selectedTemplateId")
	WebElement  template ;
	
	@FindBy(id="serviceId")
	WebElement  serviceId ;
	
	@FindBy(css="input.button")
	WebElement  Next ;
			
	@FindBy(css="img[title='Submit']")
	WebElement  submit ;
	
	@FindBy(css="img[title='Reload']")
	WebElement  reload ;
				
	@FindBy(css="img[title='Back to List']")
	WebElement  backList ;
		
	@FindBy(xpath="//*[@class='displayTable']/tbody/tr[2]/td[3]")
	WebElement  ticketID ;
		
	@FindBy(xpath="//*[@class='displayTable']/tbody/tr[2]/td[10]")
	WebElement  agentID ;
		
	@FindBy(xpath="//*[@class='displayTable']/tbody/tr[2]/td[8]")
	WebElement  state ;
	
	public void loginVFO() {
		
	
		loginID=YamlReader.getYamlValue("ASR_CancleCheckout.userName");
		password=YamlReader.getYamlValue("ASR_CancleCheckout.password");
		serviceType=YamlReader.getYamlValue("ASR_CancleCheckout.serviceType");
		inp_userName.sendKeys(loginID);
		inp_password.clear();
		inp_password.sendKeys(password);
		
		logMessage("Login " + loginID + " and password " + password + "has enterned"
				+ "\n");
	    selectProvidedTextFromDropDown(sel_serviceType,serviceType);
		btn_signIn.click();
		logMessage("Step: click btn_signIn\n");
		
	}
	

	public String[] createTroubleTicket(String templateName,String serviceID) {
		switchToFrame(mainFrame);
		hover(menuOrder);
		isElementEnabled(lnkCreateOrder, true);
		lnkCreateOrder.click();
		selectProvidedTextFromDropDown(template, templateName);
		isElementEnabled(serviceId,true);
		serviceId.clear();
		serviceId.sendKeys(serviceID);
		Next.click();
		submit.click();
		reload.click();
		hardWait(2);
		reload.click();
		hardWait(2);
		reload.click();
		backList.click();
		String Ids [] ={ticketID.getText(),agentID.getText()};
		return Ids;
		
	}
	
	public void verifyAndStoreTicket() {
		

	}
	public void searchTicket() {
		
	}
	public void cancleTicket() {
		switchToFrame(mainFrame);
		radioSelect.click();
		hover(menuOrder);
		lnkCancle.click();
		addInfo.sendKeys("Cancled by Automation Team");
		submit.click();
		reload.click();
		hardWait(2);
		reload.click();
		backList.click();
		reload.click();
		hardWait(2);
		//Assert.assertEquals("Closed", element("state").getText());
	}
	
	public void checkStatus(String Ticket,String stateTicket) {
		switchToFrame(mainFrame);
		String stateName=state.getText();
		String ticketIDName=ticketID.getText();
		if (stateTicket.equalsIgnoreCase(stateName)&& Ticket.equalsIgnoreCase(ticketIDName)){
			logMessage("Tickets are matching State is "+state+ " and ticketID is "+ ticketID);
		}
		else{
			logMessage("Tickets are not matching State is "+state+ " and ticketID is should "+ ticketID+ "and its"+Ticket );
		}
			
	}
	public void logout() {
		
	}
	
}
