package soSo_Entity;
/**
 * @author 14606
 * @version 1.0
 * */
import java.util.*;

import soSo_Entity.ServicePackage;
import soSo_Utility.CardUtil;

/**
 * ����
 * */
public class Interface {
	CardUtil util = new CardUtil();
	Scanner input = new Scanner(System.in);

	/**
	 * ��ҳ��
	 * */
	public void home_page() {
		int menuChoose = 0;// ����ѡ�����
		String mobileNumber = "";// �ֻ�����
		String password = "";// ����
		util.init();
		util.initScene();
		do {
			System.out.println("**********��ӭʹ�����ƶ�ҵ�����**********");
			System.out
					.println("1.�û���¼  2.�û�ע��  3.ʹ����  4.���ѳ�ֵ  5.�ʷ�˵��  6.�˳�ϵͳ");
			System.out.println("��ѡ��");
			menuChoose = input.nextInt();
			// ��֧��䣺���ݹ��ܱ��ִ����Ӧ��
			switch (menuChoose) {
			case 1:
				// �û���¼
				System.out.print("�������ֻ����ţ�");
				mobileNumber = input.next();
				System.out.print("���������룺");
				password = input.next();
				if (util.isExistCard(mobileNumber, password)) {
					cardMenu(mobileNumber);
				} else {
					System.out.println("Sorry�����������Ϣ�����޷���¼��");
				}
				continue;
			case 2:
				// �û�ע��
				registration();
				continue;
			case 3:
				// ʹ����
				System.out.println("�����������ֻ��ţ�");
				util.useSoso(input.next());
				continue;
			case 4:
				// ���ѳ�ֵ
				System.out.println("�����������ֻ��ţ�");
				String number = input.next();
				System.out.println("�������ֵ��");
				double money = input.nextDouble();
				util.chargeMoney(number, money);
				continue;
			case 5:
				// �ʷ�˵��
				util.showDescription();
				continue;
			case 6:
				System.out.println("���˳���ϵͳ���Ⱥ������´�ʹ��~");
				System.exit(0);
			default:
				System.out.println("���ѡ���������������롣");
				break;
			}
		} while (true);
	}

	/**
	 * �û�ע��
	 * */
	public void registration() {
		String userName = "";
		String cardNumber = "";
		String passWord = "";
		ServicePackage serPackage = null;
		double consumAmount = 0.0;
		double money = 0.0;
		System.out.println("����������������");
		userName = input.next();
		cardNumber = util.createNumber();// ѡ��
		System.out.println("�������������룺");
		passWord = input.next();
		System.out.println("1.�����ײ�   2.�����ײ�   3.�����ײͣ���ѡ���ײͣ�������ţ���");
		serPackage = util.createPack(input.nextInt());
		// Ԥ�滰�ѣ������������
		System.out.println("������Ԥ�滰�ѽ�");
		while (true) {
			money = input.nextDouble();
			if (money > serPackage.getPrice()) {
				consumAmount = serPackage.getPrice();
				money -= serPackage.getPrice();
				break;
			} else {
				System.out.println("��Ԥ��Ļ���������֧�����¹̶��ײ��ʷѣ������³�ֵ��");
				continue;
			}
		}
		MobileCard mobileCard = new MobileCard(cardNumber, userName, passWord,
				serPackage, consumAmount, money);// �����ƶ�����
		util.addCard(mobileCard);

	}

	/**
	 * ��¼�����ҳ��
	 * 
	 * @param mobileNumber
	 *            ָ���û��ֻ���
	 * @return menuChoose
	 * */
	public int cardMenu(String mobileNumber) {
		int menuChoose = 0;
		do {
			System.out.println("******���ƶ��û��˵�******");
			System.out.println("1.�����˵���ѯ");
			System.out.println("2.�ײ�������ѯ");
			System.out.println("3.��ӡ�����굥");
			System.out.println("4.�ײ͸���");
			System.out.println("5.��������");
			System.out.println("��ѡ������1-5ѡ���ܣ�������������һ������");
			menuChoose = input.nextInt();
			switch (menuChoose) {
			case 1:
				System.out.println("******�����˵���ѯ******");
				util.showAmountDetail(mobileNumber);
				continue;
			case 2:
				System.out.println("******�ײ�������ѯ******");
				util.showRemainDetail(mobileNumber);
				continue;
			case 3:
				System.out.println("******��ӡ�����굥******");
				util.printConsumInfo(mobileNumber);
				continue;
			case 4:
				System.out.println("******�ײ͸���******");
				System.out.println("1.�����ײ�   2.�����ײ�   3.�����ײͣ���ѡ���ײͣ�������ţ���");
				util.changingPack(mobileNumber, input.nextInt());
				continue;
			case 5:
				System.out.println("******��������******");
				util.delCard(mobileNumber);
				System.exit(0);
			default:
				System.out.println("ִ�з�����һ��~");
			}
			break;
		} while (true);

		return menuChoose;
	}
}
