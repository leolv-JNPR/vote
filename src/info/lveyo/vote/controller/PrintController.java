package info.lveyo.vote.controller;

import info.lveyo.vote.beans.Conference;
import info.lveyo.vote.beans.Topic;
import info.lveyo.vote.beans.TopicVotesResult;
import info.lveyo.vote.beans.VoteResult;
import info.lveyo.vote.dao.ConferenceDAO;
import info.lveyo.vote.dao.TopicDAO;
import info.lveyo.vote.dao.VoteDAO;
import info.lveyo.vote.utils.ListUtil;
import info.lveyo.vote.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrintController {
	
	@Autowired
	private TopicDAO topicDAO;
	
	@Autowired
	private ConferenceDAO conferenceDAO;
	
	@Autowired
	private VoteDAO voteDAO;

	@RequestMapping(value="/printResult")
	public ModelAndView	print(@RequestParam("conId") int conferenceId){
		Conference conference = conferenceDAO.getConferenceByID(conferenceId);
		List<Topic> topicList = topicDAO.getTopicsByConferenceID(conferenceId);
		List<TopicVotesResult> tvrList = new ArrayList<TopicVotesResult>();
		if(topicList!=null && topicList.size()!=0){
			for(Topic topic : topicList){
				List<VoteResult> vrList = voteDAO.getVoteResultByTopicId(conferenceId, topic.getId());
				tvrList.add(new TopicVotesResult(topic.getId(), topic.getTitle(), ListUtil.parseVoteResultList(vrList)));
			}
		}
		HashMap<String, Object> mapModel = new HashMap<String, Object>();
		mapModel.put("conference", conference);
		mapModel.put("tvrList", tvrList);
		mapModel.put("date", StringUtils.getDate());
		return new ModelAndView("printResult", mapModel);
	}
}
