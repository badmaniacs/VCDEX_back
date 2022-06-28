package com.myapp.vcdex.service;

import com.myapp.vcdex.dao.ReplyDAO;
import com.myapp.vcdex.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {
    @Autowired
    ReplyDAO dao;

    public int AddReply(ReplyVO vo){
        return dao.AddReply(vo);
    }

    public List<ReplyVO> ReplyList(ReplyVO vo) {
        return dao.ReplyList(vo);
    }

    public int DeleteReply(ReplyVO vo) {
        return dao.DeleteReply(vo);
    }
}
