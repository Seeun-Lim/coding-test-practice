import java.util.*;
import java.lang.*;

class Programmers0304 {
    static int nums[], size, maxNum;
    static List<Integer> combis;
    static boolean visited[], primes[];

    public int solution(String numbers) {
        int answer = 0;
        size = numbers.length();

        // numbers를 숫자 집합으로 변환
        nums = new int[size];
        for(int i = 0; i < size; i++){
            nums[i] = numbers.charAt(i) - '0';
        }

        // 함수 조합을 담을 집합
        combis = new ArrayList<>();
        visited = new boolean[size];
        maxNum = 0;
        c(0, 0);

        primes = new boolean[maxNum + 1];
        primes[1] = true;
        for(int i = 2; i <= Math.sqrt(maxNum); i++){
            if(primes[i]) continue;
            int j = 2;
            while(i * j <= maxNum){
                primes[i * j] = true;
                j++;
            }
        }

        for(int i = 0; i < combis.size(); i++){
            if(!primes[combis.get(i)]) answer++;
        }

        return answer;
    }

    static void c(int depth, int n){
        if(n != 0) combis.add(n);
        maxNum = n > maxNum? n : maxNum;

        if(depth == size) return;

        for(int i = 0; i < size; i++){
            int num = n * 10 + nums[i];

            if(!visited[i] && !combis.contains(num) && num != 0){
                visited[i] = true;
                c(depth + 1, num);
                visited[i] = false;
            }
        }
    }

}