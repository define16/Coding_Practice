package etc.sketchbook.hash;

import java.util.HashMap;

import javax.naming.CommunicationException;

public class ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ex3 ex = new ex3();
		String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"}, 
				{"green_turban", "headgear"}};
		System.out.println(ex.solution(clothes));
	}
    public int solution(String[][] clothes) {
        int answer = 0;
        String kind = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < clothes.length; i++) {
        	if(map.containsKey(clothes[i][1])) {
        		int tmp = map.get(clothes[i][1]) + 1;
        		System.out.println("tmp : " + tmp);
        		map.put(clothes[i][1], tmp);
        	}else {
        		map.put(clothes[i][1], 1);
        	}
        }
        System.out.println(map.keySet());
        System.out.println(map.values());
        
        
        return answer;
    }
    

}
