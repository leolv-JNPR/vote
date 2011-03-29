package info.lveyo.vote.controller;

import info.lveyo.vote.beans.Conference;
import info.lveyo.vote.beans.TopicResult;
import info.lveyo.vote.dao.ConferenceDAO;
import info.lveyo.vote.dao.TopicDAO;
import info.lveyo.vote.dao.VoteDAO;
import info.lveyo.vote.utils.NetworkUtil;
import info.lveyo.vote.utils.StringUtils;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VoteController {
	
	@Autowired
	private VoteDAO voteDAO;
	
	@Autowired
	private ConferenceDAO conferenceDAO;

	@RequestMapping(value="/doVote", method=RequestMethod.POST)
	public ModelAndView doVote(HttpServletRequest request){
		int conferenceId = ServletRequestUtils.getIntParameter(request, "conferenceId", 0);
		int votesCount = ServletRequestUtils.getIntParameter(request, "votesCount", 0);
		String topicIdStr = ServletRequestUtils.getStringParameter(request, "topicIdStr", "");
		Conference conferenece = conferenceDAO.getConferenceByID(conferenceId);
		HashMap<String, Object> mapModel = new HashMap<String, Object>();
		if(conferenece.getActive()==1){
			String[] topicIdArray = topicIdStr.split(",");
			mapModel.put("conId", conferenceId);
			try {
				if(topicIdArray.length==votesCount){
					for(int i=0; i<votesCount; i++){
						int voteValue = ServletRequestUtils.getIntParameter(request, "radio_"+conferenceId+"_"+topicIdArray[i], 3);
						int res = voteDAO.vote(NetworkUtil.getRemoteAddr(request), conferenceId, Integer.parseInt(topicIdArray[i]), voteValue);
					}
				}
				mapModel.put("result", 1);
			} catch (Exception e) {
				e.printStackTrace();
				mapModel.put("result", 0);
			}
		}
		else{
			mapModel.put("result", -1);
		}
		
		return new ModelAndView("voteDone", mapModel);
	}
	
	@RequestMapping(value="/updateVote", method=RequestMethod.POST)
	public ModelAndView updateVote(HttpServletRequest request){
		int conferenceId = ServletRequestUtils.getIntParameter(request, "conferenceId", 0);
		int votesCount = ServletRequestUtils.getIntParameter(request, "votesCount", 0);
		String topicIdStr = ServletRequestUtils.getStringParameter(request, "topicIdStr", "");
		HashMap<String, Object> mapModel = new HashMap<String, Object>();
		Conference conferenece = conferenceDAO.getConferenceByID(conferenceId);
		if(conferenece.getActive()==1){
		String[] topicIdArray = topicIdStr.split(",");
		mapModel.put("conId", conferenceId);
			try {
				if(topicIdArray.length==votesCount){
					for(int i=0; i<votesCount; i++){
						int voteValue = ServletRequestUtils.getIntParameter(request, "radio_"+conferenceId+"_"+topicIdArray[i], 3);
						int res = voteDAO.updateVote(NetworkUtil.getRemoteAddr(request), conferenceId, Integer.parseInt(topicIdArray[i]), voteValue);
					}
				}
				mapModel.put("result", 1);
			} catch (Exception e) {
				e.printStackTrace();
				mapModel.put("result", 0);
			}
		}
		else{
			mapModel.put("result", -1);
		}
		return new ModelAndView("voteDone", mapModel);
	}
	
	@RequestMapping(value="/viewTopicResult", method=RequestMethod.GET)
	public ModelAndView viewTopicResult(@RequestParam("conId") int conferenceId, HttpServletRequest request){
		List<TopicResult> topicResult = voteDAO.getTopicResultByConferenceID(conferenceId, NetworkUtil.getRemoteAddr(request));
		Conference curConference = conferenceDAO.getConferenceByID(conferenceId);
		
		HashMap<String, Object> mapModel = new HashMap<String, Object>();
		mapModel.put("conference", curConference);
		mapModel.put("topicList", topicResult);
		mapModel.put("votesCount", topicResult.size());
		mapModel.put("topicIdStr", StringUtils.convertResListToString(topicResult, ","));
		return new ModelAndView("viewTopicResult", mapModel);
	}
}
