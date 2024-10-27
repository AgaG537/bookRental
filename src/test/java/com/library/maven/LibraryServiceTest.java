package com.library.maven;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link LibraryService} class.
 *
 * <p>Tests core functionalities of the library service, including book and reader management,
 * as well as the rental process.</p>
 */
class LibraryServiceTest {

  /**
   * Tests adding a new book to the library.
   */
  @Test
  void testAddBook() {
    LibraryService libraryService = new LibraryService();
    Book book = libraryService.addBook("Hobbit");

    assertNotNull(book);
    assertEquals("Hobbit", book.getTitle());
    assertEquals(1, libraryService.getBooks().size());
  }

  /**
   * Tests adding a new reader to the library.
   */
  @Test
  void testAddReader() {
    LibraryService libraryService = new LibraryService();
    libraryService.addReader("Alex Jones");

    assertEquals(1, libraryService.getReaders().size());
    assertEquals("Alex Jones", libraryService.getReaders().get(0).getName());
  }

  /**
   * Tests renting a book for a reader.
   * Verifies that the book's copy availability updates correctly and that the rental is recorded for the reader.
   */
  @Test
  void testRentBook() {
    LibraryService libraryService = new LibraryService();
    Book book = libraryService.addBook("Harry Potter");
    libraryService.addCopy(book, 1);
    libraryService.addReader("John Smith");

    Reader reader = libraryService.findReaderByName("John Smith");
    boolean rented = libraryService.rentBook(reader, "Harry Potter");

    assertTrue(rented);
    assertEquals(0, book.getAvailableCopiesCount());
    assertEquals(1, reader.getRentals().size());
  }

  /**
   * Tests finding a book by its title.
   */
  @Test
  void testFindBookByTitle() {
    LibraryService libraryService = new LibraryService();
    libraryService.addBook("Frankenstein");

    Book book = libraryService.findBookByTitle("Frankenstein");
    assertNotNull(book);
    assertEquals("Frankenstein", book.getTitle());
  }

  /**
   * Tests finding a reader by their name.
   */
  @Test
  void testFindReaderByName() {
    LibraryService libraryService = new LibraryService();
    libraryService.addReader("Tom Brown");

    Reader reader = libraryService.findReaderByName("Tom Brown");
    assertNotNull(reader);
    assertEquals("Tom Brown", reader.getName());
  }
}
