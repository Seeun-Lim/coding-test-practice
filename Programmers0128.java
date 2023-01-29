import java.util.Arrays;

public class Programmers0128 {
    static boolean visited[];
    static String result[], answer[];

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}, {"SFO", "ATL"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "JFK"}, {"JFK", "ICN"}})));
        // ['ICN','A'],['A','B'],['A','C'],['B','A'],['C','A']
        // [["ICN", "AAA"], ["ICN", "CCC"], ["CCC", "DDD"], ["AAA", "BBB"], ["AAA", "BBB"], ["DDD", "ICN"], ["BBB", "AAA"]]
        // [["ICN", "AAA"], ["ICN", "AAA"], ["ICN", "AAA"], ["AAA", "ICN"], ["AAA", "ICN"]]
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "A"}, {"ICN", "C"},  {"C", "D"},  {"A", "B"},  {"A", "B"}, {"D", "ICN"}, {"B", "A"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "A"}, {"ICN", "A"},  {"ICN", "A"},  {"A", "ICN"},  {"A", "ICN"}})));
    }

    public static String[] solution(String[][] tickets) {
        answer = new String[tickets.length + 1];

        for (int i = 0, size = tickets.length; i < size; i++) {
            if(tickets[i][0].equals("ICN")){
                visited = new boolean[size];
                visited[i] = true;

                result = new String[size + 1];
                result[0] = tickets[i][0];
                result[1] = tickets[i][1];

                DFS(1, tickets);
            }
        }
        return answer;
    }

    private static void DFS(int cnt, String[][] tickets) {
        if(cnt == tickets.length){
            for (int i = 0; i < tickets.length; i++) {
                if(answer[i] == null || result[i].compareTo(answer[i]) < 0){
                    answer = result;
                    return;
                }
            }
        }

        for (int i = 0, size = tickets.length; i < size; i++) {
            if(tickets[i][0].equals(result[cnt]) && !visited[i]){
                visited[i] = true;
                result[cnt + 1] = tickets[i][1];
                DFS(cnt + 1, tickets);
            }
        }
    }
}
