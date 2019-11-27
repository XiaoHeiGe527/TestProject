<%--
  Created by IntelliJ IDEA.
  User: dmm
  Date: 2019/7/24
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.io.BufferedReader" %>
<%@page import="java.io.FileReader" %>
<%@page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        BufferedReader bufferedReader=new BufferedReader(new FileReader(new File("C:\\Users\\dmm\\Desktop\\功能.txt")));

        StringBuffer stringBuffer=new StringBuffer();

        String s=bufferedReader.readLine();

        while (s!=null){
            stringBuffer.append(s).append("<br>");
            s=bufferedReader.readLine();
        }
        bufferedReader.close();

    %>
    <center>
        <%=stringBuffer%>
    </center>

</body>
</html>
