package practice;

import java.util.Scanner;

public class ex240101 {

    public static void main(String[] args) {
        /**
         * 백준 11720 숫자의 합 구하기
         * N개의 숫자가 공백 없이 써 있다. 이 숫자를 모두 합해 출력하는 프로그램을 작성하시오.
         * ===========================================================================
         * 입력 : 1번째 줄에 숫자의 개수 N(1<= N <= 100), 2번째 줄에 숫자 N개가 공백 없이 주어진다.
         * ===========================================================================
         * 출력 : 입력으로 주어진 숫자 N개의 합을 출력한다.
         */

        /**
         * N값 입력받기
         * 길이 N의 숫자를 입력받아 String 형 변수 sNum 에 저장하기
         * sNum 을 다시 char[]형 변수 cNum 에 변환하여 저장하기
         * int 형 변수 sum 선언하기
         * for(cNum 길이만큼 반복하기)
         * {
         *  배열의 각 자릿값을 정수형으로 변환하며 sum에 더하여 누적하기
         *  }
         *  sum 출력하기
         */

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0';
//            sum += cNum[i] - 48;
        }

        System.out.println("sum = " + sum);
    }
}
