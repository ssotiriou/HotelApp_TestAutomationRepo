package tests;
	
import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;	
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Properties;
import java.io.FileInputStream;
import org.apache.commons.io.FileUtils;
import functions.HotelApp_BusinessFunctions;

public class FunctionCallingTest extends HotelApp_BusinessFunctions {
  //private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  //public Properties prop;
  
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
  public void testMyFirstWebDriver() throws Exception {
	try {  
    driver.get(baseUrl + "/HotelApp/index.php");
    //driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).clear();
    //driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).sendKeys(sUserName);
    //driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).clear();
    //driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).sendKeys(sPassword);
    //driver.findElement(By.id(prop.getProperty("Btn_Login_Login"))).click();
    
    //Call to Login Function
    HA_BF_Login(driver,"ssotiriou","Ramsbottom1"); 
    
    //new Select(driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Location")))).selectByVisibleText("Sydney");
    //driver.findElement(By.id(prop.getProperty("Btn_SearchHotel_Submit"))).click();
    
    //Call to Search Hotel Function
    HA_BF_SearchHotel(driver,"Sydney"); 
    
    //driver.findElement(By.id(prop.getProperty("Rad_SelectHotel_RadioButton_1"))).click();
    //driver.findElement(By.id(prop.getProperty("Btn_SelectHotel_Continue"))).click();
    
    //Call to Select Hotel Function
    HA_BF_SelectHotel(driver,"Rad_SelectHotel_RadioButton_1"); 
    
    
    //driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_FirstName"))).clear();
    //driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_FirstName"))).sendKeys("ss");
    //driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_LastName"))).clear();
    //driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_LastName"))).sendKeys("ss");
    //driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_Address"))).clear();
    //driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_Address"))).sendKeys("9 Arcadian Gardens, Wood Green, London");
    //driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCNumber"))).clear();
    //driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCNumber"))).sendKeys("1234567812345678");
    //new Select(driver.findElement(By.id(prop.getProperty("Lst_BookingHotel_CCType")))).selectByVisibleText("VISA");
    //new Select(driver.findElement(By.id(prop.getProperty("Lst_BookingHotel_CCExpMonth")))).selectByVisibleText("November");
    //new Select(driver.findElement(By.id(prop.getProperty("Lst_BookingHotel_CCExpYear")))).selectByVisibleText("2020");
    //driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCCvvNumber"))).clear();
    //driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCCvvNumber"))).sendKeys("111");
    //driver.findElement(By.id(prop.getProperty("Btn_BookingHotel_BookNow"))).click();
    
    //Call to Select Hotel Function
    HA_BF_HotelBooking(driver,"ss","ss","9 Arcadian Gardens, Wood Green, London","1234567812345678","VISA","November","2020","111"); 
    
    //driver.findElement(By.linkText(prop.getProperty("Lnk_BookingHotel_Logout"))).click();
    //driver.findElement(By.linkText(prop.getProperty("Lnk_Logout_ClickHereToLoginAgain"))).click();
    
    //Call to Select Hotel Function
    HA_BF_Logout(driver); 
    
    
	}
  catch(Exception e) {
	//Takes the screenshot  when test fails
	     File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(scrFile, new File("C:\\Users\\User\\eclipse-workspace\\snapshots\\failure.png"));
  }     
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

