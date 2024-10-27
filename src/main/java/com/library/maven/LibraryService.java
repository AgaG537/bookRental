package com.library.maven;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages core business logic for the library system.
 *
 * <p>
 * GRASP: Controller - LibraryService orchestrates the main operations,
 * such as adding books, managing readers, and handling rentals.
 * </p>
 */
public class LibraryService {
  /** The list of books in the library. */
  private final List<Book> books = new ArrayList<>();

  /** The list of readers in the library. */
  private final List<Reader> readers = new ArrayList<>();

  /**
   * Adds a new book to the library system.
   *
   * <p>
   * GRASP: Information Expert - LibraryService maintains
   * the collection of books in the library.
   * </p>
   *
   * @param title The title of the book
   * @return The created Book object
   */
  public Book addBook(String title) {
    Book book = new Book(title);
    books.add(book);
    return book;
  }

  /**
   * Adds a copy to a specific book in the library.
   *
   * <p>
   * GRASP: Low Coupling - LibraryService interacts with books
   * at a high level, leaving copy management to the Book class.
   * </p>
   *
   * @param book The book to which the copy will be added
   * @param copyId Unique identifier for the new copy
   */
  public void addCopy(Book book, int copyId) {
    book.addCopy(new BookCopy(copyId));
  }

  /**
   * Adds a new reader to the library.
   *
   * <p>
   * GRASP: Creator - LibraryService is responsible
   * for creating and managing Reader instances.
   * </p>
   *
   * @param name The name of the reader
   */
  public void addReader(String name) {
    Reader reader = new Reader(name);
    readers.add(reader);
  }

  /**
   * Rents a book copy to a reader, creating a rental record.
   *
   * <p>
   * GRASP: Controller - LibraryService coordinates the rental process,
   * creating a Rental and updating the Reader and BookCopy statuses.
   * </p>
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
      Rental rental = new Rental(book, bookCopy);
      reader.addRental(rental);
      return true;
    }
    return false;
  }

  /**
   * Finds a book by its title in the library.
   *
   * <p>
   * GRASP: Information Expert - LibraryService manages the
   * collection of books and can search by title.
   * </p>
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
   * Finds a reader by their name in the library.
   *
   * <p>
   * GRASP: Information Expert - LibraryService manages
   * the collection of readers and can search by name.
   * </p>
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
}
