package com.dmm.service;

import com.dmm.entry.TTempTest;

import java.util.List;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/8 10:26
 * @motto If you would have leisure, do not waste it.
 */

public interface TTempTestService {

    List<TTempTest> getPage(int offset,int limit);

    long getCount();

}
