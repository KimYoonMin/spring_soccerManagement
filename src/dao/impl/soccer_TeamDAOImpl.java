package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import dao.soccer_TeamDAO;
import dto.soccer_TeamDTO;

public class soccer_TeamDAOImpl extends SimpleJdbcTemplate implements soccer_TeamDAO {

	public soccer_TeamDAOImpl(DataSource dataSource) {
		super(dataSource);

	}

	protected class TeamRowMapper implements RowMapper<soccer_TeamDTO>{
		
		@Override
		public soccer_TeamDTO mapRow(ResultSet arg0, int arg1) throws SQLException {
			soccer_TeamDTO team = new soccer_TeamDTO();
			team.setId(arg0.getInt("team_id"));
			team.setName(arg0.getString("name"));
			return team;
		}
	}
	@Override
	public soccer_TeamDTO getTeam(Integer id) throws DataAccessException {
		String sql = "select * from team where team_id=?";
		TeamRowMapper rowMapper = new TeamRowMapper();
		//Object[] values = new Object[] {id};
		soccer_TeamDTO team = super.queryForObject(sql, rowMapper, id);
		return team;
	}

	@Override
	public List getTeamList() throws DataAccessException {
		String sql = "select * from team";
		TeamRowMapper rowMapper = new TeamRowMapper();
		List<soccer_TeamDTO> teamList = super.query(sql, rowMapper);
		return teamList;
	}

}





