<%--
  Created by IntelliJ IDEA.
  User: faithpercious
  Date: 2017/10/1
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-16");
%>
    姓名:<%=request.getParameter("username")
    %>
    <br>
    爱好：<%
        if(request.getParameterValues("favorite")!=null) {
            String s[] = request.getParameterValues("favorite");
            for (int i = 0; i < s.length; i++) {
                out.println(s[i]);
            }
        }
    %>
    <span><%=session.getId()%></span>
<a href="/servlet">get方式请求servlet</a>
<a href="/ddd/servlet2">get方式请求servlet</a>
</body>
</html>
