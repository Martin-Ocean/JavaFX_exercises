/*
* Create by Ming Gong
* Chapter 20
* Display Words in ascending order
*
*
* this program will first create a J swing window
* user enter file name and hit "enter"
* the file will be created and populated with dumme text
*     "duis tristique sollicitudin nibh sit amet commodo nulla facilisi nullam"
* it will return a sorted list in console
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.Formatter;


public class displayWordsInAscendingOrder {
    String[] words;
    static String name = "";
    static JTextField nameTextField = new JTextField(20);
    static JFrame frame = new JFrame();

    public void setName(String name) {
        this.name = name;
    }

    public void createFile() {
        Formatter file;
        try {
            file = new Formatter(String.format(name));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void populateFile() {
        FileOutputStream out;
        PrintStream prt;
        try {
            out = new FileOutputStream(name);
            prt = new PrintStream(out);
            prt.println("duis tristique sollicitudin nibh sit amet commodo nulla facilisi nullam");
            prt.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void readFile() {
        try {
            FileInputStream inStream = new FileInputStream(this.name);
            BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
            while (in.ready()) {
                words = in.readLine().split(" ");
                Arrays.sort(words);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void print() {
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println("");
    }

    public void UI() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Sort Ascending");
        frame.setLocation(600, 500);
        frame.setSize(500, 100);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();

        JLabel label = new JLabel("Enter a name for the file");
        grid.gridx = 0;
        grid.gridy = 0;
        grid.insets = new Insets(2, 10, 10, 10);

        panel.add(label, grid);
        panel.add(nameTextField);

        JButton button = new JButton("Enter");
        grid.gridx = 1;
        grid.gridy = 1;
        panel.add(button, grid);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed();
            }
        });

        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    public void buttonPressed() {
        displayWordsInAscendingOrder.name = nameTextField.getText();
        displayWordsInAscendingOrder run = new displayWordsInAscendingOrder();
        run.createFile();
        run.populateFile();
        run.readFile();
        run.print();
    }

    public static void main(String[] args) {
        new displayWordsInAscendingOrder().UI();
    }

}
