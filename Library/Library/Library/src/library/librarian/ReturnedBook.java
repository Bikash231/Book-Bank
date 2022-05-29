package library.librarian;

import library.Utils;
import library.admin.LibraryUserMenu;
import library.managers.ReturnBooksManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ReturnedBook extends JFrame {
  static ReturnedBook frame;
  private final JTextField textField;
  private final JTextField textField_1;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        frame = new ReturnedBook();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  /**
   * Create the frame.
   */
  public ReturnedBook() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200, 200, 550, 500);
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
    setContentPane(contentPane);

    JLabel lblReturnBook = new JLabel("Return Book");
    lblReturnBook.setForeground(Color.GRAY);
    lblReturnBook.setFont(new Font("TimesRoman", Font.PLAIN, 20));

    JLabel lblBookCallno = new JLabel("Book Callno:");

    JLabel lblStudentId = new JLabel("Student Id:");

    textField = new JTextField();
    textField.setColumns(10);

    textField_1 = new JTextField();
    textField_1.setColumns(10);

    JButton btnReturnBook = new JButton("Return Book");
    btnReturnBook.addActionListener(e -> {
      String bookcallno = textField.getText();
      String studentIdString = textField_1.getText();

      if (bookcallno.trim().isEmpty() || studentIdString.trim().isEmpty() || !Utils.isNumeric(studentIdString)) {
        JOptionPane.showMessageDialog(ReturnedBook.this, "Incorrect Data");
        return;
      }

      int studentid = Integer.parseInt(studentIdString);
      boolean success = ReturnBooksManager.delete(bookcallno, studentid);

      if (success) {
        JOptionPane.showMessageDialog(ReturnedBook.this, "Books returned !");
        LibraryUserMenu.main(new String[] {});
        frame.dispose();
      } else {
        JOptionPane.showMessageDialog(ReturnedBook.this, "Sorry, not able to returned!");
      }
    });

 

    JButton btnBack = new JButton("Back");
    btnBack.addActionListener(e -> {
      LibraryUserMenu.main(new String[] {});
      frame.dispose();
    });

    GroupLayout contentPaneInner = new GroupLayout(contentPane);

    contentPaneInner.setHorizontalGroup(
      contentPaneInner.createParallelGroup(Alignment.TRAILING)
        .addGroup(contentPaneInner.createSequentialGroup()
          .addGap(36)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.TRAILING, false)
            .addComponent(lblStudentId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBookCallno, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
          .addGap(56)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING)
            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
            .addComponent(textField, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(139, Short.MAX_VALUE))
        .addGroup(contentPaneInner.createSequentialGroup()
          .addContainerGap(210, Short.MAX_VALUE)
          .addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
          .addGap(176))
        .addGroup(contentPaneInner.createSequentialGroup()
          .addContainerGap(205, Short.MAX_VALUE)
          .addComponent(lblReturnBook)
          .addGap(187))
        .addGroup(contentPaneInner.createSequentialGroup()
          .addGap(19)
          .addContainerGap(294, Short.MAX_VALUE))
        .addGroup(contentPaneInner.createSequentialGroup()
          .addContainerGap(355, Short.MAX_VALUE)
          .addComponent(btnBack)
          .addGap(46))
    );

    contentPaneInner.setVerticalGroup(
      contentPaneInner.createParallelGroup(Alignment.LEADING)
        .addGroup(contentPaneInner.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblReturnBook)
          .addGap(32)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblBookCallno)
            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(34)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblStudentId)
            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(29)
          .addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
          .addGap(23)
          .addComponent(btnBack)
          .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
          .addGap(72))
    );

    contentPane.setLayout(contentPaneInner);
  }

}
