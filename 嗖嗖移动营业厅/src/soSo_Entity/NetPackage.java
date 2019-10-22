package soSo_Entity;
/**
 * @author 14606
 * @version 1.0
 * */
import soSo_Business_Interface.NetService;

/**
 * �����ײ�
 * */
public class NetPackage extends ServicePackage implements NetService {
	private int flow;// ��������
	private double price;// �ʷ�

	public NetPackage() {
		this.flow = 3 * 1024;// ��������,����1024������M���������ʾ��ʱ���ڳ���1024������G
		this.price = 68;// �ʷ�
	}

	public int getFlow() {
		return flow;
	}

	public void setFlow(int flow) {
		this.flow = flow;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * չʾ�ײ���Ϣ
	 * */
	public void showInfo() {
		System.out.println("�����ײͣ���������" + this.flow / 1024 + "GB/�£����ʷ�Ϊ"
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
}
