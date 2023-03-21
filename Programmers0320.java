import java.util.Arrays;

public class Programmers0320 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 2, 4, 7, 8}));
    }
    public static int solution(int[] citations){
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0, size = citations.length; i < size; i++) {
            if(citations[i] == citations.length - i){
                answer = citations[i];
                break;
            }
        }

        return answer;
    }
}
