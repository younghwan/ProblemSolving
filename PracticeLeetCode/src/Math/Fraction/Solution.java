package Math.Fraction;

public class Solution {
    public String fractionAddition(String expression) {
        //"-1/2+1/2"
        String[] inputs = expression.split("(?=[-+])"); // split
        //input[0] =  -1/2 , input[1] = +1/2

        int numerator, denominator;
        char[] first = inputs[0].toCharArray();
        if (first[0] != '-') {
            String[] parts = inputs[0].split("/");
            numerator = Integer.parseInt(parts[0]);
            denominator = Integer.parseInt(parts[1]);
        } else {
            String[] parts = inputs[0].substring(1).split("/");
            numerator = -Integer.parseInt(parts[0]);
            denominator = Integer.parseInt(parts[1]);
        }

        for (int i = 1; i < inputs.length; i++) {

            String[] parts = inputs[i].substring(1).split("/");

            int cnum = Integer.parseInt(parts[0]); // 1
            int cden = Integer.parseInt(parts[1]); // 2

            if (inputs[i].charAt(0) == '+') {
                //Addition
                numerator = numerator * cden + denominator * cnum;
                denominator = denominator * cden;

            } else {
                //Minus
                numerator = numerator * cden - denominator * cnum;
                denominator = denominator * cden;

            }
        }

        int temp = 0;
        boolean sign = true;
        if (numerator < 0) {
            sign = false;
            numerator *= -1;
        }
        if (numerator > denominator) {
            temp = numerator / denominator;
            numerator = numerator % denominator;
        } else if (numerator == denominator) {
            if (sign) {
                return "" + Integer.toString(1) + "/" + Integer.toString(1);
            } else {
                return "-" + Integer.toString(1) + "/" + Integer.toString(1);
            }
        }
        int gcd = GCD(denominator, numerator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        numerator += temp * denominator;

        if (sign) {
            return "" + Integer.toString(numerator) + "/" + Integer.toString(denominator);
        } else {
            return "-" + Integer.toString(numerator) + "/" + Integer.toString(denominator);
        }
    }

    public int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String n1 = "-1/2+1/2";
        String n2 = "-1/2+1/2+1/3";
        String n3 = "-4/3-2/3";
//        System.out.println(solution.fractionAddition(n1));
//        System.out.println(solution.fractionAddition(n2));
        System.out.println(solution.fractionAddition(n3));
    }
}