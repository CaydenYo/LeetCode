package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/7/9 11:43 上午
 */
public class Respace {
    /**
     * 无优化动态规划：
     * 每遍历一个元素时就先初始化为前面的基础上+1
     * 因为我们这个时候还不知道能否组成单词，先无脑+1
     * 然后遍历字典的单词，取[i - 单词长度, i]看看是否相匹配
     * 如果匹配则我们需要消除这个单词的字符长度，即当前dp[i] = dp[i - 单词长度]
     * */
    public int respace(String[] dictionary, String sentence) {
        int slen = sentence.length();
        int[] dp = new int[slen + 1];
        dp[0] = 0;
        for (int i = 1; i <= slen; i++) {
            dp[i] = dp[i - 1] + 1;
            for (String word : dictionary) {
                int wlen = word.length();
                if (wlen <= i && word.equals(sentence.substring(i - wlen, i))) {
                    dp[i] = Math.min(dp[i], dp[i - wlen]);
                }
            }
        }
        return dp[slen];
    }


    /**
     * 字典树trie
     * */

    class Trie{
        class TrieNode{
            boolean isEnd;
            TrieNode[] next;

            public TrieNode(){
                isEnd = false;
                next = new TrieNode[26];
            }
        }

        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            TrieNode curr = root;
            for (int i = word.length() - 1;i >= 0;i--){
                int c = word.charAt(i) - 'a';
                if (curr.next[c] == null) {
                    curr.next[c] = new TrieNode();
                }
                curr = curr.next[c];
            }
            curr.isEnd = true;
        }

        public List<Integer> search(String sentence, int endPos){
            List<Integer> indices = new ArrayList<>();
            TrieNode curr = root;
            for (int i = endPos;i >= 0;i--){
                if (curr.next[sentence.charAt(i) - 'a'] == null){
                    break;
                }
                curr = curr.next[sentence.charAt(i) - 'a'];
                if (curr.isEnd){
                    indices.add(i);
                }
            }
            return indices;
        }
    }

    public int respace1(String[] dictionary, String sentence) {
        // 构建字典树
        Trie trie = new Trie();
        for (String word : dictionary){
            trie.insert(word);
        }
        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = 1;i <= n;i++){
            dp[i] = dp[i - 1] + 1;
            for (int index : trie.search(sentence, i - 1)){
                dp[i] = Math.min(dp[i], dp[index]);
            }
        }
        return dp[n];
    }
}
