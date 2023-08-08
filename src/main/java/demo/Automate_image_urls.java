package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Automate_image_urls {
    ChromeDriver driver;
    public Automate_image_urls()
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
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(2000);
        List<WebElement> results = driver.findElements(By.xpath("//*[text()='Recommended Movies']/../../../..//img"));
        for(WebElement res : results){
            System.out.println(res.getAttribute("src"));
        }
        System.out.println(driver.findElement(By.xpath("(//*[text()='Premieres']/../../../..//following-sibling::div[2]/div[1]/div)[2]")).getText());
        System.out.println(driver.findElement(By.xpath("(//*[text()='Premieres']/../../../..//following-sibling::div[2]/div[2]/div)[2]")).getText());
        System.out.println("end Test case: testCase01");
    }
}
