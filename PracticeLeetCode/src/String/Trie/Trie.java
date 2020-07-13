package String.Trie;

/*
 *  Java로 Trie구현
 */

class Trie {
    TrieNode root = new TrieNode();
    void insert(String[] words) {
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur.children[c - 'a'].strings.add(word);
                cur = cur.children[c - 'a'];
            }
        }
    }
}


