package soSo_Business_Interface;
/**
 * @author 14606
 * @version 1.0
 * */
import soSo_Entity.MobileCard;

/**
 * ���ŷ���
 * */
public interface SendService {
	/**
	 * ����
	 * 
	 * @param count
	 *            ʹ������
	 * @param card
	 *            ָ���ֻ���
	 * @return count ʹ������
	 * @throws Exception
	 *             �����쳣
	 * */
	public int send(int count, MobileCard card) throws Exception;
}
