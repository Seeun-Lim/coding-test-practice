// 타겟넘버, Lv2
public class Programmers0119 {
    static int answer;
    public static int solution(int[] numbers, int target) {
        answer = 0;
        DFS(numbers, target, 0, 0);
        return answer;
    }

    public static void DFS(int[] numbers, int target, int total, int depth){
        if(depth == numbers.length){
            if(total == target){
                answer += 1;
            }
            return;
        }

        DFS(numbers, target, total + numbers[depth], depth + 1);
        DFS(numbers, target, total - numbers[depth], depth + 1);
    }
}
