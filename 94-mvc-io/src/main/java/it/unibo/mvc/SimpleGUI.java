package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame("Simple I/O GUI");

    public SimpleGUI(Controller controller){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel canvas1 = new JPanel();
        canvas1.setLayout(new BorderLayout());
        JTextField newString = new JTextField();
        canvas1.add(newString,BorderLayout.NORTH);
        JTextArea historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);
        canvas1.add(historyTextArea,BorderLayout.CENTER);
        JButton printButton = new JButton("Print");
        JButton showHistoryButton = new JButton("ShowHistory");
        JPanel canvas2 = new JPanel();
        canvas2.setLayout(new BorderLayout());
        canvas2.add(printButton,BorderLayout.CENTER);
        canvas2.add(showHistoryButton,BorderLayout.EAST);
        canvas1.add(canvas2,BorderLayout.SOUTH);

        frame.setContentPane(canvas1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        printButton.addActionListener(new ActionListener() {
      
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setNextStringToPrint(newString.getText());
                controller.printCurrentString();
            }  
        });

        showHistoryButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final List<String> history = controller.getPrintedStringsHistory(); 
                String historyText = "";
                for (String historyElement : history) {
                    historyText += (historyElement + "\n");
                }
                historyTextArea.setText(historyText);
            }
        });
    }

    public void display(){
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);     
        frame.setVisible(true);
    }

    public static void main(String... args) {
        SimpleGUI window = new SimpleGUI(new SimpleController());
        window.display();
    }
}
