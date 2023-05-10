package com.lufthansa.pages;

import com.lufthansa.elements.ClientInformationElements;
import com.lufthansa.elements.NavigationBarElements;
import com.lufthansa.globals.Globals;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.lang.module.FindException;
import java.util.List;
import java.util.Random;

public class ClientInformationPage {
    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    ClientInformationElements clientInformationElements= new ClientInformationElements();

    public ClientInformationPage(){
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    public void getUrl(String url){
        BaseInformation.getDriver().get(url);
    }

    public void selectDay(int index) {
        Select select = new Select(clientInformationElements.birthdayDay.get(index));
        String indexstr = Integer.toString(index);
        String selector = "[id^=bdate_d_"+indexstr+"]>option";
        List<WebElement> options = BaseInformation.getDriver().findElements(By.cssSelector(selector));
        select.selectByIndex(getRandomInt(options.size()-1));
    }
    public void selectMonth(int index) {
        Select select = new Select(clientInformationElements.birthdayMonth.get(index));
        String indexstr = Integer.toString(index);
        String selector = "[id^=bdate_m_"+indexstr+"]>option";
        List<WebElement> options = BaseInformation.getDriver().findElements(By.cssSelector(selector));
        select.selectByIndex(getRandomInt(options.size()-1));

    }
    public String selectYear(int index) {
        Select select = new Select(clientInformationElements.birthdayYear.get(index));
        String indexstr = Integer.toString(index);
        String selector = "[id^=bdate_y_"+indexstr+"]>option";
        List<WebElement> options = BaseInformation.getDriver().findElements(By.cssSelector(selector));
        int selectindex = getRandomInt(options.size()-1);
        select.selectByIndex(selectindex);
        return clientInformationElements.birthdayYear.get(index).getAttribute("value");
    }

    public void setName(int index){
        basePageObject.getWaitUtils().waitForElementVisible(clientInformationElements.clientName.get(index));
        basePageObject
                .getWebElementUtils().scrollToElement(clientInformationElements.clientName.get(index));
        basePageObject
                .getWebElementUtils().clickWebElement(clientInformationElements.clientName.get(index));
        basePageObject
                .getWebElementUtils().sendKeysToElementWithWait(clientInformationElements.clientName.get(index),Globals.names.get(index),10);

    }
    public void setLastName(int index){
        basePageObject
                .getWebElementUtils().scrollToElement(clientInformationElements.clientLastName.get(index));
        basePageObject
                .getWebElementUtils().clickWebElement(clientInformationElements.clientLastName.get(index));
        basePageObject
                .getWebElementUtils().sendKeysToElementWithWait(clientInformationElements.clientLastName.get(index),Globals.lastNames.get(index),10);
    }

    public void setEmail(){
        if (!clientInformationElements.clientEmail.getAttribute("value").contains(Globals.email)) {
            basePageObject
                    .getWebElementUtils().scrollToElement(clientInformationElements.clientEmail);
            basePageObject
                    .getWebElementUtils().sendKeysToElementWithWait(clientInformationElements.clientEmail,Globals.email,10);
        }
    }
    public void setConfirmationEmail(){
        if (!clientInformationElements.clientConfirmatioEmail.getAttribute("value").contains(Globals.email)) {
            basePageObject
                    .getWebElementUtils().scrollToElement(clientInformationElements.clientConfirmatioEmail);
            basePageObject
                    .getWebElementUtils().sendKeysToElementWithWait(clientInformationElements.clientConfirmatioEmail,Globals.email,10);
        }
    }
    public void setPhoneNumber(){
        if (!clientInformationElements.clientPhoneNumber.getAttribute("value").contains(Globals.phone)) {
            basePageObject
                    .getWebElementUtils().scrollToElement(clientInformationElements.clientPhoneNumber);
            basePageObject
                    .getWebElementUtils().sendKeysToElementWithWait(clientInformationElements.clientPhoneNumber,Globals.phone,10);
        }
    }



    public void fillClientInfo() {
        basePageObject.getWaitUtils().waitForElementclicableWithCustomTime(1000,clientInformationElements.clientPhoneNumber);


        basePageObject.getWebElementUtils().clickWebElement(clientInformationElements.formClientOpener.get(0));

        for (int i=0 ; i<clientInformationElements.formClientOpener.size();i++) {

            basePageObject.getWebElementUtils().scrollToElement(clientInformationElements.formClientOpener.get(i));

           basePageObject.getWebElementUtils().moveMouseToElement(clientInformationElements.formClientOpener.get(i));

           basePageObject.getWebElementUtils().clickWebElement(clientInformationElements.formClientOpener.get(i));

            String text = clientInformationElements.formClientOpener.get(i).getText();
            System.out.println("Adding "+ text + " information..");

            setName(i);
            setLastName(i);
            selectMonth(i);
            selectDay(i);
            String year = selectYear(i);
            if (text.contains("Adult")) {
                setEmail();
                setConfirmationEmail();
                setPhoneNumber();
            }
            if (text.contains("Child")){
                Globals.childrenBirthday.add(year);
            }
        }
    }

    public static int getRandomInt(int index) {
        Random random = new Random();
        return random.nextInt(index) + 1;
    }

    public void clickCreditCardOption(){
        basePageObject
                .getWebElementUtils()
                .scrollToElement(clientInformationElements.creditCardButton);
        clientInformationElements.creditCardButton.click();
    }
    public void clickTermsAndConditions(){
        basePageObject
                .getWebElementUtils()
                .scrollToElement(clientInformationElements.checkTermsAndConditions);
        clientInformationElements.checkTermsAndConditions.click();
    }

    public void clickBookNow(){
        Assert.assertTrue(compareTotalPrice(clientInformationElements.totalPrice.getText(),3500000));
        clickTermsAndConditions();
        basePageObject
                .getWebElementUtils().scrollToElement(clientInformationElements.bookNowButton);
        clientInformationElements.bookNowButton.click();
    }


    public void setCreditCardNumber(){
        basePageObject
                .getWebElementUtils().clickWebElement(clientInformationElements.creditCardNumber);
        basePageObject
                .getWebElementUtils().sendKeysToElementWithWait(clientInformationElements.creditCardNumber, Globals.CreditCardNumber,100);
    }
    public void setCreditCardName(){
        basePageObject
                .getWebElementUtils().clickWebElement(clientInformationElements.creditCardName);
        basePageObject
                .getWebElementUtils().sendKeysToElementWithWait(clientInformationElements.creditCardName, Globals.HolderName,100);
    }
    public void setCVCNumber(){
        basePageObject
                .getWebElementUtils().clickWebElement(clientInformationElements.cvcNumber);
        basePageObject
                .getWebElementUtils().sendKeysToElementWithWait(clientInformationElements.cvcNumber, Globals.CVC,100);
    }
    public void setBillingAdress(String str){
        basePageObject
                .getWebElementUtils().clickWebElement(clientInformationElements.billingAdress);
        basePageObject
                .getWebElementUtils().sendKeysToElementWithWait(clientInformationElements.billingAdress,str,100);
    }
    public void setBillingCity(String str){
        basePageObject
                .getWebElementUtils().clickWebElement(clientInformationElements.billingCity);
        basePageObject
                .getWebElementUtils().sendKeysToElementWithWait(clientInformationElements.billingCity,str,100);
    }

    public void setZipCode(String str){
        basePageObject
                .getWebElementUtils().clickWebElement(clientInformationElements.zipCode);
        basePageObject
                .getWebElementUtils().sendKeysToElementWithWait(clientInformationElements.zipCode,str,100);
    }


    public void selectExpirationMonth(String str) {
        Select select = new Select(clientInformationElements.expirationMonth);
        int index = Integer.parseInt(str);
        select.selectByIndex(index);
    }
    public void selectExpirationYear(String str) {
        Select select = new Select(clientInformationElements.expirationYear);
        select.selectByValue(str);
    }
    public void fillCreditCardInfo(){
        clickCreditCardOption();
        setCreditCardNumber();
        setCreditCardName();
        setCVCNumber();
        selectExpirationMonth(Globals.ExpirationMonth);
        selectExpirationYear(Globals.ExpirationYear);
        setBillingAdress("NY");
        setBillingCity("NY");
        setZipCode("1001");
    }

    public void setCVVcode(String str){
        basePageObject
                .getWebElementUtils()
                .scrollToElement(clientInformationElements.cvvNumber);
        basePageObject
                .getWebElementUtils().moveMouseToElement(clientInformationElements.cvvNumber);
        basePageObject
                .getWebElementUtils()
                .clickWebElement(clientInformationElements.cvvNumber);
        basePageObject
                .getWebElementUtils()
                .sendKeysToElementWithWait(clientInformationElements.cvvNumber,str,100);
    }

    public void openSeatSelection(){
        basePageObject
                .getWebElementUtils()
                .scrollToElement(clientInformationElements.selectSeatButton);
        clientInformationElements.selectSeatButton.click();
    }

    public void selectCustomSeat(String str){
        openSeatSelection();
        basePageObject
                .getWaitUtils()
                .waitForElementPresent(10000,clientInformationElements.windowSeatList.get(0));

        String selectorSeat = "div[data-tab=\"flight-tab-0\"] div.seat-group-row span[data-code=\""+str+"\"]";

        WebElement selectedSeat = BaseInformation.getDriver().findElement(By.cssSelector(selectorSeat));

        for (int i = 0 ;i< clientInformationElements.passengerSeatSelectionList.size();i++){

            basePageObject
                        .getWebElementUtils()
                                .javaScriptClick(clientInformationElements.passengerSeatSelectionList.get(i));

            if (selectedSeat.getAttribute("class").contains("seat--available")
            &&!selectedSeat.getAttribute("class").contains("seat--passenger"))
            {
                basePageObject
                        .getWebElementUtils()
                                .javaScriptClick(selectedSeat);

                System.out.println("Desired seat " + str + "selected");


            } else if(selectedSeat.getAttribute("class").contains("seat--passenger")){

                WebElement neighbourSeat = selectedSeat.findElement(By.xpath("following-sibling::span[1]"));

               if (neighbourSeat.isDisplayed() && neighbourSeat.getAttribute("class").contains("seat--available")
                    && !neighbourSeat.getAttribute("class").contains("seat--passenger")){
                   basePageObject
                           .getWebElementUtils()
                                .javaScriptClick(neighbourSeat);

               }
               else if(clientInformationElements.passengerSeatSelectionList.size()>2){
                   checkSeatAndClick();}

            }   else checkSeatAndClick();


    }
    basePageObject
            .getWebElementUtils()
            .javaScriptClick(BaseInformation
                    .getDriver()
                    .findElement(By.cssSelector("button.ui.blue.button.save-seats")));
}

        public void checkSeatAndClick(){
            for (int j = 0 ;j< clientInformationElements.windowSeatList.size();j++) {

                if (clientInformationElements.windowSeatList.get(j).getAttribute("class").contains("seat--passenger")){


                    WebElement neighbourSeat = clientInformationElements.windowSeatList.get(j).findElement(By.xpath("following-sibling::span[1]"));

                    if (!neighbourSeat.getAttribute("class").contains("seat--passenger")
                        &&neighbourSeat.getAttribute("class").contains("seat--available")){

                        basePageObject
                                .getWebElementUtils()
                                .javaScriptClick(neighbourSeat);
                        break;
                    }
                }
                if (clientInformationElements.windowSeatList.get(j).getAttribute("class").contains("seat--available")
                    &&!clientInformationElements.windowSeatList.get(j).getAttribute("class").contains("seat--passenger")) {

                    basePageObject
                            .getWebElementUtils()
                            .javaScriptClick(clientInformationElements.windowSeatList.get(j));
                    break;
                }
            }

        }

    public static boolean compareTotalPrice(String price, double value) {
        String priceWithoutDollar = price.replace("$", "");
        String priceWithoutComma= priceWithoutDollar.replace(",","");
        double priceValue = Double.parseDouble(priceWithoutComma);
        return priceValue < value;
    }
}

