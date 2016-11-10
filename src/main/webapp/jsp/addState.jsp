<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/jquery/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>Risk Manage System</title>
</head>
<body>
<div class="container">
	<div class="jumbotron" style="height:130px">
		<h1 style="margin-top:-30px">Risk Manage System</h1>
    </div>
	
	<div class="smallInfo" style="width:20%"><b>Risk Navigation</b></div>
	<div style="width:20%;border:1px solid #999999;float:left;">
	<s:form action="toRisk" method="post" name='toCourse'>
		<ul class="nav nav-pills nav-stacked">
	   <li><a href="javascript:document.toCourse.submit();">风险提交</a></li>
	   <li class="active"><a>风险跟踪</a></li>
		</ul>
	</s:form> 
	</div>
	
	<div style="width:70%;float:left;margin-left:5%">
			<div style="width:100px;margin-bottom:2%;float:left;">
			<a id="modal3" data-target="#myModal3" role="button" class="btn btn-default" data-toggle="modal" style="margin:1% 3%">新增状态</a>
			</div>
			<%int k=0;%>
	   	<s:form method="post" id="submitForm" name="submitForm">
			<input type="hidden" name="shid" id="shid"/>
			<input type="hidden" name="prid" id="prid"/>
	   <s:iterator value="#request.slist">
		<table class="table  table-bordered" style="table-layout:fixed ; ">
				<tbody>
					<tr>
						<td>
							风险内容
						</td>
						<td  style="word-wrap:break-word;" >
							<%=request.getAttribute("itemName") %>
						</td>
						
					</tr>
					<tr>
						<td>
							创建日期
						</td>
						<td  style="word-wrap:break-word;" >
							<s:property value="createTime" />
						</td>
					
					</tr>
					<tr class="success">
						<td>
							状态描述
						</td>
						<td>
							<s:property value="state" />
						</td>
						
					</tr>
					<tr class="">
						<td>
							详情
						</td>
						<td>
							<s:property value="detail" />
						</td>
						
					</tr>
				</tbody>
			</table>
			<%k++; %>
		</s:iterator>
			</s:form>	
		</div>
</div>

<s:form action="addState" method="post">
	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
			
				
				<input type="hidden" name="rid" id="rid" value=<%=request.getAttribute("itemId") %>>
				
				<span class="infoTxt" style="float:left;margin-top:1%;margin-left:3%;vertical-align:top;display:block;">状态描述：</span>
				<textarea style="width:450px;height:70px" name="rdescription"></textarea>
				<br/><br/>
				
				<span class="infoTxt" style="float:left;margin-top:1%;margin-left:3%;vertical-align:top;display:block;">风险详情：</span>
				<textarea style="width:450px;height:70px" name="rdetail"></textarea>
				<br/><br/>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消
					</button>
					<button type="submit" class="btn btn-primary">
						确定</button>
				</div>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-fade -->
	</s:form>
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

</body>
</html>