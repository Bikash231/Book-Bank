package library.librarian;

import library.managers.IssuedBooksManager;
import library.models.IssuedBook;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CheckIssuedBooks extends JFrame {

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        CheckIssuedBooks frame = new CheckIssuedBooks();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  /**
   * Create the frame.
   */
  public CheckIssuedBooks() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setBounds(200, 200, 550, 500);
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);

    String[] columns = IssuedBook.getColumns();
    String[][] data = IssuedBooksManager.getInstance().getIssuedBooksList().stream().map(IssuedBook::getData).toArray(String[][]::new);

    JTable table = new JTable(data, columns);
    JScrollPane sp = new JScrollPane(table);

    contentPane.add(sp, BorderLayout.CENTER);
  }

}
