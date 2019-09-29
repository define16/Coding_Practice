package Test_2018;
import java.util.Arrays;

public class ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub]
		
		int no = 100;
		int[] works = {5,6,7,2,478,65,84,132,84,65,24,35,9,5,24,4,35,45,345,98,48,6,5,54,6,5,84,6,98,89};
		
		ex2 ex = new ex2();

        int result = ex.solution(no, works);
        
        System.out.println("답 : " + result);
	}

    public int solution(int no, int[] works) {
        int result = 0;
        Arrays.sort(works);

        for(int j = works.length-1; j > -1; j-- ) {
            System.out.println("전 : "  + works[j]);
            if(works[j] == 0) {
            	continue;
            }
        	works[j] = works[j] - 1;
        	no--;
        	System.out.println("후 : "  +works[j]);
        	System.out.println(no);
        	if(no == 0) {
        		break;
        	}else if(j == 0 && no != 0) {
        		j = works.length;
        	}else if(works[j] == works[works.length/2]) {
        		j = works.length;
        	}
        }
        
        for(int i = 0; i< works.length; i++) {
        	System.out.println("aa : " + works[i]);
        	result += (works[i]*works[i]);
        }
        return result;
    }
    
}
