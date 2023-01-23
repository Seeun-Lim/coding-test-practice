// 연필을 안 가져와서 여기다가 품...
// n X m 크기의 맵, 나의 초기위치 (1, 1), 상대 초기위치 (n, m)
// 벽 존재(검은색 0), 흰 색(1)만 갈 수 있음
// 동서남북 방향으로 이동 => 배열 작성
// 도착하지 못할 경우에는 -1 반환
// 지나가야 하는 칸의 개수의 최솟값을 return

import java.util.LinkedList;
import java.util.Queue;

public class Programmers0123 {
    static class Pos{
        int x, y, depth;
        public Pos(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public static int solution(int[][] maps) {
        return BFS(maps);
    }

    public static int BFS(int[][] maps){
        int r = maps.length;
        int c = maps[0].length;

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[r][c];

        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();
            for (int i = 0; i < 4; i++){
                int dr = poll.x + dir[i][0];
                int dc = poll.y + dir[i][1];

                if(dr == r - 1 && dc == c - 1){
                    return poll.depth + 1;
                }

                if(dr < 0 || dr >= r || dc < 0 || dc >= c || visited[dr][dc] || maps[dr][dc] == 0){
                    continue;
                }

                queue.add(new Pos(dr, dc, poll.depth + 1));
                visited[dr][dc] = true;
            }
        }
        return -1;
    }
}
