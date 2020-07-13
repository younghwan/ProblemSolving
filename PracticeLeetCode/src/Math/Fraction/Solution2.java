package Math.Fraction;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public String fractionAddition(String expression) {
        //"-1/2+1/2"
        String[] inputs = expression.split("(?=[-+])"); // split
        String ans = "";
        //input[0] =  -1/2 , input[1] = +1/2

        List<Integer> numList = new ArrayList();
        List<Integer> denList = new ArrayList();

        for (int i = 0; i < inputs.length; i++) {
            numList.add(Integer.parseInt(inputs[i].split("/")[0]));
            denList.add(Integer.parseInt(inputs[i].split("/")[1]));
        }
        int t = denList.get(0);
        int lcm = 0;
        int num = 0;
        for (int i = 0; i < denList.size(); i++) {
            lcm = t * denList.get(i) / GCD(t, denList.get(i));
            t = lcm;
        }
        System.out.println(lcm);

        for (int i = 0; i < numList.size(); i++) {
            num += (numList.get(i) * (lcm / denList.get(i)));
        }

//-1/6 num = -1 , lcm = 6 , gcd = -1
        int gcd = GCD(lcm, num);
        ans += Integer.toString(num / gcd) + "/" + Integer.toString(lcm / gcd);

        return ans;

    }


    public int GCD(int a, int b) {
        if (b == 0) return Math.abs(a);
        return GCD(b, a % b);
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        BigInteger b1 = new BigInteger("-1");
        BigInteger b2 = new BigInteger("6");

        String n1 = "-1/2+1/2";
        String n2 = "1/3-1/2";
        String n3 = "-7/3";
//        System.out.println(solution.fractionAddition(n1));
//        System.out.println(solution.fractionAddition(n2));
        System.out.println(solution.fractionAddition(n3));
    }
}