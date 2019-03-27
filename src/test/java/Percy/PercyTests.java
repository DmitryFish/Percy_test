package Percy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpServer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.percy.selenium.Percy;

public class PercyTests {

    private static ExecutorService serverExecutor;
    private static HttpServer server;
    private static WebDriver driver;
    private static Percy percy;

    @BeforeEach
    public void startAppAndOpenBrowser(){
        //serverExecutor = Executors.newFixedThreadPool(1);
        //server = App.startServer(serverExecutor);

        System.setProperty("webdriver.chrome.driver", "D://Fish//chromedriver.exe");
        //driver.manage().window().maximize();
        driver = new ChromeDriver();
        percy = new Percy(driver);
    }

    @AfterEach
    public void closeBrowser() {
        // Close our test browser.
        driver.quit();
        // Shutdown our server and make sure the threadpool also terminates.
        //server.stop(1);
        //serverExecutor.shutdownNow();
    }

    @Test
    public void loadsGooglePage() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(5000);
        // Take a Percy snapshot.
        percy.snapshot("Google Page");
    }

}
