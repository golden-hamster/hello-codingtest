package 백준.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class pr240321_2 {

    /**
     * 백준 3273 - 두수의 합
     */

    /**
     *  수열의 크기 n 입력받기
     *  수열에 포함되는 a 배열 입력받기
     *  x 입력받기
     *  보수(x - num)를 만족시키면 count ++
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int num : a) {
            if (set.contains(x - num)) {
                count++;
            }
            set.add(num);
        }
        System.out.println(count);
    }
}
