package library.managers;

import library.Utils;
import library.models.Book;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BooksManager {
  private final static BooksManager instance = new BooksManager();

  final AtomicInteger idCounter = new AtomicInteger();
  private List<Book> bookList = new ArrayList<>();

  // Private constructor, prevents multiple objects from being created
  private BooksManager() {
    File booksFile = new File(Utils.BOOKS_FILE);

    try {
      if (booksFile.exists() && !booksFile.isDirectory()) {
        bookList = Utils.loadModel(booksFile, Book.class);
      }
    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Couldn't load books file:" + e);
    }

    // Max the max ID of a librarian in the list of library user.
    bookList
      .stream()
      .max(Comparator.comparingInt(Book::getId))
      .ifPresent(book -> idCounter.set(book.getId()));
  }

  public static BooksManager getInstance() {
    return instance;
  }

  public boolean save(String callno, String name, String author, String publisher, int quantity) {
    final Book newBook = new Book(getInstance().idCounter.incrementAndGet(), callno, name, author, publisher, quantity);
    getInstance().bookList.add(newBook);

    try {
      Utils.saveModel(new File(Utils.BOOKS_FILE), getInstance().bookList);
    } catch (IOException e) {
      System.err.println("Could not save the books into a file");
      return false;
    }

    return true;
  }


  public List<Book> getBookList() {
    return bookList;
  }
}
