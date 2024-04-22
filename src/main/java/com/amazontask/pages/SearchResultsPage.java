package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
    private WebDriver driver;

    // Locate elements on the page using @FindBy annotations
    @FindBy(css = "div[data-cy='title-recipe'] h2 a span")
    private WebElement firstResultTitle;

    @FindBy(css = "a[href*='Cursed-Child-Playscript'][class*='a-link-normal']")
    private WebElement paperbackOption;

    @FindBy(css = "div[data-cy='price-recipe'] a.a-size-base.a-link-normal.s-underline-text.s-underline-link-text.s-link-style")
    private WebElement price;

    @FindBy(css = "span.a-icon-alt")
    private WebElement rating;

    @FindBy(css = "a[href*='customerReviews']")
    private WebElement customerReviewsCount;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstResultTitleText() {
        return firstResultTitle.getText();
    }

    public boolean isFirstResultTitleCorrect(String expectedTitle) {
        return getFirstResultTitleText().contains(expectedTitle);
    }

    public boolean isPaperbackAvailable() {
        return paperbackOption.isDisplayed() && paperbackOption.getText().contains("Paperback");
    }

    public String getPriceText() {
        return price.getText();
    }

    public String getRatingText() {
        return rating.getAttribute("aria-label");
    }

    public String getCustomerReviewsCountText() {
        return customerReviewsCount.getText();
    }

    // More methods can be added to perform further checks like availability, delivery options, etc.

    // ... other methods as per your test scenarios
}
