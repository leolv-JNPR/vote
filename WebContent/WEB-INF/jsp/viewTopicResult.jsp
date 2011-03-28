<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请投票</title>
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
	$(".answerRadio").buttonset();
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
<div style="float: left; width:100%;">
<form action="updateVote" method="post" onsubmit="return checkVote();">
<input type="hidden" id="conferenceId" name="conferenceId" value="${conference.id }"/>
<input type="hidden" id="votesCount" name="votesCount" value="${votesCount }"/>
<input type="hidden" id="topicIdStr" name="topicIdStr" value="${topicIdStr }"/>
<c:forEach var="topic" items="${topicList }" varStatus="icount" begin="0" step="1">
	<div class="topics">
	<div class="topicQues">${icount.count }. ${topic.title }</div>
	<div class="answerRadio"><input type="radio"
		class="topicAnwser_radio"
		id="radio_${topic.conferenceID }_${topic.id}_1"
		name="radio_${topic.conferenceID }_${topic.id}" value="1" 
		<c:if test="${topic.voteValue==1 }">checked</c:if> />
		<label
		for="radio_${topic.conferenceID }_${topic.id}_1">同 意</label> <input
		type="radio" class="topicAnwser_radio"
		id="radio_${topic.conferenceID }_${topic.id}_2"
		name="radio_${topic.conferenceID }_${topic.id}" value="2" 
		<c:if test="${topic.voteValue==2 }">checked</c:if> /><label
		for="radio_${topic.conferenceID }_${topic.id}_2">否 决</label> <input
		type="radio" class="topicAnwser_radio"
		id="radio_${topic.conferenceID }_${topic.id}_3"
		name="radio_${topic.conferenceID }_${topic.id}" value="3" 
		<c:if test="${topic.voteValue==3 }">checked</c:if> /><label
		for="radio_${topic.conferenceID }_${topic.id}_3">弃 权</label></div>
	</div>
	<hr style="clear: both; border: none; border-top: 2px dashed #CCC; margin:auto 3px" align="left" size="1px" />
</c:forEach>
	<c:if test="${conference.active==1 }">
		<div id="submit_div">
			<div class="buttons">
				<input type="submit" value="修改投票" style="width:120px;"/>
			</div>
		</div>
	</c:if>
</form>
</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html>