package choromebrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class NopCommerce {
    // 1.Setup Chrome browser
    static String browser = "Chrome";
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        //2.Multiple browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        //3.Open URL
        driver.get(baseUrl);
        //4.Maximize the window
        driver.manage().window().maximize();
        //5.Timeout for hold the page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //6.Print the title of the page.
        System.out.println(driver.getTitle());
        //7.Print the current url.
        System.out.println(driver.getCurrentUrl());
        //8.Print the page source
        System.out.println(driver.getPageSource());
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        //9.Navigate to other URL
        driver.navigate().to(loginUrl);
        //10.Print current URL
        System.out.println("This is the current URL : " + driver.getCurrentUrl());
        //11.come back to home page
        driver.navigate().back();
        //12.come back to login page by forword arrow
        driver.navigate().forward();
        //13.Print current URL
        System.out.println("This is the current URL : " + driver.getCurrentUrl());
        //14.Refresh the page
        driver.navigate().refresh();
        //15.Enter the email to email field
        driver.findElement(By.id("Email")).sendKeys("tester@gmail.com");
        //16.Enter the password field
        driver.findElement(By.id("Password")).sendKeys("admin@123");
        //17.Click on login button
        driver.findElement(By.partialLinkText("Log in")).click();
        //18.Close the browser
        driver.quit();
    }
}

