package soSo_Business_Interface;
/**
 * @author 14606
 * @version 1.0
 * */
import soSo_Entity.MobileCard;

/**
 * ��������
 * */
public interface NetService {
	/**
	 * ����
	 * 
	 * @param flow
	 *            ʹ������
	 * @param card
	 *            ָ���ֻ���
	 * @return flow ʹ������
	 * @throws Exception
	 *             ����ʹ�ô���
	 * */
	public int netPlay(int flow, MobileCard card) throws Exception;
}
