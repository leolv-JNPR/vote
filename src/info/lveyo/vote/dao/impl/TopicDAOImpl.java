package info.lveyo.vote.dao.impl;

import info.lveyo.vote.beans.Topic;
import info.lveyo.vote.dao.TopicDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class TopicDAOImpl implements TopicDAO{

	private RowMapper<Topic> rowMapper = new RowMapper<Topic>() {
		@Override
		public Topic mapRow(ResultSet rs, int index) throws SQLException {
			Topic topic = new Topic();
			topic.setId(rs.getInt("_id"));
			topic.setTitle(rs.getString("title"));
			topic.setShow(rs.getInt("show"));
			topic.setVote(rs.getInt("vote"));
			topic.setConferenceID(rs.getInt("con_id"));
			topic.setCrtime(rs.getString("crtime"));
			topic.setUptime(rs.getString("uptime"));
			return topic;
		}};
	
	@Autowired
	private JdbcTemplate sqliteJdbcTemplate;
	
	@Override
	public List<Topic> getTopicsByConferenceID(int conferenceID)throws EmptyResultDataAccessException {
		String sql = "select * from topics where con_id=? and show=1 order by _id";
		return sqliteJdbcTemplate.query(sql, new Object[]{conferenceID}, rowMapper);
	}

	@Override
	public int addNewTopic(Topic topic) {
		String sql = "insert into topics(title,show,vote,con_id) values(?,?,?,?)";
		return sqliteJdbcTemplate.update(sql, new Object[]{topic.getTitle(), topic.getShow(), topic.getVote(), topic.getConferenceID()});
	}

	@Override
	public int updateTopic(int topId, String title, int show, int vote) {
		String sql = "update topics set title=?, show=?, vote=? where _id=?";
		return sqliteJdbcTemplate.update(sql, new Object[]{title, show, vote, topId});
	}

	@Override
	public int deleteTopic(int topId) {
		String sql = "delete from topics where _id=?";
		return sqliteJdbcTemplate.update(sql, new Object[]{topId});
	}


}
