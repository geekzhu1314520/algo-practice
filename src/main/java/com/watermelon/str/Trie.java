package com.watermelon.str;

/**
 * <h1>Trie</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/13
 */
public class Trie {

    
    /**
     * Trie树的根节点
     */
    private TrieNode root;

    /**
     * 构造函数,初始化Trie树的根节点
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * 向Trie树中插入一个单词
     * @param word 要插入的单词
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * 查找Trie树中是否存在完全匹配的单词
     * @param word 要查找的单词
     * @return 存在返回true,否则返回false
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /**
     * 查找Trie树中是否有以给定前缀开头的单词
     * @param prefix 给定的前缀
     * @return 存在返回true,否则返回false
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    /**
     * 查找给定前缀在Trie树中的最后一个节点
     * @param prefix 要查找的前缀
     * @return 如果存在返回对应节点,否则返回null
     */
    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children[c - 'a'];
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    /**
     * Trie树节点类
     */
    class TrieNode {
        /**
         * 子节点数组,存储26个小写字母
         */
        private TrieNode[] children;

        /**
         * 标记该节点是否为单词的结尾
         */
        private boolean isEnd;

        /**
         * 构造函数,初始化节点
         */
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

}