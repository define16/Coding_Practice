package sketchbook.hash;

import java.util.ArrayList;
import java.util.Arrays;

public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ex1 ex = new ex1();
    	String[] participant = {"leo", "kiki", "eden","leo"};
    	String[] completion = {"kiki","leo", "eden"};
    	
    	System.out.println(ex.solution1(participant, completion));
	}
	
    public String solution(String[] participant, String[] completion) {
    	String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i = 0; i < participant.length; i++) {
        	if(completion.length == i) {
        		answer = participant[i];
        		break;
        	} else if(completion.length != i &&!participant[i].equals(completion[i])) {
        		answer = participant[i];
        		break;
        	}
        }
    	
        return answer;
    }
    
    // 효율성 테스트 불통과
    public String solution1(String[] participant, String[] completion) {
    	String answer = "";
    	ArrayList<String> list = new ArrayList<String>();
    	for(String c : completion)
    		list.add(c);
    	for(String p : participant) {
    		if(!list.remove(p)) { // 이 부분에서 딜레이가 걸리는 것 같다.
    			answer = p;
    			break;
    		}
    	}
    	
        return answer;
    }

}
