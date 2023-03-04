import java.util.Arrays;

/**
 * 소수 판별 알고리즘
 * 1. 가장 단순한 판별 알고리즘 : 시간 복잡도  O(N)
 * 2. 에라토스테네스의 체 : 시간 복잡도 O(Nlog(logN))
 */

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrimeNumber(26));
        System.out.println(sieveOfEratosthenes(26));
    }

    /**
     * N이 소수인지 판별하는 가장 간단한 알고리즘
     * @param N : 판별 수
     * @return true(소수일 경우), false(소수가 아닐 경우)
     */
    public static boolean isPrimeNumber(int N){
        for(int i = 2; i < N / 2; i++){
            if(N % i == 0) return false;
        }
        return true;
    }

    /**
     * 에라토스테네스의 체 알고리즘
     * @param N : 판별 수
     * @return true(소수일 경우), false(소수가 아닐 경우)
     */
    public static boolean sieveOfEratosthenes(int N){
        boolean arr[] = new boolean[N + 1];

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if(arr[i]) continue;
            for (int j = 2; j < N + 1; j++) {
                if(j % i == 0) arr[j] = true;
            }
        }

        return !arr[N];
    }
}
