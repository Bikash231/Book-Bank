package library.managers;

import library.Utils;
import library.models.Book;
import library.models.IssuedBook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IssuedBooksManager {

  final static IssuedBooksManager instance = new IssuedBooksManager();

  final AtomicInteger idCounter = new AtomicInteger();
  private List<IssuedBook> issuedBooksList = new ArrayList<>();

  private IssuedBooksManager() {
    File issuedBooksFile = new File(Utils.ISSUED_BOOKS_FILE);

    try {
      if (issuedBooksFile.exists() && !issuedBooksFile.isDirectory()) {
        issuedBooksList = Utils.loadModel(issuedBooksFile, IssuedBook.class);
      }
    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Couldn't load issued books file:" + e);
    }

    // Max the max ID of a librarian in the list of librarians
    issuedBooksList
      .stream()
      .max(Comparator.comparingInt(IssuedBook::getId))
      .ifPresent(issuedBook -> idCounter.set(issuedBook.getId()));
  }

  public static IssuedBooksManager getInstance() {
    return instance;
  }

  public boolean save(String bookCallNo, int studentId, String studentName, String studentContact) {
    Book bookToUpdate = checkBook(bookCallNo);

    if (bookToUpdate == null || bookToUpdate.getQuantity() == 0) {
      return false;
    }

    IssuedBook newIssuedBook = new IssuedBook(getInstance().idCounter.incrementAndGet(), bookCallNo, studentId, studentName, studentContact);
    getInstance().issuedBooksList.add(newIssuedBook);

    bookToUpdate.setQuantity(bookToUpdate.getQuantity() - 1);
    bookToUpdate.setIssued(bookToUpdate.getIssued() + 1);

    try {
      Utils.saveModel(new File(Utils.ISSUED_BOOKS_FILE), getInstance().issuedBooksList);
      Utils.saveModel(new File(Utils.BOOKS_FILE), BooksManager.getInstance().getBookList());
    } catch (IOException e) {
      System.err.println("Could not save the books into a file");
      return false;
    }

    return true;
  }

  public Book checkBook(String bookcallno) {
    return BooksManager.getInstance().getBookList()
      .stream()
      .filter(book -> book.getCallno().equals(bookcallno))
      .findFirst()
      .orElse(null);
  }

  public List<IssuedBook> getIssuedBooksList() {
    return issuedBooksList;
  }
}
