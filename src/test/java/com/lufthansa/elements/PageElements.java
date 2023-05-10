package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageElements {
    public PageElements(){

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(id = "departure_city")
    public WebElement departureCity;

    @FindBy(id = "destination_city")
    public WebElement destinationCity;

    @FindBy(id = "departure_date")
    public WebElement departureDate;

    @FindBy(id = "return_date")
    public WebElement returnDate;

    @FindBy(className = "ui-datepicker-next")
    public WebElement nextMonth;


    @FindBy(css = "a.ui-state-default[href='#']")
    public List<WebElement> selectDay;


    @FindBy(css = "#adult-counter")
    public WebElement selectAdult;

    @FindBy(css = "#pref_class")
    public WebElement selectCabin;
    @FindBy(css = "#non_stop_flights")
    public WebElement selectNonStopFlights;



    @FindBy(id = "child-counter")
    public WebElement selectChild;

    @FindBy(id = "infant-counter")
    public WebElement selectInfant;

    @FindBy(id = "pref_class")
    public WebElement cabinPreference;

    @FindBy(className = "title")
    public WebElement advancedOptions;

    @FindBy(id = "submitBTN")
    public WebElement submitButton;


    public WebElement getMonthAndYear(){
        return BaseInformation.getDriver().findElement(By.className("ui-datepicker-title"));
    }

    @FindBy(css = "div#multiDestContainer input[id^='departure_city_']")
    public List<WebElement> departureCityList;


    @FindBy(css = "div#multiDestContainer input[id^='destination_city_']")
    public List<WebElement> destinationCityList;

    @FindBy(css = "div#multiDestContainer input[id^='departure_date_']")
    public List<WebElement> departureDateList;

    @FindBy(id ="#pref_airline")
    public WebElement preferredAirlineBox;

}
