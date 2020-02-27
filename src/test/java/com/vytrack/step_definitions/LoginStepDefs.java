package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginStepDefs {
    WebDriver driver= Driver.get();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        //Thread.sleep(2000);
        System.out.println("Opening the login page");
        String url= ConfigurationReader.get("url");
       // Driver.get().get(url);

        driver.get(url);
        driver.manage().window().maximize();


    }

    @When("the user enter the driver information")
    public void the_user_enter_the_driver_information() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        LoginPage loginPage=new LoginPage();
        String username=ConfigurationReader.get("driver_username");
        String password=ConfigurationReader.get("driver_password");
        loginPage.login(username,password);


        System.out.println("I sent the driver username");
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        // Write code here that turns the phrase above into concrete actions
        BrowserUtils.waitFor(5);
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals("Dashboard",actualTitle);

    }


    @When("the user enter the sales manager information")
    public void the_user_enter_the_sales_manager_information() {
        LoginPage loginPage=new LoginPage();
        String username=ConfigurationReader.get("sales_manager_username");
        String password=ConfigurationReader.get("sales_manager_password");
        loginPage.login(username,password);
    }

    @When("the user enter the store manager information")
    public void the_user_enter_the_store_manager_information() {
        LoginPage loginPage=new LoginPage();
        String username=ConfigurationReader.get("store_manager_username");
        String password=ConfigurationReader.get("store_manager_password");
        loginPage.login(username,password);
    }

    @When("user logs in using {string} and {string}")
    public void user_logs_in_using_and(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        LoginPage loginPage=new LoginPage();
        loginPage.login(username, password);

    }

    @Then("the title should contains {string}")
    public void the_title_should_contains(String expectedTitle) {
        System.out.println("expectedTitle = " + expectedTitle);
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));


    }

    @When("the user logged in as a driver")
    public void theUserLoggedInAsADriver() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(username,password);



    }
}
