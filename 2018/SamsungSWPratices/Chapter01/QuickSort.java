package SamsungSWPratices.Chapter01;

public class QuickSort {

	public int[] sort(int[] array, int left, int right) {
		int left_temp = left;
		int right_temp = right; 
		int pivot = array[(left + right)/2];
		
		do {
			// ���ʺ��� ����, pivot���� ū ���� �ε��� ã��
			while(array[left_temp] < pivot)
				left_temp++;
			// �����ʺ��� ����, pivot���� ���� ���� �ε��� ã��
			while(array[right_temp] > pivot)
				right_temp--;
			
			// ���� pivot���� ū ���� pivot�������� ����, pivot���� ���� ���� pivot�������� �����ʿ� �ִٸ� �ڸ��� �ٲ��ֱ�
			if(left_temp <= right_temp) {
				if(array[left_temp] != array[right_temp]) {
					System.out.println("?");
					array[left_temp] = array[left_temp]^array[right_temp];
					array[right_temp] = array[left_temp]^array[right_temp];
					array[left_temp] = array[left_temp]^array[right_temp];
					left_temp++;
					right_temp--;
				}
			}
		}while(left_temp <= right_temp); 
		// left_temp�� right_temp�� ���ٴ� �ǹ̴� pivot��ġ��� �ǹ�
		// pivot��ġ�� ���޽� ����
		
		// left_temp�� right_temp�� �迭�� ���� �������� ���� ��� ����Լ��� �� Ž��
		if(left < right_temp) 
			array = sort(array, left, right_temp);
		if(right > left_temp)
			array = sort(array, left_temp, right);
		
		return array;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input1[] = {485, 241, 454, 325, 452, 685, 498, 890, 281, 121};
		int input2[] = {486, 242, 454, 325, 453, 685, 499, 891, 282, 122};
		int anwer1[] = new int[input1.length];
		int anwer2[] = new int[input2.length];
		QuickSort quickSort = new QuickSort();
		
		anwer1 = quickSort.sort(input1, 0, input1.length-1);
		anwer2 = quickSort.sort(input2, 0, input2.length-1);
		
		for(int i = 0; i< anwer1.length; i++) {
			if(i == anwer1.length-1)
				System.out.println(anwer1[i]);
			else
				System.out.print(anwer1[i] + " ");
		}
		for(int i = 0; i< anwer2.length; i++) {
			if(i == anwer2.length-1)
				System.out.println(anwer2[i]);
			else
				System.out.print(anwer2[i] + " ");
		}
		
	}

}
