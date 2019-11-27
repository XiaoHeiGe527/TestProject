package com.dmm.controller;

import org.lionsoul.ip2region.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/12 16:03
 * @motto The more learn, the more found his ignorance.
 */
@Controller
public class TestController {

    @RequestMapping("/test10")
    @ResponseBody
    public String test1(String ip) throws DbMakerConfigException, IOException {

        System.out.println(ip);
        // 判断是否为IP地址 (可用)
        boolean isIpAddress = Util.isIpAddress(ip);

        System.out.println(isIpAddress);

        //ip和long互转 (可用)
        //long ipLong = Util.ip2long(ip);
        //String strIp = Util.long2ip(ipLong);

        //根据ip进行位置信息搜索
        DbConfig config = new DbConfig();

        //获取ip库的位置（放在src下）（直接通过测试类获取文件Ip2RegionTest为测试类）
        //String dbfile = Ip2RegionTest.class.getResource("/ip2region.db").getPath();
        //String path=AAABBB.class.getResource("/ip2region.db").getPath();
        //System.out.println(path);

        String dbfile=TestController.class.getResource("/ip2region.db").getPath();

        DbSearcher searcher = new DbSearcher(config, dbfile);

        //采用Btree搜索
        DataBlock block = searcher.btreeSearch(ip);

        //打印位置信息（格式：国家|大区|省份|城市|运营商）

        System.out.println(block.getCityId());

        System.out.println(block.getDataPtr());

        System.out.println(block.getRegion());

        return block.getRegion();
    }

    @RequestMapping("/test11")
    @ResponseBody
    public static String getCityInfo(String ip){
        //db
        String dbPath = TestController.class.getResource("/ip2region.db").getPath();

        File file = new File(dbPath);

        if ( file.exists() == false ) {
            System.out.println("Error: Invalid ip2region.db file");
        }

        //查询算法
        int algorithm = DbSearcher.BTREE_ALGORITHM; //B-tree
        //DbSearcher.BINARY_ALGORITHM //Binary
        //DbSearcher.MEMORY_ALGORITYM //Memory
        try {
            DbConfig config = new DbConfig();
            DbSearcher searcher = new DbSearcher(config, dbPath);

            //define the method
            Method method = null;
            switch ( algorithm )
            {
                case DbSearcher.BTREE_ALGORITHM:
                    method = searcher.getClass().getMethod("btreeSearch", String.class);
                    break;
                case DbSearcher.BINARY_ALGORITHM:
                    method = searcher.getClass().getMethod("binarySearch", String.class);
                    break;
                case DbSearcher.MEMORY_ALGORITYM:
                    method = searcher.getClass().getMethod("memorySearch", String.class);
                    break;
            }

            DataBlock dataBlock = null;
            if ( Util.isIpAddress(ip) == false ) {
                System.out.println("Error: Invalid ip address");
            }

            dataBlock  = (DataBlock) method.invoke(searcher, ip);

            return dataBlock.getRegion();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



}

