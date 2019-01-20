package Assignment;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddComputer {
	public WebDriver driver;

	String ComputerName = "Test";
	String ComputerSingleletter = "A";
	String ComputerLongName = "Aweujgnkljf;lbjofibl;grejgfgojfd;lbmfbjdgorhghrg;kfs;glhrhglsfhgl;fsdb;ldmjkg";
	String ComputerSpecialChar = "~!@#$%^&*()_+-= {}|:<>?;',./'";
	String ComputerWithiSpace = "TEststart Testend";
	String IntroducedDate = "2010-01-01";
	String DiscontinuedDate = "2012-01-01";
	String ZeroDate = "0000-00-00";
	String CharDate = "aaaa-aa-aa";
	String lowestYear = "0001-01-01";
	String Highestvalue = "9999-99-99";
	String CorrectMonth = "9999-01-30";
	String InvalidMonth = "9999-13-31";
	String InvalidDate = "9999-13-32";
	String ZeroinDate= "9999-13-00";
	String Null = " ";
	int Company = 7;
	String NewComputerURL = "http://computer-database.herokuapp.com/computers/new";

	@BeforeClass
	public void launchApp() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://computer-database.herokuapp.com/computers");
	}

	@Test(priority = 1)
	public void addComputerPositiveCase() {
		System.out.println("TC003");
		String text = driver.findElement(By.xpath("//section[contains(@id,'main')]/h1")).getText();
		System.out.println("Precondition" + text);
		// Add a new computer
		driver.findElement(By.id("add")).click();
		// Verify navigation is to Add computer page.
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		// Add Data to add computer page
		driver.findElement(By.id("name")).sendKeys(ComputerName);
		driver.findElement(By.id("introduced")).sendKeys(IntroducedDate);
		driver.findElement(By.id("discontinued")).sendKeys(DiscontinuedDate);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		// After adding computer successfully
		String existingComputer = text.substring(0, 3);
		int numb = Integer.parseInt(existingComputer);
		int successfullyAdded = numb + 1;
		String afterAdding = successfullyAdded + " computers found";
		System.out.println(afterAdding);
		String UpdatedHeader = driver.findElement(By.xpath("//section[contains(@id,'main')]/h1")).getText();
		Assert.assertEquals(UpdatedHeader, afterAdding);
		String UpdatedAlert = driver.findElement(By.xpath("//div[@class=\"alert-message warning\"]")).getText();
		System.out.println(UpdatedAlert);
		Assert.assertEquals(UpdatedAlert, "Done! Computer " + ComputerName + " has been created");
	}

	@Test(priority = 2)
	public void addComputerWithNullValue() {
		System.out.println("TC004");
		driver.findElement(By.id("add")).click();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		driver.findElement(By.id("name")).sendKeys(Null);
		driver.findElement(By.id("introduced")).sendKeys(Null);
		driver.findElement(By.id("discontinued")).sendKeys(Null);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));
	}

	@Test(priority = 3)
	public void addComputerWithComptName() {
		System.out.println("TC005");
		String text = driver.findElement(By.xpath("//section[contains(@id,'main')]/h1")).getText();
		System.out.println("Precondition" + text);
		// Add a new computer
		driver.findElement(By.id("add")).click();
		// Verify navigation is to Add computer page.
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		// Add Data to add computer page
		driver.findElement(By.id("name")).sendKeys(ComputerName);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		// After adding computer successfully
		String existingComputer = text.substring(0, 3);
		int numb = Integer.parseInt(existingComputer);
		int successfullyAdded = numb + 1;
		String afterAdding = successfullyAdded + " computers found";
		System.out.println(afterAdding);
		String UpdatedHeader = driver.findElement(By.xpath("//section[contains(@id,'main')]/h1")).getText();
		Assert.assertEquals(UpdatedHeader, afterAdding);
		String UpdatedAlert = driver.findElement(By.xpath("//div[@class=\"alert-message warning\"]")).getText();
		System.out.println(UpdatedAlert);
		Assert.assertEquals(UpdatedAlert, "Done! Computer " + ComputerName + " has been created");
	}

	@Test(priority = 4)
	public void addComputerWithSingleCharacter() {
		System.out.println("TC006");
		String text = driver.findElement(By.xpath("//section[contains(@id,'main')]/h1")).getText();
		System.out.println("Precondition" + text);
		// Add a new computer
		driver.findElement(By.id("add")).click();
		// Verify navigation is to Add computer page.
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		// Add Data to add computer page
		driver.findElement(By.id("name")).sendKeys(ComputerSingleletter);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		// After adding computer successfully
		String existingComputer = text.substring(0, 3);
		int numb = Integer.parseInt(existingComputer);
		int successfullyAdded = numb + 1;
		String afterAdding = successfullyAdded + " computers found";
		System.out.println(afterAdding);
		String UpdatedHeader = driver.findElement(By.xpath("//section[contains(@id,'main')]/h1")).getText();
		Assert.assertEquals(UpdatedHeader, afterAdding);
		String UpdatedAlert = driver.findElement(By.xpath("//div[@class=\"alert-message warning\"]")).getText();
		System.out.println(UpdatedAlert);
		Assert.assertEquals(UpdatedAlert, "Done! Computer " + ComputerSingleletter + " has been created");
	}

	@Test(priority = 5)
	public void addComputerWithLongName() {
		System.out.println("TC007");
		String text = driver.findElement(By.xpath("//section[contains(@id,'main')]/h1")).getText();
		System.out.println("Precondition" + text);
		// Add a new computer
		driver.findElement(By.id("add")).click();
		// Verify navigation is to Add computer page.
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		// Add Data to add computer page
		driver.findElement(By.id("name")).sendKeys(ComputerLongName);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		// After adding computer successfully
		String existingComputer = text.substring(0, 3);
		int numb = Integer.parseInt(existingComputer);
		int successfullyAdded = numb + 1;
		String afterAdding = successfullyAdded + " computers found";
		System.out.println(afterAdding);
		String UpdatedHeader = driver.findElement(By.xpath("//section[contains(@id,'main')]/h1")).getText();
		Assert.assertEquals(UpdatedHeader, afterAdding);
		String UpdatedAlert = driver.findElement(By.xpath("//div[@class=\"alert-message warning\"]")).getText();
		System.out.println(UpdatedAlert);
		Assert.assertEquals(UpdatedAlert, "Done! Computer " + ComputerLongName + " has been created");
	}

	@Test(priority = 6)
	public void addComputerWithSpecialChar() {
		System.out.println("TC008");
		String text = driver.findElement(By.xpath("//section[contains(@id,'main')]/h1")).getText();
		System.out.println("Precondition" + text);
		// Add a new computer
		driver.findElement(By.id("add")).click();
		// Verify navigation is to Add computer page.
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		// Add Data to add computer page
		driver.findElement(By.id("name")).sendKeys(ComputerSpecialChar);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		// After adding computer successfully
		String existingComputer = text.substring(0, 3);
		int numb = Integer.parseInt(existingComputer);
		int successfullyAdded = numb + 1;
		String afterAdding = successfullyAdded + " computers found";
		System.out.println(afterAdding);
		String UpdatedHeader = driver.findElement(By.xpath("//section[contains(@id,'main')]/h1")).getText();
		Assert.assertEquals(UpdatedHeader, afterAdding);
		String UpdatedAlert = driver.findElement(By.xpath("//div[@class=\"alert-message warning\"]")).getText();
		System.out.println(UpdatedAlert);
		Assert.assertEquals(UpdatedAlert, "Done! Computer " + ComputerSpecialChar + " has been created");
	}

	@Test(priority = 7)
	public void addComputerWithMultiSpace() {
		System.out.println("TC009");
		String text = driver.findElement(By.xpath("//section[contains(@id,'main')]/h1")).getText();
		System.out.println("Precondition" + text);
		// Add a new computer
		driver.findElement(By.id("add")).click();
		// Verify navigation is to Add computer page.
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		// Add Data to add computer page
		driver.findElement(By.id("name")).sendKeys(ComputerWithiSpace);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		// After adding computer successfully
		String existingComputer = text.substring(0, 3);
		int numb = Integer.parseInt(existingComputer);
		int successfullyAdded = numb + 1;
		String afterAdding = successfullyAdded + " computers found";
		System.out.println(afterAdding);
		String UpdatedHeader = driver.findElement(By.xpath("//section[contains(@id,'main')]/h1")).getText();
		Assert.assertEquals(UpdatedHeader, afterAdding);
		String UpdatedAlert = driver.findElement(By.xpath("//div[@class=\"alert-message warning\"]")).getText();
		System.out.println(UpdatedAlert);
		Assert.assertEquals(UpdatedAlert, "Done! Computer " + ComputerWithiSpace + " has been created");
	}

	@Test(priority = 8)
	public void addComputerWithDuplicateName() {
		System.out.println("TC0010");
		String text = driver.findElement(By.xpath("//section[contains(@id,'main')]/h1")).getText();
		System.out.println("Precondition" + text);
		// Add a new computer
		driver.findElement(By.id("add")).click();
		// Verify navigation is to Add computer page.
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		// Add Data to add computer page
		driver.findElement(By.id("name")).sendKeys(ComputerName);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		// After adding computer successfully
		String existingComputer = text.substring(0, 3);
		int numb = Integer.parseInt(existingComputer);
		int successfullyAdded = numb + 1;
		String afterAdding = successfullyAdded + " computers found";
		System.out.println(afterAdding);
		String UpdatedHeader = driver.findElement(By.xpath("//section[contains(@id,'main')]/h1")).getText();
		Assert.assertEquals(UpdatedHeader, afterAdding);
		String UpdatedAlert = driver.findElement(By.xpath("//div[@class=\"alert-message warning\"]")).getText();
		System.out.println(UpdatedAlert);
		Assert.assertEquals(UpdatedAlert, "Done! Computer " + ComputerName + " has been created");
	}

	@Test(priority = 9)
	public void AddCompWithZeroInIntroDate() {
		System.out.println("TC0011");
		driver.findElement(By.id("add")).click();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		driver.findElement(By.id("name")).sendKeys(Null);
		driver.findElement(By.id("introduced")).sendKeys(ZeroDate);
		driver.findElement(By.id("discontinued")).sendKeys(Null);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));
	}

	@Test(priority = 10)
	public void AddCompWithCharInDate() {
		System.out.println("TC012");
		driver.findElement(By.id("add")).click();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		driver.findElement(By.id("name")).sendKeys(Null);
		driver.findElement(By.id("introduced")).sendKeys(CharDate);
		driver.findElement(By.id("discontinued")).sendKeys(Null);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));
	}

	@Test(priority = 11)
	public void AddCompWithlowestYear() {
		System.out.println("TC013");
		driver.findElement(By.id("add")).click();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		driver.findElement(By.id("name")).sendKeys(lowestYear);
		driver.findElement(By.id("introduced")).sendKeys(Highestvalue);
		driver.findElement(By.id("discontinued")).sendKeys(Null);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));
	}

	@Test(priority = 12)
	public void AddCompWithHigestvalues() {
		System.out.println("TC014");
		driver.findElement(By.id("add")).click();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		driver.findElement(By.id("name")).sendKeys(ComputerName);
		driver.findElement(By.id("introduced")).sendKeys(Highestvalue);
		driver.findElement(By.id("discontinued")).sendKeys(Null);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));
	}



	@Test(priority = 14)
	public void AddCompWithInvalidMonth() {
		System.out.println("TC0016");
		driver.findElement(By.id("add")).click();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		driver.findElement(By.id("name")).sendKeys(ComputerName);
		driver.findElement(By.id("introduced")).sendKeys(InvalidMonth);
		driver.findElement(By.id("discontinued")).sendKeys(Null);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));
	}
	
	@Test(priority = 15)
	public void AddCompWithInvalidDate() {
		System.out.println("TC0017");
		driver.findElement(By.id("add")).click();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		driver.findElement(By.id("name")).sendKeys(ComputerName);
		driver.findElement(By.id("introduced")).sendKeys(InvalidDate);
		driver.findElement(By.id("discontinued")).sendKeys(Null);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));
	}
	
	@Test(priority = 16)
	public void AddCompWithZeroIndate() {
		System.out.println("TC0018");
		driver.findElement(By.id("add")).click();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		driver.findElement(By.id("name")).sendKeys(ComputerName);
		driver.findElement(By.id("introduced")).sendKeys(ZeroinDate);
		driver.findElement(By.id("discontinued")).sendKeys(Null);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));
	}
	
	@Test(priority = 17)
	public void AddCompWithZeroInDiscontDate() {
		System.out.println("TC0019");
		driver.findElement(By.id("add")).click();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		driver.findElement(By.id("name")).sendKeys(Null);
		driver.findElement(By.id("introduced")).sendKeys(CorrectMonth);
		driver.findElement(By.id("discontinued")).sendKeys(ZeroDate);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));
	}

	@Test(priority = 18)
	public void AddCompWithCharInDisconDate() {
		System.out.println("TC020");
		driver.findElement(By.id("add")).click();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		driver.findElement(By.id("name")).sendKeys(Null);
		driver.findElement(By.id("introduced")).sendKeys(CorrectMonth);
		driver.findElement(By.id("discontinued")).sendKeys(CharDate);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));
	}

	@Test(priority = 19)
	public void AddCompWithlowestYearinDisconDate() {
		System.out.println("TC021");
		driver.findElement(By.id("add")).click();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		driver.findElement(By.id("name")).sendKeys(lowestYear);
		driver.findElement(By.id("introduced")).sendKeys(CorrectMonth);
		driver.findElement(By.id("discontinued")).sendKeys(Highestvalue);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));
	}

	@Test(priority = 20)
	public void AddCompWithHigestvaluesinDisconDate() {
		System.out.println("TC022");
		driver.findElement(By.id("add")).click();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		driver.findElement(By.id("name")).sendKeys(ComputerName);
		driver.findElement(By.id("introduced")).sendKeys(CorrectMonth);
		driver.findElement(By.id("discontinued")).sendKeys(Highestvalue);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));
	}



	@Test(priority = 21)
	public void AddCompWithInvalidMonthinDisconDate() {
		System.out.println("TC0024");
		driver.findElement(By.id("add")).click();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		driver.findElement(By.id("name")).sendKeys(ComputerName);
		driver.findElement(By.id("introduced")).sendKeys(CorrectMonth);
		driver.findElement(By.id("discontinued")).sendKeys(InvalidMonth);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));
	}
	
	@Test(priority = 22)
	public void AddCompWithInvalidDateinDisconDate() {
		System.out.println("TC0025");
		driver.findElement(By.id("add")).click();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		driver.findElement(By.id("name")).sendKeys(ComputerName);
		driver.findElement(By.id("introduced")).sendKeys(CorrectMonth);
		driver.findElement(By.id("discontinued")).sendKeys(InvalidDate);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));
	}
	
	@Test(priority = 23)
	public void AddCompWithZeroIndateinDisconDate() {
		System.out.println("TC0026");
		driver.findElement(By.id("add")).click();
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertEquals(CurrentURL, NewComputerURL);
		driver.findElement(By.id("name")).sendKeys(ComputerName);
		driver.findElement(By.id("introduced")).sendKeys(CorrectMonth);
		driver.findElement(By.id("discontinued")).sendKeys(ZeroinDate);
		Select Comp = new Select(driver.findElement(By.id("company")));
		Comp.selectByIndex(Company);
		driver.findElement(By.xpath("//input[@value=\"Create this computer\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add")));
	}
	

		@Test(priority = 24)
		public void CheckCancelButton() {
			System.out.println("TC0208");
			String text = driver.findElement(By.xpath("//section[contains(@id,'main')]/h1")).getText();
			System.out.println("Precondition" + text);
			// Add a new computer
			driver.findElement(By.id("add")).click();
			// Verify navigation is to Add computer page.
			String CurrentURL = driver.getCurrentUrl();
			Assert.assertEquals(CurrentURL, NewComputerURL);
			// Add Data to add computer page
			driver.findElement(By.id("name")).sendKeys(ComputerSpecialChar);
			Select Comp = new Select(driver.findElement(By.id("company")));
			Comp.selectByIndex(Company);
			driver.findElement(By.xpath("//a[@class=\"btn\"]")).click();
			// After Cancelling computer successfully
			String existingComputer = text.substring(0, 3);
			int numb = Integer.parseInt(existingComputer);
			//int successfullyAdded = numb + 1;
			String afterAdding = numb + " computers found";
			System.out.println(afterAdding);
			String UpdatedHeader = driver.findElement(By.xpath("//section[contains(@id,'main')]/h1")).getText();
			Assert.assertEquals(UpdatedHeader, afterAdding);
		}

	/*
	 * @AfterClass public void CloseBrowser() { driver.close(); }
	 */

}
