package com.library.maven;

/**
 * Represents a rental transaction for a specific book copy.
 * <p>
 * GRASP: Information Expert - Rental manages details of the rented book and its specific copy.
 */
public class Rental {
  /** The book involved in the rental. */
  private Book book;

  /** The specific copy of the book being rented. */
  private BookCopy bookCopy;

  /**
   * Constructs a new Rental for the specified book and book copy.
   *
   * @param book The book being rented
   * @param bookCopy The specific copy of the book being rented
   */
  public Rental(Book book, BookCopy bookCopy) {
    this.book = book;
    this.bookCopy = bookCopy;
  }

  /**
   * Returns the book being rented.
   *
   * @return The book being rented
   */
  public Book getBook() {
    return book;
  }

  /**
   * Returns the specific copy of the book being rented.
   *
   * @return The copy of the book being rented
   */
  public BookCopy getCopy() {
    return bookCopy;
  }
}
