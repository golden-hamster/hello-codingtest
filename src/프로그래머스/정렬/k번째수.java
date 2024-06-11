package 프로그래머스.정렬;

import java.util.Arrays;

public class k번째수 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/42748

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] solution = solution(arr, commands);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public static int[] solution(int[] arr, int[][] commands) {

        int[] ans = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] result = Arrays.copyOfRange(arr, commands[i][0] - 1, commands[i][1]);

            Arrays.sort(result);

            ans[i] = result[commands[i][2] - 1];
        }
        return ans;
    }
}
