package sketchbook.hash;

import java.util.HashMap;
import java.util.Map;

public class ex3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ex3 ex = new ex3();
        String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}};
        System.out.println(ex.solution(clothes));
    }


    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < clothes.length; i++) {
            if(map.containsKey(clothes[i][1])) {
                int tmp = map.get(clothes[i][1]) + 1;
                map.put(clothes[i][1], tmp);
            }else {
                map.put(clothes[i][1], 1);
            }
        }
        /*
            여러 그룹이 있을때 각 그룹당 한개씩 중복 없이 모든 부분집합의 개수 구하시오.
            1.각 그룹의 개수 + 1 (N = n+1, M = m+1)
            2. 각 그룹를 곱한다. (r = N*M)
            3. 곱한 값에서 -1 을 한다. (answer = r-1)
         */
        for (Map.Entry<String, Integer> e : map.entrySet()){
            answer *= (e.getValue() + 1);
        }
        answer--;


        return answer;
    }


}
