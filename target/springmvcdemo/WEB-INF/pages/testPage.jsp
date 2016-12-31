<%--
  Created by IntelliJ IDEA.
  User: 符柱成
  Date: 2016/12/30
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <!-- 这个是重点！！！jstl使用获取数据的前提-->
    <%@ page isELIgnored="false" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SpringMVC 博客管理</title>


    <title>分页page</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>


    <![endif]-->

</head>
<body>
<div layout:fragment="content">
    <a href="/admin/blogs" class="list-group-item active">
        你的博客文章
    </a>
    <table class="table table-bordered table-striped">
        <tr>
            <th>ID</th>
            <th>标题</th>
            <th>作者</th>
            <th>发布日期</th>
            <th>操作</th>
        </tr>
        <!--根据key得到的那个sourceCodeList就需要遍历出来，按照他包含的BlogEntitiy去读出来-->
        <c:forEach items="${sourceCodeList}" var="blog">
            <tr>
                <td>${blog.id}</td>
                <td>${blog.title}</td>
                <td>${blog.userByUserId.nickname}, ${blog.userByUserId.firstName} ${blog.userByUserId.lastName}</td>
                <td><fmt:formatDate value="${blog.pubDate }" pattern="yyyy-MM-dd"/></td>
                <td>
                    <a href="/admin/blogs/show/${blog.id}" type="button" class="btn btn-sm btn-success">详情</a>
                    <a href="/admin/blogs/update/${blog.id}" type="button" class="btn btn-sm btn-warning">修改</a>
                    <a href="/admin/blogs/delete/${blog.id}" type="button" class="btn btn-sm btn-danger">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <!--这里就是处理那几个传过来的page数据的啦，从而实现分页嘛-->
            <td colspan="6" align="center" bgcolor="#5BA8DE">共${totalPageNumber}条记录 共${totalPages}页
                当前第${numberPage+1}页<br>

                <c:choose>
                    <c:when test="${numberPage!=0}">
                        <a href="${path}/admin/blogs?pageNonumber=${numberPage-1}"><input type="button"
                                                                                          name="previousPage"
                                                                                          value="上一页"/></a>
                    </c:when>
                    <c:otherwise>

                        <input type="button" disabled="disabled" name="previousPage" value="上一页"/>

                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${numberPage != totalPages-1}">
                        <a href="${path}/admin/blogs?pageNonumber=${numberPage+1}"><input type="button" name="nextPage"
                                                                                          value="下一页"/></a>
                    </c:when>
                    <c:otherwise>

                        <input type="button" disabled="disabled" name="nextPage" value="下一页"/>

                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </table>

</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
