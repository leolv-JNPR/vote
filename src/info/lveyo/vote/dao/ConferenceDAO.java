package info.lveyo.vote.dao;

import info.lveyo.vote.beans.Conference;

import java.util.List;

public interface ConferenceDAO {
	
	public List<Conference> getConferences();
	
	public Conference getActiveConference();
	
	public Conference getConferenceByID(int conferenceId);
	
	public int addNewConference(Conference conference);
	
	public int deleteConference(int id);
	
	public int updateConference(int id, String title, int totalVotes);
	
	public int beginConference(int conferenceId);
	
	public int endConference(int conferenceId);

}
