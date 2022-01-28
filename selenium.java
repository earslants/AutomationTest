import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.net.MalformedURLException;

public class selenium {

    private ChromeDriver driver;
    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://pt.com.tr");

    }
    @Test
    public void Login() throws InterruptedException {
        TestCase1();
        Thread.sleep(3000);
        TestCase2();
        Thread.sleep(3000);
        TestCase3();
        Thread.sleep(3000);
        TestCase4();
    }
    @Test
    public void SignUp() throws InterruptedException {
        TestCase5();
        Thread.sleep(3000);
        TestCase6();
        Thread.sleep(3000);
        TestCase7();
        Thread.sleep(3000);
        TestCase8();
        Thread.sleep(3000);
        TestCase9();
        Thread.sleep(3000);
        TestCase10();
        Thread.sleep(3000);
    }
    public void TestCase1() { //Giriş yaparken herhangi bir şey girilmediği zaman uyarı verir.
        WebElement giris = driver.findElement(By.xpath("//*[@id=\"header-middle\"]/div/div/div[2]/div[1]/div/a/div[2]/span"));
        giris.click();
        WebElement buton = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/form/div[4]/div/button"));
        buton.click();
        String message = driver.findElement(By.id("username")).getAttribute("validationMessage");
        Assert.assertEquals(message,"Lütfen bu alanı doldurun.");
    }
    public void TestCase2() { //Email formatı doğru olmadığında hata verir..
        WebElement giris = driver.findElement(By.xpath("//*[@id=\"header-middle\"]/div/div/div[2]/div[1]/div/a/div[2]/span"));
        giris.click();
        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("emirhan");
        WebElement buton = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/form/div[4]/div/button"));
        buton.click();
        String message = driver.findElement(By.id("username")).getAttribute("validationMessage");
        Assert.assertEquals(message,"Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"emirhan\" adresinde \"@\" eksik.");
        }
    public void TestCase3() { //Şifre girilmediğinde hata verir.
        WebElement giris = driver.findElement(By.xpath("//*[@id=\"header-middle\"]/div/div/div[2]/div[1]/div/a/div[2]/span"));
        giris.click();
        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("emirhan@emirhan.com");
        WebElement buton = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/form/div[4]/div/button"));
        buton.click();
        String message = driver.findElement(By.id("password")).getAttribute("validationMessage");
        Assert.assertEquals(message,"Lütfen bu alanı doldurun.");
    }
    public void TestCase4() {
        WebElement giris = driver.findElement(By.xpath("//*[@id=\"header-middle\"]/div/div/div[2]/div[1]/div/a/div[2]/span"));
        giris.click();
        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("emirhan@emirhan.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");
        WebElement buton = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/form/div[4]/div/button"));
        buton.click();
        String message = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/div[1]")).getText();
        Assert.assertEquals(message,"×\n" + "Lütfen güvenlik kutusunu işaretleyiniz!");
    }

    @Test
    public void UrunFiyatAir() throws InterruptedException {
        WebElement mac = driver.findElement(By.xpath("//*[@id=\"header-bottom\"]/div/div/div[1]/nav/ul/li[1]/a/span"));
        mac.click();
        WebElement macbookAir = driver.findElement(By.xpath("//*[@id=\"firsat-banner\"]/div/div/div/div/div[1]/div/a/img"));
        macbookAir.click();
        driver.findElement(By.xpath("//*[@id=\"items-by-category\"]/div/div/div[1]/div[3]/div/div[1]/div/a/div/img")).click();
        Thread.sleep(5000);
        String fiyatAir = driver.findElement(By.xpath("//*[@id=\"productDetailsAddToCartForm\"]/div/ul[1]/li/div[2]/div[2]")).getText();
        System.out.println("Ürünün fiyatı : " + fiyatAir);
    }
    @Test
    public void UrunFiyatPro() throws InterruptedException {
        WebElement mac = driver.findElement(By.xpath("//*[@id=\"header-bottom\"]/div/div/div[1]/nav/ul/li[1]/a/span"));
        mac.click();
        WebElement macbookPro = driver.findElement(By.xpath("//*[@id=\"firsat-banner\"]/div/div/div/div/div[2]/div/a/img"));
        macbookPro.click();
        driver.findElement(By.xpath("//*[@id=\"items-by-category\"]/div/div/div[1]/div[3]/div/div[1]/div/a/div/img")).click();
        Thread.sleep(5000);
        String fiyatPro = driver.findElement(By.xpath("//*[@id=\"productDetailsAddToCartForm\"]/div/ul[1]/li/div[2]/div[2]")).getText();
        System.out.println(fiyatPro);
    }

    public void TestCase5() throws InterruptedException { // İsim alanı doldurulmazsa uyarı verir.
        WebElement giris = driver.findElement(By.xpath("//*[@id=\"header-middle\"]/div/div/div[2]/div[1]/div/a/div[2]/span"));
        giris.click();
        WebElement uyeOl = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/div/a"));
        uyeOl.click();
        driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/form/div[6]/div/button")).click();
        String message = driver.findElement(By.id("name")).getAttribute("validationMessage");
        System.out.println(message);
    }
    public void TestCase6() { // Mail alanı doldurulmazsa uyarı verir.
        WebElement giris = driver.findElement(By.xpath("//*[@id=\"header-middle\"]/div/div/div[2]/div[1]/div/a/div[2]/span"));
        giris.click();
        WebElement uyeOl = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/div/a"));
        uyeOl.click();
        WebElement isim = driver.findElement(By.id("name"));
        isim.sendKeys("emirhan");
        driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/form/div[6]/div/button")).click();
        String message = driver.findElement(By.id("username")).getAttribute("validationMessage");
        System.out.println(message);
    }
    public void TestCase7() { // email formatı yanlışsa uyarı verir.
        WebElement giris = driver.findElement(By.xpath("//*[@id=\"header-middle\"]/div/div/div[2]/div[1]/div/a/div[2]/span"));
        giris.click();
        WebElement uyeOl = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/div/a"));
        uyeOl.click();
        WebElement isim = driver.findElement(By.id("name"));
        isim.sendKeys("emirhan");
        WebElement mail = driver.findElement(By.id("username"));
        mail.sendKeys("emirhan");
        driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/form/div[6]/div/button")).click();
        String message = driver.findElement(By.id("username")).getAttribute("validationMessage");
        System.out.println(message);
    }
    public void TestCase8() { // Şifre girilmezse uyarı verir.
        WebElement giris = driver.findElement(By.xpath("//*[@id=\"header-middle\"]/div/div/div[2]/div[1]/div/a/div[2]/span"));
        giris.click();
        WebElement uyeOl = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/div/a"));
        uyeOl.click();
        WebElement isim = driver.findElement(By.id("name"));
        isim.sendKeys("emirhan");
        WebElement mail = driver.findElement(By.id("username"));
        mail.sendKeys("emirhan@emirhan.com");
        driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/form/div[6]/div/button")).click();
        String message = driver.findElement(By.id("password")).getAttribute("validationMessage");
        System.out.println(message);
    }
    public void TestCase9() { // Üyelik sözleşmesi kabul edilmezse uyarı verir.
        WebElement giris = driver.findElement(By.xpath("//*[@id=\"header-middle\"]/div/div/div[2]/div[1]/div/a/div[2]/span"));
        giris.click();
        WebElement uyeOl = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/div/a"));
        uyeOl.click();
        WebElement isim = driver.findElement(By.id("name"));
        isim.sendKeys("emirhan");
        WebElement mail = driver.findElement(By.id("username"));
        mail.sendKeys("emirhan@emirhan.com");
        WebElement sifre = driver.findElement(By.id("password"));
        sifre.sendKeys("123456789");
        driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/form/div[6]/div/button")).click();
        String message = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/div[1]")).getText();
        System.out.println(message);
    }
    public void TestCase10() { // Captcha işaretlenmezse uyarı verir.
        WebElement giris = driver.findElement(By.xpath("//*[@id=\"header-middle\"]/div/div/div[2]/div[1]/div/a/div[2]/span"));
        giris.click();
        WebElement uyeOl = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/div/a"));
        uyeOl.click();
        WebElement isim = driver.findElement(By.id("name"));
        isim.sendKeys("emirhan");
        WebElement mail = driver.findElement(By.id("username"));
        mail.sendKeys("emirhan@emirhan.com");
        WebElement sifre = driver.findElement(By.id("password"));
        sifre.sendKeys("123456789");
        WebElement sozlesme = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/form/div[4]/div/label"));
        sozlesme.click();
        driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/form/div[6]/div/button")).click();
        String message = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div[2]/div[1]")).getText();
        System.out.println(message);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
