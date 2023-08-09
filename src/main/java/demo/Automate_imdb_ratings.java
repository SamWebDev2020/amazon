package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Automate_imdb_ratings {
    ChromeDriver driver;
    public Automate_imdb_ratings()
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
        driver.get("https://www.imdb.com/chart/top");
        // Find the highest rated movie
        WebElement dropdownElement = driver.findElement(By.id("sort-by-selector")); // Replace with the actual ID

        // Initialize the Select class with the dropdown element
        Select dropdown = new Select(dropdownElement);

        // Select by visible text
        dropdown.selectByVisibleText("IMDb rating");
        WebElement highestRatedMovieElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3"));
        String highestRatedMovie = highestRatedMovieElement.getText();
        System.out.println("Highest rated movie: " + highestRatedMovie);

        // Find the number of movies in the table
        int numberOfMovies = driver.findElements(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li/div[2]/div/div/div[1]/a/h3")).size();
        System.out.println("Number of movies: " + numberOfMovies);

        // Find the oldest movie on the list

        dropdown.selectByVisibleText("Release date");
        driver.findElement(By.id("swap-sort-order-button")).click();
        WebElement oldestMovieElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3"));
        String oldestMovie = oldestMovieElement.getText();
        System.out.println("Oldest movie on the list: " + oldestMovie);

        // Find the most recent movie on the list
        driver.findElement(By.id("swap-sort-order-button")).click();
        WebElement mostRecentMovieElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3"));
        String mostRecentMovie = mostRecentMovieElement.getText();
        System.out.println("Most recent movie on the list: " + mostRecentMovie);

        // Find the movie with the most user ratings
        dropdown.selectByVisibleText("Number of ratings");
        WebElement mostUserRatingsMovieElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3"));
        String mostUserRatingsMovie = mostUserRatingsMovieElement.getAttribute("data-value");
        System.out.println("Movie with the most user ratings: #" + mostUserRatingsMovie);

        System.out.println("end Test case: testCase01");
    }
}
