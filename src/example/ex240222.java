package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex240222 {

    /**
     * 백준 11724 연결 요소의 개수
     * 방향 없는 그래프가 주어졌을 떄, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
     */

    /**
     * n(노드 개수), m(에지 개수)
     * a(그래프 데이터 저장 인접 리스트)
     * visited(방문 기록 저장 배열)
     * for(n의 개수만큼 반복하기){
     * a 인접 리스트의 각 ArrayList 초기화하기
     * }
     * for(m의 개수만큼 반복하기){
     * a 인접 리스트에 그래프 데이터 저장하기
     * }
     *
     * for(n의 개수만큼 반복하기){
     * if(방문하지 않은 노드가 있으면){
     * 연결 요소 개수++
     * DFS실행하기
     * }
     *
     * }
     * DFS{
     * if(현재 노드 == 방문 노드) return;
     * visited 배열에 현재 노드 방문 기록하기
     * 현재 노드의 ㅇ녀결 노드 중 방문하지 않는 노드로 DFS 실행하기(재귀 함수 형턔)
     * }
     */

    static boolean visited[];
    static ArrayList<Integer>[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        a = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            a[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s].add(e);
            a[e].add(s);
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    private static void DFS(int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int i : a[node]) {
                DFS(i);
        }
    }
}
