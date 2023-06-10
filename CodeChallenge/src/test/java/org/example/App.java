package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class App
{
    public static void main( String[] args )
    {

        FirefoxOptions firefoxOptions = new FirefoxOptions();

        firefoxOptions.addArguments("start-maximized");

        // instanciar nuestro web driver manager

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://www.saucedemo.com/");

        // TEST CASE 1 - LOG IN
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        // TEST CASE 2 - ADD TO CART

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        // TEST CASE 3 - NAVIGATE TO SHOPPING CART
        driver.findElement(By.id("shopping_cart_container")).click();

        // TEST CASE 4 - REMOVE FROM CART
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        driver.findElement(By.id("checkout")).click();

    }
}
