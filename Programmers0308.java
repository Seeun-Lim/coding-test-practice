import java.util.LinkedList;
import java.util.Queue;

public class Programmers0308 {boolean solution(String s) {
    if(s.charAt(s.length() - 1) == '(' || s.charAt(0) == ')' || s.length() % 2 == 1) return false;

    Queue<Character> q = new LinkedList<>();
    for(int i = 0; i < s.length(); i++) {
        char npoll = s.charAt(i);

        if(npoll == '(') q.add(npoll);
        else {
            if(q.isEmpty()) q.add(npoll);
            else q.poll();
        }
    }

    return q.isEmpty()? true : false;
}
}
