package view;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class soccer_MainView extends soccer_AbsViewTemplate {
	private soccer_SelectTeamView selectTeamView;
	private soccer_InsertMemberView insertMemberView;
	private soccer_SelectMemberView selectMemberView;
	
	public void setSelectTeamView(soccer_SelectTeamView selectTeamView) {
		this.selectTeamView = selectTeamView;
	}
	public void setInsertMemberView(soccer_InsertMemberView insertMemberView) {
		this.insertMemberView = insertMemberView;
	}
	public void setSelectMemberView(soccer_SelectMemberView selectMemberView) {
		this.selectMemberView = selectMemberView;
	}

	@Override
	public void showMenu() {
		System.out.println("***************");
		System.out.println("");
		System.out.println("1. ����");
		System.out.println("2. �� ����Ʈ");
		System.out.println("3. ���� �߰�");
		System.out.println("4. ���� ����");
		System.out.println("");
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
		return 4;
	}

	@Override
	public void execute(int number) {
		switch(number) {
		case 1 :
			msg("���α׷� ����");
			System.exit(0);
		case 2 :
			selectTeamView.show();
			break;
		case 3 :
			insertMemberView.show();
			break;
		case 4 :
			selectMemberView.show();
			break;
		}
	}

	public static void main(String[] args) {
		GenericApplicationContext ac = new GenericXmlApplicationContext("appContext.xml");
		soccer_MainView mv = (soccer_MainView)ac.getBean("mainView");
		
		while(true) {
			mv.show();
		}
	}
}





















