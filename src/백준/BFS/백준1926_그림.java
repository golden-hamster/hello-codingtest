package 백준.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준1926_그림 {

    /**
    정수 n, m을 입력받음
    정수형 2차원 배열 a를 크기 n*m으로 초기화
    방문 여부를 나타내는 2차원 boolean 배열 visited 을 크기 n*m으로 초기화
    정수형 변수 currentArea 와 maxArea 를 선언하고 0으로 초기화

    도화지의 정보를 입력받아 배열 a에 저장

    정수형 변수 count 를 0으로 초기화

    n번째 행과 m번째 열을 반복하여 순회
    만약 a[i][j]가 1이고 visited[i][j]가 false 라면
    count 를 1 증가시키고
    currentArea 를 0으로 초기화하고
    bfs 함수를 호출하여 현재 위치에서의 그림의 넓이를 계산하고
    maxArea 를 현재 그림의 넓이와 비교하여 더 큰 값으로 업데이트함

    count 와 maxArea 를 출력함

     <---------------------- bfs -------------------->

     bfs 함수는 시작점 (i, j)에서부터 넓이를 탐색하는 역할을 수행함

     시작점 (i, j)를 큐에 삽입하고 방문 여부를 표시함
     현재 넓이를 1 증가시킴

     큐가 비어있을 때까지 반복 수행함
     큐에서 노드를 하나씩 꺼냄
     현재 노드의 상하좌우를 탐색하여 이동할 수 있는지 확인함
     이동할 수 있는 위치가 도화지 범위를 벗어나지 않고, 그림이 그려진 부분이며 아직 방문하지 않았다면
     방문 표시를 하고 큐에 추가함
     넓이를 1 증가시킴
    */

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] a;
    static int n, m;
    static int currentArea;
    static int maxArea = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1 && !visited[i][j]) {
                    count++;
                    currentArea = 0;
                    bfs(i, j);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        System.out.println(count);
        System.out.println(maxArea);
    }

    private static void bfs(int i, int j) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j}); // 시작점 넣기
        visited[i][j] = true; // 시작점 방문 기록
        currentArea++;
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && y >= 0 && x < n && y < m) { // 도화지 밖을 벗어나면 안됨
                    if (a[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                        currentArea++;
                    }
                }
            }
        }
    }
}
