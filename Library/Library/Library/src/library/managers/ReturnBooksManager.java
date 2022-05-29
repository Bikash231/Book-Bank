package library.managers;

import library.Utils;
import library.models.Book;
import library.models.IssuedBook;

import java.io.File;
import java.io.IOException;

public class ReturnBooksManager {

  public static boolean delete(String bookcallno, int studentid) {
    IssuedBook issuedBookToDelete = IssuedBooksManager.getInstance().getIssuedBooksList()
      .stream()
      .filter(issuedBook -> issuedBook.getBookCallNumber().equals(bookcallno) && issuedBook.getStudentId() == studentid)
      .findFirst()
      .orElse(null);

    if (issuedBookToDelete == null) {
      System.err.println("Cannot return book: book not found");
      return false;
    }

    if (updatebook(bookcallno)) {
      IssuedBooksManager.getInstance().getIssuedBooksList().remove(issuedBookToDelete);

      try {
        Utils.saveModel(new File(Utils.ISSUED_BOOKS_FILE), IssuedBooksManager.getInstance().getIssuedBooksList());
        Utils.saveModel(new File(Utils.BOOKS_FILE), BooksManager.getInstance().getBookList());
      } catch (IOException e) {
        System.err.println("Could not save the books into a file");
        return false;
      }
    }

    return true;
  }

  private static boolean updatebook(String bookcallno) {
    Book bookToUpdate = BooksManager.getInstance().getBookList()
      .stream()
      .filter(book -> book.getCallno().equals(bookcallno))
      .findFirst()
      .orElse(null);

    if (bookToUpdate == null) {
      return false;
    }

    if (bookToUpdate.getIssued() > 0) {
      bookToUpdate.setQuantity(bookToUpdate.getQuantity() + 1);
      bookToUpdate.setIssued(bookToUpdate.getIssued() - 1);
    }

    return true;
  }
}
