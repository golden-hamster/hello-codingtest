package example;

import java.util.Scanner;

public class ex240111 {

    /**
     * 백준 2018 연속된 자연수의 합 구하기
     * 어떠한 자연수 N은 몇개의 연속된 자연수의 합으로 나타낼 수 있다. 당신은 어떤 자연수 N(1<= N <= 10,000,000)을
     * 몇 개의 연속된 자연수의 합으로 나타내는 가짓수를 알고 싶다. 이때 사용하는 자연수는 N 이어야 한다.
     * 예를 들어 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5이다. N을 입력받아 연속된 자연수의 합으로 나타내는
     * 가짓수를 출력하는 프로그램을 작성하시오.
     */

    /**
     * N 변수 저장
     * 사용 변수 초기화(count = 1, start_index = 1, end_index = 1, sum = 1)
     * while(end_index != N){
     *     if(sum==N) count 증가, end_index 증가, sum 값 변경
     *     else if(sum > N) sum 값 변경, start_index 증가
     *     else if(sum < N) end_index 증가, sum 값 변경
     * }
     * count 출력하기
     */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1;

        while (end != n) {
            if (sum == n) {
                count++;
                end++;
                sum += end;
            }else if(sum > n){
                sum -= start;
                start++;
            } else if(sum < n){
                end++;
                sum += end;
            }
        }

        System.out.println(count);
    }

}
