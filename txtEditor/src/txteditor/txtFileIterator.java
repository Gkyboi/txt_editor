/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package txteditor;

import java.util.Iterator;
import java.util.List;


public class txtFileIterator implements Iterator<String>{

    List<String> words;
    int wordCount;

    public txtFileIterator(List<String> words) {
        this.words = words;
        this.wordCount = 0;
    }
    
    
    @Override
    public boolean hasNext() {
        return !(this.wordCount == words.size());
    }

    @Override
    public String next() {
        String word =words.get(wordCount); 
        wordCount++;
        return word;
    }
    
}
