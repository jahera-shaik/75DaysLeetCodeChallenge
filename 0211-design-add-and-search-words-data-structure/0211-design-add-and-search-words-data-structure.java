class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return backtrack(word, 0, root);
    }

    private boolean backtrack(String word, int index, TrieNode curr) {
        // Base Case: If we've reached the end of the search string
        if (index == word.length()) {
            return curr.isEndOfWord;
        }

        char c = word.charAt(index);

        if (c == '.') {
            // Wildcard: Try all 26 possible children
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    if (backtrack(word, index + 1, curr.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            // Normal character: Follow the specific path
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            return backtrack(word, index + 1, curr.children[idx]);
        }
    }
}