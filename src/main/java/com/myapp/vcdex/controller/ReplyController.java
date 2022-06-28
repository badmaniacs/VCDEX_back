package com.myapp.vcdex.controller;

import com.myapp.vcdex.service.ReplyService;
import com.myapp.vcdex.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReplyController {
    @Autowired
    ReplyService service;

    @PostMapping("/reply/add")
    public int AddReply(@RequestBody ReplyVO vo){
        return service.AddReply(vo);
    }
    @PostMapping("/reply/list")
    public List<ReplyVO> ReplyList(@RequestBody ReplyVO vo){
        return service.ReplyList(vo);
    }
    @PostMapping("/reply/delete")
    public int DeleteReply(@RequestBody ReplyVO vo) { return service.DeleteReply(vo);}
}
