package soSo_Entity;
/**
 * @author 14606
 * @version 1.0
 * */

/**
 * 套餐类型
 * */
public abstract class ServicePackage {
	protected double price; // 套餐月资费(元)

	/**
	 * 展示套餐信息
	 * */
	public abstract void showInfo();

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
