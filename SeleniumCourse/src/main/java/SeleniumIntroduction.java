import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntroduction {
    public static void main(String[] args) {
        //Invoking Browser
        /* For Chrome */
        //chromedriver.exe -> Chrome browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\BLACKFURY\\Desktop\\Kurs Selenium\\chromedriver.exe");
        //webdriver.chrome.driver -> value of path

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.youtube.com/");

        System.out.println(driver.getTitle() + " " + driver.getCurrentUrl());
        driver.close();
    }
}
