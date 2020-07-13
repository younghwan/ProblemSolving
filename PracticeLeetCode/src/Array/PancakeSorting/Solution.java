package Array.PancakeSorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    static void flip(int arr[], int i) {
        int temp, start = 0;
        while (start < i) {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }

    static int findMax(int arr[], int n) {
        int mi, i;
        for (mi = 0, i = 0; i < n; ++i)
            if (arr[i] > arr[mi])
                mi = i;
        return mi;
    }

    static int pancakeSort(int arr[], int n) {

        for (int curr_size = n; curr_size > 1; --curr_size) {
            int mi = findMax(arr, curr_size);
            if (mi != curr_size - 1) {
                flip(arr, mi);
                flip(arr, curr_size - 1);
            }
        }
        return 0;
    }

    void analyzeDescription() {
        final String description = "삼성전자가 다음 달 공개할 예정인 차기 갤럭시 S시리즈 중 한 모델로 추정되는 사진(사진)이 유출됐다.해외 개발자 커뮤니티 XDA디벨로퍼는 ‘갤럭시S20플러스’의 실물 사진을 입수했다며 12일(현지시간) 공개했다..";
        final Map<String, Integer> cacheMap = new HashMap<>();
        final String[] descriptionArray = description.split(" ");
        Arrays.sort(descriptionArray);

        String keyword = "";
        for (int i = 0; i < descriptionArray.length; i++) {
            keyword = descriptionArray[i];

            if (cacheMap.containsKey(keyword)) {
                cacheMap.put(keyword, cacheMap.get(keyword) + 1);
            } else {
                cacheMap.put(keyword, 1);
            }
        }
    }
}
