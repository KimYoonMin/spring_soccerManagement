package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import dto.soccer_MemberDTO;
import dto.soccer_TeamDTO;

public class soccer_MembersQuery extends MappingSqlQuery<soccer_MemberDTO>{
	
	private static String sql = "select member_id, member.name as memberName, "
			+"team.team_id, team.name as teamName from member, team where "
			+"member.team_id = team.team_id and team.team_id = ?";
	
	public soccer_MembersQuery(DataSource dataSource) {
		super(dataSource, sql);
		super.declareParameter(new SqlParameter("team_id", Types.INTEGER));
		compile();
	}
	@Override
	protected soccer_MemberDTO mapRow(ResultSet row, int count) throws SQLException {
		soccer_MemberDTO member = new soccer_MemberDTO();
		member.setId(row.getInt("member_id"));
		member.setName(row.getString("memberName"));
		soccer_TeamDTO team = new soccer_TeamDTO();
		team.setId(row.getInt("team_id"));
		team.setName(row.getString("teamName"));
		member.setTeam(team);
		return member;
	}

}








