package com.library.maven;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Book} class.
 *
 * <p>Tests the functionality of adding copies, retrieving available copies,
 * and managing total and available copies.</p>
 */
class BookTest {

  /**
   * Tests the addition of a copy to a book.
   */
  @Test
  void testAddCopy() {
    Book book = new Book("Macbeth");
    BookCopy copy1 = new BookCopy(1);
    book.addCopy(copy1);

    assertEquals(1, book.getTotalCopies());
  }

  /**
   * Tests the retrieval of available copies of a book.
   * Ensures that rented copies are excluded from available copies.
   */
  @Test
  void testGetAvailableCopies() {
    Book book = new Book("Hamlet");
    BookCopy copy1 = new BookCopy(1);
    BookCopy copy2 = new BookCopy(2);

    book.addCopy(copy1);
    book.addCopy(copy2);

    copy1.setRented(true);

    assertEquals(1, book.getAvailableCopiesCount());
    assertTrue(book.getAvailableCopies().contains(copy2));
  }
}
