package dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import dao.soccer_MemberDAO;
import dto.soccer_MemberDTO;

public class soccer_MemberDAOImpl extends SimpleJdbcTemplate implements soccer_MemberDAO {

	private soccer_InsertMember insertMember;
	private soccer_MembersQuery membersQuery;
	private soccer_MemberQuery memberQuery;
	private soccer_DeleteMember deleteMember;
	private soccer_UpdateMember updateMember;
	
	public soccer_MemberDAOImpl(DataSource dataSource) {
		super(dataSource);
		insertMember = new soccer_InsertMember(dataSource);
		membersQuery = new soccer_MembersQuery(dataSource);
		memberQuery = new soccer_MemberQuery(dataSource);
		deleteMember = new soccer_DeleteMember(dataSource);
		updateMember = new soccer_UpdateMember(dataSource);
	}
	
	@Override
	public void insertMember(soccer_MemberDTO member) throws DataAccessException {
		// TODO Auto-generated method stub
		Object values[] = new Object[] {member.getName(), member.getTeam().getId()};
		insertMember.update(values);
	}

	@Override
	public void updateMember(soccer_MemberDTO member) throws DataAccessException {
		updateMember.update
		(new Object[]{member.getTeam().getId(), member.getId()});
	}

	@Override
	public void deleteMember(soccer_MemberDTO member) throws DataAccessException {
		deleteMember.update(member.getId());
	}

	@Override
	public soccer_MemberDTO getMember(Integer id) throws DataAccessException {
		soccer_MemberDTO member = (soccer_MemberDTO)memberQuery.findObject(id);
		return member;
	}

	@Override
	public List getMembers(Integer id) throws DataAccessException {
		return membersQuery.execute(id);
	}

}
