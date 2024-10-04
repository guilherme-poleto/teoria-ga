package algoritmos;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {

    int data; //frequência
    char c;
    Node left;
    Node right;

    public Node(int data, char c) {
        this.data = data;
        this.c = c;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(Node node) {
        return this.data - node.data;
    }
}

public class Huffman implements Algorithm {

    private Map<Character, String> huffmanCode = new HashMap<>();
    private Node root;

    private void buildHuffmanTree(Map<Character, Integer> charFreqMap) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> entry : charFreqMap.entrySet()) {
            priorityQueue.add(new Node(entry.getValue(), entry.getKey()));
        }

        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
            Node newNode = new Node(left.data + right.data, '\0');
            newNode.left = left;
            newNode.right = right;
            priorityQueue.add(newNode);
        }
        root = priorityQueue.poll();
    }
    
    private void generateCodes(Node node, String code) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            huffmanCode.put(node.c, code);
        }

        generateCodes(node.left, code + "0");
        generateCodes(node.right, code + "1");
    }

    public String encodeNumber(int n) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            charFreqMap.put((char) (i + '0'), 10 - i);
        }

        buildHuffmanTree(charFreqMap);

        generateCodes(root, "");

        StringBuilder encodedString = new StringBuilder();
        String numberString = Integer.toString(n);

        for (char digit : numberString.toCharArray()) {
            encodedString.append(huffmanCode.get(digit));
        }

        return encodedString.toString();
    }

    public int decodeBinary(String message) {
        StringBuilder decodedString = new StringBuilder();
        Node currentNode = root;

        for (char bit : message.toCharArray()) {
            currentNode = (bit == '0') ? currentNode.left : currentNode.right;

            if (currentNode.left == null && currentNode.right == null) {
                decodedString.append(currentNode.c);
                currentNode = root;
            }
        }

        return Integer.parseInt(decodedString.toString());
    }
}
