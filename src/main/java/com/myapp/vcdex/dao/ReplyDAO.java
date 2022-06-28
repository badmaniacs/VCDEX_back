package com.myapp.vcdex.dao;

import com.myapp.vcdex.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReplyDAO {
    public int AddReply(ReplyVO vo);

    public List<ReplyVO> ReplyList(ReplyVO vo);

    public int DeleteReply(ReplyVO vo);
}
