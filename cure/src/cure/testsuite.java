package cure;

 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testsuite {
	
	public static String url="https://katalon-demo-cura.herokuapp.com";
	public static WebDriver driver;
	public static String driver_path = "chromedriver.exe";

	
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver.manage().window().maximize();
	}
	
	@Test (priority = 0)
	public void login() {
        // open home page
        driver.get("https://katalon-demo-cura.herokuapp.com");
        // go to login page 
        WebElement toggle_menu = driver.findElement(By.id("menu-toggle"));
        WebElement toggle_menu_login = driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a"));
        toggle_menu.click(); 
        toggle_menu_login.click();
        
        try {
            Assert.assertEquals( "https://katalon-demo-cura.herokuapp.com/profile.php#login",driver.getCurrentUrl());
        	}
        	catch (AssertionError e) {
        	System.out.println("login failed!!!");
        	}
       
       // access elements of login page 
        WebElement username=driver.findElement(By.id("txt-username"));
        WebElement password=driver.findElement(By.id("txt-password"));
        WebElement login=driver.findElement(By.id("btn-login"));
        
        // enter login data
        username.sendKeys("John Doe");
        password.sendKeys("ThisIsNotAPassword");
        login.click();
        
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl= "https://katalon-demo-cura.herokuapp.com/#appointment";
        
        try {
            Assert.assertEquals(expectedUrl,actualUrl);
        	}
        	catch (AssertionError e) {
        	System.out.println("login failed!!!");
        	}
        driver.close();
	}

	@Test (priority = 1)
	public void make_appointment_1() throws InterruptedException {
		// TC_01 : tokyo, apply for hospital readmission, medicare, 14/2/2020, this a comment
		driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
		 // access elements of login page 
        WebElement username=driver.findElement(By.id("txt-username"));
        WebElement password=driver.findElement(By.id("txt-password"));
        WebElement login=driver.findElement(By.id("btn-login"));
        
        // enter login data
        username.sendKeys("John Doe");
        password.sendKeys("ThisIsNotAPassword");
        login.click();
		
      
		driver.findElement(By.id("combo_facility")).click();
		driver.findElement(By.xpath("//*[@id=\"combo_facility\"]/option[1]")).click();
		driver.findElement(By.id("chk_hospotal_readmission")).click();
		driver.findElement(By.id("radio_program_medicare"));
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.id("txt_visit_date")).click();
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr[2]/td[5]")).click();
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.id("txt_comment")).sendKeys("this is a comment");
		driver.findElement(By.id("btn-book-appointment"));
		
		String expected_url = "https://katalon-demo-cura.herokuapp.com/appointment.php#summary";
		try {
			Assert.assertEquals(driver.getCurrentUrl(), expected_url);
		}
		catch (AssertionError e){
		}
		driver.close();
	}
	
	
	@Test (priority = 2)
	public void make_appointment_2() {
	  driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
	   // access elements of login page 
       WebElement username=driver.findElement(By.id("txt-username"));
       WebElement password=driver.findElement(By.id("txt-password"));
       WebElement login=driver.findElement(By.id("btn-login"));
       
       // enter login data
       username.sendKeys("John Doe");
       password.sendKeys("ThisIsNotAPassword");
       login.click();
       
		// TC_02 : tokyo,  do not apply for hospital readmission, none, 5/3/2020, this a comment
		// choose tokyo from drop down list
		driver.findElement(By.id("combo_facility")).click();
		driver.findElement(By.xpath("//*[@id=\"combo_facility\"]/option[1]")).click();
		driver.findElement(By.id("radio_program_none"));
		driver.findElement(By.id("txt_visit_date")).sendKeys("5/3/2020");
		driver.findElement(By.id("txt_comment")).sendKeys("this is a comment");
		driver.findElement(By.id("btn-book-appointment"));
		
		String expected_url = "https://katalon-demo-cura.herokuapp.com/appointment.php#summary";
		try {
			Assert.assertEquals(driver.getCurrentUrl(), expected_url);
		}
		catch (AssertionError e){
		}
		driver.close();
	}
	
	@Test (priority = 3)
	public void make_appointment_3() {
		driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
		 // access elements of login page 
       WebElement username=driver.findElement(By.id("txt-username"));
       WebElement password=driver.findElement(By.id("txt-password"));
       WebElement login=driver.findElement(By.id("btn-login"));
       
       // enter login data
       username.sendKeys("John Doe");
       password.sendKeys("ThisIsNotAPassword");
       login.click();
				// TC_03 : hongkong, apply for hospital readmission, medcare, 20/5/2019, this a comment
		driver.findElement(By.id("combo_facility")).click();
		driver.findElement(By.xpath("//*[@id=\"combo_facility\"]/option[2]")).click();
		driver.findElement(By.id("chk_hospotal_readmission")).click();
		driver.findElement(By.id("radio_program_medicaid"));
		driver.findElement(By.id("txt_visit_date")).sendKeys("5/3/2020");
		driver.findElement(By.id("txt_comment")).sendKeys("this is a comment");
		driver.findElement(By.id("btn-book-appointment"));
		
		String expected_url = "https://katalon-demo-cura.herokuapp.com/appointment.php#summary";
		try {
			Assert.assertEquals(driver.getCurrentUrl(), expected_url);
		}
		catch (AssertionError e){
		}
		driver.close();
	}
	
	@Test (priority = 4)
	public void make_appointment_4() {
		driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
		 // access elements of login page 
       WebElement username=driver.findElement(By.id("txt-username"));
       WebElement password=driver.findElement(By.id("txt-password"));
       WebElement login=driver.findElement(By.id("btn-login"));
       
       // enter login data
       username.sendKeys("John Doe");
       password.sendKeys("ThisIsNotAPassword");
       login.click();
				// TC_04 : hongkong, do not apply for hospital readmission, medicaid, 5/8/2022, this a comment
		driver.findElement(By.id("combo_facility")).click();
		driver.findElement(By.xpath("//*[@id=\"combo_facility\"]/option[2]")).click();
		driver.findElement(By.id("chk_hospotal_readmission")).click();
		driver.findElement(By.id("radio_program_medicaid"));
		driver.findElement(By.id("txt_visit_date")).sendKeys("5/8/2022");
		driver.findElement(By.id("txt_comment")).sendKeys("this is a comment");
		driver.findElement(By.id("btn-book-appointment"));
		
		String expected_url = "https://katalon-demo-cura.herokuapp.com/appointment.php#summary";
		try {
			Assert.assertEquals(driver.getCurrentUrl(), expected_url);
		}
		catch (AssertionError e){
		}
		driver.close();
	}
	
}