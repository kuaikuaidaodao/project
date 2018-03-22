<%@ page import="com.example.demo.entity.cityinfoEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf"  uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    List<cityinfoEntity> list =request.getParameter("")
%>
<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="/trainee.do?method=list" method="post">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                
                    <td>
						<div class="buttonActive">
                            <div class="buttonContent">
                                <button type="submit">检索</button>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
           
        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">

                <li><a class="edit" href="/trainee.do?method=showdetail&uuid={cr}"
                   target="dialog" rel="classroom" width="600" height="450"><span>审核</span></a></li>

        </ul>
    </div>
    <table class="list" width="100%" layoutH="90">
        <thead>
        <tr>
            <th width="20"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
            <th >序号</th>
            <th >标题</th>
            <th >内容</th>
            <th >时间</th>
            <th >分类</th>
            <th >发布人姓名</th>
            <th >发布人电话</th>
        </tr>
        </thead>
        <tbody>
        ${kitty.get(1).classify}
        <c:forEach var="cr" items="${kitty}" >
            <tr >
                <%--<td><input name="ids" value="${cr.id}" type="checkbox"></td>--%>
                <td>${cr.title}</td>
                <%--<td>${cr.getTitle()}</td>--%>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>