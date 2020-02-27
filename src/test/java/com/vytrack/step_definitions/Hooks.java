package com.vytrack.step_definitions;
import com.vytrack.utilities.DBUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @After("@wip")
    public void tearDownDatabase(){
        System.out.println("\tCLOSING DATABASE CONNECTION");
    }
    @After("@db")
    public void tearDown(){
        System.out.println("Destroying database connection...");
        DBUtils.destroyConnection();
        Driver.closeDriver();
    }
    @Before("@db")
    public void setUp(){
        System.out.println("Creating database connection...");
        DBUtils.createConnection();

    }
    @Before("@wip")
    public void setUpDatabase(){
        System.out.println("\tCONNECTION DATABASE");
    }




}
