/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tes_huffman;

/**
 *
 * @author Faiq Noor
 */
abstract class HuffmanTree implements Comparable<HuffmanTree> {
    
    public final int frequency;
    
    public HuffmanTree(int freq) {
        frequency = freq;
    }

    @Override
    public int compareTo(HuffmanTree tree) {
        return frequency - tree.frequency;
    }
    
}
