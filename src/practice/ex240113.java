package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex240113 {

    /**
     * 백준 12891 DNA 비밀번호
     * 평소에 문자열을 가지고 노는 것을 좋아하는 민호는 DNA 문자열을 알게 되었다.
     * DNA 문자열은 모든 문자열에 등장하는 문자가 {‘A’, ‘C’, ‘G’, ‘T’} 인 문자열을 말한다.
     * 예를 들어 “ACKA”는 DNA 문자열이 아니지만 “ACCA”는 DNA 문자열이다.
     * 이런 신비한 문자열에 완전히 매료된 민호는 임의의 DNA 문자열을 만들고 만들어진 DNA 문자열의 부분문자열을 비밀번호로 사용하기로 마음먹었다.
     * 하지만 민호는 이러한 방법에는 큰 문제가 있다는 것을 발견했다.
     * 임의의 DNA 문자열의 부분문자열을 뽑았을 때 “AAAA”와 같이 보안에 취약한 비밀번호가 만들어 질 수 있기 때문이다.
     * 그래서 민호는 부분문자열에서 등장하는 문자의 개수가 특정 개수 이상이여야 비밀번호로 사용할 수 있다는 규칙을 만들었다.
     * 임의의 DNA문자열이 “AAACCTGCCAA” 이고 민호가 뽑을 부분문자열의 길이를 4라고 하자.
     * 그리고 부분문자열에 ‘A’ 는 1개 이상, ‘C’는 1개 이상, ‘G’는 1개 이상, ‘T’는 0개 이상이 등장해야 비밀번호로 사용할 수 있다고 하자.
     * 이때 “ACCT” 는 ‘G’ 가 1 개 이상 등장해야 한다는 조건을 만족하지 못해 비밀번호로 사용하지 못한다.
     * 하지만 “GCCA” 은 모든 조건을 만족하기 때문에 비밀번호로 사용할 수 있다.
     * 민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분분자열의 길이,
     * 그리고 {‘A’, ‘C’, ‘G’, ‘T’} 가 각각 몇번 이상 등장해야 비밀번호로 사용할 수 있는지 순서대로 주어졌을 때
     * 민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하자.
     * 단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급한다.
     */

    /**
     * //데이터 저장
     * s(문자열 크기) p(부분 문자열의 크기)
     * a(문자열 데이터)
     * checkArr(비밀번호 체크 배열)
     * //변수 선언
     * myArr(현재 상태 배열)
     * checkSecret(몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수)
     * p의 범위(0 ~ p -1)만큼 s 배열에 적용하고, 유요한 비밀번호인지 판단
     * for(i를 p에서 s까지 반복)
     * {
     *     j 선언(i-p)
     * }
     */
    static int[] myArr;
    static int[] checkArr;
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int result = 0;
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;
        char[] a = new char[s];

        a = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }

        for (int i = 0; i < p; i++) { // 부분문자열 처음 받을 때 세팅
            add(a[i]);
        }

        if(checkSecret == 4) result++;

        // 슬라이딩 윈도우, 위에서 이미 p-1 까지는 탐색했으므로 i(끝점) 는 p 에서부터 시작
        for (int i = p; i < s; i++) {
            int j = i-p; // j => 시작점, i => 끝점
            add(a[i]);
            remove(a[j]);
            if(checkSecret == 4) result++;
        }

        System.out.println(result);
        br.close();
    }

    private static void remove(char c) {
        switch(c) {
            case 'A' :
                if(myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C' :
                if(myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G' :
                if(myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T' :
                if(myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void add(char c) {
        switch(c) {
            case 'A' :
                myArr[0]++;
                if(myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C' :
                myArr[1]++;
                if(myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G' :
                myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T' :
                myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
}
