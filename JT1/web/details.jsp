<%@ page import="utils.Girl.Girls" %>
<%@ page import="utils.DAO.GirlDAO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: faithpercious
  Date: 2017/10/2
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .main{
        width: 80%;
        height:100%;
        margin: 0 auto;
    }
    /*.main img{*/
        /*width: 600px;*/
        /*height: 600px;*/
    /*}*/
    .right{
        float: right;
        width: auto;
        height: auto;
    }
    .right img{
        width: 100px;
        height: 100px;
    }
    h2{
        width: 50%;
        float: left;
    }
    li{
        list-style: none;

    }
    li img{
        width: 200px;
        width: 200px;
    }
    ul{
        position: absolute;
        top: 100px;
        right: 0;
    }
</style>
<body>
<% GirlDAO girlDAO=new GirlDAO();
    Girls girl= girlDAO.getGirlsById(Integer.parseInt(request.getParameter("id")));
    if (girl!=null){
%>

<h2>价格：<%=girl.getMoney()%></h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<h2>姓名:<%=girl.getName()%></h2>
    <div class="main">
        <img src="images/<%=girl.getImg()%>" alt="图片已失效">
        <br>
    </div>
<%
    }
%>
<%
    String ck="";
    Cookie cookies[]=request.getCookies();
    if (cookies!=null&&cookies.length>0){
        for (Cookie c:cookies){
            if (c.getName().equals("LiView")){
                ck=c.getValue();
            }
        }
    }
    String arry[]=ck.split(",");
    int i=arry.length;
    if (arry!=null&&arry.length>0) {
        if (arry.length > 1000)
            ck = "";
    }
    if (ck.contains(request.getParameter("id")+",")){//取消重复添加id的操作
        ck=ck.replace(request.getParameter("id")+",","");//用""替换request.getParameter("id")+","
        ck+=request.getParameter("id")+",";//然后再次添加
    }
    else {
        ck+=request.getParameter("id")+",";
    }
        Cookie cookie=new Cookie("LiView",ck);

        response.addCookie(cookie);
%>
 <ul>
     <li><h3>最近看过的美女</h3></li>
     <%
         ArrayList<Girls> girls=girlDAO.getViewList(ck);
        if (girls!=null&&girls.size()>0){
            for (Girls g:girls)
            {

     %>
     <li><a href="details.jsp?id=<%=g.getId()%>"><img src="images/<%=g.getImg()%>" alt=""></a></li>
    <%
        }
        }
    %>
 </ul>


</body>
</html>
