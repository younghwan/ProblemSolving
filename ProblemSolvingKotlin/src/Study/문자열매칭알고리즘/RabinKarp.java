package Study.문자열매칭알고리즘;

// 항상 빠르지는 않지만 해시함수가 좋은 경우 O(n+m), 해시함수가 안좋은경우 O(n * m) BruteForce와 동일
public class RabinKarp {

    void findString(String parent, String pattern) {
        int parentSize = parent.length();
        int patternSize = pattern.length();
        int parentHash = 0, patternHash = 0, power = 1;

        for (int i = 0; i <= parentSize - patternSize; i++) {
            if (i == 0) {
                for (int j = 0; j < patternSize; j++) {
                    parentHash = parentHash + parent.toCharArray()[patternSize - 1 - j] * power;
                    patternHash = patternHash + pattern.toCharArray()[patternSize - 1 - j] * power;
                    if (j < patternSize - 1) power = power * 2;
                }
            } else {
                parentHash = 2 * (parentHash - parent.toCharArray()[i - 1] * power) +
                        parent.toCharArray()[patternSize - 1 + i];
            }
            if (parentHash == patternHash) {
                boolean finded = true;
                for (int j = 0; j < parentSize; j++) {
                    if (parent.toCharArray()[i + j] != pattern.toCharArray()[j])
                        finded = false;
                    break;
                }
                if (finded) {
                    System.out.println(i + 1 + "번째에서 발견했습니다.");
                }
            }

        }
    }

    public static void main(String[] args) {
        String parent = "ababcbcbcbababab";
        String pattern = "cbcb";
        RabinKarp rabinKarp = new RabinKarp();
        rabinKarp.findString(parent,pattern);
    }
}
