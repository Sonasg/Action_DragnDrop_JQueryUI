import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Sort {

WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", ".\\libs\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get("http://jqueryui.com/sortable/");
	}
	
	@Test
	public void test()
	{
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		WebElement sort = driver.findElement(By.id("sortable"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(sort));
		
		WebElement from = driver.findElement(By.xpath("//ul[@id='sortable']/li"));
		WebElement to = driver.findElement(By.xpath("//ul[@id='sortable']/li[5]"));
		Actions builder = new Actions(driver);
		Action action = builder.dragAndDropBy(from,0,50).build();
		action.perform();
		
		
	}
}

