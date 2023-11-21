package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String currentString;
    private final List<String> history = new ArrayList<String>();


    @Override
    public void setNextStringToPrint(String string) {
        currentString = string;
    }

    @Override
    public String getNextStringToPrint() {
        return currentString;
    }

    @Override
    public List<String> getPrintedStringsHistory() {
        return history;
    }

    @Override
    public void printCurrentString() {
        if(currentString == null){
            throw(new IllegalStateException("No string to print set yet!"));
        }
        history.add(currentString);
        System.out.println(currentString);
    }
}
