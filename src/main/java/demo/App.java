/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        TestCases tests = new TestCases(); // Initialize your test class
        Automate_count_hyperlinks hyperlink_count = new Automate_count_hyperlinks();
        Automate_post_on_linkedin linkedin = new Automate_post_on_linkedin();
//        //TODO: call your test case functions one after other here
        Automate_image_urls images = new Automate_image_urls();
        Automate_nested_frames_text frames = new Automate_nested_frames_text();
        Automate_imdb_ratings imdb = new Automate_imdb_ratings();
        Automate_window_handle window = new Automate_window_handle();
//
        tests.testCase01();
        tests.endTest(); // End your test by clearning connections and closing browser
        hyperlink_count.testCase01();
        hyperlink_count.endTest();
        linkedin.testCase01();
        linkedin.endTest();
        images.testCase01();
        images.endTest();
        frames.testCase01();
        frames.endTest();
        imdb.testCase01();
        imdb.endTest();
        window.testCase01();
        window.endTest();

    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}
