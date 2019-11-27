package com.dmm.service;

import com.dmm.test.FlowUtil;
import com.dmm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

/**
 * @author DMM
 * @create 2019/8/9
 */
@Component
public class TaskJob {

    @Autowired
    private FlowUtil flowUtil;

    // @Scheduled("")
    public void dd() throws FileNotFoundException {
        //find /data/*.txt -type f -newermt '2019-08-08 00:00:00' ! -newermt '2019-08-08 23:59:59'
        StringBuilder stringBuilder=new StringBuilder("find /data/*.txt -type f -newermt '");

        stringBuilder.append(DateUtil.getDate(0));
        stringBuilder.append("' ! -newermt '");
        stringBuilder.append(DateUtil.getDate(1));
        stringBuilder.append("'");

        flowUtil.readMessage(stringBuilder.toString());

    }
    public void ddc(String remotePath,String localPath) throws FileNotFoundException {
        //find /data/*.txt -type f -newermt '2019-08-08 00:00:00' ! -newermt '2019-08-08 23:59:59'
        StringBuilder stringBuilder=new StringBuilder("find ");
        stringBuilder.append(remotePath);


        //System.out.println("");

        String fileName=get(remotePath);

        int i=find(fileName,localPath);
        String ff="";
        if(i>0){
            ff=localPath+p(fileName,i);
        }else {
            ff=localPath+fileName;
        }

        FileOutputStream fileOutputStream=new FileOutputStream(new File(ff));

        flowUtil.writeLog(fileOutputStream,stringBuilder.toString());

    }

    /**
     * 获取文件名
     * @param s
     * @return
     */
    private String get(String s){

        return s.substring(s.lastIndexOf("/")+1);
    }

    /**
     * 获取路径
     * @param
     * @return
     */
//    private String get1(String s){
//
//        return s.substring(0,s.lastIndexOf("/"));
//    }

    public int find(String fileName,String localPath){

        File file=new File(localPath);

        String[] r=fileName.split("\\.");

        String [] s=file.list();

        //StringBuilder stringBuilder=new StringBuilder(fileName);

        //stringBuilder.insert(fileName.lastIndexOf("."),"*");

        String regex=r[0]+"[(][0-9]*[)]"+"."+r[1];

        System.out.println(regex+"----------------------");

        int i=0;
        for (String s1:s){

            //Pattern pattern=Pattern.compile(stringBuilder.toString());

            //pattern.

            boolean b=s1.matches(regex);
            //System.out.println(b);
            if (s1.matches(fileName) || b) {
                i++;
            }
        }
        System.out.println(i);
        System.out.println(Arrays.toString(s));

        return i;
    }

    public String p(String s,int i){

        String[] strings=s.split("\\.");
        System.out.println(Arrays.toString(strings));
        String f=strings[0]+"("+i+")."+strings[1];
        System.out.println(f);
        return f;
    }

//    public static void main(String[] args) {
//        TaskJob taskJob=new TaskJob();
//        //taskJob.find("d.txt","e://logs");
//        //taskJob.p("d.txt",2);
//        //taskJob.get1("e://")
//    }


//    public static void main(String[] args) {
//        File file=new File("E://logs/f.txt");
//        file.mkdir();
//    }



}

