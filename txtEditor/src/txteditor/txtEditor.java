/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package txteditor;

import java.awt.Desktop;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;


public class txtEditor {

    private txtFile fileOpened;

    public void openFile() {
        String defaultDirectory = System.getProperty("user.dir");
        File homeDirectory = javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory();
        JFileChooser chooser = new JFileChooser(homeDirectory);
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File fileTobeOpened = chooser.getSelectedFile();
                fileOpened = new txtFile(fileTobeOpened);
            } catch (Exception ex) {
                System.err.println("Error : File is not a txt File!");
            }
        }
    }

    public void closeFile() {
        fileOpened = null;
    }

    private boolean checkIfOpened() {
        if (fileOpened != null) {
            return true;
        }
        return false;
    }
    
    public void DisplayStats(){
       if(checkIfOpened()){
        System.out.println("Opened File Name :"+fileOpened.getFileName());
        System.out.println("Opened File Size :"+fileOpened.getSize());
        System.out.println("Number of Characters : "+fileOpened.getNumberOfCharacters());
        System.out.println("Number of Lines : "+fileOpened.getNumberOfLines());
       }
    }
    
    public void printWordByWord(){
        if(checkIfOpened()){
        while(fileOpened.getIterator().hasNext()){
        System.out.println(fileOpened.getIterator().next());
        }
        }
    }

}
