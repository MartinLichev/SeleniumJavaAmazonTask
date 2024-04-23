import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.amazon.pages.HomePage;
import com.amazon.pages.SearchResultsPage;

import static org.junit.Assert.*;

public class AmazonBookSearchTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @Before
    public void setUp() {
        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");  
            
        // Instantiate a ChromeDriver class.
        driver = new ChromeDriver();  

        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, 10);

        // Navigate to the test URL
        driver.get("https://www.amazon.com");
        
        // Initialize the page objects
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        
        // Enter the search term and click search button
        homePage.enterSearchTerm("Harry Potter and the Cursed Child");
        homePage.clickSearchButton();
    }

    @Test
    public void testSearchResultTitle() {
        // Verify the title of the first result
        assertTrue("Title verification failed.", 
            searchResultsPage.isFirstResultTitleCorrect("Harry Potter and the Cursed Child - Parts One and Two: The Official Playscript of the Original West End Production"));
    }

    @Test
    public void testPaperbackOptionAvailable() {
        // Verify the paperback option is available
        assertTrue("Paperback option is not available.", 
            searchResultsPage.isPaperbackAvailable());
    }

    @Test
    public void testPriceIsDisplayed() {
        // Verify the price is displayed
        assertFalse("Price is not displayed.", 
            searchResultsPage.getPriceText().isEmpty());
    }

    // More test methods can be added for additional verifications

    @After
    public void tearDown() {
        // Close the browser after test
        if (driver != null) {
            driver.quit();
        }
    }
}
