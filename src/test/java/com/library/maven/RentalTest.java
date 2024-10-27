package com.library.maven;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Rental} class.
 *
 * <p>Tests the storage and retrieval of rental attributes such as the book and copy details.</p>
 */
class RentalTest {

  /**
   * Tests the retrieval of book and copy attributes in a rental.
   */
  @Test
  void testRentalAttributes() {
    Book book = new Book("To Kill a Mockingbird");
    BookCopy copy = new BookCopy(1);
    Rental rental = new Rental(book, copy);

    assertEquals(book, rental.getBook());
    assertEquals(copy, rental.getCopy());
  }
}

