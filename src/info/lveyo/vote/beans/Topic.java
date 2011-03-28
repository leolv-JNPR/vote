package info.lveyo.vote.beans;

import org.json.JSONException;
import org.json.JSONObject;

public class Topic {
	
	private int id;
	
	private String title;
	
	private int show;
	
	private int vote;
	
	private int conferenceID;
	
	private String crtime;
	
	private String uptime;
	
	public JSONObject getTopicJson() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", this.id);
		jsonObject.put("title", this.title);
		jsonObject.put("show", this.show);
		jsonObject.put("vote", this.vote);
		jsonObject.put("conferenceID", this.conferenceID);
		jsonObject.put("crtime", this.crtime);
		jsonObject.put("uptime", this.uptime);
		return jsonObject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getShow() {
		return show;
	}

	public void setShow(int show) {
		this.show = show;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public String getCrtime() {
		return crtime;
	}

	public void setCrtime(String crtime) {
		this.crtime = crtime;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public int getConferenceID() {
		return conferenceID;
	}

	public void setConferenceID(int conferenceID) {
		this.conferenceID = conferenceID;
	}

}
