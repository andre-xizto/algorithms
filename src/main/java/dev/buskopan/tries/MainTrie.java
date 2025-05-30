package dev.buskopan.tries;

public class MainTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("CADA");
        trie.insert("CASA");
        trie.insert("CARA");

        System.out.println(trie.contains("cada"));
        System.out.println(trie.startsWith("car"));
        System.out.println(trie.suggest("ca"));
    }
}
