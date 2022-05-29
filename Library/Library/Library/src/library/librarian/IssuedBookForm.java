package library.librarian;

import library.Utils;
import library.admin.LibraryUserMenu;
import library.managers.IssuedBooksManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class IssuedBookForm extends JFrame {
  static IssuedBookForm frame;
  private final JTextField textField_1;
  private final JTextField textField_2;
  private final JTextField textField_3;
  private final JTextField textField_4;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        frame = new IssuedBookForm();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  /**
   * Create the frame.
   */
  public IssuedBookForm() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200, 200, 550, 500);
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
    setContentPane(contentPane);

    JLabel lblIssuedBooks = new JLabel("Issued Books ");
    lblIssuedBooks.setFont(new Font("TimesRoman", Font.PLAIN, 20));
    lblIssuedBooks.setForeground(Color.GRAY);

    JLabel lblBookCallno = new JLabel("Book Callno:");

    textField_1 = new JTextField();
    textField_1.setColumns(10);

    textField_2 = new JTextField();
    textField_2.setColumns(10);

    textField_3 = new JTextField();
    textField_3.setColumns(10);

    textField_4 = new JTextField();
    textField_4.setColumns(10);

    JLabel lblStudentId = new JLabel("Student Id:");
    JLabel lblStudentName = new JLabel("Student Name:");
    JLabel lblStudentContact = new JLabel("Student Contact:");

    JButton btnIssuedBook = new JButton("Issued Book");

    btnIssuedBook.addActionListener(e -> {
      String bookcallno = textField_1.getText();
      String studentIdString = textField_2.getText();
      String studentname = textField_3.getText();
      String studentcontact = textField_4.getText();

      if (bookcallno.trim().isEmpty() || studentIdString.trim().isEmpty() || studentname.trim().isEmpty() ||
        studentcontact.trim().isEmpty() || !Utils.isNumeric(studentIdString)) {
        JOptionPane.showMessageDialog(IssuedBookForm.this, "Incorrect Data");
        return;
      }

      int studentid = Integer.parseInt(studentIdString);

      if (IssuedBooksManager.getInstance().checkBook(bookcallno) != null) {
        boolean saveSuccess = IssuedBooksManager.getInstance().save(bookcallno, studentid, studentname, studentcontact);

        if (saveSuccess) {
          JOptionPane.showMessageDialog(IssuedBookForm.this, "Books is issued!");
          LibraryUserMenu.main(new String[] {});
          frame.dispose();
        } else {
          JOptionPane.showMessageDialog(IssuedBookForm.this, "Sorry, Books can't be issued!");
        }
      } else {
        JOptionPane.showMessageDialog(IssuedBookForm.this, "Sorry, Callno is not in data!");
      }
    });

    JButton btnBack = new JButton("Back");
    btnBack.addActionListener(e -> {
      LibraryUserMenu.main(new String[] {});
      frame.dispose();
    });


    GroupLayout contentPaneInner = new GroupLayout(contentPane);

    contentPaneInner.setHorizontalGroup(
      contentPaneInner.createParallelGroup(Alignment.LEADING)
        .addGroup(contentPaneInner.createSequentialGroup()
          .addContainerGap(10, Short.MAX_VALUE)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING)
            .addGroup(contentPaneInner.createSequentialGroup()
              .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING)
                .addComponent(lblBookCallno)
                .addComponent(lblStudentId)
                .addComponent(lblStudentName, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblStudentContact, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
              .addGap(10)
              .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING)
                .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
              .addGap(48))
            .addGroup(Alignment.TRAILING, contentPaneInner.createSequentialGroup()
              .addGap(20)
              .addGroup(contentPaneInner.createParallelGroup(Alignment.TRAILING)
                .addGroup(contentPaneInner.createSequentialGroup()
                  .addComponent(btnIssuedBook, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                  .addGap(47)
                  .addComponent(btnBack)))
              .addGap(100))))
        .addGroup(contentPaneInner.createSequentialGroup()
          .addGap(146)
          .addComponent(lblIssuedBooks)
          .addContainerGap(235, Short.MAX_VALUE))
    );

    contentPaneInner.setVerticalGroup(
      contentPaneInner.createParallelGroup(Alignment.TRAILING)
        .addGroup(contentPaneInner.createSequentialGroup()
          .addGap(37)
          .addComponent(lblIssuedBooks)
          .addGap(43)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblBookCallno)
            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(28)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblStudentId)
            .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(28)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblStudentName)
            .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(26)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblStudentContact)
            .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(btnIssuedBook, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnBack))
          .addGap(18)
          .addGap(25))
    );

    contentPane.setLayout(contentPaneInner);
  }
}
