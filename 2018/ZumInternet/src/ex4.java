import java.util.HashSet;

public class ex4 {
	
	public int count(String S) {
		int cnt = 0;
    	HashSet<Character> each_char = new HashSet<Character>();
    	HashSet<Character> overlab_char = new HashSet<Character>();
		for(int i=0; i < S.length(); i++) {
			if(each_char.contains(S.charAt(i))) {
				overlab_char.add(S.charAt(i));
			}
			each_char.add(S.charAt(i));
		}

		cnt = each_char.size() - overlab_char.size();

		return cnt;
	}
	
	public int uni(String S) {
		int cnt = 0;
		String temp = "";
    	for(int i = 0; i < S.length(); i++){
    		temp = "";
    		for(int j = 0; j < i+1; j++) {
    			temp += S.charAt(j);
    		}
    		cnt += count(temp);
    	}
    	
		return cnt;
	}
	
    public int solution(String S) {
        // write your code in Java SE 8
    	int answer = 0;
    	String temp;
    	for(int i = 0; i < S.length(); i++) {
    		temp = "";
    		for(int j = i ; j < S.length(); j++) {
    			temp += S.charAt(j);

    		}
    		answer += uni(temp);
    	}

    	
    	
    	return answer;
    }
    public static void main(String[] args) {
    	ex4 e = new ex4();
    	String S = "ACAX";
    	System.out.println(e.solution(S));
    	
    }
}
