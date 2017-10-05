<%@ page import="utils.DAO.GirlDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="utils.Girl.Girls" %>
<%--
  Created by IntelliJ IDEA.
  User: faithpercious
  Date: 2017/9/30
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    .left{
        float: left;
        width: 300px;
        height: 500px;
        background-color: #455A64;
    }
    .right{
        float: right;
        width: auto;
        height:500px;
        background-color: #455A64;
    }
    .center{
        width: 80%;
        height: 100%;
        /*position: relative;*/
        /*left: 267px;*/
        top: 100px;
        margin: 0 auto;
    }
    img{
        width: 300px;
        height: 200px;
        float: left;
    }
    .contanct{
        width: auto;
        height: 300px;
        float: left;
    }
    h1{
        width: auto;
        height: auto;
        display: block;
        margin: 0 auto;
    }
    .top{
        margin: 0 auto;
        width: 200px;
        height: 100px;
    }
    a{
        text-decoration: none;
    }
    a:visited{
        color: #455A64;
    }
    a:hover{
        color: red;
    }

</style>
<body>
<div class="top">
    <h1>美女租用系统</h1>
</div>
<div class="center">
    <%
        GirlDAO  girlDAO=new GirlDAO();
        ArrayList<Girls> girls= null;
        girls = girlDAO.getAllGirls();
        while (girls!=null&&girls.size()>0) {
            for (int i = 0; i < girls.size(); i++) {
                Girls girl = girls.get(i);
                %>
    <div class="contanct" >
        <img src = "images/<%=girl.getImg()%>" alt = "失效" >
        <span > <%=girl.getName()%></span ><br>
        <a href="details.jsp?id=<%=girl.getId()%>">详情</a><br>
    </div >
        <%    }
        break;
        }
    %>
</div>
</body>
</html>

