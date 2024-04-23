package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


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

    public boolean isAuthorCorrect(String expectedAuthor) {
        wait.until(ExpectedConditions.visibilityOf(authorLink));
        return authorLink.getText().contains(expectedAuthor);
    }

    public String getDeliveryDateText() {
        wait.until(ExpectedConditions.visibilityOf(deliveryInfo));
        return deliveryInfo.getText();
    }

    public String getUsedNewOfferPriceText() {
        wait.until(ExpectedConditions.visibilityOf(usedNewOfferPrice));
        return usedNewOfferPrice.getText();
    }

    public boolean isEditionFormatAvailable(String format) {
        wait.until(ExpectedConditions.visibilityOf(editionFormats));
        return editionFormats.getText().contains(format);
    }

    public boolean isRatingDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(rating));
        return rating.isDisplayed();
    }

    public boolean isReviewCountCorrect(String expectedCount) {
        wait.until(ExpectedConditions.visibilityOf(customerReviewsCount));
        return customerReviewsCount.getText().contains(expectedCount);
    }

    // Method to navigate to the detail page of the first result
    public ProductDetailPage goToFirstResultDetailPage() {
        firstResultTitle.click();
        return new ProductDetailPage(driver);
    }
}
