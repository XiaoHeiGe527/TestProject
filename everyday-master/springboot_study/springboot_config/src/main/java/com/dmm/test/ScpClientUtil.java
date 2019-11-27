package com.dmm.test;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @author DMM
 * @create 2019/8/9
 */
@Component
public class ScpClientUtil {

    @Value("${scp.hostname}")
     String hostname;

    @Value("${scp.port}")
     int port;

    @Value("${scp.username}")
     String username;

    @Value("${scp.password}")
     String password;

    /**
     *
     * @param outputStream
     * @param commandLine
     * @param status 0 获取文件信息 1 下载文件
     */

    public void logTest(OutputStream outputStream,String commandLine,int status){
        System.out.println("================================");
        Connection connection=new Connection(hostname,port);
        System.out.println("----------------------");
        Session session=null;

//        boolean flg = false;
//        try {
//            Connection conn = new Connection("116.62.172.166");
//            conn.connect();// 连接
//            //判断身份是否已经认证
//            if (!conn.isAuthenticationComplete()) {
//                //加锁，防止多线程调用时线程间判断不一致，导致出现重复认证
//                synchronized (this) {
//                    if (!conn.isAuthenticationComplete()) {
//                        //进行身份认证
//                        flg = conn.authenticateWithPassword("", "");
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        }


        try {
            System.out.println("dmmmmmmmmmmmmmm");
            System.out.println(username+password+hostname+"654321");
            connection.connect();

            System.out.println(username+password+hostname);
            boolean isConnection=connection.authenticateWithPassword(username,password);

            System.out.println(isConnection+"++++++++++++____________________");

            if(!isConnection){
                System.out.println("用户名称或者是密码不正确");
            }else {
                System.out.println("已经连接OK");

                session=connection.openSession();

                session.execCommand(commandLine);

                InputStream inputStream = new StreamGobbler(session.getStdout());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                while (true){
                    String line=bufferedReader.readLine();
                    if (line==null)
                        break;
                    System.out.println(line);

                    if(status==0){
                        outputStream.write(line.getBytes());
                    }

                    if(status==1){
                        SCPClient scpClient=connection.createSCPClient();
                        scpClient.get(line,outputStream);
                    }
                }

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            if (session!=null)
                session.close();
            if (connection!=null)
                connection.close();
        }

    }

//    public static void main(String[] args) {
//        ScpClientUtil scpClientUtil=new ScpClientUtil();
//
//        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
//        String s="find /data/*.txt";
//        scpClientUtil.logTest(byteArrayOutputStream,s,0);
//
//        //System.out.println(byteArrayOutputStream.toString());
//
//    }

//    public Boolean login() {

//        boolean flg = false;
//        try {
//            conn = new Connection(ip);
//            conn.connect();// 连接
//            //判断身份是否已经认证
//            if (!conn.isAuthenticationComplete()) {
//                //加锁，防止多线程调用时线程间判断不一致，导致出现重复认证
//                synchronized (this) {
//                    if (!conn.isAuthenticationComplete()) {
//                        //进行身份认证
//                        flg = conn.authenticateWithPassword(userName, userPwd);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        }
//        return flg;
//    }

}

