package com.myapp.vcdex.dao;

import com.myapp.vcdex.vo.IndexVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IndexDAO {
    public int IndexInsert(IndexVO vo);

    public List<IndexVO> IndexSelect();
}
