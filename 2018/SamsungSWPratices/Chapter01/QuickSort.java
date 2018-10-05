package SamsungSWPratices.Chapter01;

public class QuickSort {

	public int[] sort(int[] array, int left, int right) {
		int left_temp = left;
		int right_temp = right; 
		int pivot = array[(left + right)/2];
		
		do {
			// 왼쪽부터 시작, pivot보다 큰 값의 인덱스 찾기
			while(array[left_temp] < pivot)
				left_temp++;
			// 오른쪽부터 시작, pivot보다 작은 값의 인덱스 찾기
			while(array[right_temp] > pivot)
				right_temp--;
			
			// 만약 pivot보다 큰 값이 pivot기준으로 왼쪽, pivot보다 작은 값이 pivot기준으로 오른쪽에 있다면 자리를 바꿔주기
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
		// left_temp와 right_temp가 같다는 의미는 pivot위치라는 의미
		// pivot위치에 도달시 종료
		
		// left_temp와 right_temp가 배열의 끝에 도달하지 못할 경우 재귀함수로 재 탐색
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
