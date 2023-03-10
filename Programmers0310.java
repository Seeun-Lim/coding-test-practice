import java.util.*;

public class Programmers0310 {

    static class Song{
        int playCnt;
        int idx;

        Song(int playCnt, int idx){
            this.playCnt = playCnt;
            this.idx = idx;
        }
    }

    static class Genre{
        String genre;
        int sum;

        Genre(String genre, int sum){
            this.genre = genre;
            this.sum = sum;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Song>> m = new HashMap<>();
        Map<String, Integer> s = new HashMap<>();

        for(int i = 0; i < genres.length; i++){

            if(m.containsKey(genres[i])) {
                s.put(genres[i], s.get(genres[i]) + plays[i]);
            } else {
                m.put(genres[i], new ArrayList<Song>());
                s.put(genres[i], plays[i]);
            }
            m.get(genres[i]).add(new Song(plays[i], i));
        }

        List<Genre> g = new ArrayList<>();

        for(Map.Entry<String, Integer> entry: s.entrySet()){
            g.add(new Genre(entry.getKey(), entry.getValue()));
        }

        Collections.sort(g, new Comparator<Genre>(){
            @Override
            public int compare(Genre g1, Genre g2){
                return g2.sum - g1.sum;
            }
        });

        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < g.size(); i++){
            String k = g.get(i).genre;

            Collections.sort(m.get(k), new Comparator<Song>() {
                @Override
                public int compare(Song o1, Song o2) {
                    if(o1.playCnt == o2.playCnt) return o1.idx - o2.idx;
                    return o2.playCnt - o1.playCnt;
                }
            });

            l.add(m.get(k).get(0).idx);
            if(m.get(k).size() > 1) l.add(m.get(k).get(1).idx);

        }

        int[] answer = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            answer[i] = l.get(i);
        }

        return answer;
    }
}
