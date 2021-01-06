package stepDefinitions;

import org.junit.Assert;
import org.apache.log4j.xml.DOMConfigurator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import helpers.TestContext;
import pageObjects.HomePage;
import helpers.Log;
public class HomePageSteps {

	TestContext testContext;
	HomePage homePage;


	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@Given("^I visit the demoblaze home page$")
	public void i_visit_the_demoblaze_home_page() throws Throwable {
		homePage.navigateToLoginPage();
	}
	
	@When("^I click on \"([^\"]*)\"$")
	public void i_click_on(String name) throws Throwable {
		homePage.selectCatogories(name);
	
	}
	
	@When("^I added \"([^\"]*)\" to add to cart$")
	public void i_added_to_add_to_cart(String item) throws Throwable {
		homePage.selectItems(item);
		homePage.navigateToLoginPage();

	}
	
	@When("^I added another \"([^\"]*)\" to add to cart$")
	public void i_added_another_to_add_to_cart(String prod) throws Throwable {
		homePage.selectCatogories("Laptops");
		homePage.selectItems(prod);

	}
	
	@When("^I deleted \"([^\"]*)\" from cart$")
	public void i_deleted_from_cart(String arg1) throws Throwable {
		homePage.navigateToCart();
		homePage.deleteCart();
	    
	}
	
	@When("^I click at Places order$")
	public void i_click_at_Places_order() throws Throwable {
		String TotalpurchaseAmount = homePage.getPriceAtCart();
		System.out.println("Total purchase amount is: " + TotalpurchaseAmount);
		testContext.scenarioContext.setContext(Context.PURCHASE_AMOUNT_AT_CART, TotalpurchaseAmount);
	    homePage.clickAtPlaceOrder();
	  
	}

	@When("^I fill all the required field$")
	public void i_fill_all_the_required_field() throws Throwable {
		homePage.fillAllRequiredField();
	}

	@When("^I click at Purchase order$")
	public void i_click_at_Purchase_order() throws Throwable {
	    homePage.clickAtPurchase();
	}

	@When("^I collect the purchase id and amount$")
	public void i_collect_the_purchase_id_and_amount() throws Throwable {
		String acutal_purchase = homePage.getPurchaseIdAndAmount();
		testContext.scenarioContext.setContext(Context.PURCHASE_AMOUNT_AT_PURCHASE, acutal_purchase);
		System.out.println(acutal_purchase);

	}

	@Then("^I should see expected amount$")
	public void i_should_see_expected_amount() throws Throwable {
		String expected_purchase_amount = (String)testContext.scenarioContext.getContext(Context.PURCHASE_AMOUNT_AT_CART);
		String actual_purchase_amount = (String)testContext.scenarioContext.getContext(Context.PURCHASE_AMOUNT_AT_PURCHASE);
        Assert.assertTrue("Amount is not correct at purchase", actual_purchase_amount.contains(expected_purchase_amount));
	    
	}

	@When("^I click Ok$")
	public void i_click_Ok() throws Throwable {
	   homePage.clickAtOkbtn();
	}
	
	

}
