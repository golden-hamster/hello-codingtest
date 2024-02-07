package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex240207_2 {

    /**
     * 백준 2750 수정렬하기1
     * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
     */

    /**
     * 자바에서는 sort() 함수를 이용해 쉽게 정렬할 수 있지만, 정렬을 직접 구현할 줄 알아야 한다 .
     * n의 최대 범위가 1,000으로 매우 작기 때문에 o(n^2)시간 복잡도 알고리즘으로 풀 수 있다.
     * 버블 정렬의 시간 복잡도가 o(n^2)이므로 버블 정렬 알고리즘을 이용해 정렬해도 된다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        for (int i : a) {
            System.out.println(i);
        }
    }

}
