package library.librarian;

import library.managers.BooksManager;
import library.models.Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CheckBooks extends JFrame {

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        CheckBooks frame = new CheckBooks();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  /**
   * Create the frame.
   */
  public CheckBooks() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setBounds(200, 200, 550, 500);
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);

    String[] column = Book.getColumns();
    String[][] data = BooksManager.getInstance().getBookList().stream().map(Book::getData).toArray(String[][]::new);

    JTable table = new JTable(data, column);
    JScrollPane sp = new JScrollPane(table);

    contentPane.add(sp, BorderLayout.CENTER);
  }

}
