package soSo_Entity;
/**
 * @author 14606
 * @version 1.0
 * */
import soSo_Business_Interface.*;

/**
 * 话痨套餐
 * */
public class TalkPackage extends ServicePackage implements CallService,
		SendService {
	private int talkTime;// 通话时长
	private int smsCount;// 短信条数

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
	 * 展示套餐信息
	 * */
	public void showInfo() {
		System.out.println("话唠套餐：通话时长为" + this.talkTime + "分钟/月，短信条数为"
				+ this.smsCount + "条/月，资费为" + this.price + "元/月。");
	}

	/**
	 * 数据初始化
	 * */
	public TalkPackage() {
		this.talkTime = 500;// 通话时长
		this.smsCount = 30;// 短信条数
		this.price = 58;// 资费
	}

	@Override
	public int call(int minCount, MobileCard card) throws Exception {
		int temp = minCount;
		// 循环用于控制数据的变化（实际通话时长的增加）
		for (int i = 0; i < minCount; i++) {
			// 第一种情况，判断套餐中还有通话时长
			if (this.talkTime - card.getRealTalkTime() >= 1) {
				card.setRealTalkTime(card.getRealTalkTime() + 1);
			} else if (card.getMoney() >= 0.2) {
				// 第二种情况，通话时长没有剩余的情况，使用余额代替通话时长，每分钟0.2元
				card.setRealTalkTime(card.getRealTalkTime() + 1);
				card.setMoney(card.getMoney() - 0.2);
				card.setConsumAmount(card.getConsumAmount() + 0.2);
			} else {
				// 第三种情况，余额不足，通话结束，将通话时长记录，并提示
				temp = i;
				throw new Exception("本次通话已结束~\n通话时长：" + temp + "分");
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
				throw new Exception("本次短信已发送：" + i + "条，您的余额不足，请充值后再使用！");
			}
		}
		return temp;
	}
}
