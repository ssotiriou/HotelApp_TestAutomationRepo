package functions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.Properties;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.NoSuchElementException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class HotelApp_BusinessFunctions {

	public static WebDriver driver;
	public static Properties prop;
		
		
	
public void HA_BF_Login (WebDriver driver, String sUserName, String sPassword) throws InterruptedException 
{
	driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).sendKeys(sUserName);
    driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).sendKeys(sPassword);
    driver.findElement(By.id(prop.getProperty("Btn_Login_Login"))).click();
//***************************Verify Welcome message is received*************************
    Thread.sleep(4000);
    try 
    	{
    		WebElement welcomeTxt = driver.findElement(By.id(prop.getProperty("Lbl_SearchHotel_WelcomeMessage")));
    		String text = welcomeTxt.getAttribute("value");
    		if(text.contains("Hello "+ sUserName))
    				System.out.println("Login Test PASS for Username: "+sUserName);
    				return;
    	}
	catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Login Test FAIL for Username: "+sUserName);
			assert false;
		}
//****************************************************************************************
}


public void HA_BF_SearchHotel (WebDriver driver, String sLocation) 
{
	new Select(driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Location")))).selectByVisibleText(sLocation);
    driver.findElement(By.id(prop.getProperty("Btn_SearchHotel_Submit"))).click();
}

public void HA_BF_SelectHotel (WebDriver driver, String sRadioButtonNum) 
{
	driver.findElement(By.id(prop.getProperty(sRadioButtonNum))).click();
    driver.findElement(By.id(prop.getProperty("Btn_SelectHotel_Continue"))).click();
}

public void HA_BF_HotelBooking (WebDriver driver, String sFirstName, String sLastName, String sAddress, String sCCNum, String sCCType, String sCCExpMonth, String sCCExpYear, String sCCCvvNum) throws InterruptedException 
{
	driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_FirstName"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_FirstName"))).sendKeys(sFirstName);
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_LastName"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_LastName"))).sendKeys(sLastName);
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_Address"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_Address"))).sendKeys(sAddress);
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCNumber"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCNumber"))).sendKeys(sCCNum);
    new Select(driver.findElement(By.id(prop.getProperty("Lst_BookingHotel_CCType")))).selectByVisibleText(sCCType);
    new Select(driver.findElement(By.id(prop.getProperty("Lst_BookingHotel_CCExpMonth")))).selectByVisibleText(sCCExpMonth);
    new Select(driver.findElement(By.id(prop.getProperty("Lst_BookingHotel_CCExpYear")))).selectByVisibleText(sCCExpYear);
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCCvvNumber"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCCvvNumber"))).sendKeys(sCCCvvNum);
    //Get the start time
    long startTime = System.currentTimeMillis();
    driver.findElement(By.id(prop.getProperty("Btn_BookingHotel_BookNow"))).click();
    HA_GF_WaitForElementPresent(driver,By.xpath(prop.getProperty("Btn_BookingHotel_Logout")),10);
    //get the end time    
    long endTime = System.currentTimeMillis();
    //calculate and report performance
    long totalTime = endTime - startTime;
    System.out.println("Total Booking Time: "+totalTime+" milliseconds");
    
    
    
}

public void HA_BF_Logout (WebDriver driver) 
{
	 WebDriverWait myWaitVar = new WebDriverWait(driver, 10); 
	 myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Xpath_BookingHotel_Logout"))));
	 driver.findElement(By.linkText(prop.getProperty("Lnk_BookingHotel_Logout"))).click();
	 driver.findElement(By.linkText(prop.getProperty("Lnk_Logout_ClickHereToLoginAgain"))).click();
}

public void HA_GF_WaitForElementPresent (WebDriver driver, By by, int iTimeOut) throws InterruptedException

//Function to dynamically wait for element presence

{
	int iTotal = 0;
	int iSleepTime = 5000;
	while(iTotal<iTimeOut)
	{
		List<WebElement>oWebElements = driver.findElements(by);
		if(oWebElements.size()>0)
				return;
		else
		{
			Thread.sleep(iSleepTime);
			iTotal=iTotal+iSleepTime;
			System.out.println(String.format("Waited for %d milliseconds.[%s]",iTotal, by));
		}
	}
}	
	

public void HA_GF_WaitForPropertyValue (WebDriver driver, By by, String ExpPropertyVal, String ProperName, int iTimeOut) throws InterruptedException
//Function to dynamically wait for element presence
{
	int iTotal = 0;
	int iSleepTime = 5000;
	while(iTotal<iTimeOut)
	{
		List<WebElement>oWebElements = driver.findElements(by);
		if(oWebElements.size()>0)
			for (WebElement weOption : oWebElements)
			{
				if (weOption.getAttribute(ProperName).equalsIgnoreCase(ExpPropertyVal))
				{
					return;
				}
				else
				{
					Thread.sleep(iSleepTime);
					iTotal=iTotal+iSleepTime;
					System.out.println(String.format("Waited for %d milliseconds.[%s]",iTotal, by));
				}}
				else
				{
					Thread.sleep(iSleepTime);
					iTotal=iTotal+iSleepTime;
					System.out.println(String.format("Waited for %d milliseconds.[%s]",iTotal, by));
				}				
			}
	}

public void takeScreenshot(WebDriver driver, String screenshotname)
	{
	
	String msg, path;
	String res;
	
	try
		{
		
		//generate timestamp
	   	 Date date= new Date();
	     long time = date.getTime();
		 Timestamp ts = new Timestamp(time);
		 SimpleDateFormat sm = new SimpleDateFormat("ddMMyyyy_HHmmss");
		
		//Take screenshot and save it in source object
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//Define path where Screenshots will be saved
		path = "./ScreenShots/"+this.toString()+"."+screenshotname+" "+sm.format(ts)+".png";
		
		//Copy the source file at the screenshot path
		FileUtils.copyFile(source, new File(path));
		msg = "Screenshot captured at"+path;
		res = "Pass";
		}
		catch(IOException e) 
		{
			msg = "Failed to capture screenshot: " + e.getMessage();
			res = "Fail";
		}
	
		//Reporter.log function as used in TestNG test
		Reporter.log(msg, true);
	}	

public void SetBrowserToBeUsed (String browserType)
	{
	switch (browserType) 
		{
		case "firefox":
			System.setProperty("webdriver.gecko.driver","C:\\Users\\User\\Desktop\\selenium 3 installs\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Desktop\\selenium 3 installs\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver","C:\\Users\\User\\Desktop\\selenium 3 installs\\IEDriverServer_x64_3.10.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}

	}

}				
