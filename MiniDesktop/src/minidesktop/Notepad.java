package minidesktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

/*
    Step 2 Starts from here
*/

public class Notepad extends KeyAdapter implements ActionListener
{
   static int act = 0;
   static int fs = 17;

   JFrame f1;
   JMenuBar nMenuBar;
   JMenu taskfile, taskedit, taskformat, taskview,taskcolor;
   JMenuItem ndoc, odoc, nexit, sdoc, sadoc, cdoc, pdoc, rdoc, fontfam, fontsty, fontsz, fstatus,prdoc,bgcol,txtcol;
   JTextArea maintxt;
   JTextField mytitle;
   Font ft1;
   JPanel btm;
   JLabel detail, pcdoc;
  
   JScrollPane sbb;

   String familyval[] = { "Agency  FB", "Antiqua", "Architect", "Arial", "Calibri", "Comic Sans", "Courier", "Cursive", "Impact", "Serif" };
   String sizeval[] = { "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70" };
   int[] styleval = { Font.PLAIN, Font.BOLD, Font.ITALIC };
   String[] stylevals = { "PLAIN", "BOLD", "ITALIC" };

   JList famlist = new JList(familyval);
   JList stylist = new JList(stylevals);
   JList szlist = new JList(sizeval);
   String ffamily, fsstr, fstylestr;
   
   int fstyle;
   int cl;
   int linecount;
   String tle;
   String topicstitle = "";
   JScrollPane sp;

   JColorChooser co_ch;
   

   Notepad() 
   {
      f1 = new JFrame("Notepad");

      ft1 = new Font("Arial", Font.PLAIN, 17);

      btm = new JPanel();
      detail = new JLabel();
      pcdoc = new JLabel();

      // famlist = new JList(familyval);
      // stylist = new JList(stylevals);
      // szlist = new JList(sizeval);

      famlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      szlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      stylist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      btm.add(detail);

      maintxt = new JTextArea();



      sp = new JScrollPane(maintxt);
      mytitle = new JTextField(100);

      sbb = new JScrollPane(maintxt);

      maintxt.setMargin(new Insets(5, 5, 5, 5));

      maintxt.setFont(ft1);
      f1.add(sbb);

      nMenuBar = new JMenuBar();

      taskfile = new JMenu("File");
      taskedit = new JMenu("Edit");
      taskformat = new JMenu("Format");
      taskview = new JMenu("View");
      taskcolor = new JMenu("color");

      ndoc = new JMenuItem("New Document");
      odoc = new JMenuItem("Open Document");
      sdoc = new JMenuItem("Save Document");
      sadoc = new JMenuItem("Save As Document");
      prdoc = new JMenuItem("Print Document");
      nexit = new JMenuItem("Exit");

      cdoc = new JMenuItem("Copy Document");
      rdoc = new JMenuItem("Remove Document");
      pdoc = new JMenuItem("Paste Document");

      fontfam = new JMenuItem("Set Font Family");
      fontsty = new JMenuItem("Set Font Style");
      fontsz = new JMenuItem("Set Font Size");
      fstatus = new JMenuItem("Status");

      bgcol = new JMenuItem("Bg Color");
      txtcol = new JMenuItem("txt Color");

      taskfile.add(ndoc);
      taskfile.add(odoc);
      taskfile.add(sdoc);
      taskfile.add(sadoc);
      taskfile.add(prdoc);
      taskfile.add(nexit);

      taskedit.add(cdoc);
      taskedit.add(pdoc);
      taskedit.add(rdoc);

      taskformat.add(fontfam);
      taskformat.add(fontsty);
      taskformat.add(fontsz);

      taskview.add(fstatus);

      taskcolor.add(bgcol);
      taskcolor.add(txtcol);

      nMenuBar.add(taskfile);
      nMenuBar.add(taskedit);
      nMenuBar.add(taskformat);
      nMenuBar.add(taskview);
      nMenuBar.add(taskcolor);

      f1.setJMenuBar(nMenuBar);
      f1.add(btm, BorderLayout.SOUTH);

      ndoc.addActionListener(this);
      odoc.addActionListener(this);
      prdoc.addActionListener(this);
      cdoc.addActionListener(this);
      pdoc.addActionListener(this);
      rdoc.addActionListener(this);
      fstatus.addActionListener(this);
      sdoc.addActionListener(this);
      sadoc.addActionListener(this);

      fontfam.addActionListener(this);
      fontsz.addActionListener(this);
      fontsty.addActionListener(this);

      nexit.addActionListener(this);

      bgcol.addActionListener(this);
      txtcol.addActionListener(this);

      maintxt.addKeyListener(this);

      f1.setSize(600, 600);
      f1.setLocationRelativeTo(null);
      f1.setVisible(true);
   }

