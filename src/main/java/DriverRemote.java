import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

public class DriverRemote {
     RemoteWebDriver driver;

    public DriverRemote() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("77.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        this.driver = new RemoteWebDriver(URI.create("http://0.0.0.0:8080/wd/hub").toURL(), capabilities);
        this.driver.manage().window().setSize(new Dimension(1280, 720));
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void init() {
        this.driver.get("https://www.google.ru/");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void close() {
        this.driver.quit();
    }

}
