package programmers.kakao.pratices;
import java.util.ArrayList;

public class Friends4Block {
	
    int cnt;

    public int getCnt() {
	    return cnt;
    }

    public void setCnt(int cnt) {
	    this.cnt = cnt;
    }
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        ArrayList<String> board_pos = removeBlock(m,n,board);
      
        while(getCnt() != 0){
         
        }
      
      return answer;
  }
    
    public ArrayList<String> removeBlock(int m, int n, String[] board){
        int check = 0;
        ArrayList<String> board_pos = new ArrayList<>();
        for (int i = 0; i < m-1; i++){
            for (int j = 0; j < n-1; j++){
				if ((board[i].charAt(j) != ' ') && (board[i].charAt(j) == board[i].charAt(j+1)) && (board[i].charAt(j) == board[i + 1].charAt(j)) && (board[i].charAt(j) == board[i + 1].charAt(j+1))) {
                    board_pos.add(i + "," + j);
                    board_pos.add((i+1) + "," + j);
                    board_pos.add(i + "," + (j+1));
                    board_pos.add((i+1) + "," + (j+1));
                    cnt++;
				}
            }
        }
        setCnt(cnt);
        return board_pos;
    }

    public String[] resetBlock(int m, int n, String[] board, ArrayList<String> board_pos){
    	for(int i = 0; i < board_pos.size(); i++) {
    		String[] temp = board_pos.get(i).split(",");
    		System.out.println(temp[0] + "  " + temp[1]);
//    		board[Integer.parseInt(temp[0])].charAt(Integer.parseInt(temp[1])) = ' ';
    		
    		
    	}
    	
    	
    	return board;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
