package CondingTest_8th;

public class EX1 {
	
    public int solution(String[] swaps){
        int pos_ball = 1;
        for(int i = 0; i < swaps.length; i++) {
        	if(pos_ball == Integer.parseInt(swaps[i].split("-")[0])) {
        		pos_ball = Integer.parseInt(swaps[i].split("-")[1]);
        	}else if(pos_ball == Integer.parseInt(swaps[i].split("-")[1])) {
        		pos_ball = Integer.parseInt(swaps[i].split("-")[0]);
        	}
        }
        
        return pos_ball;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] swaps = {"3-1","2-3","3-1","3-2"};
		EX1 ex = new EX1();
		System.out.println(ex.solution(swaps));
	}

}
