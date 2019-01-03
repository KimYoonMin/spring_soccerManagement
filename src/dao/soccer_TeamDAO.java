package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dto.soccer_TeamDTO;

public interface soccer_TeamDAO {
	soccer_TeamDTO		getTeam(Integer id) throws DataAccessException;
	List		getTeamList()	throws DataAccessException;
}
