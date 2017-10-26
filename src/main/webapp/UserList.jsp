<%--
  Created by IntelliJ IDEA.
  User: yy
  Date: 2017/10/23
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

   <s:iterator value="userList">
       <s:property value="username"></s:property>
   <br/>
   </s:iterator>
</body>
</html>
