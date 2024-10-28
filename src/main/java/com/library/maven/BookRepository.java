package com.library.maven;

import java.util.List;

/**
 * Interface for managing books in the library system.
 *
 * <p>This interface follows the Interface Segregation Principle, focusing only
 * on operations related to books and their copies. Implementations could
 * connect to a database, file storage, or in-memory collection.</p>
 */
public interface BookRepository {

  /**
   * Adds a new book to the repository.
   *
   * @param title the title of the book
   * @return the newly created Book object
   */
  Book addBook(String title);

  /**
   * Adds a new copy of a specific book to the repository.
   *
   * @param book the book to which the copy will be added
   * @param copyId a unique identifier for the new copy
   */
  void addCopy(Book book, int copyId);

  /**
   * Finds a book by its title.
   *
   * @param title the title of the book to search for
   * @return the Book object if found, or null otherwise
   */
  Book findBookByTitle(String title);

  /**
   * Retrieves all books in the repository.
   *
   * @return a list of all books in the library
   */
  List<Book> getBooks();
}
