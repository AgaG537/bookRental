

//LibraryService.java
package com.library.maven;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
  private List<Book> books = new ArrayList<>();
  private List<Reader> readers = new ArrayList<>();

  public Book addBook(String title) {
    Book book = new Book(title);
    books.add(book);
    return book;
  }

  public void addCopy(Book book, int copyId) {
    book.addCopy(new BookCopy(copyId));
  }

  public Reader addReader(String name) {
    Reader reader = new Reader(name);
    readers.add(reader);
    return reader;
  }

  public boolean rentBook(Reader reader, String title) {
    Book book = findBookByTitle(title);
    if (book != null && !book.getAvailableCopies().isEmpty()) {
      BookCopy bookCopy = book.getAvailableCopies().get(0);
      bookCopy.setRented(true);
      reader.rentBook(book);
      return true;
    }
    return false;
  }

  public Book findBookByTitle(String title) {
    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(title)) {
        return book;
      }
    }
    return null;
  }

  public Reader findReaderByName(String name) {
    for (Reader reader : readers) {
      if (reader.getName().equalsIgnoreCase(name)) {
        return reader;
      }
    }
    return null;
  }

  public List<Book> getBooks() {
    return books;
  }

  public List<Reader> getReaders() {
    return readers;
  }
}
