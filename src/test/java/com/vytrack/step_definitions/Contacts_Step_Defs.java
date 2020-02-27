package com.vytrack.step_definitions;

import com.vytrack.pages.ContactInfoPage;
import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.DBUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contacts_Step_Defs {
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();
    WebDriver driver= Driver.get();
    ContactsPage contactsPage=new ContactsPage();
    ContactInfoPage contactInfoPage=new ContactInfoPage();

    @Given("the user logged in as a {string}")
    public void theUserLoggedInAsA(String user) {
        driver.get(ConfigurationReader.get("url"));
        if(user.equals("driver")){
            loginPage.userName.sendKeys(ConfigurationReader.get("driver_username"));
            loginPage.password.sendKeys(ConfigurationReader.get("driver_password"));
            loginPage.submit.click();
        }else if(user.equals("sales manager")){
            loginPage.userName.sendKeys(ConfigurationReader.get("sales_manager_username"));
            loginPage.password.sendKeys(ConfigurationReader.get("sales_manager_password"));
            loginPage.submit.click();

        }else if(user.equals("store manager")){
            loginPage.userName.sendKeys(ConfigurationReader.get("store_manager_username"));
            loginPage.password.sendKeys(ConfigurationReader.get("store_manager_password"));
            loginPage.submit.click();

        }

    }

    @Then("the user should see following menu options")
    public void theUserShouldSeeFollowingMenuOptions(List<String> menu) {
        System.out.println("menu.size() = " + menu.size());
        System.out.println("menu = " + menu);

        BrowserUtils.waitFor(2);
        List<String> actualMenu= BrowserUtils.getElementsText(dashboardPage.menuOptions);
        assertEquals(actualMenu,menu);



    }

    @When("the use logs in using following credentials")
    public void theUseLogsInUsingFollowingCredentials(Map<String, String> users) {
        loginPage.userName.sendKeys(users.get("username"));
        loginPage.password.sendKeys(users.get("password"));
        loginPage.submit.click();
        BrowserUtils.waitFor(2);
        String actual=dashboardPage.userName.getText();
        String expected=users.get("firstname")+" "+users.get("lastname");
        assertEquals(expected,actual);






    }

    @When("the user click the {string} from contacts")
    public void theUserClickTheFromContacts(String email) {
        BrowserUtils.waitFor(4);
        contactsPage.getContactEmail(email).click();
    }

    @Then("the information should be the same with database")
    public void theInformationShouldBeTheSameWithDatabase() {
        BrowserUtils.waitFor(6);
        System.out.println("contactInfoPage.email.getText() = " + contactInfoPage.email.getText());
        String actualFullname=contactInfoPage.contactFullName.getText();
        String actualPhone=contactInfoPage.phone.getText();
        String actualEmail=contactInfoPage.email.getText();

        String query = "select concat(name_prefix,' ',first_name,' ',last_name) as fullname, e.email, phone\n" +
                "from orocrm_contact crm JOIN orocrm_contact_email e\n" +
                "on crm.id = e.owner_id\n" +
                "join orocrm_contact_phone p\n" +
                "on e.owner_id = p.owner_id\n" +
                "where e.email = 'mbrackstone9@example.com';";

        Map<String, Object> rowMap= DBUtils.getRowMap(query);

        String expectedFullname= (String) rowMap.get("fullname");
        String expectedEmail= (String) rowMap.get("email");
        String expectedPhone= (String) rowMap.get("phone");

        assertEquals(expectedEmail,actualEmail);
        assertEquals(expectedPhone,actualPhone);
        assertEquals(expectedFullname,actualFullname);


    }

    @Then("the user click <email>")
    public void theUserClickEmail(String email) {
        contactsPage.getContactEmail(email).click();

    }

    @Then("the <email> should be the same with database")
    public void theEmailShouldBeTheSameWithDatabase(String email) {
        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String actualFullname = contactInfoPage.contactFullName.getText();
        String actualEmail = contactInfoPage.email.getText();
        String actualPhone = contactInfoPage.phone.getText();

        System.out.println("actualFullname = " + actualFullname);
        System.out.println("actualEmail = " + actualEmail);
        System.out.println("actualPhone = " + actualPhone);

        //getting information from database
        String query = "select concat(name_prefix,' ',first_name,' ',last_name) as fullname, e.email, phone\n" +
                "from orocrm_contact crm JOIN orocrm_contact_email e\n" +
                "on crm.id = e.owner_id\n" +
                "join orocrm_contact_phone p\n" +
                "on e.owner_id = p.owner_id\n" +
                "where e.email = '"+email+"';";
        System.out.println("query = " + query);
        Map<String, Object> rowMap = DBUtils.getRowMap(query);

        String expectedFullname = (String) rowMap.get("fullname");
        String expectedEmail = (String) rowMap.get("email");
        String expectedPhone = (String) rowMap.get("phone");

        System.out.println("expectedFullname = " + expectedFullname);
        System.out.println("expectedEmail = " + expectedEmail);
        System.out.println("expectedPhone = " + expectedPhone);

        //compare UI to Database
        assertEquals(expectedFullname,actualFullname);
        assertEquals(expectedEmail,actualEmail);
        assertEquals(expectedPhone,actualPhone);

    }


    @Then("the information {string} should be the same with database")
    public void the_information_should_be_the_same_with_database(String email) {
        //getting information from UI-GUI-Front-End-Browser
        ContactInfoPage contactInfoPage = new ContactInfoPage();
        BrowserUtils.waitFor(4);
        String actualFullname = contactInfoPage.contactFullName.getText();
        String actualEmail = contactInfoPage.email.getText();
        String actualPhone = contactInfoPage.phone.getText();

        System.out.println("actualFullname = " + actualFullname);
        System.out.println("actualEmail = " + actualEmail);
        System.out.println("actualPhone = " + actualPhone);

        //getting information from database
        String query = "select concat(name_prefix,' ',first_name,' ',last_name) as fullname, e.email, phone\n" +
                "from orocrm_contact crm JOIN orocrm_contact_email e\n" +
                "on crm.id = e.owner_id\n" +
                "join orocrm_contact_phone p\n" +
                "on e.owner_id = p.owner_id\n" +
                "where e.email = '"+email+"';";
        System.out.println("query = " + query);
        Map<String, Object> rowMap = DBUtils.getRowMap(query);

        String expectedFullname = (String) rowMap.get("fullname");
        String expectedEmail = (String) rowMap.get("email");
        String expectedPhone = (String) rowMap.get("phone");

        System.out.println("expectedFullname = " + expectedFullname);
        System.out.println("expectedEmail = " + expectedEmail);
        System.out.println("expectedPhone = " + expectedPhone);

        //compare UI to Database
        assertEquals(expectedFullname,actualFullname);
        assertEquals(expectedEmail,actualEmail);
        assertEquals(expectedPhone,actualPhone);
    }

}
