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
 * ������
 * */
public class CardUtil {
	// ע���¿������ţ�������
	Map<String, MobileCard> cards = new HashMap<String, MobileCard>();
	// ���Ѽ�¼�����ţ��ÿ����е����Ѽ�¼��
	Map<String, List<ConsumInfo>> consumInfos = new HashMap<String, List<ConsumInfo>>();
	List<soSo_Entity.Scene> scenes = new ArrayList<soSo_Entity.Scene>();// ʹ�ó���
	Scanner input = new Scanner(System.in);
	TalkPackage talkPackage = new TalkPackage();
	NetPackage netPackage = new NetPackage();
	SuperPackage superPackage = new SuperPackage();

	/**
	 * ���ݳ�ʼ�� �ֻ��� �û��� ���� �ײ����� ������ ���
	 * */
	public void init() {
		MobileCard mobileCard1 = new MobileCard("17629756743", "�ų���", "123456",
				superPackage, 100, 1000);
		MobileCard mobileCard2 = new MobileCard("18739096729", "��С��", "123456",
				netPackage, 100, 20);
		MobileCard mobileCard3 = new MobileCard("13939909475", "������", "123456",
				talkPackage, 100, 20);
		MobileCard mobileCard4 = new MobileCard("13233934137", "������", "123456",
				talkPackage, 100, 20);
		cards.put("17629756743", mobileCard1);
		cards.put("18739096729", mobileCard2);
		cards.put("13939909475", mobileCard3);
		cards.put("13233934137", mobileCard4);
	}

	/**
	 * ʹ�ó�����ʼ�� ���� ���� ʹ�ó���
	 */
	public void initScene() {
		scenes.add(new soSo_Entity.Scene("ͨ��", 60,
				"��ͻ���̸�������Բ�����һ��Сʱ��ȥ�ˣ�ͨ��ʱ��ʹ��60���ӡ�"));
		scenes.add(new soSo_Entity.Scene("ͨ��", 3, "ԼŮ����һ��Է���ͨ��ʱ��ʹ��3���ӡ�"));
		scenes.add(new soSo_Entity.Scene("����", 2, "���п����ˣ�����2�����š�"));
		scenes.add(new soSo_Entity.Scene("����", 10, "Ů���Ѳ�ڣ��㱨���������10�����š�"));
		scenes.add(new soSo_Entity.Scene("����", 1, "�ճ�����Ѷ1G"));
		scenes.add(new soSo_Entity.Scene("����", 2, "��ĩ׷������2G��"));
	}

