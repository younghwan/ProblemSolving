package LinkedList.SplitLinkedListinParts;

import java.util.Arrays;

/*
Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
The length of each part should be as equal as possible: no two parts should have a size differing by more than 1.
This may lead to some parts being null.
The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
Return a List of ListNode's representing the linked list parts that are formed.

Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
Example 1:
Input:
root = [1, 2, 3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The input and each element of the output are ListNodes, not arrays.
For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but it's string representation as a ListNode is [].
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int[] part = new int[k];
        ListNode[] ans = new ListNode[k];
        int len = 0;
        ListNode head = root;
        while (head != null) {
            len++;
            head = head.next;
        }
        int cnt = len / k; // 999/50 = 19
        int mod = len % k; // 49
        if (cnt == 0)
        {
            cnt = 1;
            mod = 0;
        }
        for (int i = 0; i < part.length && len > 0; i++) {
            if(mod>0)
            {
                part[i] = cnt + 1;
                len -= cnt+1;
                mod--;
            }
            else {
                part[i] = cnt;
                len -= cnt;
            }

        }
        //0 1 2 3 4 , 3
        for(int i = 0; i<part.length && root != null;i++) {
            ListNode newNood = new ListNode(root.val);
            ListNode next = root.next;
            ListNode newHead = newNood;
            while (--part[i] > 0 && next != null) {
                newNood.next = new ListNode(next.val);
                next = next.next;
                newNood = newNood.next;
            }
            root = next;
            ans[i] = newHead;
        }
        return ans;
    }

    // Best Solution
//    public ListNode[] splitListToParts(ListNode root, int k) {
//        ListNode cur = root;
//        int N = 0;
//        while (cur != null) {
//            cur = cur.next;
//            N++;
//        }
//
//        int width = N / k, rem = N % k;
//
//        ListNode[] ans = new ListNode[k];
//        cur = root;
//        for (int i = 0; i < k; ++i) {
//            ListNode head = new ListNode(0), write = head;
//            for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
//                write = write.next = new ListNode(cur.val);
//                if (cur != null) cur = cur.next;
//            }
//            ans[i] = head.next;
//        }
//        return ans;
//    }

}
