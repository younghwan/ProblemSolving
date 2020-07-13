package String.Trie;

import java.util.ArrayList;
import java.util.List;

class TrieNode {

    List<String> strings;
    boolean isTerminal;
    int count;
    TrieNode[] children;

    /* Constructor */
    public TrieNode() {
        children = new TrieNode[26];
        isTerminal = false;
        strings = new ArrayList<>();
        count = 0;
    }
}//End Class TrieNode
