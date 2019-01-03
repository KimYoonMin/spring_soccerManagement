package view;

import dao.soccer_MemberDAO;
import dao.soccer_TeamDAO;
import dto.soccer_MemberDTO;
import dto.soccer_TeamDTO;

public class soccer_InsertMemberView extends soccer_AbsView {
	private soccer_TeamDAO teamDAO;
	private soccer_MemberDAO memberDAO;
	
	public void setTeamDAO(soccer_TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}
	public void setMemberDAO(soccer_MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		final String memberName = "���� �̸� ";
		String name = getKeyInputString(memberName);
		if (!soccer_Utils.isEmpty(name, memberName)) {
			return;//show();
		}else if (soccer_Utils.isLength(name, memberName, 128)) {
			soccer_MemberDTO member = new soccer_MemberDTO();
			member.setName(name);
			showTeamField(member);
		}
	}

	public void showTeamField(soccer_MemberDTO member) {
		final String teamId = "�� ID ";
		String id = getKeyInputString(teamId);
		
		if (!soccer_Utils.isEmpty(id, teamId)) {
			return;
		}else if (soccer_Utils.isNumeric(id, teamId)) {
			soccer_TeamDTO team = teamDAO.getTeam(Integer.valueOf(id));
			if (team == null) {
				msg(":::[" + id +"]�� ���� �������� �ʽ��ϴ�.");
				showTeamField(member); 
			}else {
				member.setTeam(team);
				memberDAO.insertMember(member);
				msg(":::��[" + team.getName() +"]�� ���� [" + member.getName() + "]�� �߰�");
			}
		}
	}
}













