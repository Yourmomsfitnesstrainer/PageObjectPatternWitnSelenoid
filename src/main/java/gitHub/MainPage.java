package gitHub;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MainPage {

    final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(final String query) {
        driver.findElement(By.xpath("//input[@class[contains(., \"gLFyf\")]]")).sendKeys(query);
        driver.findElement(By.xpath("//input[@class[contains(., \"gLFyf\")]]")).sendKeys(Keys.ENTER);
    }
}
