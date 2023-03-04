public class Programmers030401 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown + yellow;
        boolean find = false;

        for(int i = 1; i <= yellow && !find; i++){
            if(yellow % i == 0 || i == 1){
                int h = yellow / i;
                int k = 1;

                while((h + k) * (i + k) <= total){
                    if((h + k) * (i + k) == total) {
                        answer = new int[]{h + k, i + k};
                        find = true;
                        break;
                    }
                    k++;
                }
            }
        }

        return answer;
    }
}
