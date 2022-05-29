package library;

import library.admin.AdminLogin;
import library.librarian.LibraryUserLogin;

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
import javax.swing.LayoutStyle.ComponentPlacement;

public class Library extends JFrame {
  static Library frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        frame = new Library();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  /**
   * Create the frame.
   */
  public Library() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200, 200, 550, 400);
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
    setContentPane(contentPane);

    JLabel lblBookBank = new JLabel("Book Bank");
    lblBookBank.setFont(new Font("TimesRoman", Font.PLAIN, 20));
    lblBookBank.setForeground(Color.GRAY);

    JButton btnAdmin = new JButton("Admin");

    btnAdmin.addActionListener(e -> {
      AdminLogin.main(new String[] {});
      frame.dispose();
    });

    btnAdmin.setFont(new Font("TimesRoman", Font.PLAIN, 18));

    JButton btnLibrarianuser = new JButton("Library user ");

    btnLibrarianuser.addActionListener(e -> LibraryUserLogin.main(new String[] {}));

    btnLibrarianuser.setFont(new Font("TimesRoman", Font.PLAIN, 18));
    GroupLayout contentPaneInner = new GroupLayout(contentPane);

    contentPaneInner.setHorizontalGroup(
      contentPaneInner.createParallelGroup(Alignment.LEADING)
        .addGroup(contentPaneInner.createSequentialGroup()
          .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING)
            .addGroup(contentPaneInner.createSequentialGroup()
              .addGap(64)
              .addComponent(lblBookBank))
            .addGroup(contentPaneInner.createSequentialGroup()
              .addGap(140)
              .addGroup(contentPaneInner.createParallelGroup(Alignment.TRAILING, false)
                .addComponent(btnLibrarianuser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdmin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
          .addContainerGap(95, Short.MAX_VALUE))
    );

    contentPaneInner.setVerticalGroup(
      contentPaneInner.createParallelGroup(Alignment.LEADING)
        .addGroup(contentPaneInner.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblBookBank)
          .addGap(32)
          .addComponent(btnAdmin, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(btnLibrarianuser, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(70, Short.MAX_VALUE))
    );

    contentPane.setLayout(contentPaneInner);
  }
}
