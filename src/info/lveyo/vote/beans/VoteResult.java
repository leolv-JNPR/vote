package info.lveyo.vote.beans;

public class VoteResult {
	
	private int topicId;
	
	private String title;
	
	private int voteValue;
	
	private int voteCount;

	public VoteResult() {
	}

	public VoteResult(int voteValue, int voteCount) {
		this.voteValue = voteValue;
		this.voteCount = voteCount;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getVoteValue() {
		return voteValue;
	}

	public void setVoteValue(int voteValue) {
		this.voteValue = voteValue;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
