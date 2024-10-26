package com.library.maven;

import java.util.ArrayList;
import java.util.List;

public class Book {
  private String title;
  private List<BookCopy> copies = new ArrayList<>();

  public Book(String title) {
    this.title = title;
  }

  public void addCopy(BookCopy bookCopy) {
    copies.add(bookCopy);
  }

  public List<BookCopy> getAvailableCopies() {
    List<BookCopy> availableCopies = new ArrayList<>();
    for (BookCopy bookCopy : copies) {
      if (!bookCopy.isRented()) availableCopies.add(bookCopy);
    }
    return availableCopies;
  }

  public String getTitle() {
    return title;
  }

  public int getTotalCopies() {
    return copies.size();
  }

  public int getAvailableCopiesCount() {
    return getAvailableCopies().size();
  }
}
