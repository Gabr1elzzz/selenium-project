package com.lufthansa.pages;

import com.lufthansa.elements.BookingPlansElements;
import com.lufthansa.elements.NavigationBarElements;
import com.lufthansa.elements.PageElements;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BookingPlansPage {
    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    NavigationBarElements navigationBarElements = new NavigationBarElements();
    BookingPlansElements bookingPlansElements = new BookingPlansElements();
    PageElements pageElements =  new PageElements();

    public BookingPlansPage(){
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    public void getUrl(String url){
        BaseInformation.getDriver().get(url);
    }



    public void selectPrize(int index){
        basePageObject
                .getWaitUtils().waitForAllElementsVisible(bookingPlansElements.priceButtons);
        basePageObject
                .getWebElementUtils().scrollToElement(bookingPlansElements.priceButtons.get(index));
        basePageObject
                .getWebElementUtils().clickWebElement(bookingPlansElements.priceButtons.get(index));
    }

    public void bookByChosenPlan(String plan) {

        List<WebElement> visibleButton= bookingPlansElements.getBookNowButtons();
        List<WebElement> visibleOffer = bookingPlansElements.getPriceOffer();


        for (int i=0;i<visibleOffer.size();i++){
            if (bookingPlansElements.getPriceOffer().get(i).getText()
                    .contains(plan.toUpperCase())){
                basePageObject
                        .getWebElementUtils()
                        .scrollToElement(visibleButton.get(i));

                basePageObject
                        .getWebElementUtils()
                        .javaScriptClick(visibleButton.get(i));
                return;
            }
           else{ basePageObject.getWebElementUtils().clickWebElement(visibleButton.get(0));return;}
        }

    }




}

