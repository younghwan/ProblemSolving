package DFS.LetterTile;

import java.util.HashSet;

public class Solution {

    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        String str = "AAABBC";

        System.out.println(DFS("", str));
    }

    private static int DFS(String path, String tiles) {

        if (!set.contains(path)) {
            if (path != "") set.add(path);
            for (int i = 0; i < tiles.length(); i++) {

                DFS(path.concat(Character.toString(tiles.charAt(i))), tiles.substring(0, i) + tiles.substring(i + 1));

            }
        }
        return set.size();
    }
}
