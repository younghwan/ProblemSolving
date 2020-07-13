package String.ComplexNumber;
class Solution {
    public String complexNumberMultiply(String a, String b) {

//        System.out.println(a);
//        System.out.println(b);
        return b;
    }

    public static void main(String[] args) {


        String a = "1+1i", b= "1+1i", c = "1+-1i", d = "1+-1i";

        String[] arr = d.split("\\+");
        String[] arrb = arr[1].split("i");

        System.out.println(arr[0]);
        System.out.println(arrb[0]);

        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arrb[0]);

        int sol_a = (n*n) - (m*m);
        int sol_b = 2*(n*m);

        System.out.println(sol_a);
        System.out.println(sol_b);



        String sol = Integer.toString(sol_a) + "+" + Integer.toString(sol_b) + "i";

        System.out.println(sol);

//        System.out.println(a.substring(a.lastIndexOf("+")+1,a.length()-1));

        System.out.println();

        Solution solution = new Solution();
        solution.complexNumberMultiply(a,b);

    }
}
