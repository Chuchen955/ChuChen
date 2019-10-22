package soSo_Entity;
/**
 * @author 14606
 * @version 1.0
 * */
import soSo_Business_Interface.*;

/**
 * �����ײ�
 * */
public class TalkPackage extends ServicePackage implements CallService,
		SendService {
	private int talkTime;// ͨ��ʱ��
	private int smsCount;// ��������

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

	/**
	 * չʾ�ײ���Ϣ
	 * */
	public void showInfo() {
		System.out.println("�����ײͣ�ͨ��ʱ��Ϊ" + this.talkTime + "����/�£���������Ϊ"
				+ this.smsCount + "��/�£��ʷ�Ϊ" + this.price + "Ԫ/�¡�");
	}

	/**
	 * ���ݳ�ʼ��
	 * */
	public TalkPackage() {
		this.talkTime = 500;// ͨ��ʱ��
		this.smsCount = 30;// ��������
		this.price = 58;// �ʷ�
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
}
