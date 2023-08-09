package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Automate_window_handle {
    ChromeDriver driver;
    public Automate_window_handle()
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


    public  void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        String mainWindowHandle = driver.getWindowHandle();
        WebElement frame = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Iterate through the window handles and switch to the new window
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                System.out.println(driver.getCurrentUrl());
                System.out.println(driver.getTitle());
//                driver.getScreenshotAs();
            }
        }
        driver.close();
        driver.switchTo().window(mainWindowHandle);

        System.out.println("end Test case: testCase01");
    }
}
