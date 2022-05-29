package library.librarian;

import library.Utils;
import library.admin.LibraryUserMenu;
import library.managers.BooksManager;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EnterBookData extends JFrame {
  static EnterBookData frame;
  private final JTextField textField;
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
        frame = new EnterBookData();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  /**
   * Create the frame.
   */
  public EnterBookData() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200, 200, 550, 500);
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
    setContentPane(contentPane);

    JLabel lblEnterBooks = new JLabel("Enter Books");
    lblEnterBooks.setForeground(Color.GRAY);
    lblEnterBooks.setFont(new Font("TimesRoman", Font.PLAIN, 20));

    JLabel lblCallNo = new JLabel("Call No:");
    JLabel lblName = new JLabel("Name:");
    JLabel lblAuthor = new JLabel("Author:");
    JLabel lblPublisher = new JLabel("Publisher:");
    JLabel lblQuantity = new JLabel("Quantity:");

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

    JButton btnEnterBooks = new JButton("Enter Books");
    btnEnterBooks.addActionListener(e -> {
      String callno = textField.getText();
      String name = textField_1.getText();
      String author = textField_2.getText();
      String publisher = textField_3.getText();
      String squantity = textField_4.getText();

      if (callno.trim().isEmpty() || name.trim().isEmpty() || author.trim().isEmpty() ||
        publisher.trim().isEmpty() || squantity.trim().isEmpty() || !Utils.isNumeric(squantity)) {
        JOptionPane.showMessageDialog(EnterBookData.this, "Incorrect Data!");
        return;
      }

      int quantity = Integer.parseInt(squantity);

      boolean success = BooksManager.getInstance().save(callno, name, author, publisher, quantity);

      if (success) {
        JOptionPane.showMessageDialog(EnterBookData.this, "Book Entered!");
        LibraryUserMenu.main(new String[] {});
        frame.dispose();
      } else {
        JOptionPane.showMessageDialog(EnterBookData.this, "Sorry, Book not able to Entered!");
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
          .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING)
            .addGroup(contentPaneInner.createSequentialGroup()
              .addGap(150)
              .addComponent(lblEnterBooks))
            .addGroup(contentPaneInner.createSequentialGroup()
              .addGap(18)
              .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING, false)
                .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblCallNo)
                .addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblPublisher, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
              .addGap(47)
              .addGroup(contentPaneInner.createParallelGroup(Alignment.LEADING)
                .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
          .addContainerGap(125, Short.MAX_VALUE))
        .addGroup(Alignment.LEADING, contentPaneInner.createSequentialGroup()
          .addGap(161)
          .addComponent(btnEnterBooks, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(162, Short.MAX_VALUE))
        .addGroup(contentPaneInner.createSequentialGroup()
          .addContainerGap(359, Short.MAX_VALUE)
          .addComponent(btnBack)
          .addContainerGap())
    );

    contentPaneInner.setVerticalGroup(
      contentPaneInner.createParallelGroup(Alignment.LEADING)
        .addGroup(contentPaneInner.createSequentialGroup()
          .addComponent(lblEnterBooks)
          .addGap(18)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblCallNo)
            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblName)
            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblAuthor)
            .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblPublisher)
            .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(contentPaneInner.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblQuantity)
            .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(30)
          .addComponent(btnEnterBooks, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(btnBack)
          .addContainerGap(53, Short.MAX_VALUE))
    );

    contentPane.setLayout(contentPaneInner);
  }

}
