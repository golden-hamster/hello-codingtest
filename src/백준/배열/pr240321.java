package 백준.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr240321 {

    /**
     * 백준 1475 - 방 번호
     */

    /**
     * 방 번호 입력받고 자리수마다 N 배열에 저장하기
     * N 배열에서의 숫자 개수를 저장할 배열 A 만들기
     * N 배열에서 각각의 숫자 개수 A 배열에 저장하기{
     *     6 혹은 9 일 경우 6, 9 중 하나만 ++;
     * }
     * A 배열에서 최대값 출력하기
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] digits = br.readLine().toCharArray();
        double[] A = new double[10];
        for(char digit : digits){
            int num = digit - '0';
            if (num == 6 || num == 9) {
                A[6] += 0.5;
            } else A[num]++;
        }

        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = (int)Math.round(A[i]);
            }
        }

        System.out.println(max);
    }
}
