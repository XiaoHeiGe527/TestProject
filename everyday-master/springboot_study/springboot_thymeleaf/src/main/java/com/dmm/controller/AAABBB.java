package com.dmm.controller;

import org.lionsoul.ip2region.*;

import java.io.IOException;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/12 16:04
 * @motto The more learn, the more found his ignorance.
 */

public class AAABBB {

    public static void main(String[] args) throws DbMakerConfigException, IOException {


        //ip  60.186.219.158 220.248.12.158 60.186.219.158 0.0.0.0
        String ip="192.168.123.12";

        // 判断是否为IP地址 (可用)
        boolean isIpAddress = Util.isIpAddress(ip);

        //ip和long互转 (可用)
        //long ipLong = Util.ip2long(ip);
        //String strIp = Util.long2ip(ipLong);

        //根据ip进行位置信息搜索
        DbConfig config = new DbConfig();

        //获取ip库的位置（放在src下）（直接通过测试类获取文件Ip2RegionTest为测试类）
        //String dbfile = Ip2RegionTest.class.getResource("/ip2region.db").getPath();
        //String path=AAABBB.class.getResource("/ip2region.db").getPath();
        //System.out.println(path);

        String dbfile=AAABBB.class.getResource("/ip2region.db").getPath();

        DbSearcher searcher = new DbSearcher(config, dbfile);

        //采用Btree搜索
        DataBlock block = searcher.btreeSearch(ip);

        //打印位置信息（格式：国家|大区|省份|城市|运营商）
        System.out.println(block.getRegion());

    }
}

