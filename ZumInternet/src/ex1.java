
public class ex1 {
	private int cnt;
	
	public ex1(){
		cnt = 0;
	}
	public int isSquare(int number) {
		int temp = (int) Math.sqrt((double)number + 0.5);
		if(temp*temp == number){
			cnt++;
			number = isSquare(temp);
		}
	
		return number;

	}
	
    public int solution(int A, int B) {
        // write your code in Java SE 8
    	int answer = 0;
    	int max = 0;
    	
    	for(int i = B; i >= A; i-- ) {
    		cnt = 0;
    		int temp = isSquare(i);
    		if(max < cnt){
    			max = cnt;
    			answer = temp;
    		}
    		
    	}
    	
    	
    	return answer;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
