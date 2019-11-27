package com.dmm.test;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DMM
 * @create 2019/8/8
 */

public class VmTest {

    public static void main(String[] args) {
        //116.62.172.166:22
        String hostname = "116.62.172.166";
        int port = 22;
        String username = "yunny";
        String password = "yunny";

        Connection conn = new Connection(hostname,port);
        Session ssh = null;
        try
        {
            //连接到主机
            conn.connect();
            //使用用户名和密码校验
            boolean isconn = conn.authenticateWithPassword(username, password);
            System.out.println(isconn);
            if (!isconn)
            {

                System.out.println("用户名称或者是密码不正确");
            }
            else
            {
                System.out.println("已经连接OK");

                File folder = new File("e://logs");
                if(!folder.exists()){
                    folder.mkdir();
                }

                SCPClient clt = conn.createSCPClient();
                ssh = conn.openSession();
                //ssh.execCommand("cd /data");
                //ssh.execCommand("find /data/ -name 'a.txt'");
                //ssh.execCommand("find /data/c.txt");
                //ssh.execCommand("stat /data/a.txt");
                //ssh.execCommand("find /data/*.txt -type f -newermt '2019-08-08 00:00:00' ! -newermt '2019-08-08 23:59:59'");
                //ssh.execCommand("grep /data/*.txt");
                InputStream is = new StreamGobbler(ssh.getStdout());
                BufferedReader brs = new BufferedReader(new InputStreamReader(is));
                //int i=0;
                while (true)
                {
                    String line = brs.readLine();
                    if (line == null)
                    {
                        break;
                    }
                    System.out.println(line);
//                    if(i==0){
//                        System.out.println(line.substring(line.indexOf(":")+1).trim());
//                    }
//                    if(i==1){
//                                            System.out.println(
//                            (
//                                    (line.substring
//                                            (line.indexOf(":")+1,line.indexOf("Blocks:"))
//                                    )
//                            ).trim()
//                    );
//                    }
//                    i++;
//
//                    if(i==5){
//
//                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//                        System.out.println(
//                                line.substring(line.indexOf(":")+1,line.indexOf(".")).trim()
//                        );
//
//                        System.out.println(format.parse
//                                (
//                                        line.substring(line.indexOf(":")+1,line.indexOf(".")).trim()
//                                ).getTime()
//                        );
//                    }
                    File file=new File("e://dmm.txt");
                    //OutputStream outputStream=new ByteArrayOutputStream();

                    OutputStream outputStream=new FileOutputStream(file);
                    //clt.get(line, "e://logs");
                    clt.get(line,outputStream);





//                    List<File> lf = new ArrayList<File>();
//                    test1 t = new test1();
//                    lf = t.getFileList(new File("D://logs"),"txt");
//                    for(File f:lf){
//                        /*System.out.println(f.getPath());*/
//                        String path=f.getPath();
//                        File file = new File(path);
//                        try{
//                            FileReader fr = new FileReader(file);
//                            BufferedReader br = new BufferedReader(fr);
//                            String s = null;
//                            Pattern p = Pattern.compile(".*?error.*?");
//                            while((s = br.readLine()) != null){
//                                Matcher m = p.matcher(s);
//                                if(m.find()) {
//                                    /*System.out.println(m.matches());*/
//                                    System.out.println(line);
//                                    System.out.println("find error!");
//                                }/*else{
//                                    System.out.println("no error");
//                                }   */
//                            }
//                            br.close();
//                        }catch(FileNotFoundException e){
//                            System.err.println("file not found");
//                        }catch(IOException e){
//                            e.printStackTrace();
//                        }
//
//                    }

                }

            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
// catch (ParseException e) {
//            e.printStackTrace();
//        }
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

    public List<File> getFileList(File fileDir,String fileType){
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

