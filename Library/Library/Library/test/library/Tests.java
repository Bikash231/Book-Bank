package library;

import library.managers.BooksManager;
import library.managers.IssuedBooksManager;
import library.managers.LibraryUserManager;
import library.managers.ReturnBooksManager;
import library.models.Book;
import library.models.IssuedBook;
import library.models.Librarian;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class Tests {

  @Test
  public void addLibrarian() throws IOException, ClassNotFoundException {
    String name = "testName";
    String pass = "testPw";
    String email = "testEmail";
    String addr = "testAddr";
    String city = "testCity";
    String contact = "testContact";

    LibraryUserManager.getInstance().save(name, pass, email, addr, city, contact);

    List<Librarian> fileLibrarianList = Utils.loadModel(new File(Utils.LIBRARIANS_FILE), Librarian.class);
    Librarian foundLibrarianInFile = fileLibrarianList.stream().filter(lib ->
      lib.getName().equals(name) && lib.getPassword().equals(pass) &&
        lib.getEmail().equals(email) && lib.getAddress().equals(addr) &&
        lib.getCity().equals(city) && lib.getContact().equals(contact)
    )
    .findFirst()
    .orElse(null);

    Librarian foundLibrarianInManager = LibraryUserManager.getInstance().getLibrarianList().stream().filter(lib ->
      lib.getName().equals(name) && lib.getPassword().equals(pass) &&
      lib.getEmail().equals(email) && lib.getAddress().equals(addr) &&
      lib.getCity().equals(city) && lib.getContact().equals(contact)
    )
    .findFirst()
    .orElse(null);

    assertNotNull(foundLibrarianInFile, "Librarian not saved in file");
    assertNotNull(foundLibrarianInManager, "Librarian not saved in manager list");

    fileLibrarianList.remove(foundLibrarianInFile);
    Utils.saveModel(new File(Utils.LIBRARIANS_FILE), fileLibrarianList);
  }

  @Test
  public void addBook() throws IOException, ClassNotFoundException {
    String callno = "testNo";
    String name = "testName";
    String author = "testEmail";
    String publisher = "testAddr";
    int quantity = 9999;

    BooksManager.getInstance().save(callno, name, author, publisher, quantity);

    List<Book> fileBookList = Utils.loadModel(new File(Utils.BOOKS_FILE), Book.class);
    Book foundBookInFile = fileBookList.stream().filter(book ->
      book.getCallno().equals(callno) && book.getName().equals(name) &&
      book.getAuthor().equals(author) && book.getPublisher().equals(publisher) &&
      book.getQuantity() == quantity
    )
    .findFirst()
    .orElse(null);

    Book foundBookInManager = BooksManager.getInstance().getBookList().stream().filter(book ->
      book.getCallno().equals(callno) && book.getName().equals(name) &&
        book.getAuthor().equals(author) && book.getPublisher().equals(publisher) &&
        book.getQuantity() == quantity
    )
    .findFirst()
    .orElse(null);

    assertNotNull(foundBookInFile, "Book not saved in file");
    assertNotNull(foundBookInManager, "Book not saved in manager list");

    fileBookList.remove(foundBookInFile);
    Utils.saveModel(new File(Utils.BOOKS_FILE), fileBookList);
  }

  @Test
  public void issueBook() throws IOException, ClassNotFoundException {
    // Add book
    String callno = "testNo";
    String name = "testName";
    String author = "testEmail";
    String publisher = "testAddr";
    int quantity = 9999;

    BooksManager.getInstance().save(callno, name, author, publisher, quantity);

    // Issue book
    String bookCallNo = "testNo";
    int studentId = 9999;
    String studentName =  "testName";
    String studentContact = "testContact";

    IssuedBooksManager.getInstance().save(bookCallNo, studentId, studentName, studentContact);


    List<IssuedBook> fileIssuedBookList = Utils.loadModel(new File(Utils.ISSUED_BOOKS_FILE), IssuedBook.class);
    IssuedBook foundIssuedBookInFile = fileIssuedBookList.stream().filter(book ->
      book.getBookCallNumber().equals(bookCallNo) && book.getStudentId() == studentId &&
      book.getStudentName().equals(studentName) && book.getStudentContact().equals(studentContact)
    )
    .findFirst()
    .orElse(null);

    IssuedBook foundIssuedBookInManager = IssuedBooksManager.getInstance().getIssuedBooksList().stream().filter(book ->
      book.getBookCallNumber().equals(bookCallNo) && book.getStudentId() == studentId &&
      book.getStudentName().equals(studentName) && book.getStudentContact().equals(studentContact)
    )
    .findFirst()
    .orElse(null);

    Book addedBook = BooksManager.getInstance().getBookList()
      .stream()
      .filter(book -> book.getCallno().equals(callno))
      .findFirst()
      .orElse(null);

    assertNotNull(foundIssuedBookInFile, "IssuedBook not saved in file");
    assertNotNull(foundIssuedBookInManager, "IssuedBook not saved in manager list");

    fileIssuedBookList.remove(foundIssuedBookInFile);
    BooksManager.getInstance().getBookList().remove(addedBook);
    Utils.saveModel(new File(Utils.ISSUED_BOOKS_FILE), fileIssuedBookList);
    Utils.saveModel(new File(Utils.BOOKS_FILE), BooksManager.getInstance().getBookList());
  }

  @Test
  public void returnBook() throws IOException, ClassNotFoundException {
    String bookCallNo = "test";
    int studentId = 9999;
    String studentName =  "testName";
    String studentContact = "testContact";

    IssuedBooksManager.getInstance().save(bookCallNo, studentId, studentName, studentContact);

    ReturnBooksManager.delete(bookCallNo, studentId);

    List<IssuedBook> fileIssuedBookList = Utils.loadModel(new File(Utils.ISSUED_BOOKS_FILE), IssuedBook.class);
    IssuedBook foundIssuedBookInFile = fileIssuedBookList
      .stream()
      .filter(book -> book.getBookCallNumber().equals(bookCallNo) && book.getStudentId() == studentId)
      .findFirst()
      .orElse(null);

    IssuedBook foundIssuedBookInManager = IssuedBooksManager.getInstance().getIssuedBooksList()
      .stream()
      .filter(book -> book.getBookCallNumber().equals(bookCallNo) && book.getId() == studentId)
      .findFirst()
      .orElse(null);

    assertNull(foundIssuedBookInFile, "Issued book not deleted from file");
    assertNull(foundIssuedBookInManager, "Issued book not deleted from manager list");
  }

  @Test
  public void deleteLibrarian() throws IOException, ClassNotFoundException {
    String name = "testName";
    String pass = "testPw";
    String email = "testEmail";
    String addr = "testAddr";
    String city = "testCity";
    String contact = "testContact";

    LibraryUserManager.getInstance().save(name, pass, email, addr, city, contact);

    Librarian addedLibrarian = LibraryUserManager.getInstance().getLibrarianList()
      .stream()
      .max(Comparator.comparingInt(Librarian::getId))
      .orElse(null);

    assertNotNull(addedLibrarian, "Added librarian does not exist");

    LibraryUserManager.getInstance().delete(addedLibrarian.getId());

    List<Librarian> fileLibrarianList = Utils.loadModel(new File(Utils.LIBRARIANS_FILE), Librarian.class);
    Librarian foundLibrarianInFile = fileLibrarianList.stream().filter(lib -> lib.getId() == addedLibrarian.getId())
      .findFirst()
      .orElse(null);

    Librarian foundLibrarianInManager = LibraryUserManager.getInstance().getLibrarianList()
      .stream()
      .filter(lib -> lib.getId() == addedLibrarian.getId())
      .findFirst()
      .orElse(null);

    assertNull(foundLibrarianInFile, "Deleted librarian still in file");
    assertNull(foundLibrarianInManager, "Deleted librarian still in manager list");
  }

}
