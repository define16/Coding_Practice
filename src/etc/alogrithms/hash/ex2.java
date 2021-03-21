package etc.sketchbook.hash;

import java.util.Arrays;

import javax.naming.CommunicationException;

public class ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] pb= {"119", "97674223", "1195524421"};
		String[] pb= {"119", "1197674223", "1195524421"};
		ex2 ex = new ex2();
		System.out.println(ex.solution(pb));
	}
	
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        String check = "";
        for (int i = 0; i < phone_book.length; i++) {
        	check = phone_book[i];
	        for(int j = 0; j<phone_book.length; j++) {
	        	if(i == j) {
	        		continue;
	        	}
	        	if(phone_book[j].contains(check)) {
	        		return false;
	        	}
	        }
        }
        return answer;
    }

}
