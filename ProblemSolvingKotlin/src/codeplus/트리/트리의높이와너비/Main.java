package codeplus.트리.트리의높이와너비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] leftPerLevel;
    static int[] rightPerLevel;
    static int posX = 1;
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        leftPerLevel = new int[n + 1];
        rightPerLevel = new int[n + 1];
        tree = new Node[n + 1];
        for (int i = 0; i < n + 1; i++) {
            leftPerLevel[i] = Integer.MAX_VALUE;
            rightPerLevel[i] = Integer.MIN_VALUE;
            tree[i] = new Node(-1, -1);
        }
        String[] in;

        for (int i = 0; i < n; i++) {
            in = bf.readLine().split(" ");
            int val = Integer.parseInt(in[0]);
            int left = Integer.parseInt(in[1]);
            int right = Integer.parseInt(in[2]);
            tree[val].value = val;
            tree[val].left = left;
            tree[val].right = right;
            if (left != -1) tree[left].parent = val;
            if (right != -1) tree[right].parent = val;
        }

        int rootIdx = -1;
        for (int i = 1; i < tree.length; i++) {
            if (tree[i].parent == -1) {
                rootIdx = i;
                break;
            }
        }
        inOrder(rootIdx, 1);

        int ansLevel = 0;
        int ansWidth = 0;

        for (int i = 1; i <= n; i++) {
            if (ansWidth < (rightPerLevel[i] - leftPerLevel[i]) + 1) {
                ansWidth = (rightPerLevel[i] - leftPerLevel[i]) + 1;
                ansLevel = i;
            }
        }
        System.out.println(ansLevel + " " + ansWidth);
    }

    static void inOrder(int val, int level) {
        if (val == -1) return;
        inOrder(tree[val].left, level + 1);
        leftPerLevel[level] = Math.min(leftPerLevel[level], posX);
        rightPerLevel[level] = posX;
        posX++;
        inOrder(tree[val].right, level + 1);
    }

    static class Node {
        int left;
        int right;
        int value;
        int parent;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
            this.parent = -1;
        }
    }
}
/*
19
5 9 10
2 4 5
3 6 7
4 8 -1
6 11 12
1 2 3
7 13 -1
8 -1 -1
9 14 15
10 -1 -1
11 16 -1
12 -1 -1
13 17 -1
14 -1 -1
15 18 -1
16 -1 -1
17 -1 19
18 -1 -1
19 -1 -1
 */