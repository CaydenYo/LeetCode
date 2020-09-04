package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/6 5:34 下午
 */

/**
 * Trie是一颗非典型的多叉树模型，
 * 多叉即每个结点的分支数量可能为多个。
 * 非典型是因为它的孩子节点是一个字母映射表(大小为26的TrieNode数组)
 * TrieNode中结点并没有直接保存字符值的数据成员，
 * TrieNode[] next中保存了对当前结点而言下一个可能出现的所有字符的链接
 * 因此我们可以通过一个父节点来预知它所有子节点的值
 * 注意：其中isEnd表示了该节点是否是一个从根节点到该节点组成的一个字符串的结束
 * 例如：
 * t(false) -> r(false) -> i(false) -> e(true) 表示包含了了trie这个单词
 * */
public class Trie208 {
    class TrieNode{
        private boolean isEnd;
        TrieNode[] next;

        public TrieNode(){
            isEnd = false;
            next = new TrieNode[26];
        }
    }

    private TrieNode root;
    public Trie208() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()){
            if (node.next[c - 'a'] == null){
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()){
            node = node.next[c - 'a'];
            if (node == null){
                return false;
            }
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()){
            node = node.next[c - 'a'];
            if (node == null){
                return false;
            }
        }
        return true;
    }
}
