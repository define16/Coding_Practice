package programmers.Sketchbook.Search;

import java.util.ArrayList;

/**
 * 프로그래머스
 * 코딩테스트 > 완저탐색 > 숫자 야구
 * @author define16
 *
 */
public class BaseballGame {

	public static void main(String[] args) {
		BaseballGame bg = new BaseballGame();
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		int answer = bg.solution(baseball);
		System.out.println(answer);
	}
	
    public int solution(int[][] baseball) {
        int answer = 0;
        String number; // 내가 부른 숫자
        String numberTmp; // 모든 경수의 수
        int strike = 0;  // Strike 개수
        int ball = 0; // ball 개수
        
        // 모든 경우의 수를 저장
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
        	for(int j = 1; j <= 9; j++) {
        		for(int k = 1; k <= 9; k++) {
        			if((i != j) && (i != k) && (j != k)) {
        				arr.add(i*100+j*10+k);
        			}
        		}
        	}
        }
        

        
        for(int i = 0; i < baseball.length; i++) {
        	number = String.valueOf(baseball[i][0]);
        	for(int j = 0; j < arr.size(); j++) {
        		// -1 인 경우 해당사항이 없기때문에 pass
        		if(arr.get(j) == -1) continue;
        		numberTmp = String.valueOf(arr.get(j));
        		for (int k = 0; k < 3; k++) {
        			// 숫자의 위치가 같으면 Strike
        			if(number.charAt(k) == numberTmp.charAt(k)) {
        				strike++;
        			}
        			// 숫자가 포함이 되어 있으면 ball
        			if (numberTmp.contains(String.valueOf(number.charAt(k)))) {
        				ball++;
        			}
        		}
        		ball -= strike; // ball과 strike의 중복 삭제
        		
        		// 결과가 틀린 경우 -1로 값을 대체
        		if(!(baseball[i][1] == strike && baseball[i][2] == ball)) {
        			arr.set(j,-1);
        		}
        		// 연산이 끝나면 초기환
        		strike = 0;
        		ball = 0;
        	}
        }
        
        // 남아있는 값의 개수
        for (int i : arr) {
        	if(i != -1) {
        		answer++;
        	}
        }
        return answer;
    }

}
 