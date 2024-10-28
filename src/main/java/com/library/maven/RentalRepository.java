package com.library.maven;

/**
 * Interface for managing book rentals in the library system.
 *
 * <p>This interface focuses on operations related to renting books, ensuring
 * the separation of responsibilities in managing rental transactions. Different
 * implementations may use various data storage methods.</p>
 */
public interface RentalRepository {

  /**
   * Rents a book copy to a reader.
   *
   * @param reader the reader who is renting the book
   * @param title the title of the book to be rented
   * @return true if the rental was successful, false if the book is not available
   */
  boolean rentBook(Reader reader, String title);
}
