import java.util.ArrayList;

public class ex3 {
	ArrayList<ArrayList<Integer>> answer_list = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> each = new ArrayList<Integer>();


	public void union(int[] A, int[] B, int index, boolean[] flag) {
		if (A.length == index) {
			return;
		}

		if (A[index] < A[index + 1] && B[index] > A[index + 1] && flag[index + 1]) {
			flag[index + 1] = false;
			each.add(index + 1);
			union(A, B, index + 1, flag);
		} else if (A[index] < B[index + 1] && B[index] > B[index + 1] && flag[index + 1]) {
			union(A, B, index + 1, flag);
			each.add(index + 1);
		}

	}

	public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
    	int answer = 0;
    	boolean flag[] = new boolean[A.length];
    	
    	for(int i = 0; i < A.length-1; i++) {
    		union(A,B,i , flag);

    	}

    	
    	return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ex3 e = new ex3();
		int[] A = { 1, 12, 42, 70, 36, -4, 43, 15 };
		int[] B = { 5, 15, 44, 72, 36, 2, 69, 24 };

		System.out.println(e.solution(A, B));

	}

}
