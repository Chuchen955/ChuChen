package soSo_Entity;
/**
 * @author 14606
 * @version 1.0
 * */
import soSo_Business_Interface.NetService;

/**
 * 网虫套餐
 * */
public class NetPackage extends ServicePackage implements NetService {
	private int flow;// 上网流量
	private double price;// 资费

	public NetPackage() {
		this.flow = 3 * 1024;// 上网流量,乘以1024，就是M数，后边显示的时候在除以1024，就是G
		this.price = 68;// 资费
	}

	public int getFlow() {
		return flow;
	}

	public void setFlow(int flow) {
		this.flow = flow;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 展示套餐信息
	 * */
	public void showInfo() {
		System.out.println("网虫套餐：上网流量" + this.flow / 1024 + "GB/月，月资费为"
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
}
