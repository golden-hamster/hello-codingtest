package 백준.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr240320_3 {
    /**
     * 백준 2577 - 숫자의 개수
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        char[] resultDigits = Integer.toString(A * B * C).toCharArray();
        int[] digitCounts = new int[10];
        for (char digit : resultDigits) {
            int num = digit - '0';
            digitCounts[num]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int count : digitCounts) {
            sb.append(count).append("\n");
        }
        System.out.print(sb.toString());
    }
}
