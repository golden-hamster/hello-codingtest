package practice.기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr240320 {
    /**
     * 백준 2562 - 최댓값
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[9];
        int index = 0;
        int max = 0;
        for (int i = 0; i < 9; i++) {
            a[i] = Integer.parseInt(br.readLine());
            if (max < a[i]) {
                max = a[i];
                index = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(index);

    }
}
