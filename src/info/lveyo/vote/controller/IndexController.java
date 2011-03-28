package info.lveyo.vote.controller;

import info.lveyo.vote.beans.Conference;
import info.lveyo.vote.beans.Topic;
import info.lveyo.vote.dao.ConferenceDAO;
import info.lveyo.vote.dao.TopicDAO;
import info.lveyo.vote.utils.StringUtils;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
	
	@Autowired
	private ConferenceDAO conferenceDAO;
	
	@Autowired
	private TopicDAO topicDAO;
	
	@RequestMapping("/")
	public ModelAndView index(){
		Conference activeConference = conferenceDAO.getActiveConference();
		HashMap<String, Object> mapModel = new HashMap<String, Object>();
		mapModel.put("conference", activeConference);
		List<Topic> topicList = topicDAO.getTopicsByConferenceID(activeConference.getId());
		mapModel.put("topicList", topicList);
		mapModel.put("votesCount", topicList.size());
		mapModel.put("topicIdStr", StringUtils.convertListToString(topicList, ","));
		return new ModelAndView("index", mapModel);
	}
}
