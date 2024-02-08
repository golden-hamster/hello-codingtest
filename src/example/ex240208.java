package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex240208 {

    /**
     * 백준 1427 내림차순으로 자릿수 정렬하기
     *  배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
     *
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] a = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            a[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        for (int i = 0; i < str.length(); i++) {
            int max = i;
            for (int j = i + 1; j < str.length(); j++) {
                if (a[j] > a[max]) {
                    max = j;
                }
            }

            int temp = a[i];
            a[i] = a[max];
            a[max] = temp;

        }
        for (int i : a) {
            System.out.print(i);
        }
    }
}
