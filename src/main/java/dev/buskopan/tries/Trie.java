package dev.buskopan.tries;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie {
    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        String wordLowerCase = word.toLowerCase();
        for (char c : wordLowerCase.toCharArray()) {
            node.getChildren().putIfAbsent(c, new TrieNode());
            node = node.getChildren().get(c);
        }

        node.setLeaf(true);
    }

    public boolean contains (String word) {
        TrieNode node = root;
        String wordLowerCase = word.toLowerCase();
        for (char c : wordLowerCase.toCharArray()) {
            if (!node.getChildren().containsKey(c)) return false;
            node = node.getChildren().get(c);
        }

        return node.isLeaf();
    }

    public boolean startsWith (String prefix) {
        TrieNode node = root;
        String prefixLowerCase = prefix.toLowerCase();
        for (char c : prefixLowerCase.toCharArray()) {
            if (!node.getChildren().containsKey(c)) return false;
            node = node.getChildren().get(c);
        }

        return true;
    }

    public List<String> suggest (String prefix) {
        TrieNode node = root;
        List<String> results = new ArrayList<>();
        if (!startsWith(prefix)) return results;

        for (char c : prefix.toCharArray()) {
            if (!node.getChildren().containsKey(c)) return results;
            node = node.getChildren().get(c);
        }

        searchSuggestions(node,prefix,results);

        return results;
    }

    private void searchSuggestions(TrieNode node, String prefix, List<String> results) {
        if (node.isLeaf()) results.add(prefix);
        for (Map.Entry<Character, TrieNode> otherNode : node.getChildren().entrySet()) {
            searchSuggestions(otherNode.getValue(), prefix + otherNode.getKey(), results);
        }
    }
}
