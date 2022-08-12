package pms.com.qa.pms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import pms.com.qa.pms.runner.PmsApplication;

@SpringBootTest(classes = PmsApplication.class)
public class SeleniumTest2 {

	private static WebDriver driver;

	@BeforeAll
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void tearDown() {
		driver.quit();
	}

	@Test
	public void home() {
		driver.get("http//localhost:9005");
		assertEquals(driver.findElement(By.xpath("//h1")).getText(), "PMS sytem");
		assertEquals(driver.getTitle(), "Home");
	}

}
