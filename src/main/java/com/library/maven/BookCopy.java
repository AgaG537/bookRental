package com.library.maven;

/**
 * Represents a copy of a book in the library.
 */
public class BookCopy {
  /** Unique identifier for the book copy. */
  private final int copyId;

  /** Indicates whether the copy is currently rented. */
  private boolean isRented;

  /**
   * Constructs a new BookCopy with the specified copy ID.
   *
   * @param copyId Unique identifier for the copy
   */
  public BookCopy(int copyId) {
    this.copyId = copyId;
    this.isRented = false;
  }

  /**
   * Checks if the copy is rented.
   *
   * @return true if the copy is rented, otherwise false
   */
  public boolean isRented() {
    return isRented;
  }

  /**
   * Sets the rental status of the copy.
   *
   * @param rented true if the copy should be marked as rented, otherwise false
   */
  public void setRented(boolean rented) {
    isRented = rented;
  }

  /**
   * Returns the unique identifier for the copy.
   *
   * @return The unique identifier for the copy
   */
  public int getCopyId() {
    return copyId;
  }
}
