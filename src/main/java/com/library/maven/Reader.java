
//Reader.java
package com.library.maven;

import java.util.ArrayList;
import java.util.List;

public class Reader {
  private String name;
  private List<Book> rentedBooks = new ArrayList<>();

  public Reader(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void rentBook(Book book) {
    rentedBooks.add(book);
  }

  public List<Book> getRentedBooks() {
    return rentedBooks;
  }
}
