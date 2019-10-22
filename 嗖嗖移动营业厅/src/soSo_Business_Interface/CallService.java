package soSo_Business_Interface;
/**
 * @author 14606
 * @version 1.0
 * */
import soSo_Entity.MobileCard;

/**
 * ͨ������
 * */
public interface CallService {
	/**
	 * ͨ��
	 * 
	 * @param minCount
	 *            ͨ��ʱ��
	 * @param card
	 *            ָ���ֻ���
	 * @return minCount ͨ������
	 * @throws Exception
	 *             ͨ���쳣
	 * */
	public int call(int minCount, MobileCard card) throws Exception;
}
