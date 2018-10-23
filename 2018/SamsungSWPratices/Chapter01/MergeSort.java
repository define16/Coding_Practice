package SamsungSWPratices.Chapter01;

public class MergeSort {
	int[] tempArray;

	public MergeSort(int size) {
		tempArray = new int[size];
	}

	public int[] getTempArray() {
		return tempArray;
	}

	// 분할 함수
	public int[] merge_division(int[] array, int left, int right) {
		int middle; // 중간

		if (left < right) {
			middle = (left + right) / 2;
			array = merge_division(array, left, middle);
			array = merge_division(array, middle+1, right);
			array = merge(array, left, middle, right);
		}

		return array;
	}

	// 병합 함수
	public int[] merge(int[] array, int left, int middle ,int right) {
		int left_, middle_, idx;

		left_ = left;
		middle_ = middle+1;
		idx = left; // tempArray의 인덱스

		// left부터 middle까지의 블록과 middle+1부터 right까지의 블록을 서로비교하는 부분
		while(left_ <= middle && middle_ <= right) {
			if(array[left_] <= array[middle_]) {
				tempArray[idx] = array[left_];
				left_++;
			}else {
				tempArray[idx] = array[middle_];
				middle_++;
			}
			idx++;
		}

		// left 블록의 값은 다 처리되었는데 right 블록의 index가 아직 남아있을 경우
		// right index를 순차적으로 결과 result에 복사
		if(left_ > middle) {
			for(int i = middle_; i <= right; i++) {
				tempArray[idx] = array[i];
				idx++;
			}
		}else {
			for(int i = left; i <= middle; i++) {
				tempArray[idx] = array[i];
				idx++;
			}
		}

		for(int i = left; i <= right; i++)
			array[i] = tempArray[i];

		return array;
	}

	//한글테스트
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 16;
		int[] input = {100, 99, 98, 97, 94, 95,96, 93, 92, 91, 90, 89, 88, 87, 86, 85};
		int[] answer = new int[num];
		MergeSort mergeSort = new MergeSort(num);

		answer = mergeSort.merge_division(input, 0, num-1);

		for(int i = 0; i < num;i++) {

			if (i == num-1) {
				System.out.print(answer[i]);
			}else {
				System.out.print(answer[i] + " ");
			}
		}


	}

}
