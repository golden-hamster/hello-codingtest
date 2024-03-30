package 백준.덱;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 백준1021_회전하는큐 {
    /**
     * 1. LinkedList.pollFirst
     * 2. LinkedList.offerLast(LinkedList.pollFirst) cnt ++
     * 3. LinkedList.offerFirst(LinkedList.pollLast) cnt ++
     *
     * 1. 뽑고자 하는 원소가 덱의 중앙에서 끝쪽에 가까운 쪽 방향으로 이동(연산)하여 뽑고자 하는 원소가 첫 번째 위치에 갈 때까지 반복
     * 2. 원소를 뽑음
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            list.offerLast(i);
        }

        int[] seq = new int[m]; // 뽑고자 하는 수를 담은 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) { // 덱에서 뽑고자 하는 숫자의 위치(index) 찾기

            int targetIndex = list.indexOf(seq[i]);
            int halfIndex;

            // 현재 덱의 원소가 짝수 개라면 중간 지점을 현재 덱의 절반 크기에서 -1 감소시킨다.
            // {1, 2, 3, 4} 일 때, 2를 중간지점으로 하면 인덱스는 1이기 때문
            if (list.size() % 2 == 0) {
                halfIndex = list.size()/2 - 1;
            }else{
                halfIndex = list.size()/2;
            }

            if (targetIndex <= halfIndex) { // 중간 지점 또는 중간 지점보다 원소의 위치가 앞에 있을 경우
                for (int j = 0; j < targetIndex; j++) { // index 보다 앞에 있는 원소들을 모두 뒤로 보낸다. (2번 연산)
                    int temp = list.pollFirst();
                    list.offerLast(temp);
                    cnt++;
                }
            }else{ // 중간 지점보다 원소의 위치가 뒤에 있을 경우
                for (int j = 0; j < list.size() - targetIndex; j++) { // index 를 포함한 뒤에 있는 원소들을 모두 앞으로 보낸다. (3번 연산)
                    int temp = list.pollLast();
                    list.offerFirst(temp);
                    cnt++;
                }
            }
            list.pollFirst(); // 연산이 끝나면 맨 앞 원소를 삭제
        }
        System.out.println(cnt);
    }
}
