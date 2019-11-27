package com.dmm.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dmm.annotation.DataSource;
import com.dmm.entity.Teacher;
import com.dmm.enums.DataSourceEnum;
import com.dmm.mapper.TeacherMapper;
import com.dmm.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author DMM
 * @create 2019/8/7
 */
@Service
@Transactional
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {


    @Override
    @DataSource(DataSourceEnum.DB2)
    public boolean insert(Teacher entity) {
        boolean b=super.insert(entity);
        System.out.println(1/0);
        return b;
    }

    @Override
    @DataSource(DataSourceEnum.DB2)
    public boolean deleteById(Serializable id) {
        return super.deleteById(id);
    }

    @Override
    @DataSource(DataSourceEnum.DB2)
    public boolean updateById(Teacher entity) {
        return super.updateById(entity);
    }

    @Override
    @DataSource(DataSourceEnum.DB2)
    public Teacher selectById(Serializable id) {
        return super.selectById(id);
    }

    @Override
    @DataSource(DataSourceEnum.DB2)
    public List<Teacher> selectList(Wrapper<Teacher> wrapper) {

        //PaginationInterceptor
        Page<Teacher> page=new Page<>(1,2,"id");
        page.setAsc(false);
        //super.selectPage(page);
        //super.selectList(wrapper)
        return super.selectPage(page).getRecords();
    }

    @Override
    @DataSource(DataSourceEnum.DB2)
    public Page<Teacher> selectPage(Page<Teacher> page) {
        return super.selectPage(page);
    }

    @Override
    @DataSource(DataSourceEnum.DB2)
    public Page<Teacher> selectPage(Page<Teacher> page, Wrapper<Teacher> wrapper) {
        return super.selectPage(page, wrapper);
    }
}

