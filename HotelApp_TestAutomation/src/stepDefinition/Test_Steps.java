package stepDefinition;
 
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import cucumber.api.java.Before;
 
public class Test_Steps {
	public static WebDriver driver;
	
	@Before
	public void before(Scenario scenario) {
		System.out.println("------------------------------");
        System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        System.out.println("------------------------------");
		System.out.println("SCENARIO STARTED");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\User\\Desktop\\selenium 3 installs\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }	
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		
	    driver.get("http://www.store.demoqa.com");
	}
 
	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	}
 
	@When("^User enters Credentials to LogIn$")
	public void user_enters_testuser__and_Test(DataTable usercredentials) throws Throwable {
		List<List<String>> data = usercredentials.raw();
		driver.findElement(By.id("log")).sendKeys(data.get(0).get(0)); 
	    driver.findElement(By.id("pwd")).sendKeys(data.get(0).get(1));
	    driver.findElement(By.id("login")).click();
	}
 
	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Login Successfully");
	}
	
	@After
	public void after(Scenario scenario) {
		driver.quit();
		System.out.println("------------------------------");
        System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        System.out.println("------------------------------");
    }
	
	
}