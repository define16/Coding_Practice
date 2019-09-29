package Floyd_Warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class FW_2606 {
	private int network[][];
	private int computer_count;
	private HashSet<Integer> connected_computer = new HashSet<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		FW_2606 ex = new FW_2606();
		int answer = 0;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
		ex.computer_count = Integer.parseInt(bf.readLine().trim());
		int computer_set_count = Integer.parseInt(bf.readLine().trim());
		ex.network = new int[ex.computer_count][ex.computer_count]; // 그래프 그리기
		for(int i = 0; i < computer_set_count; i++) {
			String tmp = bf.readLine();
			int a = Integer.parseInt(tmp.split(" ")[0]);
			int b = Integer.parseInt(tmp.split(" ")[1]);
			ex.network[a-1][b-1] = 1;
			ex.network[b-1][a-1] = 1;
		}

		ex.search(0); // 탐색
		
		answer = ex.connected_computer.size() - 1; // 1번 컴퓨터는 제외
		System.out.println(answer);	
	}
	
	public void search(int x) {
		for(int i = 0 ; i < computer_count; i++) {
			if (network[x][i] == 1 ) { // 네트워크가 이어져 있고, 처음 오는 곳이라면 
				network[x][i] = 0; // 이미 추가된 컴퓨터는 제외한다.
				network[i][x] = 0; // 이미 추가된 컴퓨터는 제외한다.
				connected_computer.add(x);
				connected_computer.add(i);
				search(i);
			}
		}
		
	}
}