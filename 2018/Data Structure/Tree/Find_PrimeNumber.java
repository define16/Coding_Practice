package Tree;

import java.util.HashSet;
import java.util.Set;

public class Find_PrimeNumber {
	  static Set<Integer> set = new HashSet<>(); // 중복원소 제거
	  
	    public int solution(String numbers) {
	        int answer = 0;
	        char[] nums = new char[numbers.length()];
	        for(int i = 0; i < nums.length; i++) {
	            nums[i] = numbers.charAt(i);
	        }
	        int n = numbers.length();
	        for(int i = 1; i < (1 << n); i++) {
	            char[] temp = new char[7];
	            boolean[] chk = new boolean[7];
	            int k = 0;
	            for(int j = 0; j < n; j++) {
	                if((i & (1 << j)) > 0) {
	                    temp[k++] = nums[j];
	                }
	            }
	            answer += solve(temp, chk, k, 0, "");
	        }

	        return answer;
	    }
	    
	    static int solve(char[] temp, boolean[] chk, int k, int start, String number) {
	        if(start == k) {
	            int num = Integer.parseInt(number);
	            if(!set.contains(num)) {
	                if(isPrime(num)) {
	                    set.add(num);
	                    return 1;
	                }
	            }
	            return 0;
	        }
	        int result = 0;
	        for(int i = 0; i < k; i++) {
	            if(!chk[i]) {
	                chk[i] = true;
	                result += solve(temp, chk, k, start + 1, number + temp[i]);
	                chk[i] = false;
	            }
	        }
	        return result;
	    }
	    static boolean isPrime(int n) {
	        if(n <= 1) {
	            return false;
	        }
	        for(int i = 2; i * i <= n; i++) {
	            if(n % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	public void main(String args[]) {
		
		
	}
}
