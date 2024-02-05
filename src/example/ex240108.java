package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex240108 {
    /**
     * 백준 11659 구간 합 구하기
     * 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
     *===========================================================================
     * 입력 : 1번째 줄에 수의 개수 N, 합을 구해야 하는 횟수 M, 2번째 줄에 N개의 수가 주어진다.
     * 각 수는 1,000보다 작거나 같은 자연수다. 3번째 줄부터는 M개의 줄에 합을 구해야 하는 구간 i 와 j 가 주어진다.
     * ===========================================================================
     * 출력 : 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
     */

    /**
     * 합 배열 공식
     * S[i] = S[i-1] + A[i]
     */

    /**
     * suNo(숫자 개수), quizNo(질의 개수) 저장하기
     * for(숫자 개수만큼 반복하기){
     * 합 배열 생성하기(S[i] = S[i-1] + A[i])
     * }
     * for(질의 개수만큼 반복하기){
     * 질의 범위 받기(i ~ j)
     * 구간 합 출력하기(S[j] - S[i - 1])
     * }
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());
        long[] s = new long[suNo + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= suNo; i++) {
            s[i] = s[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int q = 0; q < quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(s[j] - s[i - 1]);
        }
    }
}
