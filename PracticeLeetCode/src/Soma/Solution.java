package Soma;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
//    public static void main(String[] args) {
//        int[] arr = new int[100000];
//        boolean isNext = true;
//        Scanner scanner = new Scanner(System.in);
//        int ans , n, k ,index;
//        n = scanner.nextInt();
//        k = scanner.nextInt();
//
//        if(n == k) {System.out.println(1); return;}
//        for(int i =0; i< n; i++) arr[i] = scanner.nextInt();
//
//        index = k-1;
//        ans = 1;
//        while (arr[index] != 0 && isNext){
//            for(int i = index; i<index+k-1; i++)
//                if (arr[i] == 0) {
//                    isNext = false;
//                    break;
//                }
//            index += k-1;
//            ans++;
//        }
//        System.out.println(ans);
//    }


    public static void main(String[] args) {
        int[] arr = new int[100000];
        Scanner scanner = new Scanner(System.in);
        double n, k;
        n = scanner.nextDouble();
        k = scanner.nextDouble();
        for(int i =0; i< n; i++) arr[i] = scanner.nextInt();
        int ans = (int)(1 + Math.ceil((n - k) / (k - 1)));
        System.out.println(ans);
    }
}

