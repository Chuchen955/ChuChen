package soSo_Entity;
/**
 * @author 14606
 * @version 1.0
 * */
import soSo_Business_Interface.*;

/**
 * 超人套餐
 * */
public class SuperPackage extends ServicePackage implements CallService,
		SendService, NetService {
	private int talkTime;// 通话时长
	private int smsCount;// 短信条数
	private int flow;// 上网流量

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

	public int getFlow() {
		return flow;
	}

	public void setFlow(int flow) {
		this.flow = flow;
	}

	public SuperPackage() {
		this.talkTime = 200;// 通话时长
		this.smsCount = 50;// 短信条数
		this.flow = 1 * 1024;// 上网流量,乘以1024，就是M数，后边显示的时候在除以1024，就是G
		this.price = 78;// 资费
	}

	/**
	 * 展示套餐信息
	 * */
	public void showInfo() {
		System.out.println("超人套餐：通话时长为" + this.talkTime + "分钟/月，短信条数为"
				+ this.smsCount + "条/月，上网流量为" + this.flow / 1024 + "GB/月，资费为"
				+ this.price + "元/月。");
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
				throw new Exception("本次已使用流量" + i + "MB,您的余额不足，请充值后再使用！");
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
}
