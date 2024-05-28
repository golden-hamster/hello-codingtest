package 프로그래머스.스택;

import java.util.Stack;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 3, 3, 0, 1, 1};
        int[] ans = solution(arr);
        for (int an : ans) {
            System.out.print(an);
        }
    }

    public static int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (!(i == stack.peek())) {
                stack.push(i);
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.get(i);
        }

        return ans;
    }
}
