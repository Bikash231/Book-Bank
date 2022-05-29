package library.librarian;

import library.admin.AdminMenu;
import library.managers.LibraryUserManager;

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
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibraryUserForm extends JFrame {
  static LibraryUserForm frame;
  private final JPanel contentPane;
  private final JTextField textField;
  private final JTextField textField_1;
  private final JTextField textField_2;
  private final JTextField textField_3;
  private final JTextField textField_4;
  private final JPasswordField passwordField;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        frame = new LibraryUserForm();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  /**
   * Create the frame.
   */
  public LibraryUserForm() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200, 200, 550, 500);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
    setContentPane(contentPane);

    JLabel lblEnterLibraryUser = new JLabel("Enter Library User");
    lblEnterLibraryUser.setForeground(Color.DARK_GRAY);
    lblEnterLibraryUser.setFont(new Font("TimesRoman", Font.PLAIN, 24));

    JLabel lblName = new JLabel("Name:");

    JLabel lblPassword = new JLabel("Password:");

    JLabel lblEmail = new JLabel("Email:");

    JLabel lblAddress = new JLabel("Address:");

    JLabel lblCity = new JLabel("City:");

    JLabel lblContactNo = new JLabel("Contact No:");

    textField = new JTextField();
    textField.setColumns(10);

    textField_1 = new JTextField();
    textField_1.setColumns(10);

    textField_2 = new JTextField();
    textField_2.setColumns(10);

    textField_3 = new JTextField();
    textField_3.setColumns(10);

    textField_4 = new JTextField();
    textField_4.setColumns(10);

    passwordField = new JPasswordField();

    JButton btnEnterData = new JButton("Enter Data");
    btnEnterData.addActionListener(e -> {
      String name = textField.getText();
      String password = String.valueOf(passwordField.getPassword());
      String email = textField_1.getText();
      String address = textField_2.getText();
      String city = textField_3.getText();
      String contact = textField_4.getText();

      if (name.trim().isEmpty() || password.trim().isEmpty() || email.trim().isEmpty() ||
        address.trim().isEmpty() || city.trim().isEmpty() || contact.trim().isEmpty()) {
        JOptionPane.showMessageDialog(LibraryUserForm.this, "Data are not filled!");
        return;
      }

      boolean saveSuccess = LibraryUserManager.getInstance().save(name, password, email, address, city, contact);

      if (saveSuccess) {
        JOptionPane.showMessageDialog(LibraryUserForm.this, "Data Entered!");
        AdminMenu.main(new String[] {});
        frame.dispose();
      } else {
        JOptionPane.showMessageDialog(LibraryUserForm.this, "Sorry, data is not save!");
      }
    });
    btnEnterData.setForeground(Color.DARK_GRAY);

    JButton btnBack = new JButton("Back");
    btnBack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        AdminMenu.main(new String[] {});
        frame.dispose();
      }
    });

    GroupLayout contentPaneInner = new GroupLayout(contentPane);

    contentPaneInner.setHorizontalGroup(
      contentPaneInner.createParallelGroup(Alignment.TRAILING)
        .addGroup(contentPaneInner.createSequentialGroup()
          .addGap(20)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING, false)
            .addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
            .addComponent(lblName)
            .addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblAddress, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblContactNo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGap(58)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING, false)
            .addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
            .addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
            .addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
            .addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
            .addComponent(textField, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
            .addComponent(passwordField))
          .addContainerGap(107, Short.MAX_VALUE))
        .addGroup(contentPaneInner.createSequentialGroup()
          .addContainerGap(151, Short.MAX_VALUE)
          .addComponent(lblEnterLibraryUser)
          .addGap(144))
        .addGroup(contentPaneInner.createSequentialGroup()
          .addContainerGap(160, Short.MAX_VALUE)
          .addComponent(btnEnterData, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
          .addGap(133))
        .addGroup(contentPaneInner.createSequentialGroup()
          .addContainerGap(200, Short.MAX_VALUE)
          .addComponent(btnBack)
          .addGap(169))
    );

    contentPaneInner.setVerticalGroup(
      contentPaneInner.createParallelGroup(Alignment.LEADING)
        .addGroup(contentPaneInner.createSequentialGroup()
          .addComponent(lblEnterLibraryUser)
          .addGap(18)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING)
            .addGroup(contentPaneInner.createSequentialGroup()
              .addComponent(lblName)
              .addGap(18)
              .addComponent(lblPassword))
            .addGroup(contentPaneInner.createSequentialGroup()
              .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
          .addGap(18)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblEmail)
            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblAddress)
            .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblCity)
            .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblContactNo)
            .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addComponent(btnEnterData, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
          .addComponent(btnBack)
          .addGap(19))
    );

    contentPane.setLayout(contentPaneInner);
  }

}
