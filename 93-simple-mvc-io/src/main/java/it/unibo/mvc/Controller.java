package it.unibo.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String USER_HOME = System.getProperty("user.home");
    private static final String FILE_SEPARATOR = File.separator;
    private static final String DEFAULT_CURRENT_FILE = "output.txt";

    private File currentFile;

    /**
     * 0 Parameters constuctor, current File is set as the output.txt file in the user home directory
     */
    public Controller(){
        currentFile = new File(USER_HOME + FILE_SEPARATOR + DEFAULT_CURRENT_FILE);
    }

    /**
     * Sets the current file as the new file
     * @param file /The file to set as currente
     */
    public void setCurrentFile(File file){
        currentFile = file;
    }

    /**
     * Gets the current file
     * @return /The current file
     */
    public File getCurrentFile(){
        return currentFile;
    }

    /**
     * @return Path of the current file as a String
     */
    public String getCurrentFilePath(){
        return currentFile.getPath();
    }

    /**
     * this method uses a PrintStream to write on the current file a 
     * new string
     * @param string The string which is going to be pritned
     * @throws IOException 
     */
    public void printString(String string) throws IOException{
        try(PrintStream ps = new PrintStream(currentFile,StandardCharsets.UTF_8)){
            ps.print(string);
        }
    }
}
