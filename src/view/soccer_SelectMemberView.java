package view;

import java.util.List;

import dao.soccer_MemberDAO;
import dto.soccer_MemberDTO;

public class soccer_SelectMemberView extends soccer_AbsViewTemplate {

	private soccer_MemberDAO memberDAO;
	private soccer_UpdateMemberView updateMemberView;
	private soccer_DeleteMemberView deleteMemberView;
	
	public void setMemberDAO(soccer_MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	public void setUpdateMemberView(soccer_UpdateMemberView updateMemberView) {
		this.updateMemberView = updateMemberView;
	}
	public void setDeleteMemberView(soccer_DeleteMemberView deleteMemberView) {
		this.deleteMemberView = deleteMemberView;
	}
	
	public void showHeader() {
		System.out.println("***************");
		System.out.println(">>>팀원관리");
		System.out.println("============");
	}
	
	public Integer getTeamId() {
		String teamId = getKeyInputString("팀 ID");
		if (soccer_Utils.isNumeric(teamId, "팀 ID")) {
			return Integer.valueOf(teamId);
		}
		return getTeamId();
	}
	
	public void show() {
		Integer teamId = getTeamId();
		List<soccer_MemberDTO> memberList = memberDAO.getMembers(teamId);
		if (memberList.isEmpty()) {
			msg("선수가 아무도 없습니다.");
			return;
		}
		showMemberList(memberList);
		msg("Enter키를 누르세요");
		getEnter();
		super.show();
	}
	
	public void showMemberList(List<soccer_MemberDTO> memberList) {
		System.out.println(memberList.get(0).getTeam().getName()+"팀의 선수 명단");
		System.out.println("ID\t\t이름");
		System.out.println("***************");
		for(soccer_MemberDTO member : memberList) {
			System.out.println(member.getId() +"\t\t"+member.getName());
		}
	}
	
	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		showHeader();
		System.out.println("1. 팀원 트레이드");
		System.out.println("2. 팀원 방출");
		System.out.println("3. 메뉴 복귀");
		System.out.println("***************");
		System.out.println("번호 입력(Enter)");
	}

	@Override
	public int getMinMenuNumber() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getMaxMenuNumber() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public void execute(int number) {
		 switch(number) {
		 case 1 :
				updateMemberView.show();
				break;
			case 2 :
				deleteMemberView.show();
				break;
			case 3 :
			 return;
		 }

	}

}
