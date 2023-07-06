package org.lanqiao.servler;

public class Demo {
	public static void main(String[] args) {
		int arr[] = { 64, 1, 75, 46, 7 };
		directSelectionSort(arr);
		reverseSort(arr);
	}

	/**
	 * 直接选择排序 ()
	 * */
	public static void directSelectionSort(int[] array) {
		// 作用为指针，指向数组中最大的数
		int index;
		// 创建外层循环，循环次数
		for (int i = 1; i < array.length; i++) {
			// 初始指向第一个数组元素
			index = 0;
			// 这层循环数组内部元素的以此比较，像冒泡一样，每循环一次最后一个值就不需要排序了所以要减去i(排序好的数不参与循环)
			// 注意这里j为1，因为index的初始值是0，j为0的时候if判断（arr[0] < arr[0]）就失去意义
			// j <= arr.length - i 注意是<= arr.length - i
			// i就是数组的最大索引值，若是<就取不到最后的元素值，导致排序结果错误
			for (int j = 1; j <= array.length - i; j++) {
				if (array[index] < array[j]) { // <是升序 >是降序(与冒泡同样)
					index = j;// 交换索引的值
				}
			}
			int temp = array[array.length - i]; // 将参与排序数组的最后一位元素值取出
			array[array.length - i] = array[index];
			array[index] = temp;
		}
		System.out.println("选择排序的结果为：");
		showArray(array);
	}

	/**
	 * 反转排序 (常用于排序好的数据需要反转顺序)
	 * */
	public static void reverseSort(int[] array) {
		System.out.println("\n反转排序数组原有内容：");
		showArray(array);
		int arraylength = array.length;
		// 控制循环次数，为长度的一半，若是偶数就全部依次交互，若是奇数中间的位数不用变(憨憨啊，他一直在中间)
		// so length/2
		for (int i = 0; i < arraylength / 2; i++) {
			// 交换数据将前边的元素值赋给中转变量
			int temp = array[i];
			// 将最后一位的值赋给前边对应的元素，(憨憨又纠结了，arraylength - 1 - i )
			// arraylength - 1得到的是最大索引值，- i 是动态的为了下次循环，不然永远交换的都是最后一位
			// 憨憨，仔细看看循环过程这里进来第一次i的值是0，在运算结束后才会i++
			array[i] = array[arraylength - 1 - i];
			array[arraylength - 1 - i] = temp;
		}
		System.out.println("\n反转排序的结果为：");
		showArray(array);
	}

	/** 展示数据 */
	public static void showArray(int[] array) {
		for (int i : array) {
			System.out.print(i + "   ");
		}
	}
}
