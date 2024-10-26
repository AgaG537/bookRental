package com.library.maven;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a reader in the library.
 */
public class Reader {
  /** The name of the reader. */
  private String name;

  /** The list of rented books. */
  private List<Book> rentedBooks = new ArrayList<>();

  /**
   * Constructs a Reader object.
   *
   * @param name The name of the reader
   */
  public Reader(String name) {
    this.name = name;
  }

  /**
   * Returns the name of the reader.
   *
   * @return The name of the reader
   */
  public String getName() {
    return name;
  }

  /**
   * Adds a book to the list of rented books.
   *
   * @param book The book to be rented
   */
  public void rentBook(Book book) {
    rentedBooks.add(book);
  }

  /**
   * Returns the list of rented books.
   *
   * @return A list of rented books
   */
  public List<Book> getRentedBooks() {
    return rentedBooks;
  }

  // GRASP: Low Coupling - Reader class maintains its own
  // rented books without tightly coupling with other classes.
}
