package testPrograms;

import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;


public class HotelBookingTest {

	WebDriver driver;

	@FindBy(linkText = "Hotels")

	private WebElement hotelLink;

	@FindBy(id = "Tags")

	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")

	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")

	private WebElement travellerSelection;

	@Test

	public void shouldBeAbleToSearchForHotels() {

		setDriverPath();
		
		driver = new ChromeDriver();

		driver.get("https://www.cleartrip.com/");
		
		PageFactory.initElements(driver, this);

		hotelLink.click();

		localityTextBox.sendKeys("Indiranagar, Bangalore");

		new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");

		searchButton.click();
		
		driver.quit();

	}

	
	private void setDriverPath() {

		if (PlatformUtil.isMac()) {

			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

		}

		if (PlatformUtil.isWindows()) {

			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		}

		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_linux");

		}

	}

}
