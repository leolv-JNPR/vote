package info.lveyo.vote.controller;

import info.lveyo.vote.beans.Topic;
import info.lveyo.vote.dao.TopicDAO;
import info.lveyo.vote.utils.ResponseUtil;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TopicController {
	
	@Autowired
	private TopicDAO topicDAO;
	
	@RequestMapping(value="/viewTopic")
	public ModelAndView viewTopic(@RequestParam ("conId") int conferenceId){
		return new ModelAndView("topics", "conId", conferenceId);
	}
	
	@RequestMapping(value="/showAllTopicByConId")
	public void showAllTopicByConId(@RequestParam ("conId") int conferenceId, HttpServletResponse response) throws Exception{
		List<Topic> topicsList = topicDAO.getTopicsByConferenceID(conferenceId);
		JSONArray resultJSON = new JSONArray();
		for(Topic topic : topicsList){
			resultJSON.put(topic.getTopicJson());
		}
		ResponseUtil.writeJsonResponseNoCache(response, resultJSON.toString());
	}
	
	@RequestMapping(value="/addTopic", method=RequestMethod.POST)
	public String addTopic(HttpServletRequest request){
		String title = ServletRequestUtils.getStringParameter(request, "newTopicTitle", "");
		int conferenceId = ServletRequestUtils.getIntParameter(request, "conId", 0);
		if(!"".equals(title) && conferenceId!=0){
			Topic topic = new Topic();
			topic.setTitle(title);
			topic.setConferenceID(conferenceId);
			topic.setShow(1);
			topic.setVote(1);
			topicDAO.addNewTopic(topic);
		}
		return "redirect:viewTopic?conId="+conferenceId;
	}
	
	@RequestMapping(value="/deleteTopic")
	public String deleteTopic(@RequestParam ("conId") int conferenceId, @RequestParam ("topicId") int topicId){
		int res = topicDAO.deleteTopic(topicId);
		return "redirect:viewTopic?conId="+conferenceId;
	}

}
