package info.lveyo.vote.beans;

import java.util.List;

public class TopicVotesResult {
	
	private int topicId;
	
	private String topicTitle;
	
	private List<VoteResult> vrList;

	public TopicVotesResult(int topicId, String topicTitle, List<VoteResult> vrList) {
		this.topicId = topicId;
		this.topicTitle = topicTitle;
		this.vrList = vrList;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public List<VoteResult> getVrList() {
		return vrList;
	}

	public void setVrList(List<VoteResult> vrList) {
		this.vrList = vrList;
	}

}
