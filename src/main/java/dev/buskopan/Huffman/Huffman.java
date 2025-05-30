package dev.buskopan.Huffman;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static dev.buskopan.Huffman.HuffmanNode.*;

public class Huffman {
    public static void main(String[] args) {
        String text = "hello huffman";

        // 1. Frequência dos caracteres
        Map<Character, Integer> frequency = calculateFrequency(text);

        // 2. Construir a árvore de Huffman
        HuffmanNode root = buildTree(frequency);

        // 3. Gerar os códigos de Huffman
        Map<Character, String> codes = new HashMap<>();
        generateCodes(root, "", codes);

        // 4. Compactar o texto
        String compressed = compress(text, codes);

        // Exibir os resultados
        System.out.println("Frequências: " + frequency);
        System.out.println("Códigos: " + codes);
        System.out.println("Texto Compactado: " + compressed);

        printTree(root, "");

        System.out.println("Tamanho do texto: " + text.length());
        System.out.println("Bytes: " + text.getBytes(StandardCharsets.UTF_8).length);

        System.out.println("Tamanho comprimido: " + compressed.length());
        System.out.println("Bytes comprimido: " + (compressed.length() + 7) / 8);


    }

    private static Map<Character, Integer> calculateFrequency(String text) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }

    public static void printTree(HuffmanNode node, String prefix) {
        if (node == null) return;

        // Se for uma folha, exiba o caractere e sua frequência
        if (node.left == null && node.right == null) {
            System.out.println(prefix + "└── [" + node.character + ":" + node.frequency + "]");
        } else {
            System.out.println(prefix + "└── (" + node.frequency + ")");
        }

        // Subárvores
        printTree(node.left, prefix + "    ");
        printTree(node.right, prefix + "    ");
    }

}
