package String.Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
Given an array of strings products and a string searchWord.
We want to design a system that suggests at most three product names from products after each character of searchWord is typed.
Suggested products should have common prefix with the searchWord.
If there are more than three products with a common prefix return the three lexicographically minimums products.
Return list of lists of the suggested products after each character of searchWord is typed.

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]

Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
 */
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();

        Trie trie = new Trie();
        trie.insert(products);
        TrieNode cur = trie.root;
        boolean flag = true;
        for (char c : searchWord.toCharArray()) {
            List<String> list = new ArrayList<>();
            if (flag && cur.children[c - 'a'] != null) {
                Collections.sort(cur.children[c - 'a'].strings);
                for (String s : cur.children[c - 'a'].strings) {
                    list.add(s);
                    if (list.size() == 3) {
                        break;
                    }
                }
                cur = cur.children[c - 'a'];
            } else {
                flag = false;
            }
            res.add(list);
        }
        return res;
    }
}