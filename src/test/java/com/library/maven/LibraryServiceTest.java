package com.library.maven;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceTest {

  @Test
  public void testAddBook() {
    LibraryService libraryService = new LibraryService();
    Book book = libraryService.addBook("Witcher");
    assertNotNull(book);
    assertEquals("Witcher", book.getTitle());
  }

  @Test
  public void testRentBook() {
    LibraryService libraryService = new LibraryService();
    Book book = libraryService.addBook("Witcher");
    libraryService.addCopy(book, 1);
    libraryService.addReader("Jan Kowalski");

    Reader reader = new Reader("Jan Kowalski");
    assertTrue(libraryService.rentBook(reader, "Witcher"));
    assertTrue(book.getAvailableCopies().isEmpty());
  }
}