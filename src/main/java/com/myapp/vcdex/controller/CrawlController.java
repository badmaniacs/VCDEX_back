package com.myapp.vcdex.controller;

import com.myapp.vcdex.service.CardService;
import com.myapp.vcdex.vo.CardVO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@Component
@RequestMapping("/api/")
public class CrawlController {
    @Autowired
    CardService service;

    private WebDriver driver;
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/finalProject/chromedriver.exe";


    //ASUS

    @Scheduled(fixedRateString = "750000", initialDelay = 60000/2)
    public void rtx3060_asus(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=63137303","rtx3060_asus");
    }
    @Scheduled(fixedRateString = "750000", initialDelay = 120000/2)
    public void rtx3060_ti_asus(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=71317000","rtx3060_ti_asus");
    }
    @Scheduled(fixedRateString = "750000", initialDelay = 180000/2)
    public void rtx3070_asus(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=55483129","rtx3070_asus");
    }
    @Scheduled(fixedRateString = "750000", initialDelay = 240000/2)
    public void rtx3070_ti_asus() { CardUpdate("http://www.enuri.com/detail.jsp?modelno=68413675","rtx3070_ti_asus"); }
    @Scheduled(fixedRateString = "750000", initialDelay = 300000/2)
    public void rtx3080_asus(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=53788713","rtx3080_asus");
    }

    //MSI
    @Scheduled(fixedRateString = "750000", initialDelay = 360000/2)
    public void rtx3060_msi(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=63152494","rtx3060_msi");
    }
    @Scheduled(fixedRateString = "750000", initialDelay = 420000/2)
    public void rtx3060_ti_msi(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=70680979","rtx3060_ti_msi");
    }
    @Scheduled(fixedRateString = "750000", initialDelay = 480000/2)
    public void rtx3070_msi(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=70384391","rtx3070_msi");
    }
    @Scheduled(fixedRateString = "750000", initialDelay = 540000/2)
    public void rtx3070_ti_msi(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=68405649","rtx3070_ti_msi");
    }
    @Scheduled(fixedRateString = "750000", initialDelay = 600000/2)
    public void rtx3080_msi(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=72860952","rtx3080_msi");
    }

    //GIGABYTE
    @Scheduled(fixedRateString = "750000", initialDelay = 660000/2)
    public void rtx3060_gigabyte(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=68412895","rtx3060_gigabyte");
    }
    @Scheduled(fixedRateString = "750000", initialDelay = 720000/2)
    public void rtx3060_ti_gigabyte(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=71268145","rtx3060_ti_gigabyte");
    }
    @Scheduled(fixedRateString = "750000", initialDelay = 780000/2)
    public void rtx3070_gigabyte(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=71367226","rtx3070_gigabyte");
    }
    @Scheduled(fixedRateString = "750000", initialDelay = 840000/2)
    public void rtx3070_ti_gigabyte(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=68413057","rtx3070_ti_gigabyte");
    }
    @Scheduled(fixedRateString = "750000", initialDelay = 900000/2)
    public void rtx3080_gigabyte(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=71154939","rtx3080_gigabyte");
    }

//    //COLORFUL 물량이 적어서 유보
//    @Scheduled(fixedRateString = "1500000", initialDelay = 960000)
//    public void rtx3060_colorful(){
//        CardUpdate("http://www.enuri.com/detail.jsp?modelno=70680990","rtx3060_colorful");
//    }
//    @Scheduled(fixedRateString = "1500000", initialDelay = 1020000)
//    public void rtx3060_ti_colorful(){
//        CardUpdate("http://www.enuri.com/detail.jsp?modelno=71268145","rtx3060_ti_colorful");
//    }
//    @Scheduled(fixedRateString = "1500000", initialDelay = 1080000)
//    public void rtx3070_colorful(){
//        CardUpdate("http://www.enuri.com/detail.jsp?modelno=71367226","rtx3070_colorful");
//    }
//    @Scheduled(fixedRateString = "1500000", initialDelay = 1140000)
//    public void rtx3070_ti_colorful(){
//        CardUpdate("http://www.enuri.com/detail.jsp?modelno=68413057","rtx3070_ti_colorful");
//    }
//    @Scheduled(fixedRateString = "1500000", initialDelay = 1200000)
//    public void rtx3080_colorful(){
//        CardUpdate("http://www.enuri.com/detail.jsp?modelno=71154939","rtx3080_colorful");
//    }

    //EMTEK
    @Scheduled(fixedRateString = "750000", initialDelay = 1260000/2)
    public void rtx3060_emtek(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=63136660","rtx3060_emtek");
    }
    @Scheduled(fixedRateString = "750000", initialDelay = 1320000)
    public void rtx3060_ti_emtek(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=56957140","rtx3060_ti_emtek");
    }
    @Scheduled(fixedRateString = "750000", initialDelay = 1380000/2)
    public void rtx3070_emtek(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=69464254","rtx3070_emtek");
    }
    @Scheduled(fixedRateString = "750000", initialDelay = 1440000)
    public void rtx3070_ti_emtek(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=68413704","rtx3070_ti_emtek");
    }
    @Scheduled(fixedRateString = "750000", initialDelay = 1500000/2)
    public void rtx3080_emtek(){
        CardUpdate("http://www.enuri.com/detail.jsp?modelno=71155061","rtx3080_emtek");
    }

    public void CardUpdate (String url, String name) {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        try {
            ArrayList<CardVO> list = new ArrayList<>();
            driver.get(url);
            Thread.sleep(2000);
            for (int i = 1; i <= 5; i++) {
                WebElement priceElement = driver.findElement(By.xpath("//*[@id=\"prod_pricecomp\"]/div[2]/div[1]/div[2]/ul/li[" + i + "]/div[2]/div/div[1]/a/em"));
                WebElement linkElement = driver.findElement(By.xpath("//*[@id=\"prod_pricecomp\"]/div[2]/div[1]/div[2]/ul/li[" + i + "]/div[2]/div/div[1]/a"));
                CardVO vo = new CardVO();
                vo.setNo(i);
                vo.setPrice(Integer.parseInt(priceElement.getText().replaceAll(",", "")));
                vo.setLink(linkElement.getAttribute("href"));
                vo.setName(name);
                list.add(vo);
            }
            System.out.println(name+" 업데이트 완료 : "+service.CardUpdate(list));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            driver.close();
        }
    }

}
