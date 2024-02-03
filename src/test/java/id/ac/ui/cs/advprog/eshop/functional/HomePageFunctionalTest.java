package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class HomePageFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setUpTest(){
        baseUrl=String.format("%s:%d",testBaseUrl, serverPort);
    }

    @Test
    void pageTitle_isCorrect(ChromeDriver driver) throws Exception{
        driver.get(baseUrl);
        String pageTitle = driver.getTitle();

        assertEquals("ADV Shop", pageTitle);
    }

    @Test
    void welcomeMessage_homepage_isCorrect(ChromeDriver driver) throws Exception{
        driver.get(baseUrl);
        String welcomeMessage = driver.findElement(By.tagName("h3")).getText();

        assertEquals("Welcome", welcomeMessage);
    }

    @Test
    void createProduct_isCorrect(ChromeDriver driver) throws Exception{
        driver.get(String.format(baseUrl+"/product/create"));
        driver.findElement(By.id("nameInput")).sendKeys("lala");
        driver.findElement(By.id("quantityInput")).sendKeys("1231");
        driver.findElement(By.className("btn")).click();

        String productList = driver.findElement(By.tagName("h2")).getText();
        assertEquals("Product' List", productList);
        List<WebElement> productInfo = driver.findElements(By.tagName("td"));
        WebElement productName = productInfo.get(0);
        assertEquals("lala", productName.getText());
        WebElement productQuantity = productInfo.get(1);
        assertEquals("1231", productQuantity.getText());
    }

    @Test
    void createEditProduct_isCorrect(ChromeDriver driver) throws Exception{
        driver.get(String.format(baseUrl+"/product/create"));
        driver.findElement(By.id("nameInput")).sendKeys("lala");
        driver.findElement(By.id("quantityInput")).sendKeys("1231");
        driver.findElement(By.className("btn")).click();

        String productList = driver.findElement(By.tagName("h2")).getText();
        assertEquals("Product' List", productList);
        List<WebElement> productInfo = driver.findElements(By.tagName("td"));
        WebElement productName = productInfo.get(0);
        assertEquals("lala", productName.getText());
        WebElement productQuantity = productInfo.get(1);
        assertEquals("1231", productQuantity.getText());

        List<WebElement> links = driver.findElements(By.tagName("a"));
        WebElement linkEdit = links.get(1);
        linkEdit.click();

        driver.findElement(By.id("nameInput")).sendKeys("budiPekerti");
        driver.findElement(By.id("quantityInput")).sendKeys("84021");
        driver.findElement(By.className("btn")).click();

        productInfo = driver.findElements(By.tagName("td"));
        productName = productInfo.get(0);
        assertNotEquals("lala", productName.getText());
        assertEquals("budiPekerti", productName.getText());
        productQuantity = productInfo.get(1);
        assertNotEquals("1231", productQuantity.getText());
        assertEquals("84021", productQuantity.getText());
    }

    @Test
    void createDelete_isCorrect(ChromeDriver driver) throws Exception{
        driver.get(String.format(baseUrl+"/product/create"));
        driver.findElement(By.id("nameInput")).sendKeys("lala");
        driver.findElement(By.id("quantityInput")).sendKeys("1231");
        driver.findElement(By.className("btn")).click();

        String productList = driver.findElement(By.tagName("h2")).getText();
        assertEquals("Product' List", productList);
        List<WebElement> productInfo = driver.findElements(By.tagName("td"));
        WebElement productName = productInfo.get(0);
        assertEquals("lala", productName.getText());
        WebElement productQuantity = productInfo.get(1);
        assertEquals("1231", productQuantity.getText());

        List<WebElement> links = driver.findElements(By.tagName("a"));
        WebElement linkDelete = links.get(2);
        linkDelete.click();

        productInfo = driver.findElements(By.tagName("td"));
        assertEquals(0,productInfo.size());

    }
}
