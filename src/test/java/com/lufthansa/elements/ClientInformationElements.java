package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ClientInformationElements {
    public ClientInformationElements(){

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(css = "div[name=\"paxDetails\"] h4.ui.dividing.header")
    public List<WebElement> formClientOpener;

    @FindBy(css = "[id^=fname]")
    public List<WebElement> clientName;
    @FindBy(css = "[id^=lname]")
    public List<WebElement> clientLastName;

    @FindBy(css = "[id^=email_0]")
    public WebElement clientEmail;

    @FindBy(css = "[id^=email_c]")
    public WebElement clientConfirmatioEmail;

    @FindBy(css = "[id=phone_0]")
    public WebElement clientPhoneNumber;

    @FindBy(css = "[id^=bdate_d]")
    public List<WebElement> birthdayDay;

    @FindBy(css = "[id^=bdate_m]")
    public List<WebElement> birthdayMonth;

    @FindBy(css = "[id^=bdate_y]")
    public List<WebElement> birthdayYear;

    @FindBy(id = "AIRcnN_0")
    public WebElement creditCardNumber;

    @FindBy(id = "AIRcvv_0")
    public WebElement  cvcNumber;

    @FindBy(id = "AIRexp_m_0")
    public WebElement expirationMonth;

    @FindBy(id = "AIRexp_y_0")
    public WebElement expirationYear;

    @FindBy(id = "AIRstr_0")
    public WebElement billingAdress;

    @FindBy(id = "AIRcty_0")
    public WebElement billingCity;

    @FindBy(id = "AIRzip_0")
    public WebElement zipCode;

    @FindBy(css = "[id^=CUSTOM_FIELD_]")
    public WebElement cvvNumber;

    @FindBy(id = "B2CCreditCardRadioButton")
    public WebElement creditCardButton;

    @FindBy(id = "AIRcname_0")
    public WebElement creditCardName;

    @FindBy(id = "cbRules")
    public WebElement checkTermsAndConditions;

    @FindBy(id = "btnCreateBooking")
    public WebElement bookNowButton;


    @FindBy(id = "seatSelectionBtn")
    public WebElement selectSeatButton;

    @FindBy(css = "div[data-tab=\"flight-tab-0\"] div.seat-group-row > span:first-of-type")
    public List<WebElement> windowSeatList;

    @FindBy(css = "[data-paxnumber]")
    public List<WebElement> passengerSeatSelectionList;

    @FindBy(className = "total-price")
    public WebElement totalPrice;

}
