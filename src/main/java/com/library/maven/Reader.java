package com.library.maven;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library member who can rent books.
 * <p>
 * GRASP: Information Expert - Reader knows and manages the books they have rented.
 */
public class Reader {
  /** The name of the reader. */
  private String name;

  /** The list of rentals associated with the reader. */
  private List<Rental> rentals = new ArrayList<>();

  /**
   * Constructs a new Reader with the specified name.
   *
   * @param name the name of the reader
   */
  public Reader(String name) {
    this.name = name;
  }

  /**
   * Returns the name of the reader.
   *
   * @return The name of the reader
   */
  public String getName() {
    return name;
  }

  /**
   * Adds a rental to the reader's list of rentals.
   * <p>
   * GRASP: Information Expert - Reader manages and tracks its own rentals.
   *
   * @param rental The rental to be added
   */
  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  /**
   * Returns the list of rentals for this reader.
   *
   * @return A list of rentals associated with the reader
   */
  public List<Rental> getRentals() {
    return rentals;
  }
}
