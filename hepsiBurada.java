import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.aop.ThrowsAdvice;
import org.testng.Assert;

public class hepsiBurada {

    private ChromeDriver driver;
    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);
        driver.get("https://hepsiburada.com");
    }
    @Test
    public void TestCase1() throws InterruptedException { // Giriş ekranında email girilmezse hata verir.

        WebElement girisButon = driver.findElement(By.id("myAccount"));
        girisButon.click();
        Thread.sleep(1000);
        WebElement giris = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        giris.click();
        Thread.sleep(5000);
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(1000);
        String message = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div/div/div[2]/div[2]/div/div/form/div/div/div[2]")).getText();
        System.out.println(message);
    }
    @Test
    public void TestCase2() throws InterruptedException { // Girilen email sistemde kayıtlı değilse uyarı mesajı verir.

        WebElement girisButon = driver.findElement(By.id("myAccount"));
        girisButon.click();
        Thread.sleep(1000);
        WebElement giris = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        giris.click();
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.id("txtUserName"));
        username.sendKeys("emirhan@emirhan.com");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(5000);
        String message = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[2]")).getText();
        System.out.println(message);
    }
    @Test
    public void TestCase3() throws InterruptedException { // Girilen şifre hatalıysa uyarı verir.
        WebElement girisButon = driver.findElement(By.id("myAccount"));
        girisButon.click();
        Thread.sleep(2000);
        WebElement giris = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        giris.click();
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.id("txtUserName"));
        username.sendKeys("oflemir46@gmail.com");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(5000);
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.id("btnEmailSelect")).click();
        Thread.sleep(2000);
        String message = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div/div/div[4]/div/div/div[2]")).getText();
        System.out.println(message);
    }
    @Test
    public void TestCase4() throws InterruptedException { // Arama panelinden bilgisayarı aratıp, en pahalı bilgisayarın fiyatını yazdırır.
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"SearchBoxOld\"]/div/div/div[1]/div[2]/input"));
        searchBar.sendKeys("Bilgisayar");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"SearchBoxOld\"]/div/div/div[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("SortingBox")).click();
        Thread.sleep(20);
        driver.findElement(By.xpath("//*[@id=\"SortingBox\"]/div/div/div/div/div[2]/div/div/a[5]/label/div/div")).click();
        Thread.sleep(5000);
        String fiyat = driver.findElement(By.xpath("//*[@id=\"i0\"]/div/a/div[3]/div[1]/div[2]")).getText();
        System.out.println("En pahalı bilgisayarın fiyatı:" + fiyat);
    }
    @Test
    public void TestCase5() throws InterruptedException { // Arama panelinden bilgisayarı aratıp, en pahalı bilgisayarın fiyatını yazdırır.

        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"SearchBoxOld\"]/div/div/div[1]/div[2]/input"));
        searchBar.sendKeys("Bilgisayar");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"SearchBoxOld\"]/div/div/div[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("SortingBox")).click();
        Thread.sleep(20);
        driver.findElement(By.xpath("//*[@id=\"SortingBox\"]/div/div/div/div/div[2]/div/div/a[4]/label/div")).click();
        Thread.sleep(5000);
        String fiyat = driver.findElement(By.xpath("//*[@id=\"i0\"]/div/a/div[3]/div[1]/div[2]")).getText();
        System.out.println("En ucuz bilgisayarın fiyatı: " + fiyat);
    }
    @Test
    public void TestCase6() throws InterruptedException { // Sepete ürün ekler, sonra sepetten ürünü siler.

        Actions action = new Actions(driver);
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"SearchBoxOld\"]/div/div/div[1]/div[2]/input"));
        searchBar.sendKeys("Bilgisayar");
        driver.findElement(By.xpath("//*[@id=\"SearchBoxOld\"]/div/div/div[2]")).click();
        Thread.sleep(2000);
        WebElement bilgisayar1 = driver.findElement(By.id("i0"));
        action.moveToElement(bilgisayar1);
        driver.findElement(By.xpath("//*[@id=\"i0\"]/div/a/div[3]/div[3]")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("shoppingCart")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"onboarding_item_list\"]/div[2]/div[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"onboarding_item_list\"]/div[2]/div[3]/div/div/div/div[2]/button[2]")).click();
        Thread.sleep(3000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
