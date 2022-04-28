import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class BookingFlightWithAccommodation {
    private static final String DRIVER_PATH = "C:\\Users\\BLACKFURY\\Desktop\\Kurs Selenium\\chromedriver.exe";
    private static final String FROM = "Warszawa";
    private static final String TO = "Chicago";
    private static final String DEPARTURE_DATE = "01.07.2022";
    private static final String RETURN_DATE = "15.07.2022";


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.lot.com/pl/pl");
        Assert.assertEquals(driver.getTitle(), "Rezerwuj loty na LOT.com | Bilety lotnicze LOT | LOT.com");

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        driver.findElement(By.cssSelector(".single-airport-picker")).click();
        driver.findElement(By.id("airport-selection-0")).sendKeys(FROM);
        driver.findElement(By.cssSelector(".desktopDropdown__options-wrapper li")).click();

        driver.findElement(By.cssSelector(".airport-to")).click();
        driver.findElement(By.id("airport-selection-1")).sendKeys(TO);
        driver.findElement(By.cssSelector(".desktopDropdown__options-wrapper li")).click();

        driver.findElement(By.className("booker-form-field--left")).click();
        driver.findElement(By.id("from-date-input")).sendKeys(DEPARTURE_DATE);
        driver.findElement(By.id("to-date-input")).sendKeys(RETURN_DATE);
        driver.findElement(By.cssSelector("button.modal__head-close.focusable.focusable--rounded")).click();

        driver.findElement(By.cssSelector("button.bookerFlight__submit-button.focusable.focusable--narrow")).click();
        Thread.sleep(35000); //bug ???
        driver.findElement(By.cssSelector("button.bookerFlight__submit-button.focusable.focusable--narrow")).click();

//        WebElement passengerCounter = driver.findElement(By.xpath("//input[@id='passengerTypeNumberPicker0']"));
//
//        Actions action = new Actions(driver);
//        action.moveToElement(passengerCounter)
//                .click()
//                .sendKeys(Keys.chord(Keys.CONTROL, "a"))
//                .build().perform();
        Thread.sleep(2000);
        //driver.quit();
    }
}
