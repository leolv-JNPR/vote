package info.lveyo.vote.controller;

import info.lveyo.vote.beans.Conference;
import info.lveyo.vote.dao.ConferenceDAO;
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

@Controller
public class ConferenceController {
	
	@Autowired
	private ConferenceDAO conferenceDAO;

	@RequestMapping(value="/showAllConferences", method=RequestMethod.GET)
	public void showAllConferences(HttpServletResponse response) throws Exception{
		List<Conference> allConferences = conferenceDAO.getConferences();
		JSONArray resultJSON = new JSONArray();
		for(Conference conference : allConferences){
			resultJSON.put(conference.getConferenceJson());
		}
		ResponseUtil.writeJsonResponseNoCache(response, resultJSON.toString());
	}
	
	@RequestMapping(value="/conferences")
	public String conferences(){
		return "conferences";
	}
	
	@RequestMapping(value="/addConference", method=RequestMethod.POST)
	public String addConference(HttpServletRequest request){
		String title = ServletRequestUtils.getStringParameter(request, "newConferenceTitle", "");
		int totalVotes = ServletRequestUtils.getIntParameter(request, "newConferenceTotalVotes", 0);
		if(!"".equals(title)){
			Conference conference = new Conference();
			conference.setActive(1);
			conference.setTitle(title);
			conference.setTotalVotes(totalVotes);
			conferenceDAO.addNewConference(conference);
		}
		return "redirect:conferences";
	}
	
	@RequestMapping(value="/deleteConference")
	public String deleteConference(@RequestParam("conId") int conferenceId){
		int res = conferenceDAO.deleteConference(conferenceId);
		return "redirect:conferences";
	}
	
	@RequestMapping(value="/beginConference")
	public String beginConference(@RequestParam("conId") int conferenceId){
		int res = conferenceDAO.beginConference(conferenceId);
		System.out.println(res);
		return "redirect:conferences";
	}
	
	@RequestMapping(value="/endConference")
	public String endConference(@RequestParam("conId") int conferenceId){
		int res = conferenceDAO.endConference(conferenceId);
		return "redirect:conferences";
	}

}
