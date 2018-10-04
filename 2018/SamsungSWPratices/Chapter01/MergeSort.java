package SamsungSWPratices.Chapter01;

public class MergeSort {
	int[] tempArray;
	
	public MergeSort(int size) {
		tempArray = new int[size];
	}
	
	public int[] getTempArray() {
		return tempArray;
	}
	// ���� �Լ�
	public int[] merge_division(int[] array, int left, int right) {
		int middle; // �߰�
		
		if (left < right) {
			middle = (left + right) / 2;
			array= merge_division(array, left, middle);
			array= merge_division(array, middle+1, right);
			array =merge(array, left, middle, right);			
		}
		
		return array;
	}
	
	// ���� �Լ�
	public int[] merge(int[] array, int left, int middle ,int right) {
		int left_, middle_, idx;

		left_ = left;
		middle_ = middle+1;
		idx = left; // tempArray�� �ε���
		
		// left���� middle������ ��ϰ� middle+1���� right������ ����� ���κ��ϴ� �κ�
		while(left_ <= middle && middle_ <= right) {
			if(array[left_] <= array[middle_]) {
				tempArray[idx] = array[left_];
				System.out.println(" tempArray[idx] : " + tempArray[idx]);
				System.out.println(" array[left_] : " + array[left_]);
				left_++;				
			}else {
				tempArray[idx] = array[middle_];
				middle_++;
			}
			idx++;
		}
		// left ����� ���� �� ó���Ǿ��µ� right ����� index�� ���� �������� ��� 
		// right index�� ���������� ��� result�� ����
		if(left_ > middle) {
			for(int i = middle_; i <= right; i++) {
				tempArray[idx] = array[i];
				idx++;
			}
		}else {
			for(int i = middle_; i <= right; i++) {
				tempArray[idx] = array[i];
				idx++;
			}
		}
		for(int i = 0; i < array.length;i++) {
			array[i] = tempArray[i];
			System.out.println(array[i]);
		}
		return array;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 16;
		int[] input = {100, 99, 98, 97, 94, 95,96, 93, 92, 91, 90, 89, 88, 87, 86, 85};
		int[] answer = new int[num];
		MergeSort mergeSort = new MergeSort(num);
		
		answer = mergeSort.merge_division(input, 0, num-1);
		
		for(int i = 0; i < input.length;i++) {
			System.out.println(answer[i]);

		}
		
	}

}

