package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame("SimpleGUI");

    public SimpleGUI(final Controller controller){
        JPanel canvas = new JPanel();
        JTextArea textArea1 = new JTextArea();
        JButton button1 = new JButton("Save");
        canvas.setLayout(new BorderLayout());
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.add(textArea1,BorderLayout.CENTER);
        canvas.add(button1,BorderLayout.SOUTH);

        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea1.getText();
                try {
                    controller.printString(text);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null,"An error occoured while trying to print the String! "+e1.getMessage());
                }
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
        SimpleGUI window = new SimpleGUI(new Controller());
        window.display();
    }
}
