package soSo_Entity;

/**
 * @author 14606
 * @version 1.0
 * */

/**
 * �ƶ���
 * */
public class MobileCard {
	private String cardNumber;// ����
	private String userName;// �û���
	private String passWord;// ����
	private ServicePackage serPackage;// �ײ�,�����
	private double consumAmount;// �������ܺ�
	private double money;// ���
	private int realTalkTime;// ʵ��ͨ��ʱ��
	private int realSMSCount;// ʵ�ʶ�������
	private int realFlow;// ʵ��ʹ������

	/**
	 * ���÷�����д���ڴ����¿���ʱ���Դ���д���ţ��û��������루ע���������ͣ�,�ײ����ͣ������ѣ����
	 * 
	 * @param cardNumber
	 *            ����
	 * @param userName
	 *            �û���
	 * @param passWord
	 *            ����
	 * @param serPackage
	 *            �ײ�����
	 * @param consumAmount
	 *            ������
	 * @param money
	 *            ���
	 * 
	 * */
	public MobileCard(String cardNumber, String userName, String passWord,
			ServicePackage serPackage, double consumAmount, double money) {
		this.cardNumber = cardNumber;
		this.userName = userName;
		this.passWord = passWord;
		this.serPackage = serPackage;
		this.consumAmount = consumAmount;
		this.money = money;
	}

	/**
	 * ע����Ϣ
	 * */
	public void showMeg() {
		System.out.println("���ţ�" + this.cardNumber + "    �û�����" + this.userName
				+ "    ��ǰ��" + this.money + "Ԫ");
		this.serPackage.showInfo();
	}

	// Ĭ�Ϲ��췽��
	public MobileCard() {
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public ServicePackage getSerPackage() {
		return serPackage;
	}

	public void setSerPackage(ServicePackage serPackage) {
		this.serPackage = serPackage;
	}

	public double getConsumAmount() {
		return consumAmount;
	}

	public void setConsumAmount(double consumAmount) {
		this.consumAmount = consumAmount;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getRealTalkTime() {
		return realTalkTime;
	}

	public void setRealTalkTime(int realTalkTime) {
		this.realTalkTime = realTalkTime;
	}

	public int getRealSMSCount() {
		return realSMSCount;
	}

	public void setRealSMSCount(int realSMSCount) {
		this.realSMSCount = realSMSCount;
	}

	public int getRealFlow() {
		return realFlow;
	}

	public void setRealFlow(int realFlow) {
		this.realFlow = realFlow;
	}
}
