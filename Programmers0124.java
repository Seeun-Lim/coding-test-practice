// 네트워크
// A와 B가 직접적으로 연결
// B와 C가 직접적으로 연결
// A와 C도 간접적으로 연결되어 있는 상태
// 네트워크의 갯수 : 뭉텅이 갯수 return
// computers[i][j] = 1 > i번과 j번 컴퓨터가 연결되어 있으면 1
// computers[i][i] = 1
// 게리멘더링이랑 똑같은 문제암

import java.util.Arrays;

public class Programmers0124 {
    static int answer;
    static boolean visited[];

    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        answer = 0;

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                answer += 1;
                DFS(i, computers, n);
            }
        }

        return answer;
    }

    public static void DFS(int a, int[][] computers, int n){
        if(a == n) return;
        for (int i = 0; i < n; i++) {
            if(a != i && computers[a][i] == 1 && !visited[i]){
                visited[i] = true;
                DFS(i, computers, n);
            }
        }
    }

    //    public static void main(String[] args) {
//        System.out.println(solution(1, new int[][]{{1}}));
//        System.out.println(solution(7, new int[][]{
//                {1,0,0,0,0,0,1},
//                {0,1,1,0,1,0,0},
//                {0,1,1,1,0,0,0},
//                {0,0,1,1,0,0,0},
//                {0,1,0,0,1,1,0},
//                {0,0,0,0,1,1,1},
//                {1,0,0,0,0,1,1}
//        }));
//        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
//    }
}
