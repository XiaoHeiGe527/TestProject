package com.dmm.test;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author DMM
 * @create 2019/8/9
 */

public class UploadTest {

    public static void main(String[] args)
    {
        String hostname = "xxx.xxx.xxx.xxx";
        int port = 22;
        String username = "xxx";
        String password = "xxx";

        Connection conn = new Connection(hostname,port);
        Session ssh = null;
        try
        {
            //连接到主机
            conn.connect();
            //使用用户名和密码校验
            boolean isconn = conn.authenticateWithPassword(username, password);
            if (!isconn)
            {
                System.out.println("用户名称或者是密码不正确");
            }
            else
            {
                System.out.println("已经连接OK");

                File folder = new File("D://logs");
                if(!folder.exists()){
                    folder.mkdir();
                }

                SCPClient clt = conn.createSCPClient();
                ssh = conn.openSession();
                ssh.execCommand("find /dev/shm/M/ -name '*.txt'");
                InputStream is = new StreamGobbler(ssh.getStdout());
                BufferedReader brs = new BufferedReader(new InputStreamReader(is));
                while (true)
                {
                    String line = brs.readLine();
                    if (line == null)
                    {
                        break;
                    }

                    clt.get(line, "D://logs");

                    List<File> lf = new ArrayList<File>();
                    //test1 t = new test1();
                    //lf = t.
                    lf=getFileList(new File("D://logs"),"txt");
                    for(File f:lf){
                        /*System.out.println(f.getPath());*/
                        String path=f.getPath();
                        File file = new File(path);
                        try{
                            FileReader fr = new FileReader(file);
                            BufferedReader br = new BufferedReader(fr);
                            String s = null;
                            Pattern p = Pattern.compile(".*?error.*?");
                            while((s = br.readLine()) != null){
                                Matcher m = p.matcher(s);
                                if(m.find()) {
                                    /*System.out.println(m.matches());*/
                                    System.out.println(line);
                                    System.out.println("find error!");
                                }/*else{
                                    System.out.println("no error");
                                }   */
                            }
                            br.close();
                        }catch(FileNotFoundException e){
                            System.err.println("file not found");
                        }catch(IOException e){
                            e.printStackTrace();
                        }

                    }

                }

            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            //连接的Session和Connection对象都需要关闭
            if(ssh!=null)
            {
                ssh.close();
            }
            if(conn!=null)
            {
                conn.close();
            }
        }
    }

    public static List<File> getFileList(File fileDir,String fileType){

        List<File> lfile = new ArrayList<File>();
        File[] fs = fileDir.listFiles();
        for(File f:fs){
            if(f.isFile()){
                if (fileType.equals(f.getName().substring(f.getName().lastIndexOf(".")+1, f.getName().length())))
                    lfile.add(f);
            }else{
                List<File> ftemps = getFileList(f, fileType);
                lfile.addAll(ftemps);
            }
        }
        return lfile;
    }

}

