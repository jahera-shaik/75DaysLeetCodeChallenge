import java.util.*;

class Solution {
    // Standard Trie Node definition
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Stores the complete word at the leaf node
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int rows = board.length;
        int cols = board[0].length;

        // Kick off DFS from every single cell on the board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        // Boundary checks
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;

        char ch = board[r][c];
        // If the cell is already visited (#) or doesn't match the current Trie path
        if (ch == '#' || node.children[ch - 'a'] == null) return;

        // Move down the Trie to the child node
        node = node.children[ch - 'a'];

        // If we reached a leaf matching a word, capture it
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Optimization: avoid duplicate entries
        }

        // Mark the current cell as visited
        board[r][c] = '#';

        // Explore 4 directions: Up, Down, Left, Right
        dfs(board, r + 1, c, node, result);
        dfs(board, r - 1, c, node, result);
        dfs(board, r, c + 1, node, result);
        dfs(board, r, c - 1, node, result);

        // Backtrack: Restore the cell value
        board[r][c] = ch;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode current = root;
            for (char ch : w.toCharArray()) {
                int index = ch - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.word = w; // Store the word at the end node
        }
        return root;
    }
}