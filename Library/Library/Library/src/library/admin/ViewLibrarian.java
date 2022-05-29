package library.admin;

import library.managers.LibraryUserManager;
import library.models.Librarian;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ViewLibrarian extends JFrame {

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        ViewLibrarian frame = new ViewLibrarian();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  /**
   * Create the frame.
   */
  public ViewLibrarian() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setBounds(200, 200, 550, 400);
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);

    String[] columns = Librarian.getColumns();
    String[][] data = LibraryUserManager.getInstance().getLibrarianList().stream().map(Librarian::getData).toArray(String[][]::new);

    JTable table = new JTable(data, columns);
    JScrollPane sp = new JScrollPane(table);

    contentPane.add(sp, BorderLayout.CENTER);
  }

}
