package utilities;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	WebDriver driver;
	
	public ScreenShot(WebDriver driver){
		this.driver=driver;
	}
	
	public String takeScreenShot(String prompt) {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
		String formatted = now.format(formatter);
		
		String path=System.getProperty("user.dir")+"\\screenshots\\"+prompt+"-"+formatted+".png";
		File targetfile=new File(path);		
		sourcefile.renameTo(targetfile);
		return path;
		
	}
}
