package soSo_Entity;
/**
 * @author 14606
 * @version 1.0
 * */

/**
 * ���Ѽ�¼
 * */
public class ConsumInfo {
	private String cardNumber;// ����
	private String type;// ��������
	private int consumData;// ��������

	public ConsumInfo() {
	}

	/**
	 * ���Ѽ�¼����ͬ��
	 * 
	 * @param cardNumber
	 *            ����
	 * @param type
	 *            ��������
	 * @param consumData
	 *            ��������
	 * */
	public ConsumInfo(String cardNumber, String type, int consumData) {
		super();
		this.cardNumber = cardNumber;
		this.type = type;
		this.consumData = consumData;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getConsumData() {
		return consumData;
	}

	public void setConsumData(int consumData) {
		this.consumData = consumData;
	}

}
