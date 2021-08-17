package pages;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class FlightSearchResultsPage extends BasePage {
		
		@FindBy(xpath="//ul[@data-test-id='listings']/li[1]")
		private WebElement firstResult;
		
		public FlightSearchResultsPage() {
			PageFactory.initElements(driver, this);
		}
		
		public boolean isResultDisplayed() {
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			return wait.until(ExpectedConditions.visibilityOf(firstResult)).isDisplayed();
			
			//wait.until(ExpectedConditions.prese)
			
		}

	}

	
