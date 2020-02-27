package com.vytrack.step_definitions;

import com.vytrack.pages.AllCalendarEvents;
import com.vytrack.pages.CreateCalendarEvent;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_Cases_4_Step_Definitions {

    WebDriver driver= Driver.get();


    @Then("three options are available")
    public void three_options_are_available() throws InterruptedException {
        AllCalendarEvents allCalendarEvents=new AllCalendarEvents();


        List<String> ExpectedMenu = new ArrayList<>();
        ExpectedMenu.add("View");
        ExpectedMenu.add("Edit");
        ExpectedMenu.add("Delete");


        BrowserUtils.waitFor(4);
        List<String> scMenu = allCalendarEvents.SaveAndCloseMenu();
        System.out.println(scMenu.toString());
        for(int i = 0; i<ExpectedMenu.size(); i++) {
            Assert.assertEquals(scMenu.get(i), ExpectedMenu.get(i), "Verify that actual matches expected");
        }
    }

    @Then("the title column is displayed")
    public void the_title_column_is_displayed() {
        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
        WebDriverWait wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.visibilityOf(allCalendarEvents.GridSettings));
        allCalendarEvents.GridSettings.click();
//        allCalendarEvents.selected.click();
//        allCalendarEvents.titleCheckBox.click();
        allCalendarEvents.calendarCheckBox.click();
        allCalendarEvents.endCheckBox.click();
        allCalendarEvents.invitationCheckBox.click();
        allCalendarEvents.recurrenceCheckBox.click();
        allCalendarEvents.recurrentCheckBox.click();
        allCalendarEvents.startCheckBox.click();
        Assert.assertTrue(allCalendarEvents.titleColumn.isDisplayed());

    }

    @Then("Save and Close menu items displayed")
    public void save_and_Close_menu_items_displayed() throws InterruptedException {
        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
        Thread.sleep(5000);

        allCalendarEvents.createCalendarEvent.click();

        CreateCalendarEvent createCalendarEvent=new CreateCalendarEvent();
        Thread.sleep(5000);
        createCalendarEvent.saveAndCloaseExpand.click();

        List<WebElement> list=driver.findElements(By.xpath("//li/button"));

        ArrayList<String> list1=new ArrayList<String>();
        ArrayList<String> list2=new ArrayList<String>();
        list2.add("Save And Close");
        list2.add("Save And New");
        list2.add("Save");

        List<String> list3 = Arrays.asList("Save And Close","Save And New","Save");

        for (WebElement webElement : list) {
            Assert.assertTrue(webElement.isDisplayed());
            System.out.println(webElement.getText());
            list1.add(webElement.getText());

        }
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        Assert.assertTrue(list1.equals(list2));
        Assert.assertTrue(list1.equals(list3));

    }
    @And("the user navigates to Create Calendar Event")
    public void theUserNavigatesToCreateCalendarEvent() throws InterruptedException {
        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
        Thread.sleep(3000);
        allCalendarEvents.createCalendarEvent.click();
        Thread.sleep(3000);
    }


    @Then("All Calendar Events subtitle is displayed")
    public void allCalendarEventsSubtitleIsDisplayed() throws InterruptedException {
        AllCalendarEvents allCalendarEvents=new AllCalendarEvents();
        CreateCalendarEvent createCalendarEvent=new CreateCalendarEvent();
        Thread.sleep(5000);
        createCalendarEvent.cancelButton.click();

        Thread.sleep(6000);
//        Assert.assertTrue(allCalendarEvents.allCalendarEventsText.isDisplayed());
        Assert.assertTrue(allCalendarEvents.allCalendarEventsText.getText().equals("All Calendar Events"));

    }


    @Then("verify hour difference is just one hour")
    public void verifyHourDifferenceIsJustOneHour() throws InterruptedException {

        CreateCalendarEvent createCalendarEvent=new CreateCalendarEvent();
        Thread.sleep(3000);

//        WebElement element=driver.findElement(By.xpath("//input[@id='time_selector_oro_calendar_event_form_start-uid-5e086ac3df58c']"));
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].click();",element);


//        WebElement dropDownListBox = driver.findElement(By.xpath("(//input[@placeholder='time'])[1]"));
//        ((JavascriptExecutor)driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", dropDownListBox, "blablabla");

        createCalendarEvent.timeStart.click();
        Thread.sleep(3000);
        // action.click(createCalendarEvent.timeStart).perform();

//        BrowserUtils.getElementsText(By.xpath("//div[@class ='ui-timepicker-wrapper']//li"));



        List<WebElement> buttons = driver.findElements(By.xpath("//div[@class ='ui-timepicker-wrapper']//li"));
        System.out.println(buttons.toString());
