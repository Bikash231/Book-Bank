package library.admin;

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
import javax.swing.JPasswordField;

public class AdminLogin extends JFrame {
  static AdminLogin frame;
  private final JTextField textField;
  private JPasswordField passwordField;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        frame = new AdminLogin();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  /**
   * Create the frame.
   */
  public AdminLogin() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200, 200, 550, 400);
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
    setContentPane(contentPane);

    JLabel lblAdminLogin = new JLabel("Admin Login ");
    lblAdminLogin.setForeground(Color.GRAY);
    lblAdminLogin.setFont(new Font("TimesRoman", Font.PLAIN, 20));

    JLabel lblEnterUserName = new JLabel("Enter UserName:");
    JLabel lblEnterPassword = new JLabel("Enter Password:");

    textField = new JTextField();
    textField.setColumns(20);

    JButton btnLogin = new JButton("Login");

    btnLogin.addActionListener(e -> {
      String name = textField.getText();
      String password = String.valueOf(passwordField.getPassword());

      if (name.equals("Bikash") && password.equals("Bikash")) {
        AdminMenu.main(new String[] {});
        frame.dispose();
      } else {
        JOptionPane.showMessageDialog(AdminLogin.this, "Sorry, Username or Password is incorrect please try again", "Incorrect data", JOptionPane.ERROR_MESSAGE);
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
              .addComponent(lblAdminLogin))
            .addGroup(contentPaneInner.createSequentialGroup()
              .addGap(19)
              .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING)
                .addComponent(lblEnterUserName)
                .addComponent(lblEnterPassword))
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
          .addComponent(lblAdminLogin)
          .addGap(26)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblEnterUserName)
            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(28)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblEnterPassword)
            .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(80, Short.MAX_VALUE))
    );

    contentPane.setLayout(contentPaneInner);
  }
}
