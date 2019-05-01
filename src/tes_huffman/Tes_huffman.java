/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tes_huffman;

import java.util.PriorityQueue;

/**
 *
 * @author Faiq Noor
 */
public class Tes_huffman {

    /**
     * @param args the command line arguments
     */
    public static HuffmanTree builTree(int[] charFreqs) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        
        for (int i = 0; i < charFreqs.length; i++) {
            if (charFreqs[i] > 0) {
                trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));
            }
        }
        
        assert trees.size() > 0;
        
        while (trees.size() > 1) {
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();
            
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }
    
    public static void printCodes(HuffmanTree tree, StringBuffer prefix) {
        assert tree != null;
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + prefix);
        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) tree;
            
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
            
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        String test = "abracadabra";
        int[] charFreqs = new int[256];
        
        for (char c : test.toCharArray()) {
            charFreqs[c] = charFreqs[c] + 1;
        }
        
        HuffmanTree tree = builTree(charFreqs);
        
        System.out.println("SYMBOL|WEIGHT|HUFFMAN CODE");
        printCodes(tree, new StringBuffer());
    }
    
}
