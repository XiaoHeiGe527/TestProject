package com.dmm.mapper;

import com.dmm.entry.TTempTest;
import com.dmm.entry.TTempTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTempTestMapper {
    long countByExample(TTempTestExample example);

    int deleteByExample(TTempTestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTempTest record);

    int insertSelective(TTempTest record);

    List<TTempTest> selectByExample(TTempTestExample example);

    TTempTest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTempTest record, @Param("example") TTempTestExample example);

    int updateByExample(@Param("record") TTempTest record, @Param("example") TTempTestExample example);

    int updateByPrimaryKeySelective(TTempTest record);

    int updateByPrimaryKey(TTempTest record);
}