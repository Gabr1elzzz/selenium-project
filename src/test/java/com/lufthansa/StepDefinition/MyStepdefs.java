package com.lufthansa.StepDefinition;

import com.lufthansa.globals.Globals;
import com.lufthansa.pages.*;
import com.lufthansa.utilities.BaseInformation;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {

    MainPage mainPage = new MainPage();
    ClientInformationPage clientInformationPage = new ClientInformationPage();
    BookingPlansPage bookingPlansPage = new BookingPlansPage();
    NavigationBarPage navigationBarPage = new NavigationBarPage();

    LastBookingPage lastBookingPage = new LastBookingPage();

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        mainPage.getUrl(Globals.baseUrl);
    }

    @When("I select the {string} option")
    public void iSelectTheOption(String trip) {
        navigationBarPage.navigateTo(trip);
        System.out.println("Navigated to "+trip);
    }

    @And("I select the route from {string} to {string}")
    public void iSelectTheRouteFromTo(String ar0, String ar1) {
        mainPage.setDepartureCityorAirport(ar0);
        mainPage.setDestinationCityorAirport(ar1);
    }


    @And("I select {string} date on the {string}")
    public void iSelectDateOnThe(String day, String monthAndYear) {
        mainPage.setdateofDeparture(day,monthAndYear);
    }

    @And("I specify {int} adult travelers in {string}")
    public void iSpecifyAdultTravelersIn(int arg0, String arg1) {
        mainPage.selectAdults(arg0);
        mainPage.selectCabin(arg1);
        mainPage.clickSearch();
    }

    @And("I select the {int} price and I choose {string} as a plan")
    public void iSelectThePriceAndIChooseAsAPlan(int arg0, String plan) {
        bookingPlansPage.selectPrize(arg0-1);
        bookingPlansPage.bookByChosenPlan(plan);
        System.out.println("Selected "+plan+ "plan");
    }

    @And("I fill all clients info")
    public void iFillAllClientsInfo() {
        clientInformationPage.fillClientInfo();

    }

    @Then("I choose seat {string} or any window seat if it's not available")
    public void iChooseSeatOrAnyWindowSeatIfItSNotAvailable(String arg0) {
        clientInformationPage.selectCustomSeat(arg0);
        System.out.println("Seats selected");
    }

    @Then("I select the card payment option")
    public void iSelectTheCashInvoicePaymentOption() {
        clientInformationPage.fillCreditCardInfo();
        System.out.println("Payment selected and filled");
    }

    @Then("I confirm the booking after adding {string} as a CCV code")
    public void iConfirmTheBooking(String arg0) {
        clientInformationPage.setCVVcode(arg0);
        System.out.println("CVV code set to "+arg0);
        clientInformationPage.clickBookNow();
    }

    @Then("I should see the booking reference number and a message asking me to write it down or remember it")
    public void iShouldSeeTheBookingReferenceNumberAndAMessageAskingMeToWriteItDownOrRememberIt() {
        lastBookingPage.checkBookingText();
    }

    @And("the booking reference number should be displayed on the console")
    public void theBookingReferenceNumberShouldBeDisplayedOnTheConsole() {
        lastBookingPage.printReferenceCode();
    }

    @After
    public void after() {
        BaseInformation.getDriver().quit();
    }

    @And("I select {string} return date on the {string}")
    public void iSelectReturnDateOnThe(String arg0, String arg1) {
        mainPage.setdateofReturn(arg0,arg1);
    }

    @And("I specify {int} adult {int} infant travelers in {string}")
    public void iSpecifyAdultInfantTravelersIn(int arg0, int arg1, String arg2) {
        mainPage.selectAdults(arg0);
        mainPage.selectInfant(arg1);
        mainPage.selectCabin(arg2);
        mainPage.clickSearch();
    }

    @Then("I add Car")
    public void iAddCar() {
        System.out.println("Car added");
    }

    @And("I set a {int} day  multi desitination trip with route {string} in {string}")
    public void iSetADayMultiDesitinationTripWithRouteIn(int day, String route, String month) {
        mainPage.setMultipleDestinationAndReturn(route,day,month);
        System.out.println(route+ " added with a " +day + "trip");
    }

    @And("I specify {int} adult and {int} childs travelers in {string}")
    public void iSpecifyAdultAndChildsTravelersIn(int arg0, int arg1, String arg2) {
        mainPage.selectAdults(arg0);
        mainPage.selectChild(arg1);
        mainPage.selectCabin(arg2);


    }

    @Then("I add preferred airline {string}")
    public void iAddPreferredAirline(String arg0) {
        mainPage.addPreferredAirline(arg0);
        System.out.println("Preferred Airline set to " +arg0);
        mainPage.clickSearch();
    }

    @Then("I add Hotel")
    public void iAddHotel() {
        System.out.println("Hotel added.");
    }
}
