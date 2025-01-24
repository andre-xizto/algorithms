package dev.buskopan.Huffman;

import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanNode {
    char character;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public static HuffmanNode buildTree(Map<Character, Integer> frequency) {
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(new NodeComparator());
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            queue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (queue.size() > 1) {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();
            HuffmanNode merged = new HuffmanNode('\0', left.frequency + right.frequency);
            merged.left = left;
            merged.right = right;
            queue.add(merged);
        }
        return queue.poll();
    }

    public static void generateCodes(HuffmanNode node, String code, Map<Character, String> codes) {
        if (node == null) return;

        // Se é uma folha, associa o código ao caractere
        if (node.left == null && node.right == null) {
            codes.put(node.character, code);
        }

        generateCodes(node.left, code + "0", codes);
        generateCodes(node.right, code + "1", codes);
    }

    public static String compress(String text, Map<Character, String> codes) {
        StringBuilder compressed = new StringBuilder();
        for (char c : text.toCharArray()) {
            compressed.append(codes.get(c));
        }
        return compressed.toString();
    }



}
