package 백준.큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준10845_큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            String cmd = command[0];
            switch(cmd) {
                case "push" :
                    int x = Integer.parseInt(command[1]);
                    queue.offer(x);
                    last = x;
                    break;
                case "pop" :
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(queue.poll()).append("\n");
                    }
                    break;
                case "size" :
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty" :
                    if (queue.isEmpty()) {
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "front" :
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(queue.peek()).append("\n");
                    }
                    break;
                case "back" :
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(last).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
