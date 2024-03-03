import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MtsTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.mts.by");
        try {
            WebElement cookieAgreeButton = driver.findElement(By.cssSelector("#cookie-agree"));
            cookieAgreeButton.click();
        } catch (NoSuchElementException ignored){}
    }
    @AfterEach
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void testPaymentServices(){
        WebElement phoneNumberField = driver.findElement(By.cssSelector("#connection-phone"));
        assert phoneNumberField.getAttribute("placeholder").equals("Номер телефона");

        WebElement sumField = driver.findElement(By.cssSelector("#connection-sum"));
        assert sumField.getAttribute("placeholder").equals("Сумма");

        WebElement emailField = driver.findElement(By.cssSelector("#connection-email"));
        assert emailField.getAttribute("placeholder").equals("E-mail для отправки чека");

        WebElement paymentButton = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        paymentButton.click();

        WebElement homeInternetButton = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p"));
        homeInternetButton.click();

        WebElement phoneNumberField2 = driver.findElement(By.cssSelector("#internet-phone"));
        assert  phoneNumberField2.getAttribute("placeholder").equals("Номер абонента");

        WebElement sumField2 = driver.findElement(By.cssSelector("#internet-sum"));
        assert  sumField2.getAttribute("placeholder").equals("Сумма");

        WebElement emailField2 = driver.findElement(By.cssSelector("#internet-email"));
        assert emailField2.getAttribute("placeholder").equals("E-mail для отправки чека");

        paymentButton.click();

        WebElement installmentPlanButton = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p"));
        installmentPlanButton.click();

        WebElement accountNumberField = driver.findElement(By.cssSelector("#score-instalment"));
        assert  accountNumberField.getAttribute("placeholder").equals("Номер счета на 44");

        WebElement sumField3 = driver.findElement(By.cssSelector("#instalment-sum"));
        assert  sumField3.getAttribute("placeholder").equals("Сумма");

        WebElement emailField3 = driver.findElement(By.cssSelector("#instalment-email"));
        assert  emailField3.getAttribute("placeholder").equals("E-mail для отправки чека");

        paymentButton.click();

        WebElement debtButton = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p"));
        debtButton.click();

        WebElement accountNumber2 = driver.findElement(By.cssSelector("#score-arrears"));
        assert  accountNumber2.getAttribute("placeholder").equals("Номер счета на 2073");

        WebElement sumField4 = driver.findElement(By.cssSelector("#arrears-sum"));
        assert  sumField4.getAttribute("placeholder").equals("Сумма");

        WebElement emailField4 = driver.findElement(By.cssSelector("#arrears-email"));
        assert  emailField4.getAttribute("placeholder").equals("E-mail для отправки чека");

    }

    @Test
    public void testCommunicationServices() {
        WebElement phoneNumberField = driver.findElement(By.cssSelector("#connection-phone"));
        phoneNumberField.sendKeys("297777777");

        WebElement sumField = driver.findElement(By.cssSelector("#connection-sum"));
        sumField.sendKeys("50");

        WebElement emailField = driver.findElement(By.cssSelector("#connection-email"));
        emailField.sendKeys("aqa@mail.ru");

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection > button"));
        continueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bepaid-iframe")));





    }
}
