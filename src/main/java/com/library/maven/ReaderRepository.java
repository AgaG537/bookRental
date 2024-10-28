package com.library.maven;

import java.util.List;

/**
 * Interface for managing readers in the library system.
 *
 * <p>This interface provides methods specific to handling readers, such as
 * adding new readers or searching for readers by name. Different
 * implementations may interact with various data sources.</p>
 */
public interface ReaderRepository {

  /**
   * Adds a new reader to the repository.
   *
   * @param name the name of the reader
   * @return the newly created Reader object
   */
  Reader addReader(String name);

  /**
   * Finds a reader by their name.
   *
   * @param name the name of the reader to search for
   * @return the Reader object if found, or null otherwise
   */
  Reader findReaderByName(String name);

  /**
   * Retrieves all readers in the repository.
   *
   * @return a list of all readers in the library
   */
  List<Reader> getReaders();
}
