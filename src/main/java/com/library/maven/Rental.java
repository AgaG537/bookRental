
//Rental.java
package com.library.maven;

public class Rental {
  private Book book;
  private BookCopy bookCopy;

  public Rental(Book book, BookCopy bookCopy) {
    this.book = book;
    this.bookCopy = bookCopy;
  }

  public Book getBook() { return book; }
  public BookCopy getCopy() { return bookCopy; }
}
