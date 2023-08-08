package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Automate_post_on_linkedin {
    ChromeDriver driver;
    public Automate_post_on_linkedin()
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
        driver.get("https://in.linkedin.com/");
        driver.findElement(By.id("session_key")).sendKeys("smlgeorge13@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("S@mN0v_1190");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("(//span[@class='feed-identity-widget-item__stat'])[1]")).getText());
//        System.out.println(driver.findElement(By.xpath("(//span[@class='feed-identity-widget-item__stat'])[2]")).getText());
        driver.findElement(By.cssSelector("button.share-box-feed-entry__trigger")).click();
        driver.findElement(By.cssSelector("button.share-unified-settings-entry-button")).click();
        driver.findElement(By.id("CONNECTIONS_ONLY")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Done']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div.ql-editor")).sendKeys("Automation Testing");
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        Thread.sleep(3000);
        String str = driver.findElement(By.xpath("(//div[@class='update-components-text relative feed-shared-update-v2__commentary '])[1]")).getText();
        if(str.equals("Automation Testing")){
            System.out.println("test case passed");
        }else{
            System.out.println("test case failed");
        }
        System.out.println("end Test case: testCase01");
    }

}
