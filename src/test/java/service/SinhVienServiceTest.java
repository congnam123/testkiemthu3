package service;

import entity.SinhVien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SinhVienServiceTest {
    public SinhVienService service;

    @BeforeEach
    void setup(){
        service = new SinhVienService();
    }

    @Test
    void add(){
        SinhVien sv = new SinhVien("SV1","CONG",20,3.5f,2,"CNTT");
        service.addSV(sv);
        assertEquals(1,service.getAll().size());
    }

    @Test
    void delete(){
        SinhVien sv = new SinhVien("SV1","CONG",20,3.5f,2,"CNTT");
        service.addSV(sv);

        service.delete("SV1");
        assertEquals(0,service.getAll().size());
    }

    @Test
    void update(){
        SinhVien sv = new SinhVien("SV1","CONG",20,3.5f,2,"CNTT");
        service.addSV(sv);

        SinhVien sv1 = new SinhVien("SV1","CONG1",201,3.51f,21,"CNTT1");
        service.update(sv1,"SV1");
        assertAll(
                () -> assertEquals("CONG1", service.findBymaSV("SV1").getTen()),
                () -> assertEquals(201, service.findBymaSV("SV1").getTuoi()),
                () -> assertEquals(3.51f, service.findBymaSV("SV1").getDiemTrungBinh()),
                () -> assertEquals(21, service.findBymaSV("SV1").getKyHoc()),
                () -> assertEquals("CNTT1", service.findBymaSV("SV1").getChuyenNganh())
        );
    }

    @Test
    void findBymaSV(){
        SinhVien sv = new SinhVien("SV1","CONG",20,3.5f,2,"CNTT");
        service.addSV(sv);
        SinhVien timdc = service.findBymaSV("SV1");
        assertEquals("SV1",timdc.getMaSV());
    }

//    @Test
//    void dangkey(){
//        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        try {
//            driver.get("https://www.tutorialspoint.com/selenium/practice/register.php");
//            driver.findElement(By.id("firstname")).sendKeys("anhnam");
//            driver.findElement(By.id("lastname")).sendKeys("congnam");
//            driver.findElement(By.id("username")).sendKeys("anh nam");
//            driver.findElement(By.id("password")).sendKeys("congnam123");
//
//            driver.findElement(By.xpath("//input[@type='submit' and @value='Register']")).click();
//
//            assertTrue(
//                    wait.until(ExpectedConditions.urlContains("#"))
//            );
//        }finally {
//            driver.quit();
//        }
//    }
//
//
//    @Test
//    void dangnhap(){
//        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        try {
//            driver.get("https://www.tutorialspoint.com/selenium/practice/login.php");
//            driver.findElement(By.id("email")).sendKeys("nguyencongnam@gmail.com");
//            driver.findElement(By.id("password")).sendKeys("congcong");
//
//            driver.findElement(By.xpath("//input[@type ='submit' and @value='Login']")).click();
//
//            assertTrue(
//                    wait.until(ExpectedConditions.urlContains("#"))
//            );
//        } finally {
//            driver.quit();
//        }
//    }

    @Test
    void checkvalidate(){
        SinhVien sv1 = new SinhVien();
        String meegage = service.addSV(sv1);
        assertEquals("không được để trống", meegage);
    }



}