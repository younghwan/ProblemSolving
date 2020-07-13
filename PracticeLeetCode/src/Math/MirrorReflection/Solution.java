package Math.MirrorReflection;

public class Solution {
    public int mirrorReflection(int p, int q) {
        if (p % q == 0) {
            if ((p / q) % 2 == 1) return 1;
            else return 2;
        }
        int gcd = GCD(p, q);
        p /= gcd;
        q /= gcd;
        if (p % 2 == 1 && q % 2 == 1) return 1;
        if (p % 2 == 1 && q % 2 == 0) return 0;
        if (p % 2 == 0 && q % 2 == 1) return 2;

        return -1;
    }

    public int GCD(int big, int small) {
        if (small == 0) return big;
        int B = small;
        int S = big % small;
        return GCD(B, S);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.GCD(458, 446));
        solution.mirrorReflection(458, 446);
    }
}