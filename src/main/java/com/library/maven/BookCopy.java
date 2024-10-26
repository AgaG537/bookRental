package com.library.maven;

public class BookCopy {
  private final int copyId;
  private boolean isRented;

  public BookCopy(int copyId) {
    this.copyId = copyId;
    this.isRented = false;
  }

  public boolean isRented() { return isRented; }
  public void setRented(boolean rented) { isRented = rented; }
  public int getCopyId() { return copyId; }
}