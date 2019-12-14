import gitHub.MainPage;
import gitHub.SearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;

class MainPageTest {

    final DriverRemote driverWrapper = new DriverRemote();

    MainPageTest() throws MalformedURLException {
    }

    @BeforeEach
    void setUp() {
        driverWrapper.init();
    }

    @AfterEach
    void tearDown() {
        driverWrapper.close();
    }

    @Test
    void search() {
        MainPage mainPage = new MainPage(driverWrapper.getDriver());
        mainPage.search("QA");
        SearchPage searchPage = new SearchPage(driverWrapper.getDriver());
        List<WebElement> results = searchPage.getResults();
        Assertions.assertEquals(5, results.size());
    }
}