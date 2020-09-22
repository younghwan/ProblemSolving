package Study.문자열매칭알고리즘;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Trie {

    private TrieNode rootNode;

    Trie() {
        rootNode = new TrieNode();
    }

    // 특정 단어 추
    void insert(String word) {
        TrieNode thisNode = this.rootNode;

        for (int i = 0; i < word.length(); i++) {
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        thisNode.setLastChar(true);
    }

    // 특정단어가 들어있는지 확인가
    boolean contains(String word) {
        TrieNode thisNode = this.rootNode;

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            TrieNode node = thisNode.getChildNodes().get(character);
            if (node == null) return false;

            thisNode = node;
        }
        return thisNode.isLastChar();
    }

    void delete(String word) {
        delete(this.rootNode, word, 0); // 최초로 delete 던지는 부분
    }

    private void delete(TrieNode thisNode, String word, int index) {
        char character = word.charAt(index);
        if (thisNode.getChildNodes().containsKey(character))
            throw new Error("There is no [" + word + "] in this Trie");

        TrieNode childNode = thisNode.getChildNodes().get(character);
        index++;

        if (index == word.length()) {
            // 노드는 존재하지만 insert한 단어가 아닌경우 에러출
            if (!childNode.isLastChar()) throw new Error("There is no [" + word + "] in this Trie");

            childNode.setLastChar(false);
            // 삭제 대상 언어의 제일 끝으로서 자식 노드가(이 단어를 포함한 더 긴단어가) 없으면 삭제 시작
            if (childNode.getChildNodes().isEmpty())
                thisNode.getChildNodes().remove(character);


        } else {
            delete(childNode, word, index); // 콜백함수부분
            //삭제중 자식노드가 없고 현재 노드로 끝나는 다른 단어가 없는 경우 이 노드 삭제
            if (!childNode.isLastChar() && childNode.getChildNodes().isEmpty())
                thisNode.getChildNodes().remove(character);
        }
    }
    boolean isRootEmpty(){
        return this.rootNode.getChildNodes().isEmpty();
    }
}

// TireNode는 자식노드맵과 현재 노드가 마지막 글자인지 여부에 대한 정보를 갖고있다.
class TrieNode {
    private Map<Character, TrieNode> childNodes = new HashMap<>();
    private boolean isLastChar;

    public Map<Character, TrieNode> getChildNodes() {
        return childNodes;
    }

    public boolean isLastChar() {
        return isLastChar;
    }

    public void setLastChar(boolean lastChar) {
        isLastChar = lastChar;
    }
}

class TestTrie {
    @Test
    public void trieTest() {
        Trie trie = new Trie();
// insert 메서드
        assertTrue(trie.isRootEmpty());
        trie.insert("PI");
        trie.insert("PIE");
        trie.insert("POW");
        trie.insert("POP");
        assertFalse(trie.isRootEmpty());
// Contains 메서드
        assertTrue(trie.contains("POW"));
        assertFalse(trie.contains("PIES"));
// Delete 메서드
        trie.delete("POP");
        assertFalse(trie.contains("POP"));
        assertTrue(trie.contains("POW"));
// 없는 단어를 지울 때 > 에러발생하는 예
        trie.delete("PO");
        trie.delete("PIES");
        trie.delete("PEN");
    }
}

