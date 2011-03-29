package info.lveyo.vote.beans;

import java.util.List;

public class TopicVotesResult {
	
	private int topicId;
	
	private String topicTitle;
	
	private int agreeCount;
	
	private int rejectCount;
	
	private int abstainCount;
	
	public TopicVotesResult(int topicId, String topicTitle, int agreeCount, int rejectCount, int abstainCount) {
		this.topicId = topicId;
		this.topicTitle = topicTitle;
		this.agreeCount = agreeCount;
		this.rejectCount = rejectCount;
		this.abstainCount = abstainCount;
	}

	public int getTopicId() {
		return topicId;
	}

	public int getAgreeCount() {
		return agreeCount;
	}

	public void setAgreeCount(int agreeCount) {
		this.agreeCount = agreeCount;
	}

	public int getRejectCount() {
		return rejectCount;
	}

	public void setRejectCount(int rejectCount) {
		this.rejectCount = rejectCount;
	}

	public int getAbstainCount() {
		return abstainCount;
	}

	public void setAbstainCount(int abstainCount) {
		this.abstainCount = abstainCount;
	}

	public int getTotalCount() {
		return agreeCount + rejectCount + abstainCount;
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

}
