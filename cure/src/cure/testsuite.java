package cure;


import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testsuite {
	
	public static String url="https://katalon-demo-cura.herokuapp.com";
	public static WebDriver driver;
	@BeforeTest
	public void sys_setup() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);	
	}
	
	@Test (priority = 0)
	public void login() {
        
        WebElement username=driver.findElement(By.id("txt-username"));
        WebElement password=driver.findElement(By.id("txt-password"));
        WebElement login=driver.findElement(By.id("btn-login"));
        username.sendKeys("John Doe");
        password.sendKeys("ThisIsNotAPassword");
        login.click();
        
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl= "https://katalon-demo-cura.herokuapp.com/#appointment";
        
        Assert.assertEquals(expectedUrl,actualUrl);
        
	}
	
	
}
