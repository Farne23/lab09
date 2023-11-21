package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame("Simple GUI with File Chooser");

    public SimpleGUIWithFileChooser(final Controller controller){
        JPanel canvas1 = new JPanel();
        canvas1.setLayout(new BorderLayout());
        JPanel canvas2 = new JPanel();
        canvas2.setLayout(new BoxLayout(canvas2, BoxLayout.LINE_AXIS));
        JTextArea textArea1 = new JTextArea();
        JButton button1 = new JButton("Save");
        JButton button2 = new JButton("Browse...");
        JTextField textField1 = new JTextField(controller.getCurrentFilePath());
        textField1.setEditable(false);

        frame.setContentPane(canvas1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas1.add(textArea1,BorderLayout.CENTER);
        canvas1.add(button1,BorderLayout.SOUTH);
        canvas2.add(textField1);
        canvas2.add(button2);
        canvas1.add(canvas2,BorderLayout.NORTH);


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

        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                var chosenOption = fileChooser.showOpenDialog(null);
                switch (chosenOption) {
                    case JFileChooser.APPROVE_OPTION:
                        var newFile = fileChooser.getSelectedFile();
                        controller.setCurrentFile(newFile);
                        textField1.setText(newFile.getPath());
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"An error occoured while trying to select the File!");
                        break;
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
        SimpleGUIWithFileChooser window = new SimpleGUIWithFileChooser(new Controller());
        window.display();
    }

}
