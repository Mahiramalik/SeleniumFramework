
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelSearchPage extends BasePage {
	
	
	@FindBy(css="button[data-stid*=location-field-destination]")
	private WebElement destinationBtn;
	
	@FindBy(id="location-field-destination")
	private WebElement destinationInputTxtBx;
	
	@FindBy(id="d1-btn")
	private WebElement checkinBtn;
	
	@FindBy(id="d2-btn")
	private WebElement checkoutBtn;
	
	@FindBy(css="button[data-stid=apply-date-picker]")
	private WebElement doneBtn;
	
	@FindBy(css="button[data-testid=submit-button]")
	private WebElement submitBtn;
	
	public HotelSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HotelSearchResultsPage searchHotel(String destination, String checkinDate, String checkoutDate) {
		
		
		destinationBtn.click();
		//click(destinationBtn, "Destination Button");
				
		
		destinationInputTxtBx.sendKeys(destination, Keys.ENTER);
		//typeWithEnter(destinationInputTxtBx, "Destination Input Text Box", destination);
		
		
		checkinBtn.click();
		//click(checkinBtn, "Checkin date button");
		
		
		driver.findElement(By.xpath("//button[@aria-label='"+checkinDate+"']")).click();
		
		//click(driver.findElement(By.xpath("//button[@aria-label='"+checkinDate+"']")), checkinDate);
		
		doneBtn.click();
		//click(doneBtn, "Done button");
		
		checkoutBtn.click();
		//click(checkoutBtn, "Checkout Button");
		
		driver.findElement(By.xpath("//button[@aria-label='"+checkoutDate+"']")).click();
		//click(driver.findElement(By.xpath("//button[@aria-label='"+checkoutDate+"']")), checkoutDate);
		
		doneBtn.click();
		//click(doneBtn, "Done button");


		submitBtn.click();
		//click(submitBtn, "Submit Button");
		
		return new HotelSearchResultsPage();

		
		
	}
	
	
	
	
	
	
	
	
	

}
