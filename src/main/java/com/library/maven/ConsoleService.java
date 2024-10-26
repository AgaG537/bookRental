

//ConsoleService.java
package com.library.maven;

import java.util.Scanner;

public class ConsoleService {
  private final LibraryService libraryService = new LibraryService();
  private final Scanner scanner = new Scanner(System.in);

  public void run() {
    while (true) {
      System.out.println("\nChoose an option:");
      System.out.println("1. Add Book");
      System.out.println("2. Add Reader");
      System.out.println("3. Rent a Book");
      System.out.println("4. Show all Books");
      System.out.println("5. Show all Readers");
      System.out.println("6. Exit");

      int choice = scanner.nextInt();
      scanner.nextLine(); // Clear newline
      switch (choice) {
        case 1 -> addBook();
        case 2 -> addReader();
        case 3 -> rentBook();
        case 4 -> showBooks();
        case 5 -> showReaders();
        case 6 -> {
          System.out.println("Exiting system...");
          return;
        }
        default -> System.out.println("Invalid choice. Try again.");
      }
    }
  }

  private void addBook() {
    System.out.println("Enter book title:");
    String title = scanner.nextLine();
    Book book = libraryService.findBookByTitle(title);

    if (book == null) {
      // If book does not exist, create it and add copies
      book = libraryService.addBook(title);
      System.out.println("Enter number of copies to add:");
      int numCopies = scanner.nextInt();
      scanner.nextLine(); // Clear newline
      for (int i = 1; i <= numCopies; i++) {
        libraryService.addCopy(book, i);
      }
      System.out.println("Book added successfully with " + numCopies + " copies.");
    } else {
      // If book exists, ask for additional copies to add
      System.out.println("Book already exists. Adding more copies.");
      System.out.println("Enter number of additional copies to add:");
      int additionalCopies = scanner.nextInt();
      scanner.nextLine(); // Clear newline
      int currentCopyCount = book.getTotalCopies();
      for (int i = 1; i <= additionalCopies; i++) {
        libraryService.addCopy(book, currentCopyCount + i);
      }
      System.out.println(additionalCopies + " copies added successfully.");
    }
  }

  private void addReader() {
    System.out.println("Enter reader's name:");
    String name = scanner.nextLine();
    libraryService.addReader(name);
    System.out.println("Reader added successfully.");
  }

  private void rentBook() {
    System.out.println("Enter reader's name:");
    String readerName = scanner.nextLine();
    Reader reader = libraryService.findReaderByName(readerName);

    if (reader == null) {
      System.out.println("Reader not found.");
      return;
    }

    System.out.println("Enter book title:");
    String title = scanner.nextLine();

    if (libraryService.rentBook(reader, title)) {
      System.out.println("Book rented successfully.");
    } else {
      System.out.println("Book not available.");
    }
  }

  private void showBooks() {
    System.out.println("Available Books:");
    for (Book book : libraryService.getBooks()) {
      System.out.printf("Title: %s, Total Copies: %d, Available Copies: %d%n",
          book.getTitle(), book.getTotalCopies(), book.getAvailableCopiesCount());
    }
  }

  private void showReaders() {
    System.out.println("Readers:");
    for (Reader reader : libraryService.getReaders()) {
      System.out.printf("Name: %s, Books Rented: %d%n",
          reader.getName(), reader.getRentedBooks().size());
    }
  }
}
