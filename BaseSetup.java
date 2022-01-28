import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BaseSetup {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appActivity", "com.kerem.yedekparca.MainActivity");
        desiredCapabilities.setCapability("udid", "emulator-5554");
        desiredCapabilities.setCapability("appPackage", "com.kerem.yedekparca");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void TestCase1() { //Marka girilmezse uyarı mesajı verir.
        MobileElement el1 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/araba_modeli_tanimla");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el3 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/filtre");
        el3.click();
        String text1 = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
        System.out.println(text1);
        Assert.assertEquals("Marka kısmı boş geçilemez",text1);
    }
    @Test
    public void TestCase2() { //Gerçek dışı bir yıl girilirse uyarı mesajı verir.
        MobileElement el1 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/araba_modeli_tanimla");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/arabaMarkasiGirme");
        el2.sendKeys("audi");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el3 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/modelGirme");
        el3.sendKeys("a3");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el4 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/yilGirme");
        el4.sendKeys("1900");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el5 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/filtre");
        el5.click();
        String text1 = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
        System.out.println(text1);
        Assert.assertEquals("Girilen yıllar istenilen aralıkta değildir(1950-2023)",text1);
    }

    @Test
    public void TestCase3() { //Parça adı girilmezse uyarı mesajı verir.
        MobileElement el1 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/yedek_parca_ekle");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el3 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/kaydet");
        el3.click();
        String text1 = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
        System.out.println(text1);
        Assert.assertEquals("Parça Adı kısmı boş geçilemez",text1);
    }

    @Test
    public void TestCase4() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/yedek_parca_ekle");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parca_adi");
        el2.sendKeys("parcaAdi");
        MobileElement el3 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/kaydet");
        el3.click();
        String text1 = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
        System.out.println(text1);
        Assert.assertEquals("Parça markası kısmı boş geçilemez",text1);

    }
    @Test
    public void TestCase5() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/yedek_parca_ekle");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parca_adi");
        el2.sendKeys("parcaAdi");
        MobileElement el3 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parca_markasi");
        el3.sendKeys("parcaMarkasi");
        MobileElement el4 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/kaydet");
        el4.click();
        String text1 = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
        System.out.println(text1);
        Assert.assertEquals("Parça kategorisi kısmı boş geçilemez",text1);

    }
    @Test
    public void TestCase6() {

        MobileElement el1 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/yedek_parca_ekle");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parca_adi");
        el2.sendKeys("audi");
        MobileElement el3 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parca_markasi");
        el3.sendKeys("abc");
        MobileElement el4 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parca_kategorisi");
        el4.sendKeys("abc");
        MobileElement el6 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/arac_model");
        el6.sendKeys("abc");
        MobileElement el7 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/kasa_tipi");
        el7.sendKeys("abc");
        MobileElement el8 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/arac_yil");
        el8.sendKeys("1955");
        MobileElement el9 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/stok_adedi");
        el9.sendKeys("10");
        MobileElement el10 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/kaydet");
        el10.click();
        String text1 = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
        System.out.println(text1);
        Assert.assertEquals("Araç markası kısmı boş geçilemez",text1);
    }
    @Test
    public void TestCase7() {

        MobileElement el1 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/yedek_parca_ekle");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parca_adi");
        el2.sendKeys("audi");
        MobileElement el3 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parca_markasi");
        el3.sendKeys("abc");
        MobileElement el4 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parca_kategorisi");
        el4.sendKeys("abc");
        MobileElement el5 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/arac_marka");
        el5.sendKeys("abc");
        MobileElement el6 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/arac_model");
        el6.sendKeys("abc");
        MobileElement el7 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/kasa_tipi");
        el7.sendKeys("abc");
        MobileElement el8 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/arac_yil");
        el8.sendKeys("1955");
        MobileElement el9 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/stok_adedi");
        el9.sendKeys("10");
        MobileElement el10 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/kaydet");
        el10.click();
        String text1 = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
        System.out.println(text1);
        Assert.assertEquals("Belirtilen Türde Bir Araç Bulunamamıştır Lütfen Sistem Yöneticisi İle Görüşün",text1);
    }
    @Test
    public void TestCase8() {

        MobileElement el1 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/yedek_parca_ekle");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parca_adi");
        el2.sendKeys("audi");
        MobileElement el3 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parca_markasi");
        el3.sendKeys("abc");
        MobileElement el4 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parca_kategorisi");
        el4.sendKeys("abc");
        MobileElement el5 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/arac_marka");
        el5.sendKeys("abc");
        MobileElement el6 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/arac_model");
        el6.sendKeys("abc");
        MobileElement el7 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/kasa_tipi");
        el7.sendKeys("abc");
        MobileElement el8 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/arac_yil");
        el8.sendKeys("1925");
        MobileElement el9 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/stok_adedi");
        el9.sendKeys("10");
        MobileElement el10 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/kaydet");
        el10.click();
        String text1 = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
        System.out.println(text1);
        Assert.assertEquals("Girilen yıllar istenilen aralıkta değildir(1950-2023)",text1);

    }
    @Test
    public void TestCase9() {

        MobileElement el1 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/yedek_parca_ekle");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parca_adi");
        el2.sendKeys("audi");
        MobileElement el3 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parca_markasi");
        el3.sendKeys("abc");
        MobileElement el4 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parca_kategorisi");
        el4.sendKeys("abc");
        MobileElement el5 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/arac_marka");
        el5.sendKeys("abc");
        MobileElement el6 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/arac_model");
        el6.sendKeys("abc");
        MobileElement el7 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/kasa_tipi");
        el7.sendKeys("abc");
        MobileElement el8 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/arac_yil");
        el8.sendKeys("1955");
        MobileElement el10 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/kaydet");
        el10.click();
        String text1 = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
        System.out.println(text1);
        Assert.assertEquals("Stok adedi kısmı boş geçilemez",text1);

    }
    @Test
    public void TestCase10() {

        MobileElement el1 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/arac_ekle");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/button2");
        el2.click();
        String text1 = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
        System.out.println(text1);
        Assert.assertEquals("Marka kısmı boş geçilemez",text1);
    }
    @Test
    public void TestCase11() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/arac_ekle");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/marka");
        el2.sendKeys("audi");
        MobileElement el3 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/button2");
        el3.click();
        String text1 = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
        System.out.println(text1);
        Assert.assertEquals("Model kısmı boş geçilemez",text1);
    }
    @Test
    public  void TestCase12() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/arac_ekle");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/marka");
        el2.sendKeys("audi");
        MobileElement el3 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/model");
        el3.sendKeys("abc");
        MobileElement el4 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/button2");
        el4.click();
        String text1 = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
        System.out.println(text1);
        Assert.assertEquals("Kasa tipi kısmı boş geçilemez",text1);
    }
    @Test
    public  void TestCase13() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/arac_ekle");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/marka");
        el2.sendKeys("audi");
        MobileElement el3 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/model");
        el3.sendKeys("abc");
        MobileElement el4 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/kasaTipi");
        el4.sendKeys("abc");
        MobileElement el5 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/uretimYili");
        el5.sendKeys("1925");
        MobileElement el6 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/button2");
        el6.click();
        String text1 = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
        System.out.println(text1);
        Assert.assertEquals("Girilen yıllar istenilen aralıkta değildir(1950-2023)",text1);
    }
    @Test
    public  void TestCase14() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/stok_sorgulama");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/button3");
        el2.click();
        String text1 = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
        System.out.println(text1);
        Assert.assertEquals("Parça Adı kısmı boş geçilemez",text1);
    }
    @Test
    public  void TestCase15() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/stok_sorgulama");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parcaAdi");
        el2.sendKeys("abc");
        MobileElement el3 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/button3");
        el3.click();
        String text1 = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
        System.out.println(text1);
        Assert.assertEquals("Parça Markası kısmı boş geçilemez",text1);
    }
    @Test
    public  void TestCase16() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/stok_sorgulama");
        el1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parcaAdi");
        el2.sendKeys("abc");
        MobileElement el3 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parcaMarka");
        el3.sendKeys("abc");
        MobileElement el4 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/parcaKategori");
        el4.sendKeys("abc");
        MobileElement el5 = (MobileElement) driver.findElementById("com.kerem.yedekparca:id/button3");
        el5.click();
        String text1 = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
        System.out.println(text1);
        Assert.assertEquals("Aranan Özellikte Parça Bulunamamıştır",text1);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
