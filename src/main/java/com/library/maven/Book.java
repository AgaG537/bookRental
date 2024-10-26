package com.library.maven;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a book in the library.
 */
public class Book {
  /** The title of the book. */
  private String title;

  /** The list of copies of the book. */
  private List<BookCopy> copies = new ArrayList<>();

  /**
   * Constructs a Book object.
   *
   * @param title The title of the book
   */
  public Book(String title) {
    this.title = title;
  }

  /**
   * Adds a copy of the book to the list of copies.
   *
   * @param bookCopy The copy of the book to be added
   */
  public void addCopy(BookCopy bookCopy) {
    copies.add(bookCopy);
  }

  /**
   * Returns the available copies of the book.
   *
   * @return A list of available copies of the book
   */
  public List<BookCopy> getAvailableCopies() {
    List<BookCopy> availableCopies = new ArrayList<>();
    for (BookCopy bookCopy : copies) {
      if (!bookCopy.isRented()) {
        availableCopies.add(bookCopy);
      }
    }
    return availableCopies;
  }

  /**
   * Returns the title of the book.
   *
   * @return The title of the book
   */
  public String getTitle() {
    return title;
  }

  /**
   * Returns the total number of copies of the book.
   *
   * @return Total number of copies
   */
  public int getTotalCopies() {
    return copies.size();
  }

  /**
   * Returns the number of available copies of the book.
   *
   * @return Number of available copies
   */
  public int getAvailableCopiesCount() {
    return getAvailableCopies().size();
  }

  // GRASP: Creator - The Book class is responsible for creating and managing its copies.
}
