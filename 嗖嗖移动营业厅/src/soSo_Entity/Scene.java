package soSo_Entity;
/**
 * @author 14606
 * @version 1.0
 * */

/**
 * 使用场景
 * */
public class Scene {
	private String type;// 类型
	private int data;// 数据
	private String description;// 使用场景说明

	public String getType() {
		return type;
	}

	public Scene() {
	}

	/**
	 * 使用场景参数更新
	 * 
	 * @param type
	 *            类型
	 * @param data
	 *            数据
	 * @param description
	 *            使用场景说明
	 * */
	public Scene(String type, int data, String description) {
		this.type = type;
		this.data = data;
		this.description = description;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
