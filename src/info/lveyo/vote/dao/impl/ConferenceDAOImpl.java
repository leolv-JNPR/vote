package info.lveyo.vote.dao.impl;

import info.lveyo.vote.beans.Conference;
import info.lveyo.vote.dao.ConferenceDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ConferenceDAOImpl implements ConferenceDAO {
	
	private RowMapper<Conference> rowMapper = new RowMapper<Conference>() {
		@Override
		public Conference mapRow(ResultSet rs, int index) throws SQLException {
			Conference confernce = new Conference();
			confernce.setId(rs.getInt("_id"));
			confernce.setTitle(rs.getString("title"));
			confernce.setActive(rs.getInt("active"));
			confernce.setTotalVotes(rs.getInt("totalvotes"));
			confernce.setCrtime(rs.getString("crtime"));
			confernce.setUptime(rs.getString("uptime"));
			return confernce;
		}};
	
	@Autowired
	private JdbcTemplate sqliteJdbcTemplate;

	@Override
	public List<Conference> getConferences() {
		String sql = "select * from conferences order by uptime desc";
		return sqliteJdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Conference getActiveConference() throws EmptyResultDataAccessException {
		String sql = "SELECT * FROM conferences t where t._id in (select max(_id) from conferences where active=1)";
		return sqliteJdbcTemplate.queryForObject(sql, rowMapper);
	}

	@Override
	public int addNewConference(final Conference conference) {
		final String sql = "insert into conferences(title, totalvotes) values(?,?)";
		return sqliteJdbcTemplate.update(sql, new Object[] {conference.getTitle(), conference.getTotalVotes()});
	}

	@Override
	public int deleteConference(int id) {
		String sql = "delete from conferences where _id=?";
		return sqliteJdbcTemplate.update(sql, new Object[]{id});
	}

	@Override
	public int updateConference(int id, String title, int totalVotes) {
		String sql = "update conferences set title=?,totalvotes=?,uptime=datetime(CURRENT_TIMESTAMP,'localtime') where _id=?";
		return sqliteJdbcTemplate.update(sql, new Object[]{title, totalVotes, id});
	}

	@Override
	public Conference getConferenceByID(int conferenceId) throws EmptyResultDataAccessException{
		String sql = "SELECT * FROM conferences t where t._id=?";
		return sqliteJdbcTemplate.queryForObject(sql, new Object[]{conferenceId}, rowMapper);
	}

	@Override
	public int beginConference(int conferenceId) {
		String sql = "update conferences set active=0";
		String sql2 = "update conferences set active=1,uptime=datetime(CURRENT_TIMESTAMP,'localtime') where _id=?";
		sqliteJdbcTemplate.update(sql);
		return sqliteJdbcTemplate.update(sql2, new Object[]{conferenceId});
	}

	@Override
	public int endConference(int conferenceId) {
		String sql = "update conferences set active=0,uptime=datetime(CURRENT_TIMESTAMP,'localtime') where _id=?";
		return sqliteJdbcTemplate.update(sql, new Object[]{conferenceId});
	}
	
}
