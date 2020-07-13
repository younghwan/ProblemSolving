package LinkedList.AddTwoNum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given two non-empty linked lists representing two non-negative integers.
The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */

//stack 구조 사용하기
//index를 두번 사용하는것 보다 변수를 하나만들어서 사용하는게 좋다.
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cnt1 = 0;
        int cnt2 = 0;
        int len = 0;
        int carry = 0;
        ListNode node1 = l1;
        ListNode node2 = l2;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> resList = new ArrayList<>();

        while (node1 != null) {
            cnt1++;
            list1.add(node1.val);
            node1 = node1.next;
        }

        while (node2 != null) {
            cnt2++;
            list2.add(node2.val);
            node2 = node2.next;
        }

        if (cnt1 > cnt2) {
            len = cnt1;
            for (int i = 0; i < cnt1 - cnt2; i++) list2.add(0, 0);
        } else if (cnt1 < cnt2) {
            len = cnt2;
            for (int i = 0; i < cnt2 - cnt1; i++) list1.add(0, 0);
        } else len = list1.size();

        for (int i = len - 1; i >= 0; i--) {
            int sum = list1.get(i) + list2.get(i) + carry;
            carry = 0;
            if (sum > 9) {
                carry = 1;
                resList.add(0, sum % 10);
            } else{
                resList.add(0, sum);
            }
        }

        if(carry>0) resList.add(0,carry);

        ListNode resNode = new ListNode(resList.get(0));
        ListNode head = resNode;
        for (int i = 1; i < resList.size(); i++) {
            resNode.next = new ListNode(resList.get(i));
            resNode = resNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        Solution solution = new Solution();

        solution.addTwoNumbers(l1, l2);
        List<Integer> list = new ArrayList<>();

//        list.add(0,1);
//
//        System.out.println(list.get(0));

    }
}
