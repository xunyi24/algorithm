package leetcode;

import java.util.*;

public class Trie208 {
    public static void main(String[] args) {
        Trie208 trie208 = new Trie208();
        Set<String> keywords = new HashSet<>();
        keywords.add("王八羔子");
        keywords.add("王八蛋王");
        keywords.add("吃饭");
        trie208.buildTrie(keywords);
        System.out.println(trie);
    }


    boolean isEnd;
    Trie208[] children;
    /** Initialize your data structure here. */
    public Trie208() {
        isEnd = false;
        children = new Trie208[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie208 node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie208();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie208 node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] != null) {
                node = node.children[index];
                // 这里是只要给定的单词里有敏感词就会判断出; 如果将这里注释, 在代码最后一行判断的话就是判断给定的单词是全部匹配的
                if (node.isEnd) return true;
            }
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie208 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return true;
    }


    // 自己用hash实现的字典树，与本题无关
    static Map<String, Object> trie;
    private void buildTrie(Set<String> keywords) {
        trie = new HashMap<>(keywords.size() * 2);
        Map curMap;

        for (String s : keywords) {
            curMap = trie;
            for (int i = 0; i < s.length(); i++) {
                char keywordChar = s.charAt(i);
                Object wordMap = curMap.get(keywordChar);
                if (wordMap != null) {
                    curMap = (Map) wordMap;
                } else {
                    Map<String, String> newWordMap = new HashMap<>();
                    newWordMap.put("isEnd", "0");
                    curMap.put(keywordChar, newWordMap);
                    curMap = newWordMap;
                }
                // 如果达到最后一个字符设置end标记
                if (i == s.length() - 1) curMap.put("isEnd", "1");
            }
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
