package com.library.maven;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides services for managing books and readers in the library.
 */
public class LibraryService {
  /** The list of books in the library. */
  private List<Book> books = new ArrayList<>();

  /** The list of readers in the library. */
  private List<Reader> readers = new ArrayList<>();

  /**
   * Adds a book to the library.
   *
   * @param title The title of the book
   * @return The added Book object
   */
  public Book addBook(String title) {
    Book book = new Book(title);
    books.add(book);
    return book;
  }

  /**
   * Adds a copy of a book to the specified book.
   *
   * @param book The book to which the copy will be added
   * @param copyId The unique identifier for the new copy
   */
  public void addCopy(Book book, int copyId) {
    book.addCopy(new BookCopy(copyId));
  }

  /**
   * Adds a reader to the library.
   *
   * @param name The name of the reader
   * @return The added Reader object
   */
  public Reader addReader(String name) {
    Reader reader = new Reader(name);
    readers.add(reader);
    return reader;
  }

  /**
   * Rents a book to a reader.
   *
   * @param reader The reader renting the book
   * @param title The title of the book to rent
   * @return true if the book was successfully rented, otherwise false
   */
  public boolean rentBook(Reader reader, String title) {
    Book book = findBookByTitle(title);
    if (book != null && !book.getAvailableCopies().isEmpty()) {
      BookCopy bookCopy = book.getAvailableCopies().get(0);
      bookCopy.setRented(true);
      reader.rentBook(book);
      return true;
    }
    return false;
  }

  /**
   * Finds a book by its title.
   *
   * @param title The title of the book
   * @return The found Book object, or null if not found
   */
  public Book findBookByTitle(String title) {
    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(title)) {
        return book;
      }
    }
    return null;
  }

  /**
   * Finds a reader by their name.
   *
   * @param name The name of the reader
   * @return The found Reader object, or null if not found
   */
  public Reader findReaderByName(String name) {
    for (Reader reader : readers) {
      if (reader.getName().equalsIgnoreCase(name)) {
        return reader;
      }
    }
    return null;
  }

  /**
   * Returns the list of books in the library.
   *
   * @return A list of books
   */
  public List<Book> getBooks() {
    return books;
  }

  /**
   * Returns the list of readers in the library.
   *
   * @return A list of readers
   */
  public List<Reader> getReaders() {
    return readers;
  }

  // GRASP: Controller - LibraryService acts as a mediator
  // between the user interface and the underlying data.
}
