package ZumInternet_2018;

import java.util.Arrays;

public class Demo {

    public int solution(int[] A) {
        // write your code in Java SE 8
    	int answer = 0;
    	int min = 0;
    	Arrays.sort(A);
    	for(int i=0; i< A.length-1; i++) {
    		if(A[i] >= min) {
    			if((A[i+1]-A[i]) > 1) {
    				answer = A[i]+1;
	    			break;
    			}
    			min = A[i+1];
    		}
    		if(i == A.length-2)
    			answer = min+1;
    	}
    	
    	
    	
    	return answer;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo e1 = new Demo();
//		int A[] = {1, 3, 6, 4, 1, 2};
		int A[] = {1, 2, 3};
//		int A[] = {-1, -3};
		System.out.println(e1.solution(A));
	}

}
