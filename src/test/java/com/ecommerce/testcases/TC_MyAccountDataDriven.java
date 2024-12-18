package com.ecommerce.testcases;

import com.ecommerce.pageobject.AccountCreation;
import com.ecommerce.pageobject.IndexPage;
import com.ecommerce.pageobject.MyAccount;
import com.ecommerce.pageobject.RegisteredUserAccount;
import com.ecommerce.utilities.ReadExcelFile;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_MyAccountDataDriven extends BaseClass{
    @Test(enabled = false)
    public void verifyRegistrationandLogin(){
        //Open URL
//        driver.get(url);// This is common for all the test cases hence shifted to base class, this is defined in base class
//        logger.info("URL opened");

        // Sign in to the page click on Sign in, which is defined in IndexPage class
        IndexPage indexPg = new IndexPage(driver);
        indexPg.clickOnSignIn();
        logger.info("Clicked on Sigin");

        // create an object of myAccount class for the page and enter emailaddress to
        // create an account
        MyAccount myAcc = new MyAccount(driver);
        myAcc.enterEmailAddress("Olz001@ayn.com");
        logger.info("Entered email address");

        // click on Create and Account button
        myAcc.clickOnSubmitCreate();
        logger.info("Clicked on Submitcreate button");

        //Enter personal details of the user
        //-----------------------------------
        AccountCreation accountCreation = new AccountCreation(driver);

        accountCreation.selectTitle();
        logger.info("Mr. title selected");

        accountCreation.enterFirstname("Ajay");
        logger.info("First name entered");

        accountCreation.enterLastname("Puri");
        logger.info("Last name entered");

        accountCreation.enterPassword("123456");
        logger.info("Password entered");

        accountCreation.clickOnRegister();
        logger.info("Clicked on Register button");
    }
    //Verify Login user
    @Test(dataProvider = "LoginDataProvider")
    public void verifyLogin(String userEmail, String userPwd, String expectedUserName) throws IOException {
        logger.info("Verify registered user is able to login");

        IndexPage indexPg = new IndexPage(driver);
        indexPg.clickOnSignIn();
        logger.info("Clicked on Sigin");

        // create an object of myAccount class for the page
        MyAccount myAcc = new MyAccount(driver);
        myAcc.registeredEmailAddress(userEmail);
        logger.info("Entered registered email address");
        myAcc.registeredPassword(userPwd);
        logger.info("Entered registered password");
        myAcc.clickOnSubmitLogin();
        logger.info("Clicked on submit button");

        // --confirm message is displayed
//        confirmAccountEcommerce cAccount = new confirmAccountEcommerce(driver);
//        String messageDisplayed = cAccount.messageDisplayed();
//        if (messageDisplayed.equals("Welcome to your account. Here you can manage all of your personal information and orders.")) {
//            logger.info("Verified New Account created");
//            Assert.assertTrue(true);
//        } else {
//            logger.info("Verified New Account not created");
//            captureScreenShot(driver, "verifyLogin");
//            Assert.assertTrue(false);
//        }
        //Verify Username
        RegisteredUserAccount userAccount = new RegisteredUserAccount(driver);
        String userName = userAccount.getUserName();
//        Assert.assertEquals(userName, "Jyotipal Hira");
//        logger.info("Username verification");
        if (userName.equalsIgnoreCase(expectedUserName)){
            logger.info("Verify Login passed");
            captureScreenShot(driver, "verifyLogin");
            Assert.assertTrue(true);
        }else {
            logger.info("Verify login failed");
            captureScreenShot(driver, "verifyLogin");
            Assert.assertTrue(false);
        }
        userAccount.clickOnSignOut();
    }
    //give a dataprovider method which is two dimensional object
    @DataProvider(name = "LoginDataProvider")
    public String[][] LoginDataProvider(){
        //The file which stores the data
        String fileName = System.getProperty("user.dir") + "\\TestData\\EcomTestData.xlsx";

        //Because all methods declared in ReadExcelFile are static hence object is not created, these
        //can be accessed directly by using class name
        int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
        int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");

        String data[][] = new String[ttlRows - 1][ttlColumns];
        for (int i = 1; i < ttlRows; i++){ //rows = 1,2
            for (int j = 0; j < ttlColumns; j++){ //cols = 0,1,2
                data[i-1][j] = ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
            }
        }
        return data;

    }

}
