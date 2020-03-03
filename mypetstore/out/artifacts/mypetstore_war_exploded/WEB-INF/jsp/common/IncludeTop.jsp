<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/10/11
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"  pageEncoding="UTF-8"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<head>
    <link rel="StyleSheet" href="css/jpetstore.css" type="text/css"
          media="screen" />

    <meta name="generator"
          content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
    <title>MyPetStore</title>
    <meta content="text/html; charset=windows-1252"
          http-equiv="Content-Type" />
    <meta http-equiv="Cache-Control" content="max-age=0" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="Pragma" content="no-cache" />
</head>



<%--<script src="${pageContext.request.contextPath}/js/jquery-ui-1.12.1/jquery-ui.core.js"></script>--%>
<%--<script src="jquery.ui.widget.js"></script>--%>
<%--<script src="jquery.ui.position.js"></script>--%>
<%--<script src="jquery.ui.autocomplete.js"></script>--%>
<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/js/Auto/autocomplete.css" type="text/css">--%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-ui-1.12.1/jquery-ui.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-1.12.1/jquery-ui.js"></script>

<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/Auto/autocomplete.js"></script>--%>






<body>

<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="main"><img src="images/logo-topbar.gif" /></a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <a href="viewCart"><img align="middle" name="img_cart"
                                    src="images/cart.gif" /></a> <img align="middle"
                                                                         src="images/separator.gif" />
            <a href="signPage">Sign In</a>

            <a href="loginOut">Sign Out</a>
            <img align="middle" src="images/separator.gif" />

            <a href="myAccount">My Account</a>
            <img align="middle" src="images/separator.gif" />

            <a href="../help.html">?</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <form action="searchProducts" method="post">
                <label for="tags">搜索:</label>
                <input id="tags" type="text" name="keyword"  size="14" placeholder="请输入动物名" />
                <input type="submit" name="searchProducts" value="Search" />
            </form>
        </div>
    </div>

    <div id="QuickLinks">
        <a href="viewCategory?categoryId=FISH">
            <img src="images/sm_fish.gif" /></a>
        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=DOGS">
            <img src="images/sm_dogs.gif" /></a>
        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=REPTILES">
            <img
                src="images/sm_reptiles.gif" /></a>
        <img
            src="images/separator.gif" />
        <a href="viewCategory?categoryId=CATS">
        <img
            src="images/sm_cats.gif" /></a>
        <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=BIRDS">
            <img
                src="images/sm_birds.gif" /></a>
    </div>

</div>
<script>
    var names = [
       "Amazon Parrot",
       "Finch",
       "Koi",
         "Goldfish",
       "Angelfish",
        "Tiger Shark",
       "Persian",
        "Manx",
       "Bulldog",
       "Dalmation",
       "Golden Retriever",
       "Labrador Retriever",
       "Iguana",
       "Rattlesnake"];
    $( "#tags" ).autocomplete({

        source: names
    });

    // $(document).ready(function(){
    //     $('#tags').autocomplete({
    //         hints: names,
    //         width: 300,
    //         height: 30,
    //         // onSubmit: function(text){
    //         //     $('#message').html('Selected: <b>' + text + '</b>');
    //         // }
    //     });
    // });

    // $(document).ready(function() {
    //     //your script here
    //     $(function () {
    //         var id = $("#tags").val();
    //         $.get(names, {val: id}, function (data, status) {
    //
    //                 //eval() 函数可计算某个字符串，并执行其中的的 JavaScript 代码。
    //                 //此处eval()的作用是：将JSON字符串形式转换为对象的形式。（因为此处Servlet中是以text/html的形式传过来的）
    //                 // var name = eval(data);
    //                 $("#tags").autocomplete({
    //                     source: names,
    //                     onSubmit: function(text){
    //                         $('#message').html('Selected: <b>' + text + '</b>');
    //                     }
    //                 });
    //             }
    //         );
    //     });
    // });


    //
    // $("#tags").autocomplete( "autoSearch", {
    //
    //                              minChars: 1, // 最小输入一个字节
    //                              width: 310,  //下拉列表宽度 310像素
    //                              max: 10,  //最大10条数据
    //                              matchContains: true,
    //                              highlightItem: false,
    //                              cacheLength: 0,
    //                              extraParams: {
    //
    //                                  type: id //传给后台的数据
    //                              },
    //                          parse: function (data) {  //解析请求回来的数据
    //                                  return $.map(data.content, function (row) {
    //                                          return {
    //                                                  data: row,
    //                                                 value: row.name,
    //                                                  result: row.name
    //                                         };
    //                                      });
    //                              },
    //                         formatItem: function (row, i, max) { // 设置需要显示的数据
    //                                         return row.name;  // 这里我只显示请求回来的名字这项
    //                                  }
    //                          }
    //                      }).result(function (event, data, formatted) { // 这个是当选择某项时触发的回调函数
    //                                  advertiserId = data.id;  // 这里我把data里的id信息存储起来
    //
    //                          })






        // $(document).ready(function(){
        //     $('#tags').autocomplete({
        //         hints: names
        //     });
        // });






</script>

<div id="Content">