   /* 
   		Step 3 Starts from here 
   */

   public void actionPerformed(ActionEvent ae) 
   {
      if (ae.getSource() == ndoc) 
      {
         f1.setTitle("New Document.txt");
         maintxt.setText("");
      } 
      else if (ae.getSource() == cdoc) 
      {
         String texts = maintxt.getText();
         pcdoc.setText(texts);
         JOptionPane.showMessageDialog(null, "Copy Text " + texts);
      } 
      else if (ae.getSource() == rdoc) 
      {
         maintxt.setText("");
         JOptionPane.showMessageDialog(null, "Removed");
      } 
      else if (ae.getSource() == pdoc) 
      {
         if (maintxt.getText().length() != 0) {
            maintxt.setText(maintxt.getText()+'\n'+pcdoc.getText());
         } 
         else 
         {
            maintxt.setText(pcdoc.getText());
         }
      } 
      else if (ae.getSource() == fstatus) {
         try {
            if (act == 0) {
               File f = new File(tle + ".txt");
               detail.setText("Size: " + f.length());
            }
         } 
         catch (Exception e) {
         }
      } 
      else if (ae.getSource() == fontfam) 
      {
         JOptionPane.showConfirmDialog(null, famlist, "Choose Font Family", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
         ffamily = String.valueOf(famlist.getSelectedValue());
         ft1 = new Font(ffamily, fstyle, fs);
         maintxt.setFont(ft1);
      } 
      else if (ae.getSource() == fontsty) 
      {

         JOptionPane.showConfirmDialog(null, stylist, "Choose Font Style", JOptionPane.OK_CANCEL_OPTION,
               JOptionPane.PLAIN_MESSAGE);
         fstyle = styleval[stylist.getSelectedIndex()];
         ft1 = new Font(ffamily, fstyle, fs);
         maintxt.setFont(ft1);
      } 
      else if (ae.getSource() == fontsz) 
      {
         JOptionPane.showConfirmDialog(null, szlist, "Choose Font Size", JOptionPane.OK_CANCEL_OPTION,
               JOptionPane.PLAIN_MESSAGE);
         fsstr = String.valueOf(szlist.getSelectedValue());
         fs = Integer.parseInt(fsstr);
         ft1 = new Font(ffamily, fstyle, fs);
         maintxt.setFont(ft1);
      } 
      else if (ae.getSource() == nexit) 
      {
         f1.dispose();
      }
      else if (ae.getSource()==sdoc) {
			// Create an object of JFileChooser class
			JFileChooser j = new JFileChooser("f:");

			// Invoke the showsSaveDialog function to show the save dialog
			int r = j.showSaveDialog(null);

			if (r == JFileChooser.APPROVE_OPTION) {

				// Set the label to the path of the selected directory
				File fi = new File(j.getSelectedFile().getAbsolutePath());

				try {
					// Create a file writer
					FileWriter wr = new FileWriter(fi, false);

					// Create buffered writer to write
					BufferedWriter w = new BufferedWriter(wr);

					// Write
					w.write(maintxt.getText());

					w.flush();
					w.close();
				}
				catch (Exception evt) {
					JOptionPane.showMessageDialog(f1, evt.getMessage());
				}
			}
			// If the user cancelled the operation
			else
				JOptionPane.showMessageDialog(f1, "the user cancelled the operation");
		}
		else if (ae.getSource() == prdoc) {
			try {
				// print the file
				maintxt.print();
			}
			catch (Exception evt) {
				JOptionPane.showMessageDialog(f1, evt.getMessage());
			}
		}
		else if (ae.getSource()==odoc) {
			// Create an object of JFileChooser class
			JFileChooser j = new JFileChooser("f:");

			// Invoke the showsOpenDialog function to show the save dialog
			int r = j.showOpenDialog(null);
         System.out.println("you are in open");

			// If the user selects a file
			if (r == JFileChooser.APPROVE_OPTION) {
				// Set the label to the path of the selected directory
				File fi = new File(j.getSelectedFile().getAbsolutePath());

				try {
					// String
					String s1 = "", sl = "";

					// File reader
					FileReader fr = new FileReader(fi);

					// Buffered reader
					BufferedReader br = new BufferedReader(fr);

					// Initialize sl
					sl = br.readLine();

					// Take the input from the file
					while ((s1 = br.readLine()) != null) {
						sl = sl + "\n" + s1;
					}

               br.close();

					// Set the text
					maintxt.setText(sl);
				}
				catch (Exception evt) {
					JOptionPane.showMessageDialog(f1, evt.getMessage());
				}
			}
			// If the user cancelled the operation
			else
				JOptionPane.showMessageDialog(f1, "the user cancelled the operation");
		}
		
		else if (ae.getSource().equals("close")) {
			f1.setVisible(false);
		}
      else if(ae.getSource()==bgcol){
         Color initialcolor=Color.RED;    
         Color color=JColorChooser.showDialog(f1,"select your title",initialcolor);    
         // f1.setBackground(color);
         maintxt.setBackground(color);
      }
      else if(ae.getSource()==txtcol){
         Color initialcolor=Color.RED;  
         Color color=JColorChooser.showDialog(f1,"Select a color",initialcolor);    
         // f1.setBackground(color);
         maintxt.setCaretColor(color);
         maintxt.setForeground(color);
      }
   }

   /* 
   		Step 4 Starts from here 
   */

   public void keyTyped(KeyEvent ke) 
   {
      cl = maintxt.getText().length();
      linecount = maintxt.getLineCount();
      detail.setText("Length: " + cl + "  "  + " Line: " + linecount);
   }

   /* 
   		Step 5 Starts from here 
   */

   public static void main(String ar[]) 
   {
      new Notepad();
   }
}
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Scanner;
//
///**
// * Created with IntelliJ IDEA.
// * User: victorelci
// * Date: 10/2/13
// * Time: 8:32 AM
// * A simple Notepad GUI application
// */
//public class Notepad extends JFrame {
//
//    /**
//     * Holds the name of the file
//     * See {@api http://docs.oracle.com/javase/7/docs/api/javax/swing/JTextField.html}
//     */
//    private JTextField fileNameTextField;
//
//    /**
//     * Holds the text of the file
//     * See {@api http://docs.oracle.com/javase/7/docs/api/javax/swing/JTextArea.html}
//     */
//    private JTextArea textArea;
//
//    /**
//     * Our application's buttons
//     * See {@api http://docs.oracle.com/javase/7/docs/api/javax/swing/JButton.html}
//     */
//    private JButton saveButton, loadButton, clearButton;
//
//    /**
//     * default constructor
//     */
//    public Notepad() {
//
//        fileNameTextField = new JTextField();
//        textArea = new JTextArea();
//
//        /**
//         * Create a panel for the buttons to reside.
//         * The default layout for containers is FlowLayout
//         *
//         * See {@link http://docs.oracle.com/javase/7/docs/api/java/awt/FlowLayout.html}
//         */
//        JPanel buttonPanel = new JPanel();
//
//        saveButton = new JButton("Save");
//        loadButton = new JButton("Load");
//        clearButton = new JButton("Clear");
//
//        // Instantiate an action listener to listen for button click events
//        NotepadButtonListener buttonListener = new NotepadButtonListener();
//
//        // attach our action listener to the buttons
//        saveButton.addActionListener(buttonListener);
//        loadButton.addActionListener(buttonListener);
//        clearButton.addActionListener(buttonListener);
//
//        buttonPanel.add(saveButton);
//        buttonPanel.add(loadButton);
//        buttonPanel.add(clearButton);
//
//        // set the layout of the JFrame
//        this.setLayout(new BorderLayout());
//
//        /**
//         * Add the elements to the panel.
//         * BorderLayouts have 5 positions that you can add Objects:
//         * NORTH, SOUTH, EAST, WEST, and CENTER
//         *
//         * See {@api http://docs.oracle.com/javase/7/docs/api/java/awt/BorderLayout.html}
//         */
//
//        add(fileNameTextField, BorderLayout.NORTH);
//        add(textArea, BorderLayout.CENTER);
//        add(buttonPanel, BorderLayout.SOUTH);
//
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        // show the frame
//        setPreferredSize(new Dimension(400, 300));
//        pack();
//        setVisible(true);
//    }
//
//    /**
//     *
//     * @return the name of the file
//     */
//    private String getFileName() {
//        return fileNameTextField.getText();
//    }
//
//    /**
//     * Read from the specified file
//     * @param fileName the name of the file to read from
//     */
//    private void readFile(String fileName) {
//        Scanner inFile = null;
//
//        try {
//            // file reader
//            inFile = new Scanner(new FileReader(fileName));
//
//            // clear the text area
//            textArea.setText("");
//
//            // copy file
//            while (inFile.hasNextLine()) {
//                textArea.append(inFile.nextLine());
//            }
//
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//            System.out.println("File not found");
//        } finally {
//            if (inFile != null) {
//                inFile.close();
//            }
//        }
//    }
//
//    /**
//     * Write to the specified file
//     * @param fileName the name of the file to write to
//     */
//    private void writeFile(String fileName) {
//        PrintWriter outFile = null;
//
//        try {
//            // file writer
//            outFile = new PrintWriter(new FileWriter(fileName));
//
//            outFile.print(textArea.getText());
//
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//            System.out.println("File not found");
//        } finally {
//            if (outFile != null) {
//                outFile.close();
//            }
//        }
//    }
//
//    /**
//     * The action listener for our Notepad application
//     * Action listeners must implement the ActionListener interface and define
//     * the behavior of the actionPerformed() method.
//     *
//     * See {@api http://docs.oracle.com/javase/7/docs/api/java/awt/event/ActionListener.html}
//     *
//     * More info on action listeners {@api http://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html
//     */
//    class NotepadButtonListener implements ActionListener {
//
//        /**
//         * This needs to be defined since this class implements the ActionListener interface
//         * @param e the event
//         */
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JButton sourceButton = (JButton) e.getSource();
//
//            // Figure out which button was pressed            
//            if (sourceButton.equals(loadButton)) {
//                System.out.println("Load button pressed");
//                readFile(getFileName());
//            } else if (sourceButton.equals(saveButton)) {
//                System.out.println("Save button pressed");
//                writeFile(getFileName());
//            } else if (sourceButton.equals(clearButton)) {
//                System.out.println("Clear button pressed");
//
//                // clear the text area
//                textArea.setText("");
//            } else {
//                System.out.println("Unknown button pressed");
//            }
//        }
//    }
//
//    /**
//     * The application's entry point
//     * @param args
//     */
//    public static void main(String[] args) {
//        // Create the notepad instance
//        new Notepad();
//    }
//}