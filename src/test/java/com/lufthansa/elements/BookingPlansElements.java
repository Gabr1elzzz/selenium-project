package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookingPlansElements {
    public BookingPlansElements(){

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(className = "ff-price-padding")
    public List<WebElement> priceButtons;

    public List<WebElement> getPriceOffer(){
        List<WebElement> priceOffer = BaseInformation.getDriver().findElements(By.cssSelector("div.fields.non-mobile-ff button.ui.fluid.toggle.button.fareFamilyInfoButton"));
        //div[@class='fields non-mobile-ff']//button[@class='ui fluid toggle button fareFamilyInfoButton']
        return priceOffer;
    }

    public List<WebElement> getBookNowButtons(){
        List<WebElement> bookNow = BaseInformation.getDriver().findElements(By.cssSelector("div.fields.non-mobile-ff button.ui.button.red"));
        //div[@class='fields non-mobile-ff']//button[@class='ui button red  ']
        return bookNow;
    }
}
