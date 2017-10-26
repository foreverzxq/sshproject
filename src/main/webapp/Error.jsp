<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/15
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    System.out.println("basePath="+basePath);
%>
<html>
<head>
    <title>ERROR</title>
    <style type="text/css">
        #aa{display:block;
            position:relative;
            margin:auto;
        }
    </style>
</head>
<body>
<div align="center">
    <img src="<%=basePath%>/images/error.png">
</div>

</body>
</html>
