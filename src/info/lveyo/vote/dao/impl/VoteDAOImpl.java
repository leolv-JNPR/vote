package info.lveyo.vote.dao.impl;

import info.lveyo.vote.beans.TopicResult;
import info.lveyo.vote.beans.Vote;
import info.lveyo.vote.beans.VoteResult;
import info.lveyo.vote.dao.VoteDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class VoteDAOImpl implements VoteDAO{
	
	private RowMapper<Vote> voteRowMapper = new RowMapper<Vote>(){

		@Override
		public Vote mapRow(ResultSet rs, int index) throws SQLException {
			Vote vote = new Vote();
			vote.setIpAddr(rs.getString("ipaddr"));
			vote.setConferenceId(rs.getInt("con_id"));
			vote.setTopicId(rs.getInt("top_id"));
			vote.setVote(rs.getInt("vote"));
			vote.setCrtime(rs.getString("crtime"));
			vote.setUptime(rs.getString("uptime"));
			return vote;
		}
		
	};
	
	private RowMapper<TopicResult> topicResultRowMapper = new RowMapper<TopicResult>(){

		@Override
		public TopicResult mapRow(ResultSet rs, int index) throws SQLException {
			TopicResult tr = new TopicResult();
			tr.setTitle(rs.getString("title"));
			tr.setVote(rs.getInt("vote"));
			tr.setConferenceID(rs.getInt("con_id"));
			tr.setId(rs.getInt("top_id"));
			tr.setVoteValue(rs.getInt("votevalue"));
			tr.setIpAddr(rs.getString("ipaddr"));
			tr.setVoteCrtime(rs.getString("crtime"));
			tr.setUptime(rs.getString("uptime"));
			return tr;
		}
		
	};
	
	private RowMapper<VoteResult> voteResultRowMapper = new RowMapper<VoteResult>(){

		@Override
		public VoteResult mapRow(ResultSet rs, int index) throws SQLException {
			VoteResult vr = new VoteResult();
			vr.setTopicId(rs.getInt("top_id"));
			vr.setVoteValue(rs.getInt("vote"));
			vr.setVoteCount(rs.getInt("votecount"));
			return vr;
		}
		
	};
	
	
	@Autowired
	private JdbcTemplate sqliteJdbcTemplate;

	@Override
	public int vote(String ipAddr, int conId, int topId, int vote) {
		String sql = "insert into votes(ipaddr, top_id, con_id, vote) values (?,?,?,?)";
		return sqliteJdbcTemplate.update(sql, new Object[]{ipAddr, topId, conId, vote});
	}

	@Override
	public int updateVote(String ipAddr, int conId, int topId, int vote) {
		String sql = "update votes set vote=? where ipaddr=? and top_id=? and con_id=?";
		return sqliteJdbcTemplate.update(sql, new Object[]{vote, ipAddr, topId, conId});
	}

	@Override
	public Vote getVote(String ipAddr, int topId, int conId)throws EmptyResultDataAccessException {
		String sql = "select * from vote where ipaddr=? and top_id=? and con_id=?";
		return sqliteJdbcTemplate.queryForObject(sql, new Object[]{ipAddr, topId, conId}, voteRowMapper);
	}
	
	@Override
	public List<TopicResult> getTopicResultByConferenceID(int conferenceID, String ipAddr) {
		String sql = "SELECT t1.title, t1.vote, t2.con_id, t2.top_id, t2.vote as votevalue, t2.ipaddr, t2.crtime, t2.uptime " +
				"FROM topics t1, votes t2 where t2.top_id=t1._id and t1.show=1 and t2.con_id=? and t2.ipaddr=?";
		return sqliteJdbcTemplate.query(sql, new Object[]{conferenceID, ipAddr}, topicResultRowMapper);
	}

	@Override
	public List<VoteResult> getVoteResultByTopicId(int conferenceId, int topicId) {
		String sql = "select top_id, vote, count(vote) votecount from votes where con_id=? and top_id=? group by vote order by vote";
		return sqliteJdbcTemplate.query(sql, new Object[]{conferenceId, topicId}, voteResultRowMapper);
	}

}
