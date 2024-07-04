package bitcamp.project2.util;

import java.util.Scanner;

public class Prompt {
  private static Scanner scanner = new Scanner(System.in);

  public static String inputString(String message) {
    System.out.print(message);
    return scanner.nextLine();
  }

  public static int inputInt(String message) {
    System.out.print(message);
    return Integer.parseInt(scanner.nextLine());
  }

  public static void close() {
    scanner.close();
  }
}
