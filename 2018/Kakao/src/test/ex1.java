package test;

public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		int m = 500000;
        int answer = 0;
        ex1 ex = new ex1();
        
        answer = ex.solution(n,m);

        System.out.println("´ä : " + answer);
	}
	
	
	   public int solution(int n, int m) {
	        int answer = 0;
	        String num_s = "";
	        
	        for(int i=n; i<=m;i++){
	            num_s = String.valueOf(i);

	            if(num_s.length() == 1){
	                answer++;

	            }
	            else if(num_s.length() % 2 == 0) {
	            	String temp1 = num_s.substring(0,num_s.length()/2);
	            	String temp2 = num_s.substring(num_s.length()/2,num_s.length());
	            	temp2 = reverse(temp2);
	            	

	            	 if(temp1.equals(temp2)) {
	 	                answer++;
	                }
	            }else {
	            	String temp1 = num_s.substring(0,num_s.length()/2);
	            	String temp2 = num_s.substring(num_s.length()/2+1,num_s.length());
	            	temp2 = reverse(temp2);
	            	

	            	 if(temp1.equals(temp2)) {
		 	                answer++;
		                }
	                }
	            }
	           
	        return answer;
	    }

	  public String reverse(String str) {
       	StringBuffer sb = new StringBuffer(str);
       	sb.reverse();
       	str = sb.toString();
       	return str;
	   }
}
