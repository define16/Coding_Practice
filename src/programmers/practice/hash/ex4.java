package programmers.Sketchbook.Hash;

import java.util.*;

class SolutionHash {

    public static void main(String[] args) {
//        String[] genres = {"classic", "pop", "classic", "classic", "pop2", "kpop", "kpop", "jpop", "kpop", "kpop", "kpop", "jpop", "jpop"};
        String[] genres = {"classic", "pop", "classic1", "classic2", "classic", "pop"};
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500, 700,200, 7, 100, 50, 1, 7, 7};
        int[] plays = {7, 7, 7, 7,8,7};
//        int[] plays = {500, 600, 150, 800, 2500};
        SolutionHash s = new SolutionHash();
        int[] anwser = s.solution(genres, plays);
        System.out.println("정답");
        for(int a: anwser )
            System.out.println(a);
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = null;
        int maxSongCount = 2; // 2곡씩만 넣는다.
        ArrayList<Integer> answer_temp = new ArrayList<Integer>();
        HashMap<String, Integer> genreCounts = new HashMap<String, Integer>();  // 장르, 재생횟수
        HashMap<String, TreeMap<Integer, ArrayList<Integer>>> playsList = new HashMap<String, TreeMap<Integer, ArrayList<Integer>>>(); // key : 장르, value : {plays : index}
        TreeMap<Integer, ArrayList<Integer>> playRecord = null; // {plays : index}

        for(int i = 0; i < genres.length; i++){
            // 장르 계산
           if(genreCounts.containsKey(genres[i])) {
               int playTime = genreCounts.get(genres[i]);
               genreCounts.put(genres[i], playTime + plays[i]);
           } else {
               genreCounts.put(genres[i], plays[i]);
           }


            // 장르별 플레이 수 계산
            int playTimeMark = plays[i] * -1;
            if(playsList.containsKey(genres[i])) {
                TreeMap<Integer, ArrayList<Integer>> playRecordTemp = playsList.get(genres[i]);
                ArrayList<Integer> idxList = playRecordTemp.get(playTimeMark) == null ? new ArrayList<Integer>() : playRecordTemp.get(playTimeMark) ;
                if (idxList.size() == 2){
                    continue;
                }
                idxList.add(i);
                playRecordTemp.put(playTimeMark , idxList);
                playsList.put(genres[i], playRecordTemp);
            } else {
                TreeMap<Integer, ArrayList<Integer>> playRecordTemp = new TreeMap<Integer, ArrayList<Integer>>();
                ArrayList<Integer> idxList = new ArrayList<Integer>();
                idxList.add(i);
                playRecordTemp.put(playTimeMark, idxList);
                playsList.put(genres[i], playRecordTemp);
            }
        }
        // genreCounts를 value 기준으로 내림차순으로 정렬
        List<Map.Entry<String, Integer>> genreCountsEntries = new ArrayList<Map.Entry<String, Integer>>(genreCounts.entrySet());
        Collections.sort(genreCountsEntries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        for(Map.Entry<String, Integer> genreCount : genreCountsEntries) {
            playRecord = playsList.get(genreCount.getKey());
            Object[] keyList = playRecord.keySet().toArray();
            int count = 0;
            for (int i=0; i < keyList.length; i++){  // 장르별
                if (count >= maxSongCount){
                    break;
                }
                for (int idx: playRecord.get(keyList[i])){  // 노래별
                    if (count >= maxSongCount){
                        break;
                    }
                    answer_temp.add(idx);
                    count++;
                }

            }
        }

        // Arraylist -> Array
        int idx = 0;
        answer = new int[answer_temp.size()];  // 장르별 2개씩
        for(int ans: answer_temp){
            answer[idx] = ans;
            idx++;
        }
        return answer;
    }

}