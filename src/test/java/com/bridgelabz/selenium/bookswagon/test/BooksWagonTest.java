package com.bridgelabz.selenium.bookswagon.test;

import com.bridgelabz.selenium.bookswagon.base.BaseClass;
import com.bridgelabz.selenium.bookswagon.pages.DashBoardPage;
import com.bridgelabz.selenium.bookswagon.pages.Login;
import com.bridgelabz.selenium.bookswagon.utility.CustomListener;
import com.bridgelabz.selenium.bookswagon.utility.DataProviderClass;
import com.bridgelabz.selenium.bookswagon.utility.Operations;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


@Listeners(CustomListener.class)
public class BooksWagonTest extends BaseClass{
    String username = "amarprajapati99@gmail.com";
    String password = "amarprajapati91";


    @Test(priority = 1)
    public void login_to_application() throws InterruptedException {

        Login login = new Login(driver);
        login.login_to_application_with_valid_credential(username, password);
    }


    @Test(priority = 2,dataProvider = "testDataSetFromExcelFile", dataProviderClass = DataProviderClass.class)
    public void login_to_application_using_dataProvider_data(String emailId, String passwd) throws InterruptedException {

        Login login = new Login(driver);
        login.login_to_application_with_valid_credential(emailId, passwd);
        DashBoardPage dashBoardPage = new DashBoardPage (driver);
        dashBoardPage.logout_from_account();
        String expectedUrl = "https://www.bookswagon.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Test(priority = 3)
    public void login_to_application_get_login_credential_from_object_repo() throws InterruptedException, IOException {

        Login login = new Login(driver);
        String actual = login.login_to_application_from_object_repo_lib();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual, expected);
        System.out.println("You're successfully logged in..!!");
    }

    @Test(priority = 4)
    public void login_test() throws InterruptedException {

        Login login = new Login(driver);
        String actual = login.login_to_application_with_valid_credential(username, password);
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual, expected);
        System.out.println("You're successfully logged in..!!");
    }

    @Test(priority = 5)
    public void add_to_wishlist_test() throws InterruptedException {

        Login login = new Login(driver);
        login.login_to_application_with_valid_credential(username, password);
        DashBoardPage dashBoardPage = new DashBoardPage (driver);
        String actual = dashBoardPage.add_to_cart();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual, expected);
        System.out.println("Book is added to cart is successfully!!");
    }

    @Test(priority = 6)
    public void place_order_test() throws InterruptedException {

        Operations operations = new Operations(driver);
        String act_title = operations.buy_book();
        String exp_title = "Bookswagon.com: Buy Books Online: Bookstore in India: Highest Discount";
        Assert.assertEquals(act_title, exp_title);
    }
    @Test(priority = 7)
    public void search_book_test() throws InterruptedException {

        login_to_application();
        Operations operations = new Operations(driver);
        String actual = operations.add_to_wishlist_books();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void buy_book_before_login() throws InterruptedException, IOException {

        Operations operations = new Operations(driver);
        String act_title = operations.buy_test();
        String exp_title = "Bookswagon.com: Buy Books Online: Bookstore in India: Highest Discount";
        Assert.assertEquals(act_title, exp_title);
    }

    @Test(priority = 8)
    public void remove_book_test() throws InterruptedException {

        login_to_application();
        Operations operations = new Operations(driver);
        String actual_title = operations.remove_from_cart();
        String expected_title = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual_title, expected_title);
        System.out.println("book is removed successfully");
    }

    @Test(priority = 9)
    public void search_book_before_login_test() throws InterruptedException {

        Operations operations = new Operations(driver);
        String actual = operations.add_to_wishlist_books();
        login_to_application();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual, expected);
    }
}