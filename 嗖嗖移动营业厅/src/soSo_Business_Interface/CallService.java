package soSo_Business_Interface;
/**
 * @author 14606
 * @version 1.0
 * */
import soSo_Entity.MobileCard;

/**
 * 通话服务
 * */
public interface CallService {
	/**
	 * 通话
	 * 
	 * @param minCount
	 *            通话时长
	 * @param card
	 *            指定手机号
	 * @return minCount 通话数据
	 * @throws Exception
	 *             通话异常
	 * */
	public int call(int minCount, MobileCard card) throws Exception;
}
