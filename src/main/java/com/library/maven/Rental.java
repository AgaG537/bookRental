package com.library.maven;

/**
 * Represents a rental transaction for a book copy.
 */
public class Rental {
  /** The book involved in the rental. */
  private Book book;

  /** The copy of the book being rented. */
  private BookCopy bookCopy;

  /**
   * Constructs a Rental object.
   *
   * @param book The book being rented
   * @param bookCopy The copy of the book being rented
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
   * Returns the copy of the book being rented.
   *
   * @return The copy of the book being rented
   */
  public BookCopy getCopy() {
    return bookCopy;
  }

  // GRASP: High Cohesion - The Rental class encapsulates the
  // rental details, ensuring related data is managed together.
}
