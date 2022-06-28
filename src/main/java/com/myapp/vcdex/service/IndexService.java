package com.myapp.vcdex.service;

import com.myapp.vcdex.dao.IndexDAO;
import com.myapp.vcdex.vo.IndexVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {
    @Autowired
    IndexDAO dao;

    public int IndexInsert(IndexVO vo){
        return dao.IndexInsert(vo);
    }
    public List<IndexVO> IndexSelect() {
        return dao.IndexSelect();
    }
}
