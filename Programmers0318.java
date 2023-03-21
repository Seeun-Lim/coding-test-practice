import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Programmers0318 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 0}));
    }

    public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        List<String> l = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            l.add(String.valueOf(numbers[i]));
        }

        l.sort(new Comparator<String>() {
            // 999 999 9 98 988 90 1000 1000 1000
            // 9 5 34 3 344 30 / 9 5 3444 34 3 32 30
            // 1 12 24 25
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });


        System.out.println(l);

        for (int i = 0; i < l.size(); i++) {
            answer.append(l.get(i));
        }

        return String.valueOf(answer);
    }
}
