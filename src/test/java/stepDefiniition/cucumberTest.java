package stepDefiniition;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class cucumberTest {

	WebDriver driver = null;

	@Given("user is on login page")

	/*
	 * This method is to land user in the log in page
	 * 
	 * @parameter null
	 * 
	 * @return -
	 */
	public void user_is_on_login_page() {
		String driverPath = System.getProperty("usr.dir");
		System.getProperty("webdriver.chrome.driver", driverPath + "src/test/resources/driver/chromedriver.exe");
		// Initialize the driver
		driver = new ChromeDriver();
		// User in login page.
		driver.get("https://practicetestautomation.com/practice-test-login/");
		// Maximize the window
		driver.manage().window().maximize();
		System.out.println("Inside User login page method");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		System.out.println("<---Starting the test Scenerio--->");
		// Store the user name and password in an variable.
		String username = driver.findElement(By.xpath("/html/body/div[1]/div/section/section/ul/li[2]/b[1]\r\n"))
				.getText();
		String password = driver.findElement(By.xpath("/html/body/div[1]/div/section/section/ul/li[2]/b[2]\r\n"))
				.getText();
		// Pass the user name and password into the input fields
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		System.out.println("Inside username and password method");
	}

	@When("clicks on submit button")
	public void clicks_on_submit_button() {
		// Click the submit button
		driver.findElement(By.id("submit")).click();
		System.out.println("Inside Submit button method");
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		// Check of the user is navigated to home page
		String actual_page_title = "Logged In Successfully | Practice Test Automation";
		// Storing the page title.
		String pageTitle = driver.getTitle();
		// Compares the tile retrieved from web page with the predefined one.
		pageTitle.trim().equalsIgnoreCase(actual_page_title);
		// Close the browser.
		driver.close();
		// Sysout statements for logging purpose.
		System.out.println("<---The testing is successful--->");
		System.out.println("Inside navigated to home page method");
	}

}
