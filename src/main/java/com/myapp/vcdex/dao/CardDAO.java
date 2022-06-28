package com.myapp.vcdex.dao;

import com.myapp.vcdex.vo.CardVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository
public interface CardDAO {
    public int CardUpdate(ArrayList<CardVO> list);
    public int CardPrice(String CardName);

    public List<CardVO> CardList(String name);

    public CardVO CardData(String name);
}
