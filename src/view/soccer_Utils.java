package view;

import org.apache.commons.lang.StringUtils;

public class soccer_Utils {
	public static boolean isEmpty(String str, String field) {
		if (StringUtils.isEmpty(str)) {//�ƹ��͵� �������� ����� �޼ҵ�
			System.out.println(field+"�� ���� �Է��� �ּ���!!");
			return false;
		}
		return true;
	}
	public static boolean isNumeric(String str, String field) {
		if (StringUtils.isNumeric(str)) {
			return true;
		}
		System.out.println(field+"�� ���ڸ� �Է��� �ּ���!!");
		return false;
	}
	public static boolean isLength(String name, String field, int length) {
		if (name==null) {
			System.out.println("�̸��� �����ϴ�.");
			return false;
		}else if (length < name.length()) {
			System.out.println(field+"�� " + length+"���� ���Ϸ� �Է��� �ּ���");
			return false;
		}
		return true;
	}
}












