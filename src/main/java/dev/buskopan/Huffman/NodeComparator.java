package dev.buskopan.Huffman;

import java.io.Serializable;
import java.util.Comparator;

public class NodeComparator implements Comparator<HuffmanNode>, Serializable {

    public static long serialVersionUID = 1L;

    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {
        return o1.frequency - o2.frequency;
    }
}
