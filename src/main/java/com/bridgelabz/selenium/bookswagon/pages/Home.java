package com.bridgelabz.selenium.bookswagon.pages;

import com.bridgelabz.selenium.bookswagon.base.BaseClass;
import com.bridgelabz.selenium.bookswagon.utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Home extends BaseClass{

    @FindBy (xpath = "//a[@class='sprite home-ico toplevel oneline']")
    WebElement home;

    @FindBy (xpath = "//div[@class='books-category']//a[normalize-space()='Computer & Internet']")
    WebElement computer_nd_internet;

    @FindBy (xpath = "//a[normalize-space()='Applied Data Science Using Pyspark']")
    WebElement book;

    @FindBy (xpath = "//input[@value='Add to Wishlist']")
    WebElement add_to_wishlist;

    @FindBy (xpath = "//div[@id='cboxClose']")
    WebElement checkbox;

    @FindBy (xpath = "//span[@class='cart-item-count']")
    WebElement cart;

    @FindBy (xpath = "//span[@class='login-bg sprite usermenu-bg']")
    WebElement myProfile;
    @FindBy (xpath = "//a[normalize-space()='Log out']")
    WebElement logout;

    public Home (WebDriver driver) {
        PageFactory.initElements (driver, this);
    }

    public String add_to_cart () throws InterruptedException {
        Log.info ("click on home icon");
        home.click ();
        Thread.sleep (1000);
        Log.info ("click on category");
        computer_nd_internet.click ();
        Thread.sleep (1000);
        Log.info ("click on books");
        book.click ();
        Thread.sleep (2000);
        Log.info ("click on add to wishlist");
        add_to_wishlist.click ();
        Thread.sleep (4000);
        Log.info ("click on card");
        cart.click ();
        Thread.sleep (3000);
        Log.info ("click on checkbox button");
        checkbox.click ();
        Thread.sleep (3000);
        return driver.getTitle ();
    }

    public void logout_from_account () throws InterruptedException {
        Thread.sleep (4000);
        Actions actions = new Actions (driver);
        //Hovering on my account menu
        Log.info ("Mouse hovering on my account menu");
        actions.moveToElement (myProfile);
        Thread.sleep (300);
        //To mouseover on sub Logout button menu and click
        Log.info ("mouse hovering on logout sub menu");
        actions.moveToElement (logout).build ().perform ();
        Log.info ("Clicking on sub menu logout");
        logout.click ();
        Log.info ("you're logout successfully");
        Thread.sleep (400);
    }
}