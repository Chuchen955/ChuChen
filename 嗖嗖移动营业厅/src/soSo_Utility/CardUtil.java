package soSo_Utility;
/**
 * @author 14606
 * @version 1.0
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.*;

import soSo_Business_Interface.CallService;
import soSo_Business_Interface.NetService;
import soSo_Business_Interface.SendService;
import soSo_Entity.*;

/**
 * 工具类
 * */
public class CardUtil {
	// 注册新卡（卡号，卡对象）
	Map<String, MobileCard> cards = new HashMap<String, MobileCard>();
	// 消费记录（卡号，该卡所有的消费记录）
	Map<String, List<ConsumInfo>> consumInfos = new HashMap<String, List<ConsumInfo>>();
	List<soSo_Entity.Scene> scenes = new ArrayList<soSo_Entity.Scene>();// 使用场景
	Scanner input = new Scanner(System.in);
	TalkPackage talkPackage = new TalkPackage();
	NetPackage netPackage = new NetPackage();
	SuperPackage superPackage = new SuperPackage();

	/**
	 * 数据初始化 手机号 用户名 密码 套餐类型 月消费 余额
	 * */
	public void init() {
		MobileCard mobileCard1 = new MobileCard("17629756743", "张朝阳", "123456",
				superPackage, 100, 1000);
		MobileCard mobileCard2 = new MobileCard("18739096729", "张小阳", "123456",
				netPackage, 100, 20);
		MobileCard mobileCard3 = new MobileCard("13939909475", "阳阳姑", "123456",
				talkPackage, 100, 20);
		MobileCard mobileCard4 = new MobileCard("13233934137", "阳阳妈", "123456",
				talkPackage, 100, 20);
		cards.put("17629756743", mobileCard1);
		cards.put("18739096729", mobileCard2);
		cards.put("13939909475", mobileCard3);
		cards.put("13233934137", mobileCard4);
	}

	/**
	 * 使用场景初始化 类型 数据 使用场景
	 */
	public void initScene() {
		scenes.add(new soSo_Entity.Scene("通话", 60,
				"与客户畅谈人生，稍不留神一个小时过去了，通话时间使用60分钟。"));
		scenes.add(new soSo_Entity.Scene("通话", 3, "约女朋友一起吃饭，通话时间使用3分钟。"));
		scenes.add(new soSo_Entity.Scene("短信", 2, "银行卡查账，用了2条短信。"));
		scenes.add(new soSo_Entity.Scene("短信", 10, "女朋友查岗，汇报情况，用了10条短信。"));
		scenes.add(new soSo_Entity.Scene("上网", 1, "日常看资讯1G"));
		scenes.add(new soSo_Entity.Scene("上网", 2, "周末追番用了2G。"));
	}

