package practice.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr240320_2 {

    /**
     * 백준 10808 - 알파뱃 개수
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        int[] a = new int[26];
        Arrays.fill(a, 0);
        for (int i = 0; i < S.length; i++) {
            a[S[i] - 'a']++;
        }
        for (int i : a) {
            System.out.print(i + " ");
        }

    }
}
