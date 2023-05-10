package com.lufthansa.tests;

import com.lufthansa.globals.Globals;
import com.lufthansa.pages.*;
import com.lufthansa.utilities.BaseInformation;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestRegisterPage {

   MainPage mainPage = new MainPage();


   ClientInformationPage clientInformationPage = new ClientInformationPage();

   BookingPlansPage bookingPlansPage = new BookingPlansPage();

   NavigationBarPage navigationBarPage = new NavigationBarPage();

   LastBookingPage lastBookingPage = new LastBookingPage();
    @AfterTest
    public void quit(){
        BaseInformation.quit();
    }
    @Test
    public void test() throws InterruptedException {
        mainPage.getUrl(Globals.baseUrl);
        navigationBarPage.navigateTo("Round Trip");
        System.out.println(mainPage.returnCurrentDay());
        mainPage.setDepartureCityorAirport("TIA");
        mainPage.setDestinationCityorAirport("MUC");
        mainPage.setdateofDeparture("Current Day","May 2023");
        mainPage.setdateofReturn("9","Next Month 2023");
        mainPage.selectAdults(3);
        mainPage.selectChild(2);
        mainPage.selectInfant(0);
        mainPage.selectCabin("Economy");
        Thread.sleep(300);
        mainPage.clickSearch();
        bookingPlansPage.selectPrize(0);
        bookingPlansPage.bookByChosenPlan("CLASSIC");
        clientInformationPage.fillClientInfo();
        clientInformationPage.fillCreditCardInfo();
        clientInformationPage.setCVVcode("1234");
        clientInformationPage.selectCustomSeat("22A");
      clientInformationPage.clickBookNow();
        lastBookingPage.checkBookingText();
        Thread.sleep(10000000);
        //mainPage.selectNonStopFlights();

    }
    @Test
    public void test2() throws InterruptedException {
        mainPage.getUrl(Globals.baseUrl);
        navigationBarPage.navigateTo("Multi Destinations");
        mainPage.setMultipleDestinationAndReturn("Tirana-Vienna-Hamburg-Tirana",7,"Next Month");
        Thread.sleep(10000000);
    }

}
