package soSo_Business_Interface;
/**
 * @author 14606
 * @version 1.0
 * */
import soSo_Entity.MobileCard;

/**
 * 短信服务
 * */
public interface SendService {
	/**
	 * 短信
	 * 
	 * @param count
	 *            使用流量
	 * @param card
	 *            指定手机号
	 * @return count 使用数据
	 * @throws Exception
	 *             短信异常
	 * */
	public int send(int count, MobileCard card) throws Exception;
}
