<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML>
<html>
  <head>
    <c:if test="${listFinancingProduct == null }">
    	<c:redirect url="GetSomeFinancingProductServlet" />
    </c:if>
    <title>My JSP 'index.jsp' starting page</title>
	<style>
		td{text-align: center;}
	</style>
	<script src="js/jquery-3.3.1.js"></script>
	<script>
		function changeRisk(op){
			if(op==null || op==""){
				return;
			}
			document.getElementById("risk").value=op;
		}
		$(function(){
			$("tr:even").css("background","#CCCCCC");
		});
	</script>
  </head>
  
  <body onload="changeRisk('${param.risk}');">
    <form action="GetSomeFinancingProductServlet" method="post">
    	<p>
    		产品代码: <input type="text" name="id" value="${param.id }" />
    		风险评级: <select name="risk" id="risk">
    			<option value="-1">请选择</option>
    			<option value="1">R1</option>
    			<option value="2">R2</option>
    			<option value="3">R3</option>
    		</select>
    		<input type="submit" value="查询" />
    		<a href="add.jsp">新增理财信息</a>
    	</p>
    </form>
    <table width="100%" border="1">
    	<tr>
    		<th>产品代码</th>
    		<th>风险评级</th>
    		<th>预期收益</th>
    		<th>发售起始日</th>
    		<th>发售截止日</th>
    		<th>产品到期日</th>
    	</tr>
    	<c:if test="${fn:length(listFinancingProduct)==0 }">
    		<tr><td colspan="6">暂无数据</td></tr>
    	</c:if>
    	<c:forEach var="fp" items="${listFinancingProduct }">
    		<tr>
    			<td>${fp.id }</td>
    			<td>
    				<c:choose>
    					<c:when test="${fp.risk==1 }">R1</c:when>
    					<c:when test="${fp.risk==2 }">R2</c:when>
    					<c:when test="${fp.risk==3 }">R3</c:when>
    				</c:choose>
    			</td>
    			<td>${fp.income }</td>
    			<td>${fp.saleStarting }</td>
    			<td>${fp.saleEnd }</td>
    			<td>${fp.end }</td>
    		</tr>
    	</c:forEach>
    </table>
  </body>
</html>
