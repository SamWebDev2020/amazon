package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Automate_nested_frames_text {
    ChromeDriver driver;
    public Automate_nested_frames_text()
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
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        Thread.sleep(2000);
        WebElement frame_top = driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(frame_top);
        List<String> frameNames = new ArrayList<>();
        frameNames.add("frame-left");
        frameNames.add("frame-middle");
        frameNames.add("frame-right");
        for(String frames : frameNames){
            WebElement frame2 = driver.findElement(By.name(frames));
            driver.switchTo().frame(frame2);
            System.out.println(driver.findElement(By.tagName("body")).getText());
            driver.switchTo().parentFrame();
        }
        driver.switchTo().defaultContent();
        WebElement frame_bottom = driver.findElement(By.name("frame-bottom"));
        driver.switchTo().frame(frame_bottom);
        System.out.println(driver.findElement(By.tagName("body")).getText());
            System.out.println("end Test case: testCase01");
    }
}
