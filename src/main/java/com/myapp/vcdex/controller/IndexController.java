package com.myapp.vcdex.controller;

import com.myapp.vcdex.service.CardService;
import com.myapp.vcdex.service.IndexService;
import com.myapp.vcdex.vo.CardVO;
import com.myapp.vcdex.vo.IndexVO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@RestController
@Component
@RequestMapping("/api/")
public class IndexController {
    @Autowired
    CardService service;
    @Autowired
    IndexService iservice;

    @Scheduled(fixedRateString = "60000", initialDelay = 0)
    public void MakeIndex() {
        try{
            Document crptoDocument = Jsoup.connect("https://kr.investing.com/crypto/ethereum/eth-krw-converter").get();
            Document wdexrateDocument = Jsoup.connect("https://kr.investing.com/currencies/usd-krw").get();
            Elements eth_krw_element = crptoDocument.getElementsByClass("arial_26 inlineblock pid-1011043-last");
            Elements won_dollar_exrate_element = wdexrateDocument.getElementsByAttributeValue("data-test","instrument-price-last");

            //이더리움 시세, 원달러 환율
            int eth_krw = Integer.parseInt(eth_krw_element.text().replaceAll(",",""));
            double won_dollar_exrate = Double.parseDouble(won_dollar_exrate_element.text().replaceAll(",",""));

            //RTX 3060 AVG
            int rtx3060_asus = service.CardPrice("rtx3060_asus");
            int rtx3060_msi = service.CardPrice("rtx3060_msi");
            int rtx3060_gigabyte = service.CardPrice("rtx3060_gigabyte");
            int rtx3060_emtek = service.CardPrice("rtx3060_emtek");
            int rtx3060_price = (rtx3060_asus+rtx3060_msi+rtx3060_gigabyte+rtx3060_emtek)/4;
            //RTX 3060 TI AVG
            int rtx3060_ti_asus = service.CardPrice("rtx3060_ti_asus");
            int rtx3060_ti_msi = service.CardPrice("rtx3060_ti_msi");
            int rtx3060_ti_gigabyte = service.CardPrice("rtx3060_ti_gigabyte");
            int rtx3060_ti_emtek = service.CardPrice("rtx3060_ti_emtek");
            int rtx3060_ti_price = (rtx3060_ti_asus+rtx3060_ti_msi+rtx3060_ti_gigabyte+rtx3060_ti_emtek)/4;
            //RTX 3070 AVG
            int rtx3070_asus = service.CardPrice("rtx3070_asus");
            int rtx3070_msi = service.CardPrice("rtx3070_msi");
            int rtx3070_gigabyte = service.CardPrice("rtx3070_gigabyte");
            int rtx3070_emtek = service.CardPrice("rtx3070_emtek");
            int rtx3070_price = (rtx3070_asus+rtx3070_msi+rtx3070_gigabyte+rtx3070_emtek)/4;
            //RTX 3070 TI AVG
            int rtx3070_ti_asus = service.CardPrice("rtx3070_ti_asus");
            int rtx3070_ti_msi = service.CardPrice("rtx3070_ti_msi");
            int rtx3070_ti_gigabyte = service.CardPrice("rtx3070_ti_gigabyte");
            int rtx3070_ti_emtek = service.CardPrice("rtx3070_ti_emtek");
            int rtx3070_ti_price = (rtx3070_ti_asus+rtx3070_ti_msi+rtx3070_ti_gigabyte+rtx3070_ti_emtek)/4;
            //RTX 3080 AVG
            int rtx3080_asus = service.CardPrice("rtx3080_asus");
            int rtx3080_msi = service.CardPrice("rtx3080_msi");
            int rtx3080_gigabyte = service.CardPrice("rtx3080_gigabyte");
            int rtx3080_emtek = service.CardPrice("rtx3080_emtek");
            int rtx3080_price = (rtx3080_asus+rtx3080_msi+rtx3080_gigabyte+rtx3080_emtek)/4;

            //PER MSRP
            double rtx3060_per_msrp = Math.round(rtx3060_price/(329*won_dollar_exrate*1.1)*100000)/1000.0;
            double rtx3060_ti_per_msrp = Math.round(rtx3060_ti_price/(399*won_dollar_exrate*1.1)*100000)/1000.0;
            double rtx3070_per_msrp = Math.round(rtx3070_price/(499*won_dollar_exrate*1.1)*100000)/1000.0;
            double rtx3070_ti_per_msrp = Math.round(rtx3070_ti_price/(599*won_dollar_exrate*1.1)*100000)/1000.0;
            double rtx3080_per_msrp = Math.round(rtx3080_price/(699*won_dollar_exrate*1.1)*100000)/1000.0;

            //VCDEX
            double vcdex = Math.round(((rtx3060_per_msrp+rtx3060_ti_per_msrp+rtx3070_per_msrp+rtx3070_ti_per_msrp+rtx3080_per_msrp)/5)*1000)/1000.0;
            System.out.println(rtx3060_per_msrp);
            //Insert
            IndexVO vo = new IndexVO();
            vo.setVcdex(vcdex);
            vo.setEth_krw(eth_krw);
            vo.setWon_dollar_exrate(won_dollar_exrate);
            vo.setRtx3060_price(rtx3060_price);
            vo.setRtx3060_ti_price(rtx3060_ti_price);
            vo.setRtx3070_price(rtx3070_price);
            vo.setRtx3070_ti_price(rtx3070_ti_price);
            vo.setRtx3080_price(rtx3080_price);
            vo.setRtx3060_per_msrp(rtx3060_per_msrp);
            vo.setRtx3060_ti_per_msrp(rtx3060_ti_per_msrp);
            vo.setRtx3070_per_msrp(rtx3070_per_msrp);
            vo.setRtx3070_ti_per_msrp(rtx3070_ti_per_msrp);
            vo.setRtx3080_per_msrp(rtx3080_per_msrp);
            System.out.println("vcdex 지수 삽입 완료 : "+vcdex+" : "+iservice.IndexInsert(vo));
//
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("index/data")
    public Flux<ServerSentEvent<List<IndexVO>>> data() {
        return Flux.interval(Duration.ofSeconds(15))
                .map(data -> ServerSentEvent.builder(iservice.IndexSelect()).build());
    }
    @GetMapping("index/dataf")
    public List<IndexVO> dataf() {
        return iservice.IndexSelect();
    }

    @GetMapping("cardlist")
    public List<CardVO> CardList(@RequestParam("name") String name){
        return service.CardList(name);
    }
    @GetMapping("carddata")
    public CardVO CardDate(@RequestParam("name") String name) { return service.CardData(name); }
}
