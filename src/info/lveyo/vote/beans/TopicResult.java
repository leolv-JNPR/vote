package info.lveyo.vote.beans;

public class TopicResult extends Topic {

	private int voteValue;
	
	private String ipAddr;
	
	private String voteCrtime;
	
	private String voteUptime;

	public int getVoteValue() {
		return voteValue;
	}

	public void setVoteValue(int voteValue) {
		this.voteValue = voteValue;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getVoteCrtime() {
		return voteCrtime;
	}

	public void setVoteCrtime(String voteCrtime) {
		this.voteCrtime = voteCrtime;
	}

	public String getVoteUptime() {
		return voteUptime;
	}

	public void setVoteUptime(String voteUptime) {
		this.voteUptime = voteUptime;
	}
}
