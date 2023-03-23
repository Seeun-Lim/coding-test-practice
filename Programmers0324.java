import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Programmers0324 {
    static class Stage{
        int num;
        int whole;
        int failure;
        double rate;

        public Stage(int num, int whole, int failure, double rate) {
            this.num = num;
            this.whole = whole;
            this.failure = failure;
            this.rate = rate;
        }
    }

    public static void main(String[] args) {
    solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        solution(4, new int[]{4, 4, 4, 4});
    }

    public static int[] solution(int N, int[] stages) {
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 1; i <= N + 1; i++) {
                m.put(i, 0);
        }

        for (int i = 0; i < stages.length; i++) {
            m.put(stages[i], m.get(stages[i]) + 1);
        }

        Stage[] s = new Stage[N];
        int cnt = stages.length;
        for (int i = 0; i < N ; i++) {
            s[i] = new Stage(i + 1, cnt, m.get(i + 1),
                    m.get(i + 1) == 0 ? 0 : (double)m.get(i + 1) / cnt);
            cnt -= m.get(i + 1);
        }

        Arrays.sort(s, new Comparator<Stage>() {
            @Override
            public int compare(Stage o1, Stage o2) {
                if(o1.rate == o2.rate) return o1.num - o2.num;
                return Double.compare(o2.rate, o1.rate);
            }
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = s[i].num;
        }

        return answer;
    }
}
