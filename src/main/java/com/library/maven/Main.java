package com.library.maven;

/**
 * The main entry point for the library management system.
 */
public class Main {
  /**
   * Main method to run the library console service.
   *
   * @param args Command line arguments
   */
  public static void main(String[] args) {
    ConsoleService consoleService = new ConsoleService();
    consoleService.run();
  }

  // GRASP: High Cohesion - The Main class encapsulates the startup logic for the application.
}
