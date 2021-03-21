package etc.star;

/**
- 출력 형태
**********
 ********
  ******
   ****
    **
 
 */
public class star01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 5; i++) {
			// 공백 부분
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < (10 - i*2);j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
