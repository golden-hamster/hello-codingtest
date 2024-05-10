package 백준.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준4179_불 {

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static char[][] board;
    static int[][] fireDist; // 불의 전파 시간
    static int[][] jihunDist; // 지훈이의 이동 시간
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        fireDist = new int[n][m];
        jihunDist = new int[n][m];

        // 각 위치에 대한 시간 정보를 계산하기 전에 -1 로 채워둠. 아직 방문하지 않았음을 의미함.
        for (int i = 0; i < n; i++) {
            Arrays.fill(fireDist[i], -1);
            Arrays.fill(jihunDist[i], -1);
        }

        Queue<Node> fireQ = new LinkedList<>();
        Queue<Node> jihunQ = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                board[i][j] = c;
                if (c == 'F') {
                    fireQ.offer(new Node(i, j));
                    fireDist[i][j] = 0;
                }
                if (c == 'J') {
                    jihunQ.offer(new Node(i, j));
                    jihunDist[i][j] = 0;
                }
            }
        }

        // 불에 대한 BFS
        while (!fireQ.isEmpty()) {
            Node current = fireQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(isNotRange(nx, ny)) continue;
                if(fireDist[nx][ny] >= 0 || board[nx][ny] == '#') continue;
                fireDist[nx][ny] = fireDist[current.x][current.y] + 1;
                fireQ.offer(new Node(nx, ny));
            }
        }


        // 지훈이에 대한 BFS
        while (!jihunQ.isEmpty()) {
            Node cur = jihunQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isNotRange(nx, ny)) {
                    System.out.println(jihunDist[cur.x][cur.y] + 1);
                    return;
                }
                if(jihunDist[nx][ny] >= 0 || board[nx][ny] == '#') continue;
                if(fireDist[nx][ny] != -1 && fireDist[nx][ny] <= jihunDist[cur.x][cur.y] + 1) continue; // 불의 전파 시간을 조건에 추가
                jihunDist[nx][ny] = jihunDist[cur.x][cur.y] + 1;
                jihunQ.offer(new Node(nx, ny));
            }
        }
        System.out.println("IMPOSSIBLE");

    }

    public static boolean isNotRange(int nx, int ny) {
        return (nx < 0 || nx >= n || ny < 0 || ny >= m);
    }
}
