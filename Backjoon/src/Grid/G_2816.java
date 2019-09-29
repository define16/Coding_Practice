package Grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G_2816 {
	private String channels[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		G_2816 ex = new G_2816(); 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
		int channel_cnt = Integer.parseInt(bf.readLine().trim());
		ex.channels = new String[channel_cnt];
		String answer = "";
		for(int i = 0; i < channel_cnt; i++) {
			ex.channels[i] = bf.readLine().trim();
		}
		
		answer = ex.channeling(0, answer);
		
		System.out.println(answer);
	}
	
	public String channeling(int idx, String answer) {
		// 마지막 index에 오거나 KBS1, KBS2 가 첫번째 두번째 왔을때
		if(idx == channels.length || channels[0].equalsIgnoreCase("KBS1") && channels[1].equalsIgnoreCase("KBS2")) {
			return answer;
		}
		
		if(channels[idx].equalsIgnoreCase("KBS1")) {
			if(idx == 0) { // 첫 번째 왔을때
				answer += "1"; // KBS2 탐색
				answer = channeling(idx+1, answer);
			}else {
				answer += "4";
				swap(idx-1,idx);
				answer = channeling(idx-1, answer);
			}
		}else if(channels[idx].equalsIgnoreCase("KBS2")) {
			if(idx == 1) { // 두 번째 위치에 온 경우
				answer += "1"; // KBS1 탐색
				answer = channeling(idx+1, answer);
			}else if (idx == 0){ // 첫 번째로 온 경우
				answer += "3";
				swap(idx,idx+1);
				answer = channeling(idx+1, answer);
			}else { // KBS2를 위로 올림
				answer += "4";
				swap(idx-1,idx); 
				answer = channeling(idx-1, answer);
			}
		}else if(channels[idx+1].equalsIgnoreCase("KBS1")) {
			answer += "3";
			swap(idx, idx+1);
			if(idx > 0) { // 포인터를 위로 올림
				answer += "2";
				answer = channeling(idx, answer);
			}else {
				answer = channeling(idx+1, answer);
			}
			
		}else if(channels[idx+1].equalsIgnoreCase("KBS2")) {
			answer += "3";
			swap(idx, idx+1);
			if(idx > 1) { // 포인터를 위로 올림
				answer += "2";
				answer = channeling(idx, answer);
			}else {
				answer = channeling(idx+1, answer);
			}
		}else {
			answer += "1"; // KBS1, KBS2 탐색
			answer = channeling(idx+1, answer);
		}
		
		return answer;
	}
	
	public void swap(int i, int j) {
		String tmp = channels[i];
		channels[i] = channels[j];
		channels[j] = tmp;
	}
	
	

}
