package AlgorithmicProblemSolvingStrategies.first;


public class RockFestival {
    public static void main(String args[]){
        String input = "2\n6 3\n1 2 3 1 2 3\n6 2\n1 2 3 1 2 3";
        String tmp[] = input.split("\n");
        // Test Case 반복
        for(int i = 0; i < Integer.parseInt(tmp[0]) * 2; i+= Integer.parseInt(tmp[0])){
            int day = Integer.parseInt(tmp[1 + i].split(" ")[0]);
            int team =  Integer.parseInt(tmp[1 + i].split(" ")[1]);
            String cost[] = tmp[2 + i].split(" ");
            double answer = 99999.0000000;
            double avg = 0.0;
            for (int a = 0; a < day; a++){
                double count = 0;
                double sum = 0;
                for(int b = a; b < day; b++){
                    sum += Integer.parseInt(cost[b]);
                    count++;
                    if(count >= team){
                        System.out.print(count + ", " + sum + ", ");
                        avg = sum / count;
                        if (answer > avg)
                            answer = avg;
                            System.out.println(answer);
                    }
                }

            }

            System.out.format("answer : %.7f\n",answer);
        }
    }
}
