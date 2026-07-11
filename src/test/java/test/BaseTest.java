package test;

import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public WebDriver driver;
	public Properties props=new Properties();
	public FileInputStream fis;
	public Logger log;
	
	@Parameters({"browser","runType"})
	@BeforeClass(alwaysRun = true)
	public void driverSetUp(ITestContext context,String browser,String runType) throws Exception {
		
		log=LogManager.getLogger(this.getClass());
		
		log.info("Initializing Driver");
		System.out.println("Initializing Driver");
		
		fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		props.load(fis);
		String baseUrl=props.getProperty("baseUrl");
		
		switch(runType.toLowerCase()) {
		
		case "local":
			
			switch(browser.toLowerCase()) {
			
				case "chrome":
					
					log.info("Driver initialized in local with chrome browser");
					
					driver=new ChromeDriver();
					break;
					
				case "edge":
					
					log.info("Driver initialized in local with edge browser");
					
					driver=new EdgeDriver();
					break;
					
				default:
					
					log.error("chrome and edge browser are only supported");
					System.out.println("chrome and edge browser are only supported");
					Assert.fail("Invalid Browser");
					break;
			}
			
			break;
			
		case "remote":
			
			URL huburl = new URL(props.getProperty("hubUrl")); 
			DesiredCapabilities cap = new DesiredCapabilities();	
			//cap.setPlatform(Platform.WIN11); //cap.setPlatform(Platform.MAC);
			 
			switch(browser.toLowerCase()) {
			
			case "chrome":
				
				log.info("Driver initialized in remote with chrome browser");
				
				cap.setBrowserName("chrome");
				break;
				
			case "edge":
				
				log.info("Driver initialized in remote with edge browser");
				
				cap.setBrowserName("MicrosoftEdge");
				break;
				
			default:
				
				log.error("chrome and edge browser are only supported");
				System.out.println("chrome and edge browser are only supported");
				Assert.fail("Invalid Browser");
				break;
			}
		
			driver = new RemoteWebDriver(huburl, cap);
			
			break;
			
		default:
			
			log.error("Wrong run type of the project");
			System.out.println("Wrong run type of the project");
			Assert.fail("Invalid Project run type");
			break;
		}
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		context.setAttribute("driver", driver);
		
		log.info("Driver initializing finished");
		System.out.println("Driver initializing finished");
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		
		log.info("Driver closed");
		System.out.println("Driver closed");
		
		driver.quit();
	}
	
}
