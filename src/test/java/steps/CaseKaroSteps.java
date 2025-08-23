package steps;

import com.microsoft.playwright.*;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

import static support.CaseKaroConstants.*;

public class CaseKaroSteps {
    public static Playwright playwright;
    public static Browser browser;
    public static Page page;

    @Given("user navigates to CaseKaro website")
    public void user_navigates_to_casekaro_website() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://casekaro.com/");

    }

    @When("user click on Mobile Covers")
    public void userClickOnMobileCovers() {
        page.click(ButtonMobileCover);
    }

    @And("user click on search button and search for {string}")
    public void userClickOnSearchButtonAndSearchFor(String SearchText) {
        page.fill(Search, SearchText);
        page.waitForTimeout(2000);
    }

    @Then("user validate {string} brand results should be {string}")
    public void userValidateBrandResultsShouldBe(String brandName, String status) {
        Locator brandLocator = page.locator(String.format(BrandNameLocator, brandName));
        boolean isVisible = brandLocator.isVisible();

        if (status.equalsIgnoreCase("visible")) {
//            System.out.println("Result: " + isVisible);
            Assert.assertTrue("Expected brand '" + brandName + "' to be visible, but it was not.", isVisible);
        } else if (status.equalsIgnoreCase("not-visible")) {
//            System.out.println("Result: " + isVisible);
            Assert.assertFalse("Expected brand '" + brandName + "' to be NOT visible, but it was visible.", isVisible);
        }
    }


    @When("user click {string} brand")
    public void userClickBrand(String brandName) {

        Page newPage = page.waitForPopup(() -> {
            page.click(String.format(BrandNameLocator, brandName));   // locator of the button that opens new tab
        });
        newPage.waitForLoadState();  //  Wait until the new page is loaded
        page = newPage;

    }

    @Then("search model {string}")
    public void searchModel(String modelName) {
        page.fill(Search, modelName);
        Locator resultLocator = page.locator(String.format(ModelNameLocator, modelName));
        resultLocator.first().waitFor();   // Wait until at least one matching result is visible
        resultLocator.first().click();    // Click on the first result that matches the model name

    }

    @And("user Click Choose options for first item")
    public void userClickChooseOptionsForFirstItem() {
        page.click(ChooseOption);
    }

    @And("user adds {string} material cases to cart")
    public void userAddsMaterialCasesToCart(String caseName) {
        page.click(String.format(MaterialsLocator, caseName));
        page.click(AddToCart);
        page.waitForTimeout(3000);
        page.click(CloseCart);
        page.waitForTimeout(2000);
    }

    @When("user opens cart")
    public void userOpensCart() {
        page.click(Cart);
    }

    @Then("user validate {string} items should be present in cart")
    public void userValidateItemsShouldBePresentInCart(String materialName) {
        ElementHandle materialNameLocator = page.waitForSelector(String.format(MaterialInCart, materialName));
        boolean isVisible = materialNameLocator.isVisible();
        Assert.assertTrue("Expected material '" + materialName + "' to be visible, but it was not.", isVisible);
    }

    @And("print the price of all items with details")
    public void printThePriceOfAllItemsWithDetails() {
        int itemCount = page.locator(CartItemCount).count();

        for (int i = 0; i < itemCount; i++) {
            String material = page.locator(Material).nth(i).innerText();
            String price = page.locator(Price).nth(i).innerText();
            String link = page.locator(Link).nth(i).getAttribute("href");

            System.out.println("Item " + (i + 1) + ":");
            System.out.println("Material: " + material);
            System.out.println("Price: " + price);
            System.out.println("Link: " + "https://casekaro.com" + link);
            System.out.println("-----------------------------");
        }
    }
}