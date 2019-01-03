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
		msg("EnterŰ�� ��������!!");
		getEnter();
	}

	protected void showTeamList(List<soccer_TeamDTO> teamList) {
		System.out.println("********************");
		System.out.println(">>>�� ����Ʈ");
		System.out.println("********************");
		for(soccer_TeamDTO team : teamList) {
			System.out.println(team.getId() +"\t\t\t" + team.getName());
		}
	}
}















