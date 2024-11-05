/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package txteditor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class txtFile implements FileInterface {

    private File file;
    Iterator<String> iterator;
    List<String> wordList;

    public txtFile(File file) throws Exception {
        if (checkFileExtension(file)) {
            this.file = file;
            this.wordList = new ArrayList<>();
            loadContentsIntoList();
            this.iterator = new txtFileIterator(wordList);
        }
        else{
          throw new Exception("Document is not txt!");
        }
    }

    private boolean checkFileExtension(File file) {
        int lastDotPosition = file.getName().lastIndexOf(".");
        String extension = file.getName().substring(lastDotPosition + 1);
        if (extension.equals("txt")) {
            return true;
        }
        return false;
    }
    
    private void loadContentsIntoList() throws FileNotFoundException {
       
            Scanner input = new Scanner(file);
            
            while (input.hasNext()) {
                wordList.add(input.next());
            }
        
    }

    @Override
    public Iterator<String> getIterator() {
        return this.iterator;
    }
    
    public String getFileName(){
       return file.getName();
    }
    
    public String getSize(){
       double bytesize =  file.length();
       double kilobytes = (double) (bytesize / 1024); 
       return String.format("%.2f KB", kilobytes);
    }
    
    public int getNumberOfCharacters(){
       int count = 0;
        for (int i = 0; i < wordList.size(); i++) {
           count += wordList.get(i).length();
        }
        return count;
    }
    
    public int getNumberOfLines(){
         int count = 0;
        try {
            Scanner secScanner = new Scanner(file);
            while (secScanner.hasNextLine()) {
               secScanner.nextLine();
               count++;
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error while counting lines!");
        }
      return count;
    }
    

}
