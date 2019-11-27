package com.dmm.test;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

/**
 * @author DMM
 * @create 2019/8/9
 */
@Component
public class LogUploadUtil {


    @Value("${scp.hostname}")
    String hostname;

    @Value("${scp.port}")
    int port;

    @Value("${scp.username}")
    String username;

    @Value("${scp.password}")
    String password;

    /**
     * 获取时间时间段信息，及某个文件详细信息
     * @param list
     * @param commandLine
     */
    public void getLogList(List<String> list,String commandLine){

        Connection connection=new Connection(hostname,port);
        Session session=null;

        try {

            connection.connect();

            boolean isConnection=connection.authenticateWithPassword(username,password);

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
                    //System.out.println(line);
                    list.add(line);
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

    public void uploadLog(OutputStream outputStream,String commandLine){

        Connection connection=new Connection(hostname,port);
        Session session=null;

        try {

            connection.connect();

            boolean isConnection=connection.authenticateWithPassword(username,password);

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
                    //System.out.println(line);

                    SCPClient scpClient=connection.createSCPClient();
                    scpClient.get(line,outputStream);
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


}

