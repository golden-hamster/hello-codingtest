package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex240314 {

    /**
     * 백준 2178 미로 탐색
     */

    /**
     *  dx, dy(상하좌우를 탐색하기 위한 define 값 정의 변수)
     *  a(데이터 저장 2차원 행렬)
     *  n(row), m(column)
     *  visited(방문 기록 저장 배열)
     *  a 배열 초기화하기
     *  visited 배열 초기화하기
     *  for(n의 개수만큼 반복하기){
     *      for(m의 개수만큼 반복하기){
     *          a 배열에 데이터 저장하기
     *      }
     *  }
     *  BFS(0, 0) 실행하기
     *  BFS{
     *      큐 자료구조에 시작 노드 삽입하기(add 연산)
     *      visited 배열에 현재 노드 방문 기록하기
     *      while(큐가 비어 있을 때까지){
     *          큐에서 노드 데이터를 가져오기(poll 연산)
     *          for(상하좌우 탐색){
     *              if(유효한 좌표){
     *                  if(이동할 수 있는 칸이면서 방문하지 않은 노드){
     *                      visited 배열에 방문 기록하기
     *                      a 배열에 depth 를 현재 노드의 depth + 1 로 업데이트하기
     *                      큐에 데이터 삽입하기(add 연산)
     *                  }
     *              }
     *          }
     *      }
     *  }
     */

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] a;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        BFS(0,0);
        System.out.println(a[n-1][m-1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            for (int k = 0; k < 4; k++) { // 상하좌우로 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < n && y < m) { // 배열을 넘어가면 안됨
                    if (a[x][y] != 0 && !visited[x][y]) { // 0 이어서 갈수없거나 방문한 곳이면 안됨
                        visited[x][y] = true;
                        a[x][y] = a[now[0]][now[1]] + 1; // depth 를 넣어줌
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
