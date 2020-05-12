package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	
	public WebDriver driver;
	
	//We cannot use thisway cos driver is null at the instance
	/*public WebElement email=driver.findElement(By.id("login-username"));
	public WebElement emailNext=driver.findElement(By.id("login-signin"));
	public WebElement password=driver.findElement(By.id("login-passwd"));			
	public WebElement passwordNext=driver.findElement(By.id("login-signin"));
	public WebElement passwordErrMsg=driver.findElement(By.className("error-msg"));
	public WebElement emailErrMsg=driver.findElement(By.id("username-error"));*/
	
	@FindBy(id="login-username")
	public static WebElement email;
	
	@FindBy(id="login-signin")
	public static WebElement emailNext;
	
	@FindBy(id="login-passwd")
	public static WebElement password;
	
	@FindBy(id="login-passwd")
	public static WebElement passwordNext;
	
	@FindBy(className="error-msg")
	public static WebElement passwordErrMsg;
	
	
	@FindBy(id="username-error")
	public static WebElement emailErrMsg;
	
	public void openBrowser() throws IOException {
		FileInputStream fs = new FileInputStream("E:\\testing\\prop1.properties");
		Properties prop = new Properties();
		prop.load(fs);
		String browser=prop.getProperty("browser");
		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\SeleniumJars\\chromedriver.exe");
			driver=new ChromeDriver();		
		} else {
			System.setProperty("webdriver.gecko.driver", "E:\\SeleniumJars\\geckodriver.exe");
			driver=new FirefoxDriver();	
		}
		PageFactory.initElements(driver, this);
	}
	
	public void closeBrowser(){
		driver.quit();
	}
	
	public void enterEmail(String option) throws InterruptedException{
		email.sendKeys(option);
		emailNext.click();
		Thread.sleep(2000);
	}
	
	public void enterPassword(String option) throws InterruptedException{
		password.sendKeys(option);
		passwordNext.click();
		Thread.sleep(2000);
	}
	
	public String readPasswordErr(){
		String actualMsg=passwordErrMsg.getText();
		System.out.println(actualMsg);
		return actualMsg;
	}
	
	public String readEmailErr(){
		String actualMsg=emailErrMsg.getText();
		System.out.println(actualMsg);
		return actualMsg;
	}
	
	public void openYhoo(){
		 driver.get("https://login.yahoo.com/?.src=ym&.lang=en-CA&.intl=ca&.done=https%3A%2F%2Fmail.yahoo.com%2Fd%3F.intl%3Dca%26.lang%3Den-CA");
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
