package tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Properties;
import java.io.FileInputStream;


public class IDEVerificationScript {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public Properties prop;
  
  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver","C:\\Users\\User\\Desktop\\selenium 3 installs\\geckodriver-v0.19.1-win64\\geckodriver.exe");
	prop = new Properties();
    prop.load(new FileInputStream("./SharedUIMap/SharedUIMap.properties"));
	driver = new FirefoxDriver();
    baseUrl = "http://adactin.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

  
  
  
  @Test
  public void testIDEVerificationScript() throws Exception {
    driver.get(baseUrl + "/HotelApp/");
    driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).sendKeys("ssotiriou");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Ramsbottom1");
    driver.findElement(By.id("login")).click();
   
  //check logout link is present
    try {
    	assertTrue(isElementPresent(By.linkText("Logout")));
    	System.out.println("Logout Link Test PASS");
    } catch (Error e) {
    	System.out.println("Logout Link Test FAIL");
    verificationErrors.append(e.toString());
    }
    
    new Select(driver.findElement(By.id("location"))).selectByVisibleText("Sydney");
    new Select(driver.findElement(By.id("room_nos"))).selectByVisibleText("2 - Two");
    new Select(driver.findElement(By.id("adult_room"))).selectByVisibleText("2 - Two");
    driver.findElement(By.id("Submit")).click();
    driver.findElement(By.id("radiobutton_2")).click();
    driver.findElement(By.id("continue")).click();
    driver.findElement(By.id("first_name")).clear();
    driver.findElement(By.id("first_name")).sendKeys("stelios");
    driver.findElement(By.id("first_name")).clear();
    driver.findElement(By.id("first_name")).sendKeys("s");
    driver.findElement(By.id("last_name")).clear();
    driver.findElement(By.id("last_name")).sendKeys("sot");
    driver.findElement(By.id("address")).clear();
    driver.findElement(By.id("address")).sendKeys("9 Arcadian Gardens");
    driver.findElement(By.id("address")).clear();
    driver.findElement(By.id("address")).sendKeys("9 Arcadian Gardens, Wood Green, London, N22 5AA");
    driver.findElement(By.id("cc_num")).clear();
    driver.findElement(By.id("cc_num")).sendKeys("1234567812345678");
    new Select(driver.findElement(By.id("cc_type"))).selectByVisibleText("VISA");
    new Select(driver.findElement(By.id("cc_exp_month"))).selectByVisibleText("September");
    new Select(driver.findElement(By.id("cc_exp_year"))).selectByVisibleText("2019");
    driver.findElement(By.id("cc_cvv")).clear();
    driver.findElement(By.id("cc_cvv")).sendKeys("765");
    driver.findElement(By.id("book_now")).click();
    driver.findElement(By.linkText("Logout")).click();
    driver.findElement(By.linkText("Click here to login again")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
