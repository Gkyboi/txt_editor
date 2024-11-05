/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package txteditor;

import java.io.File;
import java.util.Iterator;
import javax.swing.JFileChooser;


public class Main {
    public static void main(String[] args) {
         txtEditor editor = new txtEditor();
         editor.openFile();
         editor.DisplayStats();
         editor.printWordByWord();
    }
}
