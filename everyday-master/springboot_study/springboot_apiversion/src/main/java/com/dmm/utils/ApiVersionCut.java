package com.dmm.utils;

/**
 *
 * 版本号判定字符串切割工具类
 * @author DMM
 * @create 2019/7/15
 */

public class ApiVersionCut {

    /**
     * 若请求版本大于当前最大版本，返回true
     * @param newVersion
     * @param oldVersion
     * @return
     */
    public static boolean versionCutUtil(String newVersion,String oldVersion){

        String[] newArr=newVersion.split("\\.");
        String[] oldArr=oldVersion.split("\\.");

        boolean versionStatus=false;

        for (int i=0;i<newArr.length;i++){

            Integer newI=Integer.valueOf(newArr[i]);

            Integer oldI=Integer.valueOf(oldArr[i]);

            if(newI>oldI){
                versionStatus=true;
                break;
            }
        }
        return versionStatus;
    }

    /**
     * int版本的获取
     */
    public static int versionCutInt(String newVersion,String oldVersion){

        String[] newArr=newVersion.split("\\.");
        String[] oldArr=oldVersion.split("\\.");

        int news=0;
        int olds=0;

        for (int i=0;i<newArr.length;i++){
            Integer newI=Integer.valueOf(newArr[i]);
            Integer oldI=Integer.valueOf(oldArr[i]);
            news=news+newI*(int)Math.pow(10,newArr.length-i-1);
            olds=olds+oldI*(int)Math.pow(10,newArr.length-i-1);
        }
        return news-olds;
    }


//    public static void main(String[] args) {
//        System.out.println(versionCutDouble("0.0.1.1","0.0.0.1"));
//    }


    /**
     * 出现精度损失
     * @param newVersion
     * @param oldVersion
     * @return
     */
    public static int versionCutDouble(String newVersion,String oldVersion){

        String[] newString=newVersion.split("\\.",2);
        String[] oldString=oldVersion.split("\\.",2);

        String sn=newString[1].replace(".","");
        sn=newString[0]+"."+sn;
        System.out.println(sn);
        String so=oldString[1].replace(".","");
        so=oldString[0]+"."+so;
        System.out.println(so);
        System.out.println(Double.parseDouble(sn)-Double.parseDouble(so));

        return (int)(Double.parseDouble(sn)-Double.parseDouble(so))*1000;
    }



}

