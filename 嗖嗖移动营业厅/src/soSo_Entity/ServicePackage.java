package soSo_Entity;
/**
 * @author 14606
 * @version 1.0
 * */

/**
 * �ײ�����
 * */
public abstract class ServicePackage {
	protected double price; // �ײ����ʷ�(Ԫ)

	/**
	 * չʾ�ײ���Ϣ
	 * */
	public abstract void showInfo();

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
