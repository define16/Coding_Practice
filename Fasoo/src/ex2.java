
public class ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ex2 ex = new ex2();
		int data[] = {4,9,5,8};
		int s1=2,s2=3,s3=3;
		int answer =ex.solution(data,s1,s2,s3);
		System.out.println(answer);
	}
	public int solution(int[] monster, int S1, int S2, int S3) {
		int answer = -1;
		int total = S1*S2*S3;
		int count =0;
		
		for(int c = 0; c < monster.length; c++) {
			//if((S1+S2+S3+1) < monster[c]) continue;		
			for(int i = 1; i<= S1; i++) {
				if(i >= monster[c]) continue;	
				
				for(int j = 1; j<= S2; j++) {
					if((i+j) >= monster[c]) continue;	
					
					
					for(int k = 1; k<=S3; k++) {
						if((i+j+k+1) == monster[c]) {
							count++;	
							
							System.out.println(i+" " + j + " " + k);
						}
					}
					
					
				}
				
				
				
			}
		}
		
		
		
		
		System.out.println("aa : " + count + " " + total);
		answer = (int) (((double)count / (double)total) * 1000);
		return answer;
	}
}