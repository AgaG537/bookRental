package com.library.maven;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Reader} class.
 *
 * <p>Tests the management of rentals for a reader.</p>
 */
class ReaderTest {

  /**
   * Tests adding a rental to the reader's list of rentals.
   */
  @Test
  void testAddRental() {
    Reader reader = new Reader("John Doe");
    Book book = new Book("The Alchemist");
    BookCopy copy = new BookCopy(1);
    Rental rental = new Rental(book, copy);

    reader.addRental(rental);

    assertEquals(1, reader.getRentals().size());
    assertEquals(rental, reader.getRentals().get(0));
  }
}
