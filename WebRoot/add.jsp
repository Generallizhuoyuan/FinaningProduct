<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'add.jsp' starting page</title>
    <script src="js/jquery-3.3.1.js"></script>
    <script>
    	$(function(){
    		$("#id").blur(function(){
    			var $id=$(this).val();
    			var $span = $(this).next("span");
    			if($id == ""){
    				$span.html("");
    				return;
    			}
    			$.ajax({
    				"url":"GetOneFinancingProductServlet",
    				"type":"post",
    				"data":{"id":$id},
    				"dataType":"text",
    				"success":function(data){
    					if(data=="true"){
    						$span.html("代码可用");
    					}else{
    						$span.html("代码不可用");
    					}
    				},
    				"error":function(){
    					alert("读取错误!");
    				}
    			});
    		});
    		$("#backBtn").click(function(){
    			history.back();
    		});
    		$("form").submit(function(){
    			if($("#id").val()==""){
    				alert("产品代码不能为空!");
    				return false;
    			}
    			if($("#id").next("span").html()=="代码不可用"){
    				alert("输入的产品代码已存在!");
    				return false;
    			}
    			if($("#risk").val()=="-1"){
    				alert("请选择风险评级!");
    				return false;
    			}
    			if($("#income").val()==""){
    				alert("预期收益不能为空!");
    				return false;
    			}
    			var reg = /^\d{4}-\d{2}-\d{2}$/;
    			if(reg.test($("#saleStarting").val())==false){
    				alert("发售起始日格式不正确!");
    				return false;
    			}
    			if(reg.test($("#saleEnd").val())==false){
    				alert("发售截至日格式不正确!");
    				return false;
    			}
    			if(reg.test($("#end").val())==false){
    				alert("产品到期日格式不正确!");
    				return false;
    			}
    		});
    	});
    </script>
  </head>
  
  <body>
    <form action="InsertOneFinancingProductServlet" method="post">    
    	<h3>新增理财信息</h3>
    	<p>产品代码: <input type="text" name="id" id="id" /><span></span></p>
    	<p>风险评级: <select name="risk" id="risk">
    		<option value="-1">请选择</option>
    		<option value="1">R1</option>
    		<option value="2">R2</option>
    		<option value="3">R3</option>
    	</select>
		</p>
    	<p>预期收益: <input type="text" name="income" id="income" /></p>
    	<p>发售起始日: <input type="text" name="saleStarting" id="saleStarting" /><span>yyyy-MM-dd 格式</span></p>
    	<p>发售截止日: <input type="text" name="saleEnd" id="saleEnd" /><span>yyyy-MM-dd 格式</span></p>
    	<p>产品到期日: <input type="text" name="end" id="end" /><span>yyyy-MM-dd 格式</span></p>
    	<input type="submit" value="保存" />
    	<input type="button" value="返回" id="backBtn" />
    </form>
  </body>
</html>
