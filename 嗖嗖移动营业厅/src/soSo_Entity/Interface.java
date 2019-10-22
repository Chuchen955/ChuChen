package soSo_Entity;
/**
 * @author 14606
 * @version 1.0
 * */
import java.util.*;

import soSo_Entity.ServicePackage;
import soSo_Utility.CardUtil;

/**
 * 界面
 * */
public class Interface {
	CardUtil util = new CardUtil();
	Scanner input = new Scanner(System.in);

	/**
	 * 主页面
	 * */
	public void home_page() {
		int menuChoose = 0;// 功能选择参数
		String mobileNumber = "";// 手机卡号
		String password = "";// 密码
		util.init();
		util.initScene();
		do {
			System.out.println("**********欢迎使用嗖嗖移动业务大厅**********");
			System.out
					.println("1.用户登录  2.用户注册  3.使用嗖嗖  4.话费充值  5.资费说明  6.退出系统");
			System.out.println("请选择：");
			menuChoose = input.nextInt();
			// 分支语句：根据功能编号执行相应的
			switch (menuChoose) {
			case 1:
				// 用户登录
				System.out.print("请输入手机卡号：");
				mobileNumber = input.next();
				System.out.print("请输入密码：");
				password = input.next();
				if (util.isExistCard(mobileNumber, password)) {
					cardMenu(mobileNumber);
				} else {
					System.out.println("Sorry，您输入的信息有误，无法登录！");
				}
				continue;
			case 2:
				// 用户注册
				registration();
				continue;
			case 3:
				// 使用嗖嗖
				System.out.println("请输入您的手机号：");
				util.useSoso(input.next());
				continue;
			case 4:
				// 话费充值
				System.out.println("请输入您的手机号：");
				String number = input.next();
				System.out.println("请输入充值金额：");
				double money = input.nextDouble();
				util.chargeMoney(number, money);
				continue;
			case 5:
				// 资费说明
				util.showDescription();
				continue;
			case 6:
				System.out.println("您退出了系统，等候您的下次使用~");
				System.exit(0);
			default:
				System.out.println("你的选择有误，请重新输入。");
				break;
			}
		} while (true);
	}

	/**
	 * 用户注册
	 * */
	public void registration() {
		String userName = "";
		String cardNumber = "";
		String passWord = "";
		ServicePackage serPackage = null;
		double consumAmount = 0.0;
		double money = 0.0;
		System.out.println("请输入您的姓名：");
		userName = input.next();
		cardNumber = util.createNumber();// 选号
		System.out.println("请设置您的密码：");
		passWord = input.next();
		System.out.println("1.话痨套餐   2.网虫套餐   3.超人套餐，请选择套餐（输入序号）：");
		serPackage = util.createPack(input.nextInt());
		// 预存话费，计算消费余额
		System.out.println("请输入预存话费金额：");
		while (true) {
			money = input.nextDouble();
			if (money > serPackage.getPrice()) {
				consumAmount = serPackage.getPrice();
				money -= serPackage.getPrice();
				break;
			} else {
				System.out.println("您预存的话费余额不足以支付本月固定套餐资费，请重新充值：");
				continue;
			}
		}
		MobileCard mobileCard = new MobileCard(cardNumber, userName, passWord,
				serPackage, consumAmount, money);// 引入移动卡类
		util.addCard(mobileCard);

	}

	/**
	 * 登录后二级页面
	 * 
	 * @param mobileNumber
	 *            指定用户手机号
	 * @return menuChoose
	 * */
	public int cardMenu(String mobileNumber) {
		int menuChoose = 0;
		do {
			System.out.println("******嗖嗖移动用户菜单******");
			System.out.println("1.本月账单查询");
			System.out.println("2.套餐余量查询");
			System.out.println("3.打印消费详单");
			System.out.println("4.套餐更变");
			System.out.println("5.办理退网");
			System.out.println("请选择（输入1-5选择功能，其他键返回上一级）：");
			menuChoose = input.nextInt();
			switch (menuChoose) {
			case 1:
				System.out.println("******本月账单查询******");
				util.showAmountDetail(mobileNumber);
				continue;
			case 2:
				System.out.println("******套餐余量查询******");
				util.showRemainDetail(mobileNumber);
				continue;
			case 3:
				System.out.println("******打印消费详单******");
				util.printConsumInfo(mobileNumber);
				continue;
			case 4:
				System.out.println("******套餐更变******");
				System.out.println("1.话痨套餐   2.网虫套餐   3.超人套餐，请选择套餐（输入序号）：");
				util.changingPack(mobileNumber, input.nextInt());
				continue;
			case 5:
				System.out.println("******办理退网******");
				util.delCard(mobileNumber);
				System.exit(0);
			default:
				System.out.println("执行返回上一级~");
			}
			break;
		} while (true);

		return menuChoose;
	}
}
