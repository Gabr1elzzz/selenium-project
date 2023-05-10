package com.lufthansa.pages;

import com.lufthansa.elements.NavigationBarElements;
import com.lufthansa.globals.Globals;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NavigationBarPage {
    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    NavigationBarElements navigationBarElements = new NavigationBarElements();

    public NavigationBarPage(){
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    public void getUrl(String url){
        BaseInformation.getDriver().get(url);
    }

    public void goToOneWay(){
        basePageObject
                .getWaitUtils()
                .waitForElementClickable(navigationBarElements.OneWay).click();
        basePageObject
                .getWaitUtils()
                .waitForAttributePresent(navigationBarElements.OneWay,"class");
        Assert.assertEquals(navigationBarElements.OneWay.getAttribute("class"), "active");

    }

    public void goToMultiDestination(){
        basePageObject
                .getWaitUtils()
                .waitForElementClickable(navigationBarElements.MultiDestination).click();
        basePageObject
                .getWaitUtils()
                .waitForAttributePresent(navigationBarElements.MultiDestination,"class");
        Assert.assertEquals(navigationBarElements.MultiDestination.getAttribute("class"), "active");
    }

    public void goToRoundTrip(){
        basePageObject
                .getWaitUtils()
                .waitForElementClickable(navigationBarElements.RoundTrip).click();
        basePageObject
                .getWaitUtils()
                .waitForAttributePresent(navigationBarElements.RoundTrip,"class");
        Assert.assertEquals(navigationBarElements.RoundTrip.getAttribute("class"), "active");
    }

    public void navigateTo(String tripType){
        Globals.childrenBirthday.clear();
        switch (tripType){
            case "One Way":
                goToOneWay();
                break;
            case "Round Trip":
                goToRoundTrip();
                break;
            case "Multi Destinations":
                goToMultiDestination();
                break;
        }

    }
}

