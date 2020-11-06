package DataStructure.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
7
1 2 3
2 4 0
3 5 6
5 0 0
6 0 7
7 0 0
8 0 0

	       1
	   2       3
     4       5   6
   			       7

 */
public class ArrayTree {
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        tree = new int[n+2][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int root = Integer.parseInt(st.nextToken());
            tree[root][0] = Integer.parseInt(st.nextToken());
            tree[root][1] = Integer.parseInt(st.nextToken());
        }

        inOrder(1);
    }

    static void inOrder(int val) {
        if (tree[val][0] != 0) inOrder(tree[val][0]);
        System.out.print(val);
        if (tree[val][1] != 0) inOrder(tree[val][1]);
    }
}