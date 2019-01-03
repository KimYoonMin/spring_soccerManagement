package view;

import org.apache.commons.lang.StringUtils;

import dao.soccer_MemberDAO;
import dto.soccer_MemberDTO;

public class soccer_DeleteMemberView extends soccer_AbsView {
	private soccer_MemberDAO memberDAO;
	
	public void setMemberDAO(soccer_MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
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
		if (soccer_Utils.isNumeric(id, "���� ID ")){
			soccer_MemberDTO member = memberDAO.getMember(Integer.valueOf(id));
			memberDAO.deleteMember(member);
		}else {
			show();
		}
	}

}






