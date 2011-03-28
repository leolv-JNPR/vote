package info.lveyo.vote.dao;

import info.lveyo.vote.beans.TopicResult;
import info.lveyo.vote.beans.Vote;
import info.lveyo.vote.beans.VoteResult;

import java.util.List;

public interface VoteDAO {
	
	public int vote(String ipAddr, int conId, int topId, int vote);
	
	public int updateVote(String ipAddr, int conId, int topId, int vote);
	
	public Vote getVote(String ipAddr, int topId, int conId);
	
	public List<TopicResult> getTopicResultByConferenceID(int conferenceID, String ipAddr);
	
	public List<VoteResult> getVoteResultByTopicId(int conferenceId, int topicId);

}
