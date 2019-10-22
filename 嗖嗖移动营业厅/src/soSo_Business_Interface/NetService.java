package soSo_Business_Interface;
/**
 * @author 14606
 * @version 1.0
 * */
import soSo_Entity.MobileCard;

/**
 * 上网服务
 * */
public interface NetService {
	/**
	 * 上网
	 * 
	 * @param flow
	 *            使用流量
	 * @param card
	 *            指定手机号
	 * @return flow 使用数据
	 * @throws Exception
	 *             网络使用错误
	 * */
	public int netPlay(int flow, MobileCard card) throws Exception;
}
