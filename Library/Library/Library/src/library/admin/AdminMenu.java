package library.admin;

import library.Library;
import library.librarian.LibraryUserForm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class AdminMenu extends JFrame {
  static AdminMenu frame;
  private JPanel contentPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          frame = new AdminMenu();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public AdminMenu() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200, 200, 550, 400);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
    setContentPane(contentPane);

    JLabel lblMenu = new JLabel("Menu");
    lblMenu.setFont(new Font("TimesRoman", Font.PLAIN, 24));
    lblMenu.setForeground(Color.GRAY);

    JButton btnEntryLibraryUser = new JButton("Entry LibraryUser ");
    btnEntryLibraryUser.setFont(new Font("TimesRoman", Font.PLAIN, 17));
    btnEntryLibraryUser.addActionListener(e -> {
      LibraryUserForm.main(new String[] {});
      frame.dispose();
    });

    JButton btnCheckLibraryUser = new JButton("Check LibraryUser");
    btnCheckLibraryUser.addActionListener(e -> ViewLibrarian.main(new String[] {}));
    btnCheckLibraryUser.setFont(new Font("TimesRoman", Font.PLAIN, 17));

    JButton btnRemoveLibraryUser = new JButton("Remove LibraryUser");
    btnRemoveLibraryUser.addActionListener(e -> {
      RemoveLibraryUser.main(new String[] {});
      frame.dispose();
    });
    btnRemoveLibraryUser.setFont(new Font("TimesRoman", Font.PLAIN, 17));

    JButton btnLogout = new JButton("Logout");
    btnLogout.addActionListener(e -> {
      Library.main(new String[] {});
      frame.dispose();
    });

    btnLogout.setFont(new Font("TimesRoman", Font.PLAIN, 17));
    GroupLayout contentPaneInner = new GroupLayout(contentPane);

    contentPaneInner.setHorizontalGroup(
      contentPaneInner.createParallelGroup(Alignment.TRAILING)
        .addGroup(contentPaneInner.createSequentialGroup()
          .addContainerGap(150, Short.MAX_VALUE)
          .addComponent(lblMenu, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
          .addGap(123))
        .addGroup(Alignment.LEADING, contentPaneInner.createSequentialGroup()
          .addGap(134)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING)
            .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnRemoveLibraryUser, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnCheckLibraryUser, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnEntryLibraryUser, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(109, Short.MAX_VALUE))
    );

    contentPaneInner.setVerticalGroup(
      contentPaneInner.createParallelGroup(Alignment.LEADING)
        .addGroup(contentPaneInner.createSequentialGroup()
          .addComponent(lblMenu, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
          .addGap(11)
          .addComponent(btnEntryLibraryUser, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addComponent(btnCheckLibraryUser, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addComponent(btnRemoveLibraryUser, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(21, Short.MAX_VALUE))
    );

    contentPane.setLayout(contentPaneInner);
  }
}
