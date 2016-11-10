<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/mycss.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/jquery/jquery-1.8.3.min.js"></script>
<title>Risk Manage System</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron" style="height: 130px">
			<h1 style="margin-top: -30px">Risk Manage System</h1>
		</div>


		<div class="smallInfo">
			<b>Risk Navigation</b>
		</div>
		<div style="width: 20%; border: 1px solid #999999;; float: left">
			<s:form action="toState" method="post"
				name='toHomework'>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a>风险提交</a></li>
					<li><a href="javascript:document.toHomework.submit();">风险跟踪</a></li>
				</ul>
			</s:form>
		</div>

		<div class="bigInfo">
			<b>Risk Infomation</b>
		</div>

	<s:form action="addRisk" method="post">
		<div
			style="width: 75%; border: 1px solid #999999; padding: 1% 1%; margin-top: -20px; margin-left: 5%; float: left">
			<br /> <input type="hidden" id="courseId" value=名字 />
			<input type="hidden" id="endD" value='名字' /> <input
				type="hidden" id="uname" /> <span class="infoTxt"  style="float: left; display: block"><b>风险名称：</b></span>
			<textarea style="width: 550px; height: 30px" id="rname" name="rname"></textarea><br />
			<br />
			<span class="infoTxt"  style="float: left; display: block"><b>风险内容：</b></span>
			<textarea style="width: 550px; height: 50px" id="rcontent" name="rcontent"></textarea><br />
			<br />
			 <span class="infoTxt"  style="float: left; display: block"><b>风险可能： </b></span> 
			 <textarea style="width: 550px; height: 30px" id="rpossible" name="rpossible"></textarea><br />
			<br /> <span class="infoTxt"  style="float: left; display: block"><b>影响程度：</b></span> 
			<textarea style="width: 550px; height: 30px" id="rinfluence" name="rinfluence"></textarea><br />
			<br />
			 <span class="infoTxt" style="float: left; display: block"><b>风险触发：</b></span>
			<textarea style="width: 550px; height: 30px" id="rtrig" name="rtrig"></textarea>

			<div style="width: 800px; float: left; margin-top: 2%">
				<span class="infoTxt"
					style="vertical-align: top; display: block; float: left"><b>负责跟踪：</b></span>
						<select class="form-control" name="folSelect"
							id="termSelect" style="margin-top: 1%; width: 150px; float: left">
							<s:iterator value="#request.uList">
								<option value='<s:property value="id" />'><s:property
										value="username" /></option>
							</s:iterator>
						</select>
			</div>


			<div
				style="width: 800px; float: left; margin-top: 1%; text-align: center">
				<button class="btn btn-info" id="save" type="submit">添加</button>
			</div>
		</div>
		</s:form>



	</div>

	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

</body>
</html>