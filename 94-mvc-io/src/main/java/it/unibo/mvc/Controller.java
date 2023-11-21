package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * Sets a string as the next to be printed
     * @param string //The string tht's gonna be set as the new String to be printed
     */
    void setNextStringToPrint(String string);

    /**
     * 
     * @return Next string that's going to be printed
     */
    String getNextStringToPrint();

    /**
     * @return The history of printed strings as a List
     */
    List<String> getPrintedStringsHistory();

    /**
     * Prints on the standard output a string
     */
    void printCurrentString();
}
