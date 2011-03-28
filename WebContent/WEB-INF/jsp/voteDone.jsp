<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投票结果</title>
<link type="text/css" href="css/base.css" rel="stylesheet" />
<link type="text/css" href="css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="css/theme/start/jquery-ui-1.8.custom.css" />
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.10.custom.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script>
var viewUrl = "viewTopicResult?conId=${conId}";
<c:if test="${result==1}">
	$(function() {
		$( "#dialog-message-success" ).dialog({
			modal: true,
			resizable: false,
			buttons: {
				Ok: function() {
					window.location.href=viewUrl;
				}
			},
			close: function(event, ui) { window.location.href=viewUrl; }
		});
	});
</c:if>
<c:if test="${result==0}">
$(function() {
	$( "#dialog-message-fail" ).dialog({
		modal: true,
		resizable: false, 
		buttons: {
			Ok: function() {
				window.location.href=viewUrl;
			}
		},
		close: function(event, ui) { window.location.href=viewUrl; }
	});
});
</c:if>
</script>

</head>
<body>
<div id="dialog-message-success" title="投票成功" style="display:none;">
	<p>
		<span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
		投票成功，感谢您的投票！谢谢！
	</p>
</div>
<div id="dialog-message-fail" title="投票错误" style="display:none;">
	<p>
		<span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
		您已经投过票，请不要重复投票！
	</p>
</div>

</body>
</html>