package LinkedList.NextGreaterNode;

import java.util.*;

/*
We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.
If such a j does not exist, the next larger value is 0.
Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
Note that in the example inputs (not outputs) below, arrays such as [2,1,5]
represent the serialization of a linked list with a head node value of 2,second node value of 1, and third node value of 5.

Example 1:
Input: [2,1,5]
Output: [5,5,0]

Example 2:
Input: [2,7,4,3,5]
Output: [7,0,5,5,0]
Example 3:

Input: [1,7,5,1,9,2,5,1]
Output: [7,9,9,9,0,5,0,0]
 */
public class Solution {

    public int[] nextLargerNodes(ListNode head) {
        ListNode node = head;
        List<Integer> nodeList = new ArrayList<>();
        while (node != null) {
          nodeList.add(node.val);
          node = node.next;
        }//리스트화

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        int[] result = new int[nodeList.size()];


        for(int i = nodeList.size()-1; i>=0; i--)
        {
            int val = nodeList.get(i);
            System.out.println(val);

            while (!pq.isEmpty() && pq.peek() <= val){
                pq.remove();
            }
            if(pq.isEmpty()){
                result[i] = 0;
            }
            else result[i] = pq.peek();

            pq.offer(val);
        }
        return result;
    }

    // 0 1 2 // val 5 1 2 // pq : 5
    // 5 5 0

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode input = new ListNode(2);
        input.next = new ListNode(1);
        input.next.next = new ListNode(5);
//        ListNode  = {2,7,4,3,5};
//        Output: [7,0,5,5,0]
        for (int i : solution.nextLargerNodes(input)) {
            System.out.println(i);
        }
    }
}
//node 1 -> node 3
//        2       5
//
//        node 2 -> node 3
//        1             5