	/**
	 * 是否存在此卡用户
	 * 
	 * @param number
	 *            手机号
	 * @param passWord
	 *            密码
	 * @return 不存在：false 存在：true
	 */
	public boolean isExistCard(String number, String passWord) {
		Set<String> numbers = cards.keySet();
		// 一个迭代器只能遍历一次
		// hasNext,是否具有下一个指针
		Iterator<String> it = numbers.iterator();
		while (it.hasNext()) {
			String searchNum = it.next();
			if (searchNum.equals(number)) {
				if ((cards.get(searchNum)).getPassWord().equals(passWord)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 查找指定卡号是否已注册
	 * 
	 * @param number
	 *            手机号
	 * @return 未注册：false 已注册：true
	 */
	public boolean isExistCard(String number) {
		Set<String> numbers = cards.keySet();
		// 超级For没有下标，原理是，将numbers中的值依次传递给numbeR
		// 再由numbeR与需要判断的手机号进行判断
		for (String numbeR : numbers) {
			if (numbeR.equals(number)) {
				return true;
			}
		}
		return false;

	}

	/**
	 * 创建卡号（以139开头 11位）
	 * 
	 * @return 生成的随机手机卡号
	 */
	public String createNumber() {
		String[] cardNumbers = new String[9];// 用于存放生成的电话号码
		System.out.println("******可选择的卡号******");
		for (int i = 0; i < 9; i++) {// 9代表循环九次，产生九个随机号码
			String number = "139";// 定义电话号码以139开头
			Random random = new Random();// 定义random，产生随机数
			for (int j = 0; j < 8; j++) {
				// 生成0~9 随机数，字符串类型会直接追加到后边，初始化139，在循环8次，就是一个11位数的电话号
				number += random.nextInt(9);
			}
			cardNumbers[i] = number;
			System.out.print((i + 1) + "." + number + "   ");// 输出一个电话号码
			// 用于控制三个号码一行
			if ((i + 1) % 3 == 0) {
				System.out.println("");
			}
		}
		System.out.println("请选择卡号（输入1-9的序号）：");
		int Xcard = input.nextInt();
		// 便利数组，寻找与选择的序号相对应的卡号
		for (int i = 0; i < cardNumbers.length; i++) {
			if (i == Xcard - 1) {// 这里-1（由于上边展示的时候，基于数组下标加了1，这里为了对应也得减去 1）
				return cardNumbers[i];
			}
		}
		return "";

	}

	/**
	 * 选择套餐（话唠套餐、网虫套餐、超人套餐）
	 * 
	 * @param Xpackage
	 *            选择项
	 * @return serPackage 返回套餐类型
	 * */
	public ServicePackage createPack(int Xpackage) {
		TalkPackage talkPackage = new TalkPackage();
		NetPackage netPackage = new NetPackage();
		SuperPackage superPackage = new SuperPackage();
		ServicePackage serPackage = null;
		switch (Xpackage) {
		case 1:
			serPackage = talkPackage;
			break;
		case 2:
			serPackage = netPackage;
			break;
		case 3:
			serPackage = superPackage;
			break;
		}
		return serPackage;
	}

	/**
	 * 添加新卡，到集合里
	 * 
	 * @param card
	 *            新卡
	 */
	public void addCard(MobileCard card) {
		cards.put(card.getCardNumber(), card);
		System.out.println("注册成功！");
		card.showMeg();
	}

	/**
	 * 数据格式化
	 * 
	 * @param number
	 *            手机号
	 * @return number 手机号
	 * */
	public static String forMats(double number) {
		DecimalFormat formats = new DecimalFormat("#.0");
		return formats.format(number);

	}

	/**
	 * 查询指定卡当月消费详单
	 * 
	 * @param number
	 *            手机号
	 */
	public void showAmountDetail(String number) {
		MobileCard card;
		StringBuffer sbfr = new StringBuffer();
		card = cards.get(number);
		sbfr.append("您的卡号：" + card.getCardNumber() + "\n当月账单：\n");
		sbfr.append("套餐资费：" + card.getSerPackage().getPrice() + "元\n");
		sbfr.append("合计：" + forMats(card.getConsumAmount()) + "元\n");
		sbfr.append("账户余额：" + forMats(card.getMoney()) + "元\n");
		System.out.println(sbfr);
	}

	/**
	 * 查询指定卡套餐余量
	 * 
	 * @param number
	 *            手机号
	 */
	public void showRemainDetail(String number) {
		MobileCard card;
		int remainTalkTime;// 通话
		int remainSmsCount;// 短信
		int remainFlow;// 流量
		StringBuffer pin = new StringBuffer();
		card = cards.get(number);
		pin.append("您的卡号是：" + card.getCardNumber() + "\n套餐内剩余：\n");
		ServicePackage pack = card.getSerPackage();
		if (pack instanceof TalkPackage) {
			// 话唠卡，查询套餐内剩余的通话时长和短信条数
			TalkPackage cardpack = (TalkPackage) pack;
			// 如果cardPack.getTalkTime() >card.getRealTalkTime()成立
			// 就把cardPack.getTalkTime()-card.getRealTalkTime()的值赋给前边的变量，否则就是0
			remainTalkTime = cardpack.getTalkTime() > card.getRealTalkTime() ? cardpack
					.getTalkTime() - card.getRealTalkTime()
					: 0;
			pin.append("通话时长：" + remainTalkTime + "分钟\n");
			remainSmsCount = cardpack.getSmsCount() > card.getRealSMSCount() ? cardpack
					.getSmsCount() - card.getRealSMSCount()
					: 0;
			pin.append("短信条数：" + remainTalkTime + "条");
		} else if (pack instanceof NetPackage) {
			// 网虫卡，显示上网流量
			NetPackage cardpack = (NetPackage) pack;
			remainFlow = cardpack.getFlow() > card.getRealFlow() ? cardpack
					.getFlow() - card.getRealFlow() : 0;
			pin.append("上网流量：" + remainFlow / 1024 + "G");
		} else if (pack instanceof SuperPackage) {
			// 超人卡，显示通话时长，上网流量，短信条数
			SuperPackage cardpack = (SuperPackage) pack;
			remainTalkTime = cardpack.getTalkTime() > card.getRealTalkTime() ? cardpack
					.getTalkTime() - card.getRealTalkTime()
					: 0;
			pin.append("通话时长：" + remainTalkTime + "分钟\n");
			remainSmsCount = cardpack.getSmsCount() > card.getRealSMSCount() ? cardpack
					.getSmsCount() - card.getRealSMSCount()
					: 0;
			pin.append("短信条数：" + remainSmsCount + "条\n");
			remainFlow = cardpack.getFlow() > card.getRealFlow() ? cardpack
					.getFlow() - card.getRealFlow() : 0;
			pin.append("上网流量：" + remainFlow / 1024 + "G");
		}
		System.out.println(pin);
	}

	/**
	 * 打印消费记录
	 * 
	 * @param number
	 *            手机号
	 * */
	public void printConsumInfo(String number) {
		Writer writer = null;
		try {
			writer = new FileWriter("F://o流" + number + "消费记录.txt");
			// 将所有的卡的消费记录存进set集合，KeySet()方法将所有的键值存进iterator里，键值就是手机号
			Set<String> numbers = consumInfos.keySet();
			// 使用迭代器遍历手机号（此处相当于一个功能）
			Iterator<String> iterator = numbers.iterator();
			// 用List集合存储指定卡的所有消费记录
			List<ConsumInfo> infos = new ArrayList<ConsumInfo>();
			// 布尔值变量用于指定现有消费列表中（是否存在消费记录）
			boolean isExist = false;
			// 循环查找指定卡的所有消费记录并存进指定消费记录的list集合中
			// hasNext判断是否存在下一个元素，这里指还有下标就继续循环，除非匹配到指定的号码,___如果没有记录则不执行循环
			while (iterator.hasNext()) {
				// next代表指针所指向的元素，用于列表中的元素一个一个与指定号码对比
				if (iterator.next().equals(number)) {
					// 如果号码匹配，就把指定号码的所有消费记录存进infos里
					infos = consumInfos.get(number);
					isExist = true;// 有了消费记录，就需要更改是否拥有消费记录的状态为true
					break;
				}
			}
			// if仅当给定条件为真时才执行语句。如果条件为false，那么if语句体内的语句将被完全忽略。
			if (isExist) {
				StringBuffer pin = new StringBuffer();
				pin.append("您的卡号为：" + number + "\n");
				pin.append("序号\t类型\t数据(通话(条)/上网(MB)/短信(条))\n");
				for (int i = 0; i < infos.size(); i++) {
					ConsumInfo info = infos.get(i);
					pin.append((i + 1) + ".\t" + info.getType() + "\t"
							+ info.getConsumData() + "\n");
				}
				writer.write(pin.toString());
				writer.flush();
				writer.close();
				System.out.println("消费记录打印完毕！");
			} else {
				System.out.println("Sorry，该手机号不存在消费记录，无法打印！");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 指定卡号换套餐
	 * 
	 * @param number
	 *            手机号
	 * @param XPackage
	 *            选择项
	 */
	public void changingPack(String number, int XPackage) {
		MobileCard card = cards.get(number);
		ServicePackage pack = createPack(XPackage);
		// .getClass().getName(),代表Class对象所代表的具体对象的名称
		// 这里判断的是原来服务包的名称与需要更改的服务包名称
		if (card.getSerPackage().getClass().getName()
				.equals(pack.getClass().getName())) {
			System.out.println("对不起，您已经是该套餐用户，无需更换套餐！");
		} else {
			if (card.getMoney() >= pack.getPrice()) {
				card.setMoney(card.getMoney() - pack.getPrice());
				card.setSerPackage(pack);
				// 数据清0
				card.setRealTalkTime(0);
				card.setRealFlow(0);
				card.setRealSMSCount(0);
				// 更换当月消费套餐金额
				card.setConsumAmount(pack.getPrice());
				System.out.println("更换套餐成功！");
				card.showMeg();
			} else {
				System.out.println("Sorry,您的余额不足以支付新套餐本月资费，请充值后在办理更换套餐业务！");
				return;
			}
		}
	}

	/**
	 * 指定卡号办理退网
	 * 
	 * @param number
	 *            手机号
	 */
	public void delCard(String number) {
		if (isExistCard(number)) {
			cards.remove(number);
			System.out.println("卡号" + number + "办理退网成功！");
			System.out.println("谢谢使用^-^");
		} else {
			System.out.println("Sorry，该卡号未注册，不能办退退网！");
		}
	}

	/**
	 * 使用嗖嗖
	 * 
	 * @param number
	 *            当前卡号
	 */
	public void useSoso(String number) {
		MobileCard card = cards.get(number);// 将对应的手机号参数传递给新卡，代表这个手机号
		ServicePackage pack = card.getSerPackage();// 代表手机号的套餐类型
		Random random = new Random();
		int ranNum = 0;
		int temp = 0;// 记录消费数据
		do {
			// 生成随机数用于代表消费类型
			ranNum = random.nextInt(6);
			// list集合存储了所有的消费类型，由于list是有序不唯一的，所以默认将消费记录编号
			// get()将对应的消费记录取出，传给scene，用于当作生成的消费记录
			Scene scene = scenes.get(ranNum);
			// 根据序号判断，生成的消费记录属于那种消费类型，分别为通话(0,1)、短信(2,3)、上网(4,5)
			switch (ranNum) {
			// 通话服务
			case 0:
			case 1:
				// 首先判断，该手机卡的套餐是否支持通话服务
				if (pack instanceof CallService) {
					System.out.println(scene.getDescription());// 展示使用场景
					// 将套餐转为通话，，，，因为话痨接入了通话功能（这样向下转型类似于成为了通话）
					// 方便在以后调用call方法
					CallService callService = (CallService) pack;
					// 获取本次通话的时长
					try {
						temp = callService.call(scene.getData(), card);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// 创建消费记录，将对应的数据同步
					ConsumInfo consumInfo = new ConsumInfo();
					consumInfo.setCardNumber(number);
					consumInfo.setConsumData(temp);
					consumInfo.setType(scene.getType());
					// 本次消费记录存进本卡的消费记录中
					addConsumInfo(number, consumInfo);
					break;
				} else {
					// 如果不支持就重新生成随机数，判断其他场景
					continue;
				}

				// 短信服务
			case 2:
			case 3:
				// 首先判断，该手机卡的套餐是否支持短信服务
				if (pack instanceof SendService) {
					System.out.println(scene.getDescription());// 展示使用场景
					// 将套餐转为短信，，，，因为接入了短信功能（这样向下转型类似于成为了通话）
					// 方便在以后调用send方法
					SendService sendService = (SendService) pack;
					// 获取本次使用的短息数量
					try {
						temp = sendService.send(scene.getData(), card);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// 创建消费记录，将对应的数据同步
					ConsumInfo consumInfo = new ConsumInfo();
					consumInfo.setCardNumber(number);
					consumInfo.setConsumData(temp);
					consumInfo.setType(scene.getType());
					// 本次消费记录存进本卡的消费记录中
					addConsumInfo(number, consumInfo);
					break;
				} else {
					// 如果不支持就重新生成随机数，判断其他场景
					continue;
				}

				// 上网服务
			case 4:
			case 5:
				// 首先判断，该手机卡的套餐是否支持上网服务
				if (pack instanceof NetService) {
					System.out.println(scene.getDescription());// 展示使用场景
					// 将套餐转为上网，，，，因为接入了上网功能（这样向下转型类似于成为了通话）
					// 方便在以后调用netPlay方法
					NetService netService = (NetService) pack;
					// 获取本次上网的流量
					try {
						temp = netService.netPlay(scene.getData(), card);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// 创建消费记录，将对应的数据同步
					ConsumInfo consumInfo = new ConsumInfo();
					consumInfo.setCardNumber(number);
					consumInfo.setConsumData(temp);
					consumInfo.setType(scene.getType());
					// 本次消费记录存进本卡的消费记录中
					addConsumInfo(number, consumInfo);
					break;
				} else {
					// 如果不支持就重新生成随机数，判断其他场景
					continue;
				}
			}
			break;
		} while (true);

	}

	/**
	 * 添加一条指定卡的消费记录
	 * 
	 * @param number
	 *            要添加消费记录的卡
	 * @param info
	 *            要添加的消费记录
	 */
	public void addConsumInfo(String number, ConsumInfo info) {
		Set<String> numbers = consumInfos.keySet();
		Iterator<String> it = numbers.iterator();
		// 一张卡可以有多条消费记录，list就是用来存储指定卡的多条消费记录
		// Arraylist查询快，适合在这，后边的括号，在new 新对象时都会有
		List<ConsumInfo> infos = new ArrayList<ConsumInfo>();
		// 布尔值代表集合中有无消费记录
		boolean isExist = false;
		while (it.hasNext()) {
			// 消费集合中有该卡的消费记录，就找到卡号，添加一条
			if (it.next().equals(number)) {
				infos = consumInfos.get(number);
				infos.add(info);
				isExist = true;
				System.out.println("已添加一条消费记录！");
				break;
			}
		}
		// 如果所有手机号记录消费记录里没有这个手机号的消费记录，就创建一个消费记录并添加进所有手机号记录里
		if (!isExist) {
			infos.add(info);// 将消费记录传给infos
			consumInfos.put(number, infos);// 再将这手机号消费记录添加到总记录里
			System.out.println("不存在此卡的消费记录，已添加一条消费记录。");
		}
	}

	/**
	 * 为指定手机卡充值
	 * 
	 * @param number
	 *            指定充值的卡号
	 * @param money
	 *            充值金额
	 */
	public void chargeMoney(String number, double money) {
		MobileCard card = cards.get(number);
		if (money > 50) {
			card.setMoney(card.getMoney() + money);
			System.out
					.println("充值成功，当前话费余额为" + forMats(card.getMoney()) + "元。");
		} else {
			System.out.println("对不起，最低充值金额为50元！");
			return;
		}

	}

	/**
	 * 显示资费说明
	 */
	public void showDescription() {
		File file = new File("F://I流/套餐资费说明.txt");
		Reader reader = null;
		StringBuffer sb = null;
		System.out.println(file.length());
		// 判断文件是否存在
		if (file.exists()) {
			try {
				reader = new FileReader("F://I流/套餐资费说明.txt");
				// 字符中转站
				char[] content = new char[(int) file.length()];
				sb = new StringBuffer();
				// 将内容读取到中转站
				reader.read(content);
				for (int i = 0; i < file.length(); i++) {
					// 拼接字符串
					sb.append(content);
					reader.read();
				}
				System.out.println(sb);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("文件不存在！");
		}
	}
}
