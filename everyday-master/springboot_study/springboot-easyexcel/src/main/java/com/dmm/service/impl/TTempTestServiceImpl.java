package com.dmm.service.impl;

import com.dmm.entry.TTempTest;
import com.dmm.entry.TTempTestExample;
import com.dmm.mapper.TTempTestMapper;
import com.dmm.service.TTempTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/8 10:30
 * @motto The more learn, the more found his ignorance.
 */
@Service
public class TTempTestServiceImpl implements TTempTestService {

    @Autowired
    private TTempTestMapper tTempTestMapper;

    @Override
    public List<TTempTest> getPage(int offset, int limit) {

        TTempTestExample tTempTestExample=new TTempTestExample();
        tTempTestExample.setOffset(offset);
        tTempTestExample.setLimit(limit);

        return tTempTestMapper.selectByExample(tTempTestExample);

    }

    @Override
    public long getCount() {
        TTempTestExample tTempTestExample=new TTempTestExample();
        return tTempTestMapper.countByExample(tTempTestExample);
    }
}

