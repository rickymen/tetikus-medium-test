import com.github.ubaifadhli.pages.medium.*;
import com.github.ubaifadhli.runners.TetikusBaseRunner;
import com.github.ubaifadhli.util.*;
import org.testng.annotations.Test;

public class TetikusCoreRunner extends TetikusBaseRunner {
    private HomePage homePage;
    private LoginPage loginPage;

    @Test
    public void login() {
        String username = TetikusPropertiesReader.getPropertyAsString("login.twitter.username");
        String password = TetikusPropertiesReader.getPropertyAsString("login.twitter.password");

        homePage.openPage();

        homePage.goToTwitterLoginPage();

        loginPage.fillTwitterLoginCredentials(username, password);
        loginPage.waitForHomeTitle();
    }


    @Test
    public void searchForArticle() {
        String desiredArticle = "spring boot";
        String expectedTitle = "How to scale Microservices with Message Queues, Spring Boot, and Kubernetes";

        homePage.openPage();

        homePage.searchForArticle(desiredArticle);

        assertThat(homePage.getFirstArticleTitle(), equalTo(expectedTitle));
    }
}
