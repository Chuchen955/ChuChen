package soSo_Entity;

/**
 * @author 14606
 * @version 1.0
 * */

/**
 * 移动卡
 * */
public class MobileCard {
	private String cardNumber;// 卡号
	private String userName;// 用户名
	private String passWord;// 密码
	private ServicePackage serPackage;// 套餐,服务包
	private double consumAmount;// 月消费总和
	private double money;// 余额
	private int realTalkTime;// 实际通话时长
	private int realSMSCount;// 实际短信数量
	private int realFlow;// 实际使用流量

	/**
	 * 利用方法重写，在创建新卡的时候，以此填写卡号，用户名，密码（注意数据类型）,套餐类型，月消费，余额
	 * 
	 * @param cardNumber
	 *            卡号
	 * @param userName
	 *            用户名
	 * @param passWord
	 *            密码
	 * @param serPackage
	 *            套餐类型
	 * @param consumAmount
	 *            月消费
	 * @param money
	 *            余额
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
	 * 注册信息
	 * */
	public void showMeg() {
		System.out.println("卡号：" + this.cardNumber + "    用户名：" + this.userName
				+ "    当前余额：" + this.money + "元");
		this.serPackage.showInfo();
	}

	// 默认构造方法
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
