package library.admin;

import library.managers.LibraryUserManager;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RemoveLibraryUser extends JFrame {
  static RemoveLibraryUser frame;
  private final JTextField textField;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        frame = new RemoveLibraryUser();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  /**
   * Create the frame.
   */
  public RemoveLibraryUser() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200, 200, 550, 400);
    JPanel contentPane1 = new JPanel();
    contentPane1.setBorder(new EmptyBorder(6, 6, 6, 6));
    setContentPane(contentPane1);

    JLabel lblSelectId = new JLabel("Select Id:");

    textField = new JTextField();
    textField.setColumns(10);

    JButton btnDelete = new JButton("Delete");
    btnDelete.addActionListener(e -> {
      String sid = textField.getText();

      if (sid == null || sid.trim().isEmpty()) {
        JOptionPane.showMessageDialog(RemoveLibraryUser.this, "Id is empty, try again!");
        return;
      }

      String dialogMessage = LibraryUserManager.getInstance().delete(Integer.parseInt(sid)) ?
        "data removed!" :
        "Unable to remove given id!";

      JOptionPane.showMessageDialog(RemoveLibraryUser.this, dialogMessage);
    });

    btnDelete.setFont(new Font("TimesRoman", Font.PLAIN, 15));

    JButton btnNewButton = new JButton("Back");
    btnNewButton.addActionListener(e -> {
      AdminMenu.main(new String[] {});
      frame.dispose();
    });

    btnNewButton.setFont(new Font("TimesRoman", Font.PLAIN, 15));
    GroupLayout contentPane = new GroupLayout(contentPane1);

    contentPane.setHorizontalGroup(
      contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(contentPane.createSequentialGroup()
          .addGap(39)
          .addComponent(lblSelectId)
          .addGap(57)
          .addComponent(textField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(107, Short.MAX_VALUE))
        .addGroup(Alignment.TRAILING, contentPane.createSequentialGroup()
          .addContainerGap(175, Short.MAX_VALUE)
          .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
          .addGap(140))
        .addGroup(Alignment.TRAILING, contentPane.createSequentialGroup()
          .addContainerGap(322, Short.MAX_VALUE)
          .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
          .addContainerGap())
    );

    contentPane.setVerticalGroup(
      contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(contentPane.createSequentialGroup()
          .addGap(19)
          .addGroup(contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblSelectId))
          .addGap(33)
          .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
          .addGap(43)
          .addComponent(btnNewButton)
          .addContainerGap(78, Short.MAX_VALUE))
    );

    contentPane1.setLayout(contentPane);
  }
}
