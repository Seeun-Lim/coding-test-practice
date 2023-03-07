import java.util.LinkedList;
import java.util.Queue;

public class Programmers0307 {
    public int solution(int n, int[][] wires) {
        int answer = n;
        // answer의 최솟값 구해줘야 함...

        for(int i = 0; i < wires.length; i++){
            int cnt = bfs(i, wires);
            int rest = n - cnt;
            answer = Math.min(answer, Math.abs(cnt - rest));
        }

        return answer;
    }

    public static int bfs(int idx, int[][] wires){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[wires.length];

        if(idx == 0) {
            q.add(wires[1][0]);
            q.add(wires[1][1]);
            visited[1] = true;
        } else {
            q.add(wires[0][0]);
            q.add(wires[0][1]);
            visited[0] = true;
        }

        int cnt = 0;
        while(!q.isEmpty()){
            int poll = q.poll();
            cnt++;

            for(int i = 0; i < wires.length; i++){
                if(idx == i) continue;
                if(!visited[i] && (poll == wires[i][0] || poll == wires[i][1])){
                    visited[i] = true;
                    q.add(poll == wires[i][0]? wires[i][1] : wires[i][0]);
                }
            }
        }


        return cnt;
    }
}
