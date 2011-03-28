var htmlForBlank = '<div class="blank">暂时没有项目，请从下面添加。</div>';

function checkVote(){
	var conferenceId = $('#conferenceId').val();
	var votesCount = $('#votesCount').val();
	var topicIdStr = $('#topicIdStr').val();
	var topicIdArray = topicIdStr.split(',');
	var length = topicIdArray.length;
	
	if(parseInt(votesCount)==topicIdArray.length-1){
		for(var i=0; i<length-1; i++){
			//alert(i+' length '+topicIdArray[i]);
			var name = 'radio_'+conferenceId+'_'+topicIdArray[i];
			if($(':radio[name="' + name + '"][checked]').val() == undefined){
				alert("您有未选择的投票题目！");
				$('#'+name+'_1').focus();
				return false;
			}
		}
		return true;
	}
	else{
		return false;
	}
}

function getAllConferences() {
	$.getJSON('showAllConferences', null, function(responseJSON) {
		if (responseJSON == null) {
			originalRequest.request.options.onFailure();
			return;
		}
		var html = '';
		if(responseJSON.length!=0){
			for(var i=0; i<responseJSON.length; i++){
				var icount = i+1;
				html +='<div class="con_div ';
				if(responseJSON[i].active==1){
					html += 'bgRed';
				}
				html +='">';
				html +='<div class="con_title">' + icount+'. <a href="javascript:conference('+responseJSON[i].id+')">'+responseJSON[i].title + '</a>('+responseJSON[i].totalVotes+')</div>';
				
				html +='<div class="clear"></div><div class="con_operate">';
				if(responseJSON[i].active==0){
					html +='<div class="con_run"><b class="icoImg icoRun"></b><span class="bTxt" onclick="runCon('+responseJSON[i].id+',\''+responseJSON[i].title+'\');">启动投票</span></div>';
				}
				else{
					html +='<div class="con_stop"><b class="icoImg icoStop"></b><span class="bTxt" onclick="stopCon('+responseJSON[i].id+',\''+responseJSON[i].title+'\');">停止投票</span></div>';
				}
				html +='<div class="con_delete"><b class="icoImg icoDel"></b><span class="bTxt" onclick="delCon('+responseJSON[i].id+',\''+responseJSON[i].title+'\');">删除</span></div>';
				html +='<div class="con_viewVote"><b class="icoImg icoView"></b><span class="bTxt" onclick="viewResult('+responseJSON[i].id+');">查看投票结果</span></div>';
				html +='</div>';
				html +='<div class="con_date">'+responseJSON[i].crtime+'</div>';
				html +='<div class="clear"></div></div>';
			}
			$('#conferencesList').html(html);
		}
		else{
			$('#conferencesList').html(htmlForBlank);
		}
	});
}

function getAllTopics(conferenceId){
	$.getJSON('showAllTopicByConId', {conId:conferenceId}, function(responseJSON) {
		if (responseJSON == null) {
			originalRequest.request.options.onFailure();
			return;
		}
		var html = '';
		if(responseJSON.length!=0){
			for(var i=0; i<responseJSON.length; i++){
				var icount = i+1;
				html +='<div class="con_div">';
				html +='<div class="con_title">' + icount+'. '+responseJSON[i].title + '</div>';
				
				html +='<div class="clear"></div><div class="con_operate">';
				html +='<div class="con_delete"><b class="icoImg icoDel"></b><span class="bTxt" onclick="delTopic('+responseJSON[i].id+',\''+responseJSON[i].title+'\','+conferenceId+');">删除</span></div>';
				html +='</div>';
				html +='<div class="con_date">'+responseJSON[i].crtime+'</div>';
				html +='<div class="clear"></div></div>';
			}
			$('#conferencesList').html(html);
		}
		else{
			$('#conferencesList').html(htmlForBlank);
		}
	});
}

function conference(conferenceId){
	window.location.href = "viewTopic?conId="+conferenceId;
}

function delCon(conferenceId, conferenceTitle){
	var msg = conferenceTitle + "\n\n您确定删除此次投票吗？";
	if(confirm(msg)){
		window.location.href="deleteConference?conId="+conferenceId;
	}
}

function delTopic(topicId, topicTitle, conferenceId){
	var msg = topicTitle + "\n\n您确定删除这个议题吗？";
	if(confirm(msg)){
		window.location.href="deleteTopic?topicId="+topicId+"&conId="+conferenceId;
	}
}

function runCon(conferenceId, conferenceTitle){
	var msg = conferenceTitle + "\n\n您确定开始此次投票吗？";
	if(confirm(msg)){
		window.location.href="beginConference?conId="+conferenceId;
	}
}

function stopCon(conferenceId, conferenceTitle){
	var msg = conferenceTitle + "\n\n您确定停止此次投票吗？";
	if(confirm(msg)){
		window.location.href="endConference?conId="+conferenceId;
	}
}

function viewResult(conferenceId){
	window.location.href = "viewVotesResult?conId="+conferenceId;
}

function backCon(){
	window.location.href = "conferences";
}

function printResult(conferenceId){
	window.location.href = "printResult?conId="+conferenceId;
}

