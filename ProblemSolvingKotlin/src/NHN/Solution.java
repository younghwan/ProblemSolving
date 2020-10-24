package NHN;

public class Solution {
    public static void main(String[] args) {
        char[] circle = new char[5];
//65~90
        for (int i = 0; i < circle.length; i++) {
            circle[i] = (char) ((char) 66 + i);
        }

        for (int i = 0; i < circle.length; i++) {
            System.out.println(circle[i]);
        }

        int numsGame = 2;
        char[] quick= {'B','C'};
        int[] gamemove = {3,-2};


    }
}
