package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBarElements {
    public NavigationBarElements(){

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(id = "RoundTrip")
    public WebElement RoundTrip;

    @FindBy(id = "OneWay")
    public WebElement OneWay;

    @FindBy(id = "MultiDestination")
    public WebElement MultiDestination;

}
