package com.myapp.vcdex.service;

import com.myapp.vcdex.dao.CardDAO;
import com.myapp.vcdex.vo.CardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    @Autowired
    CardDAO dao;

    public int CardUpdate(ArrayList<CardVO> list) {
        return dao.CardUpdate(list);
    }
    public int CardPrice(String CardName){
        return dao.CardPrice(CardName);
    }

    public List<CardVO> CardList(String name) {
        return dao.CardList(name);
    }

    public CardVO CardData(String name) {
        return dao.CardData(name);
    }
}
