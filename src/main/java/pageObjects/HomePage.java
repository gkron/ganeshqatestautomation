package pageObjects;

import java.util.List;
import javax.xml.xpath.XPath;
import helpers.Wait;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import helpers.Log;

import managers.FileReaderManager;

public class HomePage {
	WebDriver driver;


	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		DOMConfigurator.configure("log4j.xml");

	}
	

	@FindAll({@FindBy(xpath=".//*[contains(@id,'itemc')]")})
	List<WebElement> catogories;
	
	@FindAll({@FindBy(xpath=".//*[@class='hrefch']")})
	List<WebElement> all_items;
	
	@FindBy(xpath=".//a[text()='Add to cart']")
	WebElement addToCart;
	
	@FindBy(xpath=".//a[text()='Cart']")
	WebElement cart;
	
	@FindBy(xpath=".//td[text()='Dell i7 8gb']/following::a[1]")
	WebElement deleteCart;
	
	@FindBy(xpath=".//button[text()='Place Order']")
	WebElement placeOrder;
	
	@FindBy(xpath="(.//tr[@class='success']/td)[3]")
	WebElement  priceAtCart;
	
	@FindBy(xpath=".//input[@id='name']")
	WebElement name;
	@FindBy(xpath=".//input[@id='country']")
	WebElement country;
	@FindBy(xpath=".//input[@id='city']")
	WebElement city;
	@FindBy(xpath=".//input[@id='card']")
	WebElement card;
	@FindBy(xpath=".//input[@id='month']")
	WebElement month;
	@FindBy(xpath=".//input[@id='year']")
	WebElement year;
	@FindBy(xpath=".//button[text()='Purchase']")
	WebElement purchase_btn;
	@FindBy(xpath=".//*[contains(@class,'lead text-muted')]")
	WebElement logMsg;
	@FindBy(xpath=".//button[text()='OK']")
	WebElement OK_btn;
   
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void navigateToLoginPage() throws InterruptedException {
		Log.info("Naviate to application homepage");
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		Wait.untilPageLoadComplete(driver);

	}
	
	public void selectCatogories(String cat) throws InterruptedException {
		Log.info("Selectig Laptop option from categories");
		for(WebElement el: catogories) {
			if(el.getText().equalsIgnoreCase(cat)) {
				el.click();
			    Wait.staticWait(3000);


			}
		}
	}
	
	public void selectItems(String item) throws InterruptedException {
		Log.info("Selectig products from laptop page");
		for(WebElement el: all_items) {
			if(el.getText().equalsIgnoreCase(item)) {
				el.click();
				//Wait.untilJqueryIsDone(driver);
				addToCart.click();
			    Wait.staticWait(3000);
	      		Alert simpleAlert = driver.switchTo().alert();
				simpleAlert.accept();
			    Wait.staticWait(3000);

				break;
				
			}
		}
	}
	
	public void navigateToCart() throws InterruptedException {
		Log.info("Navigate to cart page");
		cart.click();
		Wait.untilPageLoadComplete(driver);
		Wait.staticWait(2000);

	}
	
	public void deleteCart() throws InterruptedException {
		Log.info("delete product from cart page");
		deleteCart.click();
		Wait.untilJqueryIsDone(driver);

		
	}
	
	public String getPriceAtCart() {
		Log.info("Gettings the total price count at cart page");
		return priceAtCart.getText();
	}
	
	public void clickAtPlaceOrder() throws InterruptedException {
		Log.info("Clicking at Placeorder");
		placeOrder.click();
		Wait.untilPageLoadComplete(driver);
	}
	
	public void fillAllRequiredField() throws InterruptedException {
		Log.info("Filling all the requiredfield at forms");
	    Wait.staticWait(2000);
		name.sendKeys(FileReaderManager.getInstance().getConfigReader().getName());
		country.sendKeys(FileReaderManager.getInstance().getConfigReader().getcountry());
		city.sendKeys(FileReaderManager.getInstance().getConfigReader().getcity());
		card.sendKeys(FileReaderManager.getInstance().getConfigReader().getCartDeatils());
		month.sendKeys(FileReaderManager.getInstance().getConfigReader().getMonth());
		year.sendKeys(FileReaderManager.getInstance().getConfigReader().getYear());
	    Wait.staticWait(1000);
		Wait.untilPageLoadComplete(driver);


	}
	
	public void clickAtPurchase() throws InterruptedException {
		Log.info("Clicking at purchase order");
		purchase_btn.click();
		Wait.untilPageLoadComplete(driver);

	}
	
	public String getPurchaseIdAndAmount() {
		return logMsg.getText();
	}
	
	public void clickAtOkbtn() {
		Log.info("Clicing at Ok Button");
		OK_btn.click();
		Wait.untilPageLoadComplete(driver);

	}
	
}
