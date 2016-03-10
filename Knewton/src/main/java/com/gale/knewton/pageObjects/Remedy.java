package com.gale.knewton.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;
import com.gale.knewton.base.BaseWebComponent;

public class Remedy extends BaseWebComponent{

	WebDriver driver;
	String pagename = "Remedy";
	String serviceIDName=""; 
	String VnetIDName="";

	public Remedy() {
		initializePageFactory(this);
	}

	@FindBy(id="username-id")
	WebElement  inp_userName ;
	
	@FindBy(id="pwd-id")
	WebElement  inp_password ;
	
	@FindBy(name="login")
	WebElement  btn_signIn ;
	
	@FindBy(xpath=".//*[@class='BaseTable']/tbody/tr[2]/td[23]")
	WebElement  serviceID ;
	
	@FindBy(xpath=".//*[@class='BaseTable']/tbody/tr[2]/td[2]")
	WebElement  VnetID ;
	
	@FindBy(linkText="Refresh")
	WebElement  refresh ;
	
	@FindBy(xpath="//a[3]/div/div")
	WebElement  logout ;
	
	@FindBy(css="div.f1")
	WebElement  btn_ackldg ;
	
	@FindBy(id="arid_WIN_0_700025204")
	WebElement  tcktPrty ;
	
	@FindBy(linkText="Report")
	WebElement  Report ;
	
	@FindBy(css="#WIN_0_536871021 > div.btntextdiv")
	WebElement  imgBilling ;
	
	@FindBy(css="#WIN_0_1003 > div.btntextdiv > div.f7")
	WebElement  lnkModify ;
	
	@FindBy(linkText="Dispatch")
	WebElement  lnkDispatch ;
	
	@FindBy(css="#WIN_0_777504010 > div.btntextdiv > div.f7")
	WebElement  lnkCreateFrmTckt ;
	
	@FindBy(id="arid_WIN_0_800007019")
	WebElement  ddDispatch ;
	
	@FindBy(id="arid_WIN_0_800007013")
	WebElement  ddSkillSet ;
	
	@FindBy(css="div.f7")
	WebElement  btnSubmit ;
	
	@FindBy(linkText="Timeline")
	WebElement  lnkTimeline ;
	
	@FindBy(css="#WIN_0_777000001 > div.btnimgdiv")
	WebElement  btnCloseWO ;
	
	
	@FindBy(id="reg_img_777000001")
	WebElement  btnCloseOP ;
	//reg_img_777000001
	
	public void loginRemedy(String loginID, String password) {
		inp_userName.sendKeys(loginID);
		inp_password.sendKeys(password);
		btn_signIn.click();
		logMessage("Step: click btn_signIn\n");
	}
	
	public String getServiceID(int rowNumber) throws InterruptedException {
		refresh.click();
		hardWait(4);
		if (rowNumber==1) {
			isElementEnabled(serviceID, true);
			serviceIDName=serviceID.getText();
			logMessage("Step: Getting circuit ID "+  serviceIDName+ " from remedy\n");
			return serviceIDName;
			
		} else {
			isElementEnabled(serviceID,true);
			serviceIDName=serviceID.getText();
			logMessage("Step: Getting circuit ID "+ serviceIDName+" from remedy\n");
			return serviceIDName;
		}
		
	}
	public String getVnetID() throws InterruptedException {
		refresh.click();
		hardWait(3);
		
		isElementEnabled(VnetID, true);
		VnetIDName=VnetID.getText();
		logMessage("Step: Getting circuit ID from remedy\n");
		return VnetIDName;
	}
	public void dblclickServiceID() { 
		isElementEnabled(serviceID,true);
		doubleClick(serviceID);
		logMessage("Step: double clicked on serviceID \n");
	}
	
	public void closeMutipleWindow() {
		btnCloseWO.click();
		hardWait(2);
		switchWindow();
		btnCloseOP.click();
		hardWait(2);
		switchWindow();
		//isElementDisplayed("serviceID");
		//doubleClick(element("serviceID"));
		//logMessage("Step: double clicked on serviceID \n");
	}
	

	public void createWorkOrder(String ticketPriority,String dispatchNotes,String skillSet) {
		switchWindow();
		isElementEnabled(Report, true);
		isElementEnabled(btn_ackldg,true);
		btn_ackldg.click();
		logMessage("Step: clicked on acknowledge \n");
		//isElementEnabled("Report", true);
		hardWait(5);
		isElementEnabled(imgBilling,true);
		isElementEnabled(Report, true);
		String script="document.getElementById('arid_WIN_0_700025204').value = '"+ticketPriority+"';";
		
		executeJavascript(script);
		fireEventChange(tcktPrty);
		//doubleClick(element("tcktPrty"));
		hardWait(2);
		isElementEnabled(Report, true);
		logMessage("Step:Major has been selected");
		//Click on modify
		isElementEnabled(lnkModify, true);
		lnkModify.click();
		hardWait(2);
		isElementEnabled(Report, true);
		lnkDispatch.click();
		lnkCreateFrmTckt.click();
		switchWindow();
		//give dispatch and skill set value and submit
		
		isElementEnabled(ddDispatch, true);
		doubleClick(ddDispatch);
		script="document.getElementById('arid_WIN_0_800007019').value = '"+dispatchNotes+"';";
		executeJavascript(script);
		fireEventChange(ddDispatch);
		doubleClick(ddDispatch);
		
		isElementEnabled(ddSkillSet, true);
		doubleClick(ddSkillSet);
		script="document.getElementById('arid_WIN_0_800007013').value = '"+skillSet+"';";
		executeJavascript(script);
		fireEventChange(ddSkillSet);
		doubleClick(ddSkillSet);
		
		hardWait(2);
		btnSubmit.click();
		waitForElementToDisable(btnSubmit);
		hardWait(5);
			
	}
	
	
	public void verifyVNetIdDissapear() {
		
	}
	public void logoutRemedy() {
		isElementEnabled(logout,true);
		logout.click();
		
	}
}
