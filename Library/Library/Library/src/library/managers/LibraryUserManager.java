package library.managers;

import library.Utils;
import library.models.Librarian;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LibraryUserManager {
  final static LibraryUserManager instance = new LibraryUserManager();

  final AtomicInteger idCounter = new AtomicInteger();
  private List<Librarian> librarianList = new ArrayList<>();

  // Private constructor, prevents multiple objects from being created
  private LibraryUserManager() {
    File librariansFile = new File(Utils.LIBRARIANS_FILE);

    try {
      if (librariansFile.exists() && !librariansFile.isDirectory()) {
        librarianList = Utils.loadModel(librariansFile, Librarian.class);
      }
    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Couldn't load librarians file:" + e);
    }

    // Max the max ID of a librarian in the list of librarians
    librarianList
      .stream()
      .max(Comparator.comparingInt(Librarian::getId))
      .ifPresent(librarian -> idCounter.set(librarian.getId()));
  }

  public static LibraryUserManager getInstance() {
    return instance;
  }

  public boolean save(String name, String password, String email, String address, String city, String contact) {
    final Librarian newLibrarian = new Librarian(getInstance().idCounter.incrementAndGet(), name, password, email, address, city, contact);
    getInstance().librarianList.add(newLibrarian);

    try {
      Utils.saveModel(new File(Utils.LIBRARIANS_FILE), getInstance().librarianList);
    } catch (IOException e) {
      System.err.println("Could not save the librarians into a file");
      return false;
    }

    return true;
  }

  public boolean delete(int id) {
    Librarian librarianToDelete = getInstance().librarianList
      .stream()
      .filter(librarian -> librarian.getId() == id)
      .findFirst()
      .orElse(null);

    if (librarianToDelete == null) {
      System.err.println("Cannot delete librarian: invalid ID");
      return false;
    }

    getInstance().librarianList.remove(librarianToDelete);

    try {
      Utils.saveModel(new File(Utils.LIBRARIANS_FILE), getInstance().librarianList);
    } catch (IOException e) {
      System.err.println("Could not save the librarians into a file");
      return false;
    }

    return true;
  }

  public static boolean validate(String name, String password) {
    Librarian librarianWithCredentials = getInstance().librarianList
      .stream()
      .filter(librarian -> librarian.getName().equals(name) && librarian.getPassword().equals(password))
      .findFirst()
      .orElse(null);

    return librarianWithCredentials != null;
  }

  public List<Librarian> getLibrarianList() {
    return librarianList;
  }
}
