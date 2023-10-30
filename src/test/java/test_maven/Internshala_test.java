package test_maven;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages_maven.Internshala_pages;

public class Internshala_test {
	WebDriver driver;
	
	@BeforeTest
	public void Setup() {
		
		driver=new ChromeDriver();
		
	}
	@BeforeMethod
	public void Url() {
		driver.get("https://internshala.com/");
	}
	
	@Test
	public void test() throws Exception {
		Internshala_pages pg=new Internshala_pages(driver);
		driver.manage().window().maximize();
		pg.Contentverification();
		pg.titleverifivation();
		pg.Logodisplay();
		pg.screenshot();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		pg.mousehover();
		pg.scrolldown();
		pg.Profile();
		pg.login();		
		pg.windowhandle();
		pg.Fileupload();
		
		
		
	}
	
	
	

}
