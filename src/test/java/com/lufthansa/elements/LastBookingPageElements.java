package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LastBookingPageElements {
    public LastBookingPageElements(){

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(css = "div.ref_num_btn > h2")
    public WebElement bookingReferenceText;

    @FindBy(css = "div.ref_num_btn span")
    public WebElement bookingReferenceCode;
    //div[@class='ui segment white']//table[@class='ui single line table']//td[2]
    @FindBy(css = "div.ui.segment.white table.ui.single.line.table td:nth-of-type(2)")
    public List<WebElement> displayedNames;
}