	/**
	 * �Ƿ���ڴ˿��û�
	 * 
	 * @param number
	 *            �ֻ���
	 * @param passWord
	 *            ����
	 * @return �����ڣ�false ���ڣ�true
	 */
	public boolean isExistCard(String number, String passWord) {
		Set<String> numbers = cards.keySet();
		// һ��������ֻ�ܱ���һ��
		// hasNext,�Ƿ������һ��ָ��
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
	 * ����ָ�������Ƿ���ע��
	 * 
	 * @param number
	 *            �ֻ���
	 * @return δע�᣺false ��ע�᣺true
	 */
	public boolean isExistCard(String number) {
		Set<String> numbers = cards.keySet();
		// ����Forû���±꣬ԭ���ǣ���numbers�е�ֵ���δ��ݸ�numbeR
		// ����numbeR����Ҫ�жϵ��ֻ��Ž����ж�
		for (String numbeR : numbers) {
			if (numbeR.equals(number)) {
				return true;
			}
		}
		return false;

	}

	/**
	 * �������ţ���139��ͷ 11λ��
	 * 
	 * @return ���ɵ�����ֻ�����
	 */
	public String createNumber() {
		String[] cardNumbers = new String[9];// ���ڴ�����ɵĵ绰����
		System.out.println("******��ѡ��Ŀ���******");
		for (int i = 0; i < 9; i++) {// 9����ѭ���ŴΣ������Ÿ��������
			String number = "139";// ����绰������139��ͷ
			Random random = new Random();// ����random�����������
			for (int j = 0; j < 8; j++) {
				// ����0~9 ��������ַ������ͻ�ֱ��׷�ӵ���ߣ���ʼ��139����ѭ��8�Σ�����һ��11λ���ĵ绰��
				number += random.nextInt(9);
			}
			cardNumbers[i] = number;
			System.out.print((i + 1) + "." + number + "   ");// ���һ���绰����
			// ���ڿ�����������һ��
			if ((i + 1) % 3 == 0) {
				System.out.println("");
			}
		}
		System.out.println("��ѡ�񿨺ţ�����1-9����ţ���");
		int Xcard = input.nextInt();
		// �������飬Ѱ����ѡ���������Ӧ�Ŀ���
		for (int i = 0; i < cardNumbers.length; i++) {
			if (i == Xcard - 1) {// ����-1�������ϱ�չʾ��ʱ�򣬻��������±����1������Ϊ�˶�ӦҲ�ü�ȥ 1��
				return cardNumbers[i];
			}
		}
		return "";

	}

	/**
	 * ѡ���ײͣ������ײ͡������ײ͡������ײͣ�
	 * 
	 * @param Xpackage
	 *            ѡ����
	 * @return serPackage �����ײ�����
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
	 * ����¿�����������
	 * 
	 * @param card
	 *            �¿�
	 */
	public void addCard(MobileCard card) {
		cards.put(card.getCardNumber(), card);
		System.out.println("ע��ɹ���");
		card.showMeg();
	}

	/**
	 * ���ݸ�ʽ��
	 * 
	 * @param number
	 *            �ֻ���
	 * @return number �ֻ���
	 * */
	public static String forMats(double number) {
		DecimalFormat formats = new DecimalFormat("#.0");
		return formats.format(number);

	}

	/**
	 * ��ѯָ�������������굥
	 * 
	 * @param number
	 *            �ֻ���
	 */
	public void showAmountDetail(String number) {
		MobileCard card;
		StringBuffer sbfr = new StringBuffer();
		card = cards.get(number);
		sbfr.append("���Ŀ��ţ�" + card.getCardNumber() + "\n�����˵���\n");
		sbfr.append("�ײ��ʷѣ�" + card.getSerPackage().getPrice() + "Ԫ\n");
		sbfr.append("�ϼƣ�" + forMats(card.getConsumAmount()) + "Ԫ\n");
		sbfr.append("�˻���" + forMats(card.getMoney()) + "Ԫ\n");
		System.out.println(sbfr);
	}

	/**
	 * ��ѯָ�����ײ�����
	 * 
	 * @param number
	 *            �ֻ���
	 */
	public void showRemainDetail(String number) {
		MobileCard card;
		int remainTalkTime;// ͨ��
		int remainSmsCount;// ����
		int remainFlow;// ����
		StringBuffer pin = new StringBuffer();
		card = cards.get(number);
		pin.append("���Ŀ����ǣ�" + card.getCardNumber() + "\n�ײ���ʣ�ࣺ\n");
		ServicePackage pack = card.getSerPackage();
		if (pack instanceof TalkPackage) {
			// ���뿨����ѯ�ײ���ʣ���ͨ��ʱ���Ͷ�������
			TalkPackage cardpack = (TalkPackage) pack;
			// ���cardPack.getTalkTime() >card.getRealTalkTime()����
			// �Ͱ�cardPack.getTalkTime()-card.getRealTalkTime()��ֵ����ǰ�ߵı������������0
			remainTalkTime = cardpack.getTalkTime() > card.getRealTalkTime() ? cardpack
					.getTalkTime() - card.getRealTalkTime()
					: 0;
			pin.append("ͨ��ʱ����" + remainTalkTime + "����\n");
			remainSmsCount = cardpack.getSmsCount() > card.getRealSMSCount() ? cardpack
					.getSmsCount() - card.getRealSMSCount()
					: 0;
			pin.append("����������" + remainTalkTime + "��");
		} else if (pack instanceof NetPackage) {
			// ���濨����ʾ��������
			NetPackage cardpack = (NetPackage) pack;
			remainFlow = cardpack.getFlow() > card.getRealFlow() ? cardpack
					.getFlow() - card.getRealFlow() : 0;
			pin.append("����������" + remainFlow / 1024 + "G");
		} else if (pack instanceof SuperPackage) {
			// ���˿�����ʾͨ��ʱ����������������������
			SuperPackage cardpack = (SuperPackage) pack;
			remainTalkTime = cardpack.getTalkTime() > card.getRealTalkTime() ? cardpack
					.getTalkTime() - card.getRealTalkTime()
					: 0;
			pin.append("ͨ��ʱ����" + remainTalkTime + "����\n");
			remainSmsCount = cardpack.getSmsCount() > card.getRealSMSCount() ? cardpack
					.getSmsCount() - card.getRealSMSCount()
					: 0;
			pin.append("����������" + remainSmsCount + "��\n");
			remainFlow = cardpack.getFlow() > card.getRealFlow() ? cardpack
					.getFlow() - card.getRealFlow() : 0;
			pin.append("����������" + remainFlow / 1024 + "G");
		}
		System.out.println(pin);
	}

	/**
	 * ��ӡ���Ѽ�¼
	 * 
	 * @param number
	 *            �ֻ���
	 * */
	public void printConsumInfo(String number) {
		Writer writer = null;
		try {
			writer = new FileWriter("F://o��" + number + "���Ѽ�¼.txt");
			// �����еĿ������Ѽ�¼���set���ϣ�KeySet()���������еļ�ֵ���iterator���ֵ�����ֻ���
			Set<String> numbers = consumInfos.keySet();
			// ʹ�õ����������ֻ��ţ��˴��൱��һ�����ܣ�
			Iterator<String> iterator = numbers.iterator();
			// ��List���ϴ洢ָ�������������Ѽ�¼
			List<ConsumInfo> infos = new ArrayList<ConsumInfo>();
			// ����ֵ��������ָ�����������б��У��Ƿ�������Ѽ�¼��
			boolean isExist = false;
			// ѭ������ָ�������������Ѽ�¼�����ָ�����Ѽ�¼��list������
			// hasNext�ж��Ƿ������һ��Ԫ�أ�����ָ�����±�ͼ���ѭ��������ƥ�䵽ָ���ĺ���,___���û�м�¼��ִ��ѭ��
			while (iterator.hasNext()) {
				// next����ָ����ָ���Ԫ�أ������б��е�Ԫ��һ��һ����ָ������Ա�
				if (iterator.next().equals(number)) {
					// �������ƥ�䣬�Ͱ�ָ��������������Ѽ�¼���infos��
					infos = consumInfos.get(number);
					isExist = true;// �������Ѽ�¼������Ҫ�����Ƿ�ӵ�����Ѽ�¼��״̬Ϊtrue
					break;
				}
			}
			// if������������Ϊ��ʱ��ִ����䡣�������Ϊfalse����ôif������ڵ���佫����ȫ���ԡ�
			if (isExist) {
				StringBuffer pin = new StringBuffer();
				pin.append("���Ŀ���Ϊ��" + number + "\n");
				pin.append("���\t����\t����(ͨ��(��)/����(MB)/����(��))\n");
				for (int i = 0; i < infos.size(); i++) {
					ConsumInfo info = infos.get(i);
					pin.append((i + 1) + ".\t" + info.getType() + "\t"
							+ info.getConsumData() + "\n");
				}
				writer.write(pin.toString());
				writer.flush();
				writer.close();
				System.out.println("���Ѽ�¼��ӡ��ϣ�");
			} else {
				System.out.println("Sorry�����ֻ��Ų��������Ѽ�¼���޷���ӡ��");
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
	 * ָ�����Ż��ײ�
	 * 
	 * @param number
	 *            �ֻ���
	 * @param XPackage
	 *            ѡ����
	 */
	public void changingPack(String number, int XPackage) {
		MobileCard card = cards.get(number);
		ServicePackage pack = createPack(XPackage);
		// .getClass().getName(),����Class����������ľ�����������
		// �����жϵ���ԭ�����������������Ҫ���ĵķ��������
		if (card.getSerPackage().getClass().getName()
				.equals(pack.getClass().getName())) {
			System.out.println("�Բ������Ѿ��Ǹ��ײ��û�����������ײͣ�");
		} else {
			if (card.getMoney() >= pack.getPrice()) {
				card.setMoney(card.getMoney() - pack.getPrice());
				card.setSerPackage(pack);
				// ������0
				card.setRealTalkTime(0);
				card.setRealFlow(0);
				card.setRealSMSCount(0);
				// �������������ײͽ��
				card.setConsumAmount(pack.getPrice());
				System.out.println("�����ײͳɹ���");
				card.showMeg();
			} else {
				System.out.println("Sorry,����������֧�����ײͱ����ʷѣ����ֵ���ڰ�������ײ�ҵ��");
				return;
			}
		}
	}

	/**
	 * ָ�����Ű�������
	 * 
	 * @param number
	 *            �ֻ���
	 */
	public void delCard(String number) {
		if (isExistCard(number)) {
			cards.remove(number);
			System.out.println("����" + number + "���������ɹ���");
			System.out.println("ллʹ��^-^");
		} else {
			System.out.println("Sorry���ÿ���δע�ᣬ���ܰ���������");
		}
	}

	/**
	 * ʹ����
	 * 
	 * @param number
	 *            ��ǰ����
	 */
	public void useSoso(String number) {
		MobileCard card = cards.get(number);// ����Ӧ���ֻ��Ų������ݸ��¿�����������ֻ���
		ServicePackage pack = card.getSerPackage();// �����ֻ��ŵ��ײ�����
		Random random = new Random();
		int ranNum = 0;
		int temp = 0;// ��¼��������
		do {
			// ������������ڴ�����������
			ranNum = random.nextInt(6);
			// list���ϴ洢�����е��������ͣ�����list������Ψһ�ģ�����Ĭ�Ͻ����Ѽ�¼���
			// get()����Ӧ�����Ѽ�¼ȡ��������scene�����ڵ������ɵ����Ѽ�¼
			Scene scene = scenes.get(ranNum);
			// ��������жϣ����ɵ����Ѽ�¼���������������ͣ��ֱ�Ϊͨ��(0,1)������(2,3)������(4,5)
			switch (ranNum) {
			// ͨ������
			case 0:
			case 1:
				// �����жϣ����ֻ������ײ��Ƿ�֧��ͨ������
				if (pack instanceof CallService) {
					System.out.println(scene.getDescription());// չʾʹ�ó���
					// ���ײ�תΪͨ������������Ϊ���������ͨ�����ܣ���������ת�������ڳ�Ϊ��ͨ����
					// �������Ժ����call����
					CallService callService = (CallService) pack;
					// ��ȡ����ͨ����ʱ��
					try {
						temp = callService.call(scene.getData(), card);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// �������Ѽ�¼������Ӧ������ͬ��
					ConsumInfo consumInfo = new ConsumInfo();
					consumInfo.setCardNumber(number);
					consumInfo.setConsumData(temp);
					consumInfo.setType(scene.getType());
					// �������Ѽ�¼������������Ѽ�¼��
					addConsumInfo(number, consumInfo);
					break;
				} else {
					// �����֧�־�����������������ж���������
					continue;
				}

				// ���ŷ���
			case 2:
			case 3:
				// �����жϣ����ֻ������ײ��Ƿ�֧�ֶ��ŷ���
				if (pack instanceof SendService) {
					System.out.println(scene.getDescription());// չʾʹ�ó���
					// ���ײ�תΪ���ţ���������Ϊ�����˶��Ź��ܣ���������ת�������ڳ�Ϊ��ͨ����
					// �������Ժ����send����
					SendService sendService = (SendService) pack;
					// ��ȡ����ʹ�õĶ�Ϣ����
					try {
						temp = sendService.send(scene.getData(), card);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// �������Ѽ�¼������Ӧ������ͬ��
					ConsumInfo consumInfo = new ConsumInfo();
					consumInfo.setCardNumber(number);
					consumInfo.setConsumData(temp);
					consumInfo.setType(scene.getType());
					// �������Ѽ�¼������������Ѽ�¼��
					addConsumInfo(number, consumInfo);
					break;
				} else {
					// �����֧�־�����������������ж���������
					continue;
				}

				// ��������
			case 4:
			case 5:
				// �����жϣ����ֻ������ײ��Ƿ�֧����������
				if (pack instanceof NetService) {
					System.out.println(scene.getDescription());// չʾʹ�ó���
					// ���ײ�תΪ��������������Ϊ�������������ܣ���������ת�������ڳ�Ϊ��ͨ����
					// �������Ժ����netPlay����
					NetService netService = (NetService) pack;
					// ��ȡ��������������
					try {
						temp = netService.netPlay(scene.getData(), card);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// �������Ѽ�¼������Ӧ������ͬ��
					ConsumInfo consumInfo = new ConsumInfo();
					consumInfo.setCardNumber(number);
					consumInfo.setConsumData(temp);
					consumInfo.setType(scene.getType());
					// �������Ѽ�¼������������Ѽ�¼��
					addConsumInfo(number, consumInfo);
					break;
				} else {
					// �����֧�־�����������������ж���������
					continue;
				}
			}
			break;
		} while (true);

	}

	/**
	 * ���һ��ָ���������Ѽ�¼
	 * 
	 * @param number
	 *            Ҫ������Ѽ�¼�Ŀ�
	 * @param info
	 *            Ҫ��ӵ����Ѽ�¼
	 */
	public void addConsumInfo(String number, ConsumInfo info) {
		Set<String> numbers = consumInfos.keySet();
		Iterator<String> it = numbers.iterator();
		// һ�ſ������ж������Ѽ�¼��list���������洢ָ�����Ķ������Ѽ�¼
		// Arraylist��ѯ�죬�ʺ����⣬��ߵ����ţ���new �¶���ʱ������
		List<ConsumInfo> infos = new ArrayList<ConsumInfo>();
		// ����ֵ���������������Ѽ�¼
		boolean isExist = false;
		while (it.hasNext()) {
			// ���Ѽ������иÿ������Ѽ�¼�����ҵ����ţ����һ��
			if (it.next().equals(number)) {
				infos = consumInfos.get(number);
				infos.add(info);
				isExist = true;
				System.out.println("�����һ�����Ѽ�¼��");
				break;
			}
		}
		// ��������ֻ��ż�¼���Ѽ�¼��û������ֻ��ŵ����Ѽ�¼���ʹ���һ�����Ѽ�¼����ӽ������ֻ��ż�¼��
		if (!isExist) {
			infos.add(info);// �����Ѽ�¼����infos
			consumInfos.put(number, infos);// �ٽ����ֻ������Ѽ�¼��ӵ��ܼ�¼��
			System.out.println("�����ڴ˿������Ѽ�¼�������һ�����Ѽ�¼��");
		}
	}

	/**
	 * Ϊָ���ֻ�����ֵ
	 * 
	 * @param number
	 *            ָ����ֵ�Ŀ���
	 * @param money
	 *            ��ֵ���
	 */
	public void chargeMoney(String number, double money) {
		MobileCard card = cards.get(number);
		if (money > 50) {
			card.setMoney(card.getMoney() + money);
			System.out
					.println("��ֵ�ɹ�����ǰ�������Ϊ" + forMats(card.getMoney()) + "Ԫ��");
		} else {
			System.out.println("�Բ�����ͳ�ֵ���Ϊ50Ԫ��");
			return;
		}

	}

	/**
	 * ��ʾ�ʷ�˵��
	 */
	public void showDescription() {
		File file = new File("F://I��/�ײ��ʷ�˵��.txt");
		Reader reader = null;
		StringBuffer sb = null;
		System.out.println(file.length());
		// �ж��ļ��Ƿ����
		if (file.exists()) {
			try {
				reader = new FileReader("F://I��/�ײ��ʷ�˵��.txt");
				// �ַ���תվ
				char[] content = new char[(int) file.length()];
				sb = new StringBuffer();
				// �����ݶ�ȡ����תվ
				reader.read(content);
				for (int i = 0; i < file.length(); i++) {
					// ƴ���ַ���
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
			System.out.println("�ļ������ڣ�");
		}
	}
}
