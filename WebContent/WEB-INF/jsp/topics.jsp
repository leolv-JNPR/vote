<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>议题列表</title>
<link type="text/css" href="css/base.css" rel="stylesheet" />
<link type="text/css" href="css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="css/theme/start/jquery-ui-1.8.custom.css" />
<link rel="stylesheet" type="text/css" href="css/main.css"/>
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.10.custom.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script>
$(function() {
	$("input:button, input:submit", ".buttons").button();
	getAllTopics(${conId});
});

</script>
</head>
<body>
<div id="wrapper" style="margin-top: 60px">
<div id="content-wrapper">
<!--<table border=0 cellpadding=0 cellspacing=0 height="110px;" width="760px"><tr>
		<td width="86px;" background="images/logo80.gif">&nbsp;</td>
		<td width="444px;" background="images/title-gif.gif">&nbsp;</td>
		<td width="250px;" background="images/new110-250.gif">&nbsp;</td>
	</tr>
	</table>
--><div id="login-wrapper" class="my-dialog">
<div class="my-ui-dialog ui-widget ui-widget-content ui-corner-all">
<div class="ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix">
<span id="ui-dialog-title-dialog" class="ui-dialog-title">议题列表</span></div>
<div style="min-height: 109px; width: auto;"
	class="ui-dialog-content ui-widget-content">
<div style="width:100%;">
<div id="conferencesList"><img src="images/ajaxLoader.gif" /> </div>
<hr style="clear: both; border: none; border-top: 1px solid #CCC; padding:auto 13px" align="left" size="1px" />
<form action="addTopic" method="post">
	<div style="width:100%;">添加议题
		<table border="0" cellpadding="0" width="600px" align="right">
			<tr><td align="right">议题名称：</td><td><input type="text" name="newTopicTitle" class="longInput" maxlength="64"/></td></tr>
		</table>
		<input type="hidden" name="conId" value="${conId }"/>
		<div class="buttons" style="width: 300px;"><input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;<input type="button" value="返回" onclick="backCon();"></div>
	</div>
</form>
</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html>