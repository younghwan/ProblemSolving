package LinkedList.Components;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
No.817
We are given head, the head node of a linked list containing unique integer values.
We are also given the list G, a subset of the values in the linked list.
Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.

Example 1:
Input:
head: 0->1->2->3
G = [0, 1, 3]
Output: 2
Explanation:
0 and 1 are connected, so [0, 1] and [3] are the two connected components.

Example 2:
Input:
head: 0->1->2->3->4
G = [0, 3, 1, 4]
Output: 2
Explanation:
0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 */

//        head: 0->1->2->3->4
//        G = [0, 3, 1, 4]
//            -1, -1,-1,-1
//      2

//        [1,2,0,4,3]
//        [3,4,0,2,1]

public class Solution {
    //best solution
//    public int numComponents(ListNode head, int[] G) {
//        Set<Integer> Gset = new HashSet();
//        for (int x: G) Gset.add(x);
//
//        ListNode cur = head;
//        int ans = 0;
//
//        while (cur != null) {
//            if (Gset.contains(cur.val) &&
//                    (cur.next == null || !Gset.contains(cur.next.val)))
//                ans++;
//            cur = cur.next;
//        }
//
//        return ans;
//    }
    public int numComponents(ListNode head, int[] G) {

        ListNode node = head;
        List<Integer> list = new ArrayList<>();
        int res = 0;
        int index = 0;

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (IntStream.of(G).anyMatch(x -> x == num)) {
                if (findIndex(G, num) != -1) G[findIndex(G, num)] = -1;

                if(i+1<list.size()) index = i + 1;

                while (list.get(index) != null) {
                    int target = list.get(index);
                    if (IntStream.of(G).noneMatch(x -> x == target)) {
                        System.out.println(num);
                        res++;
                        break;
                    }
                    if (findIndex(G, target) != -1) G[findIndex(G, target)] = -1;
                    if(index+1<list.size()) index++;
                    else break;
                }
            }
        }
        return res;

    }

    public static int findIndex(int arr[], int t) {

        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode input = new ListNode(0);
        input.next = new ListNode(1);
        input.next.next = new ListNode(2);
        input.next.next.next = new ListNode(3);
        input.next.next.next.next = new ListNode(4);

        int[] G = {0, 3, 1, 4};
        System.out.println(solution.numComponents(input, G));
    }
}
