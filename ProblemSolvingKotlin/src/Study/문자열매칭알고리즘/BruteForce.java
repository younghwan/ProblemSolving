package Study.문자열매칭알고리즘;


import java.lang.reflect.Array;

// 문자열 T의 각각의 가능한 위치에 대하여 유형P 가 일치하는지 검사
// 시간복잡도 O(n x m)
public class BruteForce {
    int BruteForceStringMatch(int T[], int n, int P[], int m) {
        for (int i = 0; i < n - m; i++) {
            int j = 0;
            while (j < m && P[j] == T[i + j]) {
                j = j + 1;
                if (j == m)
                    return i;
            }
        }
        return -1;
    }
}
