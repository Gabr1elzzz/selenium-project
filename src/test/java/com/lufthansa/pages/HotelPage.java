package com.lufthansa.pages;

import com.lufthansa.elements.BookingPlansElements;
import com.lufthansa.elements.HotelElements;
import com.lufthansa.elements.NavigationBarElements;
import com.lufthansa.elements.PageElements;
import com.lufthansa.globals.Globals;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.LocalDate;
import java.util.List;

public class HotelPage {
    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());

    HotelElements hotelElements = new HotelElements();

    MainPage mainPage = new MainPage();
    Double maxPrice = (double) 0;

    public HotelPage(){
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    public void getUrl(String url){
        BaseInformation.getDriver().get(url);
    }



    public void selectAgesOfKids() {

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        for (int i = 0;i < hotelElements.childAge.size(); i++)
        {
            String yearString = Globals.childrenBirthday.get(i);

            int year = Integer.parseInt(yearString);

            int difference = currentYear - year;

            Select select= new Select(hotelElements.childAge.get(i));
            select.selectByIndex(difference);
        }
    }

    public void bookHotel(){
        basePageObject
                .getWebElementUtils().clickWebElement(hotelElements.addHotelButton);

        mainPage.setdateofReturn(Globals.dayOfReturn,Globals.monthAndYearofReturn);

        selectAgesOfKids();

        WebElement bookhotel = null;
        for (WebElement hotels : hotelElements.bookHotel) {
            if (hotels.isDisplayed()&&comparePrice(hotels.getText(),3500)) {
                if (getPriceDouble(hotels.getText())>maxPrice) {
                    maxPrice=getPriceDouble(hotels.getText());
                    bookhotel = hotels;
                }

            } break;
        }
        if (bookhotel != null) {
            basePageObject
                    .getWebElementUtils()
                            .scrollToElement(bookhotel);

            basePageObject.getWebElementUtils().clickWebElement(bookhotel);
            System.out.println("Hotel selected");
        }
    }
    public  boolean comparePrice(String price, double value) {
        String priceWithoutDollar = price.replace("$", "");
        double priceValue = Double.parseDouble(priceWithoutDollar);
        return priceValue < value;
    }
    public  double getPriceDouble(String price) {
        String priceWithoutDollar = price.replace("$", "");
        double priceValue = Double.parseDouble(priceWithoutDollar);
        return priceValue ;
    }

}






