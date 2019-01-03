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
		String str = ">>>팀원 정보 수정\n";
		str += "팀원 ID를 입력하여 주세요(Enter)\n";
		str += "아무것도 입력하지 않고 Enter를 누르면 메뉴로 복귀합니다.";
		msg(str);		
	}
	@Override
	public void show() {
		showMenu();
		String id = getKeyInputString("팀원 ID ");
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
		String name = getKeyInputString("팀원 이름 ");
		return name;
	}
	public soccer_TeamDTO getTeam(){
		String id = getKeyInputString("팀 ID ");
		soccer_TeamDTO team = teamDAO.getTeam(Integer.valueOf(id));
		return team;
	}
	
	public soccer_MemberDTO getMember(String id){
		if (soccer_Utils.isNumeric(id, "팀원 ID ")){
			soccer_MemberDTO member = memberDAO.getMember(Integer.valueOf(id));
			return member;
		}
		return null;
	}

}



