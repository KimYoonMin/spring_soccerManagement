package view;

import org.apache.commons.lang.StringUtils;

import dao.soccer_MemberDAO;
import dao.soccer_TeamDAO;
import dto.soccer_MemberDTO;
import dto.soccer_TeamDTO;

public class soccer_UpdateMemberView extends soccer_AbsView {
	private soccer_MemberDAO memberDAO;
	private soccer_TeamDAO teamDAO;
	
	public void setMemberDAO(soccer_MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	public void setTeamDAO(soccer_TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	public void showMenu(){
		String str = ">>>���� ���� ����\n";
		str += "���� ID�� �Է��Ͽ� �ּ���(Enter)\n";
		str += "�ƹ��͵� �Է����� �ʰ� Enter�� ������ �޴��� �����մϴ�.";
		msg(str);		
	}
	@Override
	public void show() {
		showMenu();
		String id = getKeyInputString("���� ID ");
		if (StringUtils.isEmpty(id)){
			return;
		}
		
		soccer_MemberDTO member = getMember(id);
		if (member != null) {
			//member.setName(getName());
			member.setTeam(getTeam());
			memberDAO.updateMember(member);
		}else {
			show();
		}
	}
	public String getName(){
		String name = getKeyInputString("���� �̸� ");
		return name;
	}
	public soccer_TeamDTO getTeam(){
		String id = getKeyInputString("�� ID ");
		soccer_TeamDTO team = teamDAO.getTeam(Integer.valueOf(id));
		return team;
	}
	
	public soccer_MemberDTO getMember(String id){
		if (soccer_Utils.isNumeric(id, "���� ID ")){
			soccer_MemberDTO member = memberDAO.getMember(Integer.valueOf(id));
			return member;
		}
		return null;
	}

}



