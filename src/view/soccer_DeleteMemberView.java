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
		String str = ">>>팀원 정보 삭제\n";
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
		if (soccer_Utils.isNumeric(id, "팀원 ID ")){
			soccer_MemberDTO member = memberDAO.getMember(Integer.valueOf(id));
			memberDAO.deleteMember(member);
		}else {
			show();
		}
	}

}






