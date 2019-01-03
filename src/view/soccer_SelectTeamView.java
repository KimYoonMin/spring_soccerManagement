package view;

import java.util.List;

import dao.soccer_TeamDAO;
import dto.soccer_TeamDTO;

public class soccer_SelectTeamView extends soccer_AbsView {
	private soccer_TeamDAO teamDAO;
	
	public void setTeamDAO(soccer_TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		List<soccer_TeamDTO> teamList = teamDAO.getTeamList();
		showTeamList(teamList);
		msg("Enter키를 누르세요!!");
		getEnter();
	}

	protected void showTeamList(List<soccer_TeamDTO> teamList) {
		System.out.println("********************");
		System.out.println(">>>팀 리스트");
		System.out.println("********************");
		for(soccer_TeamDTO team : teamList) {
			System.out.println(team.getId() +"\t\t\t" + team.getName());
		}
	}
}















