<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打印投票结果</title>
<link rel="stylesheet" type="text/css"
	href="css/theme/start/jquery-ui-1.8.custom.css" />
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.10.custom.min.js"></script>
<script language="javascript" src="js/jquery.printElement.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/main.js"></script>
<script>
$(function() {
	$("input:button, input:submit", ".buttons").button();
	$('#printarea').printElement();
	return false;
});
</script>
</head>
<body>
<div class="print" id="printarea">
<div style="width:700px; margin: 30px auto; font-size:1.4em; font-weight:bold;">${conference.title }</div>
<table cellspacing="0" cellpadding="10" border="1" align="center" width="700">
<tr>
<th width="385" align="center">议题</th>
<th width="70">同意票</th>
<th width="70">反对票</th>
<th>弃权票</th>
</tr>
<c:forEach var="vr" items="${tvrList }" varStatus="icount" begin="0" step="1">
<tr height="30">
<td>${icount.index+1}. ${vr.topicTitle }</td>
<c:forEach var="result" items="${vr.vrList }" varStatus="jcount" begin="0" step="1">
<td align="center" valign="middle">${result.voteCount }</td>
</c:forEach>
</tr>
</c:forEach>
</table>
<div style="width:700px;margin: 50px auto;text-align:right;padding-right: 30px;">打印时间：${date }</div>
</div>
<div class="buttons" style="width: 300px; margin: 30px auto;"><input type="button" value="返回" onclick="history.back();"></div>
</body>
</html>