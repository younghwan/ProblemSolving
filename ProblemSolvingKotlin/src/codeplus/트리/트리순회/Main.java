package codeplus.트리.트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1991
public class Main {
    static int[][] tree = new int[26][2];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int tc = Integer.parseInt(s);


        for (int i = 0; i < tc; i++) {
            String in = bf.readLine();
            StringTokenizer st = new StringTokenizer(in);
            char root = st.nextToken().charAt(0);
            for (int j = 0; j < 2; j++) {
                char c = st.nextToken().charAt(0);
                if (c == '.') {
                    tree[root - 65][j] = -1;
                } else {
                    tree[root - 65][j] = c - 65;
                }
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    private static void postOrder(int n) {
        int root = n;
        int left = tree[n][0];
        int right = tree[n][1];

        if (left > 0) postOrder(left);
        if (right > 0) postOrder(right);
        System.out.print((char) (root + 65));
    }

    static void preOrder(int n) {
        int root = n;
        int left = tree[n][0];
        int right = tree[n][1];
        System.out.print((char) (root + 65));
        if (left > 0) preOrder(left);
        if (right > 0) preOrder(right);
    }

    static void inOrder(int n) {
        int root = n;
        int left = tree[n][0];
        int right = tree[n][1];
        if (left > 0) inOrder(left);
        System.out.print((char) (root + 65));
        if (right > 0) inOrder(right);
    }
}
// 트리를 2차원배열로 구현할수있다. 인덱스를 루트로두고 좌우를 넣어둔다
// 순회를 할때 재귀를 이용한다.

/*
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
*/