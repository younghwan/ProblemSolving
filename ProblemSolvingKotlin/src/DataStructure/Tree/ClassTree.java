package DataStructure.Tree;

//클래스를 이용한 방법
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
import kotlin.reflect.jvm.internal.impl.utils.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClassTree {
    public static void main(String[] args) throws IOException {
        // 인풋을 받을때 root 부터 순서대로 받을 경우에만 정상 동작 한다.
        // 순서가 랜덤일 경우엔 Node에 parent를 추가해서 parent가 null인것부터 시작하면댐
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        Tree tree = new Tree();
        String[] data;
        for (int i = 0; i < tc; i++) {
            data = bf.readLine().split(" ");
            int rootNum = Integer.parseInt(data[0]);
            int leftNum = Integer.parseInt(data[1]);
            int rightNum = Integer.parseInt(data[2]);
            tree.add(rootNum,leftNum,rightNum);
        }
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
        System.out.println();
        tree.DFS(tree.root);
    }
}

class Tree {
    Node root;

    void add(int value, int left, int right) {
        if (root == null) {
            if (value != 0) root = new Node(value);
            if (left != 0) root.left = new Node(left);
            if (right != 0) root.right = new Node(right);
        } else search(root, value, left, right);
    }


    void search(Node root, int value, int left, int right) {
        if (root == null) return;

        if (value == root.value) {
            if (left != 0) root.left = new Node(left);
            if (right != 0) root.right = new Node(right);
        } else {
            search(root.left, value, left, right);
            search(root.right, value, left, right);
        }
    }

    void preOrder(Node root) {
        System.out.print(root.value);
        if (root.left != null) preOrder(root.left);
        if (root.right != null) preOrder(root.right);
    }

    void inOrder(Node root) {
        if (root.left != null) inOrder(root.left);
        System.out.print(root.value);
        if (root.right != null) inOrder(root.right);
    }

    void postOrder(Node root) {
        if (root.left != null) postOrder(root.left);
        if (root.right != null) postOrder(root.right);
        System.out.print(root.value);
    }

    void DFS(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) DFS(root.left);
        if (root.right != null) DFS(root.right);
        System.out.print(root.value);
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
