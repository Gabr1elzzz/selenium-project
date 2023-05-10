package com.lufthansa.pages;

import com.lufthansa.elements.LastBookingPageElements;
import com.lufthansa.elements.NavigationBarElements;
import com.lufthansa.globals.Globals;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LastBookingPage {
    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    LastBookingPageElements lastBookingPageElements = new LastBookingPageElements();

    public LastBookingPage(){
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    public void getUrl(String url){
        BaseInformation.getDriver().get(url);
    }


    public void checkBookingText(){
        basePageObject
                .getWaitUtils()
                .waitForElementVisibleWithCustomTime(100000,lastBookingPageElements.bookingReferenceText);
        Assert.assertTrue(lastBookingPageElements.bookingReferenceText.getText().contains("booking reference number"));

        checkNames();

    }

    public void printReferenceCode(){
        System.out.println(lastBookingPageElements.bookingReferenceCode.getText());
    }

    public void checkNames(){
        for (int i=0;i<lastBookingPageElements.displayedNames.size();i++){
            Assert.assertTrue(Globals.names.get(i).contains(lastBookingPageElements.displayedNames.get(i).getText()));
        }
    }
}

