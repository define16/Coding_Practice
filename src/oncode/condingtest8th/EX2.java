package oncode.condingtest8th;

public class EX2 {
	
	
    public String solution(String[] masks){
    	String answer = "";
    	// 비트마스크판이 2개 미만일때
    	if(masks.length < 2) {
    		answer = "NO";
    	}

    	// 비트마스크판이 3개 이상일때
    	else {
	    	for(int i = 0; i < masks[0].length(); i++) {
	    		for(int j = 1; j < masks.length; j++) {	  
	    			
	    			// 출력문
	    			if(j == 1) {
		    			System.out.print(masks[0].split("")[i] + " " + masks[j].split("")[i] + " ");
	    			}else {
	    				System.out.print(masks[j].split("")[i] + " ");
	    			}
	    			
					if(masks[0].split("")[i].equals(masks[j].split("")[i])) answer = "NO";
					else {
						answer = "YES";
						break; // 하나라도 다르면 Stop
		    		}
			
	    		}
	    		System.out.println();
	    		// 한 비트라도 알수 없을때
	    		if(answer.equals("NO")) {
	    			break;
	    		}
	    		else {
                    if(masks[0].length() > 1){
			    		for(int j = 0; j < masks.length-1; j++) {
			    			if(Integer.parseInt(masks[j].split("")[i]) != Integer.parseInt(masks[j+1].split("")[i])) {
			    				answer = "NO";
			    			}else {
			    				answer = "YES";
			    				break;
			    			}
			    		}
                    }
                    else if(masks[0].length() == 1 && masks.length == 2){
                    	if(masks[0].equals("0") && masks[1].equals("1")) {
                    		answer = "NO";
                    	}else if(masks[1].equals("0") && masks[0].equals("1")) {
                    		answer = "NO";
                    	}else {
		    				answer = "YES";
                    	}
                    }
	    		}
	    	}

    	}

    	
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] masks = {"110","011","000"};
//		String[] masks = {"101001011","011011010","010110010","111010100","111111111"};
		EX2 ex = new EX2();
		System.out.println(ex.solution(masks));
	}

}
