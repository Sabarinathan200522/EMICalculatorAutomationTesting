package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage(){
		
	}
	
    public BasePage(WebDriver driver) {
    	
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }
      
    public String getTextBoxValue(WebElement txtBox,WebElement clickable,String value) {
    	
//    	txtBox.clear();
    	txtBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
    	txtBox.sendKeys(value);
    	clickable.click();
		return txtBox.getAttribute("value");
    }
    
    public List<String> navBarListing(List<WebElement> navbar) {
    	List<String> lTypes=new ArrayList<>();
		for(WebElement i:navbar) {
			lTypes.add(i.getText());
		}
		return lTypes;
    }
    public String getMonthYearTextboxValue(String monthOrYear,WebElement txtBox,WebElement monthOrYearBtn) {
    	
    	txtBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
    	txtBox.sendKeys(monthOrYear);
    	monthOrYearBtn.click();
    	monthOrYearBtn.click();
    	return txtBox.getAttribute("value");
    }
    
    public String textboxToSlider(WebElement sliderHandle,int txtboxValue,WebElement txtBox,double minValue,double maxValue) {
        
        txtBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        txtBox.sendKeys(txtboxValue+"");
        txtBox.sendKeys(Keys.ENTER);
        String sliderPercent=sliderHandle.getAttribute("style");
        double sliderPercentMoved=Double.parseDouble(sliderPercent.replaceAll("[^0-9.]", ""));
        double range=maxValue-minValue;
        double calculatedValue=minValue+(range*(sliderPercentMoved/100.0));
        int sliderValue=(int)Math.round(calculatedValue);
        return sliderValue+"";
    }
    
    public String sliderToTextbox(WebElement fullSlider,WebElement sliderHandle,double targetValue,WebElement txtBox,double minValue,double maxValue) {
        
    	int sliderWidth=fullSlider.getSize().getWidth();
        int handleWidth=sliderHandle.getSize().getWidth();
        int movableSpace=sliderWidth-handleWidth;
        double range=maxValue-minValue;
        double targetPercentage=(targetValue-minValue)/range;
        int targetPixelOffsetFromStart=(int)Math.round(targetPercentage*movableSpace);
        int trackStartX=fullSlider.getLocation().getX();
        int currentHandleX=sliderHandle.getLocation().getX();
        int targetAbsoluteX=trackStartX+targetPixelOffsetFromStart;
        int dragDistance=targetAbsoluteX-currentHandleX;
        Actions actions=new Actions(driver);
        actions.dragAndDropBy(sliderHandle,dragDistance,0).perform();

        
        return txtBox.getAttribute("value").replace(",","");
    }
    
    
    public String sliderToTextbox(WebElement fullSlider,WebElement sliderHandle,WebElement slider,double sliderValue,WebElement txtBox,double unit,String sliderName) {
    	if(sliderName.equals("interest slider")) {
        	sliderValue-=5;		
    	}
    	int sliderWidth = fullSlider.getSize().getWidth();
		int start = sliderHandle.getLocation().getX();
		Actions actions = new Actions(driver);
		double  singleUnit=sliderWidth/unit;
		int moveOffset=(int)(Math.floor(singleUnit*sliderValue));
		actions.dragAndDropBy(sliderHandle, -start, 0).perform();
		actions.dragAndDropBy(slider,moveOffset,0).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	return txtBox.getAttribute("value").replace(",","");
    }
}
