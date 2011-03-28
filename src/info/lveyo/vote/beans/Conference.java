package info.lveyo.vote.beans;

import org.json.JSONException;
import org.json.JSONObject;

public class Conference {
	
	private int id;
	
	private String title;
	
	private int active;
	
	private int totalVotes;
	
	private String crtime;
	
	private String uptime;


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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getTotalVotes() {
		return totalVotes;
	}

	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
	}
	
	public JSONObject getConferenceJson() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", this.id);
		jsonObject.put("title", this.title);
		jsonObject.put("totalVotes", this.totalVotes);
		jsonObject.put("active", this.active);
		jsonObject.put("crtime", this.crtime);
		jsonObject.put("uptime", this.uptime);
		return jsonObject;
	}

}