//
//
//        for (WebElement button : buttons) {
//            System.out.println(button.getText());
//        }

        ArrayList<String> hours=new ArrayList<>();

        for (int i = 0; i < buttons.size(); i++) {

            WebElement element1=buttons.get(i);
            String innerHTML=element1.getAttribute("innerHTML");

//            butun secenekleri yazdirmak icin
            System.out.println("innerHTML = " + innerHTML.substring(0,5));

//            AM PM kismini atmak icin
            hours.add(innerHTML.substring(0,5));

        }
        System.out.println("hours.get(3) = " + hours.get(3));
        System.out.println("hours.get(5) = " + hours.get(5));

        String str=hours.get(3);
        String[] array = str.split(":");
        String firstHour=array[0].concat(array[1]);
        System.out.println("firstHour = " + firstHour);

        String str2=hours.get(5);
        String[] array2 = str2.split(":");
        String secondHour=array2[0]+array2[1];
        System.out.println("secondHour = " + secondHour);

//        String firstHourRegularString="130";
//        String secondHourRegularString="230";
//        int a=Integer.parseInt(firstHourRegularString);
//        int b=Integer.parseInt(secondHourRegularString);
//        int c=b-a;
//        System.out.println("c = " + c);


        double firstHourInteger=Double.parseDouble(firstHour);
        double secondHourInteger=Double.parseDouble(secondHour);
        System.out.println(secondHourInteger-firstHourInteger);

        int firstHourInteger2=(int)firstHourInteger;
        int secondHourInteger2=(int)secondHourInteger;
        int result=secondHourInteger2-firstHourInteger2;
//
        Assert.assertTrue(result==100);

    }


    @Then("Verify end time as one hour later")
    public void verifyEndTimeAsOneHourLater() {
        CreateCalendarEvent createCalendarEvent=new CreateCalendarEvent();
        createCalendarEvent.waitUntilLoaderScreenDisappear();
        createCalendarEvent.timeStart.click();

        createCalendarEvent.selectTime("9:00 PM").click();


        createCalendarEvent.timeEnd.click();
        String endTime= createCalendarEvent.getSelectedEndTime.getText();
        Assert.assertEquals(endTime, "10:00 PM");
    }

    @Then("Verify that start and end date input boxes are displayed")
    public void verifyThatStartAndEndDateInputBoxesAreDisplayed() throws InterruptedException {
        CreateCalendarEvent createCalendarEvent=new CreateCalendarEvent();
        Thread.sleep(3000);
        createCalendarEvent.allDayEventCeheckBox.click();
        Thread.sleep(2000);
        Assert.assertFalse(createCalendarEvent.timeStart.isDisplayed());
        Assert.assertFalse(createCalendarEvent.timeEnd.isDisplayed());
        Assert.assertTrue(createCalendarEvent.startDay.isDisplayed());
        Assert.assertTrue(createCalendarEvent.endDay.isDisplayed());

    }

    @Then("Verify that Daily is selected by default")
    public void verifyThatDailyIsSelectedByDefault() {
        CreateCalendarEvent createCalendarEvent=new CreateCalendarEvent();
        createCalendarEvent.repeatOptions.click();
        String defaultRepeatOption= createCalendarEvent.defaultRepeat.getText();
        Assert.assertEquals(defaultRepeatOption,"Daily");

        Select repeatOptions=new Select(createCalendarEvent.repeatDropdownOptions);

        List<WebElement> options=repeatOptions.getOptions();
        ArrayList<String> options2=new ArrayList<>();
        for (WebElement s : options) {
            options2.add(s.getText());
        }
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");
        Assert.assertEquals(options2, expectedList);
    }

    @Then("Verify “Summary: Daily every {int} day” is displayed")
    public void verifySummaryDailyEveryDayIsDisplayed(int arg0) throws InterruptedException {
        CreateCalendarEvent createCalendarEvent=new CreateCalendarEvent();
        Thread.sleep(3000);
        createCalendarEvent.repeatOptions.click();
        Assert.assertTrue(createCalendarEvent.repeatEveryRadioButton.isSelected());
        arg0=1;
        String message="Daily every ".concat(String.valueOf(arg0)).concat(" day");
        System.out.println("message = " + message);
        System.out.println(createCalendarEvent.summaryMessage.getText());
        if(createCalendarEvent.summaryMessage.getText().equals(message)){
            System.out.println("true");

        }


        Assert.assertTrue(createCalendarEvent.summaryMessage.getText().equals(message));
    }

    @Then("Verify “Daily every {int} day, end  after {int} occurrences”")
    public void verifyDailyEveryDayEndAfterOccurrences(int arg0, int arg1) throws InterruptedException {
        String message="Daily every ".concat(String.valueOf(arg0)).concat(" day, end after ").concat(String.valueOf(arg1)).concat(" occurrences");
        CreateCalendarEvent createCalendarEvent = new CreateCalendarEvent();
        Thread.sleep(3000);
        createCalendarEvent.repeatOptions.click();
        createCalendarEvent.afterRadioButton.click();
        createCalendarEvent.afterInputBox.sendKeys("10");
        createCalendarEvent.afterInputBox.click();

        System.out.println("message = " + message);
        System.out.println("Daily every 1 day".concat(createCalendarEvent.afterMessage.getText()));
        Assert.assertTrue("Daily every 1 day".concat(createCalendarEvent.afterMessage.getText()).equals(message));
    }
}
