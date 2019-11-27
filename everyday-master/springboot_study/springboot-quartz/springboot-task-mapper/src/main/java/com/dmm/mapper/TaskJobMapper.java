package com.dmm.mapper;

import com.dmm.entry.TaskJob;
import com.dmm.entry.TaskJobExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskJobMapper {
    long countByExample(TaskJobExample example);

    int deleteByExample(TaskJobExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TaskJob record);

    int insertSelective(TaskJob record);

    List<TaskJob> selectByExample(TaskJobExample example);

    TaskJob selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TaskJob record, @Param("example") TaskJobExample example);

    int updateByExample(@Param("record") TaskJob record, @Param("example") TaskJobExample example);

    int updateByPrimaryKeySelective(TaskJob record);

    int updateByPrimaryKey(TaskJob record);
}