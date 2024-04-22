import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {
    public static void main(String[] args) {
        ConfigLoader configLoader = new ConfigLoader();
        WebDriver driver = new ChromeDriver();
        driver.get(configLoader.getSiteUrl());

        HomePage homePage = new HomePage(driver);
        homePage.enterSearchTerm("Harry Potter and the Cursed Child");
        homePage.clickSearchButton();

        // Continue with the rest of the test

        driver.quit();
    }
}
