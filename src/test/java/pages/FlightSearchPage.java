package pages;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class FlightSearchPage extends BasePage {
		
		
		@FindBy(css="button[data-stid=location-field-leg1-origin-menu-trigger]")
		private WebElement originBtn;
		
		@FindBy(id="location-field-leg1-origin")
		private WebElement originInputTxtbx;
		
		@FindBy(css="button[data-stid=location-field-leg1-destination-menu-trigger]")
		private WebElement destinationBtn;
		
		@FindBy(id="location-field-leg1-destination")
		private WebElement destinationTxtbx;
		
		@FindBy(id="d1-btn")
		private WebElement checkinBtn;
		
		@FindBy(id="d2-btn")
		private WebElement checkoutBtn;
		
		@FindBy(css="button[data-stid=apply-date-picker]")
		private WebElement doneBtn;
		
		@FindBy(css="button[data-testid=submit-button]")
		private WebElement submitBtn;
		
		public FlightSearchPage() {
			PageFactory.initElements(driver, this);
		}
		
		public FlightSearchResultsPage searchFlight(String origin, String destination, String checkinDate, String checkoutDate) {
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			
			//originBtn.click();
			click(originBtn, "Origin Button");
			
			// originInputTxtbx.sendKeys(origin, Keys.ENTER);
			typeWithEnter(originInputTxtbx, "Origin Input Text Box", origin);
			
			// destinationBtn.click();
			click(destinationBtn, "Destination Button");
			
			// destinationTxtbx.sendKeys(destination, Keys.ENTER);
			typeWithEnter(destinationTxtbx, "Destination Input Text Box", destination);
			
			//checkinBtn.click();
			click(checkinBtn, "Checkin date button");
			
			//driver.findElement(By.xpath("//button[@aria-label='"+checkinDate+"']")).click();
			WebElement checkInDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='"+checkinDate+"']")));
			//checkInDate.click();
			click(checkInDate, checkinDate);
			
			//doneBtn.click();
			click(doneBtn, "Done Button");
			//checkoutBtn.click();
			click(checkoutBtn, "checkout button");
			//driver.findElement(By.xpath("//button[@aria-label='"+checkoutDate+"']")).click();
			WebElement checkOutDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='"+checkoutDate+"']")));
			checkOutDate.click();
			click(checkOutDate, checkoutDate);
			//doneBtn.click();
			click(doneBtn, "Done Button");
			//submitBtn.click();
			click(submitBtn, "Submit Button");
			
			
			return new FlightSearchResultsPage();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		

	}

