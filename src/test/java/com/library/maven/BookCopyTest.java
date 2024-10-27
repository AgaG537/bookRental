package com.library.maven;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link BookCopy} class.
 *
 * <p>Tests the management of copy rental status and identifier.</p>
 */
class BookCopyTest {

  /**
   * Tests setting and checking the rental status of a book copy.
   */
  @Test
  void testSetRented() {
    BookCopy copy = new BookCopy(1);
    assertFalse(copy.isRented());

    copy.setRented(true);
    assertTrue(copy.isRented());

    copy.setRented(false);
    assertFalse(copy.isRented());
  }

  /**
   * Tests retrieval of the unique identifier for a book copy.
   */
  @Test
  void testGetCopyId() {
    BookCopy copy = new BookCopy(5);
    assertEquals(5, copy.getCopyId());
  }
}
