import java.util.*;

public class Programmers0309 {
    public int solution(int[] nums) {
        int answer = 0;

        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(m.containsKey(nums[i])){
                m.put(nums[i], m.get(nums[i]) + 1);
            } else m.put(nums[i], 1);
        }

        answer = nums.length / 2 > m.keySet().size() ? m.keySet().size() : nums.length / 2;

        return answer;
    }
}