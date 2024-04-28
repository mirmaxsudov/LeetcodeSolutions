package tasks;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.HashMap;

class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        left = null;
        right = null;
    }

    @Override
    public int compareTo(HuffmanNode node) {
        return this.frequency - node.frequency;
    }
}

public class HuffmanEncoding {

    public static HashMap<Character, String> encode(String input) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray())
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);

        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>();

        for (char c : frequencyMap.keySet())
            minHeap.offer(new HuffmanNode(c, frequencyMap.get(c)));

        while (minHeap.size() > 1) {
            HuffmanNode left = minHeap.poll();
            HuffmanNode right = minHeap.poll();

            HuffmanNode merged = new HuffmanNode('\0', left.frequency + Objects.requireNonNull(right).frequency);
            merged.left = left;
            merged.right = right;
            minHeap.offer(merged);
        }

        HuffmanNode root = minHeap.poll();
        HashMap<Character, String> codeMap = new HashMap<>();
        generateCodes(root, "", codeMap);
        return codeMap;
    }

    private static void generateCodes(HuffmanNode node, String code, HashMap<Character, String> codeMap) {
        if (node == null) return;

        if (node.left == null && node.right == null)
            codeMap.put(node.character, code);

        generateCodes(node.left, code + "0", codeMap);
        generateCodes(node.right, code + "1", codeMap);
    }

    public static void main(String[] args) {
        String input = "12345678901234567890123456789012345678901234567890";
        HashMap<Character, String> codeMap = encode(input);

        System.out.println("Character Codes:");
        for (char c : codeMap.keySet())
            System.out.println(c + " : " + codeMap.get(c));
    }
}
