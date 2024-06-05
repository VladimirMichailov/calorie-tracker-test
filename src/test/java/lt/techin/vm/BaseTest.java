package lt.techin.vm;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://practice.expandtesting.com/tracalorie/?classId=e83a1e60-d212-4fa4-9e1c-f89284b2328a&assignmentId=bf2480e2-ae85-49e3-bbb4-6fc77a9d30d8&submissionId=92a6aa4a-f070-a961-cee6-21dd170931e2");

    }


//    @AfterEach
//    void teardown() {
//        driver.quit();
//    }

}
