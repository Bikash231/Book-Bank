package library.admin;

import library.Library;
import library.librarian.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LibraryUserMenu extends JFrame {
  static LibraryUserMenu frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        frame = new LibraryUserMenu();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  /**
   * Create the frame.
   */
  public LibraryUserMenu() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200, 200, 550, 500);
    JPanel contentPane = new JPanel();
    contentPane.setForeground(Color.GRAY);
    contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
    setContentPane(contentPane);

    JLabel lblLibraryUser = new JLabel("Library User");
    lblLibraryUser.setFont(new Font("TimesRoman", Font.PLAIN, 24));

    JButton btnEnterBooks = new JButton("Enter Books");
    btnEnterBooks.addActionListener(e -> {
      EnterBookData.main(new String[] {});
      frame.dispose();
    });
    btnEnterBooks.setFont(new Font("TimesRoman", Font.PLAIN, 15));

    JButton btnCheckBooks = new JButton("Check Books");
    btnCheckBooks.addActionListener(e -> CheckBooks.main(new String[] {}));
    btnCheckBooks.setFont(new Font("TimesRoman", Font.PLAIN, 15));

    JButton btnIssueBook = new JButton("Issue Book");
    btnIssueBook.addActionListener(e -> {
      IssuedBookForm.main(new String[] {});
      frame.dispose();
    });
    btnIssueBook.setFont(new Font("TimesRoman", Font.PLAIN, 15));

    JButton btncheckIssueBooks = new JButton("check Issue Books");
    btncheckIssueBooks.addActionListener(e -> CheckIssuedBooks.main(new String[] {}));
    btncheckIssueBooks.setFont(new Font("TimesRoman", Font.PLAIN, 15));

    JButton btnReturnedBook = new JButton("Returned Book");
    btnReturnedBook.addActionListener(e -> {
      ReturnedBook.main(new String[] {});
      frame.dispose();
    });
    btnReturnedBook.setFont(new Font("TimesRoman", Font.PLAIN, 15));

    JButton btnLogout = new JButton("Logout");
    btnLogout.addActionListener(e -> {
      Library.main(new String[] {});
      frame.dispose();
    });
    btnLogout.setFont(new Font("TimesRoman", Font.PLAIN, 15));

    GroupLayout contentPaneInner = new GroupLayout(contentPane);

    contentPaneInner.setHorizontalGroup(
      contentPaneInner.createParallelGroup(Alignment.LEADING)
        .addGroup(Alignment.TRAILING, contentPaneInner.createSequentialGroup()
          .addContainerGap(81, Short.MAX_VALUE)
          .addComponent(lblLibraryUser)
          .addGap(54))
        .addGroup(contentPaneInner.createSequentialGroup()
          .addGap(132)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING)
            .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnReturnedBook, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
            .addComponent(btncheckIssueBooks, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnCheckBooks, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnEnterBooks, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(101, Short.MAX_VALUE))
    );

    contentPaneInner.setVerticalGroup(
      contentPaneInner.createParallelGroup(Alignment.LEADING)
        .addGroup(contentPaneInner.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblLibraryUser)
          .addGap(18)
          .addComponent(btnEnterBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addComponent(btnCheckBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addComponent(btncheckIssueBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addComponent(btnReturnedBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(16, Short.MAX_VALUE))
    );

    contentPane.setLayout(contentPaneInner);
  }

}
