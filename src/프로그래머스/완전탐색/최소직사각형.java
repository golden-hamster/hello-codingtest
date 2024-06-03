package 프로그래머스.완전탐색;

public class 최소직사각형 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/86491

    public static void main(String[] args) {
        int[][] sizes = new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int ans = solution(sizes);
        System.out.println(ans);
    }

    public static int solution(int[][] sizes) {

        int[] max = new int[]{0, 0};

        for (int[] arr : sizes) {
            max[0] = Math.max(max[0], Math.max(arr[0], arr[1]));
            max[1] = Math.max(max[1], Math.min(arr[0], arr[1]));
        }

        return max[0] * max[1];
    }

}
