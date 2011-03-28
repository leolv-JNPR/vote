package info.lveyo.vote.dao;

import info.lveyo.vote.beans.Topic;

import java.util.List;

public interface TopicDAO {
	
	public List<Topic> getTopicsByConferenceID(int conferenceID);
	
	public int addNewTopic(Topic topic);
	
	public int updateTopic(int topId, String title, int show, int vote);
	
	public int deleteTopic(int topId);
	

}
