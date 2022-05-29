package library;

import java.io.*;
import java.util.List;

public class Utils {
  public static String LIBRARIANS_FILE = "librarians.bin";
  public static String BOOKS_FILE = "books.bin";
  public static String ISSUED_BOOKS_FILE = "issued.bin";

  public static <T> void saveModel(File savedFile, List<T> mList) throws IOException {
    try (FileOutputStream fileOutputStream = new FileOutputStream(savedFile);
         ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
      objectOutputStream.writeObject(mList);
      System.out.println("Saving done");
    }
  }

  @SuppressWarnings("unchecked")
  public static <T> List<T> loadModel(File loadedFile, Class<T> tClass) throws IOException, ClassNotFoundException {
    try (FileInputStream fileInputStream = new FileInputStream(loadedFile);
         ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

      List<T> modelList = (List<T>) objectInputStream.readObject();
      System.out.printf(" class %s Completed%n", tClass);
      return modelList;
    }
  }

  public static boolean isNumeric(String string) {
    try {
      Double.parseDouble(string);
    } catch(NumberFormatException e){
      return false;
    }

    return true;
  }
}
