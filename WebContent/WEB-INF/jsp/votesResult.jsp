<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投票统计</title>
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
<span id="ui-dialog-title-dialog" class="ui-dialog-title">${conference.title }</span></div>
<div style="min-height: 109px; width: auto;"
	class="ui-dialog-content ui-widget-content">
<div style="width:100%;">
<div id="conferencesList">
<c:forEach var="vr" items="${tvrList }" varStatus="icount" begin="0" step="1">
<div class="con_div">
	<div class="con_title">${icount.index+1 }. ${vr.topicTitle }</div>
	<div class="clear"></div>
	<div class="votesResult">
	<c:forEach var="result" items="${vr.vrList }" varStatus="jcount" begin="0" step="1">
		<c:choose>
		<c:when test="${result.voteValue==1 }">
			<div class="con_agree" title="同意票"><b class="icoImg icoAgree"></b><span class="votesCount">${result.voteCount }</span></div>
		</c:when>
		<c:when test="${result.voteValue==2 }">
			<div class="con_reject" title="反对票"><b class="icoImg icoReject"></b><span class="votesCount">${result.voteCount }</span></div>
		</c:when>
		<c:when test="${result.voteValue==3 }">
			<div class="con_abstain" title="弃权票"><b class="icoImg icoAbstain"></b><span class="votesCount">${result.voteCount }</span></div>
		</c:when>
		</c:choose>
	</c:forEach>
	</div><div class="clear"></div>
</div>
</c:forEach>
<div class="buttons" style="width: 300px; margin: 30px auto;"><input type="button" onclick="printResult(${conference.id });" value="打印"/>&nbsp;&nbsp;&nbsp;<input type="button" value="返回" onclick="backCon();"></div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html>