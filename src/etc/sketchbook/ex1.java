package etc.sketchbook;

import java.util.ArrayList;

public class ex1 {
	public static void main(String args[]) {
			int []arr = {};
		  int[] answer = {};
	        ArrayList<Integer> ans = new ArrayList<Integer>();
	        int tmp = -1000;
	        for(int i = 0; i < arr.length; i++){
	            if (tmp ==  arr[i]){
		            continue;
	            }
	            ans.add(arr[i]);
	            tmp = arr[i]; 
	        }
	        answer = new int[ans.size()];
	        for(int i = 0; i < ans.size(); i++) {
	        	answer[i] = ans.get(i);
	        }



	}
}
