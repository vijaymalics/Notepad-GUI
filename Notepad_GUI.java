import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class NotepadGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Simple Notepad");
        JTextArea textArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(textArea);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");

        fileMenu.add(open);
        fileMenu.add(save);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.add(scroll);

        open.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedReader br = new BufferedReader(
                        new FileReader(fileChooser.getSelectedFile()));
                    textArea.read(br, null);
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        save.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedWriter bw = new BufferedWriter(
                        new FileWriter(fileChooser.getSelectedFile()));
                    textArea.write(bw);
                    bw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}