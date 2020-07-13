package Heap.UglyNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int num = 2;

        List<Integer> solList = new ArrayList<>();
        List<Integer> primesList = new ArrayList<>();

        for (int i : primes) {
            primesList.add(i);
        }
        solList.add(1);

        while (solList.size() < n) {
            ArrayList<Integer> primeFactorList = primeFactor(num);

            for (int i = 0; i < primeFactorList.size(); i++) {
                if (!primesList.contains(primeFactorList.get(i))) break;
                else if (i == primeFactorList.size() - 1) solList.add(num);
            }
            num++;
        }
        return solList.get(solList.size() - 1);
    }

    public ArrayList<Integer> primeFactor(int number) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = 2;
        while (number > 1) {
            if (number % n == 0) {
                number = number / n;
                list.add(n);
            } else {
                n++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 12;
        int[] arr = {2, 7, 13, 19};

        Solution solution = new Solution();

//        System.out.println(solution.primeFactor(21));
        System.out.println(solution.nthSuperUglyNumber(n, arr));
    }
}
