package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dto.soccer_MemberDTO;

public interface soccer_MemberDAO {
	void 	insertMember(soccer_MemberDTO member) throws DataAccessException;
	void	updateMember(soccer_MemberDTO member) throws DataAccessException;
	void 	deleteMember(soccer_MemberDTO member) throws DataAccessException;
	soccer_MemberDTO	getMember(Integer id) throws DataAccessException;
	List		getMembers(Integer id) throws DataAccessException;
}
