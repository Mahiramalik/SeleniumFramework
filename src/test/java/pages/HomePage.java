
package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	@FindBy(css="a[href*=wizard-hotel-pwa][role=tab]")
	 private WebElement hotelTab;
	
	@FindBy(css="a[href*=wizard-flight-pwa][role=tab]")
	private WebElement flightTab;
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	public HotelSearchPage navigateToHotelSearchPage() {
		//hotelTab.click();
		click(hotelTab, "Hotel Tab");
		return new HotelSearchPage();
		}
	public FlightSearchPage navigateToFlightSearchPage() {
		// flightTab.click();
		 click(flightTab, "Flight Tab");
		return new FlightSearchPage();
	}
}
