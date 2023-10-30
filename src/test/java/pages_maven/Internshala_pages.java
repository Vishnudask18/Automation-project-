package pages_maven;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Internshala_pages {
	WebDriver driver;
	By Login=By.xpath("//*[@id=\"header\"]/div/nav/div[3]/button[2]");
	By Email=By.xpath("//*[@id=\"modal_email\"]");
	By Pass=By.xpath("//*[@id=\"modal_password\"]");
	By Log=By.xpath("//*[@id=\"modal_login_submit\"]");
	By Logo=By.xpath("//*[@id=\"header\"]/div/nav/div[1]/a/div");
	By Nothanks=By.xpath("//*[@id=\"no_thanks\"]");
	By Internship=By.xpath("//*[@id=\"internships_new_superscript\"]");
	By Course=By.xpath("//*[@id=\"trainings_dropdown_link\"]/i");
	By Solidwork=By.xpath("//*[@id=\"header\"]/div/nav/div[3]/ul/li[2]/div/div/div[2]/div/a[1]");
	By WorkHome=By.xpath("//*[@id=\"internships-dropdown\"]/div/div[2]/div[1]/div/a[1]");
	By Account=By.xpath("//*[@id=\"header\"]/div/nav/div[3]/ul/li[7]/a/div/div");
	
	By Profile=By.xpath("//*[@id=\"header\"]/div/nav/div[3]/ul/li[4]/a");
	By PLogin=By.xpath("//*[@id=\"header_login_modal_button\"]");
	By Resume=By.xpath("//*[@id=\"profile-dropdown\"]/div/div/div/ul/div/li[3]/a");
	By Edit=By.xpath("//*[@id=\"personal_details_edit\"]/i");
	By Upload=By.xpath("//*[@id=\"personal_details_form\"]/div[1]/div[2]/label[2]");
	By Update=By.xpath("//*[@id=\"personal_details_form\"]/button");
	By Placement=By.xpath("//*[@id=\"navbar\"]/div/div[1]/div[1]/div[2]/div[2]/div[1]");
	By Know=By.xpath("//*[@id=\"placement-and-job-guarantee-courses\"]/div/div[3]/div/a[2]/div[2]/div");
	By Pack=By.xpath("//*[@id=\"trending_banner_556\"]/a/img");
	
	
	public Internshala_pages(WebDriver driver) {
		this.driver=driver;
	}
	
	public void titleverifivation() {
		String title=driver.getTitle();
		String T="Internship";
		if(title.equals(T)){
			System.out.println("Title name is same");			
		}else {
			System.out.println("Title name is different");
		}
		
	}
	
	public void Contentverification() {
		String Content=driver.getPageSource();
		if(Content.contains("INTERNSHALA")) {
			System.out.println("Verified");
		}else {
			System.out.println("Not-verified");
		}
	}
	public void Logodisplay() {
		WebElement lo=driver.findElement(Logo);
		boolean b=lo.isDisplayed();
		
		if(b) {
			System.out.println("Logo displayed");
		}else {
			System.out.println("Logo not displayed");
		}
	}
	public void screenshot() throws IOException {
		File f=(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE));
		FileHandler.copy(f,new File("./Screenshot1/Internshala.png"));
	}
	
	public void mousehover() {
		Actions act=new Actions(driver);
		WebElement W=driver.findElement(Internship);
		act.moveToElement(W);
		act.perform();
		driver.findElement(WorkHome).click();
		driver.findElement(Nothanks).click();
		
	}
	//public void mousehover1() {}
	
	public void scrolldown() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)", "");
	}
	public void Profile() {
		Actions pr=new Actions(driver);
		WebElement E=driver.findElement(Profile);
		pr.moveToElement(E);
		pr.perform();
		driver.findElement(PLogin).click();
		
		
	}
	public void login() throws IOException {
		File F=new File("C:\\Users\\Acer\\Desktop\\Automation_project\\Datadriven_project.xlsx");
		
		FileInputStream fs=new FileInputStream(F);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sh=wb.getSheet("sheet1");
		System.out.println(sh.getLastRowNum());
		
		for(int i=1;i<sh.getLastRowNum();i++) {
			String Username=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(Username);
			String Password=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(Password);
			
			driver.findElement(Email).clear();
			driver.findElement(Email).sendKeys(Username);
			driver.findElement(Pass).clear();
			driver.findElement(Pass).sendKeys(Password);
			driver.findElement(Log).click();
			
		}
		
	}
	
	
	public void windowhandle() {
				
		String parentwindow=driver.getWindowHandle();
			
		driver.findElement(Pack).click();
		Set<String> allwindowhandles = driver.getWindowHandles();
		
		for(String handle:allwindowhandles) {
			System.out.println(handle);
			
			if(!handle.equalsIgnoreCase(parentwindow)) {
				driver.switchTo().window(handle);
				System.out.println("Package opened");
				driver.findElement(Know).click();
				
			}
			
		}
		driver.switchTo().window(parentwindow);	
		
	}
	public void Fileupload() throws Exception {
		Actions Ac=new Actions(driver);
		WebElement A=driver.findElement(Account);
		Ac.moveToElement(A);
		Ac.perform();
		driver.findElement(Resume).click();
		driver.findElement(Edit).click();
		driver.findElement(Upload).click();
		
		fileupload("C:\\Users\\Acer\\Desktop\\Vishnu Das.jpg");
	}
	
	public void fileupload(String m) throws Exception {
		
		
		StringSelection strselection=new StringSelection(m);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strselection, null);
		
		Robot robot=new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		JavascriptExecutor sw=(JavascriptExecutor)driver;
		sw.executeScript("window.scrollBy(0,1500)", "");
		
		driver.findElement(Update).click();
	}
	
}
	 

