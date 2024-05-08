package 백준.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준2178_미로탐색 {

    /**
     * dx, dy(상하좌우를 탐색하기 위한 define 값 정의 변수)
     * A(데이터 저장 2차원 행렬)
     * N(row), M(column)
     * visited(방문 기록 저장 배열)
     * A 배열 초기화하기
     * visited 배열 초기화하기
     * for(N의 개수만큼 반복하기){
     *     for(M의 개수만큼 반복하기){
     *         A 배열에 데이터 저장하기
     *     }
     * }
     * BFS(0,0) 실행
     * BFS{   -------------> BFS 구현
     *     큐 자료구조에 시작 노드 삽입(add 연산)
     *     visited 배열에 현재 노드 방문 기록
     *     while(큐가 비어 있을 때까지){
     *         큐에서 노드 데이터를 가져오기(poll 연산)
     *         for(상하좌우 탐색){
     *             if(유효한 좌표){       ----------------> 미로의 밖으로 갈 수 없다, 데이터가 0 이면 안 된다, 이미 방문했으면 안 된다.
     *                 if(이동할 수 있는 칸이면서 방문하지 않은 노드){
     *                     visited 배열에 방문 기록
     *                     A 배열에 depth 를 현재 노드의 depth + 1 로 업데이트하기
     *                     큐에 데이터 삽입하기(add 연산)
     *                 }
     *             }
     *         }
     *     }
     * }
     */

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0}; // 우하좌상
    static boolean[][] visited;
    static int[][] A;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken(); //110010
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j + 1)); // 한칸 한칸 짤라서 넣기 위해서
            }
        }

        BFS(0, 0);
        System.out.println(A[N-1][M-1]); // 도착지점의 depth
    }

    private static void BFS(int i, int j) {
        Queue<int[]>queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            for (int k = 0; k < 4; k++) { // 상하좌우로 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M) { // 배열을 넘어가면 안 된다
                    if (A[x][y] != 0 && !visited[x][y]) { // 0이어서 갈 수 없거나 기방문한 곳이면 안 된다
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; // depth 저장 (핵심)
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
