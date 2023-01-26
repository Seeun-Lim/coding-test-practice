import java.util.LinkedList;
import java.util.Queue;

// 단어 변환
public class Programmers0127 {
    static class Word{
        String word;
        int depth;
        public Word(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean visited[] = new boolean[words.length];
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));

        while (!q.isEmpty()){
            Word poll = q.poll();

            for (int i = 0; i < words.length; i++) {
                if(!visited[i]){
                    String word = words[i];
                    int cnt = 0;

                    for (int j = 0; j < word.length(); j++) {
                        if(poll.word.charAt(j) != word.charAt(j)) cnt++;
                    }

                    if(cnt == 1 && word.equals(target)){
                        return poll.depth + 1;
                    } else if(cnt == 1){
                        q.add(new Word(word, poll.depth + 1));
                        visited[i] = true;
                    }
                }
            }
        }

        return answer;
    }
}
