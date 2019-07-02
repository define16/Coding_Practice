import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ex2 {

    public String solution(String S) {
        // write your code in Java SE 8
    	String answer = "";
    	HashSet<String> cityName = new HashSet<String>();
    	TreeMap<String,String> treeMap = new TreeMap<String,String>();
    	HashMap<String,Integer> map = new HashMap<String,Integer>();
    	String files[] = S.split("\n");
    	
    	String fileNames[] = new String[files.length];
    	String cityNames[] = new String[files.length];
    	String fileDates[] = new String[files.length];
    	
    	for(int i=0; i < files.length; i++) {
    		int temp = 0;
    		String files_element[] = files[i].split(", ");
    		
    		treeMap.put(files_element[2].trim(),files_element[1].trim());
        	cityName.add(files_element[1].trim());
        	fileNames[i] = files_element[0].trim();
        	cityNames[i] = files_element[1].trim();
        	fileDates[i] = files_element[2].trim();


    	}
    	    	
    	ArrayList cityName_list = new ArrayList(cityName);

    	for(int i=0; i < cityName_list.size(); i++) {
//    		System.out.println(cityName_list.get(i));
    		String temp_cityName = cityName_list.get(i).toString();
        	Iterator it = treeMap.entrySet().iterator();
        	int index = 1;
        	String value_name = "";

        	while(it.hasNext()) {
        		Map.Entry e = (Entry) it.next();
        		value_name = e.getValue().toString();

        		if(temp_cityName.equals(value_name)){
    	        	for(int k=0; k < files.length; k++) {
    	        		if(cityNames[k].equals(e.getValue()) && fileDates[k].equals(e.getKey())) {
    	        			String[] temp_file = fileNames[k].split("\\.");
    	        			String tempName = "";
    	        			if(index < 10) {
    	        				tempName = cityNames[k] + "0" + String.valueOf(index);

    	        			}
    	        			else 
    	        				tempName = cityNames[k] + String.valueOf(index);
    	        			
    	        			index++;

    	        			fileNames[k] = tempName + "." +temp_file[1];
    	        		}
    	        	}
            		
        		}

        	}
//        	System.out.println(index);
        	map.put(temp_cityName,index);
    	}
    	
    	// 10보다 작은 빈도수를 갖는 도시 이름 찾기
    	ArrayList small_name = new ArrayList<String>();
    	Iterator it = map.entrySet().iterator();
    	while(it.hasNext()) {
    		Map.Entry e = (Entry) it.next();
//    		System.out.println(e.getKey() + " " + e.getValue());
    		if(Integer.parseInt(e.getValue().toString()) < 10) {
    			small_name.add(e.getKey().toString());
    		}
    	}


    	for(int i = 0; i < fileNames.length; i++) {
    		for(int j = 0; j < small_name.size(); j++){
    			String temp[] = fileNames[i].split("\\.");
    			
    			if(temp[0].contains(String.valueOf(small_name.get(j)))){
    				fileNames[i] = fileNames[i].replace("0", "");
    				break;

    			}
    			
    		

    		}
    		answer += fileNames[i];
    		if(i != fileNames.length-1)
    			answer+="\n";
    		
    	}
    	
    	return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "photo.jpg, Warsaw, 2013-09-05 14:08:15\r\n" + 
				"john.png, London, 2015-06-20 15:13:22\r\n" + 
				"myFriends.png, Warsaw, 2013-09-05 14:07:13\r\n" + 
				"Eiffel.jpg, Paris, 2015-07-23 08:03:02\r\n" + 
				"pisatower.jpg, Paris, 2015-07-22 23:59:59\r\n" + 
				"BOB.jpg, London, 2015-08-05 00:02:03\r\n" + 
				"notredame.png, Paris, 2015-09-01 12:00:00\r\n" + 
				"me.jpg, Warsaw, 2013-09-06 15:40:22\r\n" + 
				"a.png, Warsaw, 2016-02-13 13:33:50\r\n" + 
				"b.jpg, Warsaw, 2016-01-02 15:12:22\r\n" + 
				"c.jpg, Warsaw, 2016-01-02 14:34:30\r\n" + 
				"d.jpg, Warsaw, 2016-01-02 15:15:01\r\n" + 
				"e.png, Warsaw, 2016-01-02 09:49:09\r\n" + 
				"f.png, Warsaw, 2016-01-02 10:55:32\r\n" + 
				"g.jpg, Warsaw, 2016-02-29 22:13:11";
		
		ex2 e2 = new ex2();
		System.out.println(e2.solution(S));
	}

}
