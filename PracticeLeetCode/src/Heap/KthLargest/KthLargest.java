package Heap.KthLargest;

import java.util.*;

//Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//        Your Heap.KthLargest class will have a constructor which accepts an integer k and an integer array nums,
//        which contains initial elements from the stream. For each call to the method Heap.KthLargest.add,
//        return the element representing the kth largest element in the stream.
class KthLargest {

    List<Integer> list = new ArrayList();
    int k;

    public KthLargest(int k, int[] nums) {

        this.k = k;
        for(int num : nums)
        {
           list.add(num);
        }

    }

    public int add(int val) {
        list.add(val);
        list.sort(Comparator.reverseOrder());
        return list.get(k-1);
    }



    public static void main(String[] args) {
        int[] arr = {4,5,8,2};
        KthLargest kth = new KthLargest(3,arr);

        Scanner scanner =new Scanner(System.in);
        int n = 0;
        while (n != -1) {
            n =scanner.nextInt();
            System.out.println(kth.add(n));
        }

    }
}


//int k = 3;
//int[] arr = [4,5,8,2];
//Heap.KthLargest kthLargest = new Heap.KthLargest(3, arr);
//kthLargest.add(3);   // returns 4 [4,5,8,2,3];
//kthLargest.add(5);   // returns 5 [4,5,8,2,3,5];
//kthLargest.add(10);  // returns 5
//kthLargest.add(9);   // returns 8
//kthLargest.add(4);   // returns 8