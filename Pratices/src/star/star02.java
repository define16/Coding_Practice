package star;
/**
- ��� ����
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
			// ù��° �ﰢ��
			if(i < 5) {
				//����κ�
				for(int j = 4-i; j > 0; j--) {
					System.out.print(" ");
				}
				// *�κ�
				for (int j = 0; j < (i+1)*2;j++) {
					System.out.print("*");
				}
			// �ι�° ���ﰢ��
			}else {
				//����κ�
				for(int j = 0; j < (i-4);j++) {
					System.out.print(" ");
				}
				// *�κ�
				for(int j = (10-(i-4)*2); j > 0;j--) {
					System.out.print("*");
				}
			}
			
			System.out.println();
		}
	}

}
