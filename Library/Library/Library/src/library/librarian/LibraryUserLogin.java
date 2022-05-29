package library.librarian;

import library.admin.LibraryUserMenu;
import library.managers.LibraryUserManager;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LibraryUserLogin extends JFrame {
  static LibraryUserLogin frame;
  private JPanel contentPane;
  private JTextField textField;
  private JPasswordField passwordField;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        frame = new LibraryUserLogin();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  /**
   * Create the frame.
   */
  public LibraryUserLogin() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200, 200, 550, 500);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
    setContentPane(contentPane);

    JLabel lblLibrariUserLogin = new JLabel("Library User Login");
    lblLibrariUserLogin.setForeground(Color.GRAY);
    lblLibrariUserLogin.setFont(new Font("TimesRoman", Font.PLAIN, 20));

    JLabel lblName = new JLabel(" Name:");

    JLabel lblPassword = new JLabel(" Password:");

    textField = new JTextField();
    textField.setColumns(10);

    JButton btnLogin = new JButton("Login");
    btnLogin.addActionListener(e -> {
      String name = textField.getText();
      String password = String.valueOf(passwordField.getPassword());

      if (LibraryUserManager.validate(name, password)) {
        LibraryUserMenu.main(new String[] {});
        frame.dispose();
      } else {
        JOptionPane.showMessageDialog(LibraryUserLogin.this, "Sorry, Username or Password is incorrect please try again", "Incorrect data", JOptionPane.ERROR_MESSAGE);
        textField.setText("");
        passwordField.setText("");
      }
    });

    passwordField = new JPasswordField();
    GroupLayout contentPaneInner = new GroupLayout(contentPane);

    contentPaneInner.setHorizontalGroup(
      contentPaneInner.createParallelGroup(Alignment.TRAILING)
        .addGroup(contentPaneInner.createSequentialGroup()
          .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING)
            .addGroup(contentPaneInner.createSequentialGroup()
              .addGap(124)
              .addComponent(lblLibrariUserLogin))
            .addGroup(contentPaneInner.createSequentialGroup()
              .addGap(19)
              .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING)
                .addComponent(lblName)
                .addComponent(lblPassword))
              .addGap(47)
              .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING, false)
                .addComponent(passwordField)
                .addComponent(textField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
          .addContainerGap(107, Short.MAX_VALUE))
        .addGroup(contentPaneInner.createSequentialGroup()
          .addContainerGap(187, Short.MAX_VALUE)
          .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
          .addGap(151))
    );
    contentPaneInner.setVerticalGroup(
      contentPaneInner.createParallelGroup(Alignment.LEADING)
        .addGroup(contentPaneInner.createSequentialGroup()
          .addComponent(lblLibrariUserLogin)
          .addGap(26)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblName)
            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(28)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblPassword)
            .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(80, Short.MAX_VALUE))
    );
    contentPane.setLayout(contentPaneInner);
  }
}
