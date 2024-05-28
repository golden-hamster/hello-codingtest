package 프로그래머스.해시;

import java.util.HashSet;

public class 폰켓몬 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 3, 2, 2, 2};
        int ans = solution(nums);
        System.out.println(ans);
    }

    public static int solution(int[] nums) {
//        int answer = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

//        if (hashSet.size() > nums.length / 2) {
//            answer = nums.length / 2;
//        } else {
//            answer = hashSet.size();
//        }
        return Math.min(hashSet.size(), nums.length / 2);
    }
}
