//package Fasoo;
//
//import java.util.Stack;
//
//public class Solution {
//    public static void main(String[] args) {
//        String s = "{cpp{java}}{python}";
//        int[] idx = {0, 4, 9, 10, 11, 18};
//        int[] arr = new int[s.length()];
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '{') {
//                stack.add(i);
//            } else if (s.charAt(i) == '}') {
//                int top = stack.peek();
//                arr[top] = i;
//                arr[i] = top;
//                stack.pop();
//            }
//        }
//        for (int i = 0; i < idx.length; i++) {
//            System.out.println(arr[idx[i]]);
//        }
//
//    }
//}
