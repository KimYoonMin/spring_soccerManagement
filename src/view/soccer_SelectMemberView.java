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
		System.out.println(">>>��������");
		System.out.println("============");
	}
	
	public Integer getTeamId() {
		String teamId = getKeyInputString("�� ID");
		if (soccer_Utils.isNumeric(teamId, "�� ID")) {
			return Integer.valueOf(teamId);
		}
		return getTeamId();
	}
	
	public void show() {
		Integer teamId = getTeamId();
		List<soccer_MemberDTO> memberList = memberDAO.getMembers(teamId);
		if (memberList.isEmpty()) {
			msg("������ �ƹ��� �����ϴ�.");
			return;
		}
		showMemberList(memberList);
		msg("EnterŰ�� ��������");
		getEnter();
		super.show();
	}
	
	public void showMemberList(List<soccer_MemberDTO> memberList) {
		System.out.println(memberList.get(0).getTeam().getName()+"���� ���� ���");
		System.out.println("ID\t\t�̸�");
		System.out.println("***************");
		for(soccer_MemberDTO member : memberList) {
			System.out.println(member.getId() +"\t\t"+member.getName());
		}
	}
	
	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		showHeader();
		System.out.println("1. ���� Ʈ���̵�");
		System.out.println("2. ���� ����");
		System.out.println("3. �޴� ����");
		System.out.println("***************");
		System.out.println("��ȣ �Է�(Enter)");
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
