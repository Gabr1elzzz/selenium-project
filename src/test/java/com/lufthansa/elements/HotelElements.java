package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelElements {
    public HotelElements(){

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(css = "div#addHotelTravelTypeDiv > button")
    public WebElement addHotelButton;

    @FindBy(id = "return_date")
    public WebElement checkoutDateHotel;

    @FindBy(css = "[id^=child-counter]")
    public List<WebElement> childAge;


    @FindBy(id = "selectbtn")
    public List<WebElement> bookHotel;

    @FindBy(id="search")
    public WebElement searchButton;


}
