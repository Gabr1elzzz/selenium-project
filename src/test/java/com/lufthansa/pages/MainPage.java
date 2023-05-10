package com.lufthansa.pages;

import com.lufthansa.elements.PageElements;
import com.lufthansa.globals.Globals;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

import java.text.DateFormatSymbols;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class MainPage {
    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    PageElements pageElements =  new PageElements();



    public MainPage(){
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    public void getUrl(String url){
        BaseInformation.getDriver().get(url);
    }

    public void setDepartureCityorAirport(String departure) {
        basePageObject
                .getWebElementUtils()
                .clickWebElement(pageElements.departureCity);

        basePageObject
                .getWebElementUtils()
                .sendKeysToElementWithWait(pageElements.departureCity,departure,10);

        WebElement resultCity = pageElements.departureCity.findElement(By.xpath("following-sibling::*"));

        basePageObject
                .getWaitUtils()
                .waitForTextToBePresentInElement(resultCity,"result");

        pageElements.departureCity.sendKeys(Keys.ENTER);
        Assert.assertTrue(pageElements.departureCity.getAttribute("value").contains(departure));


        System.out.println("Departure selected:"+ departure);

    }
    public void setDestinationCityorAirport(String destination) {
        basePageObject
                .getWebElementUtils()
                .clickWebElement(pageElements.destinationCity);

        basePageObject
                .getWebElementUtils()
                .sendKeysToElementWithWait(pageElements.destinationCity,destination,10);

        WebElement resultCity = pageElements.destinationCity.findElement(By.xpath("following-sibling::*"));

        basePageObject.
                getWaitUtils().
                waitForTextToBePresentInElement(resultCity,"result");

        pageElements.destinationCity.sendKeys(Keys.ENTER);

        Assert.assertTrue(pageElements.destinationCity.getAttribute("value").contains(destination));

        System.out.println("Destination selected:"+ destination);

    }

    public void setdateofDeparture(String desiredDate,String desiredMonthAndYear){
        basePageObject.getWebElementUtils().clickWebElement(pageElements.departureDate);
        if (desiredDate.equals("Current Day")){
            setdateofDeparture(returnCurrentDay(),desiredMonthAndYear);
            return;
        }
        if (desiredMonthAndYear.contains("Next Month")){
            setdateofDeparture(returnCurrentDay(),desiredMonthAndYear.replace("Next Month",returnNextMonth()));
            return;
        }
        boolean dateFound = false;
        do {
            String currentMonthAndYear = pageElements.getMonthAndYear().getText();
            if (!currentMonthAndYear.contains(desiredMonthAndYear)) {
                pageElements.nextMonth.click();
                continue;
            }
            List<WebElement> allDates = pageElements.selectDay;
            for (WebElement correctDate : allDates) {
                if (correctDate.getText().equals(desiredDate)) {
                    basePageObject
                            .getWebElementUtils().clickWebElement(correctDate);
                    System.out.println("Date of departure set to: " + desiredDate + " " + desiredMonthAndYear);
                    dateFound = true;
                    break; }
            }
        } while (!dateFound);
    }

    public String returnCurrentDay(){
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH)+1;
        return String.valueOf(dayOfMonth);
    }
    public String returnFutureDayFromCurrentDay(int day){
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH)+1;
        dayOfMonth += day;
        System.out.println(dayOfMonth);
        return String.valueOf(dayOfMonth);
    }
    public String returnNextMonth(){
        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH);
        return new DateFormatSymbols().getMonths()[currentMonth + 1 ];
    }

    public void setdateofReturn(String desiredDate,String desiredMonthAndYear){
        basePageObject.getWebElementUtils().clickWebElement(pageElements.returnDate);
        if (desiredMonthAndYear.contains("Next Month")){
            setdateofReturn(returnCurrentDay(),desiredMonthAndYear.replace("Next Month",returnNextMonth()));
            return;
        }
        if (desiredDate.equals("Current Day")){
            setdateofReturn(returnCurrentDay(),desiredMonthAndYear);
            return;
        }
        boolean dateFound = false;

        do {
            basePageObject.getWaitUtils().waitForElementVisible(pageElements.getMonthAndYear());
            String currentMonthAndYear = pageElements.getMonthAndYear().getText();
            if (!currentMonthAndYear.contains(desiredMonthAndYear)) {
                pageElements.nextMonth.click();
                continue;
            }
            List<WebElement> alldates = pageElements.selectDay;
            for (WebElement correctdate : alldates) {
                if (correctdate.getText().equals(desiredDate)) {
                    basePageObject
                            .getWebElementUtils().clickWebElement(correctdate);
                    System.out.println("Date of departure set to: " + desiredDate + " " + desiredMonthAndYear);
                    dateFound = true;
                    break; }
            }
        } while (!dateFound);
    }

    public void clickSearch(){
        basePageObject
                .getWebElementUtils().scrollToElement(pageElements.submitButton);
        basePageObject
                .getWebElementUtils().clickWebElement(pageElements.submitButton);
    }




    public void selectAdults(int count) {
        Select select = new Select(pageElements.selectAdult);
        select.selectByIndex(count-1);
        System.out.println("Selected "+count+" adults.");
    }

    public void selectChild(int count) {
        Select select = new Select(pageElements.selectChild);
        select.selectByIndex(count);
        System.out.println("Selected "+count+" kids.");
    }
    public void selectInfant(int count) {
        Select select = new Select(pageElements.selectInfant);
        select.selectByIndex(count);
        System.out.println("Selected "+count+" infants.");
    }

    public void selectCabin(String cabin) {
        //basePageObject.getWaitUtils().waitForElementClickable(pageElements.selectAdult);
        Select select = new Select(pageElements.selectCabin);
        select.selectByVisibleText(cabin);
        System.out.println("Selected "+cabin);
    }

    public void selectNonStopFlights(){
        basePageObject.getWebElementUtils().scrollToElement(pageElements.advancedOptions);
        pageElements.advancedOptions.click();
        Select select = new Select(pageElements.selectNonStopFlights);
        select.selectByIndex(1);
        System.out.println("Selected non stop flights");
    }
    public void addPreferredAirline(String airline){
        selectNonStopFlights();
        basePageObject
                .getWaitUtils().waitForElementPresent(pageElements.preferredAirlineBox);
        basePageObject
                .getWebElementUtils().moveMouseToElement(pageElements.preferredAirlineBox);
        pageElements.preferredAirlineBox.click();
        basePageObject
                .getWebElementUtils().sendKeysToElementWithWait(pageElements.preferredAirlineBox,airline,1000);
        Assert.assertTrue(pageElements.preferredAirlineBox.getAttribute("airlinename").contains(airline));
    }


    public List<String> getLocations(String locationString ) {
        String[] locationArray = locationString.split("-");
        List<String> locations = new ArrayList<>(Arrays.asList(locationArray));
        return locations;
    }

    public void setMultipleDestinationAndReturn(String departure , int Day , String MonthAndYear) {

        List<String> airportStrings = getLocations(departure);

        for (int i=0 ;i < airportStrings.size()-1;i++) {
            String selector = "div#multiDestContainer a[id^='addLeg_"+i+"']";

            setDepartureCityWithIndex(i,airportStrings.get(i));
            setDestinationWithIndex(i,airportStrings.get(i+1));

            if (i<airportStrings.size()-2){
            setMultipleDateOfDeparture("Current Day",MonthAndYear,i);
            WebElement plusButton = BaseInformation.getDriver().findElement(By.cssSelector(selector));
            basePageObject.getWebElementUtils().javaScriptClick(plusButton);
            }else{
                String chosenDay = returnFutureDayFromCurrentDay(Day);
                Globals.monthAndYearofReturn= MonthAndYear;
                Globals.dayOfReturn = chosenDay;
                setMultipleDateOfDeparture(chosenDay,MonthAndYear, i);
            }
        }
    }

    public void setMultipleDestination(String departure , String destination, int Day , String MonthAndYear) {
        for (int i=0 ;i < 3;i++) {
            String selectorSeat = "div#multiDestContainer a[id='addLeg_0']";
            setDepartureCityorAirport(departure);
            setDestinationCityorAirport(destination);
            if (i<2){
                setdateofDeparture(String.valueOf(Day-7),MonthAndYear);
                WebElement plusButton = BaseInformation.getDriver().findElement(By.cssSelector(selectorSeat));
                basePageObject.getWebElementUtils().javaScriptClick(plusButton);
            }else{
                setdateofDeparture(String.valueOf(Day),MonthAndYear);
            }
        }
    }

    public void setMultipleDateOfDeparture(String desiredDate, String desiredMonthAndYear, int i){
        basePageObject.getWebElementUtils().clickWebElement(pageElements.departureDateList.get(i));
        if (desiredDate.equals("Current Day")){
            setMultipleDateOfDeparture(returnCurrentDay(),desiredMonthAndYear,i);
            return;
        }
        if (desiredMonthAndYear.contains("Next Month")){
            setMultipleDateOfDeparture(desiredDate,desiredMonthAndYear.replace("Next Month",returnNextMonth()),i);
            return;
        }
        boolean dateFound = false;
        do {
            String currentMonthAndYear = pageElements.getMonthAndYear().getText();
            if (!currentMonthAndYear.contains(desiredMonthAndYear)) {
                pageElements.nextMonth.click();
                continue;
            }
            List<WebElement> allDates = pageElements.selectDay;
            for (WebElement correctDate : allDates) {
                if (correctDate.getText().equals(desiredDate)) {
                    basePageObject
                            .getWebElementUtils().clickWebElement(correctDate);
                    System.out.println("Date of departure set to: " + desiredDate + " " + desiredMonthAndYear);
                    dateFound = true;
                    break; }
            }
        } while (!dateFound);
    }
    public void setDepartureCityWithIndex(int index , String airport) {

            basePageObject
                    .getWebElementUtils()
                    .clickWebElement(pageElements.departureCityList.get(index));

            basePageObject
                    .getWebElementUtils()
                    .sendKeysToElementWithWait(pageElements.departureCityList.get(index), airport, 10);

            WebElement resultCity = pageElements.departureCityList.get(index).findElement(By.xpath("following-sibling::*"));

            basePageObject.
                    getWaitUtils().
                    waitForTextToBePresentInElement(resultCity, "result");

            pageElements.departureCityList.get(index).sendKeys(Keys.ENTER);

            System.out.println("Departure "+(index+1)+" selected:" + airport);

        }

    public void setDestinationWithIndex(int index , String airport) {

        basePageObject
                .getWebElementUtils()
                .clickWebElement(pageElements.destinationCityList.get(index));

        basePageObject
                .getWebElementUtils()
                .sendKeysToElementWithWait(pageElements.destinationCityList.get(index), airport, 10);

        WebElement resultCity = pageElements.destinationCityList.get(index).findElement(By.xpath("following-sibling::*"));

        basePageObject.
                getWaitUtils().
                waitForTextToBePresentInElement(resultCity, "result");

        pageElements.destinationCityList.get(index).sendKeys(Keys.ENTER);


        System.out.println("Destination "+(index+1)+" selected:" + airport);

    }

}




