package org.example;

import java.sql.SQLOutput;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {
    // Press Ctrl+1 with your caret at the highlighted text to see how
    // IntelliJ IDEA suggests fixing it.

    // Press Alt+Shift+X or click the green arrow button in the gutter to run the code.
    for (int i = 1; i <= 5; i++) {

      // Press Alt+Shift+D to start debugging your code. We have set one breakpoint
      // for you, but you can always add more by pressing Ctrl+Shift+B.
      System.out.println("i = " + i);
    }

    System.out.println();
    System.out.println();
    System.out.println();

    System.out.println("Hello Wolrd!");
    Student s1 = new Student("22000000", "홍참");
    System.out.println(s1.toString());

  }
}