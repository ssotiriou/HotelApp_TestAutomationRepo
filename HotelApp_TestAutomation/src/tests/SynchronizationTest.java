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
import functions.ExcelReader;
import functions.CommonMethods;
import functions.TestData;


public class SynchronizationTest extends HotelApp_BusinessFunctions {
  //private WebDriver driver;
  //private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public static String sAppURL;
  public static String sSharedUIMapPath;
  //private String strFile;
  //private String strLocation;
  public ExcelReader excelReaderObj;
  
  
  //public Properties prop;
  
  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver","C:\\Users\\User\\Desktop\\selenium 3 installs\\geckodriver-v0.19.1-win64\\geckodriver.exe");
	prop = new Properties();
	prop.load(new FileInputStream("./Configuration/HA_Configuration.properties"));
    sAppURL = prop.getProperty("AppUrl");
    sSharedUIMapPath = prop.getProperty("SharedUIMap");
    prop.load(new FileInputStream(sSharedUIMapPath));
    driver = new FirefoxDriver();
    //baseUrl = "http://adactin.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);        
    }

  @Test
  public void testMyFirstWebDriver() throws Exception {
	try {  
    driver.get(sAppURL);
    
    //driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).clear();
    //driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).sendKeys(sUserName);
    //driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).clear();
    //driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).sendKeys(sPassword);
    //driver.findElement(By.id(prop.getProperty("Btn_Login_Login"))).click();
    
 // Create Objects for Excel File parameters.
        CommonMethods commonMethodObj = new CommonMethods();
    TestData td = new TestData();
    // Load the excel file for testing
    excelReaderObj = new ExcelReader("./DataPool/HA_HotelSearch.xls");
    // Load the Excel Sheet Col in to Dictionary for use in test cases
    excelReaderObj.ColumnDictionary();
    // Get the data from excel file
    commonMethodObj.readExcelData (td);
    //String userAccount = td.getLoginUser().get(0);
    
    
    //Call to Login Function
    HA_BF_Login(driver,td.getUserName().get(0),td.getPassword().get(0)); 
    
    //Search Hotel Search details
    new Select(driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Location")))).selectByVisibleText(td.getLocation().get(0));
    driver.findElement(By.id(prop.getProperty("Btn_SearchHotel_Submit"))).click();
    
    //Call to Search Hotel Function
    //HA_BF_SearchHotel(driver,data.getLoginUser().get(0)); 
    
    //driver.findElement(By.id(prop.getProperty("Rad_SelectHotel_RadioButton_1"))).click();
    //driver.findElement(By.id(prop.getProperty("Btn_SelectHotel_Continue"))).click();
    
    //Call to Select Hotel Function
    HA_BF_SelectHotel(driver,"Rad_SelectHotel_RadioButton_" + td.getRadioButtonNumLocation().get(0)); 
    
    
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
    
    
    
    
    //Call to Book Hotel Function
    HA_BF_HotelBooking(driver,td.getFirstName().get(0),td.getLastName().get(0),td.getAddress().get(0),td.getCcNumber().get(0),td.getCcType().get(0),td.getCcExpMonth().get(0),td.getCcExpYear().get(0),td.getCccVvNum().get(0)); 
    
    //capture the order number and display
    Thread.sleep(10);
    String strOrderNo = driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_OrderNo"))).getAttribute("value");
    System.out.println("Order Number generated is " + strOrderNo);
    
    
    //driver.findElement(By.linkText(prop.getProperty("Lnk_BookingHotel_Logout"))).click();
    //driver.findElement(By.linkText(prop.getProperty("Lnk_Logout_ClickHereToLoginAgain"))).click();
    
    //Logout
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

