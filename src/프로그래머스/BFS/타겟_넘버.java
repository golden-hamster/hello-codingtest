package 프로그래머스.BFS;


import java.util.LinkedList;
import java.util.Queue;

public class 타겟_넘버 {

    //https://school.programmers.co.kr/learn/courses/30/lessons/43165

    public static void main(String[] args) {
        int[] numbers = new int[]{4, 1, 2, 1};
        int target = 4;

        int ans = solution(numbers, target);
        System.out.println(ans);
    }

    public static class Node {
        int index;
        int sum;

        Node(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }

    public static int solution(int[] numbers, int target) {
        int ans = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            //모든 숫자를 다 사용한 경우
            if (node.index == numbers.length) {
                if (node.sum == target) {
                    ans++;
                }
            }else{
                queue.add(new Node(node.index + 1, node.sum + numbers[node.index]));
                queue.add(new Node(node.index + 1, node.sum - numbers[node.index]));
            }
        }

        return ans;
    }
}
