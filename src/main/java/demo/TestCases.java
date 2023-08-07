package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        driver.findElement(By.id("APjFqb")).sendKeys("amazon");
        driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).click();
        Thread.sleep(3000);
        List<WebElement> searchResults = driver.findElements(By.cssSelector("div.g"));
            for (WebElement result : searchResults) {
                // Check if the result contains "amazon.in" or "amazon.com"
                if (result.getText().contains("amazon.in") || result.getText().contains("amazon.com")) {
                    System.out.println("Search result contains 'amazon.in' or 'amazon.com'. Test passed.");
                    break;
                }
            }else {
                System.out.println("Search result does not contain 'amazon.in' or 'amazon.com'. Test failed.");
            }
    
        System.out.println("end Test case: testCase01");
    }




}
