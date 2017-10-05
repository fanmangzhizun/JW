<%@ page import="utils.DAO.GirlDAO" %>
<%@ page import="utils.Girl.Girls" %>
<%@ page import="utils.Dire.Store" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %><%--
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
<style>
    body{
        background-color: #455A64;
    }
    *{
        padding: 0;
        margin: 0;
    }
    h1{
        width: 200px;
        height: auto;
        margin: 0 auto;
    }
    ul{
        width: 100%;
        height: auto;
        display: inline-block;
    }
    li{
        list-style: none;
        float: left;
        width: 20%;
        font-weight: bold;
        font-family: "Adobe 楷体 Std R";
        font-size: large;
        text-align: center;
    }
li img{
    width: 200px;
    height: 200px;
}
    #center{
        position: relative;
        width: 80%;
        height: auto;
        margin: 0 auto;
        background-color:cadetblue;
    }
    #foot{
        position: absolute;
        bottom: 0;
        right: 0;
    }
    #foot span{
        font-size: larger;
        font-weight: bold;
    }
    a{
        text-decoration: none;
        color: black;
        font-weight: bold;
        font-size: large;
    }
    a:hover{
        cursor: pointer;
        color: red;
    }
</style>
<body>
<a href="index.jsp">返回首页</a>
<h1>租用订单详情</h1>
<div id="center">
    <ul>
        <li>美女图片</li>
        <li>美女名称</li>
        <li>美女价格</li>
        <li>租用天数</li>
        <li>取消订单</li>
    </ul>
    <%
        Store order=(Store) request.getSession().getAttribute("order");
        HashMap<Girls,Integer> girls=order.getLearn();
        Set<Girls> g=girls.keySet();
        Iterator<Girls> it=g.iterator();
        while (it.hasNext()){
            Girls gh=it.next();
    %>
    <ul>
        <li><img src="images/<%=gh.getImg()%>" alt=""></li>
        <li><%=gh.getName()%></li>
        <li><%=gh.getMoney()%></li>
        <li><%=girls.get(gh)%></li>
        <li><a href="/servlet?action=delete&id=<%=gh.getId()%>">删除此订单</a></li>
    </ul>
    <%}%>
</div>
<div id="foot">
    <span>总金额：￥<%=order.getTotalprice()%></span>
</div>
</body>
</html>
