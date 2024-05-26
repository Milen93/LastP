import org.example.WebElement;

@FindBy(xpath = "//button[contains(text(),'Login')]")
WebElement loginButton;

public MainPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}

public void clickLogin() {
    loginButton.click();
}@BeforeMethod
public void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://training.skillo-bg.com:4200/posts/all");
    mainPage = new MainPage(driver);
}

@Test
public void testLoginButton() {
    mainPage.clickLogin();
    // Add assertions as needed
    Assert.assertTrue(driver.getTitle().contains("Login"));
}

@AfterMethod
public void teardown() {
    driver.quit();
}@Override
public void onStart(ITestContext context) {}

@Override
public void onFinish(ITestContext context) {}

@Override
public void onTestStart(ITestResult result) {}

@Override
public void onTestSuccess(ITestResult result) {}

@Override
public void onTestSkipped(ITestResult result) {}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
@BeforeMethod
public void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://training.skillo-bg.com:4200/posts/all");
}

@AfterMethod
public void teardown() {
    if (driver != null) {
        driver.quit();
    }
}

public WebDriver getDriver() {
    return driver;
}