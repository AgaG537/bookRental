package com.library.maven;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a book in the library.
 *
 * <p>
 * GRASP: Information Expert - Book knows its own copies and manages availability details.
 */
public class Book {
  /** The title of the book. */
  private final String title;

  /** The list of copies of this book. */
  private final List<BookCopy> copies = new ArrayList<>();

  /**
   * Constructs a new Book with the specified title.
   *
   * @param title the title of the book
   */
  public Book(String title) {
    this.title = title;
  }

  /**
   * Adds a copy to the book's collection of copies.
   *
   * <p>
   * GRASP: High Cohesion - Book focuses solely on managing its copies and their status.
   *
   * @param bookCopy The copy of the book to be added
   */
  public void addCopy(BookCopy bookCopy) {
    copies.add(bookCopy);
  }

  /**
   * Returns the list of available copies of the book.
   *
   * <p>
   * GRASP: Information Expert - Book determines which copies are available.
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
   * Returns the total number of copies of this book.
   *
   * @return The total number of copies
   */
  public int getTotalCopies() {
    return copies.size();
  }

  /**
   * Returns the number of available copies of this book.
   *
   * @return The number of available copies
   */
  public int getAvailableCopiesCount() {
    return getAvailableCopies().size();
  }
}
