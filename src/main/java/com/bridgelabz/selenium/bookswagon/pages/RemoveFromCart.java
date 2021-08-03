package com.bridgelabz.selenium.bookswagon.pages;

import com.bridgelabz.selenium.bookswagon.base.BaseClass;
import com.bridgelabz.selenium.bookswagon.utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RemoveFromCart extends BaseClass{

    @FindBy(xpath = "//input[@id='ctl00_TopSearch1_txtSearch']")
    WebElement searchBar;

    @FindBy(xpath = "//input[@id='ctl00_TopSearch1_Button1']")
    WebElement searchEnter;

    @FindBy(xpath = "//div[@id='listSearchResult']")
    List<WebElement> searchList;

    @FindBy(xpath = "/html/body/form/div[4]/div[2]/div[3]/div[2]/div[2]/div[4]/div[5]/a[1]/input")
    WebElement buy_now;

    @FindBy (xpath = "//a[normalize-space()='Remove']")
    WebElement remove_from_cart;

    public RemoveFromCart(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String removeFromCart() throws InterruptedException {

        Log.info("Remove from the cart");
        searchBar.click();

        Thread.sleep(1000);
        searchBar.sendKeys("C++");

        Thread.sleep(2000);
        searchEnter.click();

        Thread.sleep(1000);
        System.out.println(searchList.size());

        Thread.sleep(2000);
        searchList.get(0).click();

        Thread.sleep(4000);
        buy_now.click();

        Thread.sleep(3000);
        driver.switchTo().frame(0);

        Thread.sleep(3000);
        remove_from_cart.click();

        Thread.sleep(2000);
        return driver.getTitle();
    }
}

