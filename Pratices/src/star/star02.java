package star;
/**
- 출력 형태
    **
   ****
  ******
 ********
**********
 ********
  ******
   ****
    **
 
 */
public class star02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 9; i++) {
			// 첫번째 삼각형
			if(i < 5) {
				//공백부분
				for(int j = 4-i; j > 0; j--) {
					System.out.print(" ");
				}
				// *부분
				for (int j = 0; j < (i+1)*2;j++) {
					System.out.print("*");
				}
			// 두번째 역삼각형
			}else {
				//공백부분
				for(int j = 0; j < (i-4);j++) {
					System.out.print(" ");
				}
				// *부분
				for(int j = (10-(i-4)*2); j > 0;j--) {
					System.out.print("*");
				}
			}
			
			System.out.println();
		}
	}

}
