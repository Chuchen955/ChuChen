package soSo_Entity;
/**
 * @author 14606
 * @version 1.0
 * */
import soSo_Business_Interface.*;

/**
 * �����ײ�
 * */
public class SuperPackage extends ServicePackage implements CallService,
		SendService, NetService {
	private int talkTime;// ͨ��ʱ��
	private int smsCount;// ��������
	private int flow;// ��������

	public int getTalkTime() {
		return talkTime;
	}

	public void setTalkTime(int talkTime) {
		this.talkTime = talkTime;
	}

	public int getSmsCount() {
		return smsCount;
	}

	public void setSmsCount(int smsCount) {
		this.smsCount = smsCount;
	}

	public int getFlow() {
		return flow;
	}

	public void setFlow(int flow) {
		this.flow = flow;
	}

	public SuperPackage() {
		this.talkTime = 200;// ͨ��ʱ��
		this.smsCount = 50;// ��������
		this.flow = 1 * 1024;// ��������,����1024������M���������ʾ��ʱ���ڳ���1024������G
		this.price = 78;// �ʷ�
	}

	/**
	 * չʾ�ײ���Ϣ
	 * */
	public void showInfo() {
		System.out.println("�����ײͣ�ͨ��ʱ��Ϊ" + this.talkTime + "����/�£���������Ϊ"
				+ this.smsCount + "��/�£���������Ϊ" + this.flow / 1024 + "GB/�£��ʷ�Ϊ"
				+ this.price + "Ԫ/�¡�");
	}

	@Override
	public int netPlay(int flow, MobileCard card) throws Exception {
		int temp = flow;
		for (int i = 0; i < flow; i++) {
			if (this.flow - card.getRealFlow() >= 1) {
				card.setRealFlow(card.getRealFlow() + 1);
			} else if (card.getMoney() >= 0.1) {
				card.setRealFlow(card.getRealFlow() + 1);
				card.setMoney(card.getMoney() - 0.1);
				card.setConsumAmount(card.getConsumAmount() + 0.1);
			} else {
				temp = i;
				throw new Exception("������ʹ������" + i + "MB,�������㣬���ֵ����ʹ�ã�");
			}
		}
		return temp;
	}

	@Override
	public int send(int count, MobileCard card) throws Exception {
		int temp = count;
		for (int i = 0; i < count; i++) {
			if (this.smsCount - card.getRealSMSCount() >= 1) {
				card.setRealSMSCount(card.getRealSMSCount() + 1);
			} else if (card.getMoney() >= 0.1) {
				card.setRealSMSCount(card.getRealSMSCount() + 1);
				card.setMoney(card.getMoney() - 0.1);
				card.setConsumAmount(card.getConsumAmount() + 0.1);
			} else {
				temp = i;
				throw new Exception("���ζ����ѷ��ͣ�" + i + "�����������㣬���ֵ����ʹ�ã�");
			}
		}
		return temp;
	}

	@Override
	public int call(int minCount, MobileCard card) throws Exception {
		int temp = minCount;
		// ѭ�����ڿ������ݵı仯��ʵ��ͨ��ʱ�������ӣ�
		for (int i = 0; i < minCount; i++) {
			// ��һ��������ж��ײ��л���ͨ��ʱ��
			if (this.talkTime - card.getRealTalkTime() >= 1) {
				card.setRealTalkTime(card.getRealTalkTime() + 1);
			} else if (card.getMoney() >= 0.2) {
				// �ڶ��������ͨ��ʱ��û��ʣ��������ʹ��������ͨ��ʱ����ÿ����0.2Ԫ
				card.setRealTalkTime(card.getRealTalkTime() + 1);
				card.setMoney(card.getMoney() - 0.2);
				card.setConsumAmount(card.getConsumAmount() + 0.2);
			} else {
				// ��������������㣬ͨ����������ͨ��ʱ����¼������ʾ
				temp = i;
				throw new Exception("����ͨ���ѽ���~\nͨ��ʱ����" + temp + "��");
			}
		}
		return temp;
	}
}
