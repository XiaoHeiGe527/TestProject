package com.dmm.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.*;

/**
 * @author DMM
 * @create 2019/8/9
 */
@Component
public class FlowUtil {

//    @Autowired
//    private ScpClientUtil scpClientUtil;

    @Autowired
    private LogUploadUtil uploadUtil;

    @Value("${scp.localPath}")
    private String localPath;

    /**
     * 下载文件
     */
    public void uploadTest(String localPath){

    }

    /**
     *
     */
    public List readMessage(String c) throws FileNotFoundException {

        List<String> list=new ArrayList<>();

        //ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();

//        new FileOutputStream(new File("")).

//        ScpClientUtil scpClientUtil=new ScpClientUtil();

        uploadUtil.getLogList(list,c);

        //String d=byteArrayOutputStream.toString();
        //list.add(d);

        //System.out.println(d+"===========");

        Map<String,List<String>> map=new HashMap<>();

        list.forEach(s->{
            System.out.println(s);
            List<String> list1=new ArrayList<>();

            StringBuilder stringBuilder=new StringBuilder("stat ");
            stringBuilder.append(s);
            uploadUtil.getLogList(list1,stringBuilder.toString());

            map.put(s,list1);

            //list1.clear();
        });

//        list1.forEach(s->{
//            System.out.println(s+"100");
//        });

        for(Map.Entry<String,List<String>> set:map.entrySet()){
            System.out.println(set.getKey());
            set.getValue().forEach(s -> {
                System.out.println(s+100);
            });
        }

        return list;
    }

    public void writeLog(OutputStream outputStream,String c) throws FileNotFoundException {

        uploadUtil.uploadLog(outputStream,c);

    }


}

