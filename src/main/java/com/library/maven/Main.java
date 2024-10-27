package com.library.maven;

/**
 * The main entry point for the library management system.
 *
 * <p>
 * This class initializes and starts the console-based library system by
 * creating an instance of `ConsoleService` and invoking its `run` method.
 * </p>
 *
 * <p>
 * GRASP: Pure Fabrication - Main acts as a fabricated entry point to separate
 * initialization logic from business logic, keeping it cohesive and maintainable.
 * </p>
 */
public class Main {

  /**
   * Main method to run the library console service.
   *
   * @param args Command line arguments (not used in this application)
   */
  public static void main(String[] args) {
    // Initialize ConsoleService, which will handle user interactions and library operations
    ConsoleService consoleService = new ConsoleService();

    // Start the console service to interact with the user
    consoleService.run();
  }
}
