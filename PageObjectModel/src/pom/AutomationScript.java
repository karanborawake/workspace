package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class AutomationScript extends ReusableMethod {
	

	public static void runMe(){
		System.out.println("Run me.....");
	}
	
	public static void test1(){
		System.out.println("test 1 .....");
	}
	public static void test2(){
		System.out.println("test 1 .....");
	}
	
	//1st Test case LoginErrorMessage
	
	public static void LoginErrorMessage() throws Throwable{
		String expectedMessage = "Please enter your password";
	
		Driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Driver.driver.get("https://login.salesforce.com/");
		//driver.manage().window().maximize();

		WebElement userName = Driver.driver.findElement(By.id("username"));
		enterText(userName, "User@gmail.com", "UserName");

		WebElement pwd = Driver.driver.findElement(By.id("password"));
		enterText(pwd, "", "Password");

		WebElement rememberMeChk = Driver.driver.findElement(By.xpath(".//*[@id='rememberUn']"));
		chkBox(rememberMeChk, "RememberMe Check Box");

		WebElement salesForceLoginButton = Driver.driver.findElement(By.id("Login"));
		clickButton(salesForceLoginButton, "Login");

		Thread.sleep(5000);
		WebElement errorMsg = Driver.driver.findElement(By.id("error"));
		validateTextMsg(errorMsg, "Error message", expectedMessage);
		//Driver.driver.quit();
	}

	// 2nd test case LoginToSalesforce
	
	public static void LoginToSalesforce() throws Throwable{
		
		Driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Driver.driver.get("https://login.salesforce.com/");
		
		WebElement userName = Driver.driver.findElement(By.id("username"));
		enterText(userName, "sonalitjadhav@gmail.com", "UserName");

		WebElement pwd = Driver.driver.findElement(By.id("password"));
		enterText(pwd, "Sonali123", "Password");

		WebElement salesForceLoginButton = Driver.driver.findElement(By.id("Login"));
		clickButton(salesForceLoginButton, "Login");
		
	}

	// 3rd Test Case CheckRememberMe checkbox
	public static void CheckRememberMe() throws Throwable{
		String expectedM = "sonalitjadhav@gmail.com";
		//Driver.driver = new FirefoxDriver();
		Driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Driver.driver.get("https://login.salesforce.com/");
		//Driver.driver.manage().window().maximize();

		WebElement userName = Driver.driver.findElement(By.id("username"));
		enterText(userName, "sonalitjadhav@gmail.com", "UserName");

		WebElement pwd = Driver.driver.findElement(By.id("password"));
		enterText(pwd, "Sonali123", "Password");

		WebElement rememberMeChk = Driver.driver.findElement(By.xpath(".//*[@id='rememberUn']"));
		chkBox(rememberMeChk, "RememberMe Check Box");

		WebElement salesForceLoginButton = Driver.driver.findElement(By.id("Login"));
		clickButton(salesForceLoginButton, "Login");

		Thread.sleep(3000);
		WebElement userAuthentication = Driver.driver.findElement(By.id("userNavButton"));
		clickButton(userAuthentication, "Username profile button");

		WebElement logOutButton = Driver.driver.findElement(By.linkText("Logout"));
		clickButton(logOutButton, "LogOut Button");

		Thread.sleep(5000);
		WebElement userNameValidation = Driver.driver.findElement(By.id("idcard-container"));
		validateTextMsg(userNameValidation, "Username ", expectedM);
		//Driver.driver.quit();
	}

	// 4th Test Case ForgotPassword
	public static void ForgotPassword() throws Throwable{
		//Driver.driver = new FirefoxDriver();

		Driver.driver.get("https://login.salesforce.com/");

		//Driver.driver.manage().window().maximize();

		WebElement forgotPasswordLink = Driver.driver.findElement(By.linkText("Forgot Your Password?"));
		clickButton(forgotPasswordLink, "Forgot password link");

		Thread.sleep(3000);
		WebElement userNameEnter = Driver.driver.findElement(By.id("un"));
		enterText(userNameEnter, "sonalitjadhav@gmail.com", "UserName");

		WebElement continueButton = Driver.driver.findElement(By.id("continue"));
		clickButton(continueButton, "Continue Button");

		Thread.sleep(3000);
		WebElement actuallinkmsg = Driver.driver.findElement(By.xpath(".//*[@id='forgotPassForm']/div/p[1]"));

		String expectedM = "We’ve sent you an email with a link to finish resetting your password.";

		validateTextMsg(actuallinkmsg, "Actual", expectedM);

		//Driver.driver.quit();
	}

	// 5th Test case ValidateLoginErrorMessage
	public static void ValidateLoginErrorMessage() throws Throwable{
		//Driver.driver = new FirefoxDriver();

		Driver.driver.get("https://login.salesforce.com/");

		WebElement userName = Driver.driver.findElement(By.id("username"));
		enterText(userName, "123", "UserName");

		WebElement pwd = Driver.driver.findElement(By.id("password"));
		enterText(pwd, "22131", "password");

		WebElement salesForceLoginButton = Driver.driver.findElement(By.id("Login"));
		clickButton(salesForceLoginButton, "Login Button");

		Thread.sleep(3000);
		WebElement actualErrorMsg = Driver.driver.findElement(By.id("error"));

		String expectedErrorMsg = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";

		validateTextMsg(actualErrorMsg, " Actual message" , expectedErrorMsg);

	}

	// 6th Test case selectUserMenu
	public static void selectUserMenu() throws Throwable{
		
		Driver.driver.get("https://login.salesforce.com/");

		Driver.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		SFDCLogin(Driver.driver, "sonalitjadhav@gmail.com", "Sonali123");
		Thread.sleep(3000);
		WebElement userProfileButton = Driver.driver.findElement(By.id("userNavButton"));
		clickButton(userProfileButton, "User profile dropdown");
		
		Thread.sleep(10000);
		List<WebElement> usermenuitems = Driver.driver.findElement(By.xpath("html/body/div[1]/div[1]/table/tbody/tr/td[3]/div/div[2]/div/div/div[2]/div[3]")).findElements(By.tagName("a"));
		validateTextMsg(usermenuitems.get(0), "My Profile Link", "My Profile");
		validateTextMsg(usermenuitems.get(1), "My Settings Link", "My Settings");
		validateTextMsg(usermenuitems.get(2), "Developer Console Link", "Developer Console");
		validateTextMsg(usermenuitems.get(3), "Switch to Lightning Experience Link", "Switch to Lightning Experience");
		validateTextMsg(usermenuitems.get(4), "Logout Link", "Logout");
		
		Driver.driver.quit();

	}
	//7th Test case selectMyProfileOption
	public static void selectMyProfileOption() throws Throwable{
		Driver.driver = new FirefoxDriver();
		Driver.driver.manage().window().maximize();
		Driver.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver.driver.get("https://login.salesforce.com/");
		
		SFDCLogin(Driver.driver, "sonalitjadhav@gmail.com", "Sonali123");
		WebElement userProfileButton = Driver.driver.findElement(By.id("userNavButton"));
		//validateTextMsg(userProfileButton, "Actual Message", "Sonali J");
		clickButton(userProfileButton, "User profile dropdown");
		
		WebElement myProfile = Driver.driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[1]"));
		clickButton(myProfile, "My Profile link");
		
		WebElement editContact = Driver.driver.findElement(By.xpath(".//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		clickButton(editContact, "Edit contact");
		
		Thread.sleep(3000);
		
		Driver.driver.switchTo().frame("contactInfoContentId");
		Driver.driver.findElement(By.xpath(".//*[@id='aboutTab']/a")).click();;
		//clickButton(aboutTab, "About tab");
		System.out.println("about tab clicked");

		WebElement lastName = Driver. driver.findElement(By.xpath(".//*[@id='lastName']"));
		lastName.clear();
		//lastName.sendKeys("Jadhav");
		enterText(lastName, "Jadhav", "LastName");
		//System.out.println("Name changed");

		WebElement saveAll = Driver.driver.findElement(By.xpath(".//*[@id='TabPanel']/div/div[2]/form/div/input[1]"));
		clickButton(saveAll, "Save all button");
		//System.out.println("Save all button clicked");
		Thread.sleep(5000);

		Driver.driver.switchTo().defaultContent();

		WebElement postLink = Driver.driver.findElement(By.linkText("Post"));
		clickButton(postLink, "Post Link");
		System.out.println("Post link clicked");
		Thread.sleep(10000);
		
		Driver.driver.quit();
	}
	//8th Test cases selectDevloperConsole
	public static void selectDeveloperConsole() throws Throwable{
		
		Driver.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver.driver.get("https://login.salesforce.com/");
		WebElement userName = Driver.driver.findElement(By.id("username"));
		enterText(userName, "sonalitjadhav@gmail.com", "UserName");

		Driver.driver.findElement(By.id("password")).sendKeys("Sonali123");;
		//enterText(pwd, "Sonali123", "Password");
		
		WebElement salesForceLoginButton = Driver.driver.findElement(By.id("Login"));
		clickButton(salesForceLoginButton, "Login");
		
		Thread.sleep(5000);
		WebElement userProfileButton = Driver.driver.findElement(By.id("userNavButton"));
		
		clickButton(userProfileButton, "User profile dropdown");
		
		WebElement devloperConsole =  Driver.driver.findElement(By.linkText("Developer Console"));
		clickButton(devloperConsole, "Devloper Console Button");
		
		Driver.driver.close();
		
	}
	//9th Test Case select logout option
	public static void selectLogoutOption() throws Throwable{
		
		Driver.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver.driver.get("https://login.salesforce.com/");
		WebElement userName = Driver.driver.findElement(By.id("username"));
		enterText(userName, "sonalitjadhav@gmail.com", "UserName");

		WebElement pwd = Driver.driver.findElement(By.id("password"));
		enterText(pwd, "Sonali123", "Password");
		
		WebElement salesForceLoginButton = Driver.driver.findElement(By.id("Login"));
		clickButton(salesForceLoginButton, "Login");
		
		Thread.sleep(5000);
		WebElement userProfileButton = Driver.driver.findElement(By.id("userNavButton"));
		
		clickButton(userProfileButton, "User profile dropdown");
		
		WebElement logOut =  Driver.driver.findElement(By.linkText("Logout"));
		clickButton(logOut, "Log Out Button");
		
		Driver.driver.close();
		
	}
	//10th Test case createNewAccount
	public static void createNewAccount() throws Throwable{
		
		Driver.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//login URL
		Driver.driver.get("https://login.salesforce.com/");
		
		//enter username
		WebElement userName = Driver.driver.findElement(By.id("username"));
		enterText(userName, "sonalitjadhav@gmail.com", "UserName");
		
		//enter password
		WebElement pwd = Driver.driver.findElement(By.id("password"));
		enterText(pwd, "Sonali123", "Password");
		
		//click login button
		WebElement salesForceLoginButton = Driver.driver.findElement(By.id("Login"));
		clickButton(salesForceLoginButton, "Login");
		
		Thread.sleep(5000);
		
		//click on account tab
		WebElement accounts =  Driver.driver.findElement(By.linkText("Accounts"));
		clickButton(accounts, "Account link");
		
		//click new button
		WebElement newButton =  Driver.driver.findElement(By.name("new"));
		clickButton(newButton, "New Button ");
		
		//enter account number
		WebElement accNumber = Driver.driver.findElement(By.id("acc2"));
		enterText(accNumber, "12345", "New account name");
		
		//save button
		WebElement saveButton = Driver.driver.findElement(By.name("save"));
		clickButton(saveButton, "Save button");
		
		Thread.sleep(3000);
		//validate account number
		WebElement AccTitle = Driver.driver.findElement(By.xpath(".//*[@id='contactHeaderRow']/div[2]/h2"));
		validateTextMsg(AccTitle, "Account number display", "12345");
		
	}
	// 11th Test case createNewView
	public static void createNewView() throws Throwable{
		
		Driver.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//login URL
		Driver.driver.get("https://login.salesforce.com/");
		
		//enter userName
		WebElement userName = Driver.driver.findElement(By.id("username"));
		enterText(userName, "sonalitjadhav@gmail.com", "UserName");

		//enter password
		WebElement pwd = Driver.driver.findElement(By.id("password"));
		enterText(pwd, "Sonali123", "Password");
		
		//click login
		WebElement salesForceLoginButton = Driver.driver.findElement(By.id("Login"));
		clickButton(salesForceLoginButton, "Login");
		
		Thread.sleep(5000);
		//click on account tab
		WebElement accounts =  Driver.driver.findElement(By.linkText("Accounts"));
		clickButton(accounts, "Account link");
		
		//click on create new view button
		WebElement createNew =  Driver.driver.findElement(By.linkText("Create New View"));
		clickButton(createNew, "Create New Button");
		
		//Enter view name
		WebElement viewName = Driver.driver.findElement(By.id("fname"));
		enterText(viewName, "Sonali", "View Name");
		
		//Enter Unique name
		WebElement uniqueName = Driver.driver.findElement(By.id("devname"));
		clickButton(uniqueName, "Unique name textbox");
		
		//click on save
		WebElement save = Driver.driver.findElement(By.name("save"));
		clickButton(save, "Save Button");
		
		//verify that new view is displayed
		//WebElement ViewTitle = Driver.driver.findElement(By.id("is:islv:inlineSchedulerListView:enhancedList_listSelect"));
		//validateTextMsg(ViewTitle, "View Diplayed", "Sonali");
	}
	
	// 12th Test case
		public static void editView() throws Throwable{
			//Enter URL
			Driver.driver.get("https://login.salesforce.com/");
			
			Driver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			//enter userName 
			WebElement usernameBox = Driver.driver.findElement(By.id("username"));
			enterText(usernameBox,"sonalitjadhav@gmail.com","UserName TextBox");

			//enter password
			WebElement passwordBox = Driver.driver.findElement(By.id("password"));
			enterText(passwordBox,"Sonali123","Password Textbox");

			//click login
			WebElement login = Driver.driver.findElement(By.id("Login"));
			clickButton(login, "Login Button");

			//check for account tab
			WebElement accountTab = Driver.driver.findElement(By.id("Account_Tab"));

			if(accountTab.isDisplayed()){
				//System.out.println("Pass: Home page is displayed");
				Update_Report("Pass", "editViewName", "Home page is displayed");
			}
			else{
				//System.out.println("Fail: Login page is not displayed");
				Update_Report("Fail", "editViewName", "Home page is not displayed");
			}
			Thread.sleep(3000);

			//Verify the username
			WebElement displayName = Driver.driver.findElement(By.xpath(".//*[@id='ptBody']/div/div/span[1]/h1"));
			
			//click on Accounts
			clickButton(accountTab, "Account tab");

			Thread.sleep(3000);				
			
			//select a Sonali from the dropdown
			WebElement viewdropdown = Driver.driver.findElement(By.id("fcf"));
			
			Select dplist = new Select(viewdropdown);
			dplist.selectByVisibleText("Sonali");
			
			//Click on Edit
			WebElement EditViewLink = Driver.driver.findElement(By.linkText("Edit"));
			clickButton(EditViewLink, "Edit View link");
			
			//Verify page title
			String EditViewTitle = Driver.driver.getTitle();
			
			if (EditViewTitle.equals("Accounts: Edit View ~ Salesforce - Professional Edition")){
				//System.out.println("Page title '"+EditViewTitle+"' is displayed correctly");	
				Update_Report("Pass", "editViewName", "Page title "+EditViewTitle+" is displayed correctly");
			}
			else {
				//System.out.println("Page title '"+EditViewTitle+"' is displayed incorrectly");	
				Update_Report("Fail", "editViewName", "Page title "+EditViewTitle+" is displayed incorrectly");
			}
			
			
			//Enter New View Name
			WebElement viewnameBox = Driver.driver.findElement(By.id("fname"));
			viewnameBox.clear();
			enterText(viewnameBox, "Sonali", "View name textbox");
			
			//Enter View Unique Name
			WebElement viewuniqnameBox = Driver.driver.findElement(By.id("devname"));
			viewuniqnameBox.clear();
			enterText(viewuniqnameBox, "Sonali", "View Unique name textbox");

			//select Last activity column
			WebElement availableFieldDropdown = Driver.driver.findElement(By.id("fcol1"));
			
			Select dplist1 = new Select(availableFieldDropdown);
			dplist1.selectByValue("ACCOUNT.LAST_ACTIVITY");
			
			//Click add button
			WebElement addFieldButton = Driver.driver.findElement(By.id("bool_filter_toggle"));
			clickButton(addFieldButton, "Add Field Button");
			
			//click on Save
			WebElement SaveViewButton = Driver.driver.findElement(By.xpath(".//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[1]"));
			clickButton(SaveViewButton, "Save View Button");

			Thread.sleep(3000);

						
			//verify that new view is displayed
			//WebElement ViewTitle = Driver.driver.findElement(By.id("is:islv:inlineSchedulerListView:enhancedList_listSelect"));
			//validateTextMsg(ViewTitle, "View Diplayed", "Sonali");
		}
		
		// 13th Test case mergeAccount
				public static void mergeAccount() throws Throwable{
					//Enter URL
					Driver.driver.get("https://login.salesforce.com/");
					
					Driver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//enter userName 
					WebElement usernameBox = Driver.driver.findElement(By.id("username"));
					enterText(usernameBox,"sonalitjadhav@gmail.com","UserName TextBox");

					//enter password
					WebElement passwordBox = Driver.driver.findElement(By.id("password"));
					enterText(passwordBox,"Sonali123","Password Textbox");

					//click login
					WebElement login = Driver.driver.findElement(By.id("Login"));
					clickButton(login, "Login Button");

					//check for account tab
					WebElement accountTab = Driver.driver.findElement(By.id("Account_Tab"));

					if(accountTab.isDisplayed()){
						System.out.println("Pass: Home page is displayed");
						Update_Report("Pass", "editViewName", "Home page is displayed");
					}
					else{
						System.out.println("Fail: Login page is not displayed");
						Update_Report("Fail", "editViewName", "Home page is not displayed");
					}
					Thread.sleep(3000);

					//click on Accounts
					clickButton(accountTab, "Account tab");

					Thread.sleep(3000);				
					
					//click on merge account
					WebElement mergeAccount = Driver.driver.findElement(By.linkText("Merge Accounts"));
					clickButton(mergeAccount, "Merge account link ");
					
					//account name is enter in search box 
					WebElement searchText = Driver.driver.findElement(By.xpath(".//*[@id='srch']"));
					enterText(searchText, "1", "Search account");
					
					//find account button click
					WebElement findAccount = Driver.driver.findElement(By.xpath(".//*[@id='stageForm']/div/div[2]/div[4]/input[2]"));
					clickButton(findAccount, "Find account button");
					
					//account 1 is clicked
					WebElement acc1 = Driver.driver.findElement(By.xpath(".//*[@id='cid0']"));
					chkBox(acc1, "Account 1");
					
					//account 2 is clicked
					WebElement acc2 = Driver.driver.findElement(By.xpath(".//*[@id='cid1']"));
					chkBox(acc2, "Account 2");
					
					//next button click
					WebElement nextButton = Driver.driver.findElement(By.name("goNext"));
					clickButton(nextButton, "Next Button");
					
					//validate merge my account text is present.
					WebElement mergeMyAcc = Driver.driver.findElement(By.xpath(".//*[@id='bodyCell']/div/div[1]/div[1]/h1"));
					validateTextMsg(mergeMyAcc, "Mearge my account displayed  ", "Merge My Accounts");
					
					//click on mearge button
					WebElement mergeButton = Driver.driver.findElement(By.xpath(".//*[@id='stageForm']/div/div[2]/div[5]/div/input[2]"));
					clickButton(mergeButton, "Merge Button");
					
					//accept alert
					Alert alt = Driver.driver.switchTo().alert();
					alt.accept();
					
					//WebElement recentlyViewed = Driver.driver.findElement(By.xpath(".//*[@id='hotlist_mode']"));
					//validateTextMsg(recentlyViewed, "Recently viewed", "Recently viewed");;
										
				}
				
				// 14th Test case createAccountReport
				public static void createAccountReport() throws Throwable{
					//Enter URL
					Driver.driver.get("https://login.salesforce.com/");
					
					Driver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//enter userName 
					WebElement usernameBox = Driver.driver.findElement(By.id("username"));
					enterText(usernameBox,"sonalitjadhav@gmail.com","UserName TextBox");

					//enter password
					WebElement passwordBox = Driver.driver.findElement(By.id("password"));
					enterText(passwordBox,"Sonali123","Password Textbox");

					//click login
					WebElement login = Driver.driver.findElement(By.id("Login"));
					clickButton(login, "Login Button");

					//check for account tab
					WebElement accountTab = Driver.driver.findElement(By.id("Account_Tab"));

					if(accountTab.isDisplayed()){
						System.out.println("Pass: Home page is displayed");
						Update_Report("Pass", "editViewName", "Home page is displayed");
					}
					else{
						System.out.println("Fail: Login page is not displayed");
						Update_Report("Fail", "editViewName", "Home page is not displayed");
					}
					Thread.sleep(3000);

					//click on Accounts
					clickButton(accountTab, "Account tab");

					Thread.sleep(3000);				
					
					//click on account with last activity > 30 days link
					WebElement accLastActivityObj = Driver.driver.findElement(By.linkText("Accounts with last activity > 30 days"));
					clickButton(accLastActivityObj, "Account with last activity link ");
					
					Thread.sleep(5000);
					
					//click on date field tab 
					WebElement dateFieldObj = Driver.driver.findElement(By.xpath(".//*[@id='ext-gen20']"));
					clickButton(dateFieldObj, "Date Field tab");
					
					Thread.sleep(5000);
					//Created date select
					//WebElement createdDate = Driver.driver.findElement(By.xpath(".//*[@id='ext-gen241']/div[3]"));
					//clickButton(createdDate, "Created date");
					
					//Select dropdown = new Select(dateFieldObj);
					//dropdown.selectByVisibleText("Created Date");
					
					//From button click
					WebElement fromObj = Driver.driver.findElement(By.xpath(".//*[@id='ext-gen152']"));
					clickButton(fromObj, "From ");
					
					//Today button click
					WebElement todayFromObj = Driver.driver.findElement(By.xpath(".//*[@id='ext-comp-1112']"));
					clickButton(todayFromObj, "Today ");
					
					//To button click
					WebElement toObj = Driver.driver.findElement(By.xpath(".//*[@id='ext-gen154']"));
					clickButton(toObj, "To");
					
					//Today's date selected in TO.
					WebElement todayToObj = Driver.driver.findElement(By.xpath(".//*[@id='ext-comp-1114']"));
					clickButton(todayToObj, "Today ");
					
					//click on saveButton
					WebElement saveButton = Driver.driver.findElement(By.xpath(".//*[@id='saveReportBtn']/tbody/tr[2]/td[2]/em"));
					clickButton(saveButton, "Save Button");
					
					WebElement reportName = Driver.driver.findElement(By.xpath(".//*[@id='saveReportDlg_reportNameField']"));
					enterText(reportName, "My activity", "Report Name");
					
					WebElement reportUniqueName = Driver.driver.findElement(By.xpath(".//*[@id='saveReportDlg_DeveloperName']"));
					clickButton(reportUniqueName, "Report unique name");
					
					WebElement saveAndRunReport = Driver.driver.findElement(By.xpath(".//*[@id='dlgSaveAndRun']"));
					clickButton(saveAndRunReport, "Save and Run report");
						
					//WebElement reportNameDisplay = Driver.driver.findElement(By.xpath(".//*[@id='noTableContainer']/div/div[1]/div[1]/div[1]/h1"));
					//validateTextMsg(reportNameDisplay, "My activity", "My activity");;
				}
				
				// 15th Test case userMenuDropdown
				public static void userMenuDropdown() throws Throwable{
					//Enter URL
					Driver.driver.get("https://login.salesforce.com/");
					
					Driver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//enter userName 
					WebElement usernameBox = Driver.driver.findElement(By.id("username"));
					enterText(usernameBox,"sonalitjadhav@gmail.com","UserName TextBox");

					//enter password
					WebElement passwordBox = Driver.driver.findElement(By.id("password"));
					enterText(passwordBox,"Sonali123","Password Textbox");

					//click login
					WebElement login = Driver.driver.findElement(By.id("Login"));
					clickButton(login, "Login Button");

					//check for account tab
					WebElement opportunitiesTab = Driver.driver.findElement(By.linkText("Opportunities"));

					if(opportunitiesTab.isDisplayed()){
						System.out.println("Pass: Home page is displayed");
						Update_Report("Pass", "editViewName", "Home page is displayed");
					}
					else{
						System.out.println("Fail: Login page is not displayed");
						Update_Report("Fail", "editViewName", "Home page is not displayed");
					}
					Thread.sleep(3000);

					//click on Accounts
					clickButton(opportunitiesTab, "Opportunities tab");

					Thread.sleep(3000);				
					
					//validation opportunity home page
					WebElement opportunitiesText = Driver.driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h1"));
					validateTextMsg(opportunitiesText,"Actual message", "Opportunities");
					
					//display dropdown options
					List<WebElement> options = Driver.driver.findElements(By.xpath(".//*[@id='fcf']/option"));
					for (int i = 0; i < options.size(); i++) {
						System.out.println(options.get(i).getText());
					}
										
				}
				
				// 16th Test case testOpportunityPipelineReport
				public static void testOpportunityPipelineReport() throws Throwable{
					//Enter URL
					Driver.driver.get("https://login.salesforce.com/");
					
					Driver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//enter userName 
					WebElement usernameBox = Driver.driver.findElement(By.id("username"));
					enterText(usernameBox,"sonalitjadhav@gmail.com","UserName TextBox");

					//enter password
					WebElement passwordBox = Driver.driver.findElement(By.id("password"));
					enterText(passwordBox,"Sonali123","Password Textbox");

					//click login
					WebElement login = Driver.driver.findElement(By.id("Login"));
					clickButton(login, "Login Button");

					//check for account tab
					WebElement opportunitiesTab = Driver.driver.findElement(By.linkText("Opportunities"));

					if(opportunitiesTab.isDisplayed()){
						System.out.println("Pass: Home page is displayed");
						Update_Report("Pass", "editViewName", "Home page is displayed");
					}
					else{
						System.out.println("Fail: Login page is not displayed");
						Update_Report("Fail", "editViewName", "Home page is not displayed");
					}
					Thread.sleep(3000);

					//click on Accounts
					clickButton(opportunitiesTab, "Opportunities tab");

					Thread.sleep(3000);				
					
					//validation opportunity home page
					WebElement opportunitiesText = Driver.driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h1"));
					validateTextMsg(opportunitiesText,"Actual message", "Opportunities");
					
					WebElement opportunityPipelineObj = Driver.driver.findElement(By.linkText("Opportunity Pipeline"));
					clickButton(opportunityPipelineObj, "Opportunity pipelinev link");
					
					WebElement opportunityPipelineText = Driver.driver.findElement(By.xpath(".//*[@id='noTableContainer']/div/div[1]/div[1]/div[1]/h1"));
					validateTextMsg(opportunityPipelineText,"Actual message", "Opportunity Pipeline");
									
				}
				
				// 17th Test case createNewOpty
				public static void createNewOpty() throws Throwable{
					//Enter URL
					Driver.driver.get("https://login.salesforce.com/");
					
					Driver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//enter userName 
					WebElement usernameBox = Driver.driver.findElement(By.id("username"));
					enterText(usernameBox,"sonalitjadhav@gmail.com","UserName TextBox");

					//enter password
					WebElement passwordBox = Driver.driver.findElement(By.id("password"));
					enterText(passwordBox,"Sonali123","Password Textbox");

					//click login
					WebElement login = Driver.driver.findElement(By.id("Login"));
					clickButton(login, "Login Button");

					//check for account tab
					WebElement opportunitiesTab = Driver.driver.findElement(By.linkText("Opportunities"));

					if(opportunitiesTab.isDisplayed()){
						System.out.println("Pass: Home page is displayed");
						Update_Report("Pass", "editViewName", "Home page is displayed");
					}
					else{
						System.out.println("Fail: Login page is not displayed");
						Update_Report("Fail", "editViewName", "Home page is not displayed");
					}
					Thread.sleep(3000);

					//click on Accounts
					clickButton(opportunitiesTab, "Opportunities tab");

					Thread.sleep(3000);				
					
					//validation opportunity home page
					WebElement opportunitiesText = Driver.driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h1"));
					validateTextMsg(opportunitiesText,"Actual message", "Opportunities");
					
					//click new button
					WebElement newObj = Driver.driver.findElement(By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input"));
					clickButton(newObj, "New Button");
					
					// enter opportunity name
					WebElement optyNameObj = Driver.driver.findElement(By.xpath(".//*[@id='opp3']"));
					enterText(optyNameObj, "Apple", "Opportunity");
					
					//enter account name
					WebElement accNameObj = Driver.driver.findElement(By.xpath(".//*[@id='opp4']"));
					enterText(accNameObj, "Sonali", "Account name");
					
					// enter close date
					WebElement closeDateObj = Driver.driver.findElement(By.xpath(".//*[@id='ep']/div[2]/div[3]/table/tbody/tr[2]/td[4]/div/span/span/a"));
					clickButton(closeDateObj, "Close Date Button");
					
					// enter stage
					WebElement stageObj = Driver.driver.findElement(By.xpath(".//*[@id='opp11']"));
					Select sl = new Select(stageObj);
					sl.selectByVisibleText("Closed Lost");
					
					//enter probability
					WebElement probabilityObj = Driver.driver.findElement(By.xpath(".//*[@id='opp12']"));
					enterText(probabilityObj, "90", "Probability");
					
					//click save button
					WebElement saveButtonObj = Driver.driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]"));
					clickButton(saveButtonObj, "Save Button");
					
					//validate opportunity name
					WebElement opportunityName = Driver.driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2"));
					validateTextMsg(opportunityName,"Opportunity is sucessfully created", "Apple");
									
				}
				
				// 18th Test case testStuckOptyReport
				public static void testStuckOptyReport() throws Throwable{
					//Enter URL
					Driver.driver.get("https://login.salesforce.com/");
					
					Driver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//enter userName 
					WebElement usernameBox = Driver.driver.findElement(By.id("username"));
					enterText(usernameBox,"sonalitjadhav@gmail.com","UserName TextBox");

					//enter password
					WebElement passwordBox = Driver.driver.findElement(By.id("password"));
					enterText(passwordBox,"Sonali123","Password Textbox");

					//click login
					WebElement login = Driver.driver.findElement(By.id("Login"));
					clickButton(login, "Login Button");

					//check for account tab
					WebElement opportunitiesTab = Driver.driver.findElement(By.linkText("Opportunities"));

					if(opportunitiesTab.isDisplayed()){
						System.out.println("Pass: Home page is displayed");
						Update_Report("Pass", "editViewName", "Home page is displayed");
					}
					else{
						System.out.println("Fail: Login page is not displayed");
						Update_Report("Fail", "editViewName", "Home page is not displayed");
					}
					Thread.sleep(3000);

					//click on Accounts
					clickButton(opportunitiesTab, "Opportunities tab");

					Thread.sleep(3000);				
					
					//validation opportunity home page
					WebElement opportunitiesText = Driver.driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h1"));
					validateTextMsg(opportunitiesText,"Actual message", "Opportunities");
					
					//click new button
					WebElement stuckOptyObj = Driver.driver.findElement(By.linkText("Stuck Opportunities"));
					clickButton(stuckOptyObj, "Stuck opportunity link");
					
					//validate opportunity name
					WebElement stuckOptyText = Driver.driver.findElement(By.xpath(".//*[@id='noTableContainer']/div/div[1]/div[1]/div[1]/h1"));
					validateTextMsg(stuckOptyText,"Stuck opportunity home page display succesfully", "Stuck Opportunities");
									
				}
				
				// 19th Test case testquarterlySummaryReport
				public static void testquarterlySummaryReport() throws Throwable{
					//Enter URL
					Driver.driver.get("https://login.salesforce.com/");
					
					Driver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//enter userName 
					WebElement usernameBox = Driver.driver.findElement(By.id("username"));
					enterText(usernameBox,"sonalitjadhav@gmail.com","UserName TextBox");

					//enter password
					WebElement passwordBox = Driver.driver.findElement(By.id("password"));
					enterText(passwordBox,"Sonali123","Password Textbox");

					//click login
					WebElement login = Driver.driver.findElement(By.id("Login"));
					clickButton(login, "Login Button");

					//check for account tab
					WebElement opportunitiesTab = Driver.driver.findElement(By.linkText("Opportunities"));

					if(opportunitiesTab.isDisplayed()){
						System.out.println("Pass: Home page is displayed");
						Update_Report("Pass", "editViewName", "Home page is displayed");
					}
					else{
						System.out.println("Fail: Login page is not displayed");
						Update_Report("Fail", "editViewName", "Home page is not displayed");
					}
					Thread.sleep(3000);

					//click on Accounts
					clickButton(opportunitiesTab, "Opportunities tab");

					Thread.sleep(3000);				
					
					//validation opportunity home page
					WebElement opportunitiesText = Driver.driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h1"));
					validateTextMsg(opportunitiesText,"Actual message", "Opportunities");
					
					//select interval Quarterly summary
					WebElement intervalObj = Driver.driver.findElement(By.xpath(".//*[@id='quarter_q']"));
					Select sl = new Select(intervalObj);
					sl.selectByVisibleText("Current and Next FQ");
					
					//select include Quarterly summary
					WebElement includeObj = Driver.driver.findElement(By.xpath(".//*[@id='open']"));
					Select sl2 = new Select(includeObj);
					sl2.selectByVisibleText("Closed/Won Opportunities");
					
					//click new button
					WebElement runReportObj = Driver.driver.findElement(By.xpath(".//*[@id='lead_summary']/table/tbody/tr[3]/td/input"));
					clickButton(runReportObj, "Run Report button");
					
					//validate opportunity name
					WebElement reportObj = Driver.driver.findElement(By.xpath(".//*[@id='noTableContainer']/div/div[1]/div[1]/div[1]/h1"));
					validateTextMsg(reportObj,"Opportunity Report page display succesfully", "Opportunity Report");
									
				}
				
				// 20th Test case checkLeadsTabLink
				public static void checkLeadsTabLink() throws Throwable{
					//Enter URL
					Driver.driver.get("https://login.salesforce.com/");
					
					Driver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//enter userName 
					WebElement usernameBox = Driver.driver.findElement(By.id("username"));
					enterText(usernameBox,"sonalitjadhav@gmail.com","UserName TextBox");

					//enter password
					WebElement passwordBox = Driver.driver.findElement(By.id("password"));
					enterText(passwordBox,"Sonali123","Password Textbox");

					//click login
					WebElement login = Driver.driver.findElement(By.id("Login"));
					clickButton(login, "Login Button");

					//check for Leads Tab link
					WebElement leadsLink = Driver.driver.findElement(By.xpath(".//*[@id='Lead_Tab']"));

					if(leadsLink.isDisplayed()){
						//System.out.println("Pass: Home page is displayed");
						Update_Report("Pass", "editViewName", "Home page is displayed");
					}
					else{
						//System.out.println("Fail: Login page is not displayed");
						Update_Report("Fail", "editViewName", "Home page is not displayed");
					}
					Thread.sleep(3000);

					//click on Leads tab link
					clickButton(leadsLink, "Leads tab link");

					Thread.sleep(3000);			
					
					//validate Leads home page
					WebElement leadsObjText = Driver.driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h1"));
					validateTextMsg(leadsObjText,"Leads home page display succesfully", "Leads");
									
				}
				
				// 21th Test case checkLeadsTabLink
				public static void leadsSelectView() throws Throwable{
					//Enter URL
					Driver.driver.get("https://login.salesforce.com/");
					
					Driver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//enter userName 
					WebElement usernameBox = Driver.driver.findElement(By.id("username"));
					enterText(usernameBox,"sonalitjadhav@gmail.com","UserName TextBox");

					//enter password
					WebElement passwordBox = Driver.driver.findElement(By.id("password"));
					enterText(passwordBox,"Sonali123","Password Textbox");

					//click login
					WebElement login = Driver.driver.findElement(By.id("Login"));
					clickButton(login, "Login Button");

					//check for Leads Tab link
					WebElement leadsLink = Driver.driver.findElement(By.xpath(".//*[@id='Lead_Tab']"));

					if(leadsLink.isDisplayed()){
						//System.out.println("Pass: Home page is displayed");
						Update_Report("Pass", "editViewName", "Home page is displayed");
					}
					else{
						//System.out.println("Fail: Login page is not displayed");
						Update_Report("Fail", "editViewName", "Home page is not displayed");
					}
					Thread.sleep(3000);

					//click on Leads tab link
					clickButton(leadsLink, "Leads tab link");

					Thread.sleep(3000);			
					
					//validate Leads home page
					WebElement leadsObjText = Driver.driver.findElement(By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h1"));
					validateTextMsg(leadsObjText,"Leads home page display succesfully", "Leads");
					
					//display dropdown options
					List<WebElement> options = Driver.driver.findElements(By.xpath(".//*[@id='fcf']/option"));
					for (int i = 0; i < options.size(); i++) {
						System.out.println(options.get(i).getText());
					}
					
				}
}

