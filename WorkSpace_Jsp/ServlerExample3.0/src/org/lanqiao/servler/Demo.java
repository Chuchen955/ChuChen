package org.lanqiao.servler;

public class Demo {
	public static void main(String[] args) {
		int arr[] = { 64, 1, 75, 46, 7 };
		directSelectionSort(arr);
		reverseSort(arr);
	}

	/**
	 * ֱ��ѡ������ ()
	 * */
	public static void directSelectionSort(int[] array) {
		// ����Ϊָ�룬ָ��������������
		int index;
		// �������ѭ����ѭ������
		for (int i = 1; i < array.length; i++) {
			// ��ʼָ���һ������Ԫ��
			index = 0;
			// ���ѭ�������ڲ�Ԫ�ص��Դ˱Ƚϣ���ð��һ����ÿѭ��һ�����һ��ֵ�Ͳ���Ҫ����������Ҫ��ȥi(����õ���������ѭ��)
			// ע������jΪ1����Ϊindex�ĳ�ʼֵ��0��jΪ0��ʱ��if�жϣ�arr[0] < arr[0]����ʧȥ����
			// j <= arr.length - i ע����<= arr.length - i
			// i����������������ֵ������<��ȡ��������Ԫ��ֵ����������������
			for (int j = 1; j <= array.length - i; j++) {
				if (array[index] < array[j]) { // <������ >�ǽ���(��ð��ͬ��)
					index = j;// ����������ֵ
				}
			}
			int temp = array[array.length - i]; // ������������������һλԪ��ֵȡ��
			array[array.length - i] = array[index];
			array[index] = temp;
		}
		System.out.println("ѡ������Ľ��Ϊ��");
		showArray(array);
	}

	/**
	 * ��ת���� (����������õ�������Ҫ��ת˳��)
	 * */
	public static void reverseSort(int[] array) {
		System.out.println("\n��ת��������ԭ�����ݣ�");
		showArray(array);
		int arraylength = array.length;
		// ����ѭ��������Ϊ���ȵ�һ�룬����ż����ȫ�����ν��������������м��λ�����ñ�(����������һֱ���м�)
		// so length/2
		for (int i = 0; i < arraylength / 2; i++) {
			// �������ݽ�ǰ�ߵ�Ԫ��ֵ������ת����
			int temp = array[i];
			// �����һλ��ֵ����ǰ�߶�Ӧ��Ԫ�أ�(�����־����ˣ�arraylength - 1 - i )
			// arraylength - 1�õ������������ֵ��- i �Ƕ�̬��Ϊ���´�ѭ������Ȼ��Զ�����Ķ������һλ
			// ��������ϸ����ѭ���������������һ��i��ֵ��0�������������Ż�i++
			array[i] = array[arraylength - 1 - i];
			array[arraylength - 1 - i] = temp;
		}
		System.out.println("\n��ת����Ľ��Ϊ��");
		showArray(array);
	}

	/** չʾ���� */
	public static void showArray(int[] array) {
		for (int i : array) {
			System.out.print(i + "   ");
		}
	}
}
